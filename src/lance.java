import java.util.ArrayList;

public class lance {

	public static void main(String[] args) {
		HubProg h=new HubProg();
		//Personnedao.ajouter("nomp", "prenomp", "onction", "01", "01", "97", "1");
		//MenuProfil MenuProfil= new MenuProfil();
		
		ArrayList<String> Lieu= new ArrayList<String>();
		Lieu.add("a");
		Lieu.add("b");
		Lieu.add("c");
		
		/*
		String lieu = "a/b/c/d";
		 
        String  mots[] = lieu.split("/");
		ArrayList<String> Lieu= new ArrayList<String>();
		for (int i = 0; i < mots.length; i++) {
			Lieu.add(mots[i]);
        }*/
		Profildao Profildao= new Profildao();
		Profildao.modifie("ytytyt",Lieu , "02", "11",21);
		//Profildao Profildao =new Profildao();
		//HubProg.CréeProfil2("eleve", "a/z/er/t", "01", "11");
	}
}
