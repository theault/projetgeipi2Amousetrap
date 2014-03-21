import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class jeu extends Game {
    
	final int vitesse=1; // vitesse de la mouse
	BufferedImage Mouse;
	String imagemouse;
	int fps;
	int xmouse, ymouse; 
	int haut,bas,droite,gauche;
	int direction;
	
	public void begin () {
		GameApplication.start(new jeu());

	}
	
	public jeu ()
	{
		this.haut=KeyEvent.VK_UP; //  pour recuperer ce que vaut la touche fleche du dessus
		this.bas = KeyEvent.VK_DOWN;
		this.droite = KeyEvent.VK_RIGHT;
		this.gauche = KeyEvent.VK_LEFT;
		fps=0;
		xmouse=300;
		ymouse=300;
		//imagemouse= "wesh l'adresse
		/*try{
		Mouse=ImageIO.read(new File (imagemouse));
		} catch (IOException e){
			e.printStackTrace();
		}*/
		
	}
	
	
	public void Keypressed (KeyEvent e) {
		direction = e.getKeyCode();
	}

	@Override
	public void update() {
		fps++;  // regler la vitesse d'affichage
		if(fps>5)
			fps=0;
		
		switch (direction ){
		
		case KeyEvent.VK_LEFT: //37
			xmouse-=vitesse;
			break;
		
		case KeyEvent.VK_RIGHT://38
			xmouse+=vitesse;
			break;
		
		case KeyEvent.VK_UP://39
			ymouse-=vitesse;
			break;
		
		case KeyEvent.VK_DOWN://40
			xmouse+=vitesse;
			break;
			
		}
		
	}

	@Override
	
	
	
	public void draw(Graphics2D g) {
		g.drawImage(Mouse.getSubimage(fps*tailleimagex, (direction-37)*tailleperso, w, h), xmouse,ymouse, null);// pour afficher le sprite de la souris 
	}

}
