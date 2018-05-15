
public class Personne {
	/**
	 * nom de la personne 
	 */
String nom;
/**
 * prenom de la personne
 */
String prenom;
/**
 * fonction de la personne
 */
String fonction;
/**
 * jours de naissance
 */
String naissance;

/** id de lpersonne g�n�r� dans le sql
 * 
 */
int idpersonne;
/** id du profil
 * 
 */
int idprofil;
/** classe constructeur
 *  
 * @param pnom
 * @param pprenom
 * @param pfonction
 * @param jnaissancep
 * @param mnaissancep
 * @param anaissancep
 * @param pidpersonne
 * @param pidprofil
 */
public Personne(String pnom,String pprenom, String pfonction,String naissancep,int pidpersonne, int pidprofil) {
	nom=pnom;
	prenom=pprenom;
	naissance=naissancep;
	fonction=pfonction; 
	idpersonne=pidpersonne;
	idprofil=pidprofil;
}
public Personne(String pnom,String pprenom, String pfonction,int pidpersonne, int pidprofil) {
	nom=pnom;
	prenom=pprenom;
	fonction=pfonction; 
	idpersonne=pidpersonne;
	idprofil=pidprofil;
}

/** Récupération de Idprofil
 * 
 * @return
 */
public int getIdprofil() {
	return idprofil;
}
/** Récupération de Idpersonne
 * 
 * @return idpersonne
 */
public int getIdpersonne() {
	return idpersonne;
}
/** Récupération de fonction
 * 
 * @return fonction
 */
public String getfonction() {
	return fonction;
}
/** Récupération de prenom
 * 
 * @return prenom
 */
public String getprenom() {
	return prenom;
}
/** Récupération de nom
 * 
 * @return nom
 */
public String getnom() {
	return nom;
}
/**Récupération de jnaissance 
 * 
 * @return jnaissance
 */
public String getNaissance() {
	return naissance;
}

}
