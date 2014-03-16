import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;




public class panelcredits  extends JPanel{
	
	displaymanager manager;
	JButton retour= new JButton ("retour") ;
	JLabel auteur1= new JLabel ("Titouan VERDU");
	JLabel auteur2 = new JLabel ("Théault GARRIDO");
	CardLayout c1 = new CardLayout ();
	
	
	public panelcredits ( displaymanager managerbis)
	{   
		this.manager=managerbis;
		JPanel generique = new JPanel ();
		JPanel bouton = new JPanel();
	   
	    BorderLayout grille = new BorderLayout (); 
	    this.setLayout(grille);
	    this.add(generique, BorderLayout.CENTER);
	    this.add(bouton, BorderLayout.SOUTH);
	    generique.setBackground (Color.BLACK);
	    GridLayout grille2= new GridLayout(2,1);
	    generique.setLayout(grille2);
	    bouton.setLayout(c1);
	    
	    generique.add(auteur1);
	    auteur1.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		auteur1.setForeground(Color.YELLOW);
		auteur1.setHorizontalAlignment(SwingConstants.CENTER);
		
		generique.add(auteur2);
	    auteur2.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		auteur2.setForeground(Color.YELLOW);
		auteur2.setHorizontalAlignment(SwingConstants.CENTER);
		
		bouton.add(retour);
        retour.setBackground(Color.WHITE);
        this.retour.addActionListener(new retour());
		
		
		
	}
	
	class retour implements ActionListener {
		public void actionPerformed(ActionEvent e)
		{
			manager.choixmenu(1);
		}
	

}}
