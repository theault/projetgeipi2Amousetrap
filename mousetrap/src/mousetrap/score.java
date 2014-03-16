package mousetrap;

public class score {
	
	int compte ;
	
	
	public score () 
	{
	     initscore();
	}
	
	public void initscore ()
	{
		this.compte=0;
	}
	
	synchronized void incscore (fromage cheese)//surement à changer
	{
		this.compte= compte + cheese.getvaleur();
	}
	
	
	public int getscore()
	{
		return this.compte;
	}

}
