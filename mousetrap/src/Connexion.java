import java.io.*;
import java.net.*;

 public class Connexion extends Thread {
 static int port = 9999;
 Socket socket ;
reseauchat chat;

 
 
 public Connexion(String text) {
	 try {
			socket= new Socket(text, port);
			this.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 chat=new reseauchat();
	 chat.begin();
	 chat.changebool(true);
}


public void run() {
 
 BufferedReader sisr=null;
try {
	sisr = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
 PrintWriter sisw=null;
try {
	sisw = new PrintWriter(new BufferedWriter( new OutputStreamWriter(socket.getOutputStream())),true);
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
 
String str = "bonjour ";
 for (int i = 0; i < 100; i++) {
  
 sisw.println(str+i); // envoi d’un message
 try {
	str = sisr.readLine();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} // lecture de la reponse
 System.out.println(str);
 }
 
    //sisw.println("END") ;
     try {
		sisr.close();
		sisw.close();
		socket.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
	}
 
}
