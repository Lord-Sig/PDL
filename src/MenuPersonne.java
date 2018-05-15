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

public class MenuPersonne extends JFrame implements ActionListener {

	
	private static final long serialVersionUID = 1L;

	/**
	 * Ce panel contient les objets
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
	 * bouton retour menu
	 */	
	private JButton boutonretour;
	
	
	JTextArea zoneTextListConnection;
	

	JScrollPane zoneDefilement;
	/**
	 * classe constructeur
	 */
	public MenuPersonne() {
		
	

	this.setTitle("Menu personne");
	this.setSize(300, 200);
	
	this.setLocationRelativeTo(null);
	containerPanel = new JPanel();
	
	containerPanel.setLayout(new BoxLayout(containerPanel,BoxLayout.PAGE_AXIS));
	containerPanel.setBackground(Color.WHITE);
	this.setContentPane(containerPanel);
	
	boutonMenuPers = new JButton("Créer personne");
	//boutonMenuPers2 = new JButton("Sélectionner personne");
	boutonMenuPers2 = new JButton("Modifier personne");
	boutonMenuPers3 = new JButton("Supprimer personne");
	boutonMenuPers4 = new JButton("liste les personnes");
	
	
	containerPanel.add(boutonMenuPers);
	//containerPanel.add(boutonMenuPers2);
	containerPanel.add(boutonMenuPers2);
	containerPanel.add(boutonMenuPers3);
	containerPanel.add(boutonMenuPers4);
	
	
	boutonMenuPers.addActionListener(this);
	//boutonMenuPers2.addActionListener(this);
	boutonMenuPers2.addActionListener(this);
	boutonMenuPers3.addActionListener(this);
	boutonMenuPers4.addActionListener(this);
	
	boutonretour= new JButton("Retour");
	containerPanel.add(boutonretour);
	boutonretour.addActionListener(this);
	
	this.setTitle("Menu personne");
	this.setVisible(true);
	
	}
	
	/**
	 * Cette méthode attend que l'on apuis sur le bouton et éxécute des actions en fonction du bouton
	 */
	public void actionPerformed(ActionEvent ae) {
		
		try {
				
				if(ae.getSource() == boutonMenuPers) {
					HubProg.creePersonne1();
				}else if (ae.getSource() == boutonMenuPers2){
					HubProg.modifPersonne1();
					
				}else if (ae.getSource()== boutonMenuPers3){					
					HubProg.suprefPersonne1();
				}else if (ae.getSource()== boutonMenuPers4){					
					HubProg.ListePersonne();
				}else if (ae.getSource()== boutonretour){
					Menu Menu=new Menu();
					this.dispose();
				}
						
		}catch (Exception e) {	
		}
	}
	
}