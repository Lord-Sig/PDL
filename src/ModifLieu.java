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

public class ModifLieu extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JPanel containerPanel;
	
	private JTextField textFieldNom;
	private JTextField textFieldAdresse;
	
	private JLabel labelNom;
	private JLabel labelAdresse;
	
	
	private JButton boutonModifier;
	
	public ModifLieu() {
		
		
		// on fixe le titre		
		this.setTitle("Menu modifier lieu");
		// initialisation de la taille
		this.setSize(500, 500);
		
		
		this.setLocationRelativeTo(null);
		containerPanel = new JPanel();
		
		containerPanel.setLayout(new BoxLayout(containerPanel,BoxLayout.PAGE_AXIS));
		containerPanel.setBackground(Color.WHITE);
		this.setContentPane(containerPanel);

		
		textFieldNom = new JTextField();
		textFieldAdresse = new JTextField();
		
		labelNom = new JLabel("Nom :");
		labelAdresse = new JLabel("Adresse :");
		
		
		boutonModifier = new JButton("Modifier lieu");
		
		containerPanel.add(labelNom);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		containerPanel.add(textFieldNom);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		
		containerPanel.add(labelAdresse);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		containerPanel.add(textFieldAdresse);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		
		containerPanel.add(boutonModifier);
		
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Menu modifier lieu");
		this.setVisible(true);
		
		
	}
	
	
public void actionPerformed(ActionEvent ae) {
		
		try {
			
			if(ae.getSource() == boutonModifier) {
			
		}
		
		
		
		}catch (Exception e) {
	
}
		
}

public static void main(String[] args) {
	new ModifLieu();
}
	
	
}
