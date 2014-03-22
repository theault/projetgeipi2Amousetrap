import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;


public class jeu extends Game {
    
	final int vitesse=1; // vitesse de la mouse
	BufferedImage Mouse;
	String urlfiletxt;
	File filetxt;
	String imagemouse;
	int fps;
	int xmouse, ymouse; 
	int haut,bas,droite,gauche;
	int direction;
	int nbrline;
    int nbrcolonnes;
	ArrayList <String> lignes = new ArrayList <String>();
	
	public void begin () {
		GameApplication.start(new jeu());

	}
	
	public jeu ()
	{  
		this.urlfiletxt="map1.txt"; //adresse du fichier texte contenant les 0 et 1 de la map
		this.filetxt= new File (this.urlfiletxt); // on recupere le fichier
		this.haut=KeyEvent.VK_UP; //  pour recuperer ce que vaut la touche fleche du dessus
		this.bas = KeyEvent.VK_DOWN;
		this.droite = KeyEvent.VK_RIGHT;
		this.gauche = KeyEvent.VK_LEFT;
		fps=0;
		xmouse=300;
		ymouse=300;
		inittab(); // lecutre du tableau
		//imagemouse= "wesh l'adresse
		/*try{
		Mouse=ImageIO.read(new File (imagemouse));
		} catch (IOException e){
			e.printStackTrace();
		}*/
		
	}
	
	
	public void inittab()
	{    nbrline=0;
	     nbrcolonnes =0;
		try {
			Scanner S = new Scanner (filetxt);
					while (S.hasNextLine())
							{
								lignes.add(S.nextLine());
							}
			S.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//test file
		nbrline = lignes.size(); 
		nbrcolonnes = lignes.get(0).length();
		System.out.println("le fichier texte contient : " + nbrline + "lignes "+  nbrcolonnes+ "colonnes");
		System.out.println("test recup valeur " + Valmap(0,1));
	}
	
	public void Keypressed (KeyEvent e) {
		int key = e.getKeyCode();
		if (key >36||key<41) // pour filtrer si la touche appuyer est bien la bonne 
			direction = key;
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

	
	
	private char Valmap (int ligne , int colonnes){
		return lignes.get(ligne).charAt(colonnes);
	}
	
	public void draw(Graphics2D g) {
		//g.drawImage(Mouse.getSubimage(fps*tailleimagex, (direction-37)*tailleperso, w, h), xmouse,ymouse, null);// pour afficher le sprite de la souris 
	}

}


/* deja faiit :
 * un putain de trucs de magiciens pour voir le gugusses QUI bouge, manque plus que l'images sprites
 * normalement l'orientation du sprite est deja faite
 * recuperation du fichier contenant les 0 et les 1 pour les colisions 
 * il faudrait recuperer la photo de la map*/
