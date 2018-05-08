import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;

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
	/** cette commande crée dans la BDD la personne
	 * 
	 * @param personne
	 * @return none
	 */
	public void ajouter(String nomp,String prenomp,String fonction,String joursp,String moisp,String annep,String idprofil) {
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
		ps = con.prepareStatement("INSERT INTO PERSONNE (nomp, prenomp, fonction, joursp, moisp, annep, idpersonne, idprofil) VALUES(?,?,?,?,?,?,PERSONNE_SEQ.nextval,?)");
		ps.setString(1, nomp);
		ps.setString(2, prenomp);
		ps.setString(3, fonction);
		ps.setString(4, annep);
		ps.setString(5, moisp);
		ps.setString(6, joursp);
		ps.setString(7, idprofil);
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
	 * @param personne
	 * @return
	 */
	public int supprime(int idpersonnep) {
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
	/** cette commande modifié  dans la BDD la personne
	 * personne 2 est celle qu'on modifie la 1 les nouvelle valeurs 
	 * @param personne1(personne que l'on veut 
	 * @param idpersonnep  id de la personne a modifié 
	 * @return
	 */
public  int modifie(String nomp,String prenomp,String fonction,String joursp,String moisp,String annep,String idprofil, int idpersonnep ) {
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
		ps = con.prepareStatement("UPDATE PERSONNE SET nomp=?, prenomp=?, fonction=?,annep=?,moisp=?,joursp=?,idprofil=? WHERE idpersonne=?");
		ps.setString(1,nomp);
		ps.setString(2, prenomp);
		ps.setString(3, fonction);
		ps.setString(4, annep);
		ps.setString(5, moisp);
		ps.setString(6, joursp);
		ps.setString(7,idprofil);
		ps.setInt(8, idpersonnep);
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
 * 
 * @param nomp
 * @param prenomp
 * @param fonction
 * @param annep
 * @param moisp
 * @param joursp
 * @return
 */
public ArrayList<Personne> Trouvepersonne(String nomp,String prenomp,String fonction,String annep,String moisp,String joursp) {
	ArrayList<Personne> personnetrouve =new ArrayList<Personne>();
	java.sql.Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	// connexion à la base de données
	try {
	con = DriverManager.getConnection(URL, LOGIN, PASS);
	ps = con.prepareStatement("SELECT * FROM PERSONNE WHERE nomp=? and prenomp=? and fonction=? and annep=? and moisp=? and joursp=?");
	ps.setString(1, nomp);
	ps.setString(2, prenomp);
	ps.setString(3, fonction);
	ps.setString(4, annep);
	ps.setString(5, moisp);
	ps.setString(6, joursp);
	//on exécute la requête
	//rs contient un pointeur situé jusute avant la première ligne
	//retournée
	rs= ps.executeQuery();
	while (rs.next())
		personnetrouve.add(new Personne (rs.getString("nomp"),rs.getString("prenomp"),rs.getString("fonction"),rs.getInt("annep"),rs.getInt("moisp"),rs.getInt("joursp"),rs.getInt("idpersonne"),rs.getInt("idprofil")));
		
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
/**trouve l'id d'une personne
 * 
 * @param nomp
 * @param prenomp
 * @param annep
 * @param moisp
 * @param joursp
 * @return
 */
public int getIdpersonne(String nomp,String prenomp,String annep,String moisp,String joursp) {
	int idpersonner = 0 ;
	java.sql.Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	// connexion à la base de données
	try {
	con = DriverManager.getConnection(URL, LOGIN, PASS);
	ps = con.prepareStatement("SELECT idpersonne FROM PERSONNE WHERE nomp=? and prenomp=? and annep=? and moisp=? and joursp=?");
	ps.setString(1, nomp);
	ps.setString(2, prenomp);
	ps.setString(3, annep);
	ps.setString(4, moisp);
	ps.setString(5, joursp);
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


