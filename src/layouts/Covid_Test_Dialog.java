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
import qL_NhanKhau.Covid_TestCovid;
import qL_NhanKhau.NhanKhau;
import sql.ConnectSQL;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import index.ComboBox;

public class Covid_Test_Dialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	InputField txtCCCD;
	InputField txtKetQua;
	InputField txtNamTest;
	
	ComboBox<String> txtNgayTest;
	ComboBox<String> txtThangTest;
	
	Table table;
	
	ConnectSQL c;
	CovidController controller;
	NhanKhauController nC;
	NhanKhau nL;
	/**
	 * Create the dialog.
	 */
	public Covid_Test_Dialog(ConnectSQL cc) {
		setTitle("Test Covid");
		getContentPane().setLayout(null);
		setBounds(100, 100, 500, 500);
		setLocationRelativeTo(null);
		c= cc;
		controller= new CovidController(c);
		nC = new NhanKhauController(c);
		/*
		 * Labels
		 */
		
			Label lblThemHK = new Label("Test Covid");
			lblThemHK.setBounds(10, 10, 167, 19);
			getContentPane().add(lblThemHK);
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 35, 850, 2);
			getContentPane().add(separator);
			JSeparator separator_1 = new JSeparator();
			separator_1.setBounds(10, 355, 850, 2);
			getContentPane().add(separator_1);
			
			JLabel lblThngTinCh = new JLabel("Thông tin người test");
			lblThngTinCh.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblThngTinCh.setBounds(10, 40, 167, 25);
			getContentPane().add(lblThngTinCh);
			JSeparator separator_1_1 = new JSeparator();
			separator_1_1.setBounds(10, 193, 850, 2);
			getContentPane().add(separator_1_1);
			
			JLabel lblThngTinCh_1 = new JLabel("Thông tin khai báo");
			lblThngTinCh_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblThngTinCh_1.setBounds(10, 206, 140, 25);
			getContentPane().add(lblThngTinCh_1);
			
		/*
		 * Text Field
		 * */
			txtCCCD = new InputField("ID người test(*)");
			txtCCCD.setBounds(10, 63, 328, 51);
			getContentPane().add(txtCCCD);
			txtCCCD.setColumns(10);
			
			txtKetQua = new InputField("Kết quả(*)");
			txtKetQua.setBounds(10, 293, 464, 51);
			getContentPane().add(txtKetQua);
			txtKetQua.setColumns(10);
			
			txtNamTest = new InputField("Năm test (*)");
			txtNamTest.setBounds(271, 237, 128, 45);
			getContentPane().add(txtNamTest);
			
			txtNgayTest = new ComboBox<String>();
			txtNgayTest.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
			txtNgayTest.setSelectedIndex(-1);
			txtNgayTest.setMaximumRowCount(32);
			txtNgayTest.setLabelText("Ngày test (*)");
			txtNgayTest.setBounds(10, 237, 111, 45);
			getContentPane().add(txtNgayTest);
			
			txtThangTest = new ComboBox<String>();
			txtThangTest.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
			txtThangTest.setSelectedIndex(-1);
			txtThangTest.setMaximumRowCount(30);
			txtThangTest.setLabelText("Tháng test (*)");
			txtThangTest.setBounds(139, 237, 111, 45);
			getContentPane().add(txtThangTest);
			
		/*
		 * Table
		 * */
			table = new Table();
			Object[] columns =  {"ID", "Họ tên", "CCCD", "Ghi chu"};
			table.model.setColumnIdentifiers(columns);
				
			ScrollPane scrollPane = new ScrollPane(table);
			scrollPane.setBounds(10, 125, 464, 57);
			getContentPane().add(scrollPane);
			
		/*
		 ** Buttons
		 */
			Button btnXcNhn = new Button("Xác nhận");
			btnXcNhn.setBounds(31, 368, 118, 68);
			getContentPane().add(btnXcNhn);
			btnXcNhn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					xacNhanThem();
				}
			});
			
			Button btnReset = new Button("Reset");
			btnReset.setBounds(179, 368, 118, 68);
			getContentPane().add(btnReset);
			btnReset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					reset();
				}
			});
			
			Button btnThoat = new Button("Thoát");
			btnThoat.setBounds(332, 368, 118, 68);
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
			JOptionPane.showMessageDialog(this, "Nhập nhân khẩu test!");
		}else if(txtKetQua.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "Nhập kết quả!");
		}else if(txtNgayTest.getSelectedIndex()==-1) {
			JOptionPane.showMessageDialog(this, "Chọn ngày test!");
		}else if(txtThangTest.getSelectedIndex()==-1) {
			JOptionPane.showMessageDialog(this, "Chọn tháng test!");
		}else if(txtNamTest.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "Nhập năm test!");
		}else if(nL.getGhiChu().equals("Đã qua đời")) {
			JOptionPane.showMessageDialog(this, "Nhân khẩu đã qua đời!");
		}else check = true;
		int nam = -1;
		try {
			nam = Integer.parseInt(txtNamTest.getText())-1900;
		} catch (Exception e) {
			check = false;
			JOptionPane.showMessageDialog(this, "Năm phải là số!");
		}
		
		if(true) {
			String ketqua = txtKetQua.getText();
			int ngay = txtNgayTest.getSelectedIndex()+1;
			int thang = txtThangTest.getSelectedIndex();
			@SuppressWarnings("deprecation")
			Date ngaykb = new Date(nam, thang, ngay);
			Covid_TestCovid t = new Covid_TestCovid(nL, ngaykb, ketqua);
			if(controller.themTest(t)) {
				JOptionPane.showMessageDialog(this, "Thêm thành công!");
				dispose();
			}else JOptionPane.showMessageDialog(this, "Thêm thất bại!");
		}
	}
	
	public void reset() {
		txtCCCD.setText("");
		txtKetQua.setText("");
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
