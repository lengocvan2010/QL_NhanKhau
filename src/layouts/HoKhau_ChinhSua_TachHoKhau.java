package layouts;

import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JDialog;

import index.Label;
import index.ScrollPane;
import index.Table;
import qL_NhanKhau.HoKhau;
import qL_NhanKhau.NhanKhau;
import sql.ConnectSQL;

import javax.swing.JSeparator;
import javax.swing.table.DefaultTableModel;

import controller.HoKhauController;
import index.Button;
import index.InputField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

public class HoKhau_ChinhSua_TachHoKhau extends JDialog {
	Table table_ThanhVien;
	InputField txtDiaChi;
	InputField txtSoHoKhau;
	HoKhau hL;
	
	ConnectSQL c;
	HoKhauController hC;
	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public HoKhau_ChinhSua_TachHoKhau(HoKhau ho, ConnectSQL cc) {
		c = cc;
		hC = new HoKhauController(c);
		this.hL=ho;
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("otherResource/HoKhau16.png"));
		setTitle("Đổi chủ hộ");
		getContentPane().setLayout(null);
		setBounds(100, 100, 600, 700);
		setLocationRelativeTo(null);
		
		/*
		 * Table
		 * */
			table_ThanhVien = new Table();
			table_ThanhVien.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			Object[] columns =  {"ID", "Họ và tên", "Ngày sinh", "Giới tính", "CCCD/CMND", "Quan hệ chủ hộ"};
			table_ThanhVien.model.setColumnIdentifiers(columns);
			
			ScrollPane scrollPane = new ScrollPane(table_ThanhVien);
			scrollPane.setBounds(10, 235, 564, 370);
			getContentPane().add(scrollPane);
			
		
	/*
	 * Label
	 * */
		Label lblThemHK = new Label("Tách hộ khẩu");
		lblThemHK.setIcon(new ImageIcon("otherResource/HoKhau16.png"));
		lblThemHK.setBounds(10, 10, 258, 19);
		getContentPane().add(lblThemHK);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 40, 850, 2);
		getContentPane().add(separator);
		
		JLabel lblThongTinThanh = new JLabel("Thông tin thành viên");
		lblThongTinThanh.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblThongTinThanh.setBounds(10, 199, 197, 19);
		getContentPane().add(lblThongTinThanh);
	
	/*
	 * Information
	 * */
		txtDiaChi = new InputField("Địa chỉ (*)");
		txtDiaChi.setText("");
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(10, 131, 564, 57);
		getContentPane().add(txtDiaChi);
		
		txtSoHoKhau = new InputField("Số hộ khẩu (*)");
		txtSoHoKhau.setText("");
		txtSoHoKhau.setColumns(10);
		txtSoHoKhau.setBounds(10, 69, 564, 51);
		getContentPane().add(txtSoHoKhau);
		
	/*
	 * Button
	 * */

		Button btnNewButton = new Button("Huỷ");
		btnNewButton.setBounds(335, 616, 89, 23);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		Button btnXacNhan = new Button("Xác nhận");
		btnXacNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xacNhan();
			}
		});
		btnXacNhan.setBounds(99, 616, 133, 23);
		getContentPane().add(btnXacNhan);
		
		JLabel lblThongTinThanh_1 = new JLabel("(Vui lòng sửa lại quan hệ chủ hộ!!)");
		lblThongTinThanh_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblThongTinThanh_1.setBounds(187, 199, 237, 19);
		getContentPane().add(lblThongTinThanh_1);
		
		
		hienThiDanhSachThanhVien(hL.getNkL());
	}
	
	
	
	void hienThiDanhSachThanhVien(ArrayList<NhanKhau> l) {
		table_ThanhVien.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
						"ID", "Họ và tên", "Ngày sinh", "Giới tính", "CCCD/CMND", "Quan hệ chủ hộ"
				}
				));
		DefaultTableModel mta = (DefaultTableModel) table_ThanhVien.getModel();
		for(int i=0;i<l.size();i++) {
			NhanKhau n = l.get(i);
				mta.addRow(new Object[] {
						n.getId(),n.getTen(),n.getNgaySinh(),n.getGioiTinh(),n.getCCCD(),n.getQuanHeChuHo()
				});
		}
	}
	
	public void xacNhan() {
		boolean check = false;
		if(txtSoHoKhau.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "Nhập số HK!!");
		}else if(txtDiaChi.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "Nhập địa chỉ!!");
		} check = true;
		
		HoKhau tmp = hC.timHoKhau(txtSoHoKhau.getText());
		if(tmp.getSoHoKhau()!=null) {
			JOptionPane.showMessageDialog(this, "HK đã tồn tại!!");
			check = false;
		}
		if(check) {
			hL.setDiaChi(txtDiaChi.getText());
			hL.setSoHoKhau(txtSoHoKhau.getText());
			int a = 0;
			for (int i = 0; i < hL.getNkL().size(); i++) {
				hL.getNkL().get(i).setQuanHeChuHo((String)table_ThanhVien.getValueAt(i, 5));
				if(hL.getNkL().get(i).getQuanHeChuHo().equals("Chủ hộ")) a++;
			}
			if(a!=1) {
				JOptionPane.showMessageDialog(this, "Chỉ có đúng 1 chủ hộ!!");
			}else {
				hC.themHK(hL);
				for(int i =0;i<hL.getNkL().size();i++) {
					hC.xoaNKHK(hL.getNkL().get(i));
					hC.themThanhVien(hL, hL.getNkL().get(i));
					
				}
				JOptionPane.showMessageDialog(this, "Thêm thành công!!");
				dispose();
			}
		}
		
	}
}
