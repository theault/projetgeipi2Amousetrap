import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class paneloptions extends JPanel{
	
	displaymanager manager;
	JButton retour = new JButton ("Retour");
	JPanel retourct = new JPanel();
	JPanel temp = new JPanel ();
	
	public paneloptions (displaymanager managerbis)
	{
		this.manager = managerbis;
		this.setLayout(new BorderLayout());
		this.temp.setBackground (Color.BLACK);
		this.add(temp, BorderLayout.CENTER);
		this.retourct.setBackground(Color.BLACK);
		this.add(retourct , BorderLayout.SOUTH);
		
		this.retourct.add(retour);
		this.retour.setBackground(Color.WHITE);
		this.retour.addActionListener(new retour());
		
	}
		
		class retour implements ActionListener {
			public void actionPerformed(ActionEvent e)
			{
				manager.choixmenu(1);
			}
		

	}
	}


