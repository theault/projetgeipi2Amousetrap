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
	int column, row; 
	int nbrows, nbrcolumn;
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
		
		urlimagemouse= "stuart.gif";
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
	{    column=0;
	     row =0;
		try { 
			int A=0;
			Scanner S = new Scanner (filetxt);
					while (S.hasNextLine())
							{   
								String line=S.nextLine();
								lignes.add(line);
								if (line.contains("5")){
								 row =A*20;
								 column = line.indexOf("5")*20;
								 System.out.println("je m'initialise à : " + row/20 + " lignes et "+column/20+ " colonnes");
								}
								 A++;
								   }
		   
			S.close();
		} catch (FileNotFoundException e) {
												e.printStackTrace();
										  }
		
		//test file
		nbrows = lignes.size(); 
		nbrcolumn = lignes.get(0).length();
		System.out.println("le fichier texte contient : " + nbrows + "lignes "+  nbrcolumn+ "colonnes");
		//System.out.println("test recup valeur " + Valmap(0,1));
	}
	
	
	@Override 
	public void keyPressed (KeyEvent e){
		int key = e.getKeyCode();
		if (key>36 && key <41)
			direction = key;
	}
	
	public int getrow(){
		return row/20; // return le numero de la ligne ou se situe la souris (coord y)
	}

	public int getcolumn(){
		return column/20; // return le numero de la coloones ou se situe la souris (coord x)
	}
	@Override
	public void update() {
		fps++;  // regler la vitesse d'affichage
		if(fps>6)
			fps=0;
		
	 switch (direction ){
		
		case KeyEvent.VK_LEFT: //37
			column-=vitesse;
			numerosprite =0;
			break;
	 
		
	case KeyEvent.VK_RIGHT://38
			
		    column+=vitesse;
			numerosprite=1;
			break;
			
	case KeyEvent.VK_UP://39
		
		  row-=vitesse;
			numerosprite=3;
			break;
		
	case KeyEvent.VK_DOWN://40
		row+=vitesse;
			numerosprite =2;
			break;
			
		}
		
	 if (column<0)
		 column=0;
	 else  if (column >560-vitesse)
		 column=(560-vitesse);
	 else if (row<0)
		 row=0;
	 else if (row >560-vitesse)
		 row=(560-vitesse);// à revoir petit pb
	}

	
	
	
	public void draw(Graphics2D g) {
		
		g.drawImage(map, 0,0,null);
		g.drawImage(Mouse.getSubimage(fps*40 ,(numerosprite*60), 40, 40), column,row, null);// pour afficher le sprite de la souris 
	}

}


/* deja faiit :
 * un putain de trucs de magiciens pour voir le gugusses QUI bouge, manque plus que l'images sprites
 * normalement l'orientation du sprite est deja faite
 * recuperation du fichier contenant les 0 et les 1 pour les colisions 
 * il faudrait recuperer la photo de la map*/
