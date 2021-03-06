import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class PlayerSignup extends JFrame {

	private JPanel contentPane;
	private JTextField User_txt;
	private JTextField Pass_txt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerSignup frame = new PlayerSignup();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */	
	public PlayerSignup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayerLogin log = new PlayerLogin();
				
				PlayerSignup.this.dispose();
				log.setVisible(true);
			}
		});
		btnNewButton.setBounds(530, 371, 95, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Sign up as a Player");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(223, 46, 165, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(178, 133, 95, 27);
		contentPane.add(lblNewLabel_1);
		
		User_txt = new JTextField();
		User_txt.setColumns(10);
		User_txt.setBounds(305, 133, 131, 32);
		contentPane.add(User_txt);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(178, 193, 95, 27);
		contentPane.add(lblNewLabel_1_1);
		
		Pass_txt = new JTextField();
		Pass_txt.setColumns(10);
		Pass_txt.setBounds(305, 199, 131, 32);
		contentPane.add(Pass_txt);
		
		JButton btnNewButton_1 = new JButton("Sign up!");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String getUser = User_txt.getText();
				String getPass = Pass_txt.getText();
				
				Password user = new Password(getUser, getPass);
				MainMethod.users.add(user);
				
				try {
					MainMethod.writeUser();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				PlayerLogin page = new PlayerLogin();
				PlayerSignup.this.dispose();
				System.out.println(getUser + getPass);
				page.setVisible(true);
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(254, 292, 95, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Already have an account? ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(355, 361, 165, 38);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_2 = new JButton("HOME");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrontPage home = new FrontPage();
				PlayerSignup.this.dispose();
				home.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(43, 371, 85, 21);
		contentPane.add(btnNewButton_2);
	}

}
