//Les imports habituels
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
 
public class CreationBadge extends JFrame {
	/**
	 * le panel qui contien tout les items
	 */
  private JPanel container = new JPanel();
  /** l'item texte d'information 
   * 
   */
  private JLabel label = new JLabel("Badge créé");

  public CreationBadge(){
    this.setTitle("Animation");
    this.setSize(300, 75);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    container.setBackground(Color.white);
    container.setLayout(new BorderLayout());
    JPanel top = new JPanel();
    Font police = new Font("Arial", Font.BOLD, 14);
    top.add(label);
    container.add(top, BorderLayout.NORTH);
    this.setContentPane(container);
    this.setVisible(true); 
  }
  
	  
  }