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

public class ConnectionFen extends JFrame implements ActionListener{

	private HubProg Hub =new HubProg();
	
	private JPanel containerPanel;

	private JTextField textFieldIdentifiant;

	private JTextField textFieldMotDePasse;

	private JTextField textFieldConnection;
	
	private JLabel labelIdentifiant;

	private JLabel labelMotDePasse;
	
	private JButton boutonConnexion;
	
	JTextArea zoneTextListConnection;

	//private JLabel labelConnection;

	JScrollPane zoneDefilement;
	
	public ConnectionFen() {
		
		// on fixe le titre
		this.setTitle("Menu connection");
		// initialisation de la taille
		this.setSize(500, 300);
		
		
		
		this.setLocationRelativeTo(null);
		containerPanel = new JPanel();
		
		containerPanel.setLayout(new BoxLayout(containerPanel,BoxLayout.PAGE_AXIS));
		containerPanel.setBackground(Color.WHITE);
		this.setContentPane(containerPanel);
		//this.setVisible(true);
		
		textFieldIdentifiant = new JTextField();
		textFieldMotDePasse = new JTextField();
		//textFieldConnection = new JTextField();
		boutonConnexion = new JButton("Connexion");
		
		
		
		
		labelIdentifiant = new JLabel("Identifiant :");
		labelMotDePasse = new JLabel("Mot de passe :");
		//labelConnection = new JLabel(":");
		
		containerPanel.add(labelIdentifiant);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		containerPanel.add(textFieldIdentifiant);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		
		containerPanel.add(labelMotDePasse);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		containerPanel.add(textFieldMotDePasse);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		
		containerPanel.add(boutonConnexion);
		
		boutonConnexion.addActionListener(this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Menu connection administrateur");
		this.setVisible(true);
		
	}
	
	
	public void actionPerformed(ActionEvent ae) {
		
		try {
			
			if(ae.getSource() == boutonConnexion) {
			Hub.authentification(textFieldIdentifiant.getText(),textFieldMotDePasse.getText());
				
			
		}
		
		
		
		}catch (Exception e) {
			JOptionPane.showMessageDialog(this,
					"Veuillez saisir vos saisies", "Erreur",
					JOptionPane.ERROR_MESSAGE);
			System.err.println("Veuillez controler vos saisies");			
			
		}
		
	}
}
