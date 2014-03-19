import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JPanel;


public class upgrade extends JPanel {

	Image image;
	games game;
	Graphics2D g;
	
	public upgrade (Image image, games game )
	{
		this.image= image ;
		this.game=game;
	     this.setPreferredSize(new Dimension(20, 20));
     }
	
	
	public void paintComponent (Graphics2D g)
	{
		super.paintComponent(g);
		System.out.println ("prout");
	      g.drawImage(image, 0, 0,100,100, this);
	}
}
