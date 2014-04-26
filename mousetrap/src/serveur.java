import java.io.*;
import java.net.*;

 public class serveur {
 
 static final int port = 9999;
 static int i =0;
 static jeu mygame;
 
 public static void main(displaymanager mng) throws Exception {
	 mygame = new jeu (1);
	 mygame.begin(); 
	 mng.choixmenu(5);
 System.out.println ("coucoucouccijcjdjkcknjedc");
 
 ServerSocket s = new ServerSocket(port);
 Socket soc = s.accept();
 System.out.println ("coucoucouccijcjdjkcknjedc");
 
 BufferedReader sisr = new BufferedReader(new InputStreamReader(soc.getInputStream()));
 PrintWriter sisw = new PrintWriter( new BufferedWriter( new OutputStreamWriter(soc.getOutputStream())),true);

 
 while (true) {
 
 i++;
 String str = sisr.readLine(); // lecture du message
 if (str.equals("END")) break;
 System.out.println("ECHO = " + str); // trace locale
 sisw.println(str); // renvoi d’un e;kcho
 }
 sisr.close();
 sisw.close();
 soc.close();
 }
 }
