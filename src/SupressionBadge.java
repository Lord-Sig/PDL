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
	
	private HubProg Hub =new HubProg();
	
	private JPanel containerPanel;

	private JTextField textFieldIdBadge;
	
	private JLabel labelIdBadge;
	
	private JButton boutonValider;
	
	private JTextArea zoneTextListConnection;

	//private JLabel labelConnection;

	private JScrollPane zoneDefilement;
	
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
	
public void actionPerformed(ActionEvent ae) {
		
		try {
			
			if(ae.getSource() == boutonValider) {
				Hub.supreBadge2(Integer.parseInt(textFieldIdBadge.getText()));
			}else {
				
				
				}
		}catch (Exception e) {
			
		}
		
}
}
