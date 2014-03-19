
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;


public class games extends JPanel{
	
	map carte;
	Image image;
	upgrade cool;
	
	public games ()
	{
	
		try {
			carte = new map("map-1.jpg", "map1.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.image = carte.image;
		this.setBackground(Color.BLACK);
		this.cool = new upgrade (this.image, this);
		this.setPreferredSize(new Dimension(600, 600));
		this.add(cool);
     }

	
	
	public void paintComponent(Graphics g) {
	      super.paintComponent(g);
	      g.drawImage(image, 0, 0,getWidth(), getHeight(), this);
	      
	  }
}
