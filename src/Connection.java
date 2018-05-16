import java.sql.*;

public class Connection {
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
	
	public Connection() {
	// chargement du pilote de bases de données
	try {
	Class.forName("oracle.jdbc.OracleDriver");
	} catch (ClassNotFoundException e) {
	System.err.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
	}
	}
	/** Fonction de vérification lors de la connection 
	 * 
	 * @param compte
	 * nom de compte
	 * @param code
	 * code du compte
	 * @return true si le nom de compte et le code sont juste false sinon
	 */
	public static boolean VerrifieCompte(String compte, String code) {
		String alpha=null; 
		String beta=null;
		java.sql.Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// connexion à la base de données
		try {
		con = DriverManager.getConnection(URL, LOGIN, PASS);
		ps = con.prepareStatement("SELECT * FROM COMPTE WHERE NOMDECOMPTE=? and CODE=?");
		ps.setString(1, compte);
		ps.setString(2, code);
		//on exécute la requête
		//rs contient un pointeur situé jusute avant la première ligne
		//retournée
		rs= ps.executeQuery();
		if (rs.next())
		alpha=rs.getString("nomdecompte");
		beta=rs.getString("code");
		if (beta==null | alpha==null ) {
			return false;
		}
		return true;		
				} catch (Exception ee) {
				ee.printStackTrace();
				} finally {
				// fermeture du ResultSet, du PreparedStatement et de la Connexion
				try { if (rs != null) rs.close();} catch (Exception ignore) {}
				try { if (ps != null) ps.close();} catch (Exception ignore) {}
				try { if (con != null) con.close();} catch (Exception ignore) {}
				}
				return false;
				}
	
	
}