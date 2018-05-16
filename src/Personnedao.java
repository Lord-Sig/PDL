import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;

// penser a elever profil de personne dans cr�� et modif
public class Personnedao {
	/**
	 * url de connection a la BDD
	 */
	final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	/**
	 * Login pour la BDD
	 */
	final static String LOGIN = "BDD6"; 
	/**
	 * Code de connection a la BDD
	 */
	final static String PASS = "BDD6";
	/**
	* Constructeur de la classe
	*
	*/  
	public Personnedao() {
	// chargement du pilote de bases de données
	try {
	Class.forName("oracle.jdbc.OracleDriver");
	} catch (ClassNotFoundException e) {
	System.err.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
	} 
	}
	/**
	 * cette commande crée dans la BDD la personne
	 * @param nomp
	 * nom de la personne 
	 * @param prenomp
	 * prenom de la personne
	 * @param fonction
	 * fonction de la personne
	 * @param joursp
	 * jours de naissance de la personne
	 * @param moisp
	 * mois de naissance de la personne
	 * @param annep
	 * ann�e de naissance de la personne
	 */
	public static void ajouter(String nomp,String prenomp,String fonction,String joursp,String moisp,String annep) {
		Connection con = null;
		PreparedStatement ps = null;
		int retour = 0;  
		// connexion à la base de données
		try {
		// tentative de connexion 
		con = DriverManager.getConnection(URL, LOGIN, PASS);
		// préparation de l'instruction SQL, chaque ? représente une valeur
		// à communiquer dans l'insertion
		// les getters permettent de récupérer les valeurs des attributs
		// souhaités
		String date = joursp +"/"+moisp+"/"+annep;
		ps = con.prepareStatement("INSERT INTO PERSONNE (nomp, prenomp, fonction, naissance, idpersonne) VALUES(?,?,?,TO_DATE(?, 'DD/MM/YY'),PERSONNE_SEQ.nextval)");
		ps.setString(1, nomp);
		ps.setString(2, prenomp);
		ps.setString(3, fonction);
		ps.setString(4, date);
		// Exécution de la requête
		retour = ps.executeUpdate();
		} catch (Exception e) {
		e.printStackTrace();
		} finally {
		// fermeture du preparedStatement et de la connexion
		try {if (ps != null) ps.close(); } catch (Exception ignore) {}
		try {if (con != null) con.close();} catch (Exception ignore) {}
		}
		return ;
		}
	/** cette commande supprime dans la BDD la personne
	 * 
	 * @param idpersonnep
	 * id de la personne a supprim�
	 * @return none 
	 */
	public static int supprime(int idpersonnep) {
		Connection con = null;
		PreparedStatement ps = null;
		int retour = 0;
		// connexion à la base de données
		try {
		// tentative de connexion
		con = DriverManager.getConnection(URL, LOGIN, PASS);
		// préparation de l'instruction SQL, chaque ? représente une valeur
		// à communiquer dans l'insertion
		// les getters permettent de récupérer les valeurs des attributs
		// souhaités
		System.out.println("ok");
		ps = con.prepareStatement("DELETE FROM PERSONNE WHERE idpersonne=?");
		ps.setInt(1, idpersonnep);
		// Exécution de la requête
		retour = ps.executeUpdate();
		System.out.println("ok");
		} catch (Exception e) {
		e.printStackTrace();
		} finally {
		// fermeture du preparedStatement et de la connexion
		try {if (ps != null) ps.close(); } catch (Exception ignore) {}
		try {if (con != null) con.close();} catch (Exception ignore) {}
		}
		return retour;
		}
	/**
	 * cette commande modifié  dans la BDD la personne
	 * @param nomp
	 * nouveau nom
	 * @param prenomp
	 * nouveau prenomp
	 * @param fonction
	 * nouvelle fonction
	 * @param joursp
	 * nouveau jours de naissance
	 * @param moisp
	 * nouveau mois de naissance
	 * @param annep
	 * nouvelle ann�e de naissance
	 * @param idpersonnep 
	 * id de la personne a modifi�
	 * @return none
	 */
public static int modifie(String nomp,String prenomp,String fonction,String joursp,String moisp,String annep, int idpersonnep ) {
		Connection con = null;
		PreparedStatement ps = null;
		int retour = 0;
		// connexion à la base de données
		try {
		// tentative de connexion
		con = DriverManager.getConnection(URL, LOGIN, PASS);
		// préparation de l'instruction SQL, chaque ? représente une valeur
		// à communiquer dans l'insertion
		// les getters permettent de récupérer les valeurs des attributs

		String date = joursp +"/"+moisp+"/"+annep;
		// souhaités
		ps = con.prepareStatement("UPDATE PERSONNE SET nomp=?, prenomp=?, fonction=?,naissance=TO_DATE(?, 'DD/MM/YY') WHERE idpersonne=?");
		ps.setString(1,nomp);
		ps.setString(2, prenomp);
		ps.setString(3, fonction);
		ps.setString(4, date);;
		ps.setInt(5, idpersonnep);
		// Exécution de la requête
		retour = ps.executeUpdate();
		} catch (Exception e) {
		e.printStackTrace();
		} finally {
		// fermeture du preparedStatement et de la connexion
		try {if (ps != null) ps.close(); } catch (Exception ignore) {}
		try {if (con != null) con.close();} catch (Exception ignore) {}
		}
		return retour;
		}
/**
 * Cette commande Retourne les personne corespondant a une entr�
 * @param nomp
 * nom de la personne a selectionner
 * @param prenomp
 * prenom de la personne a selectionner
 * @return personnetrouve
 *  liste de personne
 */
public static ArrayList<Personne> Trouvepersonne(String nomp,String prenomp) {
	ArrayList<Personne> personnetrouve =new ArrayList<Personne>();
	java.sql.Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	// connexion à la base de données
	try {
	con = DriverManager.getConnection(URL, LOGIN, PASS);
	ps = con.prepareStatement("SELECT * FROM PERSONNE WHERE nomp=? and prenomp=? ");
	ps.setString(1, nomp);
	ps.setString(2, prenomp);
	//on exécute la requête
	//rs contient un pointeur situé jusute avant la première ligne
	//retournée
	rs= ps.executeQuery();
	while (rs.next())
		personnetrouve.add(new Personne(rs.getString("nomp"),rs.getString("prenomp"),rs.getString("fonction"),rs.getString("naissance"),rs.getInt("idpersonne"),rs.getInt("idprofil")));
		
	} catch (Exception ee) {
		ee.printStackTrace();
		} finally {
		// fermeture du rs, du preparedStatement et de la connexion
		try { if (rs != null) rs.close();} catch (Exception ignore) {}
		try { if (ps != null) ps.close();} catch (Exception ignore) {}
		try { if (con != null) con.close();} catch (Exception ignore) {}
		}
		return personnetrouve;
	
}
/**trouve l'id d'une personne dans la dao
 * 
 * @param nomp
 * nom de la personne  dons on veut l'id
 * @param prenomp
 * prenom de la personne  dons on veut l'id
 * @param annep
 * ann�ede naissance de la personne  dons on veut l'id
 * @param moisp
 * mois de naissance  de la personne  dons on veut l'id
 * @param joursp
 * jours de naissance  de la personne  dons on veut l'id
 * @return none
 */
public static int getIdpersonne(String nomp,String prenomp,String joursp,String moisp,String annep) {
	int idpersonner = 0 ;
	java.sql.Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String date = joursp +"/"+moisp+"/"+annep;
	// connexion à la base de données
	try {
	con = DriverManager.getConnection(URL, LOGIN, PASS);
	ps = con.prepareStatement("SELECT idpersonne FROM PERSONNE WHERE nomp=? and prenomp=? and naissance=TO_DATE(?, 'DD/MM/YY') ");
	ps.setString(1, nomp);
	ps.setString(2, prenomp);
	ps.setString(3, date);
	//on exécute la requête
	//rs contient un pointeur situé jusute avant la première ligne
	//retournée
	rs= ps.executeQuery();
	if (rs.next())
		idpersonner=rs.getInt("idpersonne");
		return idpersonner;
		
	} catch (Exception ee) {
		ee.printStackTrace();
		} finally {
		// fermeture du rs, du preparedStatement et de la connexion
		try { if (rs != null) rs.close();} catch (Exception ignore) {}
		try { if (ps != null) ps.close();} catch (Exception ignore) {}
		try { if (con != null) con.close();} catch (Exception ignore) {}
		}
		return 0;
}
}


