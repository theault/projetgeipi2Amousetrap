import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class jeu extends Game {

	BufferedImage Mouse;
	String imagemouse;
	
	public void begin () {
		GameApplication.start(new jeu());

	}
	
	public jeu ()
	{
		//imagemouse= "wesh l'adresse
		/*try{
		Mouse=ImageIO.read(new File (imagemouse));
		} catch (IOException e){
			e.printStackTrace();
		}*/
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics2D g) {
		g.drawImage(Mouse.getSubimage(x, y, w, h), 100,100,20,20, null);// pour afficher le sprite de la souris 
	}

}
