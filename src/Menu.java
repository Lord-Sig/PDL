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

public class Menu extends JFrame implements ActionListener {

	
	private static final long serialVersionUID = 1L;

	
	private JPanel containerPanel;
	
	private JButton boutonMenu;
	
	private JButton boutonMenu2;
	
	private JButton boutonMenu3;
	
	private JButton boutonMenu4;
	
	JTextArea zoneTextListConnection;

	//private JLabel labelConnection;

	JScrollPane zoneDefilement;
	
	public Menu() {
		
	

	this.setTitle("Menu principal");
	this.setSize(300, 200);
	
	this.setLocationRelativeTo(null);
	containerPanel = new JPanel();
	
	containerPanel.setLayout(new BoxLayout(containerPanel,BoxLayout.PAGE_AXIS));
	containerPanel.setBackground(Color.WHITE);
	this.setContentPane(containerPanel);
	
	boutonMenu = new JButton("Gerer profil");
	boutonMenu2 = new JButton("Gerer personne");
	boutonMenu3 = new JButton("Gerer badge");
	boutonMenu4 = new JButton("Gerer lieu");
	
	containerPanel.add(boutonMenu);
	containerPanel.add(boutonMenu2);
	containerPanel.add(boutonMenu3);
	containerPanel.add(boutonMenu4);
	
	boutonMenu.addActionListener(this);
	boutonMenu2.addActionListener(this);
	boutonMenu3.addActionListener(this);
	boutonMenu4.addActionListener(this);
	
	this.setTitle("Menu principal");
	this.setVisible(true);
	
	}
	public void actionPerformed(ActionEvent ae) {
		
	try {
			
			if(ae.getSource() == boutonMenu) {
			HubProg.gererProfil();
				
			}else if(ae.getSource() == boutonMenu2) {
				HubProg.gerePersonne();
			}else if(ae.getSource() == boutonMenu3) {
			HubProg.gereBadge();
					
					
			}else if(ae.getSource() == boutonMenu4) {
					
					
			}
	}catch (Exception e) {	
	}
	
	
	//public static void main(String[] args) {
	//	new Menu();
	//}
}
}
