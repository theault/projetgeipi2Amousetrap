import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JPanel;


public class upgrade {

	Image image;
	games game;
	Graphics2D g;
	
	public upgrade (Image image, games game )
	{
		this.image= image ;
		this.game=game;
		//this.paintComponent(g);
     }
	
	
	public void paintComponent (Graphics2D g)
	{
		System.out.println ("prout");
	      g.drawImage(image, 0, 0,100,100, game);
	}
}
