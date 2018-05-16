import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class selectionProfil extends JFrame implements ActionListener{
 
	private static final long serialVersionUID = 1L;
	/**
	 *C'est le panel qui va contenir les objet
	 */
	private JPanel containerPanel;
	/**
	 * On a le texte que l'on va récupérer
	 */
	private JTextField textFieldNom;
	/**
	 * On a le texte que l'on va afficher
	 */
	private JLabel labelNom;
	/**
	 * cette variable permet de return Id du profil selectionner
	 */
	private static int id;
	/**
	 * le bouton valide la selection
	 */
	private JButton boutonValider;
	/**
	 * bouton
	 */	
	private JButton boutonretour;
	
	JTextArea zoneTextListConnection;

	//private JLabel labelConnection;

	JScrollPane zoneDefilement;
	
	/**
	 * Classe constructeur affiche la fenettre
	 */
	public selectionProfil() {
		
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
		
		textFieldNom = new JTextField();
		//textFieldConnection = new JTextField();
		boutonValider = new JButton("Valider");
		
		
		
		
		labelNom = new JLabel("Nom :");
		
		//labelConnection = new JLabel(":");
		
		containerPanel.add(labelNom);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		containerPanel.add(textFieldNom);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10))); 
		
		containerPanel.add(boutonValider);
		
		boutonValider.addActionListener(this);
		boutonretour= new JButton("Retour");
		containerPanel.add(boutonretour);
		boutonretour.addActionListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Menu selection profil");
		this.setVisible(true);
		
		
	}
	/**
	 * Cette méthode attend que l'on apuis sur le bouton et éxécute des actions en fonction du bouton
	 */
public void actionPerformed(ActionEvent ae) {
		
		try {
			
			if(ae.getSource() == boutonValider) {
				id=HubProg.ModifProfil2(textFieldNom.getText());
				HubProg.ModifProfil2(textFieldNom.getText());
			}else if (ae.getSource()== boutonretour){
				Menu Menu=new Menu();
				this.dispose();
			}
		}catch (Exception e) {
			
		}
}
/**
 *donne l'idProfil selectionner
 * @return id 
 */
public static int getID() {
	return id;
}
	
}
