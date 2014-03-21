import java.awt.Graphics2D;
import java.io.IOException;


public class gestionnaire extends Game {

	map carte;
    fenetre fenetrejeu;
	GameApplication game;
	
	public  void  truc ( )
	{
		 GameApplication.start(new gestionnaire (this.fenetrejeu));	
	}
	public gestionnaire (fenetre frame)
	{      
		   this.fenetrejeu= frame;

		try {
				carte = new map("map-1.jpg", "1.txt");
		    } catch (IOException e) {
		    							e.printStackTrace();
		    }
		
	}
	
	
	
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics2D g) {
		System.out.println("coucou les loulous");
	      g.drawImage(carte.image, 0, 0, fenetrejeu);
		
	}

}
