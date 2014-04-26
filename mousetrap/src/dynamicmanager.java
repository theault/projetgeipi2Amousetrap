import java.util.concurrent.Semaphore;


public class dynamicmanager {
    int jeton =1;
	char dynamic [][] = new char [30][30];
	Semaphore sem;
	
	public dynamicmanager (){
		init ();
         sem = new Semaphore(1);
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
	  System.out.println(" avant j'etait à " +c1+ " col "+l1+" lig , maintenant je suis à "+c2+ " col "+l2+" lig ");
		       try {
		    	   		sem.acquire();
		    	   		System.out.println("la lettre est " +c);
		    	   		System.out.println("glouglouglou");
				       
				        	dynamic [l1][c1]='1';
				        	dynamic [l1+1][c1]='1';
				        	dynamic [l1+1][c1+1]='1';
				        	dynamic [l1][c1+1]='1';
				        	dynamic [l2][c2]=c;
				        	dynamic [l2+1][c2]=c;
				        	dynamic [l2+1][c2+1]=c;
				        	dynamic [l2][c2+1]=c;
				      
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
	
	public void display () {
		System.out.println("--------------------------");
		for (int i =0; i<30;i++)
			{for(int j=0; j<30; j++)
				System.out.print(""+dynamic[i][j]);
			System.out.println("");}
		System.out.println("--------------------------");
		 sem.release();
	}
	
}
