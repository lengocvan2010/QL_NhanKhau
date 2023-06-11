package layouts;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSeparator;

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
import java.awt.event.ActionEvent;
import index.ComboBox;

public class DangKy_TamTru_ChiTiet extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	NhanKhau nL;
	NhanKhauController nC;
	DichVuController dC;
	ConnectSQL c;
	Table table_NguoiDK;
	ScrollPane scrollPane_NguoiDK;
	InputField txtThuongTru, txtTamTru, txtTuNam;
	ComboBox<String> txtTuNgay, txtTuThang;
	DichVu_TamTru d;
	/**
	 * Create the dialog.
	 * @param k 
	 */
	@SuppressWarnings("deprecation")
	public DangKy_TamTru_ChiTiet(ConnectSQL cc, DichVu_TamTru k) {
		this.c = cc;
		nC = new NhanKhauController(c);
		dC = new DichVuController(c);
		d=k;
		nL = nC.timNhanKhauId(d.getNhanKhau().getId());
		setTitle("Thông tin tạm trú");
		getContentPane().setLayout(null);
		setBounds(100, 100, 500, 420);
		setLocationRelativeTo(null);
	
		/*
		 * Labels
		 */
		
			Label lblThemHK = new Label("Thông tin tạm trú");
			lblThemHK.setBounds(10, 10, 189, 19);
			getContentPane().add(lblThemHK);
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 35, 850, 2);
			getContentPane().add(separator);
			
			JLabel lblThngTinCh = new JLabel("Người tạm trú");
			lblThngTinCh.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblThngTinCh.setBounds(10, 40, 140, 25);
			getContentPane().add(lblThngTinCh);
			
			JLabel lblThngTinCh_1 = new JLabel("Thời gian từ ngày(*)");
			lblThngTinCh_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblThngTinCh_1.setBounds(10, 258, 169, 25);
			getContentPane().add(lblThngTinCh_1);
			

			JLabel lblThngTinCh_1_1 = new JLabel("đến nay");
			lblThngTinCh_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblThngTinCh_1_1.setBounds(407, 309, 67, 25);
			getContentPane().add(lblThngTinCh_1_1);
		
		/*
		 * Input
		 * */
			txtThuongTru = new InputField("Địa chỉ thường trú");
			txtThuongTru.setEditable(false);
			txtThuongTru.setColumns(10);
			txtThuongTru.setBounds(10, 134, 464, 51);
			getContentPane().add(txtThuongTru);
			txtThuongTru.setText(d.getDiaChiThuongTru());
			
			txtTamTru = new InputField("Địa chỉ tạm trú");
			txtTamTru.setEditable(false);
			txtTamTru.setColumns(10);
			txtTamTru.setBounds(10, 196, 464, 51);
			getContentPane().add(txtTamTru);
			txtTamTru.setText(d.getDiaChiTamTru());
			
			txtTuNgay = new ComboBox<String>();
			txtTuNgay.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
			
			txtTuNgay.setMaximumRowCount(32);
			txtTuNgay.setLabelText("Ngày(*)");
			txtTuNgay.setBounds(10, 294, 111, 45);
			txtTuNgay.setSelectedIndex(d.getDate().getDate()-1);
			getContentPane().add(txtTuNgay);
			
			txtTuThang = new ComboBox<String>();
			txtTuThang.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
			
			txtTuThang.setMaximumRowCount(30);
			txtTuThang.setLabelText("Tháng(*)");
			txtTuThang.setBounds(139, 294, 111, 45);
			txtTuThang.setSelectedIndex(d.getDate().getMonth());
			getContentPane().add(txtTuThang);
			
			txtTuNam = new InputField("Năm(*)");
			txtTuNam.setEditable(false);
			txtTuNam.setBounds(271, 294, 111, 45);
			getContentPane().add(txtTuNam);
			txtTuNam.setText(""+(d.getDate().getYear()+1900));
			
		/*
		 * Table
		 * */
			table_NguoiDK = new Table();
			Object[] columns_NguoiKhai =  {"ID", "Họ tên", "CCCD", "Ghi chu"};
			table_NguoiDK.model.setColumnIdentifiers(columns_NguoiKhai);
			table_NguoiDK.model.addRow(new Object[] {
					nL.getId(),nL.getTen(),nL.getCCCD(),nL.getGhiChu()
			});
			
			scrollPane_NguoiDK = new ScrollPane(table_NguoiDK);
			scrollPane_NguoiDK.setBounds(10, 66, 464, 57);
			getContentPane().add(scrollPane_NguoiDK);
		
		/*
		 ** Buttons
		 */
			
			Button btnThoat = new Button("Close");
			btnThoat.setBounds(185, 345, 118, 25);
			getContentPane().add(btnThoat);
			btnThoat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
	}
}
