
public class mousetrap {

	public static void main(String[] args) {
		fenetre fenetrepp= new fenetre();
		panelmenu1 menuprincipal =new  panelmenu1();
		displaymanager manager1= new displaymanager (fenetrepp, menuprincipal);//generation du controleur qui va gérer tous les affichages
	}

}
