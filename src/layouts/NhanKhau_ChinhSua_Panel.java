package layouts;

import java.awt.Font;
import java.sql.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.GroupLayout.Alignment;

import index.ComboBox;
import index.InputField;
import qL_NhanKhau.NhanKhau;

public class NhanKhau_ChinhSua_Panel extends JPanel {

	NhanKhau n;
	private static final long serialVersionUID = 1L;

	InputField txtNoiCap;
	InputField txtCCCD;
	InputField txtNamCap;
	InputField txtNamDK;
	InputField txtThuongTru;
	InputField txtThuongTru_Truoc;
	InputField txtNoiLamViec;
	InputField txtDanToc;
	InputField txtNgheNghiep;
	InputField txtQueQuan;
	InputField txtNoiSinh;
	InputField txtHoTen;
	InputField txtBiDanh;
	ComboBox<String> txtNgayCap;
	ComboBox<String> txtThangCap;
	ComboBox<String> txtNgayDK;
	ComboBox<String> txtThangDK;
	ComboBox<String> txtThangSinh;
	ComboBox<String> txtNgaySinh;
	InputField txtNamSinh;
	ComboBox<String> txtGioiTinh;
	
	@SuppressWarnings("deprecation")
	public NhanKhau_ChinhSua_Panel(NhanKhau a) {
		setAutoscrolls(true);
		n = a;
		/*
		 * Label
		 * */
		JSeparator separator = new JSeparator();
		JSeparator separator_1 = new JSeparator();
		
		JLabel ThuongTru = new JLabel("Thường trú");
		ThuongTru.setFont(new Font("Tahoma", Font.BOLD, 14));
		JLabel CCCD = new JLabel("Căn cước công dân");
		CCCD.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		/*
		 * Input Field
		 * */
		txtNoiCap = new InputField("Nơi cấp");
		txtNoiCap.setText(n.getNoiCap());
		
		txtCCCD = new InputField("CCCD/CMND");
		txtCCCD.setText(n.getCCCD());
		
		txtNamCap = new InputField("Năm cấp");
		txtNamCap.setText(""+(n.getNgayCap().getYear()+1900));
		
		txtNamDK = new InputField("Năm đăng ký");
		txtNamDK.setText(""+(n.getNgayDangKyThuongTru().getYear()+1900));
		
		txtThuongTru = new InputField("Địa chỉ thường trú hiện nay");
		txtThuongTru.setText(n.getDiaChiThuongTru());
		
		txtThuongTru_Truoc = new InputField("Địa chỉ thường trú trước");
		txtThuongTru_Truoc.setText(n.getDiaChiThuongTruTruoc());
		
		txtNoiLamViec = new InputField("Nơi làm việc");
		txtNoiLamViec.setText(n.getNoiLamViec());
		
		txtDanToc = new InputField("Dân tộc");
		txtDanToc.setText(n.getDanToc());
		
		txtNgheNghiep = new InputField("Nghề nghiệp");
		txtNgheNghiep.setText(n.getNgheNghiep());
		
		txtQueQuan = new InputField("Quê quán");
		txtQueQuan.setText(n.getQueQuan());
		
		txtNoiSinh = new InputField("Nơi sinh");
		txtNoiSinh.setText(n.getNoiSinh());
		
		txtHoTen = new InputField("Họ và tên");
		txtHoTen.setText(n.getTen());
		
		txtBiDanh = new InputField("Bí danh");
		txtBiDanh.setText(n.getBiDanh());
		
		txtNamSinh = new InputField("Năm sinh");
		txtNamSinh.setText(""+(n.getNgaySinh().getYear()+1900));
		
	/*
	 * ComboBox
	 * */
		txtNgayCap = new ComboBox<String>();
		txtNgayCap.setEditable(true);
		txtNgayCap.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		txtNgayCap.setSelectedIndex(n.getNgayCap().getDate());
		txtNgayCap.setMaximumRowCount(32);
		txtNgayCap.setLabelText("Ngày cấp");
		
		txtThangCap = new ComboBox<String>();
		txtThangCap.setEditable(true);
		txtThangCap.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		txtThangCap.setSelectedIndex(n.getNgayCap().getMonth()-1);
		txtThangCap.setMaximumRowCount(30);
		txtThangCap.setLabelText("Tháng cấp");
		
		txtNgayDK = new ComboBox<String>();
		txtNgayDK.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNgayDK.setEditable(true);
		txtNgayDK.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		txtNgayDK.setSelectedIndex(n.getNgayDangKyThuongTru().getDate()-1);
		txtNgayDK.setMaximumRowCount(32);
		txtNgayDK.setLabelText("Ngày đăng ký");
		
		txtThangDK = new ComboBox<String>();
		txtThangDK.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtThangDK.setEditable(true);
		txtThangDK.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		txtThangDK.setSelectedIndex(n.getNgayDangKyThuongTru().getMonth()-1);
		txtThangDK.setMaximumRowCount(30);
		txtThangDK.setLabelText("Tháng đăng ký");
		
		txtNgaySinh = new ComboBox<String>();
		txtNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNgaySinh.setEditable(true);
		txtNgaySinh.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		txtNgaySinh.setSelectedIndex(n.getNgaySinh().getDate()-1);
		txtNgaySinh.setMaximumRowCount(32);
		txtNgaySinh.setLabelText("Ngày sinh");
		
		txtThangSinh = new ComboBox<String>();
		txtThangSinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtThangSinh.setEditable(true);
		txtThangSinh.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		txtThangSinh.setSelectedIndex(n.getNgaySinh().getMonth()-1);
		txtThangSinh.setMaximumRowCount(30);
		txtThangSinh.setLabelText("Tháng sinh");
		
		txtGioiTinh = new ComboBox<String>();
		txtGioiTinh.setEditable(true);
		txtGioiTinh.setModel(new DefaultComboBoxModel<String>(new String[] {"Nam", "Nữ", "Khác"}));
		txtGioiTinh.setSelectedIndex(n.getInGioiTinh());
		txtGioiTinh.setMaximumRowCount(30);
		txtThangSinh.setLabelText("Giới tính");
		
	/*
	 * Group
	 * */
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
							.addComponent(txtNgaySinh, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(19)
							.addComponent(txtThangSinh, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(21)
							.addComponent(txtNamSinh, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(128)
							.addComponent(txtGioiTinh, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
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
						.addComponent(txtThuongTru_Truoc, GroupLayout.PREFERRED_SIZE, 612, GroupLayout.PREFERRED_SIZE)))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtHoTen, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtBiDanh, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtNgaySinh, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtThangSinh, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNamSinh, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtGioiTinh, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
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
	
	public NhanKhau getNhanKhau() {
		NhanKhau n = new NhanKhau();
		String hoTen = txtHoTen.getText();
		String biDanh = txtBiDanh.getText();
		int ngaySinh = txtNgaySinh.getSelectedIndex()+1;
		int thangSinh = txtThangSinh.getSelectedIndex()+1;
		int namSinh = -1;
		int namDK = -1;
		int namCap = -1;

		String gioiTinh = "Nam";
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
		try {
			namSinh = Integer.parseInt(txtNamSinh.getText())-1900;
			namDK = Integer.parseInt(txtNamDK.getText())-1900;
			namCap = Integer.parseInt(txtNamCap.getText())-1900;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Nam la so!");
		}
		
		
		@SuppressWarnings("deprecation")
		Date ngaySinhDate = new Date(namSinh, thangSinh, ngaySinh);
		@SuppressWarnings("deprecation")
		Date ngayCapDate = new Date(namCap, thangCap, ngayCap);
		@SuppressWarnings("deprecation")
		Date ngayDKDate = new Date(namDK, thangDK, ngayDK);
		
		n = new NhanKhau(hoTen, gioiTinh, biDanh, ngaySinhDate, noiSinh,
				 queQuan,  danToc,  ngheNghiep,  noiLamViec,  cccd,  ngayCapDate,
				 noiCap, ngayDKDate, diaChiTT, diaChiTTTruoc,
				 null, "Không", "Không");
		return n;
	}

}
