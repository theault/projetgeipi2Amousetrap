
public class displaymanager {
	
	fenetre fenetre1;
	panelmenu1 menuprincipal;
	panelcredits menucredits;
	
	public displaymanager (fenetre frame1)
	{
		this.fenetre1=frame1;
		this.menuprincipal= new panelmenu1(this);
		this.menucredits=new panelcredits(this);
		choixmenu(1);
		fenetre1.setVisible(true);
	}
	
	public void choixmenu (int i)
	{
		if (i==1)
		{
			fenetre1.setContentPane(menuprincipal);
			fenetre1.repaint();
			fenetre1.revalidate();
		}
		
		else if (i==2)
		{
			fenetre1.setContentPane(menucredits);
			fenetre1.repaint();
			fenetre1.revalidate();
		}
			
	}

}
