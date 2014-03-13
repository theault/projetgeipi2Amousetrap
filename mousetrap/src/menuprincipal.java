import java.awt.BorderLayout;
import java.awt.EventQueue;

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
		});// THEAULT PUE!!!!!
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
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblMouseTrap = new JLabel("Mouse Trap");
		lblMouseTrap.setHorizontalAlignment(SwingConstants.CENTER);
		lblMouseTrap.setFont(new Font("Comic Sans MS", Font.BOLD, 46));
		lblMouseTrap.setForeground(Color.YELLOW);
		contentPane.add(lblMouseTrap, BorderLayout.NORTH);
	}

}
