import java.io.*;
import java.net.*;

 public class Connexion  {
 static int port = 9999;
 static Socket socket ;
static reseauchat chat;
static String temp;
 
 
public static void main(String text, reseauchat mchat) throws Exception {
	 
	chat=mchat;
    socket= new Socket(text, port);
    
	 chat.changebool(true);
   BufferedReader sisr;

	sisr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
 PrintWriter sisw;
	sisw = new PrintWriter(new BufferedWriter( new OutputStreamWriter(socket.getOutputStream())),true);

 

while (true) {
 //System.out.println("woullalalalalal");
 String str = "C";
 if (chat.row/100==0||chat.column/100==0){
	 
	 if (chat.row/100==0 && chat.column/100==0){
		 						temp = "0"+Integer.toString(chat.row);
		 						str = str+temp;
		 						temp = "0"+Integer.toString(chat.column);
		 						str = str+temp;
	 					 }
	 else if (chat.column/100==0 && chat.column/100!=0){
								temp = "0"+Integer.toString(chat.row);
								str = str+temp;
								str=str+Integer.toString(chat.column);
	 }
	 
	 else {
		 		str=str+Integer.toString(chat.row);
		 		temp = "0"+Integer.toString(chat.column);
				str = str+temp;
	 	  }
	 
 }
 
 else {
	 		str=str+Integer.toString(chat.row)+Integer.toString(chat.column);	
 }

 sisw.println(str); // envoi d’un message
 try {
	str = sisr.readLine();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} // lecture de la reponse
 //System.out.println(str);
 }
 
    
    /* try {
		sisr.close();
		sisw.close();
		socket.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
    
	}
 
}
