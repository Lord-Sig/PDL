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
		for(int i=0;i<acceslieu.size();i=i+1)
		{
			ps = con.prepareStatement("INSERT INTO PROFIL (idprofil, nomprofil, acceslieu, heuredebut, heurefin) VALUES(PROFIL_SEQ .nextval,?,?,?,?)");
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
	public  int supprime(int idpersonnep) {
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

}