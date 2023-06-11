package layouts;

import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;

import index.Label;
import qL_NhanKhau.NhanKhau;
import index.InputField;
import index.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NhanKhau_ThongTin extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	NhanKhau_ThongTin_Panel panel;
	NhanKhau a;
	/**
	 * Create the dialog.
	 */
	public NhanKhau_ThongTin(NhanKhau a) {
		this.a =a;
		panel = new NhanKhau_ThongTin_Panel(a);
		setIconImage(Toolkit.getDefaultToolkit().getImage("otherResource/NhanKhau16.png"));
		setTitle("Thông Tin Nhân Khẩu");
		setBounds(100, 100, 700, 751);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		/*
		 * Label
		 * */
			Label lblThemHK = new Label("Thông tin Nhân Khẩu");
			lblThemHK.setIcon(new ImageIcon("otherResource/NhanKhau16.png"));
			lblThemHK.setBounds(10, 10, 258, 19);
			getContentPane().add(lblThemHK);
			
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 40, 850, 2);
			getContentPane().add(separator);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 50, 664, 403);
			getContentPane().add(scrollPane);
			scrollPane.setViewportView(panel);
			
		/*
		 * Text
		 * */
			InputField txtSoHoKhau = new InputField("Số Hộ khẩu");
			txtSoHoKhau.setEditable(false);
			txtSoHoKhau.setText(a.getSoHK());
			txtSoHoKhau.setColumns(10);
			txtSoHoKhau.setBounds(10, 469, 664, 51);
			getContentPane().add(txtSoHoKhau);
			
			InputField txtQuanHe = new InputField("Quan hệ chủ hộ");
			txtQuanHe.setEditable(false);
			txtQuanHe.setText(a.getQuanHeChuHo());
			txtQuanHe.setColumns(10);
			txtQuanHe.setBounds(10, 536, 664, 51);
			getContentPane().add(txtQuanHe);
			
			InputField txtGhiChu = new InputField("Ghi chú");
			txtGhiChu.setText(a.getGhiChu());
			txtGhiChu.setEditable(false);
			txtGhiChu.setColumns(10);
			txtGhiChu.setBounds(10, 603, 664, 51);
			getContentPane().add(txtGhiChu);
			
			Button btnNewButton = new Button("Close");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnNewButton.setBounds(292, 678, 89, 23);
			getContentPane().add(btnNewButton);
			
	}
}
