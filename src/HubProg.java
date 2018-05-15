import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class HubProg {
	private static final Component ErreurecoF = null;
	/**
	 * initialiser une fenêtre
	 */
	static ConnectionFen ConnectionFen;
	/**
	 * initialiser une fenêtre
	 */
	static selectionPersonneL selectionPersonneL;
	static Menu Menu;
	static menuLieu menuLieu;
	/**
	 * initialiser une fenêtre
	 */
	static selectionPersonneL2 selectionPersonneL2;
	/**
	 * initialiser une fenêtre
	 */
	static MenuPersonne MenuPersonne;
	/**
	 * initialiser une fenêtre
	 */
	static SelectionPersonneS SelectionPersonneS;
	/**
	 * initialiser une fenêtre
	 */
	static SelectionPersonneM SelectionPersonneM;
	/**
	 * initialiser une fenêtre
	 */
	static SelectionPersonneB SelectionPersonneB;
	/**
	 * initialiser une fenêtre
	 */
	static CreationPersonne CreationPersonne;
	/**
	 * initialiser une fenêtre
	 */
	static MenuBadge MenuBadge;
	/**
	 * initialiser une fenêtre
	 */
	static ModifPersonne ModifPersonne;
	/**
	 * initialiser une fenêtre
	 */
	static SupressionBadge SupressionBadge;
	/**
	 * initialiser une fenêtre
	 */
	static MenuProfil MenuProfil;
	/**
	 * initialiser une fenêtre
	 */
	static selectionPersonneP selectionPersonneP;
	/**
	 * initialiser une fenêtre
	 */
	static CréeProfil CréeProfil;
	/**
	 * initialiser une fenêtre
	 */
	static selectionProfil selectionProfil;
	/**
	 * initialiser une fenêtre
	 */
	static selectionProfilS selectionProfilS;
	/**
	 * initialiser une fenêtre
	 */
	static selectionProfilP selectionProfilP;
	/**
	 * initialiser une fenêtre
	 */
	static ModifProfil ModifProfil;
	/**
	 * initialiser une fenêtre
	 */
	static selectionProfilL selectionProfilL;
	/**
	 * initialiser une fenêtre
	 */
	static selectionProfilL2 selectionProfilL2;
	//static selectionProfilL3 selectionProfilL3;
	
	/**
	 * Classe constructeur
	 */
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
	/**
	 * Cette fonction envois dans le menu gerer personne
	 */
	public static void gerePersonne() {
		Menu.setVisible(false);
		MenuPersonne= new MenuPersonne();
		Menu.dispose();
		return;
		
	}
	/**
	 * Cette fonction envois dans le menu gerer badge
	 */
	public static void gereBadge() {
		Menu.setVisible(false);
		MenuBadge= new MenuBadge();
		Menu.dispose();
		return;
	}
	/**
	 * Ouvre la fenêtre crée personne
	 */
	public static void creePersonne1(){
		MenuPersonne.setVisible(false);
		 CreationPersonne= new CreationPersonne();
		MenuPersonne.dispose();
		return;
	}
	/**
	 * action du bouton validé de crée personne et retourne sur la fenêtre menu
	 * il ordone de mettre les donné dans la dao
	 * @param pnom
	 * @param pprenom
	 * @param pfonction
	 * @param jnaissancep
	 * @param mnaissancep
	 * @param anaissancep
	 * @param string
	 */
	public static void creePersonne2(String pnom,String pprenom, String pfonction,String jnaissancep,String mnaissancep,String anaissancep){
		CreationPersonne.setVisible(false);
		System.out.println(anaissancep);
		System.out.println(mnaissancep);
		System.out.println(jnaissancep);
		Personnedao.ajouter( pnom, pprenom,  pfonction, jnaissancep, mnaissancep, anaissancep);
		 Menu=new Menu();
		CreationPersonne.dispose();
		JOptionPane.showMessageDialog(ErreurecoF, "Création faite !",
				"Info", JOptionPane.INFORMATION_MESSAGE);
		return;
	}
	
	/**
	 * ouvre la fenêtre selection personne
	 */
	public static void modifPersonne1() {  
		MenuPersonne.setVisible(false);
		 SelectionPersonneM= new SelectionPersonneM();
		MenuPersonne.dispose();
		return;
	}
	/**
	 * selectionne la personne a modif 
	 * ouvre la fenêtre pour rentrer les infos de la personne apres modification 
	 * @param pnom
	 * @param pprenom
	 * @param jnaissancep
	 * @param mnaissancep
	 * @param anaissancep
	 * @return
	 */
	public static int modifPersonne2(String pnom,String pprenom,String jnaissancep,String mnaissancep,String anaissancep) {
		SelectionPersonneM.setVisible(false);
		int id =Personnedao.getIdpersonne( pnom, pprenom, jnaissancep, mnaissancep, anaissancep);
		ModifPersonne= new ModifPersonne();

		 System.out.println(id);
		return id;
	}
	/**
	 * modifie la personne 
	 * retourne sur la fenêtre menu
	 * @param pnom
	 * @param pprenom
	 * @param fonction
	 * @param jnaissancep
	 * @param mnaissancep
	 * @param anaissancep
	 * @param idpersonne
	 */
	public static void modifPersonne3(String pnom,String pprenom,String fonction,String jnaissancep,String mnaissancep,String anaissancep,int idpersonne) {
		ModifPersonne.setVisible(false);
		 Menu=new Menu();
		 System.out.println(idpersonne);
		Personnedao.modifie(pnom,pprenom,fonction,jnaissancep,mnaissancep,anaissancep, idpersonne);
		ModifPersonne.dispose();
		SelectionPersonneM.dispose();
		JOptionPane.showMessageDialog(ErreurecoF, "Modification faite !",
				"Info", JOptionPane.INFORMATION_MESSAGE);
		return;
	}
	/**
	 * ouvre la fenêtre selection personne
	 */
	public static void suprefPersonne1() {
		MenuPersonne.setVisible(false);
		SelectionPersonneS= new SelectionPersonneS();
		MenuPersonne.dispose();
		return;
	}
	/**
	 * Suprime la personne et retourne a la fenêtre menu
	 * @param pnom
	 * @param pprenom
	 * @param jnaissancep
	 * @param mnaissancep
	 * @param anaissancep
	 */
	public static void suprePersonne2(String pnom,String pprenom,String jnaissancep,String mnaissancep,String anaissancep) {
		SelectionPersonneS.setVisible(false);
		int id =Personnedao.getIdpersonne( pnom, pprenom, jnaissancep, mnaissancep, anaissancep);
		System.out.println(id);
		Personnedao.supprime(id);
		Menu Menu= new Menu();
		JOptionPane.showMessageDialog(ErreurecoF, "Personne Supprimé !",
				"Info", JOptionPane.INFORMATION_MESSAGE);
		SelectionPersonneS.dispose();
		return ;
	}
	/**
	 * ouvre la fenêtre crée badge 
	 */
	public static  void creeBadge1() {
		MenuBadge.setVisible(false);
		 SelectionPersonneB= new SelectionPersonneB();
		MenuBadge.dispose();
		return;
	}
	/**
	 * crée le badge
	 * ouvre la fenêtre menu
	 * @param pnom
	 * @param pprenom
	 * @param jnaissancep
	 * @param mnaissancep
	 * @param anaissancep
	 */
	public static void creeBadge2() {
		SelectionPersonneB.setVisible(false);
		Badgedao.ajouter(SelectionPersonneB.getID());
		 Menu= new Menu();
		SelectionPersonneB.dispose();
		return;
	}
	/**
	 * ouvre la fenêtre selection badge
	 */
	public static void supreBadge1() {
		MenuBadge.setVisible(false);
		SupressionBadge = new SupressionBadge();
		MenuBadge.dispose();
		return;
	}
	/**
	 * supprime le badge 
	 * ouvre la fenêtre menu
	 * @param idbadge
	 */
	public static void supreBadge2(int idbadge) {
		Badgedao.supprime(idbadge);
		 JOptionPane.showMessageDialog(ErreurecoF, "Badge Supprimé !",
					"Info", JOptionPane.INFORMATION_MESSAGE);
		 Menu= new Menu();
		 SupressionBadge.dispose();
		return;
	}
	/**
	 * ouvre la fenêtre gerer profil 
	 */
	public static void gererProfil() {
		Menu.setVisible(false);
		MenuProfil =new MenuProfil(); 
		Menu.dispose();
		return;
	}
	/**
	 * Ouvre la fenêtre crée un badge
	 */
	public static void CréeProfil() {
		MenuProfil.setVisible(false);
		CréeProfil = new CréeProfil();
		return;
	}
	/**
	 * crée un profil 
	 * ouvre la fenêtre menu
	 * @param nomp
	 * @param lieu
	 * @param heuredebut
	 * @param heurefin
	 */
	public static void CréeProfil2(String nomp, String lieu ,String heuredebut,String heurefin) {
		//CréeProfil.setVisible(false);
		String  mots[] = lieu.split("/");
		ArrayList<String> Lieu= new ArrayList<String>();
		for (int i = 0; i < mots.length; i++) {
			Lieu.add(mots[i]);
			System.out.println(mots[i]);
        }
		System.out.println(nomp);
		System.out.println(heuredebut);
		System.out.println(heurefin);
		Menu = new Menu();
		Profildao.ajouter(nomp, Lieu, heuredebut, heurefin);
		CréeProfil.dispose();
	}
	/**
	 * ouvre la fenêtre lection profil
	 */
	public static void ModifProfil() {
		MenuProfil.setVisible(false);
		selectionProfil = new selectionProfil();
		return;
	}
	/**
	 * selectionne le profil
	 * ouvre la fenêtre modif profil
	 * @param nomp
	 * @return
	 */
	public static int ModifProfil2(String nomp) {
		selectionProfil.setVisible(false);
		ModifProfil= new ModifProfil();
		int id =Profildao.getIdprofil(nomp);
		return id;
	}
	/**
	 * modifie la personne 
	 * ovre la fenêtre menu
	 * @param nomp
	 * @param lieu
	 * @param heuredebut
	 * @param heurefin
	 * @param idprofil
	 */
	public static void ModifProfil3(String nomp, String lieu ,String heuredebut,String heurefin,int  idprofil) {
		ModifProfil.setVisible(false);
		String  mots[] = lieu.split("/");
		ArrayList<String> Lieu= new ArrayList<String>();
		for (int i = 0; i < mots.length; i++) {
			Lieu.add(mots[i]);
			System.out.println(mots[i]);
        }
		System.out.println(idprofil);
		Menu = new Menu();
		Profildao.modifie(nomp, Lieu, heuredebut, heurefin, idprofil);
		ModifProfil.dispose();
		selectionProfil.dispose();
		return;
	}
	/**
	 * ouvre la fenêtre selection profil
	 */
	public static void SupreProfil() {
		MenuProfil.setVisible(false);
		selectionProfilS = new selectionProfilS();
		return;
	}
	/**
	 * suprime le profil
	 * ouvre la fenêtre menu
	 * @param nomp
	 */
	public static void SupreProfil2() {
		System.out.println("z");
		selectionProfil.setVisible(false);
		Menu m=new Menu();
		Profildao.supprime(selectionProfil.getID());
		selectionProfil.dispose();
		selectionProfilS.dispose();
		return;
	}
	/**
	 * ouvre la fenêtre selection personne
	 */
	public static void setProfil() {
		MenuProfil.setVisible(false);
		selectionPersonneP= new selectionPersonneP();
		MenuProfil.dispose();
		return ;
	}
	/**
	 * selectionne la personne 
	 * ouvre la fenêtre selection profil
	 * @param nomp
	 * @param prenom
	 * @param anne
	 * @param mois
	 * @param jour
	 * @return
	 */
	public static int setProfil2(String nomp, String prenom, String anne, String mois, String jour) {
		selectionPersonneP.setVisible(false);
		int id =Personnedao.getIdpersonne(nomp, prenom, anne, mois, jour);
		selectionProfilP = new selectionProfilP();
		return id;
		
	}
	/**
	 * ouvre la fenêtre menu
	 * uptade le profil
	 * @param profil
	 * @param idpersonne
	 */
	public static void setProfil3(String  profil, int idpersonne) {
		selectionProfilP.setVisible(false);
		int idprofils= Profildao.getIdprofil(profil);
		Profildao.modifieprofilpersonne(idprofils, idpersonne);
		Menu= new Menu();
		selectionProfilP.dispose();
		return;
	}
	/**
	 * ouvre la fenêtre selection profil
	 */
	public static void ListeProfil() {
		MenuProfil.setVisible(false);
		selectionProfilL= new selectionProfilL();
		MenuProfil.dispose();
		return ;
	}
	/**
	 * ouvre la fenêtre affichage des personne
	 * @param nomprof
	 * @return
	 */
	public static int ListeProfil2(String nomprof) {
		selectionProfilL.setVisible(false);
		int id = Profildao.getIdprofil(nomprof);
		selectionProfilL2= new selectionProfilL2(id);
		return id;
	}
	/**
	 * ouvre la fenêtre menu
	 */
	public static void 	ListeProfil3() {
		selectionProfilL2.setVisible(false);
		Menu = new Menu();
		selectionProfilL2.dispose();
		selectionProfilL.dispose();
		return ;
	}
	public static void ListePersonne() {
		MenuPersonne.setVisible(false);
		selectionPersonneL= new selectionPersonneL();
		MenuPersonne.dispose();
		return ;
	}
	/**
	 * ouvre la fenêtre affichage des personne
	 * @param nomprof
	 * @param string4 
	 * @param string3 
	 * @param string2 
	 * @param string 
	 * @return
	 */
	public static void  ListePersonne2(String nomp, String prenomp) {
		selectionPersonneL.setVisible(false);
		ArrayList<Personne> listpers = new ArrayList<Personne>();
		listpers= Personnedao.Trouvepersonne(nomp, prenomp);
		selectionPersonneL2= new selectionPersonneL2(listpers);
		return ;
	}
	/**
	 * ouvre la fenêtre menu
	 */
	public static void 	ListePersonne3() {
		selectionPersonneL2.setVisible(false);
		Menu = new Menu();
		selectionPersonneL2.dispose();
		selectionPersonneL.dispose();
		return ;
	}
	public static void MenuLieu() {
		Menu.setVisible(false);
		menuLieu = new menuLieu();
		Menu.dispose();
	}

	
}

