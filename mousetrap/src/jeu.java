import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class jeu extends Game {
    
	final int vitesse=4; // vitesse de la mouse
	BufferedImage Mouse;
	BufferedImage map;
	BufferedImage gameover;
	BufferedImage souriswin;
	BufferedImage fromage;
	String urlfromage;
	BufferedImage chatimage;
	String urlchat;
	String urlfiletxt;
	String urlgameover;
	File filetxt;
	String urlimagemouse;
	String urlimagemap;
	String souriswinurl;
	int fps;
	int column, row; 
	int nbrows, nbrcolumn;
	int haut,bas,droite,gauche;
	int direction;
    int numerosprite;
    int score;
	ArrayList <String> lignes = new ArrayList <String>();
	cat chat;
	cat chat2;
	point avant;
	dynamicmanager mng;
	JPanel panel;
	Font f;
	
	public void begin () {
		GameApplication.start(new jeu());

	}
	
	public jeu ()
	{  
		panel= new JPanel();
		panel.setBackground(Color.BLACK);
		mng = new dynamicmanager();
		this.score=0;
		this.urlfiletxt="map1.txt"; //adresse du fichier texte contenant les 0 et 1 de la map
		this.filetxt= new File (this.urlfiletxt); // on recupere le fichier
		direction =0;
		fps=0;
		inittab(); // lecutre du tableau
		urlimagemouse= "stuart.gif";
		urlfromage="Fromage.gif";
		souriswinurl="souriswin.jpg";
		urlgameover="gameover.png";
		try{
			fromage=ImageIO.read(new File (urlfromage));
		} catch (IOException e){
									e.printStackTrace();
								}
		urlchat="chat.gif";
		try{
			chatimage=ImageIO.read(new File (urlchat));
		} catch (IOException e){
									e.printStackTrace();
								}
		souriswinurl="souriswin.jpg";
		try{
			souriswin=ImageIO.read(new File (souriswinurl));
		} catch (IOException e){
									e.printStackTrace();
								}
		try{
			gameover=ImageIO.read(new File (urlgameover));
		} catch (IOException e){
									e.printStackTrace();
								}
			try{
					Mouse=ImageIO.read(new File (urlimagemouse));
				} catch (IOException e){
											e.printStackTrace();
										}
		
		urlimagemap ="map-1.jpg";
		     try{
					 map=ImageIO.read(new File (urlimagemap));
				 } catch (IOException e){
				   		   					e.printStackTrace();}
			   	   				     
	chat = new cat (20,480,540,480,540,80,20,80,mng);
	chat2 = new cat (20,20,540,20,540,540,20,540,mng);
	chat.start();
	chat2.start();
	
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
								 avant=new point (column, row);
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
		if (mng.dead)
			direction=0;
	    if (direction==KeyEvent.VK_ENTER)
			{
				recupframe().dispose();
			}
			}
	
	public int getrow(){
		return row/20; // return le numero de la ligne ou se situe la souris (coord y)
	}

	public int getcolumn(){
		return column/20; // return le numero de la coloones ou se situe la souris (coord x)
	}
	
	
	@Override
	public void update() {
		if (mng.dead){
			chat.stop();
			chat2.stop();
		}
		fps++;  // regler la vitesse d'affichage
		if(fps>6)
			fps=0;
		
		mng.change(avant, new point (column,row), 'M');	
		avant.y=row;
		avant.x=column;
	 switch (direction ){
		
		case KeyEvent.VK_LEFT: //37
			if ( collision (row,column, row + 20, column, direction)==true)//value(Y,X-1)
			{   
				column-=vitesse;
			numerosprite =0;}
			break;
	 
		
	case KeyEvent.VK_RIGHT://38
		if (  collision (row,column + 20, row + 20, column + 20, direction)==true)
		{ column+=vitesse;
			numerosprite=1;}
			break;
			
	case KeyEvent.VK_UP://39
		if( collision (row,column, row + 20, column, direction)==true)
		{ row-=vitesse;
			numerosprite=3;}
			break;
		
	case KeyEvent.VK_DOWN://40
		if ( collision (row,column, row +20, column, direction)==true)//value(Y,X-1)
		{row+=vitesse;
			numerosprite =2;}
			break;
	case  0: break;
		
		}
	}

	
	private void change (int row1, int column1, char s) // methode pour remplacer un caractere dans le tablea!!!
	{
		String nv = lignes.get(row1);
		StringBuffer buffer = new StringBuffer(nv);
		buffer.setCharAt(column1, s);
	    nv = buffer.toString();
		lignes.set(row1, nv);
	}
	
	
	private char value(int row1, int  column1) {
		char a='1';
		if (row1>=0 && column1>=0){
		  a =lignes.get(row1).charAt(column1);
		//System.out.println("a la ligne : "+row1+" et à la colonne : "+column1+" j'ai une valeur de : " +a);
		  }
		else if (column1==30)
			a=lignes.get(row1).charAt(29);
		else if (row1==30)
			a=lignes.get(29).charAt(column1);
		else 
			a =lignes.get(0).charAt(0);	
		return a;
	}

	public void draw(Graphics2D g) {
		int empty = 0;
		
		recupframe().add(panel);
		recupframe().revalidate();
		g.drawImage(map, 0,0,null);
		g.drawImage(Mouse.getSubimage(fps*40 ,(numerosprite*60), 40, 40), column,row, null);// pour afficher le sprite de la souris 
		
		int i,j;//x,y de la map, on affiche les fromages
		g.setColor(Color.YELLOW);
		
		for (i=0; i<30; i++)//parcourt lignes
				{
					for (j=0; j<30;j++)//parcourt colonnes
						{
							if (value(i,j)=='F')
							{
								empty++;
								g.drawImage(fromage, j*20+10,i*20+10,null);
							  // g.fillOval(j*20+10, i*20, 20, 20); //provisoire
							}
						}
				}
		
		g.setColor(Color.RED);
		
		g.drawImage(chatimage.getSubimage(chat.getFps()*40 ,(chat.getNumerosprite()*40), 40, 40), chat.pcat.x,chat.pcat.y,null);
		g.drawImage(chatimage.getSubimage(chat2.getFps()*40 ,(chat2.getNumerosprite()*40), 40, 40), chat2.pcat.x, chat2.pcat.y,null);
	  /* g.fillRect(chat.pcat.x, chat.pcat.y, 40, 40);
		g.fillRect(chat2.pcat.x, chat2.pcat.y, 40, 40);*/
		
		if (empty==0)
		{
			g.drawImage(souriswin, 0,0,null);
			g.setColor(Color.RED);
			f = new Font("Comic Sans MS", Font.BOLD, 20);
			g.setFont(f);
			g.drawString("La souris win",400, 630);
			g.drawString("Press Enter to Quit",0, 630);
		}
		
		if (mng.dead && empty!=0)
			{g.drawImage(gameover, 150,150,null);
			g.setColor(Color.RED);
			f = new Font("Comic Sans MS", Font.BOLD, 20);
			g.setFont(f);
			g.drawString("Les chats gagnent",400, 630);
			g.drawString("Press Enter to Quit",0, 630);}
		
		g.setColor(Color.YELLOW);
		f = new Font("Comic Sans MS", Font.BOLD, 20);
		g.setFont(f);
		g.drawString(" Score : "+Integer.toString(score),260, 630);
	}



public boolean collision (int row1, int column1, int row2, int column2, int direction){
	
    boolean colision=false; 
    int y1=row1;
	int y2=row2;
	int x1=column1;
	int x2=column2;
	System.out.println(" colonnes 1 =" + column1);
	System.out.println(" colonnes 2 =" + column2);
	System.out.println(" ligne 1 =" + row1);
	System.out.println(" ligne 2 =" + row2);
	boolean case1=false ;
	boolean case2=false ;
	
	
	if (value (row1/20, column1/20)=='F'||value(row2/20,column2/20)=='F')
	{    
		change (row1/20, column1/20,'0');
		this.score+=100;
	}
    
	if (direction ==KeyEvent.VK_LEFT){ // à gauche
		
			row2+=10;
			row1+=5;
			y2=row2;
			y1=row1;
			x1=(x1-19)/20;
			x2=(x2-19)/20;
		
			if (value ((y1/20), (x1))=='1') 
				{    
					x1=(x1*20)+20;
					System.out.println(" x1= "+x1);
					x2=x1;
					case1=true;
				}
		
			if (case1)
				{
					x2=x2/20;
				}
		   
		   
			if (value ((y2/20), x2)=='1')
				{
					x2=(x2*20)+20;
					System.out.println("x2 = "+x2);
					x1=x2;
					case2=true;
				}
	   }
	
	
	else if (direction ==KeyEvent.VK_RIGHT){ // à gdroite
					System.out.println(" prout");
					row2+=10;
					row1+=5;
					y2=row2;
					y1=row1;
					x1=(x1+19)/20;
					x2=(x2+19)/20;
		
			if (value ((y1/20), (x1))=='1') 
				{    
					x1=(x1*20)-20;
					System.out.println(" x1= "+x1);
					x2=x1;
					case1=true;
				}
		
			if (case1)
	   			{
		   			x2=x2/20;
	   			}
		   
		   
			if (value ((y2/20), x2)=='1')
				{
					x2=(x2*20)-20;
					System.out.println("x2 = "+x2);
					x1=x2;
					case2=true;
				}
	   }
	
	
	else if (direction ==KeyEvent.VK_UP){ // en haut
		
		row2-=20;
		column2+=35;
		column1+=5;
		x1=column1;
		x2=column2;
		y2=row2;
		y1=(y1-19)/20;
		y2=(y2-19)/20;
	
		if (value ((y1), (x1/20))=='1') 
			{    
				y1=(y1*20)+20;
				System.out.println(" y1= "+y1);
				y2=y1;
				case1=true;
			}
	
		if (case1)
			{
				y2=y2/20;
			}
	   
	   
		if (value ((y2), x2/20)=='1')
			{
				y2=(y2*20)+20;
				System.out.println("y2 = "+y2);
				y1=y2;
				case2=true;
			}
   }
	
	else if (direction ==KeyEvent.VK_DOWN){ // en bas
		
		row2+=20;
		row1+=40;
		column2+=35;
		column1+=5;
		x1=column1;
		x2=column2;
		y1=row1;
		y2=row2;
		y1=(y1+19)/20;
		y2=(y2+19)/20;
		System.out.println(" colonnes 1 =" + column1);
		System.out.println(" colonnes 2 =" + column2);
		System.out.println(" ligne 1 =" + row1);
		System.out.println(" ligne 2 =" + row2);
		
		if (value (row1/20, column1/20)=='F'||value(row2/20,column2/20)=='F')
		{    
			change (row1/20, column1/20,'0');
			this.score+=100;
		}
	
		 if (value ((y1), (x1/20))=='1') 
			{    
				y1=(y1*20);
				System.out.println(" y1= "+y1);
				y2=y1;
				case1=true;
			}
	
		if (case1)
			{
				y2=y2/20;
			}
	   
	   
		if (value ((y2), x2/20)=='1')
			{
				y2=(y2*20);
				System.out.println("y2 = "+y2);
				y1=y2;
				case2=true;
			}
		
   }
	
	
	switch (direction){
	
	case KeyEvent.VK_LEFT:
		if (case1==false && case2==false)
			colision=true;
		else if (x1<column1 && x2<column2)
	    	{
				colision =true;
	    	}
		break;
		
	case KeyEvent.VK_RIGHT:
		if (case1==false && case2==false)
			colision=true;
		else if (x1>column1 && x2>column2)
	    	{
				colision =true;
	    	}
		break;
		
	case KeyEvent.VK_UP:
		if (case1==false && case2==false)
			colision=true;
		else if (y1<row1 && y2<row2)
	    	{
				colision =true;
	    	}
		break;
		
	case KeyEvent.VK_DOWN:
		if (case1==false && case2==false)
			colision=true;
		else if (y1>row1 && y2>row2)
	    	{
				colision =true;
	    	}
		break;
	}
	
	return colision;
}


}

