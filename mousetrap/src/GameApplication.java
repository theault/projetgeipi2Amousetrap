/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class GameApplication {
	
	

	public static void start(final Game game) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				fenetre frame = game.frame;
				//JPanel panel = new JPanel ();
				/*panel.setBackground(Color.BLACK);
				frame.add(panel);*/
				frame.setSize(606, 628);
				frame.setResizable(false);
				GameCanvas canvas = new GameCanvas();
				canvas.setGame(game);
				frame.add(canvas);
				canvas.requestFocus();
				new GameLoop(game, canvas).start();
				System.out.println("wesh");
			}
		});
	}
	
}
