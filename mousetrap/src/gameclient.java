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
	
	public gameclient (String ipAddress){
		chat33=new reseauchat(this);
		x=y=0;
		try {
			this.socket = new DatagramSocket();
			try {
				this.ipadress=InetAddress.getByName(ipAddress);
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void run ()
	{  chat33.begin();
		System.out.println("client rejoinds la partie");
		while (true){
			System.out.println("i am at " +x+ " "+y);
			byte[] data = new byte [1024];
			DatagramPacket packet = new DatagramPacket (data, data.length);
			try {
				socket.receive(packet);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String message =new String(packet.getData());
			System.out.println("SERVER> "+message);
			System.out.println("SERVER2222> "+creationpacket());
			sendData(creationpacket().getBytes());
			try {
				Thread.sleep (10);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String creationpacket (){
		String str="";
		System.out.println("le chat est à " +y + " "+x);
		String temp;
		 if (y/100==0||x/100==0){
			 
			 if (y/100==0 && x/100==0){
				 						temp = "0"+Integer.toString(y);
				 						str = str+temp;
				 						temp = "0"+Integer.toString(x);
				 						str = str+temp;
			 					 }
			 else if (x/100==0 && y/100!=0){
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
		 System.out.println(" je renvoies " +str);
		return str;
	}
}
