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

public class menuLieu extends JFrame implements ActionListener {

	
	private static final long serialVersionUID = 1L;
	/**
	 * containerPanel 
	 * Ce paremettre crée un panel pour contenir les objets
	 */
	private JPanel containerPanel;
	/**
	 *bouton
	 */
	private JButton boutonMenuPers;
	/**
	 *bouton
	 */
	private JButton boutonMenuPers2;


	/**
	 * bouton
	 */	
	private JButton boutonMenuPers3;
	/**
	 * bouton
	 */	
	private JButton boutonMenuPers4;
	/**
	 * bouton
	 */	
	private JButton boutonretour;
	
	
	JTextArea zoneTextListConnection;
	

	JScrollPane zoneDefilement;
	/**
	 * classe constructeur
	 */
	public menuLieu() {
		
	

	this.setTitle("Menu lieu");
	this.setSize(300, 200);
	
	this.setLocationRelativeTo(null);
	containerPanel = new JPanel();
	
	containerPanel.setLayout(new BoxLayout(containerPanel,BoxLayout.PAGE_AXIS));
	containerPanel.setBackground(Color.WHITE);
	this.setContentPane(containerPanel);
	
	boutonMenuPers = new JButton("Créer Lieu");
	//boutonMenuPers2 = new JButton("Sélectionner personne");
	boutonMenuPers2 = new JButton("Modifier Lieu");
	boutonMenuPers3 = new JButton("Supprimer Lieu");
	
	
	containerPanel.add(boutonMenuPers);
	//containerPanel.add(boutonMenuPers2);
	containerPanel.add(boutonMenuPers2);
	containerPanel.add(boutonMenuPers3);
	
	boutonretour= new JButton("Retour");
	containerPanel.add(boutonretour);

	
	
	boutonMenuPers.addActionListener(this);
	//boutonMenuPers2.addActionListener(this);
	boutonMenuPers2.addActionListener(this);
	boutonMenuPers3.addActionListener(this);
	boutonretour.addActionListener(this);
	
	this.setTitle("Menu Lieu");
	this.setVisible(true);
	
	}
	
	/**
	 * Cette méthode attend que l'on apuis sur le bouton et éxécute des actions en fonction du bouton
	 */
	public void actionPerformed(ActionEvent ae) {
		
		try {
				
				if(ae.getSource() == boutonMenuPers) {
					HubProg.CréeLieu();
				}else if (ae.getSource() == boutonMenuPers2){
					HubProg.ModifLieu();
				}else if (ae.getSource()== boutonMenuPers3){
					HubProg.supreLieu	();
				}else if (ae.getSource()== boutonretour){
					Menu Menu=new Menu();
					this.dispose();
				}
				
			
						
		}catch (Exception e) {	
		}
	}
	
}