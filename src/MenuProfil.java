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

public class MenuProfil extends JFrame implements ActionListener {

	
	private static final long serialVersionUID = 1L;

	
	private JPanel containerPanel;
	
	private JButton boutonMenu;
	
	private JButton boutonMenu2;
	
	private JButton boutonMenu3;
	
	private JButton boutonMenu4;
	
	JTextArea zoneTextListConnection;

	JScrollPane zoneDefilement;
	
	public MenuProfil() {
		
	

	this.setTitle("Menu Profil");
	this.setSize(300, 200);
	
	this.setLocationRelativeTo(null);
	containerPanel = new JPanel();
	
	containerPanel.setLayout(new BoxLayout(containerPanel,BoxLayout.PAGE_AXIS));
	containerPanel.setBackground(Color.WHITE);
	this.setContentPane(containerPanel);
	
	boutonMenu = new JButton("Création profil");
	boutonMenu2 = new JButton("Modfier profil");
	boutonMenu3 = new JButton("Supression profil");
	boutonMenu4 = new JButton("Liste Persone par profil");
	
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
				
				
			}else if(ae.getSource() == boutonMenu2) {
				
			}else if(ae.getSource() == boutonMenu3) {
				
			}else if(ae.getSource() == boutonMenu4) {
				
			}
		
	
		
	} catch (Exception e) {
					
			
		}
		
	}
	

}
