
public class Badge {
	/**
	 * id de la personne
	 */
	int idpersonne;
	/** 
	 * id du badge g�n�r� par le sql
	 */
	int idbadge;
	/** constructeurs de la classe
	 * 
	 * @param pidpersonne
	 * id de la personne li� au badge
	 * @param pidbadge
	 * id du badge 
	 */  
	public Badge(int pidpersonne, int pidbadge) {
		idpersonne=pidpersonne;
		idbadge=pidbadge;
	}
	/** Récupération de Idbadge
	 * 
	 * @return idbadge
	 */
	public int getIdbadge() {
		return idbadge;
	}
	/** Récupération de Idpersonne
	 * 
	 * @return idpersonne
	 */
	public int getIdpersonne() {
		return idpersonne;
	}
}