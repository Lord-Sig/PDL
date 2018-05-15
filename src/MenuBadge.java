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

public class MenuBadge extends JFrame implements ActionListener {

	
	private static final long serialVersionUID = 1L;

	/**
	 * Le panel qui contient les objets
	 */
	private JPanel containerPanel;
	/**
	 * C'est le bouton qui va a Création Badge
	 */
	private JButton boutonMenu;
	/**
	 * C'est le bouton qui va a Supression Badge
	 */
	private JButton boutonMenu2;
	/**
	 * bouton retour menu
	 */	
	private JButton boutonretour;
	
	
	JTextArea zoneTextListConnection;

	JScrollPane zoneDefilement;
	/**
	 * classe constructeur
	 */
	public MenuBadge() {
		
	

	this.setTitle("Menu Badge");
	this.setSize(300, 200);
	
	this.setLocationRelativeTo(null);
	containerPanel = new JPanel();
	
	containerPanel.setLayout(new BoxLayout(containerPanel,BoxLayout.PAGE_AXIS));
	containerPanel.setBackground(Color.WHITE);
	this.setContentPane(containerPanel);
	
	boutonMenu = new JButton("Création Badge");
	boutonMenu2 = new JButton("Supression Badge");
	
	containerPanel.add(boutonMenu);
	containerPanel.add(boutonMenu2);
	
	
	boutonMenu.addActionListener(this);
	boutonMenu2.addActionListener(this);
	
	this.setTitle("Menu Badge");
	this.setVisible(true);
	
	}
	/**
	 * Cette fonction attend qu'on apuis sur le bouton et va vers crée personne modif personne ou supre personne
	 */
	public void actionPerformed(ActionEvent ae) {
		
	try {
			
			if(ae.getSource() == boutonMenu) {
				HubProg.creeBadge1();
			}else if(ae.getSource() == boutonMenu2) {
				HubProg.supreBadge1();
			}else if (ae.getSource()== boutonretour){
				Menu Menu=new Menu();
				this.dispose();
			}
	
		
	} catch (Exception e) {
					
			
		}
		
	}
	

}
