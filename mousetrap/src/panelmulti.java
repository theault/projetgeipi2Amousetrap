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
JButton hote = new JButton ("Devenir h�te(MOUSE)");
JButton retour = new JButton ("retour");
JButton join = new JButton ("Rejoindre(CAT)!!");
displaymanager manager;
JLabel nom = new JLabel ("Adresse IP de l'h�te : ");
JTextField ip = new JTextField ("expl : 194.153.205.26 ");
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
	
		hote.setBackground(Color.WHITE);
		retour.setBackground(Color.WHITE);
		join.setBackground(Color.WHITE);
		
		ip.setPreferredSize(new Dimension(150, 30));
		rejoindre.add(nom);
		rejoindre.add(ip);
		rejoindre.add(join);
		
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
			manager.choixmenu(3);
		}

	}
	
	class serv implements ActionListener {
		public void actionPerformed(ActionEvent e)
		{  
		   gameserver socketserver;
	        socketserver = new gameserver ();
			socketserver.start();
			
		}

	}

	class multi implements ActionListener {
		public void actionPerformed(ActionEvent e)
		{   gameclient socketclient;
	        socketclient = new gameclient ( ip.getText());
			socketclient.start();
		}

	}
}
