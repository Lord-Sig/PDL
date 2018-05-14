import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.Box;
import java.util.List;

public class SelectionPersonneM extends JFrame implements ActionListener{
 
	private static final long serialVersionUID = 1L;
	/**
	 * Le panel qui contient les objets
	 */
	private JPanel containerPanel;
	/**
	 * C'est du texte qu'on va récuperer
	 */
	private JTextField textFieldNom;
	/**
	 * C'est du texte qu'on va récuperer
	 */
	private JTextField textFieldPrenom;
	/**
	 * C'est du texte qu'on va récuperer
	 */
	private JTextField textFieldDateDeNaissanceJ;
	/**
	 * C'est du texte qu'on va récuperer
	 */
	private JTextField textFieldDateDeNaissanceM;
	/**
	 * C'est du texte qu'on va récuperer
	 */
	private JTextField textFieldDateDeNaissanceA;
	/**
	 * C'est du texte qu'on va récuperer
	 */
	private JTextField textFieldFonction;
	/**
	 * C'est du texte qu'on va afficher
	 */
	private JLabel labelNom;
	/**
	 * C'est du texte qu'on va afficher
	 */
	private JLabel labelPrenom;
	/**
	 * C'est du texte qu'on va afficher
	 */
	private JLabel labelDateDeNaissanceJ;
	/**
	 * C'est du texte qu'on va afficher
	 */
	private JLabel labelDateDeNaissanceM;
	/**
	 * C'est du texte qu'on va afficher
	 */
	private JLabel labelDateDeNaissanceA;
	/**
	 * C'est du texte qu'on va afficher
	 */
	private JLabel labelFonction;
	/**
	 * Ce bouton valide la selection du personnage 
	 */
	private JButton boutonValider;
	
	public static int id;
	
	JTextArea zoneTextListConnection;

	//private JLabel labelConnection;

	JScrollPane zoneDefilement;
	
	/**
	 * classe constructeur
	 */
	public SelectionPersonneM() {
		
		// on fixe le titre
		this.setTitle("Menu sélectionner modification d'une personne");
		// initialisation de la taille
		this.setSize(500, 500);
		
		
		
		this.setLocationRelativeTo(null);
		containerPanel = new JPanel();
		
		containerPanel.setLayout(new BoxLayout(containerPanel,BoxLayout.PAGE_AXIS));
		containerPanel.setBackground(Color.WHITE);
		this.setContentPane(containerPanel);
		//this.setVisible(true);
		
		textFieldNom = new JTextField();
		textFieldPrenom = new JTextField();
		textFieldDateDeNaissanceJ = new JTextField();
		textFieldDateDeNaissanceM = new JTextField();
		textFieldDateDeNaissanceA = new JTextField();
		//textFieldFonction = new JTextField();
		//textFieldConnection = new JTextField();
		boutonValider = new JButton("Valider la selection");
		
		
		
		
		labelNom = new JLabel("Nom :");
		labelPrenom = new JLabel("Prenom :");
		labelDateDeNaissanceJ = new JLabel("Jour de naissance :");
		labelDateDeNaissanceM = new JLabel("Mois de naissance :");
		labelDateDeNaissanceA = new JLabel("Année de naissance :");
		labelFonction = new JLabel("Fonction :");
		
		//labelConnection = new JLabel(":");
		
		containerPanel.add(labelNom);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		containerPanel.add(textFieldNom);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		
		containerPanel.add(labelPrenom);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		containerPanel.add(textFieldPrenom);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		
		containerPanel.add(labelDateDeNaissanceJ);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		containerPanel.add(textFieldDateDeNaissanceJ);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		
		containerPanel.add(labelDateDeNaissanceM);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		containerPanel.add(textFieldDateDeNaissanceM);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		
		containerPanel.add(labelDateDeNaissanceA);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		containerPanel.add(textFieldDateDeNaissanceA);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		/*
		containerPanel.add(labelFonction);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		containerPanel.add(textFieldFonction);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		*/
		containerPanel.add(boutonValider);
		
		boutonValider.addActionListener(this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Menu selectionner la modification personne");
		this.setVisible(true);
		
	}
	/**
	 * attend que l'on apuis sur le bouton et quand on apuis actualise l'id
	 */
public void actionPerformed(ActionEvent ae) {
		
		try {
			
			if(ae.getSource() == boutonValider) {
				id=HubProg.modifPersonne2(textFieldNom.getText(), textFieldPrenom.getText(), textFieldDateDeNaissanceA.getText(), textFieldDateDeNaissanceM.getText(),textFieldDateDeNaissanceJ.getText());
			}else {
				
				
				}
		}catch (Exception e) {
			
		}
		
}
/** 
 * Donne l'idpersonne de la personne selectionné  
 * @return id
 */
public static int getID() {
	return id;
}
}
