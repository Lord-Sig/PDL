import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;

public class Profildao {
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
	public Profildao() {
	// chargement du pilote de bases de données
	try {
	Class.forName("oracle.jdbc.OracleDriver");
	} catch (ClassNotFoundException e) {
	System.err.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
	} 
	}
	/**
	 * Cette commande cr�e un profil dans la BDD
	 * @param nomprofil
	 * nom de profil
	 * @param acceslieu
	 * liste des lieux 
	 * @param heuredebut
	 * heure de d�but d'entr�
	 * @param heurefin
	 * heure de fin d'entr�
	 */
	public static void ajouter(String nomprofil,ArrayList<String> acceslieu,String heuredebut,String heurefin) {
		Connection con = null;
		PreparedStatement ps = null;
		int retour = 0; 
		int i=0;
		// connexion à la base de données
		try {
		// tentative de connexion
		con = DriverManager.getConnection(URL, LOGIN, PASS);
		// préparation de l'instruction SQL, chaque ? représente une valeur
		// à communiquer dans l'insertion
		// les getters permettent de récupérer les valeurs des attributs
		// souhaités
		//d'abord je passe a la valeurs suivante 
		ps = con.prepareStatement("INSERT INTO PROFIL (idprofil, nomprofil, acceslieu, heuredebut, heurefin) VALUES(PROFIL_SEQ .nextval,?,?,?,?)");
		ps.setString(1, nomprofil);
		ps.setString(2, acceslieu.get(i));
		ps.setString(3, heuredebut);
		ps.setString(4, heurefin);
		// Exécution de la requête
		retour = ps.executeUpdate();
		i=i+1;
		while ( i<acceslieu.size())
		{
			ps = con.prepareStatement("INSERT INTO PROFIL (idprofil, nomprofil, acceslieu, heuredebut, heurefin) VALUES(PROFIL_SEQ .currval,?,?,?,?)");
			ps.setString(1, nomprofil);
			ps.setString(2, acceslieu.get(i));
			ps.setString(3, heuredebut);
			ps.setString(4, heurefin);
			// Exécution de la requête
			retour = ps.executeUpdate();
			i=i+1;
		}
		} catch (Exception e) {
		e.printStackTrace();
		} finally {
		// fermeture du preparedStatement et de la connexion
		try {if (ps != null) ps.close(); } catch (Exception ignore) {}
		try {if (con != null) con.close();} catch (Exception ignore) {}
		}
		return ;
		}
	/**
	 * cette commande supprime dans la BDD le profil
	 * @param idprofil
	 * id du profil voulue
	 * @return id
	 */
	public static int supprime(int idprofil) {
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
		ps = con.prepareStatement("DELETE FROM PROFIL WHERE idprofil=?");
		ps.setInt(1, idprofil);
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
	 * Cette commande suprime d'abord le profil qu'on modifie puis on recr� avec les valeurs voulue 
	 * @param nomprofil
	 * nouveau nom du profil
	 * @param acceslieu
	 * nouvelle liste de lieu
	 * @param heuredebut
	 * nouvelle horaire
	 * @param heurefin
	 * nouvelle horaire
	 * @param idprofil
	 * id du profil a modifier
	 * @return none 
	 */
public static int modifie(String nomprofil,ArrayList<String> acceslieu,String heuredebut,String heurefin, int idprofil ) {
		Connection con = null;
		PreparedStatement ps = null;
		int retour = 0;
		int i=0;
		Profildao.supprime(idprofil);
		// connexion à la base de données
		//je trouve l'idduprofil a modif
		try {
		// tentative de connexion
		con = DriverManager.getConnection(URL, LOGIN, PASS);
		// préparation de l'instruction SQL, chaque ? représente une valeur
		// à communiquer dans l'insertion
		// les getters permettent de récupérer les valeurs des attributs
		// souhaités
		//d'abord je passe a la valeurs suivante 
		ps = con.prepareStatement("INSERT INTO PROFIL (idprofil, nomprofil, acceslieu, heuredebut, heurefin) VALUES(?,?,?,?,?)");
		ps.setInt(1, idprofil);
		ps.setString(2, nomprofil);
		ps.setString(3, acceslieu.get(0));
		ps.setString(4, heuredebut);
		ps.setString(5, heurefin);
		retour = ps.executeUpdate();
		i=i+1;
		while ( i<acceslieu.size())
		{
			ps = con.prepareStatement("INSERT INTO PROFIL (idprofil, nomprofil, acceslieu, heuredebut, heurefin) VALUES(?,?,?,?,?)");
			ps.setInt(1, idprofil);
			ps.setString(2, nomprofil);
			ps.setString(3, acceslieu.get(i));
			ps.setString(4, heuredebut);
			ps.setString(5, heurefin);
			// Exécution de la requête
			retour = ps.executeUpdate();
			i=i+1;
		}
		} catch (Exception e) {
		e.printStackTrace();
		} finally {
		// fermeture du preparedStatement et de la connexion
		try {if (ps != null) ps.close(); } catch (Exception ignore) {}
		try {if (con != null) con.close();} catch (Exception ignore) {}
		}
		return retour;
		}
/**R�cupere l'id d'un profil grace a nomprofil 
 * @param nomprofil
 * nom du profil du qu'elle on veut l'id
 * @return id 
 * id du profil
 */
public static int getIdprofil(String nomprofil) {
	int idprofil = 0 ;
	java.sql.Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	// connexion à la base de données
	try {
	con = DriverManager.getConnection(URL, LOGIN, PASS);
	ps = con.prepareStatement("SELECT idprofil FROM PROFIL WHERE nomprofil=? ");
	ps.setString(1, nomprofil);
	//rs contient un pointeur situé jusute avant la première ligne
	//retournée
	rs= ps.executeQuery();
	if (rs.next())
		idprofil=rs.getInt("idprofil");
		return idprofil;
		
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
/**
 *  retourne le nom du profil
 * @param idprofil
 * id du profil voulue
 * @return NProfil
 *le nom du profil voulue 
 */
public static String getNProfil(int idprofil) {
	String nprofil = null ;
	java.sql.Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	// connexion à la base de données
	try {
	con = DriverManager.getConnection(URL, LOGIN, PASS);
	ps = con.prepareStatement("SELECT nomprofil FROM PROFIL WHERE idprofil=? ");
	ps.setInt(1, idprofil);
	//rs contient un pointeur situé jusute avant la première ligne
	//retournée
	rs= ps.executeQuery();
	if (rs.next())
		nprofil=rs.getString("nprofil");
		return nprofil;
		
	} catch (Exception ee) {
		ee.printStackTrace();
		} finally {
		// fermeture du rs, du preparedStatement et de la connexion
		try { if (rs != null) rs.close();} catch (Exception ignore) {}
		try { if (ps != null) ps.close();} catch (Exception ignore) {}
		try { if (con != null) con.close();} catch (Exception ignore) {}
		}
		return null;
}

/**
 * Cette fonction trouve toutes les personnes lier a un profil
 * @param profil
 * profil pour le quels on veut une liste
 * @return personnetrouve
 *  liste de personne
 */
public static ArrayList<Personne> ListePersonneparProfil(int profil) {
	ArrayList<Personne> personnetrouve =new ArrayList<Personne>();
	java.sql.Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	// connexion à la base de données
	try {
	con = DriverManager.getConnection(URL, LOGIN, PASS);
	ps = con.prepareStatement("SELECT * FROM PERSONNE WHERE IDPROFIL=?");
	ps.setInt(1, profil);
	//on exécute la requête
	//rs contient un pointeur situé jusute avant la première ligne
	//retournée
	rs= ps.executeQuery();
	while (rs.next())
		personnetrouve.add(new Personne (rs.getString("nomp"),rs.getString("prenomp"),rs.getString("fonction"),rs.getInt("idpersonne"),rs.getInt("idprofil")));
		
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
/**
 * Change le profil d'une personne 
 * @param idprofils
 * id du profil a mmetre
 * @param idpersonnep
 * id de la personne a modifi�
 * @return none
 */
public static int modifieprofilpersonne(int idprofils, int idpersonnep ) {
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
	ps = con.prepareStatement("UPDATE PERSONNE SET idprofil=? WHERE idpersonne=?");
	ps.setInt(1,idprofils);
	ps.setInt(2, idpersonnep);
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



}