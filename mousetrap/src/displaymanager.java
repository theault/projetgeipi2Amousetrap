
public class displaymanager {
	
	fenetre fenetre1;
	panelmenu1 menuprincipal;
	
	public displaymanager (fenetre frame1, panelmenu1 menupp)
	{
		this.fenetre1=frame1;
		this.menuprincipal=menupp;
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
	}

}
