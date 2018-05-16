
public class Badge {
	/**
	 * id de la personne
	 */
	int idpersonne;
	/** 
	 * id du badge généré par le sql
	 */
	int idbadge;
	/** constructeurs de la classe
	 * 
	 * @param pidpersonne
	 * id de la personne lié au badge
	 * @param pidbadge
	 * id du badge 
	 */  
	public Badge(int pidpersonne, int pidbadge) {
		idpersonne=pidpersonne;
		idbadge=pidbadge;
	}
	/** RÃ©cupÃ©ration de Idbadge
	 * 
	 * @return idbadge
	 */
	public int getIdbadge() {
		return idbadge;
	}
	/** RÃ©cupÃ©ration de Idpersonne
	 * 
	 * @return idpersonne
	 */
	public int getIdpersonne() {
		return idpersonne;
	}
}