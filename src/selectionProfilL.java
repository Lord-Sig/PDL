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

public class selectionProfilL extends JFrame implements ActionListener{
 
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
	 * C'est du texte qu'on va afficher
	 */
	private JLabel labelNom;
	/**
	 * id de la personne chosi
	 */
	private static int id;
	/**
	 * C'est le bouton qui valide la selection du profil
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
	public selectionProfilL() {
		
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
		this.setTitle("Menu Profil");
		this.setVisible(true);
		
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
				id=HubProg.ListeProfil2(textFieldNom.getText());
				
			}else if (ae.getSource()== boutonretour){
				Menu Menu=new Menu();
				this.dispose();
			}
		}catch (Exception e) {
			
		}
}
/**
 * retourne l'id du profil choisi
 * @return id
 */
public  int getId () {
	return id;
}
}

	