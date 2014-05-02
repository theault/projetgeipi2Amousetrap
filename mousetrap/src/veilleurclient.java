
public class veilleurclient extends Thread{
	
gameclient client;
	
	public veilleurclient (gameclient server){
		this.client=server;
	}
	
	public void run(){
		do{
		if (!client.getalive())
			client.Clore();
		}while (client.getalive());
		
	}

}
