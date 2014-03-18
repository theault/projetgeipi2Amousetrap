
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;


public class games extends JPanel{
	
	map carte;
	Image image;
	
	public games (){
	
		carte = new map("1.jpg", "1.txt");
		this.image = carte.image;
                    }

	 public void paintComponent(Graphics g) {
	      super.paintComponent(g);
	      g.drawImage(image, 0, 0, this);
	  }
}
