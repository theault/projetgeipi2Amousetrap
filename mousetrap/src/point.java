
public class point {
	
	int x;
	int y;
	
	public point (int x1, int y1){
		this.x=x1;
		this.y=y1;
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
