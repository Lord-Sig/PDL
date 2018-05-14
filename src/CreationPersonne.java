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

public class CreationPersonne extends JFrame implements ActionListener{
 
	private static final long serialVersionUID = 1L;
	/**
	 * Le panel qui contient les objets
	 */
	private JPanel containerPanel;
	/**
	 * C'est du texte qu'on va r�cuperer
	 */
	private JTextField textFieldNom;
	/**
	 * C'est du texte qu'on va r�cuperer
	 */
	private JTextField textFieldPrenom;
	/**
	 * C'est du texte qu'on va r�cuperer
	 */
	private JTextField textFieldDateDeNaissanceJ;
	/**
	 * C'est du texte qu'on va r�cuperer
	 */
	private JTextField textFieldDateDeNaissanceM;
	/**
	 * C'est du texte qu'on va r�cuperer
	 */
	private JTextField textFieldDateDeNaissanceA;
	/**
	 * C'est du texte qu'on va r�cuperer
	 */
	private JTextField textFieldFonction;
	/**
	 * C'est du texte qu'on va afficher
	 */
	private JLabel labelNom;
	/**
	 * C'est du texte qu'on va afficher
	 */
	private JLabel labelIdprofil;
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
	 * Ce bouton valide la cr�ation d'une personne
	 */
	private JButton boutonValider;
	
	JTextArea zoneTextListConnection;

	//private JLabel labelConnection;

	JScrollPane zoneDefilement;
	/**
	 * classe constructeur
	 */
	public CreationPersonne() {
		
		// on fixe le titre
		this.setTitle("Menu cr�er personne");
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
		textFieldFonction = new JTextField();
		//textFieldConnection = new JTextField();
		boutonValider = new JButton("Valider");
		
		
		
		
		labelNom = new JLabel("Nom :");
		labelPrenom = new JLabel("Prenom :");
		labelDateDeNaissanceJ = new JLabel("Jour de naissance :");
		labelDateDeNaissanceM = new JLabel("Mois de naissance :");
		labelDateDeNaissanceA = new JLabel("Ann�e de naissance :");
		labelFonction = new JLabel("Fonction :");
		labelIdprofil = new JLabel("Idprofil :");
		
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
		
		containerPanel.add(labelFonction);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		containerPanel.add(textFieldFonction);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		
		containerPanel.add(boutonValider);
		
		boutonValider.addActionListener(this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Menu cr�er personne");
		this.setVisible(true);
		
		
	}
	/** 
	 * Cette m�thode attend que l'on apuis et quand �a arrive cr�e la personne et va au menu
	 */
public void actionPerformed(ActionEvent ae) {
		
		try {
			
			if(ae.getSource() == boutonValider) {
				HubProg.creePersonne2(textFieldNom.getText(), textFieldPrenom.getText(), textFieldFonction.getText(), textFieldDateDeNaissanceA.getText(), textFieldDateDeNaissanceM.getText(),  textFieldDateDeNaissanceJ.getText());
				
			}else {
				
				
				}
		}catch (Exception e) {
			
		}
}
	
}
