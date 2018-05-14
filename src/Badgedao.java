import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Badgedao {
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
	public Badgedao() { 
	// chargement du pilote de bases de données
	try {
	Class.forName("oracle.jdbc.OracleDriver");
	} catch (ClassNotFoundException e) {
	System.err.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
	} 
	}
	/**crée un badge dans la BDD
	 * 
	 * @param badge
	 * @return none
	 */
	public static int ajouter(int idpersonne) {
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
		//teste
		ps = con.prepareStatement("INSERT INTO BADGE (idbadge,idpersonne) VALUES (BADGE_SEQ.nextval, ?)");
		ps.setInt(1, idpersonne);
		
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
	/** supprime le badge dans la BDD
	 * 
	 * @param badge
	 * @return none
	 */
	public static int supprime(int idbadge) {
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
		ps = con.prepareStatement("DELETE FROM BADGE WHERE idbadge=?");
		ps.setInt(1, idbadge);
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
	 * Cette fonction dit si un badge existe 
	 * @param idpersonne
	 * @return boolean 
	 */
	public boolean ExisteBadge (int idpersonne) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// connexion à la base de données
		try {
		// tentative de connexion
		con = DriverManager.getConnection(URL, LOGIN, PASS);
		// préparation de l'instruction SQL, chaque ? représente une valeur
		// à communiquer dans l'insertion
		// les getters permettent de récupérer les valeurs des attributs
		// souhaités
		ps = con.prepareStatement("SELECT idbadge FROM idpersonne=?");
		ps.setInt(1, idpersonne);
		rs= ps.executeQuery();
		int idpersonner= 0;
		if (rs.next())
			idpersonner=rs.getInt("idpersonne");
		if (idpersonne!= 0 ) {
			return true;
		}
		} catch (Exception e) {
		e.printStackTrace();
		} finally { 
		// fermeture du preparedStatement et de la connexion
		try {if (ps != null) ps.close(); } catch (Exception ignore) {}
		try {if (con != null) con.close();} catch (Exception ignore) {}
		}
		return false;
		}
		
		
		
	}
	

