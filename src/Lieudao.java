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
	
	public LieuDAO() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			} catch (ClassNotFoundException e) {
			System.err.println("Impossible de charger le pilote de BDD, il est indispensable d'importer un .jar dans le projet");
			} 
	}
	
	public void ajouter(int idp, String emplacementp, String horairesp, int nombreAccesp) {
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
		ps = con.prepareStatement("INSERT INTO PERSONNE (id, emplacement, horaires, nombreAcces) VALUES(?,?,?,?,?,?,LIEU_SEQ.nextval,?)");
		ps.setInt(1, idp);
		ps.setString(2, emplacementp);
		ps.setString(3, horairesp);
		ps.setInt(4, nombreAccesp);

		// Ex�cution de la requ�te
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
	
	
	public int supprimerLieu(int idp) {
		Connection con = null;
		PreparedStatement ps = null;
		int retour = 0;
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("DELETE FROM LIEU EMPLACEMENT = ? ");
			ps.setInt(1, idp);

		// Ex�cution de la requ�te
			retour = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {if (ps != null) ps.close(); } catch (Exception ignore) {}
			try {if (con != null) con.close();} catch (Exception ignore) {}
			}
			return retour;

	
	}
	
	
		
	}
