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
		       try {
		    	   		sem.acquire();
		    	   		System.out.println("glouglouglou");
				        if (c1!= c2 || l1 != l2)
				        {
				        	dynamic [l1][c1]='0';
				        	dynamic [l1+1][c1]='0';
				        	dynamic [l1+1][c1+1]='0';
				        	dynamic [l1][c1+1]='0';
				        	dynamic [l2][c2]=c;
				        	dynamic [l2+1][c2]=c;
				        	dynamic [l2+1][c2+1]=c;
				        	dynamic [l2][c2+1]=c;
				        }
				        sem.release();
		       		} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	            
	}
	

	
}
