import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class HubProg {
	private static final Component ErreurecoF = null;
	/**
	 * initialiser une fenêtre
	 */
	 static  ConnectionFen ConnectionFen;
	/**
	 * initialiser une fenêtre
	 */
	static selectionPersonneL selectionPersonneL;
	/**
	 * initialiser une fenêtre
	 */
	static Menu Menu;
	/**
	 * initialiser une fenêtre
	 */
	static ModifLieu ModifLieu;
	/**
	 * initialiser une fenêtre
	 */
	static supreLieu supreLieu;
	/**
	 * initialiser une fenêtre
	 */
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
	static créeLieu créeLieu;
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
	 * nom de compte
	 * @param code
	 * code du compte
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
	 * Cette fonction envoi dans la fenêtre et crée dans la dao la personne
	 * @param pnom
	 * nom de la personne
	 * @param pprenom
	 * prenom de la personne
	 * @param pfonction
	 * fonction de la personne
	 * @param jnaissancep
	 * jours de naissance de la personne
	 * @param mnaissancep
	 * mois de naissance de la personne
	 * @param anaissancep
	 * année de la personne
	 * 
	 */
	public static void creePersonne2(String pnom,String pprenom, String pfonction,String jnaissancep,String mnaissancep,String anaissancep){
		CreationPersonne.setVisible(false);
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
	 *  nom
	 * @param pprenom
	 *  prenom
	 * @param jnaissancep
	 *  jours de naissance
	 * @param mnaissancep
	 *  mois de naissance
	 * @param anaissancep
	 *  année de naissance
	 * @return id 
	 * id de la personne a modifier 
	 */
	public static int modifPersonne2(String pnom,String pprenom,String jnaissancep,String mnaissancep,String anaissancep) {
		SelectionPersonneM.setVisible(false);
		int id =Personnedao.getIdpersonne( pnom, pprenom, jnaissancep, mnaissancep, anaissancep);
		ModifPersonne= new ModifPersonne();

		 System.out.println(id);
		return id;
	}
	/**
	 * selectionne la personne a modif 
	 * ouvre la fenêtre pour rentrer les infos de la personne apres modification 
	 * @param pnom
	 * nouveau nom
	 * @param pprenom
	 * nouveau prenom
	 * @param fonction
	 * nouvelle fonction 
	 * @param jnaissancep
	 * nouveau jours de naissance
	 * @param mnaissancep
	 * nouveau mois de naissance
	 * @param anaissancep
	 * nouvelle année de naissance
	 * @param idpersonne 
	 * id de la personne a modifier 
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
	 * passe à la fenêtre selection personne
	 */
	public static void suprefPersonne1() {
		MenuPersonne.setVisible(false);
		SelectionPersonneS= new SelectionPersonneS();
		MenuPersonne.dispose();
		return;
	}
	/**
	 * Suprime la personne et passe à la fenêtre menu
	 * @param pnom 
	 * nom de la personne a supprimé
	 * @param pprenom
	 * Prenom de la personne a supprimé
	 * @param jnaissancep
	 * jours de naissance de la personne a supprimé
	 * @param mnaissancep
	 * mois de naissance de la personne a supprime
	 * @param anaissancep
	 * année de naissance de la personne a supprimé
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
	 * passe à la fenêtre crée badge 
	 */
	public static  void creeBadge1() {
		MenuBadge.setVisible(false);
		 SelectionPersonneB= new SelectionPersonneB();
		MenuBadge.dispose();
		return;
	}
	/**
	 * retourne au menu
	 */
	public static void creeBadge2() {
		SelectionPersonneB.setVisible(false);
		Badgedao.ajouter(SelectionPersonneB.getID());
		 Menu= new Menu();
		SelectionPersonneB.dispose();
		return;
	}
	/**
	 * passe à la fenêtre selection badge
	 */
	public static void supreBadge1() {
		MenuBadge.setVisible(false);
		SupressionBadge = new SupressionBadge();
		MenuBadge.dispose();
		return;
	}
	/**
	 * supprime le badge dans la dao
	 * passe à la fenêtre menu
	 * @param idbadge 
	 * id du badge a supprimer
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
	 * passe à la fenêtre gerer profil 
	 */
	public static void gererProfil() {
		Menu.setVisible(false);
		MenuProfil =new MenuProfil(); 
		Menu.dispose();
		return;
	}
	/**
	 * passe à la fenêtre crée un profil
	 */
	public static void CréeProfil() {
		MenuProfil.setVisible(false);
		CréeProfil = new CréeProfil();
		return;
	}
	/**
	 * crée un profil 
	 * passe à la fenêtre menu
	 * @param nomp
	 * nom du profil
	 * @param lieu
	 * les lieux autorisé
	 * @param heuredebut
	 * heure de début d'entré
	 * @param heurefin
	 * heure de début de fin
	 */
	public static void CréeProfil2(String nomp, String lieu ,String heuredebut,String heurefin) {
		//CréeProfil.setVisible(false);
		String  mots[] = lieu.split("/");
		ArrayList<String> Lieu= new ArrayList<String>();
		for (int i = 0; i < mots.length; i++) {
			Lieu.add(mots[i]);
			System.out.println(mots[i]);
        }
		Menu = new Menu();
		Profildao.ajouter(nomp, Lieu, heuredebut, heurefin);
		CréeProfil.dispose();
	}
	/**
	 * passe à la fenêtre selection profil
	 */
	public static void ModifProfil() {
		MenuProfil.setVisible(false);
		selectionProfil = new selectionProfil();
		return;
	}
	/**
	 * selectionne le profil
	 * passe à la fenêtre modifier profil
	 * @param nomp
	 * nomp du profil a modif
	 * @return none
	 */
	public static int ModifProfil2(String nomp) {
		selectionProfil.setVisible(false);
		ModifProfil= new ModifProfil();
		int id =Profildao.getIdprofil(nomp);
		return id;
	}
	/**
	 * modifie la personne 
	 * passe à la fenêtre menu
	 * @param nomp
	 * nouveau nom du profil
	 * @param lieu
	 * nouveau lieu posible
	 * @param heuredebut
	 * nouvelle heure de début
	 * @param heurefin
	 * nouvelle heure de fin
	 * @param idprofil
	 * id du profil a modifié
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
	 * passe à la fenêtre selection profil
	 */
	public static void SupreProfil() {
		MenuProfil.setVisible(false);
		selectionProfilS = new selectionProfilS();
		return;
	}
	/**
	 * suprime le profil dans la dao
	 * passe à la fenêtre menu
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
	 * passe à la fenêtre selection personne
	 */
	public static void setProfil() {
		MenuProfil.setVisible(false);
		selectionPersonneP= new selectionPersonneP();
		MenuProfil.dispose();
		return ;
	}
	/**
	 * selectionne la personne 
	 * passe à la fenêtre selection profil
	 * @param nomp 
	 * nom de la personne a set
	 * @param prenom
	 * prenom de la personne a set
	 * @param anne
	 * année de la personne a set
	 * @param mois
	 * mois de la personne a set
	 * @param jour
	 * jours de la personne a set
	 * @return id 
	 * de la personne selectioné 
	 */
	public static int setProfil2(String nomp, String prenom, String anne, String mois, String jour) {
		selectionPersonneP.setVisible(false);
		int id =Personnedao.getIdpersonne(nomp, prenom, anne, mois, jour);
		selectionProfilP = new selectionProfilP();
		return id;
		
	}
	/**
	 * passe à la fenêtre menu
	 * modifie le profil
	 * @param profil
	 * nom du profil
	 * @param idpersonne
	 * id de la personne set
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
	 * passe à la fenêtre selection profil
	 */
	public static void ListeProfil() {
		MenuProfil.setVisible(false);
		selectionProfilL= new selectionProfilL();
		MenuProfil.dispose();
		return ;
	}
	/**
	 * passe à la fenêtre affichage des personne
	 * @param nomprof
	 * nom du profil
	 * @return id 
	 * id du profil selectionné
	 */
	public static int ListeProfil2(String nomprof) {
		selectionProfilL.setVisible(false);
		int id = Profildao.getIdprofil(nomprof);
		selectionProfilL2= new selectionProfilL2(id);
		return id;
	}
	/**
	 * passe à la fenêtre menu
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
	 * passe à la fenêtre affichage des personne
	 * @param nomp
	 * nom de la personne
	 * @param prenomp
	 * prenom de la personne
	 */
	public static void  ListePersonne2(String nomp, String prenomp) {
		selectionPersonneL.setVisible(false);
		ArrayList<Personne> listpers = new ArrayList<Personne>();
		listpers= Personnedao.Trouvepersonne(nomp, prenomp);
		selectionPersonneL2= new selectionPersonneL2(listpers);
		return ;
	}
	/**
	 * passe à la fenêtre menu
	 */
	public static void 	ListePersonne3() {
		selectionPersonneL2.setVisible(false);
		Menu = new Menu();
		selectionPersonneL2.dispose();
		selectionPersonneL.dispose();
		return ;
	} 
	/**
	 * passe à la fenêtre Menu Lieu
	 */
	public static void MenuLieu() {
		Menu.setVisible(false);
		menuLieu = new menuLieu();
		Menu.dispose();
	}
	/**
	 * Passe à la fenêtre Crée Lieu
	 */
	public static void CréeLieu() {
		menuLieu.setVisible(false);
		créeLieu=new créeLieu();
		menuLieu.dispose();
		return ;
	}
	/**
	 * Passe à la fenêtre Menu
	 * crée le Lieu dans la Dao
	 * @param nom
	 * nom du lieu
	 * @param adresse
	 * adresse du lieu
	 */
	public static void CréeLieu2(String nom, String adresse) {
		créeLieu.setVisible(false);
		LieuDAO.ajouter(nom, adresse);
		Menu = new Menu();
		créeLieu.dispose();
		return ;
	}
	/**
	 * Passe à la fenêtre modifié personne 
	 */
	public static void ModifLieu() {
		menuLieu.setVisible(false);
		ModifLieu=new ModifLieu();
		menuLieu.dispose();
		return ;
	}
	/**
	 * passe à la fenêtre Menu
	 * @param nomm 
	 * nom du lieu à modifier 
	 * @param nom 
	 * le nouveau nom du lieu
	 * @param adresse
	 * la nouvell adresse
	 */
	public static void ModifLieu2(String nomm, String nom, String adresse) {
		ModifLieu.setVisible(false);
		LieuDAO.modifie(nom, adresse,nomm);
		Menu = new Menu();
		ModifLieu.dispose();
		return ;
	}
	/**
	 * Passe à la fenêtre Selection Lieu
	 */
	public static void supreLieu() {
		menuLieu.setVisible(false);
		supreLieu=new supreLieu();
		menuLieu.dispose();
		return ;
	}
	/**
	 * Supprime le lieu dans le dao
	 * Passe à la fenêtre Menu
	 * @param nom 
	 * nom du lieu a suprimer 
	 */
	public static void supreLieu2(String nom) {
		supreLieu.setVisible(false);
		LieuDAO.supprimerLieu(nom);
		Menu =new Menu();
		supreLieu.dispose();
		return ;
	}
	
}

