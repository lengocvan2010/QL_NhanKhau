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
import qL_NhanKhau.DichVu_TamVang;
import qL_NhanKhau.NhanKhau;
import sql.ConnectSQL;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import index.ComboBox;

public class DangKy_TamVang extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ComboBox<String> txtTuNgay;
	ComboBox<String> txtDenNgay;
	ComboBox<String> txtTuThang;
	ComboBox<String> txtDenThang;
	InputField txtTuNam;
	InputField txtDenNam;
	InputField txtCCCD;
	InputField txtTamTru;
	InputField txtLyDo;
	
	Table table;
	ScrollPane scrollPane;
	
	ConnectSQL c;
	NhanKhau nL;
	NhanKhauController nC;
	DichVuController dC;
	
	/**
	 * Create the dialog.
	 */
	public DangKy_TamVang(ConnectSQL cc) {
		this.c = cc;
		nC = new NhanKhauController(c);
		dC = new DichVuController(c);
		setTitle("Tạm vắng");
		getContentPane().setLayout(null);
		setBounds(100, 100, 500, 600);
		setLocationRelativeTo(null);
	
		/*
		 * Labels
		 */
		
			Label lblThemHK = new Label("Tạm vắng");
			lblThemHK.setIcon(new ImageIcon("otherResource/HoKhau16.png"));
			lblThemHK.setBounds(10, 10, 167, 19);
			getContentPane().add(lblThemHK);
			
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 35, 850, 2);
			getContentPane().add(separator);
			JSeparator separator_1 = new JSeparator();
			separator_1.setBounds(10, 479, 850, 2);
			getContentPane().add(separator_1);
			
			JLabel lblThngTinCh = new JLabel("CCCD người đăng ký");
			lblThngTinCh.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblThngTinCh.setBounds(10, 40, 167, 25);
			getContentPane().add(lblThngTinCh);
			
			JSeparator separator_1_1 = new JSeparator();
			separator_1_1.setBounds(10, 193, 850, 2);
			getContentPane().add(separator_1_1);
			
			JLabel lblThngTinCh_1 = new JLabel("Thời gian từ ngày");
			lblThngTinCh_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblThngTinCh_1.setBounds(10, 269, 140, 25);
			getContentPane().add(lblThngTinCh_1);
			
			scrollPane = new ScrollPane(table);
			scrollPane.setBounds(10, 125, 464, 57);
			getContentPane().add(scrollPane);
			
			JLabel lblThngTinCh_1_1 = new JLabel("Đến ngày");
			lblThngTinCh_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblThngTinCh_1_1.setBounds(10, 349, 140, 25);
			getContentPane().add(lblThngTinCh_1_1);
			
		/*
		 * Text Field
		 * */
			txtCCCD = new InputField("CCCD/CMND");
			txtCCCD.setBounds(10, 63, 328, 51);
			getContentPane().add(txtCCCD);
			txtCCCD.setColumns(10);
			
			txtTuNam = new InputField("Năm");
			txtTuNam.setBounds(271, 293, 111, 45);
			getContentPane().add(txtTuNam);
			
			txtDenNam = new InputField("Năm");
			txtDenNam.setBounds(271, 373, 111, 45);
			getContentPane().add(txtDenNam);
			
			txtTamTru = new InputField("Địa chỉ tạm trú");
			txtTamTru.setColumns(10);
			txtTamTru.setBounds(10, 212, 464, 51);
			getContentPane().add(txtTamTru);
			
			txtTuNgay = new ComboBox<String>();
			txtTuNgay.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
			txtTuNgay.setSelectedIndex(-1);
			txtTuNgay.setMaximumRowCount(32);
			txtTuNgay.setLabelText("Ngày");
			txtTuNgay.setBounds(10, 293, 111, 45);
			getContentPane().add(txtTuNgay);
			
			txtTuThang = new ComboBox<String>();
			txtTuThang.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
			txtTuThang.setSelectedIndex(-1);
			txtTuThang.setMaximumRowCount(30);
			txtTuThang.setLabelText("Tháng");
			txtTuThang.setBounds(139, 293, 111, 45);
			getContentPane().add(txtTuThang);
			
			txtDenNgay = new ComboBox<String>();
			txtDenNgay.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
			txtDenNgay.setSelectedIndex(-1);
			txtDenNgay.setMaximumRowCount(32);
			txtDenNgay.setLabelText("Ngày");
			txtDenNgay.setBounds(10, 373, 111, 45);
			getContentPane().add(txtDenNgay);
			
			txtDenThang = new ComboBox<String>();
			txtDenThang.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
			txtDenThang.setSelectedIndex(-1);
			txtDenThang.setMaximumRowCount(30);
			txtDenThang.setLabelText("Tháng");
			txtDenThang.setBounds(139, 373, 111, 45);
			getContentPane().add(txtDenThang);
			
			txtLyDo = new InputField("Lý do");
			txtLyDo.setColumns(10);
			txtLyDo.setBounds(10, 424, 464, 51);
			getContentPane().add(txtLyDo);
			
		/*
		 * Table
		 * */
			table = new Table();
			Object[] columns =  {"ID", "Họ tên", "CCCD", "Ghi chu"};
			table.model.setColumnIdentifiers(columns);
			
			scrollPane = new ScrollPane(table);
			scrollPane.setBounds(10, 125, 464, 57);
			getContentPane().add(scrollPane);
			
		/*
		 ** Buttons
		 */
			Button btnXcNhn = new Button("Xác nhận");
			btnXcNhn.setBounds(31, 497, 118, 53);
			getContentPane().add(btnXcNhn);
			btnXcNhn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					xacNhan();
				}
			});
			
			Button btnReset = new Button("Reset");
			btnReset.setBounds(179, 497, 118, 53);
			getContentPane().add(btnReset);
			btnReset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					reset();
				}
			});
			
			Button btnThoat = new Button("Thoát");
			btnThoat.setBounds(332, 497, 118, 53);
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
		if(nL.getId()==null) {
			JOptionPane.showMessageDialog(this, "Nhập nhân khẩu!");
		}else if(txtLyDo.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "Nhập địa chỉ tạm trú!");
		}else if(txtTamTru.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "Nhập lí do!");
		}else if(txtTuNgay.getSelectedIndex()==-1||txtTuThang.getSelectedIndex()==-1||txtDenNgay.getSelectedIndex()==-1||
				txtDenThang.getSelectedIndex()==-1||txtTuNam.getText().isBlank()||txtDenNam.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "Hãy nhập đủ ngày, tháng, năm!");
		}else if(nL.getGhiChu().equals("Đã qua đời")) {
			JOptionPane.showMessageDialog(this, "Nhân khẩu đã qua đời!");
		}else check = true;
		int tungay = txtTuNgay.getSelectedIndex()+1;
		int tuthang = txtTuThang.getSelectedIndex();
		int denngay = txtDenNgay.getSelectedIndex()+1;
		int denthang = txtDenThang.getSelectedIndex();
		int tunam=-1,dennam=-1;
		try {
			tunam = Integer.parseInt(txtTuNam.getText())-1900;
			dennam = Integer.parseInt(txtDenNam.getText())-1900;
		} catch (Exception e) {
			check = false;
			JOptionPane.showMessageDialog(this, "Năm phải là số!");
		}
		if(check) {
			@SuppressWarnings("deprecation")
			Date tuDate = new Date(tunam, tuthang, tungay);
			@SuppressWarnings("deprecation")
			Date denDate = new Date(dennam, denthang, denngay);
			DichVu_TamVang d = new DichVu_TamVang(nL, null, tuDate, txtTamTru.getText(), tuDate, denDate, txtLyDo.getText());
			if(dC.themTamVang(d)) {JOptionPane.showMessageDialog(this, "Thêm thành công!"); dispose();}
			else JOptionPane.showMessageDialog(this, "Thêm thất bại!");
		}
		
	}
	
	public void reset() {
		txtCCCD.setText("");
		if(table.getRowCount() > 0) {
			table.model.removeRow(0);
		}
		txtTuNgay.setSelectedIndex(-1);
		txtTuThang.setSelectedIndex(-1);
		txtTuNam.setText("");
		txtDenNgay.setSelectedIndex(-1);
		txtDenThang.setSelectedIndex(-1);
		txtDenNam.setText("");
		txtTamTru.setText("");
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
