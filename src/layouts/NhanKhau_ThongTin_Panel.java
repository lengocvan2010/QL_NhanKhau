package layouts;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSeparator;
import index.InputField;
import qL_NhanKhau.NhanKhau;
import index.ComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;

public class NhanKhau_ThongTin_Panel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	NhanKhau a;
	/**
	 * Create the panel.
	 */
	@SuppressWarnings("deprecation")
	public NhanKhau_ThongTin_Panel(NhanKhau a) {
		setAutoscrolls(true);
		this.a=a;
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
		InputField txtNoiCap = new InputField("Nơi cấp");
		txtNoiCap.setEditable(false);
		txtNoiCap.setText(a.getNoiCap());
		
		InputField txtCCCD = new InputField("CCCD/CMND");
		txtCCCD.setEditable(false);
		txtCCCD.setText(a.getCCCD());
		
		InputField txtNamCap = new InputField("Năm cấp");
		txtNamCap.setEditable(false);
		txtNamCap.setText("");
		
		InputField txtNamDK = new InputField("Năm đăng ký");
		txtNamDK.setEditable(false);
		txtNamDK.setText(""+(a.getNgayDangKyThuongTru().getYear()+1900));
		
		InputField txtThuongTru = new InputField("Địa chỉ thường trú hiện nay");
		txtThuongTru.setEditable(false);
		txtThuongTru.setText(a.getDiaChiThuongTru());
		
		InputField txtThuongTru_Truoc = new InputField("Địa chỉ thường trú trước");
		txtThuongTru_Truoc.setEditable(false);
		txtThuongTru_Truoc.setText(a.getDiaChiThuongTruTruoc());
		
		InputField txtNoiLamViec = new InputField("Nơi làm việc");
		txtNoiLamViec.setEditable(false);
		txtNoiLamViec.setText(a.getNoiLamViec());
		
		InputField txtDanToc = new InputField("Dân tộc");
		txtDanToc.setEditable(false);
		txtDanToc.setText(a.getDanToc());
		
		InputField txtNgheNghiep = new InputField("Nghề nghiệp");
		txtNgheNghiep.setEditable(false);
		txtNgheNghiep.setText(a.getNgheNghiep());
		
		InputField txtQueQuan = new InputField("Quê quán");
		txtQueQuan.setEditable(false);
		txtQueQuan.setText(a.getQueQuan());
		
		InputField txtNoiSinh = new InputField("Nơi sinh");
		txtNoiSinh.setEditable(false);
		txtNoiSinh.setText(a.getNoiSinh());
		
		InputField txtHoTen = new InputField("Họ và tên");
		txtHoTen.setEditable(false);
		txtHoTen.setText(a.getTen());
		
		InputField txtBiDanh = new InputField("Bí danh");
		txtBiDanh.setEditable(false);
		txtBiDanh.setText(a.getBiDanh());

		InputField txtNamSinh = new InputField("Năm sinh");
		txtNamSinh.setEditable(false);
		txtNamSinh.setText("" +(a.getNgaySinh().getYear() + 1900));
		
	/*
	 * ComboBox
	 * */
		ComboBox<String> txtNgayCap = new ComboBox<String>();
		txtNgayCap.setEnabled(false);
		txtNgayCap.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		txtNgayCap.setSelectedIndex(-1);
		txtNgayCap.setMaximumRowCount(32);
		txtNgayCap.setLabelText("Ngày cấp");
		
		ComboBox<String> txtThangCap = new ComboBox<String>();
		txtThangCap.setEnabled(false);
		txtThangCap.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		txtThangCap.setSelectedIndex(-1);
		txtThangCap.setMaximumRowCount(30);
		txtThangCap.setLabelText("Tháng cấp");
		
		ComboBox<String> txtNgayDK = new ComboBox<String>();
		txtNgayDK.setEnabled(false);
		txtNgayDK.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		txtNgayDK.setSelectedIndex(a.getNgayDangKyThuongTru().getDate()-1);
		txtNgayDK.setMaximumRowCount(32);
		txtNgayDK.setLabelText("Ngày đăng ký");
		
		ComboBox<String> txtThangDK = new ComboBox<String>();
		txtThangDK.setEnabled(true);
		txtThangDK.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		txtThangDK.setSelectedIndex(a.getNgayDangKyThuongTru().getMonth()-1);
		txtThangDK.setMaximumRowCount(30);
		txtThangDK.setLabelText("Tháng đăng ký");
		
		ComboBox<String> txtNgaySinh = new ComboBox<String>();
		txtNgaySinh.setEnabled(false);
		txtNgaySinh.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		txtNgaySinh.setSelectedIndex(a.getNgaySinh().getDate()-1);
		txtNgaySinh.setMaximumRowCount(32);
		txtNgaySinh.setLabelText("Ngày sinh");
		
		ComboBox<String> txtThangSinh = new ComboBox<String>();
		txtThangSinh.setEnabled(false);
		txtThangSinh.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		txtThangSinh.setSelectedIndex(a.getNgaySinh().getMonth()-1);
		txtThangSinh.setMaximumRowCount(30);
		txtThangSinh.setLabelText("Tháng sinh");
		
		ComboBox<String> comboBox_1 = new ComboBox<String>();
		comboBox_1.setEnabled(true);
		comboBox_1.setModel(new DefaultComboBoxModel<String>(new String[] {"Nam", "Nữ", "Khác"}));
		comboBox_1.setSelectedIndex(a.getInGioiTinh());
		comboBox_1.setMaximumRowCount(3);
		comboBox_1.setLabelText("Giới tính");
		
		if(a.getNgayCap()!=null) {
			txtNgayCap.setSelectedIndex(a.getNgayCap().getDate()-1);
			txtThangCap.setSelectedIndex(a.getNgayCap().getMonth()-1);
			txtNamCap.setText(""+(a.getNgayCap().getYear() + 1900));
		}
		
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
							.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
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
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
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
}
