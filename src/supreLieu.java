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

public class supreLieu extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JPanel containerPanel;
	
	private JTextField textFieldNom;
	
	private JLabel labelNom;
	private JLabel labelAdresse;
	
	
	private JButton boutonModifier;
	
	public supreLieu() {
		
		
		// on fixe le titre		
		this.setTitle("Menu crée lieu");
		// initialisation de la taille
		this.setSize(500, 500);
		
		
		this.setLocationRelativeTo(null);
		containerPanel = new JPanel();
		
		containerPanel.setLayout(new BoxLayout(containerPanel,BoxLayout.PAGE_AXIS));
		containerPanel.setBackground(Color.WHITE);
		this.setContentPane(containerPanel);

		
		textFieldNom = new JTextField();
		
		labelNom = new JLabel("Nom du profil a modifier  :");
		labelAdresse = new JLabel("Adresse :");
		
		
		boutonModifier = new JButton("Modifier lieu");
		
		
		labelNom = new JLabel("Nouveau Nom :");
		containerPanel.add(labelNom);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		containerPanel.add(textFieldNom);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		
		containerPanel.add(boutonModifier);
		
		
		boutonModifier.addActionListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Menu modifier lieu");
		this.setVisible(true);
		
		
	}
	
	
public void actionPerformed(ActionEvent ae) {
		
		try {
			
			if(ae.getSource() == boutonModifier) {
				System.out.println("z");
			HubProg.supreLieu2(textFieldNom.getText());
		}
		
		
		
		}catch (Exception e) {
	
}
		
}
	
	
}