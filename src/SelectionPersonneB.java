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

public class SelectionPersonneB extends JFrame implements ActionListener{
 
	private static final long serialVersionUID = 1L;
	/**
	 * Le panel qui contient les objets
	 */
	private JPanel containerPanel;
	/**
	 * Le panel qui contient du texte qu'on va récupérer 
	 */
	private JTextField textFieldNom;
	/**
	 * Le panel qui contient du texte qu'on va récupérer 
	 */
	private JTextField textFieldPrenom;
	/**
	 * Le panel qui contient du texte qu'on va récupérer 
	 */
	private JTextField textFieldDateDeNaissanceJ;
	/**
	 * Le panel qui contient du texte qu'on va récupérer 
	 */
	private JTextField textFieldDateDeNaissanceM;
	/**
	 * Le panel qui contient du texte qu'on va récupérer 
	 */
	private JTextField textFieldDateDeNaissanceA;
	/**
	 * Le panel qui contient du texte qui indique  
	 */
	private JLabel labelNom;
	/**
	 * On a le texte que l'on va afficher
	 */
	private JLabel labelPrenom;
	/**
	 * On a le texte que l'on va afficher
	 */
	private JLabel labelDateDeNaissanceJ;
	/**
	 * On a le texte que l'on va afficher
	 */
	private JLabel labelDateDeNaissanceM;
	/**
	 * On a le texte que l'on va afficher
	 */
	private JLabel labelDateDeNaissanceA;
	/**
	 * Le bouton pour valider la selection
	 */
	private JButton boutonValider;
	
	JTextArea zoneTextListConnection;

	//private JLabel labelConnection;

	JScrollPane zoneDefilement;
	/**
	 * constructeur
	 */
	public SelectionPersonneB() {
		
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
		//textFieldConnection = new JTextField();
		boutonValider = new JButton("Valider la selection");
		
		
		
		
		labelNom = new JLabel("Nom :");
		labelPrenom = new JLabel("Prenom :");
		labelDateDeNaissanceJ = new JLabel("Jour de naissance :");
		labelDateDeNaissanceM = new JLabel("Mois de naissance :");
		labelDateDeNaissanceA = new JLabel("Année de naissance :");
		
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
		
		
		
		containerPanel.add(boutonValider);
		
		boutonValider.addActionListener(this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Menu selectionner la modification personne");
		this.setVisible(true);
		
	}
	/**
	 * cette méthode attend qu'on apuis sur le bouton
	 */
public void actionPerformed(ActionEvent ae) {
		
		try {
			
			if(ae.getSource() == boutonValider) {
				HubProg.creeBadge2(textFieldNom.getText(), textFieldPrenom.getText(), textFieldDateDeNaissanceJ.getText(), textFieldDateDeNaissanceM.getText(), textFieldDateDeNaissanceA.getText());
			}else {
				
				
				}
		}catch (Exception e) {
			
		}
		
}
}
