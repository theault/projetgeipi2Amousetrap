
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;


public class games extends JPanel{
	
	map carte;
	Image image;
	
	public games ()
	{
	
		try {
			carte = new map("jaune.jpg", "1.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.image = carte.image;
		this.setBackground(Color.BLACK);
     }

	
	
	public void paintComponent(Graphics g) {
	      super.paintComponent(g);
	      g.drawImage(image, 0, 0,this);
	  }
}
