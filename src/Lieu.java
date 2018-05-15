public class Lieu {
	
	
	
private String nom;
private String adresse;



public Lieu(String nom, String adresse) {
	
	this.nom=nom;
	this.adresse=adresse;
	

}
	
public String getNom(){
	return nom;
	
}
	
public String getAdresse(){
	return adresse;
	
	
	}


public void setNom(String nom){
	this.nom=nom;
	
}

public void setAdresse(String adresse){
	this.adresse=adresse;
	
}




public void afficher() {
	
	System.out.print(nom+","+adresse);
}








}
