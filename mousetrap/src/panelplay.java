import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;




public class panelplay extends JPanel{
	
	displaymanager manager;
	JPanel choix;
	JPanel image;

	JButton retour = new JButton ("Retour");
	JButton Single = new JButton ("Single Player");
	JButton multi = new JButton ("Multiplayer");
	
	
	public panelplay (displaymanager managerbis)
	{
		this.manager = managerbis;
		choix = new JPanel ();
		image = new JPanel();
		this.setLayout(new BorderLayout());
		this.add(choix, BorderLayout.SOUTH);
		this.add(image, BorderLayout.CENTER);
		
		
	  
		choix.add( retour);
		choix.add( Single);
		choix.add( multi);
		
		image.setBackground (Color.BLACK);
		
		 retour.setBackground(Color.WHITE);
		 Single.setBackground(Color.WHITE);
		 multi.setBackground(Color.WHITE);
		 
		 this.retour.addActionListener(new retour());
			
			
			
		}
		
		class retour implements ActionListener {
			public void actionPerformed(ActionEvent e)
			{
				manager.choixmenu(1);
			}
		
	}
	

}
