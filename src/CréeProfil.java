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

public class CréeProfil extends JFrame implements ActionListener{
 
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
	private JTextField textFieldLieu;
	/**
	 * C'est du texte qu'on va récuperer
	 */
	private JTextField textFieldheuredébut;
	/**
	 * C'est du texte qu'on va récuperer
	 */
	private JTextField textFieldheurefin;
	/**
	 * C'est du texte qu'on va afficher
	 */
	private JLabel labelNom;
	/**
	 * C'est du texte qu'on va afficher
	 */
	private JLabel labelheuredebut;
	/**
	 * C'est du texte qu'on va afficher
	 */
	private JLabel labelheurefin;
	/**
	 * C'est du texte qu'on va afficher
	 */
	private JLabel labelLieu;
	/**
	 *Ce bouton valide la création de profil
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
	 */
	public CréeProfil() {
		
		// on fixe le titre
		this.setTitle("Menu créer profil");
		// initialisation de la taille
		this.setSize(500, 500);
		
		
		
		this.setLocationRelativeTo(null);
		containerPanel = new JPanel();
		
		containerPanel.setLayout(new BoxLayout(containerPanel,BoxLayout.PAGE_AXIS));
		containerPanel.setBackground(Color.WHITE);
		this.setContentPane(containerPanel);
		//this.setVisible(true);
		
		textFieldNom = new JTextField();
		textFieldLieu = new JTextField();
		textFieldheuredébut = new JTextField();
		textFieldheurefin = new JTextField();
		//textFieldConnection = new JTextField();
		boutonValider = new JButton("Valider");
		
		
		
		
		labelNom = new JLabel("Nom :");
		labelheuredebut = new JLabel("Heure début :");
		labelheurefin = new JLabel("Heure fin  :");
		labelLieu = new JLabel("Mettre les lieux sous le format suivant lieu1/lieu2/lieu3...  :");
		
		//labelConnection = new JLabel(":");
		
		containerPanel.add(labelNom);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		containerPanel.add(textFieldNom);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

		containerPanel.add(labelLieu);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		containerPanel.add(textFieldLieu);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		
		containerPanel.add(labelheuredebut);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		containerPanel.add(textFieldheuredébut);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		
		containerPanel.add(labelheurefin);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		containerPanel.add(textFieldheurefin);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		
		containerPanel.add(boutonValider);
		
		boutonValider.addActionListener(this);
		boutonretour= new JButton("Retour");
		containerPanel.add(boutonretour);
		boutonretour.addActionListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Menu créer profil");
		this.setVisible(true);
		
		
	}
	/**
	 * Cette méthode attend que l'on apuis sur le bouton et éxécute des actions en fonction du bouton
	 * @ae
	 */
public void actionPerformed(ActionEvent ae) {
		
		try {
			
			if(ae.getSource() == boutonValider) {
				HubProg.CréeProfil2(textFieldNom.getText(),textFieldLieu.getText(),textFieldheuredébut.getText(),textFieldheurefin.getText());
				
			}else if (ae.getSource()== boutonretour){
				Menu Menu=new Menu();
				this.dispose();
			}
		}catch (Exception e) {
			
		}
}
	
}
