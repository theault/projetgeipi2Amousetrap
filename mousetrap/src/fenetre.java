import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;


public class fenetre extends JFrame {
	
	public panelmenu1 menupp ;

	
	public fenetre (){
		
			this.setVisible(true);
			this.setTitle("Mouse Trap");
			this.setBackground(new Color(220, 20, 60));
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setBounds(100, 100, 635, 517);
			this.menupp= new panelmenu1(this); 
			this.setContentPane(this.menupp);
            this.repaint();
            this.revalidate();
			
		
		}

}
