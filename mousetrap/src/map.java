
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
	
	public map (String url, String fichetxt)
	{
		this.file=url;
		this.toolkit = Toolkit.getDefaultToolkit();
		this.image = toolkit.getImage(url);
		this.Grille=new int [10][10];
		this.fichetxt=fichetxt;//fichier contenant la grille de 0 et de 1
		
	}
	
	public void inittab () throws IOException 
	{
		File fichier = new File (fichetxt);
		long taillefichier = fichier.length();
		lire = new BufferedReader (new FileReader (fichier));
		char a ;
		int i;
		int j;
				if (taillefichier <=99)
					{
						for ( i=0; i<=9; i++)
						{
								for (j=0; j<=9; j++)
									{
										a=(char)lire.read();
									     Grille[i][j]=Character.getNumericValue(a);
									}
						}
					}
		
		lire.close();	
    }
	

}
