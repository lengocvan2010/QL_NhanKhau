package layouts;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.table.DefaultTableModel;

import controller.DichVuController;
import controller.NhanKhauController;
import index.Button;
import index.InputField;
import index.Label;
import index.ScrollPane;
import index.Table;
import qL_NhanKhau.DichVu_TamTru;
import qL_NhanKhau.NhanKhau;
import sql.ConnectSQL;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import index.ComboBox;

public class DangKy_TamTru extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ComboBox<String> txtTuNgay;
	ComboBox<String> txtTuThang;
	InputField txtTuNam;
	InputField txtCCCD;
	InputField txtThuongTru;
	InputField txtTamTru;
	
	Table table;
	ScrollPane scrollPane;
	
	NhanKhau nL;
	NhanKhauController nC;
	DichVuController dC;
	ConnectSQL c;
	
	/**
	 * Create the dialog.
	 */
	public DangKy_TamTru(ConnectSQL cc) {
		this.c = cc;
		nC = new NhanKhauController(c);
		dC = new DichVuController(c);
		setTitle("Tạm trú");
		getContentPane().setLayout(null);
		setBounds(100, 100, 500, 550);
		setLocationRelativeTo(null);
	
		/*
		 * Labels
		 */
		
			Label lblThemHK = new Label("Tạm trú");
			lblThemHK.setIcon(new ImageIcon("otherResource/HoKhau16.png"));
			lblThemHK.setBounds(10, 10, 167, 19);
			getContentPane().add(lblThemHK);
			
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 35, 850, 2);
			getContentPane().add(separator);
			JSeparator separator_1 = new JSeparator();
			separator_1.setBounds(10, 429, 850, 2);
			getContentPane().add(separator_1);
			
			JLabel lblThngTinCh = new JLabel("CCCD người đăng ký(*)");
			lblThngTinCh.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblThngTinCh.setBounds(10, 40, 167, 25);
			getContentPane().add(lblThngTinCh);
			JSeparator separator_1_1 = new JSeparator();
			separator_1_1.setBounds(10, 193, 850, 2);
			getContentPane().add(separator_1_1);
			
			JLabel lblThngTinCh_1 = new JLabel("Thời gian từ ngày(*)");
			lblThngTinCh_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblThngTinCh_1.setBounds(10, 337, 140, 25);
			getContentPane().add(lblThngTinCh_1);
			
			JLabel lblThngTinCh_1_1 = new JLabel("đến nay");
			lblThngTinCh_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblThngTinCh_1_1.setBounds(407, 376, 67, 25);
			getContentPane().add(lblThngTinCh_1_1);
			
		/*
		 * Text Field
		 * */
			txtCCCD = new InputField("CCCD/CMND(*)");
			txtCCCD.setBounds(10, 63, 328, 51);
			getContentPane().add(txtCCCD);
			txtCCCD.setColumns(10);
			
			txtTuNam = new InputField("Năm(*)");
			txtTuNam.setBounds(271, 361, 111, 45);
			getContentPane().add(txtTuNam);
			
			txtThuongTru = new InputField("Địa chỉ thường trú(*)");
			txtThuongTru.setColumns(10);
			txtThuongTru.setBounds(10, 212, 464, 51);
			getContentPane().add(txtThuongTru);
			
			txtTamTru = new InputField("Địa chỉ tạm trú(*)");
			txtTamTru.setColumns(10);
			txtTamTru.setBounds(10, 275, 464, 51);
			getContentPane().add(txtTamTru);
			
			txtTuNgay = new ComboBox<String>();
			txtTuNgay.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
			txtTuNgay.setSelectedIndex(-1);
			txtTuNgay.setMaximumRowCount(32);
			txtTuNgay.setLabelText("Ngày(*)");
			txtTuNgay.setBounds(10, 361, 111, 45);
			getContentPane().add(txtTuNgay);
			
			txtTuThang = new ComboBox<String>();
			txtTuThang.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
			txtTuThang.setSelectedIndex(-1);
			txtTuThang.setMaximumRowCount(30);
			txtTuThang.setLabelText("Tháng(*)");
			txtTuThang.setBounds(139, 361, 111, 45);
			getContentPane().add(txtTuThang);
			
		/*
		 * Table
		 * */
			table = new Table();
			Object[] columns =  {"ID", "Họ tên", "CCCD", "Ghi chú"};
			table.model.setColumnIdentifiers(columns);
			
			scrollPane = new ScrollPane(table);
			scrollPane.setBounds(10, 125, 464, 57);
			getContentPane().add(scrollPane);
			
		/*
		 ** Buttons
		 */
			Button btnXcNhn = new Button("Xác nhận");
			btnXcNhn.setBounds(31, 447, 118, 53);
			getContentPane().add(btnXcNhn);
			btnXcNhn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					xacNhan();
				}
			});
			
			Button btnReset = new Button("Reset");
			btnReset.setBounds(179, 447, 118, 53);
			getContentPane().add(btnReset);
			btnReset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					reset();
				}
			});
			
			Button btnThoat = new Button("Thoát");
			btnThoat.setBounds(332, 447, 118, 53);
			getContentPane().add(btnThoat);
			btnThoat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			
			Button btnXcNhn_CCCD = new Button("Xác nhận");
			btnXcNhn_CCCD.setBounds(370, 78, 104, 29);
			getContentPane().add(btnXcNhn_CCCD);
			btnXcNhn_CCCD.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					xacNhan_CCCD();
				}
			});
			
	}
	
	/*
	 * Events
	 * */
	public void xacNhan() {
		nL = nC.timNhanKhauId(txtCCCD.getText());
		
		boolean check = false;
		if(nL.getCCCD()==null) {
			JOptionPane.showMessageDialog(this, "Nhập nhân khẩu khai báo!");
		}else if(txtTamTru.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "Nhập địa chỉ tạm trú!");
		}else if(txtThuongTru.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "Nhập địa chỉ thường trú!");
		}else if(txtTuNgay.getSelectedIndex()==-1) {
			JOptionPane.showMessageDialog(this, "Chọn ngày tạm trú!");
		}else if(txtTuThang.getSelectedIndex()==-1) {
			JOptionPane.showMessageDialog(this, "Chọn tháng tạm trú!");
		}else if(txtTuNam.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "Nhập năm tạm trú!");
		}else if(nL.getGhiChu().equals("Đã qua đời")) {
			JOptionPane.showMessageDialog(this, "Nhân khẩu đã qua đời!");
		}else check = true;
		int nam = -1;
		try {
			nam  = Integer.parseInt(txtTuNam.getText())-1900;
		} catch (Exception e) {
			check = false;
			JOptionPane.showMessageDialog(this, "Năm phải là số!");
		}
		if(check) {
			@SuppressWarnings("deprecation")
			Date ngayTamTru = new Date(nam, txtTuThang.getSelectedIndex(), txtTuNgay.getSelectedIndex()+1);
			DichVu_TamTru d = new DichVu_TamTru(nL, null, ngayTamTru, txtThuongTru.getText(), txtTamTru.getText());
			if(dC.themTamTru(d)) {
				JOptionPane.showMessageDialog(this, "Thêm thành công!");
				dispose();
			}else JOptionPane.showMessageDialog(this, "Thêm thất bại!");
		}
		
	}
	
	public void reset() {
		txtCCCD.setText("");
		if(table.getRowCount() > 0) {
			table.model.removeRow(0);
		}
	}
	
	public void xacNhan_CCCD() {
		nL  =  nC.timNhanKhauId(txtCCCD.getText());
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"ID", "Họ tên", "CCCD", "Ghi chú"
				}
				));
		DefaultTableModel mta_NguoiKhai = (DefaultTableModel) table.getModel();
		if(nL.getCCCD()!=null) {
			mta_NguoiKhai.addRow(new Object[] {
					nL.getId(),nL.getTen(),nL.getCCCD(),nL.getGhiChu()
			});
		}
	}
}
