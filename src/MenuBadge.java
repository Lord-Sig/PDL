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

	private HubProg Hub =new HubProg();
	
	private JPanel containerPanel;
	
	private JButton boutonMenu;
	
	private JButton boutonMenu2;
	
	private JTextArea zoneTextListConnection;

	private JScrollPane zoneDefilement;
	
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
	public void actionPerformed(ActionEvent ae) {
		
	try {
			
			if(ae.getSource() == boutonMenu) {
				Hub.creeBadge1();
			}else if(ae.getSource() == boutonMenu2) {
				Hub.supreBadge1();
			}
	
		
	} catch (Exception e) {
					
			
		}
		
	}
	

}
