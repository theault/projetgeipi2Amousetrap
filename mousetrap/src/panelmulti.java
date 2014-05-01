import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;




public class panelmulti extends JPanel{
JButton hote = new JButton ("Devenir hôte");
JButton retour = new JButton ("retour");
JButton join = new JButton ("Rejoindre !!");
displaymanager manager;
JLabel nom = new JLabel ("Adresse IP de l'hôte : ");
JTextField ip = new JTextField ("expl : 194.153.205.26 ");
JTextField name = new JTextField ("Gustave... ");
JLabel pseudo = new JLabel ("Votre pseudo : ");
JPanel rejoindre;
JPanel fiche;
JPanel dessus;
int port =9999;


public panelmulti (displaymanager managerbis)
	{   rejoindre = new JPanel ();
		fiche = new JPanel ();
		dessus = new JPanel ();
		this.setBackground(Color.BLACK);
		rejoindre.setBackground(Color.BLACK);
		fiche.setBackground(Color.BLACK);
		dessus.setBackground(Color.BLACK);
		this.manager=managerbis;
		this.setLayout(new BorderLayout());
		nom.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		nom.setForeground(Color.YELLOW);
		pseudo.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		pseudo.setForeground(Color.YELLOW);
		hote.setBackground(Color.WHITE);
		retour.setBackground(Color.WHITE);
		join.setBackground(Color.WHITE);
		name.setPreferredSize(new Dimension(150, 30));
		ip.setPreferredSize(new Dimension(150, 30));
		rejoindre.add(nom);
		rejoindre.add(ip);
		rejoindre.add(join);
		fiche.add(pseudo);
		fiche.add(name);
		dessus.add(hote);
		dessus.add(retour);
		this.add(rejoindre, BorderLayout.SOUTH);
		this.add(dessus,BorderLayout.NORTH);
		this.add(fiche, BorderLayout.WEST);
		
		this.retour.addActionListener(new retour());
		this.join.addActionListener(new multi());
		this.hote.addActionListener(new serv());
	}


	class retour implements ActionListener {
		public void actionPerformed(ActionEvent e)
		{
			manager.choixmenu(1);
		}

	}
	
	class serv implements ActionListener {
		public void actionPerformed(ActionEvent e)
		{  boolean result = false;
			reseaumouse nem = new reseaumouse();
		    while (!result)
		    	result=nem.begin();
			reseau1 serv = new reseau1 ();
			try {
				serv.main(nem);
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}

	}

	class multi implements ActionListener {
		public void actionPerformed(ActionEvent e)
		{   boolean result= false;
			reseauchat nem = new reseauchat();
		    while (!result)
		    	result=nem.begin();
			client con = new client ();
			
			try {
				con.main(ip.getText());
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}

	}
}
