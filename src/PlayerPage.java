import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PlayerPage extends JFrame {

	private JPanel contentPane;
	private JTextField txtTeam;
	private JTextField txtTeam2;
	private JTextField txtPlayer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerPage frame = new PlayerPage();
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
	public PlayerPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Team Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(162, 109, 147, 25);
		contentPane.add(lblNewLabel);
		
		txtTeam = new JTextField();
		txtTeam.setBounds(335, 112, 135, 24);
		contentPane.add(txtTeam);
		txtTeam.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Check Team Info?");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(253, 42, 160, 25);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Check Team Info");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String tname = txtTeam.getText();
				JFrame f = new JFrame();
				int index = MainMethod.searchTeam(tname);
				if (index != -1)
					JOptionPane.showMessageDialog(f, MainMethod.teams.get(index).getInfo());
				else
					JOptionPane.showMessageDialog(f, "Team Not Found");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(228, 172, 156, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1_1 = new JLabel("Check Player Info?");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(235, 231, 160, 25);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblEnterTeamName = new JLabel("Enter Team Name");
		lblEnterTeamName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEnterTeamName.setBounds(162, 298, 147, 25);
		contentPane.add(lblEnterTeamName);
		
		txtTeam2 = new JTextField();
		txtTeam2.setColumns(10);
		txtTeam2.setBounds(335, 301, 135, 24);
		contentPane.add(txtTeam2);
		
		JButton btnCheckPlayerInfo = new JButton("Check Player Info");
		btnCheckPlayerInfo.addActionListener(new ActionListener() {
			JFrame f = new JFrame();
			public void actionPerformed(ActionEvent e) {
				try {
					String tname2 = txtTeam2.getText();
					String pname = txtPlayer.getText();
					
					int index = MainMethod.searchTeam(tname2);
					String res = MainMethod.teams.get(index).getPlayerInfo(pname);
					JFrame f = new JFrame();  
				    JOptionPane.showMessageDialog(f, res);
				} catch (IndexOutOfBoundsException errr) {
					JOptionPane.showMessageDialog(f, "No Such Player");
				}
				
				
				
				
			}
		});
		btnCheckPlayerInfo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCheckPlayerInfo.setBounds(228, 419, 156, 21);
		contentPane.add(btnCheckPlayerInfo);
		
		txtPlayer = new JTextField();
		txtPlayer.setColumns(10);
		txtPlayer.setBounds(335, 364, 135, 24);
		contentPane.add(txtPlayer);
		
		JLabel lblNewLabel_2_1 = new JLabel("Enter Player Name");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(162, 361, 147, 25);
		contentPane.add(lblNewLabel_2_1);
		
		JButton btnNewButton_2 = new JButton("Log Out");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrontPage home = new FrontPage();
				PlayerPage.this.dispose();
				home.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(521, 46, 132, 21);
		contentPane.add(btnNewButton_2);
	}

}
