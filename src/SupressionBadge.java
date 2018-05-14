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

public class SupressionBadge extends JFrame implements ActionListener{
 
	private static final long serialVersionUID = 1L;
	
	/**
	 * containerPanel 
	 * Ce paremettre crée un panel pour contenir les objets
	 */
	private JPanel containerPanel;
	
	/**
	 * On a le texte que l'on va récupérer 
	 */
	private JTextField textFieldIdBadge;
	
	/**
	 * On a le texte que l'on va afficher
	 */
	private JLabel labelIdBadge;
	
	/**
	 * On a le bouton que l'on utilise pour validé la supréstion 
	 */
	private JButton boutonValider;
	
	JTextArea zoneTextListConnection;

	//private JLabel labelConnection;

	JScrollPane zoneDefilement;
	/**
	 *  constructeur 
	 */
	public SupressionBadge() {
		
		// on fixe le titre
		this.setTitle("Menu supression badge");
		// initialisation de la taille
		this.setSize(400, 150);
		
		
		
		this.setLocationRelativeTo(null);
		containerPanel = new JPanel();
		containerPanel.setLayout(new BoxLayout(containerPanel,BoxLayout.PAGE_AXIS));
		containerPanel.setBackground(Color.WHITE);
		this.setContentPane(containerPanel);
		//this.setVisible(true);
		
		textFieldIdBadge = new JTextField();
		
		boutonValider = new JButton("Valider la supression");
		
		
		
		
		labelIdBadge = new JLabel("Id Badge :");
		
		containerPanel.add(labelIdBadge);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		containerPanel.add(textFieldIdBadge);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		
		containerPanel.add(boutonValider);
		
		boutonValider.addActionListener(this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Menu supression badge");
		this.setVisible(true);
		
	}
	/**
	 * Cette fonction attend que l'on apuis sur le bouton
	 */
public void actionPerformed(ActionEvent ae) {
		
		try {
			
			if(ae.getSource() == boutonValider) {
				HubProg.supreBadge2(Integer.parseInt(textFieldIdBadge.getText()));
			}else {
				
				
				}
		}catch (Exception e) {
			
		}
		
}
}
