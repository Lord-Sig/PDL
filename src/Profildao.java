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
	/** cette commande crée dans la BDD la personne
	 * 
	 * @param personne
	 * @return none
	 */
	public void ajouter(String nomprofil,ArrayList<String> acceslieu,String heuredebut,String heurefin) {
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
		//d'abord je passe a la valeurs suivante 
		ps = con.prepareStatement("INSERT INTO PROFIL (idprofil, nomprofil, acceslieu, heuredebut, heurefin) VALUES(PROFIL_SEQ .nextval,?,?,?,?)");
		ps.setString(1, nomprofil);
		ps.setString(2, acceslieu.get(0));
		ps.setString(3, heuredebut);
		ps.setString(4, heurefin);
		// Exécution de la requête
		retour = ps.executeUpdate();
		while ( i<acceslieu.size())
		{
			ps = con.prepareStatement("INSERT INTO PROFIL (idprofil, nomprofil, acceslieu, heuredebut, heurefin) VALUES(PROFIL_SEQ .currval,?,?,?,?)");
			ps.setString(1, nomprofil);
			ps.setString(2, acceslieu.get(i));
			ps.setString(3, heuredebut);
			ps.setString(4, heurefin);
			// Exécution de la requête
			retour = ps.executeUpdate();
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
	/** cette commande supprime dans la BDD la personne
	 * 
	 * @param personne
	 * @return
	 */
	public  int supprime(int idprofil) {
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
		ps = con.prepareStatement("DELETE FROM PERSONNE WHERE idprofil=?");
		ps.setInt(1, idprofil);
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
public  int modifie(String nomprofil,ArrayList<String> acceslieu,String heuredebut,String heurefin, int idprofil ) {
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
		ps.setString(2, acceslieu.get(0));
		ps.setString(3, heuredebut);
		ps.setString(4, heurefin);
		} catch (Exception e) {
		e.printStackTrace();
		} finally {
		// fermeture du preparedStatement et de la connexion
		try {if (ps != null) ps.close(); } catch (Exception ignore) {}
		try {if (con != null) con.close();} catch (Exception ignore) {}
		}
		return retour;
		}
public int getIdprofil(String nomprofil,String heuredebut,String heurefin) {
	int idprofil = 0 ;
	java.sql.Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	// connexion à la base de données
	try {
	con = DriverManager.getConnection(URL, LOGIN, PASS);
	ps = con.prepareStatement("SELECT idprofil FROM PROFIL WHERE nomprofil=? and heuredebut=? and heurefin=?");
	ps.setString(1, nomprofil);
	ps.setString(2, heuredebut);
	ps.setString(3, heurefin);
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

}