import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;


public class gameclient extends Thread {


	private InetAddress ipadress;
	private DatagramSocket socket;
	private reseauchat chat33;
	private int port = 9999;
	int x,y;
	int recuprow,recupcol;
	private boolean alive;
	veilleurclient Veilleur;

	
	public gameclient (String ipAddress){
		
		alive=true;
		
		Veilleur=new veilleurclient(this);
		Veilleur.start();
		chat33=new reseauchat(this);
		x=y=5;
		try {
			this.socket = new DatagramSocket();
			try {
				
				this.ipadress=InetAddress.getByName(ipAddress);
			} catch (UnknownHostException e) {
				System.out.println("probleme connexion");
				e.printStackTrace();
			}
		} catch (SocketException e) {
			System.out.println("probleme connexion");
			e.printStackTrace();
		}
		
	}
	
	public void run ()
	{   
		chat33.begin();
		System.out.println("client rejoinds la partie");
		sendData("begin".getBytes());
		while (alive){
			
			byte[] data = new byte [1024];
			DatagramPacket packet = new DatagramPacket (data, data.length);
			try {
				socket.receive(packet);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			String message =new String(packet.getData());
			/*System.out.println("SERVER> "+message);
			System.out.println("SERVER2222> "+creationpacket());
			 System.out.println(" je renvoies " +creationpacket());*/
			sendData(creationpacket().getBytes());
			decode(message);
			//System.out.println("gameclient \\\\__/////j'ai eu " + recuprow + " "+recupcol);
			try {
				Thread.sleep (0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void sendData (byte[]  data) {
		DatagramPacket packet = new DatagramPacket (data, data.length, ipadress, port);
		try {
			socket.send(packet);
		} catch (IOException e) {
			System.out.println("probleme envoie");
			e.printStackTrace();
		}
	}
	
	public synchronized String creationpacket (){
		String str="";
		//System.out.println("le chat est à " +y + " "+x);
		String temp;
		 if (y/100==0||x/100==0){
			 
			 if (y/100==0 && x/100==0){
				 						temp = "0"+Integer.toString(y);
				 						str = str+temp;
				 						temp = "0"+Integer.toString(x);
				 						str = str+temp;
			 					 }
			 else if (y/100==0 && x/100!=0){
										temp = "0"+Integer.toString(y);
										str = str+temp;
										str=str+Integer.toString(x);
			 }
			 
			 else {
				 		str=str+Integer.toString(y);
				 		temp = "0"+Integer.toString(x);
						str = str+temp;
			 	  }
			 
		 }
		 
		 else {
			 		str=str+Integer.toString(y)+Integer.toString(x);	
		 }
		 //System.out.println(" je renvoies " +str);
		return str;
	}
	
	public void decode (String data)
	{   //System.out.println("!!!!!!!!j'ai eu " +data);
		recuprow=100* Character.getNumericValue(data.charAt(0))+10* Character.getNumericValue(data.charAt(1))+Character.getNumericValue(data.charAt(2));
		recupcol=100* Character.getNumericValue(data.charAt(3))+10* Character.getNumericValue(data.charAt(4))+Character.getNumericValue(data.charAt(5));
		
		if (recuprow<=600 && recupcol<=600 && recuprow>=0 && recupcol>=0)
		{chat33.setfps(Character.getNumericValue(data.charAt(6)));
		chat33.seta(recuprow);
	    chat33.setb(recupcol);
	    chat33.setnumerosprite(Character.getNumericValue(data.charAt(7)));
	    chat33.setdirectmousee(Character.getNumericValue(data.charAt(8))*10+Character.getNumericValue(data.charAt(9)));}
	   
	}
	
	public void setalive (boolean alive) {this.alive=alive;}
	public boolean getalive () {return this.alive;}
	
	public void Clore ()  { 
		socket.close() ;
	System.out.println("client deconnecté");}
	
}
