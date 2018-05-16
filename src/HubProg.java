import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class HubProg {
	private static final Component ErreurecoF = null;
	/**
	 * initialiser une fen�tre
	 */
	 static  ConnectionFen ConnectionFen;
	/**
	 * initialiser une fen�tre
	 */
	static selectionPersonneL selectionPersonneL;
	/**
	 * initialiser une fen�tre
	 */
	static Menu Menu;
	/**
	 * initialiser une fen�tre
	 */
	static ModifLieu ModifLieu;
	/**
	 * initialiser une fen�tre
	 */
	static supreLieu supreLieu;
	/**
	 * initialiser une fen�tre
	 */
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
	static cr�eLieu cr�eLieu;
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
	 * Ouvre la fen�tre cr�e personne
	 */
	public static void creePersonne1(){
		MenuPersonne.setVisible(false);
		 CreationPersonne= new CreationPersonne();
		MenuPersonne.dispose();
		return;
	}
	/**
	 * Cette fonction envoi dans la fen�tre et cr�e dans la dao la personne
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
	 * ann�e de la personne
	 * 
	 */
	public static void creePersonne2(String pnom,String pprenom, String pfonction,String jnaissancep,String mnaissancep,String anaissancep){
		CreationPersonne.setVisible(false);
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
	 *  nom
	 * @param pprenom
	 *  prenom
	 * @param jnaissancep
	 *  jours de naissance
	 * @param mnaissancep
	 *  mois de naissance
	 * @param anaissancep
	 *  ann�e de naissance
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
	 * ouvre la fen�tre pour rentrer les infos de la personne apres modification 
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
	 * nouvelle ann�e de naissance
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
	 * passe � la fen�tre selection personne
	 */
	public static void suprefPersonne1() {
		MenuPersonne.setVisible(false);
		SelectionPersonneS= new SelectionPersonneS();
		MenuPersonne.dispose();
		return;
	}
	/**
	 * Suprime la personne et passe � la fen�tre menu
	 * @param pnom 
	 * nom de la personne a supprim�
	 * @param pprenom
	 * Prenom de la personne a supprim�
	 * @param jnaissancep
	 * jours de naissance de la personne a supprim�
	 * @param mnaissancep
	 * mois de naissance de la personne a supprime
	 * @param anaissancep
	 * ann�e de naissance de la personne a supprim�
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
	 * passe � la fen�tre cr�e badge 
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
	 * passe � la fen�tre selection badge
	 */
	public static void supreBadge1() {
		MenuBadge.setVisible(false);
		SupressionBadge = new SupressionBadge();
		MenuBadge.dispose();
		return;
	}
	/**
	 * supprime le badge dans la dao
	 * passe � la fen�tre menu
	 * @param idbadge 
	 * id du badge a supprimer
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
	 * passe � la fen�tre gerer profil 
	 */
	public static void gererProfil() {
		Menu.setVisible(false);
		MenuProfil =new MenuProfil(); 
		Menu.dispose();
		return;
	}
	/**
	 * passe � la fen�tre cr�e un profil
	 */
	public static void Cr�eProfil() {
		MenuProfil.setVisible(false);
		Cr�eProfil = new Cr�eProfil();
		return;
	}
	/**
	 * cr�e un profil 
	 * passe � la fen�tre menu
	 * @param nomp
	 * nom du profil
	 * @param lieu
	 * les lieux autoris�
	 * @param heuredebut
	 * heure de d�but d'entr�
	 * @param heurefin
	 * heure de d�but de fin
	 */
	public static void Cr�eProfil2(String nomp, String lieu ,String heuredebut,String heurefin) {
		//Cr�eProfil.setVisible(false);
		String  mots[] = lieu.split("/");
		ArrayList<String> Lieu= new ArrayList<String>();
		for (int i = 0; i < mots.length; i++) {
			Lieu.add(mots[i]);
			System.out.println(mots[i]);
        }
		Menu = new Menu();
		Profildao.ajouter(nomp, Lieu, heuredebut, heurefin);
		Cr�eProfil.dispose();
	}
	/**
	 * passe � la fen�tre selection profil
	 */
	public static void ModifProfil() {
		MenuProfil.setVisible(false);
		selectionProfil = new selectionProfil();
		return;
	}
	/**
	 * selectionne le profil
	 * passe � la fen�tre modifier profil
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
	 * passe � la fen�tre menu
	 * @param nomp
	 * nouveau nom du profil
	 * @param lieu
	 * nouveau lieu posible
	 * @param heuredebut
	 * nouvelle heure de d�but
	 * @param heurefin
	 * nouvelle heure de fin
	 * @param idprofil
	 * id du profil a modifi�
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
	 * passe � la fen�tre selection profil
	 */
	public static void SupreProfil() {
		MenuProfil.setVisible(false);
		selectionProfilS = new selectionProfilS();
		return;
	}
	/**
	 * suprime le profil dans la dao
	 * passe � la fen�tre menu
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
	 * passe � la fen�tre selection personne
	 */
	public static void setProfil() {
		MenuProfil.setVisible(false);
		selectionPersonneP= new selectionPersonneP();
		MenuProfil.dispose();
		return ;
	}
	/**
	 * selectionne la personne 
	 * passe � la fen�tre selection profil
	 * @param nomp 
	 * nom de la personne a set
	 * @param prenom
	 * prenom de la personne a set
	 * @param anne
	 * ann�e de la personne a set
	 * @param mois
	 * mois de la personne a set
	 * @param jour
	 * jours de la personne a set
	 * @return id 
	 * de la personne selection� 
	 */
	public static int setProfil2(String nomp, String prenom, String anne, String mois, String jour) {
		selectionPersonneP.setVisible(false);
		int id =Personnedao.getIdpersonne(nomp, prenom, anne, mois, jour);
		selectionProfilP = new selectionProfilP();
		return id;
		
	}
	/**
	 * passe � la fen�tre menu
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
	 * passe � la fen�tre selection profil
	 */
	public static void ListeProfil() {
		MenuProfil.setVisible(false);
		selectionProfilL= new selectionProfilL();
		MenuProfil.dispose();
		return ;
	}
	/**
	 * passe � la fen�tre affichage des personne
	 * @param nomprof
	 * nom du profil
	 * @return id 
	 * id du profil selectionn�
	 */
	public static int ListeProfil2(String nomprof) {
		selectionProfilL.setVisible(false);
		int id = Profildao.getIdprofil(nomprof);
		selectionProfilL2= new selectionProfilL2(id);
		return id;
	}
	/**
	 * passe � la fen�tre menu
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
	 * passe � la fen�tre affichage des personne
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
	 * passe � la fen�tre menu
	 */
	public static void 	ListePersonne3() {
		selectionPersonneL2.setVisible(false);
		Menu = new Menu();
		selectionPersonneL2.dispose();
		selectionPersonneL.dispose();
		return ;
	} 
	/**
	 * passe � la fen�tre Menu Lieu
	 */
	public static void MenuLieu() {
		Menu.setVisible(false);
		menuLieu = new menuLieu();
		Menu.dispose();
	}
	/**
	 * Passe � la fen�tre Cr�e Lieu
	 */
	public static void Cr�eLieu() {
		menuLieu.setVisible(false);
		cr�eLieu=new cr�eLieu();
		menuLieu.dispose();
		return ;
	}
	/**
	 * Passe � la fen�tre Menu
	 * cr�e le Lieu dans la Dao
	 * @param nom
	 * nom du lieu
	 * @param adresse
	 * adresse du lieu
	 */
	public static void Cr�eLieu2(String nom, String adresse) {
		cr�eLieu.setVisible(false);
		LieuDAO.ajouter(nom, adresse);
		Menu = new Menu();
		cr�eLieu.dispose();
		return ;
	}
	/**
	 * Passe � la fen�tre modifi� personne 
	 */
	public static void ModifLieu() {
		menuLieu.setVisible(false);
		ModifLieu=new ModifLieu();
		menuLieu.dispose();
		return ;
	}
	/**
	 * passe � la fen�tre Menu
	 * @param nomm 
	 * nom du lieu � modifier 
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
	 * Passe � la fen�tre Selection Lieu
	 */
	public static void supreLieu() {
		menuLieu.setVisible(false);
		supreLieu=new supreLieu();
		menuLieu.dispose();
		return ;
	}
	/**
	 * Supprime le lieu dans le dao
	 * Passe � la fen�tre Menu
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

