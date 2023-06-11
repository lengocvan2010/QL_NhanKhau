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
import qL_NhanKhau.DichVu_KhaiTu;
import qL_NhanKhau.NhanKhau;
import sql.ConnectSQL;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import index.ComboBox;

public class DangKy_KhaiTu_ChiTiet extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	NhanKhau nguoiKhai;
	NhanKhau nguoiMat;
	
	DichVu_KhaiTu d;
	
	NhanKhauController nC;
	DichVuController dC;
	ConnectSQL c;
	Table table_NguoiKhai, table_NguoiMat;
	ScrollPane scrollPane_NguoiKhai;
	ScrollPane scrollPane_NguoiMat;
	
	ComboBox<String> txtNgayKhai;
	ComboBox<String> txtThangKhai;
	InputField txtNamKhaiBao;
	
	/**
	 * Create the dialog.
	 */
	@SuppressWarnings("deprecation")
	public DangKy_KhaiTu_ChiTiet(ConnectSQL cc, DichVu_KhaiTu dd) {
		this.c = cc;
		nC = new NhanKhauController(c);
		dC = new DichVuController(c);
		d=dd;
		nguoiKhai = nC.timNhanKhauId(d.getNguoiKhai().getId());
		nguoiMat = nC.timNhanKhauId(d.getNhanKhau().getId());
		
		setTitle("Thông tin khai tử");
		getContentPane().setLayout(null);
		setBounds(100, 100, 500, 420);
		setLocationRelativeTo(null);
	
		/*
		 * Labels
		 */
		
			Label lblThemHK = new Label("Thông tin khai tử");
			lblThemHK.setBounds(10, 10, 189, 19);
			getContentPane().add(lblThemHK);
			
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 35, 850, 2);
			getContentPane().add(separator);
			
			JLabel lblThngTinCh = new JLabel("Người khai");
			lblThngTinCh.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblThngTinCh.setBounds(10, 40, 140, 25);
			getContentPane().add(lblThngTinCh);
			
			JSeparator separator_1_1 = new JSeparator();
			separator_1_1.setBounds(10, 144, 850, 11);
			getContentPane().add(separator_1_1);
			
			JLabel lblThngTinCh_1 = new JLabel("Người mất");
			lblThngTinCh_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblThngTinCh_1.setBounds(10, 155, 167, 25);
			getContentPane().add(lblThngTinCh_1);
			
		
		/*
		 * Input
		 * */
			txtNgayKhai = new ComboBox<String>();
			txtNgayKhai.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
			
			txtNgayKhai.setMaximumRowCount(32);
			txtNgayKhai.setLabelText("Ngày khai tử");
			txtNgayKhai.setBounds(103, 265, 111, 45);
			txtNgayKhai.setSelectedIndex(d.getDate().getDate()-1);
			getContentPane().add(txtNgayKhai);
			
			txtThangKhai = new ComboBox<String>();
			txtThangKhai.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
			
			txtThangKhai.setMaximumRowCount(30);
			txtThangKhai.setLabelText("Tháng khai tử");
			txtThangKhai.setBounds(224, 265, 111, 45);
			txtThangKhai.setSelectedIndex(d.getDate().getMonth());
			getContentPane().add(txtThangKhai);
			
			txtNamKhaiBao = new InputField("Năm khai tử");
			txtNamKhaiBao.setEditable(false);
			txtNamKhaiBao.setBounds(346, 265, 128, 43);
			getContentPane().add(txtNamKhaiBao);
			txtNamKhaiBao.setText(""+(d.getDate().getYear()+1900));
		/*
		 * Table
		 * */
			table_NguoiKhai = new Table();
			Object[] columns_NguoiKhai =  {"ID", "Họ tên", "CCCD", "Ghi chu"};
			table_NguoiKhai.model.setColumnIdentifiers(columns_NguoiKhai);
			table_NguoiKhai.model.addRow(new Object[] {
					nguoiKhai.getId(),nguoiKhai.getTen(),nguoiKhai.getCCCD(),nguoiKhai.getGhiChu()
			});
			
			scrollPane_NguoiKhai = new ScrollPane(table_NguoiKhai);
			scrollPane_NguoiKhai.setBounds(10, 76, 464, 57);
			getContentPane().add(scrollPane_NguoiKhai);
			
			table_NguoiMat = new Table();
			Object[] columns_NguoiMat =  {"ID", "Họ tên", "CCCD", "Ghi chu"};
			table_NguoiMat.model.setColumnIdentifiers(columns_NguoiMat);
			table_NguoiMat.model.addRow(new Object[] {
					nguoiMat.getId(),nguoiMat.getTen(),nguoiMat.getCCCD(),nguoiMat.getGhiChu()
			});
			
			scrollPane_NguoiMat = new ScrollPane(table_NguoiMat);
			scrollPane_NguoiMat.setBounds(10, 191, 464, 57);
			getContentPane().add(scrollPane_NguoiMat);
			
		/*
		 ** Buttons
		 */
			
			Button btnThoat = new Button("Close");
			btnThoat.setBounds(185, 333, 118, 25);
			getContentPane().add(btnThoat);
			btnThoat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
	}
}
