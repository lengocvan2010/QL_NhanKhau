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
import javax.swing.LayoutStyle.ComponentPlacement;
public class NhanKhau_Them_ThongTin extends JPanel {

	InputField txtNoiSinh;
	InputField txtHoTen;
	InputField txtBiDanh;
	InputField txtQueQuan;
	InputField txtDanToc;
	InputField txtNoiLamViec;
	InputField txtNamSinh;
	InputField txtNgheNghiep;
	InputField txtCCCD;
	ComboBox<String> txtThangCap;
	ComboBox<String> txtNgaySinh;
	ComboBox<String> txtThangSinh;
	ComboBox<String> txtNgayCap;
	InputField txtNamCap;
	InputField txtNoiCap;
	ComboBox<String> txtNgayDK;
	ComboBox<String> txtGioiTinh;
	ComboBox<String> txtThangDK;
	InputField txtNamDK;
	InputField txtThuongTru;
	InputField txtThuongTru_Truoc;
	InputField id;
	private static final long serialVersionUID = 1L;
	
	public NhanKhau_Them_ThongTin() {
		setAutoscrolls(true);
		
	/*
	 * Label
	 * */
		JLabel CCCD = new JLabel("Căn cước công dân");
		CCCD.setFont(new Font("Tahoma", Font.BOLD, 14));
		JSeparator separator = new JSeparator();
		
		JLabel ThuongTru = new JLabel("Thường trú");
		ThuongTru.setFont(new Font("Tahoma", Font.BOLD, 14));
		JSeparator separator_1 = new JSeparator();
		
	/*
	 * Input
	 * */
		txtHoTen = new InputField("Họ và tên (*)");
		txtBiDanh = new InputField("Bí danh (*)");
		txtNoiSinh = new InputField("Nơi sinh (*)");
		txtQueQuan = new InputField("Quê quán (*)");
		txtDanToc = new InputField("Dân tộc (*)");
		txtNoiLamViec = new InputField("Nơi làm việc (*)");
		txtNamSinh = new InputField("Năm sinh (*)");
		txtNgheNghiep = new InputField("Nghề nghiệp (*)");
		txtCCCD = new InputField("CCCD/CMND (*)");
		txtNamCap = new InputField("Năm cấp (*)");
		txtNoiCap = new InputField("Nơi cấp (*)");
		txtNamDK = new InputField("Năm đăng ký (*)");	
		txtThuongTru = new InputField("Địa chỉ thường trú hiện nay (*)");
		txtThuongTru_Truoc = new InputField("Địa chỉ thường trú trước");
		id = new InputField("ID (*)");
		
		txtGioiTinh = new ComboBox<String>();
		txtGioiTinh.setModel(new DefaultComboBoxModel<String>(new String[] {"Nam", "Nữ", "Khác"}));
		txtGioiTinh.setSelectedIndex(-1);
		txtGioiTinh.setMaximumRowCount(30);
		txtGioiTinh.setLabelText("Giới tính (*)");
	
		txtNgaySinh = new ComboBox<String>();
		txtNgaySinh.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		txtNgaySinh.setSelectedIndex(-1);
		txtNgaySinh.setMaximumRowCount(32);
		txtNgaySinh.setLabelText("Ngày sinh (*)");
		
		txtThangSinh = new ComboBox<String>();
		txtThangSinh.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		txtThangSinh.setSelectedIndex(-1);
		txtThangSinh.setMaximumRowCount(30);
		txtThangSinh.setLabelText("Tháng sinh (*)");
	
		txtThangCap = new ComboBox<String>();
		txtThangCap.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		txtThangCap.setSelectedIndex(-1);
		txtThangCap.setMaximumRowCount(30);
		txtThangCap.setLabelText("Tháng cấp (*)");
		
		txtNgayCap = new ComboBox<String>();
		txtNgayCap.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		txtNgayCap.setSelectedIndex(-1);
		txtNgayCap.setMaximumRowCount(32);
		txtNgayCap.setLabelText("Ngày cấp (*)");
	
		txtNgayDK = new ComboBox<String>();
		txtNgayDK.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		txtNgayDK.setSelectedIndex(-1);
		txtNgayDK.setMaximumRowCount(32);
		txtNgayDK.setLabelText("Ngày đăng ký (*)");
		
		txtThangDK = new ComboBox<String>();
		txtThangDK.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		txtThangDK.setSelectedIndex(-1);
		txtThangDK.setMaximumRowCount(30);
		txtThangDK.setLabelText("Tháng đăng ký (*)");
	
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtNoiSinh, GroupLayout.PREFERRED_SIZE, 612, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtQueQuan, GroupLayout.PREFERRED_SIZE, 612, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtDanToc, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
							.addGap(128)
							.addComponent(txtNgheNghiep, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtNoiLamViec, GroupLayout.PREFERRED_SIZE, 612, GroupLayout.PREFERRED_SIZE)
						.addComponent(CCCD, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, 612, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtCCCD, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addComponent(txtNgayCap, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(19)
							.addComponent(txtThangCap, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(21)
							.addComponent(txtNamCap, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtNoiCap, GroupLayout.PREFERRED_SIZE, 612, GroupLayout.PREFERRED_SIZE)
						.addComponent(ThuongTru, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
						.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 612, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtNgayDK, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(19)
							.addComponent(txtThangDK, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(21)
							.addComponent(txtNamDK, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtThuongTru, GroupLayout.PREFERRED_SIZE, 612, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtThuongTru_Truoc, GroupLayout.PREFERRED_SIZE, 612, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtHoTen, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtBiDanh, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(id, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtNgaySinh, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtThangSinh, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(21)
							.addComponent(txtNamSinh, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtGioiTinh, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtHoTen, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtBiDanh, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(txtGioiTinh, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtThangSinh, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtNamSinh, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtNgaySinh, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
					.addGap(20)
					.addComponent(txtNoiSinh, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(txtQueQuan, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtDanToc, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNgheNghiep, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addComponent(txtNoiLamViec, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(CCCD, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 9, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtCCCD, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNgayCap, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtThangCap, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNamCap, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addGap(15)
					.addComponent(txtNoiCap, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(20)
					.addComponent(ThuongTru, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 9, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtNgayDK, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtThangDK, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNamDK, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addComponent(txtThuongTru, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(txtThuongTru_Truoc, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
		);
		setLayout(groupLayout);
		
	}
	
	@SuppressWarnings("deprecation")
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
		}else if (txtNgheNghiep.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "Nhập nghề nghiệp!");
		}else if (txtNoiLamViec.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "Nhập nơi làm việc!");
		}else check = true;
		
		if(!txtCCCD.getText().isBlank()) {
			check = false;
			if(txtNoiCap.getText().isBlank()) {
				JOptionPane.showMessageDialog(this, "Nhập nơi cấp!");
			}else if(txtNgayCap.getSelectedIndex()==-1||txtThangCap.getSelectedIndex()==-1||txtNamCap.getText().isBlank()) {
				JOptionPane.showMessageDialog(this,"Nhập ngày cấp!");
			}else check=true;
		}	
		int namSinh = -1;
		int namDK = -1;
		int namCap = -1;
		try {
			if(!txtCCCD.getText().isBlank()) namCap = Integer.parseInt(txtNamCap.getText()) -1900;
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
			String ngheNghiep = txtNgheNghiep.getText();
			String noiLamViec = txtNoiLamViec.getText();
			String cccd = txtCCCD.getText();
			int ngayCap = txtNgayCap.getSelectedIndex() +1;
			int thangCap = txtNgayCap.getSelectedIndex()+1;

			String noiCap = txtNoiCap.getText();
			int ngayDK = txtNgayDK.getSelectedIndex() +1;
			int thangDK = txtThangDK.getSelectedIndex()+1;

			String diaChiTT = txtThuongTru.getText();
			String diaChiTTTruoc = txtThuongTru_Truoc.getText();
			Date ngaySinhDate = new Date(namSinh, thangSinh, ngaySinh);
			Date ngayCapDate = new Date(namCap, thangCap, ngayCap);
			Date ngayDKDate = new Date(namDK, thangDK, ngayDK);
			if(txtCCCD.getText().isBlank()) {
				cccd = null;
				noiCap = null;
				ngayCapDate=null;
			}
			String idString = id.getText();
			n = new NhanKhau(idString, hoTen, gioiTinh, biDanh, ngaySinhDate, noiSinh,
				 queQuan,  danToc,  ngheNghiep,  noiLamViec,  cccd,  ngayCapDate,
				 noiCap, ngayDKDate, diaChiTT, diaChiTTTruoc,
				 null, null, null);
		}
		return n;
	}
}
