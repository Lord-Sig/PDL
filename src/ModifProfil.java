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

public class ModifProfil extends JFrame implements ActionListener{
 
	private static final long serialVersionUID = 1L;
	/**
	 * Ce panel contient les objets
	 */
	private JPanel containerPanel;
	/**
	 * C'est du texte qu'on va r�cuperer
	 */
	private JTextField textFieldNom;
	/**
	 * C'est du texte qu'on va r�cuperer
	 */
	private JTextField textFieldLieu;
	/**
	 * C'est du texte qu'on va r�cuperer
	 */
	private JTextField textFieldheured�but;
	/**
	 * C'est du texte qu'on va r�cuperer
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
	 * C'est le bouton qui valida la modification 
	 */
	private JButton boutonValider;
	
	JTextArea zoneTextListConnection;

	//private JLabel labelConnection;

	JScrollPane zoneDefilement;
	/**
	 * Classe cr�ateur
	 */
	public ModifProfil() {
		
		// on fixe le titre
		this.setTitle("Menu cr�er profil");
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
		textFieldheured�but = new JTextField();
		textFieldheurefin = new JTextField();
		//textFieldConnection = new JTextField();
		boutonValider = new JButton("Valider");
		
		
		
		
		labelNom = new JLabel("Nom :");
		labelheuredebut = new JLabel("Heure d�but :");
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
		containerPanel.add(textFieldheured�but);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		
		containerPanel.add(labelheurefin);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		containerPanel.add(textFieldheurefin);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		
		containerPanel.add(boutonValider);
		
		boutonValider.addActionListener(this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Modif profil");
		this.setVisible(true);
		
		
	}
	/** 
	 * Cette m�thode attend que l'on apuis sur le bouton 
	 */
public void actionPerformed(ActionEvent ae) {
		
		try {
			
			if(ae.getSource() == boutonValider) {
				HubProg.ModifProfil3(textFieldNom.getText(),textFieldLieu.getText(),textFieldheured�but.getText(),textFieldheurefin.getText(),selectionProfil.getID());
				
			}else {
				
				
				}
		}catch (Exception e) {
			
		}
}

	
}