package layouts;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Account.Account;
import controllers.AccountManagement;
import index.Button;
import index.InputField;
import index.Label;
import index.PasswordField;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import index.ComboBox;
import javax.swing.DefaultComboBoxModel;

public class Login_Panel extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtAccount;
	private JPasswordField txtPassword;
	ComboBox<String> txtChucVu;
	
	public boolean isLogin;

	/**
	 * Create the frame.
	 */
	public Login_Panel() {
		
		getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 11));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 400);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
	/*
	 * Labels
	 * */
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("otherResource/Background.jpg"));
		lblNewLabel.setBounds(0, 0, 100, 400);
		getContentPane().add(lblNewLabel);	
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("otherResource/Background.jpg"));
		lblNewLabel_1.setBounds(540, 0, 100, 400);
		getContentPane().add(lblNewLabel_1);
		
		Label lblNewLabel_2 = new Label("LOGIN TO SYSTEM");
		lblNewLabel_2.setBounds(250, 11, 166, 21);
		getContentPane().add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.MAGENTA);
		separator.setBounds(129, 48, 386, 2);
		getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.MAGENTA);
		separator_1.setBounds(129, 268, 386, 2);
		getContentPane().add(separator_1);
		
	/*
	 * Field text
	 * */
		txtAccount = new InputField("Username");
		txtAccount.setBounds(129, 66, 386, 53);
		getContentPane().add(txtAccount);
		txtAccount.setColumns(10);
		
		txtPassword = new PasswordField("Password");
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPassword.setBounds(129, 137, 386, 53);
		getContentPane().add(txtPassword);
		
		txtChucVu = new ComboBox<String>();
		txtChucVu.setModel(new DefaultComboBoxModel<String>(new String[] {"Tổ trưởng", "Tổ phó", "Covid-19", "Khác"}));
		txtChucVu.setSelectedIndex(-1);
		txtChucVu.setMaximumRowCount(30);
		txtChucVu.setLabelText("Chức vụ");
		txtChucVu.setBounds(404, 212, 111, 45);
		getContentPane().add(txtChucVu);
		
	/*
	 * BUTTON
	 * */
		Button btnLoginButton = new Button("Login");
		btnLoginButton.setBounds(128, 281, 118, 68);
		getContentPane().add(btnLoginButton);
		btnLoginButton.setMnemonic(KeyEvent.VK_L);
		btnLoginButton.setToolTipText("Alt + L");
		btnLoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login();
			}
		});
		
		Button btnResetButton = new Button("Reset");
		btnResetButton.setBounds(257, 281, 124, 69);
		getContentPane().add(btnResetButton);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		btnResetButton.setMnemonic(KeyEvent.VK_R);
		btnResetButton.setToolTipText("Alt + R");
		btnResetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reset();
			}
		});
		
		Button btnExitButton = new Button("Exit");
		btnExitButton.setBounds(391, 281, 124, 69);
		getContentPane().add(btnExitButton);
		btnExitButton.setMnemonic(KeyEvent.VK_E);
		btnExitButton.setToolTipText("Alt + E");
		btnExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Exit();
			}
		});
	}
	
	/*
	 * Events
	 * */
	
	void Login() {
		String username = txtAccount.getText();
		String password = new String(txtPassword.getPassword());
		String chucVu = "Khac";
		int index = txtChucVu.getSelectedIndex();
		if(index == 0) chucVu = "To truong";
		if(index == 1) chucVu = "To pho";
		if(index == 2) chucVu = "Covid-19";
		if(index == 3) chucVu = "Khac";
		Account account = new Account(username, password, chucVu);
		
		AccountManagement accountM = new AccountManagement();
		accountM.getListOfAccounts(accountM.accounts);
		
		if(txtAccount.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Tài khoản trống!");
			return;
		}
		else if(new String(txtPassword.getPassword()).equals("")) {
			JOptionPane.showMessageDialog(this, "Mật khẩu trống!");
			return;
		}
		else {
			boolean foundAccount = false, foundPassword = false, foundChucVu = false;
			for(int i = 0; i< accountM.accounts.length; i++) {
				Account acc = accountM.accounts[i];
				if(acc != null && account.getUsername().equals(acc.getUsername())) {
					foundAccount = true;
					if(account.getPasswords().equals(acc.getPasswords())) {
						foundPassword = true;
						if(account.getChucVu().equals(acc.getChucVu())) {
							foundChucVu = true;
							isLogin = true;
							Main_Panel menu = new Main_Panel(this, index);
							menu.setVisible(isLogin);
							txtAccount.setText("");
							txtPassword.setText("");
							this.dispose();
							break;
						}
					}
				}
			}
			if(foundAccount == false)	JOptionPane.showMessageDialog(this, "Tài khoản không hợp lệ!");
			else {
				if(foundPassword == false) JOptionPane.showMessageDialog(this, "Mật khẩu không hợp lệ!");
				else {
					if(foundChucVu == false) JOptionPane.showMessageDialog(this, "Sai chức vụ!");
				}
			}
		}
	}
	
	void Reset() {
		txtAccount.setText("");
		txtPassword.setText("");
	}
	void Exit() {
		System.exit(0);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
