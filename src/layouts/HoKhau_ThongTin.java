package layouts;

import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JDialog;

import index.Label;
import index.ScrollPane;
import index.Table;
import qL_NhanKhau.HoKhau;
import qL_NhanKhau.NhanKhau;

import javax.swing.JSeparator;
import javax.swing.table.DefaultTableModel;

import controller.CONTROLLER;
import controller.HoKhauController;
import controller.NhanKhauController;
import index.Button;
import index.InputField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class HoKhau_ThongTin extends JDialog {
	Table table;
	InputField txtDiaChi;
	InputField txtSoHoKhau;
	HoKhau h;
	CONTROLLER c;
	NhanKhauController nC;
	
	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public HoKhau_ThongTin(HoKhau ho, HoKhauController hC) {
		this.h=ho;
		this.h.setNkL(hC.dsThanhVien(h));
		setIconImage(Toolkit.getDefaultToolkit().getImage("otherResource/HoKhau16.png"));
		setTitle("Thông tin hộ khẩu");
		getContentPane().setLayout(null);
		setBounds(100, 100, 600, 700);
		setLocationRelativeTo(null);
		
		/*
		 * Table
		 * */
			table = new Table();
			Object[] columns =  {"ID", "Họ và tên", "Ngày sinh", "Giới tính", "CCCD/CMND", "Quan hệ chủ hộ"};
			table.model.setColumnIdentifiers(columns);
			
			ScrollPane scrollPane = new ScrollPane(table);
			scrollPane.setBounds(10, 234, 564, 371);
			getContentPane().add(scrollPane);
			
		
	/*
	 * Label
	 * */
		Label lblThemHK = new Label("Thông tin hộ khẩu");
		lblThemHK.setIcon(new ImageIcon("otherResource/HoKhau16.png"));
		lblThemHK.setBounds(10, 10, 258, 19);
		getContentPane().add(lblThemHK);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 40, 850, 2);
		getContentPane().add(separator);
		
		JLabel lblThongTinThanh = new JLabel("Thông tin thành viên");
		lblThongTinThanh.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblThongTinThanh.setBounds(10, 204, 197, 19);
		getContentPane().add(lblThongTinThanh);
	
	/*
	 * Information
	 * */
		txtDiaChi = new InputField("Địa chỉ");
		txtDiaChi.setText(h.getDiaChi());
		txtDiaChi.setEditable(false);
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(10, 131, 564, 57);
		getContentPane().add(txtDiaChi);
		
		txtSoHoKhau = new InputField("Số hộ khẩu");
		txtSoHoKhau.setText(h.getSoHoKhau());
		txtSoHoKhau.setEditable(false);
		txtSoHoKhau.setColumns(10);
		txtSoHoKhau.setBounds(10, 69, 564, 51);
		getContentPane().add(txtSoHoKhau);
		
	/*
	 * Button
	 * */

		Button btnNewButton = new Button("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(357, 616, 89, 23);
		getContentPane().add(btnNewButton);
		
		
		Button btnThongTinTV = new Button("Thông tin thành viên");
		btnThongTinTV.setBounds(111, 616, 184, 23);
		getContentPane().add(btnThongTinTV);
		btnThongTinTV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chiTiet(h.getNkL());
			}
		});
		
		
		hienThiDanhSachThanhVien(h.getNkL());
	}
	
	void hienThiDanhSachThanhVien(ArrayList<NhanKhau> l) {
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
						"ID", "Họ và tên", "Ngày sinh", "Giới tính", "CCCD/CMND", "Quan hệ chủ hộ"
				}
				));
		DefaultTableModel mta = (DefaultTableModel) table.getModel();
		for(int i=0;i<l.size();i++) {
			NhanKhau n = l.get(i);
			mta.addRow(new Object[] {
					n.getId(),n.getTen(),n.getNgaySinh(),n.getGioiTinh(),n.getCCCD(),n.getQuanHeChuHo()
			});
		}
	}
	
	public void chiTiet(ArrayList<NhanKhau> l) {
		int i = table.getSelectedRow();
		if(i>=0) {
			NhanKhau nT = l.get(i);
			NhanKhau_ThongTin thongTinNhanKhau = new NhanKhau_ThongTin(nT);
			thongTinNhanKhau.setVisible(true);
		}else JOptionPane.showMessageDialog(this, "Chọn 1 nhân khẩu!!!");
	}
}
