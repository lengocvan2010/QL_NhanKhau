package layouts;

import javax.swing.JPanel;

import index.Button;
import sql.ConnectSQL;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DichVu_DangKy extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ConnectSQL c;
	public DichVu_DangKy(ConnectSQL cc) {
		c=cc;
		setLayout(null);
	
		Button btnKhaiSinh = new Button("Khai sinh");
		btnKhaiSinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addKhaiSinhDialog();
			}
		});
		btnKhaiSinh.setBounds(85, 50, 153, 63);
		add(btnKhaiSinh);
		
		Button btnKhaiTu = new Button("Khai tử");
		btnKhaiTu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addKhaiTuDialog();
			}
		});
		btnKhaiTu.setBounds(360, 50, 153, 63);
		add(btnKhaiTu);
		
		Button btnTamTru = new Button("Tạm trú");
		btnTamTru.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTamTruDialog();
			}
		});
		btnTamTru.setBounds(85, 147, 153, 63);
		add(btnTamTru);
		
		Button btnTamVang = new Button("Tạm vắng");
		btnTamVang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTamVangDialog();
			}
		});
		btnTamVang.setBounds(360, 147, 153, 63);
		add(btnTamVang);
		
		Button btnChuynNhnKhu = new Button("Chuyển Nhân khẩu");
		btnChuynNhnKhu.setText("Chuyển Hộ khẩu");
		btnChuynNhnKhu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addChuyenNhanKhau();
			}
		});
		btnChuynNhnKhu.setBounds(225, 247, 153, 63);
		add(btnChuynNhnKhu);

	}
	/*
	 * Service dialogs
	 * */
		public void addKhaiSinhDialog() {
			DangKy_KhaiSinh khaiSinh = new DangKy_KhaiSinh(c);
			khaiSinh.setVisible(true);
		}
		public void addKhaiTuDialog() {
			DangKy_KhaiTu khaiTu = new DangKy_KhaiTu(c);
			khaiTu.setVisible(true);
		}
		public void addTamTruDialog() {
			DangKy_TamTru tamTru = new DangKy_TamTru(c);
			tamTru.setVisible(true);
		}
		public void addTamVangDialog() {
			DangKy_TamVang tamVang = new DangKy_TamVang(c);
			tamVang.setVisible(true);
		}
		public void addChuyenNhanKhau() {
			DangKy_ChuyenNhanKhau chuyenNhanKhau = new DangKy_ChuyenNhanKhau(c);
			chuyenNhanKhau.setVisible(true);
		}
}
