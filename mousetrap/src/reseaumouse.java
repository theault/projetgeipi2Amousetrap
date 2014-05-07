
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;




public class reseaumouse extends Game {
    
	final int vitesse=4; // vitesse de la mouse
	BufferedImage Mouse;
	BufferedImage map;
	BufferedImage gameover;
	BufferedImage catwinimage;
	BufferedImage souriswin;
	BufferedImage fromage;
	String urlfromage;
	BufferedImage chatimage;
	String urlfiletxt;
	String urlgameover;
	File filetxt;
	String urlimagemouse;
	String urlimagemap;
	String catwin;
	String souriswinurl;
	int fps;
	int column, row; 
	int nbrows, nbrcolumn;
	int direction;
    int numerosprite;
    int score;
	ArrayList <String> lignes = new ArrayList <String>();
	boolean val1,val2;
	boolean colcat =false;
	dynamicmanager mng;
	private int a;
	private int b;
	 gameserver server;
	JPanel panel;
	Font f;
	private int directcat;
	String urlchat;
	int fpscat;
	int numerospritecat;

	
	public void begin () {
		GameApplication.start(this);
	}
	
	public reseaumouse (gameserver serverbis)
	{   
		fpscat=numerospritecat=0;
		directcat=0;
		panel= new JPanel();
		panel.setBackground(Color.BLACK);
		val1=val2=false;
		server=serverbis;
		mng = new dynamicmanager();
		urlfromage="Fromage.gif";
		this.score=0;
		this.catwin="chatwin.jpg";
		this.urlfiletxt="map1.txt"; //adresse du fichier texte contenant les 0 et 1 de la map
		this.filetxt= new File (this.urlfiletxt); // on recupere le fichier
		direction =0;
		fps=0;
		inittab(); // lecutre du tableau
		urlimagemouse= "stuart.gif";
		urlgameover="gameover.png";
		
		
		urlchat="chat.gif";
		try{
			chatimage=ImageIO.read(new File (urlchat));
		} catch (IOException e){
									e.printStackTrace();
								}
		
		souriswinurl="souriswin.jpg";
		
		try{
			fromage=ImageIO.read(new File (urlfromage));
		} catch (IOException e){
									e.printStackTrace();}
								
		
		try{
			souriswin=ImageIO.read(new File (souriswinurl));
		} catch (IOException e){
									e.printStackTrace();
								}
		
		try{
			catwinimage=ImageIO.read(new File (catwin));
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
		      
		val1=true;
		
	}
	
	
	public int getDirectcat() {
		return directcat;
	}

	public void setDirectcat(int directcat) {
		this.directcat = directcat;
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
		
								 //System.out.println("je m'initialise à : " + row/20 + " lignes et "+column/20+ " colonnes");
								}
								if (line.contains("4")){
									 a =A*20;
									 b= line.indexOf("4")*20;
									 System.out.println("le chat : je m'initialise à : " + a/20 + " lignes et "+b/20+ " colonnes");
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
		val2=true;
	}
	
	
	@Override 
	public void keyPressed (KeyEvent e){
	     int key = e.getKeyCode();
		if (key>36 && key <41)
			direction = key;
		if (mng.dead)
			direction=0;
		else if (key==KeyEvent.VK_ENTER)
			{
			   recupframe().dispose();
			   server.setalive(false);
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
		server.x=column;
		server.y=row;
		
		fps++;  // regler la vitesse d'affichage
		if(fps>6)
			fps=0;
		
		fpscat++;  // regler la vitesse d'affichage
		if(fpscat>2)
			fpscat=0;
		//System.out.println("test la valeur de a est de "+ this.a+ "et pour "+this.b);
		
		 switch (directcat ){
			
			case KeyEvent.VK_LEFT: //37
				   numerospritecat =1;
					break;
		 
			
		case KeyEvent.VK_RIGHT://38
			    numerospritecat=2;
				break;
				
		case KeyEvent.VK_UP://39
			    numerospritecat=3;
				break;
			
		case KeyEvent.VK_DOWN://40
				 numerospritecat =0;
				 break;
				 
		case  0: break;
			
			}
		
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
	
	 if (val1 && val2)
		 colisionwithcat();	
	 

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
    public int getx (){
    	return this.column;
    }
    public int gety (){
    	return this.row;
    }
	public void draw(Graphics2D g) {
		int empty=0;
		recupframe().add(panel);
		recupframe().revalidate();
		
		if (!mng.dead ||!colcat)
	   {g.drawImage(map, 0,0,null);
		g.drawImage(Mouse.getSubimage(fps*40 ,(numerosprite*60), 40, 40), column,row, null);// pour afficher le sprite de la souris 
		g.drawImage(chatimage.getSubimage(fpscat*40 ,(numerospritecat*40), 40, 40),b,a,null);}
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
								//g.fillOval(j*20+10, i*20+10, 20, 20); //provisoire
							}
						}
				}
		g.setColor(Color.RED);
		//System.out.println("test dans affichage " +a+" "+b);
	    //g.fillRect(b, a, 40, 40);}
		
		if (empty==0)
		{
			g.drawImage(souriswin, 0,0,null);
			g.setColor(Color.RED);
			f = new Font("Comic Sans MS", Font.BOLD, 20);
			g.setFont(f);
			g.drawString("La souris win",400, 630);
			g.drawString("Press Enter to Quit",0, 630);
		}
		
		if (mng.dead ||colcat)
		 {  
			server.setalive(false);
		    //recupframe().revalidate();
			g.setColor(Color.RED);
			f = new Font("Comic Sans MS", Font.BOLD, 20);
			g.setFont(f);
			g.drawString("Les chats gagnent",400, 630);
			g.drawString("Press Enter to Quit",0, 630);
			g.drawImage(catwinimage, 0,0,null);
			}
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
	/*System.out.println(" colonnes 1 =" + column1);
	System.out.println(" colonnes 2 =" + column2);
	System.out.println(" ligne 1 =" + row1);
	System.out.println(" ligne 2 =" + row2);*/
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
					//System.out.println(" x1= "+x1);
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
					//System.out.println("x2 = "+x2);
					x1=x2;
					case2=true;
				}
	   }
	
	
	else if (direction ==KeyEvent.VK_RIGHT){ // à gdroite
					//System.out.println(" prout");
					row2+=10;
					row1+=5;
					y2=row2;
					y1=row1;
					x1=(x1+19)/20;
					x2=(x2+19)/20;
		
			if (value ((y1/20), (x1))=='1') 
				{    
					x1=(x1*20)-20;
					//System.out.println(" x1= "+x1);
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
					//System.out.println("x2 = "+x2);
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
				//System.out.println(" y1= "+y1);
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
				//System.out.println("y2 = "+y2);
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
		/*System.out.println(" colonnes 1 =" + column1);
		System.out.println(" colonnes 2 =" + column2);
		System.out.println(" ligne 1 =" + row1);
		System.out.println(" ligne 2 =" + row2);*/
		
		if (value (row1/20, column1/20)=='F'||value(row2/20,column2/20)=='F')
		{    
			change (row1/20, column1/20,'0');
			this.score+=100;
		}
	
		 if (value ((y1), (x1/20))=='1') 
			{    
				y1=(y1*20);
				//System.out.println(" y1= "+y1);
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
				//System.out.println("y2 = "+y2);
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

/*public synchronized void setposmouse (int recuprow, int recupcolumn){
	temp=new point(pcat.x,pcat.y);
	//System.out.println ("////////on m a envoyé "+recuprow+" "+recupcolumn);
	if (recuprow<=600 && recuprow>=0 &&recupcolumn<=600 && recupcolumn>=0 )
	{  this.a=recupcolumn;
	   b=recuprow;
	}
	System.out.println ("///////////on m a envoyé "+a+" "+b);
	//mng.change(pcatbefore, pcat , 'X');
}*/
public void seta(int abis){
	this.a=abis;
	//System.out.println("la valeur de a est " +this.a);
}
public int geta (){
	return this.a;
}

public void setb(int abis){
	this.b=abis;
	//System.out.println("la valeur de a est " +this.a);
}
public int getb (){
	return this.b;
}

public void colisionwithcat (){
	if (a==row)
	{if (Math.abs(column+40-b)<40||Math.abs(column-b)<40)
		{colcat=true;
		//System.out.println("la souris est à "+row+" & "+column+" le chat est a "+a+" & "+b);
		//System.out.println("!!!!!!!!!!!!!!!!!!!!attention collision avec chatttt !!!!!!!!!!!!!!!!!!!!!!!");
		}}
	
	else if (b==column)
	{
		if(Math.abs(row-a)<40||Math.abs(row+40-a)<40)
		{colcat=true;
		//System.out.println("la souris est à "+row+" & "+column+" le chat est a "+a+" & "+b);
		//System.out.println("!!!!!!!!!!!!!!!!!!!!attention collision avec chatttt !!!!!!!!!!!!!!!!!!!!!!!");
		}
	}
}

}

