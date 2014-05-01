   import java.io.*; 
	import java.net.*;
  //serveur
	class reseau1
	{ 
	  final static int port = 9999; 
	  final static int taille = 1024; 
	  final static byte buffer[] = new byte[taille];

	  public static void main(reseaumouse mousebis) throws Exception 
	    { reseaumouse mouse = new reseaumouse();
	      mouse=mousebis;
	      int i =1;
	      DatagramSocket socket = new DatagramSocket(port); 
	      while(true) 
	      { 
	        DatagramPacket data = new DatagramPacket(buffer,buffer.length); 
	        socket.receive(data); 
	        System.out.println(data.getAddress()+ "on a dedans " +new String(data.getData())); 
	        socket.send(data); 
	      } 
	    } 
	}

