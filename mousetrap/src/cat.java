import java.awt.event.KeyEvent;


public class cat extends Thread  {
	
	point p1;
	point p2;
	point p3;
	point p4;
	point test;
	point pcat;
	point tab [];

	public cat (int x1,int y1,int x2,int y2,int x3,int y3,int x4,int y4){
		
		p1=new point (x1,y1);
		p2=new point (x2,y2);
		p3=new point (x3,y3);
		p4=new point (x4,y4);
		tab = new point [5];
		tab[0]=p1;
		tab[1]=p2;
		tab[2]=p3;
		tab[3]=p4;
		tab[4]=p1;
	    pcat=new point (p1.x,p1.y);//point  courant du chat
	}
	
	public void run(){
		int i =0;
		while (true){
			 
			if (i<3)
				 i++;
			 else 
				 i--;
				System.out.println("coucoucocuicociciociiciccccedcd");
				
		for (int j =1; j<5;j++){
			while (different (pcat,tab[j])){
		    	try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				switch (inc(pcat, tab[j])){
				
				case 1 :  pcat.y+=4; 
					      break;
				case 2 :  pcat.y-=4; 
			      break;
				case 11 :  pcat.x+=4; 
			      break;
				case 12 :  pcat.x-=4; 
			      break;
			  }
		    }
		}
		
		for (int j =4; j>=0;j--){
			while (different (pcat,tab[j])){
		    	try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				switch (inc(pcat, tab[j])){
				
				case 1 :  pcat.y+=4; 
					      break;
				case 2 :  pcat.y-=4; 
			      break;
				case 11 :  pcat.x+=4; 
			      break;
				case 12 :  pcat.x-=4; 
			      break;
			  }
		    }
		}
	}
}
	
	public boolean different (point p1, point p2){
		if (p1.x==p2.x && p2.y==p1.y)
			 return false;
		else 
			return true;
	}
	
	public int inc (point p1, point p2)
	{
		if (p1.x==p2.x )
		     {
			    if (p2.y>p1.y)
			    	return 1; //il va falloir incrementer les y
			    else 
			    	return 2;//il va falloir decrementer les y
		     }
		else 
			{
				if (p2.x>p1.x)
					return 11; //il va falloir incrementer les x
				else 
		    		return 12;//il va falloir decrementer les x
			}
	
		}
}