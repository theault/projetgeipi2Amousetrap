/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class GameApplication {

	public static void start(final Game game) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frame = new JFrame(game.getTitle());
				frame.setSize(game.getWidth(), game.getHeight());
				frame.setResizable(false);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				GameCanvas canvas = new GameCanvas();
				canvas.setGame(game);
				frame.add(canvas);
				frame.setVisible(true);
				canvas.requestFocus();
				game.setframe(frame);
				new GameLoop(game, canvas).start();
			}
		});
	}
}
