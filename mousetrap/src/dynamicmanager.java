import java.util.concurrent.Semaphore;


public class dynamicmanager {
    int jeton =1;
	char dynamic [][] = new char [30][30];
	Semaphore sem;
	boolean dead;
	
	public dynamicmanager (){
		init ();
         sem = new Semaphore(1);
         dead=false;
	}

	private void init() {
		for (int i =0; i<30;i++)
			for (int j=0; j<30;j++ )
				dynamic[i][j]='0';
	   }
	
	public void change (point avant, point now, char c)
	{ int c1 = avant.x/20;
	  int c2 = now.x/20;
	  int l1 = avant.y/20;
	  int l2 = now.y/20;
	  System.out.println(" avant j'etait � " +c1+ " col "+l1+" lig , maintenant je suis � "+c2+ " col "+l2+" lig ");
		       try {
		    	   		sem.acquire();
		    	   		System.out.println("la lettre est " +c);
		    	   		System.out.println("glouglouglou");
				       
				        	dynamic [l1][c1]='0';
				        	dynamic [l1+1][c1]='0';
				        	dynamic [l1+1][c1+1]='0';
				        	dynamic [l1][c1+1]='0';
				        	dynamic [l2][c2]=c;
				        	dynamic [l2+1][c2]=c;
				        	dynamic [l2+1][c2+1]=c;
				        	dynamic [l2][c2+1]=c;
				        	verif(l2,c2,c);
				      if (dead)
				    	  System.out.println("MoOOOOOOOOOOOOOOOOOOOOOOOOOOPOOOOOOOOOOOOOOooooooooooooooooooooooooooooooooooooooooORT");
				        System.out.println("--------------------------");
						for (int i =0; i<30;i++)
							{for(int j=0; j<30; j++)
								System.out.print(""+dynamic[i][j]);
							System.out.println("");}
						System.out.println("--------------------------");
						 sem.release();
				       
		       		} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	            
	}
	
	public void verif (int l2, int c2, char c) {
		if (c=='M')
		{
		    if (dynamic[l2-1][c2]=='X'||dynamic[l2-1][c2+1]=='X'||dynamic[l2][c2+2]=='X'||dynamic[l2+1][c2+2]=='X'||dynamic[l2+2][c2]=='X'||dynamic[l2+2][c2+1]=='X'||dynamic[l2][c2-1]=='X'||dynamic[l2+1][c2-1]=='X')
		             dead=true;
		}
		else if (c=='X')
		{
			 if (dynamic[l2-1][c2]=='M'||dynamic[l2-1][c2+1]=='M'||dynamic[l2][c2+2]=='M'||dynamic[l2+1][c2+2]=='M'||dynamic[l2+2][c2]=='M'||dynamic[l2+2][c2+1]=='M'||dynamic[l2][c2-1]=='M'||dynamic[l2+1][c2-1]=='M')
	             dead=true;
		}
	}
	
}
