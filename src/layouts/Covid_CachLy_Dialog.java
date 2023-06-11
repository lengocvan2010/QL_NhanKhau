package layouts;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.table.DefaultTableModel;

import controller.CovidController;
import controller.NhanKhauController;
import index.Button;
import index.InputField;
import index.Label;
import index.ScrollPane;
import index.Table;
import qL_NhanKhau.Covid_CachLy;
import qL_NhanKhau.NhanKhau;
import sql.ConnectSQL;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import index.ComboBox;

public class Covid_CachLy_Dialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	InputField txtCCCD;
	Table table;
	InputField txtNoiCachLy;
	InputField txtNamCachLy;
	InputField txtSoNgay;
	
	ComboBox<String> txtNgayCachLy;
	ComboBox<String> txtThangCachLy;
	ComboBox<String> txtLoaiCachLy;
	
	ConnectSQL c;
	CovidController controller;
	NhanKhauController nC;
	
	NhanKhau nL;
	/**
	 * Create the dialog.
	 */
	public Covid_CachLy_Dialog(ConnectSQL cc) {
		setTitle("Cách ly");
		getContentPane().setLayout(null);
		setBounds(100, 100, 500, 550);
		setLocationRelativeTo(null);
		c= cc;
		controller= new CovidController(c);
		nC = new NhanKhauController(c);
		/*
		 * Labels
		 */
		
			Label lblThemHK = new Label("Cách ly");
			lblThemHK.setBounds(10, 10, 167, 19);
			getContentPane().add(lblThemHK);
			
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 35, 850, 2);
			getContentPane().add(separator);
			JSeparator separator_1 = new JSeparator();
			separator_1.setBounds(10, 418, 850, 2);
			getContentPane().add(separator_1);
			
			JLabel lblThngTinCh = new JLabel("Thông tin người cách ly");
			lblThngTinCh.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblThngTinCh.setBounds(10, 40, 167, 25);
			getContentPane().add(lblThngTinCh);
			
			JSeparator separator_1_1 = new JSeparator();
			separator_1_1.setBounds(10, 193, 850, 2);
			getContentPane().add(separator_1_1);
			
			JLabel lblThngTinCh_1 = new JLabel("Thông tin cách ly");
			lblThngTinCh_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblThngTinCh_1.setBounds(10, 206, 140, 25);
			getContentPane().add(lblThngTinCh_1);
			
		/*
		 * Text Field
		 * */
			txtCCCD = new InputField("ID nhân khẩu(*)");
			txtCCCD.setBounds(10, 63, 328, 51);
			getContentPane().add(txtCCCD);
			
			txtNoiCachLy = new InputField("Nơi cách ly(*)");
			txtNoiCachLy.setBounds(10, 355, 464, 57);
			getContentPane().add(txtNoiCachLy);
			
			txtNamCachLy = new InputField("Năm cách ly (*)");
			txtNamCachLy.setBounds(271, 237, 111, 45);
			getContentPane().add(txtNamCachLy);
			
			txtSoNgay = new InputField("Số ngày (*)");
			txtSoNgay.setBounds(389, 237, 85, 45);
			getContentPane().add(txtSoNgay);
			
			txtNgayCachLy = new ComboBox<String>();
			txtNgayCachLy.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
			txtNgayCachLy.setSelectedIndex(-1);
			txtNgayCachLy.setMaximumRowCount(32);
			txtNgayCachLy.setLabelText("Ngày cách ly (*)");
			txtNgayCachLy.setBounds(10, 237, 111, 45);
			getContentPane().add(txtNgayCachLy);
			
			txtThangCachLy = new ComboBox<String>();
			txtThangCachLy.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
			txtThangCachLy.setSelectedIndex(-1);
			txtThangCachLy.setMaximumRowCount(12);
			txtThangCachLy.setLabelText("Tháng cách ly (*)");
			txtThangCachLy.setBounds(139, 237, 111, 45);
			getContentPane().add(txtThangCachLy);
			
			txtLoaiCachLy = new ComboBox<String>();
			txtLoaiCachLy.setModel(new DefaultComboBoxModel<String>(new String[] {"F0", "F1", "F2", "Khác"}));
			txtLoaiCachLy.setSelectedIndex(-1);
			txtLoaiCachLy.setMaximumRowCount(4);
			txtLoaiCachLy.setLabelText("Loại cách ly (*)");
			txtLoaiCachLy.setBounds(10, 293, 464, 51);
			getContentPane().add(txtLoaiCachLy);
			
		/*
		 * Table
		 * */
			table = new Table();
			Object[] columns =  {"ID", "Họ tên", "CCCD", "Ghi chú"};
			table.model.setColumnIdentifiers(columns);
				
			ScrollPane scrollPane = new ScrollPane(table);
			scrollPane.setBounds(10, 125, 464, 57);
			getContentPane().add(scrollPane);
			
		/*
		 ** Buttons
		 */
			Button btnXcNhn = new Button("Xác nhận");
			btnXcNhn.setBounds(31, 431, 118, 68);
			getContentPane().add(btnXcNhn);
			btnXcNhn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					xacNhanThem();
				}
			});
			
			Button btnReset = new Button("Reset");
			btnReset.setBounds(179, 431, 118, 68);
			getContentPane().add(btnReset);
			btnReset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					reset();
				}
			});
			
			Button btnThoat = new Button("Thoát");
			btnThoat.setBounds(332, 431, 118, 68);
			getContentPane().add(btnThoat);
			btnThoat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			
			Button btnXcNhn_NguoiKhai = new Button("Xác nhận");
			btnXcNhn_NguoiKhai.setBounds(370, 78, 104, 29);
			getContentPane().add(btnXcNhn_NguoiKhai);
			btnXcNhn_NguoiKhai.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					xacNhan_NguoiKhai();
				}
			});
	}
	
	/*
	 * Events
	 * */
	public void xacNhanThem() {		
		nL = nC.timNhanKhauId(txtCCCD.getText());
		boolean check = false;
		if(nL.getCCCD()==null) {
			JOptionPane.showMessageDialog(this, "Nhập nhân khẩu khai báo!");
		}else if(txtLoaiCachLy.getSelectedItem().toString().isBlank()) {
			JOptionPane.showMessageDialog(this, "Nhập loại cách ly!");
		}else if(txtNoiCachLy.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "Nhập nơi cách ly!");
		}else if(txtNgayCachLy.getSelectedIndex()==-1) {
			JOptionPane.showMessageDialog(this, "Chọn ngày cách ly!");
		}else if(txtThangCachLy.getSelectedIndex()==-1) {
			JOptionPane.showMessageDialog(this, "Chọn tháng cách ly!");
		}else if(txtNamCachLy.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "Nhập năm cách ly!");
		}else if(txtSoNgay.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "Nhập số ngày cách ly!");
		}else if(nL.getGhiChu().equals("Đã qua đời")) {
			JOptionPane.showMessageDialog(this, "Nhân khẩu đã qua đời!");
		}else check = true;
		int nam = -1;
		int so = 0;
		try {
			nam = Integer.parseInt(txtNamCachLy.getText())-1900;
			so = Integer.parseInt(txtSoNgay.getText());
		} catch (Exception e) {
			check = false;
			JOptionPane.showMessageDialog(this, "Năm và số ngày phải là số!");
		}
		
		if(check) {
			String loai = txtLoaiCachLy.getSelectedItem().toString();
			String noi = txtNoiCachLy.getText();
			int ngay = txtNgayCachLy.getSelectedIndex()+1;
			int thang = txtThangCachLy.getSelectedIndex();
			@SuppressWarnings("deprecation")
			Date ngaykb = new Date(nam, thang, ngay);
			Covid_CachLy c = new Covid_CachLy(nL, ngaykb, so, loai, noi);
			if(controller.themCachly(c)) {
				JOptionPane.showMessageDialog(this, "Thêm thành công!");
				dispose();
			}else JOptionPane.showMessageDialog(this, "Thêm thất bại!");
		}
		System.out.println(txtThangCachLy.getSelectedIndex()+":"+txtThangCachLy.getItemAt(txtThangCachLy.getSelectedIndex()));
	}
	
	public void reset() {
		txtCCCD.setText("");
		txtLoaiCachLy.setSelectedIndex(-1);
		txtNoiCachLy.setText("");
		if(table.getRowCount() > 0) {
			table.model.removeRow(0);
		}
	}
	
	public void xacNhan_NguoiKhai() {
		nL  =  nC.timNhanKhauId(txtCCCD.getText());
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"ID", "Họ tên", "CCCD", "Ghi chu"
				}
				));
		DefaultTableModel mta = (DefaultTableModel) table.getModel();
		if(nL.getCCCD()!=null) {
			mta.addRow(new Object[] {
					nL.getId(),nL.getTen(),nL.getCCCD(),nL.getGhiChu()
			});
		}
	}
}
