import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class selectionProfilL2 extends JFrame implements ActionListener{
 
	private static final long serialVersionUID = 1L;
	
	private JPanel containerPanel;
	
	private JLabel label;
	
	private static int id;
	
	private JButton boutonValider;
	
	JTextArea zoneTextListConnection;

	//private JLabel labelConnection;

	JScrollPane zoneDefilement;
	
	public selectionProfilL2(int idprofil) {
		
		// on fixe le titre
		this.setTitle("Menu selection profil");
		// initialisation de la taille
		this.setSize(500, 500);
		
		
		
		this.setLocationRelativeTo(null);
		containerPanel = new JPanel();
		
		containerPanel.setLayout(new BoxLayout(containerPanel,BoxLayout.PAGE_AXIS));
		containerPanel.setBackground(Color.WHITE);
		this.setContentPane(containerPanel);
		//this.setVisible(true);
		//textFieldConnection = new JTextField();
		boutonValider = new JButton("Menu");
		
		ArrayList<Personne> listpers = new ArrayList<Personne>();
		listpers= Profildao.ListePersonneparProfil(idprofil);
		boutonValider.addActionListener(this);
		for (int i =0; i< listpers.size(); i=i+1) {
			label = new JLabel(listpers.get(i).getnom()+"  "+listpers.get(i).getprenom()+"   "+listpers.get(i).getfonction());
			
			containerPanel.add(label);
			containerPanel.add(Box.createRigidArea(new Dimension(0, 10)));  
		}
		containerPanel.add(boutonValider);
		
		boutonValider.addActionListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Menu modif profil");
		this.setVisible(true);
		
		
	}
public void actionPerformed(ActionEvent ae) {
		
		try {
			
			if(ae.getSource() == boutonValider) {
				HubProg.ListeProfil3();
				
			}else {
				
				
				}
		}catch (Exception e) {
			
		}
}
	
}