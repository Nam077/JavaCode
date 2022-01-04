package Main;
import Main.*;
import Connect.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;
import Class.*;;

public class UserAuth extends JFrame {

	private JPanel contentPane;
	private JTextField tfRegisterEmail;
	private JTextField tfRegisterName;
	private JTextField tfRegisterPass2;
	private JTextField tfRegisterPass;
	private JTextField tfLoginEmail;
	private JTextField tfLoginPass;
	private JTextField tfForgetEmail;
	private JPanel PanelRegister, PanelLogin, PanelForget;
	private Connect connect;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserAuth frame = new UserAuth();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserAuth() {
		connect = new Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 637, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		PanelRegister = new JPanel();
		PanelRegister.setVisible(false);
		PanelRegister.setLayout(null);
		PanelRegister.setBounds(10, 11, 601, 423);
		contentPane.add(PanelRegister);

		tfRegisterEmail = new JTextField();
		tfRegisterEmail.setColumns(10);
		tfRegisterEmail.setBounds(111, 98, 386, 40);
		PanelRegister.add(tfRegisterEmail);

		tfRegisterName = new JTextField();
		tfRegisterName.setColumns(10);
		tfRegisterName.setBounds(111, 171, 386, 40);
		PanelRegister.add(tfRegisterName);

		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setBounds(111, 76, 46, 14);
		PanelRegister.add(lblNewLabel_3);

		JLabel lblPassword_2 = new JLabel("T\u00EAn");
		lblPassword_2.setBounds(111, 149, 79, 14);
		PanelRegister.add(lblPassword_2);

		JLabel lblNewLabel_1_1 = new JLabel("Register");
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 32));
		lblNewLabel_1_1.setBounds(243, 11, 145, 54);
		PanelRegister.add(lblNewLabel_1_1);

		tfRegisterPass2 = new JTextField();
		tfRegisterPass2.setColumns(10);
		tfRegisterPass2.setBounds(111, 317, 386, 40);
		PanelRegister.add(tfRegisterPass2);

		tfRegisterPass = new JTextField();
		tfRegisterPass.setColumns(10);
		tfRegisterPass.setBounds(111, 244, 386, 40);
		PanelRegister.add(tfRegisterPass);

		JLabel lblPassword_1_1 = new JLabel("Nh\u1EADp l\u1EA1i m\u1EADt kh\u1EA9u");
		lblPassword_1_1.setBounds(111, 295, 117, 14);
		PanelRegister.add(lblPassword_1_1);

		JLabel lblNewLabel_2_1 = new JLabel("M\u1EADt kh\u1EA9u");
		lblNewLabel_2_1.setBounds(111, 222, 79, 14);
		PanelRegister.add(lblNewLabel_2_1);

		JButton btRegisterSubmit = new JButton("\u0110\u0103ng k\u00FD");
		
		btRegisterSubmit.setBounds(111, 372, 201, 40);
		PanelRegister.add(btRegisterSubmit);

		JButton btRegisterLogin = new JButton("\u0110\u0103ng nh\u1EADp");
		btRegisterLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getLayoutLogin();
			}
		});
		btRegisterLogin.setBounds(322, 372, 175, 40);
		PanelRegister.add(btRegisterLogin);

		PanelLogin = new JPanel();
		PanelLogin.setLayout(null);
		PanelLogin.setBounds(10, 11, 601, 423);
		contentPane.add(PanelLogin);

		tfLoginEmail = new JTextField();
		tfLoginEmail.setColumns(10);
		tfLoginEmail.setBounds(110, 98, 386, 40);
		PanelLogin.add(tfLoginEmail);

		tfLoginPass = new JTextField();
		tfLoginPass.setColumns(10);
		tfLoginPass.setBounds(110, 171, 386, 40);
		PanelLogin.add(tfLoginPass);

		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setBounds(110, 76, 46, 14);
		PanelLogin.add(lblNewLabel);

		JLabel lblPassword = new JLabel("PassWord");
		lblPassword.setBounds(110, 149, 79, 14);
		PanelLogin.add(lblPassword);

		JLabel lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 32));
		lblNewLabel_1.setBounds(243, 11, 145, 54);
		PanelLogin.add(lblNewLabel_1);

		JButton button_1 = new JButton("New button");
		button_1.setBounds(110, 171, 89, 23);
		PanelLogin.add(button_1);

		JButton btLoginSubmit = new JButton("\u0110\u0103ng nh\u1EADp");

		btLoginSubmit.setBounds(110, 249, 201, 40);
		PanelLogin.add(btLoginSubmit);

		JButton btLoginRegister = new JButton("\u0110\u0103ng k\u00FD");
		btLoginRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getLayoutRegister();
			}
		});
		btLoginRegister.setBounds(321, 249, 175, 40);
		PanelLogin.add(btLoginRegister);

		JLabel lbLoginForget = new JLabel("Qu\u00EAn m\u1EADt kh\u1EA9u");

		lbLoginForget.setBounds(398, 224, 98, 14);
		PanelLogin.add(lbLoginForget);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("T\u00F4i l\u00E0 admin");
		rdbtnNewRadioButton.setBounds(110, 219, 109, 23);
		PanelLogin.add(rdbtnNewRadioButton);

		PanelForget = new JPanel();
		PanelForget.setVisible(false);
		PanelForget.setLayout(null);
		PanelForget.setBounds(10, 11, 601, 423);
		contentPane.add(PanelForget);

		tfForgetEmail = new JTextField();
		tfForgetEmail.setColumns(10);
		tfForgetEmail.setBounds(114, 151, 386, 40);
		PanelForget.add(tfForgetEmail);

		JLabel lblNewLabel_3_1 = new JLabel("Email");
		lblNewLabel_3_1.setBounds(114, 129, 46, 14);
		PanelForget.add(lblNewLabel_3_1);

		JLabel ForgetPass = new JLabel("ForgetPass");
		ForgetPass.setFont(new Font("Segoe UI", Font.BOLD, 32));
		ForgetPass.setBounds(224, 11, 222, 54);
		PanelForget.add(ForgetPass);

		JButton btForgetSubmit = new JButton("Nh\u1EADn M\u1EADt Kh\u1EA9u");
		btForgetSubmit.setBounds(114, 221, 201, 40);
		PanelForget.add(btForgetSubmit);
		btLoginSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(contentPane, "login");
				Account account = new Account();
				account = connect.getAccountLogin(tfLoginEmail.getText());
				if (account.getEmail() != null) {
					if (account.getPass().equals(tfLoginPass.getText().toString())) {
						setVisible(false);
						Main main = new Main();
						main.getView();
						
//						JOptionPane.showMessageDialog(contentPane, "Oke");
					}
					else {
						JOptionPane.showMessageDialog(contentPane, "Sai mật khẩu");
					}
				} else {
				}
			}
		});
		JButton btRegisterLogin_2 = new JButton("\u0110\u0103ng nh\u1EADp");
		btRegisterLogin_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getLayoutLogin();
			}
		});
		btRegisterLogin_2.setBounds(325, 221, 175, 40);
		PanelForget.add(btRegisterLogin_2);
		lbLoginForget.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getLayoutForget();

			}
		});
		btRegisterSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Account account = new Account();
				if(connect.getMailAccout(tfRegisterEmail.getText()) < 1) {
					if(tfRegisterPass.getText().equals(tfRegisterPass2.getText()) == true) {
						account.setEmail(tfRegisterEmail.getText());
						account.setName(tfRegisterName.getText());
						account.setPhone(tfRegisterPass.getText());
						
						
						SqlResult sqlResult = new SqlResult();
						sqlResult = connect.addAccount(account);
						if(sqlResult.getStatus().equals("1")) {
							JOptionPane.showMessageDialog(contentPane, "Oke");
						}
					}
					else {
						JOptionPane.showMessageDialog(contentPane, "Không trùng");
					}		
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "Email đã tồn tại");
				}
				
			}
		});
	}

	private void getLayoutLogin() {
		PanelRegister.setVisible(false);
		PanelLogin.setVisible(true);
		PanelForget.setVisible(false);
	}

	private void getLayoutRegister() {
		PanelRegister.setVisible(true);
		PanelLogin.setVisible(false);
		PanelForget.setVisible(false);
	}

	private void getLayoutForget() {
		PanelRegister.setVisible(false);
		PanelLogin.setVisible(false);
		PanelForget.setVisible(true);
	}
}
