import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class selectionPersonneL2 extends JFrame implements ActionListener{
 
	private static final long serialVersionUID = 1L;
	/**
	 * Le panel qui contient les objets
	 */
	private JPanel containerPanel;
	/**
	 * C'est du texte qu'on va afficher
	 */
	private JLabel label;
	/**
	 * l'id du profil qu'on va retourner 
	 */
	private static int id;
	/**
	 * bouton
	 */
	private JButton boutonValider;
	/**
	 * bouton retour menu
	 */	
	private JButton boutonretour;
	
	JTextArea zoneTextListConnection;

	//private JLabel labelConnection;

	JScrollPane zoneDefilement;
	/**
	 * classe constructeur
	 * @param idprofil
	 */
	public selectionPersonneL2(ArrayList<Personne> listpers) {
		
		// on fixe le titre
		this.setTitle("Menu selection profil");
		// initialisation de la taille
		this.setSize(500, 500);
		
		
		
		this.setLocationRelativeTo(null);
		containerPanel = new JPanel();
		
		containerPanel.setLayout(new BoxLayout(containerPanel,BoxLayout.PAGE_AXIS));
		containerPanel.setBackground(Color.WHITE);
		this.setContentPane(containerPanel);
		//this.setVisible(true);
		//textFieldConnection = new JTextField();
		boutonValider = new JButton("Menu");

		boutonValider.addActionListener(this);
		for (int i =0; i< listpers.size(); i=i+1) {
			label = new JLabel("nom :"+listpers.get(i).getnom()+"Prenom : "+listpers.get(i).getprenom()+" Fonction : "+listpers.get(i).getfonction()+" naissance :"+ listpers.get(i).getNaissance() +"  Profil: "+Profildao.getNProfil(listpers.get(i).getIdprofil()));
			
			containerPanel.add(label);
			containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));  
		}
		containerPanel.add(boutonValider);
		
		boutonValider.addActionListener(this);
		
		boutonretour= new JButton("Retour");
		containerPanel.add(boutonretour);
		boutonretour.addActionListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("affichage des personnes  ");
		this.setVisible(true);
		
		
	}
	/**
	 * Cette m�thode attend que l'on apuis sur le bouton et �x�cute des actions en fonction du bouton
	 */
public void actionPerformed(ActionEvent ae) {
		
		try {
			
			if(ae.getSource() == boutonValider) {
				HubProg.ListePersonne3();
				
			}else if (ae.getSource()== boutonretour){
				Menu Menu=new Menu();
				this.dispose();
			}
		}catch (Exception e) {
			
		}
}
	
}
