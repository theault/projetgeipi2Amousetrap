import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;


public class gameserver extends Thread {
	
	private DatagramSocket socket;
	private reseaumouse mouse;
	private int port = 9999;
	int recuprow, recupcol;
	public gameserver (){
		mouse=new reseaumouse();
		mouse.begin();
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
		    sendData ("pong".getBytes(), packet.getAddress(), packet.getPort());
			decode(message);
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
	    //System.out.println("/////j'ai eu " + recuprow + " "+recupcol);
		//mouse.resx=recupcol;
		//mouse.resy=recuprow;
		//System.out.println("j'ai eu " + mouse.resx+ " "+mouse.resy);
		mouse.setposmouse(recuprow, recupcol);
	   
	}
}
