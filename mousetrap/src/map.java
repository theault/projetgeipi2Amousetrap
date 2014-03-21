
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class map  {
	
	
	String file;
	Image image; 
	Toolkit toolkit;
	int Grille [][];
	BufferedReader lire ;
	String fichetxt;
	
	public map (String url, String fichetxt) throws IOException
	{
		this.file=url;
	     this.image = Toolkit.getDefaultToolkit().getImage(this.file);
		                    
		
		this.Grille=new int [10][10];
		this.fichetxt=fichetxt;//fichier contenant la grille de 0 et de 1
		
		inittab(); 
		test();
		
	}
	
	public void inittab () throws IOException 
	{   String chaine;
		File fichier = new File (fichetxt);
		lire = new BufferedReader (new FileReader (fichier));
		int i;
		int j;
		
		for (i=0;i<10; i++)
		{
			chaine=lire.readLine(); // on recupere chaque ligne du fichier
			for (j=0;j<10;j++)
			{
				Grille[i][j]=Character.getNumericValue(chaine.charAt(j));// on convertit chaque caractere de la ligne en valeur numérique
			}
		}
				
		lire.close();	
    }
	
	
	public void test ()
	{ int i,j; 
		for ( i=0; i<=9; i++)
		{
				for (j=0; j<=9; j++)
					{
						
					   System.out.print("  "+Grille[i][j]);
					}
				System.out.println();
		}
	}

}
