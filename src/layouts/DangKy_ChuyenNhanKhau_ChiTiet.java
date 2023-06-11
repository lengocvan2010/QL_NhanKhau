package layouts;

import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSeparator;

import controller.DichVuController;
import controller.HoKhauController;
import controller.NhanKhauController;
import index.Button;
import index.InputField;
import index.Label;
import index.ScrollPane;
import index.Table;
import qL_NhanKhau.*;
import sql.ConnectSQL;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import index.ComboBox;

public class DangKy_ChuyenNhanKhau_ChiTiet extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	InputField txtNamDK;
	Table table_NguoiChuyen, table_HoKhauCu, table_HoKhauMoi;
	
	ConnectSQL c;
	HoKhauController hC;
	HoKhau hcL;
	HoKhau hmL;
	
	NhanKhauController nC;
	NhanKhau nL;
	DichVuController dC;
	DichVu_ChuyenNhanKhau d;
	
	ComboBox<String> txtNgayDK, txtThangDK;
	/**
	 * Create the dialog.
	 * @param k 
	 */
	public DangKy_ChuyenNhanKhau_ChiTiet(ConnectSQL cc, DichVu_ChuyenNhanKhau k) {
		setTitle("Tạm vắng");
		getContentPane().setLayout(null);
		setBounds(100, 100, 500, 450);
		setLocationRelativeTo(null);
		c = cc;
		nC = new NhanKhauController(c);
		hC = new HoKhauController(c);
		dC = new DichVuController(c);
		d=k;
		nL = nC.timNhanKhauId(d.getNhanKhau().getId());
		hcL = hC.timHoKhau(d.getHoKhauChuyenDi().getSoHoKhau());
		hmL = hC.timHoKhau(d.getHoKhauChuyenDen().getSoHoKhau());
		/*
		 * Labels
		 */
		
			Label lblThemHK = new Label("Thông tin chuyển nhân khẩu");
			lblThemHK.setBounds(10, 10, 260, 19);
			getContentPane().add(lblThemHK);	
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 35, 850, 2);
			getContentPane().add(separator);
			JSeparator separator_1 = new JSeparator();
			separator_1.setBounds(10, 359, 850, 2);
			getContentPane().add(separator_1);
			
			JLabel lblThngTinCh = new JLabel("Người chuyển");
			lblThngTinCh.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblThngTinCh.setBounds(10, 40, 167, 25);
			getContentPane().add(lblThngTinCh);		
			JSeparator separator_1_1 = new JSeparator();
			separator_1_1.setBounds(10, 138, 850, 2);
			getContentPane().add(separator_1_1);
			
			JLabel lblThngTinCh_1 = new JLabel("Hộ khẩu cũ");
			lblThngTinCh_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblThngTinCh_1.setBounds(10, 151, 167, 25);
			getContentPane().add(lblThngTinCh_1);
			
			JLabel lblThngTinCh_1_1 = new JLabel("Hộ khẩu mới");
			lblThngTinCh_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblThngTinCh_1_1.setBounds(10, 255, 167, 25);
			getContentPane().add(lblThngTinCh_1_1);
		/*
		 * Table
		 * */
			table_NguoiChuyen = new Table();
			Object[] columns_NguoiChuyen =  {"ID", "Họ tên", "Số Hộ khẩu", "Ghi chú"};
			table_NguoiChuyen.model.setColumnIdentifiers(columns_NguoiChuyen);	
			table_NguoiChuyen.model.addRow(new Object[] {
					nL.getId(),nL.getTen(),nL.getSoHK(),nL.getGhiChu()
			});
			ScrollPane scrollPane_NguoiChuye = new ScrollPane(table_NguoiChuyen);
			scrollPane_NguoiChuye.setBounds(10, 70, 464, 57);
			getContentPane().add(scrollPane_NguoiChuye);
			
			
			table_HoKhauCu = new Table();
			Object[] columns_HoKhauCu =  {"Số Hộ khẩu", "Chủ Hộ", "Địa chỉ"};
			table_HoKhauCu.model.setColumnIdentifiers(columns_HoKhauCu);
			table_HoKhauCu.model.addRow(new Object[] {
					hcL.getSoHoKhau(),hcL.getChuHo().getTen(),hcL.getDiaChi()
			});
			ScrollPane scrollPane_HoKhauCu = new ScrollPane(table_HoKhauCu);
			scrollPane_HoKhauCu.setBounds(10, 187, 464, 57);
			getContentPane().add(scrollPane_HoKhauCu);
			
			table_HoKhauMoi = new Table();
			Object[] columns_HoKhauMoi =  {"Số Hộ khẩu", "Chủ Hộ", "Địa chỉ"};
			table_HoKhauMoi.model.setColumnIdentifiers(columns_HoKhauMoi);
			table_HoKhauMoi.model.addRow(new Object[] {
					hmL.getSoHoKhau(),hmL.getChuHo().getTen(),hmL.getDiaChi()
			});
			ScrollPane scrollPane_HoKhauMoi = new ScrollPane(table_HoKhauMoi);
			scrollPane_HoKhauMoi.setBounds(10, 291, 464, 57);
			getContentPane().add(scrollPane_HoKhauMoi);
			
			
		/*
		 * Input
		 * */
			
			
		/*
		 * Button
		 * */
			Button btnThoat = new Button("Close");
			btnThoat.setBounds(172, 372, 118, 25);
			getContentPane().add(btnThoat);
			btnThoat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			
	}
}
