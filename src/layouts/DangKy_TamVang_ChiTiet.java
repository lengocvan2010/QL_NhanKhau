package layouts;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
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
import qL_NhanKhau.DichVu_TamVang;
import qL_NhanKhau.NhanKhau;
import sql.ConnectSQL;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import index.ComboBox;

public class DangKy_TamVang_ChiTiet extends JDialog {

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
	InputField txtTamTru;
	InputField txtLyDo;
	
	Table table;
	ScrollPane scrollPane;
	
	ConnectSQL c;
	DichVu_TamVang d;
	NhanKhau nL;
	NhanKhauController nC;
	DichVuController dC;
	
	/**
	 * Create the dialog.
	 * @param k 
	 */
	@SuppressWarnings("deprecation")
	public DangKy_TamVang_ChiTiet(ConnectSQL cc, DichVu_TamVang k) {
		this.c = cc;
		nC = new NhanKhauController(c);
		dC = new DichVuController(c);
		d = k;
		nL = nC.timNhanKhauId(d.getNhanKhau().getId());
		
		setTitle("Tạm vắng");
		getContentPane().setLayout(null);
		setBounds(100, 100, 500, 500);
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
			
			JLabel lblThngTinCh = new JLabel("CCCD người tạm vắng");
			lblThngTinCh.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblThngTinCh.setBounds(10, 40, 167, 25);
			getContentPane().add(lblThngTinCh);
			
			JSeparator separator_1_1 = new JSeparator();
			separator_1_1.setBounds(10, 139, 850, 2);
			getContentPane().add(separator_1_1);
			
			JLabel lblThngTinCh_1 = new JLabel("Thời gian từ ngày");
			lblThngTinCh_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblThngTinCh_1.setBounds(10, 215, 140, 25);
			getContentPane().add(lblThngTinCh_1);
			
			JLabel lblThngTinCh_1_1 = new JLabel("Đến ngày");
			lblThngTinCh_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblThngTinCh_1_1.setBounds(10, 295, 140, 25);
			getContentPane().add(lblThngTinCh_1_1);
			
			txtTuNam = new InputField("Năm");
			txtTuNam.setEditable(false);
			txtTuNam.setBounds(271, 239, 111, 45);
			txtTuNam.setText(""+(d.getTuNgay().getYear()+1900));
			getContentPane().add(txtTuNam);
			
			
			txtDenNam = new InputField("Năm");
			txtDenNam.setEditable(false);
			txtDenNam.setBounds(271, 319, 111, 45);
			txtDenNam.setText(""+(d.getDenNgay().getYear()+1900));
			getContentPane().add(txtDenNam);
			
			txtTamTru = new InputField("Địa chỉ tạm trú");
			txtTamTru.setEditable(false);
			txtTamTru.setColumns(10);
			txtTamTru.setBounds(10, 158, 464, 51);
			txtTamTru.setText(d.getDiaChiTamTru());
			getContentPane().add(txtTamTru);
			
			txtLyDo = new InputField("Lý do");
			txtLyDo.setEditable(false);
			txtLyDo.setColumns(10);
			txtLyDo.setBounds(10, 370, 464, 51);
			txtLyDo.setText(d.getLyDo());
			getContentPane().add(txtLyDo);
			
			txtTuNgay = new ComboBox<String>();
			txtTuNgay.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
			
			txtTuNgay.setMaximumRowCount(32);
			txtTuNgay.setLabelText("Ngày");
			txtTuNgay.setBounds(10, 239, 111, 45);
			txtTuNgay.setSelectedIndex(d.getTuNgay().getDate()-1);
			getContentPane().add(txtTuNgay);
			
			txtTuThang = new ComboBox<String>();
			txtTuThang.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
			
			txtTuThang.setMaximumRowCount(30);
			txtTuThang.setLabelText("Tháng");
			txtTuThang.setBounds(139, 239, 111, 45);
			txtTuThang.setSelectedIndex(d.getTuNgay().getMonth());
			getContentPane().add(txtTuThang);
			
			txtDenNgay = new ComboBox<String>();
			txtDenNgay.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
			
			txtDenNgay.setMaximumRowCount(32);
			txtDenNgay.setLabelText("Ngày");
			txtDenNgay.setBounds(10, 319, 111, 45);
			txtDenNgay.setSelectedIndex(d.getDenNgay().getDate()-1);
			getContentPane().add(txtDenNgay);
			
			txtDenThang = new ComboBox<String>();
			txtDenThang.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
			txtDenThang.setSelectedIndex(-1);
			txtDenThang.setMaximumRowCount(30);
			txtDenThang.setLabelText("Tháng");
			txtDenThang.setBounds(139, 319, 111, 45);
			txtDenNgay.setSelectedIndex(d.getDenNgay().getMonth());
			getContentPane().add(txtDenThang);
			
		/*
		 * Table
		 * */
			table = new Table();
			Object[] columns =  {"ID", "Họ tên", "CCCD", "Ghi chu"};
			table.model.setColumnIdentifiers(columns);
			table.model.addRow(new Object[] {
				nL.getId(),nL.getTen(),nL.getCCCD(),nL.getGhiChu()	
			});
			scrollPane = new ScrollPane(table);
			scrollPane.setBounds(10, 71, 464, 57);
			getContentPane().add(scrollPane);
			
			Button btnThoat = new Button("Close");
			btnThoat.setBounds(172, 432, 118, 25);
			getContentPane().add(btnThoat);
			
			btnThoat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
	}
}
