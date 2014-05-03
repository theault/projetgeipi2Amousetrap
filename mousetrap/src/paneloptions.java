import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;


public class paneloptions extends JPanel{
	
	displaymanager manager;
	JButton retour = new JButton ("Retour");
	JPanel retourct = new JPanel();
	JPanel temp = new JPanel ();
	JTextPane  regle = new JTextPane();
	
	public paneloptions (displaymanager managerbis)
	{
		this.manager = managerbis;
		this.setLayout(new BorderLayout());
		this.temp.setBackground (Color.BLACK);
		this.add(temp, BorderLayout.CENTER);
		this.retourct.setBackground(Color.BLACK);
		this.add(retourct , BorderLayout.SOUTH);
		
		SimpleAttributeSet style_normal = new SimpleAttributeSet();
		StyleConstants.setFontFamily(style_normal, "Comis sans ms");
		StyleConstants.setFontSize(style_normal, 14);
		Style defaut = regle.getStyle("default");
		Style style1 = regle.addStyle("style1", defaut);
		      StyleConstants.setFontFamily(style1, "Comic sans MS");
		Style style2 = regle.addStyle("style2", style1);
	      StyleConstants.setForeground(style2, Color.RED);
	      StyleConstants.setFontSize(style2, 25);
	      Style style3 = regle.addStyle("style3", style1);
	      StyleConstants.setForeground(style3, Color.GREEN);
	      StyleConstants.setFontSize(style3, 18);
		
		try {
			/*
			 * Récupération du style du document 
			 */
			StyledDocument doc = regle.getStyledDocument();
			
			/*
			 * Insertion d'une chaine de caractères dans le document
			 * insertString :
			 * 	position de départ dans le document (doc.getLength ajoute à la fin
			 *  texte à ajouter
			 *  style pour le texte à ajouter
			 */
			String regle1 = " 1 PLAYER:";
			String regle2 = "- Manges un maximum de fromages, sans te faire attraper ";
			String regle3 = "- Tu peux appuyer sur la touche Entrée à tous moments pour quitter la partie";
			String regle4 = " 2 PLAYERS:";
			String regle5 = "Lorsque tu joues en multijoueurs, tu peux incarner soit les chats, soit la souris. Deux types de personnages donc deux facons de jouer ;)";
			String regle6= " CHAT :";
			String regle7= "- Ton but est simple, attrape la souris avant qu'elle ne mange tous les fromages";
			String regle8 = " MOUSE";
			String regle9=  "- Ton objectif est de manger tous les fromages, sans te faire attraper ";
			String regle10= "- Tu peux appuyer sur la touche Entrée à tous moments pour quitter la partie";
			doc.insertString(doc.getLength(), regle1+"\n", style2);
			doc.insertString(doc.getLength(), regle2+"\n", style_normal);
			doc.insertString(doc.getLength(), regle3+"\n\n", style_normal);
			doc.insertString(doc.getLength(), regle4+"\n", style2);
			doc.insertString(doc.getLength(), regle5+"\n\n", style_normal);
			doc.insertString(doc.getLength(), regle6+"\n", style3);
			doc.insertString(doc.getLength(), regle7+"\n\n", style_normal);
			doc.insertString(doc.getLength(), regle8+"\n", style3);
			doc.insertString(doc.getLength(), regle9+"\n\n", style_normal);
			doc.insertString(doc.getLength(), regle10+"\n\n", style_normal);
		
		}
		catch (BadLocationException e) {
			e.printStackTrace();
		}
		
		this.add(regle);
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


