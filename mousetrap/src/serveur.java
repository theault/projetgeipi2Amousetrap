import java.io.*;
import java.net.*;

 public class serveur {
 
 static final int port = 9999;
 static int i =0;
 static reseaumouse mygame;
 static int recuprow=0;
 static int recupcolumn=0;
 
 public static void main(displaymanager mng) throws Exception {
	 mygame = new reseaumouse ();
	 mygame.begin(); 
	 mng.choixmenu(5);
 System.out.println ("coucoucouccijcjdjkcknjedc");
 
 ServerSocket s = new ServerSocket(port);
 Socket soc = s.accept();
 System.out.println ("coucoucouccijcjdjkcknjedc");
 
 BufferedReader sisr = new BufferedReader(new InputStreamReader(soc.getInputStream()));
 PrintWriter sisw = new PrintWriter( new BufferedWriter( new OutputStreamWriter(soc.getOutputStream())),true);

 
 while (true) {
 
 String str = sisr.readLine(); // lecture du message
 
 /*if (str.charAt(1)=='C') {*/
	recuprow= Character.getNumericValue(str.charAt(1))*100 + Character.getNumericValue(str.charAt(2))*10 + Character.getNumericValue(str.charAt(3)); 
	recupcolumn= Character.getNumericValue(str.charAt(4))*100 + Character.getNumericValue(str.charAt(5))*10 + Character.getNumericValue(str.charAt(6)); 
    System.out.println(""+recuprow+" "+recupcolumn);
 //}
 
 mygame.setposmouse(recuprow, recupcolumn);
 
 System.out.println("ECHO = " + str); // trace locale
 sisw.println(str); // renvoi d’un e;kcho
 }
 //sisr.close();
 //sisw.close();
// soc.close();
 }
 }
