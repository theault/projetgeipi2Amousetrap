
public class displaymanagergame {

	fenetre fenetrejeu;
	games contgames;
	
	
	public displaymanagergame (fenetre frame1)
	{
		this.fenetrejeu =frame1;
		this.fenetrejeu.setSize(606, 628);
		this.fenetrejeu.setResizable(false);
		this.contgames = new games();// panel qui va contenir tout le jeu 
		fenetrejeu.setContentPane(this.contgames); 
	}
}
