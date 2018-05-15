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
	/**
	 * containerPanel 
	 * Ce paremettre crée un panel pour contenir les objets
	 */
	private JPanel containerPanel;
	/**
	 * C'est du texte qu'on va récuperer
	 */
	private JTextField textFieldNom;
	/**
	 * On a le texte que l'on va afficher
	 */
	private JLabel labelNom;
	/**
	 * bouton
	 */	
	private JButton boutonModifier;
	/**
	 * bouton
	 */	
	private JButton boutonretour;
	/**
	 * classe constructeur
	 */
	public supreLieu() {
		
		
		// on fixe le titre		
		this.setTitle("Menu supprimer lieu");
		// initialisation de la taille
		this.setSize(500, 500);
		
		
		this.setLocationRelativeTo(null);
		containerPanel = new JPanel();
		
		containerPanel.setLayout(new BoxLayout(containerPanel,BoxLayout.PAGE_AXIS));
		containerPanel.setBackground(Color.WHITE);
		this.setContentPane(containerPanel);

		
		textFieldNom = new JTextField();
		
		
		boutonModifier = new JButton("supprimer lieu");
		
		
		labelNom = new JLabel(" Nom du lieu a suprimer:");
		containerPanel.add(labelNom);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		containerPanel.add(textFieldNom);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		
		containerPanel.add(boutonModifier);
		
		
		boutonModifier.addActionListener(this);
		boutonretour= new JButton("Retour");
		containerPanel.add(boutonretour);
		boutonretour.addActionListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Menu supprimer lieu");
		this.setVisible(true);
		
		
	}
	
	/**
	 * Cette méthode attend que l'on apuis sur le bouton et éxécute des actions en fonction du bouton
	 */
public void actionPerformed(ActionEvent ae) {
		
		try {
			
			if(ae.getSource() == boutonModifier) {
				System.out.println("z");
			HubProg.supreLieu2(textFieldNom.getText());
		}else if (ae.getSource()== boutonretour){
			Menu Menu=new Menu();
			this.dispose();
		}
		
		
		
		}catch (Exception e) {
	
}
		
}
	
	
}