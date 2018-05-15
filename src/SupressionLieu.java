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

public class SupressionLieu extends JFrame implements ActionListener{
 
	private static final long serialVersionUID = 1L;
	
	private JPanel containerPanel;

	private JTextField textFieldNom;
	
	private JLabel labelNom;
	
	private JButton boutonSupprimer;
	
	JTextArea zoneTextListConnection;

	//private JLabel labelConnection;

	JScrollPane zoneDefilement;	
	
	public SupressionLieu() {
		
		// on fixe le titre
		this.setTitle("Menu supression lieu");
		// initialisation de la taille
		this.setSize(400, 150);
		
		
		
		this.setLocationRelativeTo(null);
		containerPanel = new JPanel();
		containerPanel.setLayout(new BoxLayout(containerPanel,BoxLayout.PAGE_AXIS));
		containerPanel.setBackground(Color.WHITE);
		this.setContentPane(containerPanel);
		//this.setVisible(true);
		
		textFieldNom = new JTextField();
		
		boutonSupprimer = new JButton("Valider la supression");
		
		
		
		
		labelNom = new JLabel("Nom lieu :");
		
		containerPanel.add(labelNom);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		containerPanel.add(textFieldNom);
		containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		
		containerPanel.add(boutonSupprimer);
		
		boutonSupprimer.addActionListener(this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Menu supression lieu");
		this.setVisible(true);
		
	}