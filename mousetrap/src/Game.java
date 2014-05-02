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

import javax.swing.JFrame;

/**
 *
 * @author paul
 */
public abstract class Game implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {

	protected boolean over;
	protected String title = "MouseTrap";
	protected int width=606, height=678;
	protected int delay = 60;
	JFrame frame;
	public void init() {}
	abstract public void update();
	abstract public void draw(Graphics2D g);


	public boolean isOver() { return over; }
	public String getTitle() { return title; }
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	public int getDelay() { return delay; }
	public void resize(int width, int height) {}
    public JFrame recupframe(){return frame;}
    public void setframe (JFrame framebis){ this.frame = framebis;}
	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseDragged(MouseEvent e) {
	}

	public void mouseMoved(MouseEvent e) {
	}

	public void mouseWheelMoved(MouseWheelEvent e) {
	}

}
