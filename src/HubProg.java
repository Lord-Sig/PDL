import java.awt.Component;

import javax.swing.JOptionPane;

public class HubProg {
	private static final Component ErreurecoF = null;
	static ConnectionFen ConnectionFen;
	static Menu Menu;
	static MenuPersonne MenuPersonne;
	static SelectionPersonneS SelectionPersonneS;
	static SelectionPersonneM SelectionPersonneM;
	static SelectionPersonneB SelectionPersonneB;
	static CreationPersonne CreationPersonne;
	static MenuBadge MenuBadge;
	static ModifPersonne ModifPersonne;
	static SupressionBadge SupressionBadge;
	
	public HubProg() {
		ConnectionFen= new ConnectionFen(); 
		ConnectionFen.setVisible(true); 
	}
	/** login de la fonction
	 * 
	 * @param compte
	 * @param code
	 */
	public static void authentification (String compte, String code) {
		boolean verif=Connection.VerrifieCompte(compte,code);
		if ( verif == false) {
			JOptionPane.showMessageDialog(ErreurecoF, "erreur connexion !",
					"Erreur", JOptionPane.ERROR_MESSAGE);
			
		}
		
		if ( verif == true) {
			ConnectionFen.setVisible(false);
			Menu=new Menu();
			ConnectionFen.dispose();
		}
		return;
	}
	public static void gerePersonne() {
		Menu.setVisible(false);
		MenuPersonne= new MenuPersonne();
		Menu.dispose();
		return;
		
	}
	
	public static void gereBadge() {
		Menu.setVisible(false);
		MenuBadge= new MenuBadge();
		Menu.dispose();
		return;
	}

	public static void creePersonne1(){
		MenuPersonne.setVisible(false);
		 CreationPersonne= new CreationPersonne();
		MenuPersonne.dispose();
		return;
	}
	/**
	 * action du bouton validé de crée personne 
	 * il ordone de mettre les donné dans la dao
	 * @param pnom
	 * @param pprenom
	 * @param pfonction
	 * @param jnaissancep
	 * @param mnaissancep
	 * @param anaissancep
	 * @param string
	 */
	public static void creePersonne2(String pnom,String pprenom, String pfonction,String jnaissancep,String mnaissancep,String anaissancep, String Idfonction){
		CreationPersonne.setVisible(false);
		Personnedao.ajouter( pnom, pprenom,  pfonction, jnaissancep, mnaissancep, anaissancep, Idfonction);
		 Menu=new Menu();
		CreationPersonne.dispose();
		JOptionPane.showMessageDialog(ErreurecoF, "Création faite !",
				"Info", JOptionPane.INFORMATION_MESSAGE);
		return;
	}
	
	public static void modifPersonne1() {
		MenuPersonne.setVisible(false);
		 SelectionPersonneM= new SelectionPersonneM();
		MenuPersonne.dispose();
		return;
	}
	public static int modifPersonne2(String pnom,String pprenom,String jnaissancep,String mnaissancep,String anaissancep) {
		SelectionPersonneM.setVisible(false);
		int id =Personnedao.getIdpersonne( pnom, pprenom, jnaissancep, mnaissancep, anaissancep);
		ModifPersonne= new ModifPersonne();
		return id;
	}
	public static void modifPersonne3(String pnom,String pprenom,String fonction,String jnaissancep,String mnaissancep,String anaissancep, String idprofil,int idpersonne) {
		ModifPersonne.setVisible(false);
		 Menu=new Menu();
		Personnedao.modifie(pnom,pprenom,fonction,jnaissancep,mnaissancep,anaissancep,idprofil, idpersonne);
		ModifPersonne.dispose();
		SelectionPersonneM.dispose();
		JOptionPane.showMessageDialog(ErreurecoF, "Modification faite !",
				"Info", JOptionPane.INFORMATION_MESSAGE);
		return;
	}
	////////////
	public static void suprefPersonne1() {
		MenuPersonne.setVisible(false);
		SelectionPersonneS= new SelectionPersonneS();
		MenuPersonne.dispose();
		return;
	}
	public static void suprePersonne2(String pnom,String pprenom,String jnaissancep,String mnaissancep,String anaissancep) {
		SelectionPersonneS.setVisible(false);
		int id =Personnedao.getIdpersonne( pnom, pprenom, anaissancep, mnaissancep, jnaissancep);
		System.out.println(id);
		Personnedao.supprime(id);
		Menu Menu= new Menu();
		JOptionPane.showMessageDialog(ErreurecoF, "Personne Supprimé !",
				"Info", JOptionPane.INFORMATION_MESSAGE);
		SelectionPersonneS.dispose();
		return ;
	}
	//////////
	public static  void creeBadge1() {
		System.out.println("sssss");
		MenuBadge.setVisible(false);
		 SelectionPersonneB= new SelectionPersonneB();
		MenuBadge.dispose();
		return;
	}
	public static void creeBadge2(String pnom,String pprenom,String jnaissancep,String mnaissancep,String anaissancep) {
		SelectionPersonneB.setVisible(false);
		int id =Personnedao.getIdpersonne( pnom, pprenom, jnaissancep, mnaissancep, anaissancep);
		Badgedao.ajouter(id);
		 Menu= new Menu();
		SelectionPersonneB.dispose();
		return;
	}
	////////
	public static void supreBadge1() {
		MenuBadge.setVisible(false);
		SupressionBadge = new SupressionBadge();
		MenuBadge.dispose();
		return;
	}
	public static void supreBadge2(int idbadge) {
		Badgedao.supprime(idbadge);
		 JOptionPane.showMessageDialog(ErreurecoF, "Badge Supprimé !",
					"Info", JOptionPane.INFORMATION_MESSAGE);
		 Menu= new Menu();
		 SupressionBadge.dispose();
		return;
	}
	//teste
	
}
