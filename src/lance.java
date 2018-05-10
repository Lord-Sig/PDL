import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class lance {

	public static void main(String[] args) throws SQLException {
		Profildao profil =new Profildao();
		ArrayList<String> pl = new ArrayList<String>();
		
		pl.add("p");
		pl.add("o");
		pl.add("m");
		pl.add("r");
		pl.add("g");
		
		System.out.println(pl);
		//profil.ajouter("nomp", pl, "11", "11");
		//profil.supprime(13);
		//profil.ajouter("nomp", pl, "12", "13");
		profil.modifie("bite", pl, "10", "9",15);
		/////commande marche 
		
		/*
		final String LOGIN = "BDD6"; 
		
		Connection con = null;
		PreparedStatement ps = null;
		final  String PASS = "BDD6";
		
		try {
			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// préparation de l'instruction SQL, chaque ? représente une valeur
			// à communiquer dans l'insertion
			// les getters permettent de récupérer les valeurs des attributs
			// souhaités
			//d'abord je passe a la valeurs suivante 
			ps = con.prepareStatement("INSERT INTO PROFIL (idprofil, nomprofil, acceslieu, heuredebut, heurefin) VALUES(1,'a','a',TO_DATE('1', 'HH24'),TO_DATE('11'  , 'HH24'))");
			ps.execute();
			} catch (Exception e) {
			e.printStackTrace();
			} finally {
			// fermeture du preparedStatement et de la connexion
			try {if (ps != null) ps.close(); } catch (Exception ignore) {}
			try {if (con != null) con.close();} catch (Exception ignore) {}
			}
		*/
		

	}
}
