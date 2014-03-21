import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;

import javax.swing.JPanel;



public class displaymanagergame  {

	fenetre fenetrejeu;
	GameApplication game;
	map carte;
	JPanel contgames = new JPanel();
	gestionnaire managergame;
	
	public displaymanagergame (fenetre frame1)
	{
		this.fenetrejeu =frame1;
	    this.managergame=new gestionnaire (this.fenetrejeu);
	    this.managergame.truc();
	}

}
