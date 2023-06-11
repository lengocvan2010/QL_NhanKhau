package layouts;

import javax.swing.JPanel;

import index.InputField;
import qL_NhanKhau.NhanKhau;
import index.ComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Date;

import javax.swing.JSeparator;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class DangKy_KhaiSinh_ThongTin extends JPanel {
	InputField id;
	InputField txtNoiSinh;
	InputField txtHoTen;
	InputField txtBiDanh;
	InputField txtQueQuan;
	InputField txtDanToc;
	InputField txtNamSinh;
	ComboBox<String> txtThangSinh;
	ComboBox<String> txtNgayDK;
	ComboBox<String> txtThangDK;
	ComboBox<String> txtNgaySinh;
	ComboBox<String> txtGioiTinh;
	
	InputField txtNamDK;
	InputField txtThuongTru;
	
	private static final long serialVersionUID = 1L;
	public DangKy_KhaiSinh_ThongTin() {
		
	/*
	 * Label
	 * */
		JLabel ThuongTru = new JLabel("Thường trú(*)");
		ThuongTru.setFont(new Font("Tahoma", Font.BOLD, 14));
		JSeparator separator_1 = new JSeparator();
		setAutoscrolls(true);
		
	/*
	 * Input
	 * */
		txtHoTen = new InputField("Họ và tên (*)");
		txtBiDanh = new InputField("Bí danh");
		txtNoiSinh = new InputField("Nơi sinh (*)");
		txtQueQuan = new InputField("Quê quán (*)");
		txtDanToc = new InputField("Dân tộc(*)");
		txtNamDK = new InputField("Năm đăng ký(*)");	
		txtThuongTru = new InputField("Địa chỉ thường trú hiện nay");
		id = new InputField("ID(*)");
		txtNamSinh = new InputField("Năm sinh(*)");
		
		txtNgayDK = new ComboBox<String>();
		txtNgayDK.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		txtNgayDK.setSelectedIndex(-1);
		txtNgayDK.setMaximumRowCount(32);
		txtNgayDK.setLabelText("Ngày đăng ký(*)");
		
		txtThangDK = new ComboBox<String>();
		txtThangDK.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		txtThangDK.setSelectedIndex(-1);
		txtThangDK.setMaximumRowCount(30);
		txtThangDK.setLabelText("Tháng đăng ký(*)");
		
		txtNgaySinh = new ComboBox<String>();
		txtNgaySinh.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		txtNgaySinh.setSelectedIndex(-1);
		txtNgaySinh.setMaximumRowCount(32);
		txtNgaySinh.setLabelText("Ngày sinh(*)");
		
		txtThangSinh = new ComboBox<String>();
		txtThangSinh.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		txtThangSinh.setSelectedIndex(-1);
		txtThangSinh.setMaximumRowCount(30);
		txtThangSinh.setLabelText("Tháng sinh(*)");
		
		txtGioiTinh = new ComboBox<String>();
		txtGioiTinh.setModel(new DefaultComboBoxModel<String>(new String[] {"Nam", "Nữ", "Khác"}));
		txtGioiTinh.setSelectedIndex(-1);
		txtGioiTinh.setMaximumRowCount(30);
		txtGioiTinh.setLabelText("Giới tính(*)");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtHoTen, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtBiDanh, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(id, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtNgaySinh, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtThangSinh, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(21)
							.addComponent(txtNamSinh, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(txtGioiTinh, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtNoiSinh, GroupLayout.PREFERRED_SIZE, 612, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtQueQuan, GroupLayout.PREFERRED_SIZE, 612, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDanToc, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addComponent(ThuongTru, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
						.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 612, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtNgayDK, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(19)
							.addComponent(txtThangDK, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(21)
							.addComponent(txtNamDK, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtThuongTru, GroupLayout.PREFERRED_SIZE, 612, GroupLayout.PREFERRED_SIZE)))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtHoTen, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtBiDanh, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(txtNgaySinh, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(txtThangSinh, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(txtNamSinh, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(txtGioiTinh, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
					.addGap(9)
					.addComponent(txtNoiSinh, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(txtQueQuan, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(txtDanToc, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(ThuongTru, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 9, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtNgayDK, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtThangDK, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNamDK, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addComponent(txtThuongTru, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
		);
		setLayout(groupLayout);
		
	}
	
	public NhanKhau getNhanKhau() {
		NhanKhau n = null;
		boolean check = false;
		if(id.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "Nhập id!");
		}else if (txtHoTen.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "Nhập họ tên!");
		}else if (txtNgaySinh.getSelectedIndex()==-1||txtThangSinh.getSelectedIndex()==-1||txtNamSinh.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "Nhập ngày sinh!");
		}else if(txtGioiTinh.getSelectedIndex()==-1) {
			JOptionPane.showMessageDialog(this, "Chọn giới tính!");
		}else if (txtNoiSinh.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "Nhập nơi sinh!");
		}else if (txtQueQuan.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "Nhập quê quán!");
		}else if (txtDanToc.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "Nhập dân tộc!");
		}else if (txtThuongTru.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "Nhập địa chỉ thường trú!");
		}else if (txtNgayDK.getSelectedIndex()==-1||txtThangDK.getSelectedIndex()==-1||txtNamDK.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "Nhập ngày đăng kí thường trú!");
		}else check = true;
		
		
		int namSinh = -1;
		int namDK = -1;
		int namCap = -1;
		try {
			namDK = Integer.parseInt(txtNamDK.getText())-1900;
			namSinh = Integer.parseInt(txtNamSinh.getText())-1900;
		} catch (Exception e) {
			// TODO: handle exception
			check = false;
			JOptionPane.showMessageDialog(this, "Năm phải là số!");
		}
		
		
		if(check) {
			String gioiTinh = "Nam";
			String hoTen = txtHoTen.getText();
			String biDanh = txtBiDanh.getText();
			int ngaySinh = txtNgaySinh.getSelectedIndex()+1;
			int thangSinh = txtThangSinh.getSelectedIndex()+1;
			if(txtGioiTinh.getSelectedIndex() == 0) gioiTinh = "Nam";
			if(txtGioiTinh.getSelectedIndex() == 1) gioiTinh = "Nữ";
			if(txtGioiTinh.getSelectedIndex() == 2) gioiTinh = "Khác";
			String noiSinh = txtNoiSinh.getText();
			String queQuan = txtQueQuan.getText();
			String danToc = txtDanToc.getText();
			int ngayDK = txtNgayDK.getSelectedIndex() +1;
			int thangDK = txtThangDK.getSelectedIndex()+1;

			String diaChiTT = txtThuongTru.getText();
			
			@SuppressWarnings("deprecation")
			Date ngaySinhDate = new Date(namSinh, thangSinh, ngaySinh);
			@SuppressWarnings("deprecation")
			Date ngayDKDate = new Date(namDK, thangDK, ngayDK);
			String idString = id.getText();
			n = new NhanKhau(idString, hoTen, gioiTinh, biDanh, ngaySinhDate, noiSinh,
				 queQuan,  danToc,  null,  null,  null,  null,
				 null, ngayDKDate, diaChiTT, null,
				 null, null, null);
		}
		return n;
	}
}
