import java.io.*;
import java.net.*;

 public class Connexion extends Thread {
 static int port = 9999;
 Socket socket ;


 
 
 public Connexion(String text) {
	 try {
			socket= new Socket(text, port);
			this.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}


public void run() {
 System.out.println("SOCKET = " + socket);
 // illustration des capacites bidirectionnelles du flux
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
