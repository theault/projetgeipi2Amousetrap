
public class veilleur extends Thread  {
	
	gameserver serveur;
	
	public veilleur (gameserver server){
		this.serveur=server;
	}
	
	public void run(){
		do{
		if (!serveur.getalive())
			serveur.clore();
		}while (serveur.getalive());
		
	}

}
