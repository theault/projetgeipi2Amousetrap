import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class panelmenu1 extends JPanel{

	JButton play = new JButton("Play!!!");
	JButton optn = new JButton("Options");
	JButton credits = new JButton("Crédits");
	JButton quitter = new JButton("Quitter");
	JLabel nomjeu = new JLabel ("Mouse trap");
	displaymanager manager ;
	
	public panelmenu1 (displaymanager managerbis)
	
	{
		this.manager=managerbis;
		GridLayout grille = new GridLayout (6,1,0,40);
		
		this.setLayout(grille);
		this.setBackground(Color.BLACK);
		
		nomjeu.setFont(new Font("Comic Sans MS", Font.BOLD, 46));
		nomjeu.setForeground(Color.YELLOW);
		nomjeu.setHorizontalAlignment(SwingConstants.CENTER);
		play.setBackground(Color.WHITE);
		optn.setBackground(Color.WHITE);
		credits.setBackground(Color.WHITE);
		quitter.setBackground(Color.WHITE);
		
		this.quitter.addActionListener(new quit ());
		this.credits.addActionListener(new credit ());
		this.play.addActionListener(new play ());
		this.optn.addActionListener(new options ());
		
		
		
	this.add(nomjeu);
		this.add(play);
		this.add(optn);
	this.add(credits);
	this.add(quitter);
		
		}
	
	 
	class quit implements ActionListener {
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}
	
	class credit implements ActionListener {
		public void actionPerformed(ActionEvent e)
		{
			manager.choixmenu(2); 
		}
	}
	

	class play implements ActionListener {
		public void actionPerformed(ActionEvent e)
		{
			manager.choixmenu(3); 
		}
	}
	

	class options implements ActionListener {
		public void actionPerformed(ActionEvent e)
		{
			manager.choixmenu(4); 
		}
	}
	
}
