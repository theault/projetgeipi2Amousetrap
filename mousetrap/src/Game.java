/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;


public abstract class Game implements KeyListener {
     
	fenetre frame;
	protected boolean over;
	protected int delay = 30;

	public void init() {
	}
	abstract public void update();
	abstract public void draw(Graphics2D g);


	public boolean isOver() { return over; }
	public int getDelay() { return delay; }
	public void resize(int width, int height) {}

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}



}
