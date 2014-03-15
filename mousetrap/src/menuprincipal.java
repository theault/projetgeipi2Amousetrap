import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;


public class menuprincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuprincipal frame = new menuprincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});// THEAULT PUEra!!!!!
	}

	/**
	 * Create the frame.
	 */
	public menuprincipal() {
		setTitle("Mouse Trap");
		setBackground(new Color(220, 20, 60));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 517);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(6,1,10, 40));
		setContentPane(contentPane);
		
		JLabel lblMouseTrap = new JLabel("Mouse Trap");
		lblMouseTrap.setHorizontalAlignment(SwingConstants.CENTER);
		lblMouseTrap.setFont(new Font("Comic Sans MS", Font.BOLD, 46));
		lblMouseTrap.setForeground(Color.YELLOW);
		contentPane.add(lblMouseTrap);
		
		JButton play = new JButton("Play!!!");
		play.setBackground(Color.WHITE);
		contentPane.add(play);
		
		JButton optn = new JButton("Options");
		optn.setBackground(Color.WHITE);
		contentPane.add(optn);
		
		JButton credit = new JButton("Crédits");
		credit.setBackground(Color.WHITE);
		contentPane.add(credit);
		
		JButton quitter = new JButton("Quitter");
		quitter.setBackground(Color.WHITE);
		contentPane.add(quitter);
		
	}

}
