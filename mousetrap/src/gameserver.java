import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;


public class gameserver extends Thread {
	
	private DatagramSocket socket;
	private reseaumouse mouse22;
	private int port = 9999;
	int recuprow, recupcol;
	int x,y;
	ArrayList <String> tabres = new ArrayList <String>(0);
	
	public gameserver (){
		mouse22=new reseaumouse(this);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		mouse22.begin();
		x=y=0;
			try {
				this.socket = new DatagramSocket(port);
			} catch (SocketException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}
	
	public void run ()
	{ System.out.println("serveur mis en route");
		while (true){
			byte[] data = new byte [1024];
			DatagramPacket packet = new DatagramPacket (data, data.length);
			try {
				socket.receive(packet);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String message =new String(packet.getData());
			/*System.out.println("CLIENT["+packet.getAddress()+" : "+packet.getPort()+"]>" +message);
			System.out.println("CLIENT" +message);*/
				//System.out.println("je retourne pong");
		    sendData (creationpacket().getBytes(), packet.getAddress(), packet.getPort());
			decode(message);
			//System.out.println("gameserve r\\\\__/////j'ai eu " + recuprow + " "+recupcol);
			mouse22.seta(recuprow);
			try {
				Thread.sleep (10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}
	}
	public void sendData (byte[]  data, InetAddress ipadress, int portbis) {
		DatagramPacket packet = new DatagramPacket (data, data.length, ipadress,portbis);
		try {
			this.socket.send(packet);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 
	public void decode (String data)
	{   //System.out.println("!!!!!!!!j'ai eu " +data);
		recuprow=100* Character.getNumericValue(data.charAt(0))+10* Character.getNumericValue(data.charAt(1))+Character.getNumericValue(data.charAt(2));
		recupcol=100* Character.getNumericValue(data.charAt(3))+10* Character.getNumericValue(data.charAt(4))+Character.getNumericValue(data.charAt(5));
	    
		//mouse22.pcatbefore=new point (mouse22.getb(),mouse22.geta());
		
		if (recuprow<=600 && recupcol<=600 && recuprow>=0 && recupcol>=0)
		{mouse22.seta(recuprow);
	    mouse22.setb(recupcol);}
	  //  mouse22.pcat=new point (mouse22.getb(),mouse22.geta());
		//System.out.println("/////j'ai eu " + recuprow + " "+recupcol);
		//mouse.resx=recupcol;
		//mouse.resy=recuprow;
		//System.out.println("j'ai eu " + mouse.resx+ " "+mouse.resy);
		//mouse22.setposmouse(recuprow, recupcol);
	   
	}
	
	public synchronized String creationpacket (){
		String str="";
		//System.out.println("la souris est à " +y + " "+x);
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
		 str=str+Integer.toString(mouse22.fps)+Integer.toString(mouse22.numerosprite)+Integer.toString(mouse22.direction);
		 //System.out.println(" je renvoies " +str);
		return str;
	}
}
