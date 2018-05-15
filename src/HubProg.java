import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class HubProg {
	private static final Component ErreurecoF = null;
	/**
	 * initialiser une fen�tre
	 */
	static ConnectionFen ConnectionFen;
	/**
	 * initialiser une fen�tre
	 */
	static selectionPersonneL selectionPersonneL;
	static Menu Menu;
	static menuLieu menuLieu;
	/**
	 * initialiser une fen�tre
	 */
	static selectionPersonneL2 selectionPersonneL2;
	/**
	 * initialiser une fen�tre
	 */
	static MenuPersonne MenuPersonne;
	/**
	 * initialiser une fen�tre
	 */
	static SelectionPersonneS SelectionPersonneS;
	/**
	 * initialiser une fen�tre
	 */
	static SelectionPersonneM SelectionPersonneM;
	/**
	 * initialiser une fen�tre
	 */
	static SelectionPersonneB SelectionPersonneB;
	/**
	 * initialiser une fen�tre
	 */
	static CreationPersonne CreationPersonne;
	/**
	 * initialiser une fen�tre
	 */
	static MenuBadge MenuBadge;
	/**
	 * initialiser une fen�tre
	 */
	static ModifPersonne ModifPersonne;
	/**
	 * initialiser une fen�tre
	 */
	static SupressionBadge SupressionBadge;
	/**
	 * initialiser une fen�tre
	 */
	static MenuProfil MenuProfil;
	/**
	 * initialiser une fen�tre
	 */
	static selectionPersonneP selectionPersonneP;
	/**
	 * initialiser une fen�tre
	 */
	static Cr�eProfil Cr�eProfil;
	/**
	 * initialiser une fen�tre
	 */
	static selectionProfil selectionProfil;
	/**
	 * initialiser une fen�tre
	 */
	static selectionProfilS selectionProfilS;
	/**
	 * initialiser une fen�tre
	 */
	static selectionProfilP selectionProfilP;
	/**
	 * initialiser une fen�tre
	 */
	static ModifProfil ModifProfil;
	/**
	 * initialiser une fen�tre
	 */
	static selectionProfilL selectionProfilL;
	/**
	 * initialiser une fen�tre
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
	 * Ouvre la fen�tre cr�e personne
	 */
	public static void creePersonne1(){
		MenuPersonne.setVisible(false);
		 CreationPersonne= new CreationPersonne();
		MenuPersonne.dispose();
		return;
	}
	/**
	 * action du bouton valid� de cr�e personne et retourne sur la fen�tre menu
	 * il ordone de mettre les donn� dans la dao
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
		JOptionPane.showMessageDialog(ErreurecoF, "Cr�ation faite !",
				"Info", JOptionPane.INFORMATION_MESSAGE);
		return;
	}
	
	/**
	 * ouvre la fen�tre selection personne
	 */
	public static void modifPersonne1() {  
		MenuPersonne.setVisible(false);
		 SelectionPersonneM= new SelectionPersonneM();
		MenuPersonne.dispose();
		return;
	}
	/**
	 * selectionne la personne a modif 
	 * ouvre la fen�tre pour rentrer les infos de la personne apres modification 
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
	 * retourne sur la fen�tre menu
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
	 * ouvre la fen�tre selection personne
	 */
	public static void suprefPersonne1() {
		MenuPersonne.setVisible(false);
		SelectionPersonneS= new SelectionPersonneS();
		MenuPersonne.dispose();
		return;
	}
	/**
	 * Suprime la personne et retourne a la fen�tre menu
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
		JOptionPane.showMessageDialog(ErreurecoF, "Personne Supprim� !",
				"Info", JOptionPane.INFORMATION_MESSAGE);
		SelectionPersonneS.dispose();
		return ;
	}
	/**
	 * ouvre la fen�tre cr�e badge 
	 */
	public static  void creeBadge1() {
		MenuBadge.setVisible(false);
		 SelectionPersonneB= new SelectionPersonneB();
		MenuBadge.dispose();
		return;
	}
	/**
	 * cr�e le badge
	 * ouvre la fen�tre menu
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
	 * ouvre la fen�tre selection badge
	 */
	public static void supreBadge1() {
		MenuBadge.setVisible(false);
		SupressionBadge = new SupressionBadge();
		MenuBadge.dispose();
		return;
	}
	/**
	 * supprime le badge 
	 * ouvre la fen�tre menu
	 * @param idbadge
	 */
	public static void supreBadge2(int idbadge) {
		Badgedao.supprime(idbadge);
		 JOptionPane.showMessageDialog(ErreurecoF, "Badge Supprim� !",
					"Info", JOptionPane.INFORMATION_MESSAGE);
		 Menu= new Menu();
		 SupressionBadge.dispose();
		return;
	}
	/**
	 * ouvre la fen�tre gerer profil 
	 */
	public static void gererProfil() {
		Menu.setVisible(false);
		MenuProfil =new MenuProfil(); 
		Menu.dispose();
		return;
	}
	/**
	 * Ouvre la fen�tre cr�e un badge
	 */
	public static void Cr�eProfil() {
		MenuProfil.setVisible(false);
		Cr�eProfil = new Cr�eProfil();
		return;
	}
	/**
	 * cr�e un profil 
	 * ouvre la fen�tre menu
	 * @param nomp
	 * @param lieu
	 * @param heuredebut
	 * @param heurefin
	 */
	public static void Cr�eProfil2(String nomp, String lieu ,String heuredebut,String heurefin) {
		//Cr�eProfil.setVisible(false);
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
		Cr�eProfil.dispose();
	}
	/**
	 * ouvre la fen�tre lection profil
	 */
	public static void ModifProfil() {
		MenuProfil.setVisible(false);
		selectionProfil = new selectionProfil();
		return;
	}
	/**
	 * selectionne le profil
	 * ouvre la fen�tre modif profil
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
	 * ovre la fen�tre menu
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
	 * ouvre la fen�tre selection profil
	 */
	public static void SupreProfil() {
		MenuProfil.setVisible(false);
		selectionProfilS = new selectionProfilS();
		return;
	}
	/**
	 * suprime le profil
	 * ouvre la fen�tre menu
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
	 * ouvre la fen�tre selection personne
	 */
	public static void setProfil() {
		MenuProfil.setVisible(false);
		selectionPersonneP= new selectionPersonneP();
		MenuProfil.dispose();
		return ;
	}
	/**
	 * selectionne la personne 
	 * ouvre la fen�tre selection profil
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
	 * ouvre la fen�tre menu
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
	 * ouvre la fen�tre selection profil
	 */
	public static void ListeProfil() {
		MenuProfil.setVisible(false);
		selectionProfilL= new selectionProfilL();
		MenuProfil.dispose();
		return ;
	}
	/**
	 * ouvre la fen�tre affichage des personne
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
	 * ouvre la fen�tre menu
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
	 * ouvre la fen�tre affichage des personne
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
	 * ouvre la fen�tre menu
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

