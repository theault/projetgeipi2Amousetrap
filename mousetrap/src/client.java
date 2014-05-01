import java.io.*; 
import java.net.*;


public class client 
{ 
  final static int taille = 1024; 
  final static byte buffer[] = new byte[taille];

  public static void main(String ip) throws Exception 
    { String données="wessssh";
      InetAddress serveur = InetAddress.getByName(ip); 
      while (!données.equals("end"))
      {int length = données.length(); 
      byte buffer[] = données.getBytes(); 
      DatagramPacket dataSent = new DatagramPacket(buffer,length,serveur,reseau1.port); 
      DatagramSocket socket = new DatagramSocket(); 
  
      socket.send(dataSent); 

      DatagramPacket dataRecieved = new DatagramPacket(new byte[length],length); 
      socket.receive(dataRecieved); 
      System.out.println("Data recieved : " + new String(dataRecieved.getData())); 
      System.out.println("From : " + dataRecieved.getAddress() + ":" + dataRecieved.getPort()); }
      données="end";
    } 
}