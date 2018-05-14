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
	
	private JPanel containerPanel;

	private JTextField textFieldNom;
	
	private JLabel labelNom;
	
	private static int id;
	
	private JButton boutonValider;
	
	JTextArea zoneTextListConnection;

	//private JLabel labelConnection;

	JScrollPane zoneDefilement;
	
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
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Menu modif profil");
		this.setVisible(true);
		
		
	}
public void actionPerformed(ActionEvent ae) {
		
		try {
			
			if(ae.getSource() == boutonValider) {
				HubProg.ModifProfil2(textFieldNom.getText());
				
			}else {
				
				
				}
		}catch (Exception e) {
			
		}
}
public static int getID() {
	return id;
}
	
}
