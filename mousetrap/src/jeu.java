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
    
	final int vitesse=3; // vitesse de la mouse
	BufferedImage Mouse;
	BufferedImage map;
	String urlfiletxt;
	File filetxt;
	String urlimagemouse;
	String urlimagemap;
	int fps;
	int lines, colonnes; 
	int nbrlines, nbrcolumn;
	int haut,bas,droite,gauche;
	int direction;
    int numerosprite;
	ArrayList <String> lignes = new ArrayList <String>();
	
	public void begin () {
		GameApplication.start(new jeu());

	}
	
	public jeu ()
	{  
		this.urlfiletxt="map1.txt"; //adresse du fichier texte contenant les 0 et 1 de la map
		this.filetxt= new File (this.urlfiletxt); // on recupere le fichier
		
		/*this.haut=KeyEvent.VK_UP; //  pour recuperer ce que vaut la touche fleche du dessus
		this.bas = KeyEvent.VK_DOWN;
		this.droite = KeyEvent.VK_RIGHT;
		this.gauche = KeyEvent.VK_LEFT;*/
		direction =0;
		fps=0;
		inittab(); // lecutre du tableau
		
		urlimagemouse= "stuart.jpg";
		try{
		Mouse=ImageIO.read(new File (urlimagemouse));
		} catch (IOException e){
			e.printStackTrace();
		}
		
		urlimagemap ="map-1.jpg";
				   try{
					   	map=ImageIO.read(new File (urlimagemap));
				   	   } catch (IOException e){
				   		   							e.printStackTrace();
				   	   						   }
		
	}
	
	
	public void inittab()
	{    lines=0;
	     colonnes =0;
	     String line;
		try { 
			int A=0;
			Scanner S = new Scanner (filetxt);
					while (S.hasNextLine())
							{   
								line=S.nextLine();
								lignes.add(line);
								if (line.contains("5")){
								 lines =A*20;
								 colonnes = line.indexOf("5")*20;
								}
								 A++;
								   }
		   
			S.close();
		} catch (FileNotFoundException e) {
												e.printStackTrace();
										  }
		
		//test file
		nbrlines = lignes.size(); 
		nbrcolumn = lignes.get(0).length();
		System.out.println("le fichier texte contient : " + nbrlines + "lignes "+  nbrcolumn+ "colonnes");
		System.out.println("test recup valeur " + Valmap(0,1));
	}
	
	public int getcolumn(){
		return (colonnes/20);
	}
	
	public int getline(){
		return (lines/20);
	}
	
	@Override 
	public void keyPressed (KeyEvent e){
		int key = e.getKeyCode();
		if (key>36 && key <41)
			direction = key;
	}

	@Override
	public void update() {
		fps++;  // regler la vitesse d'affichage
		if(fps>6)
			fps=0;
		
	 switch (direction ){
		
		case KeyEvent.VK_LEFT: //37
			if (Valmap())
			lines-=vitesse;
			numerosprite =0;
			break;
	 
		
	case KeyEvent.VK_RIGHT://38
			lines+=vitesse;
			numerosprite=1;
			break;
			
	case KeyEvent.VK_UP://39
			colonnes-=vitesse;
			numerosprite=3;
			break;
		
	case KeyEvent.VK_DOWN://40
			colonnes+=vitesse;
			numerosprite =2;
			break;
			
		}
		
	 if (lines<0)
		 lines=0;
	 else  if (lines >width-40-vitesse)
		 lines=(width-40-vitesse);
	 else if (colonnes<0)
		 colonnes=0;
	 else if (colonnes >height-40-vitesse)
		 colonnes=(height-40-vitesse);// à revoir petit pb
	}

	
	
	private char Valmap (int ligne , int colonnes){
		return lignes.get(ligne).charAt(colonnes);
	}
	
	public void draw(Graphics2D g) {
		
		g.drawImage(map, 0,0,null);
		g.drawImage(Mouse.getSubimage(fps*40 ,numerosprite*40, 40, 40), lines,colonnes, null);// pour afficher le sprite de la souris 
	}

}


/* deja faiit :
 * un putain de trucs de magiciens pour voir le gugusses QUI bouge, manque plus que l'images sprites
 * normalement l'orientation du sprite est deja faite
 * recuperation du fichier contenant les 0 et les 1 pour les colisions 
 * il faudrait recuperer la photo de la map*/
