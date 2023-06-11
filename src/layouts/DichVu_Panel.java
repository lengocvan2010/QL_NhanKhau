package layouts;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.table.DefaultTableModel;

import controller.DichVuController;
import controller.NhanKhauController;
import index.Button;
import index.Label;
import index.ScrollPane;
import index.Table;
import qL_NhanKhau.DichVu;
import qL_NhanKhau.DichVu_ChuyenNhanKhau;
import qL_NhanKhau.DichVu_KhaiSinh;
import qL_NhanKhau.DichVu_KhaiTu;
import qL_NhanKhau.DichVu_TamTru;
import qL_NhanKhau.DichVu_TamVang;
import qL_NhanKhau.NhanKhau;
import sql.ConnectSQL;

public class DichVu_Panel extends JPanel {
	/**
	 * 
	 */
	ConnectSQL c;
	private static final long serialVersionUID = 1L;
	DichVu_DangKy dangKy;
	private Table table;
	ScrollPane scrollPane;
	ArrayList<DichVu> list;
	DichVuController controller;
	NhanKhauController nC;
	
	/**
	 * Create the panel.
	 */
	public DichVu_Panel(ConnectSQL cc) {
		c=cc;
		nC = new NhanKhauController(c);
		dangKy = new DichVu_DangKy(c);
		setLayout(null);
		setBounds(100, 100, 800, 500);
		controller = new DichVuController(c);
		list = controller.xemTT();
	/*
	 * Label
	 * */
		Label lblNewLabel = new Label("Dịch vụ");
		lblNewLabel.setBounds(0, 10, 790, 35);
		add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(212, 45, 400, 10);
		add(separator);
		
	/*
	 * TABLE
	 * */
		table = new Table();
		Object[] columns = {"ID", "Nhân khẩu","Ngày đăng kí","Dịch vụ"};
		table.model.setColumnIdentifiers(columns);
		
		scrollPane = new ScrollPane(table);
		scrollPane.setBounds(212, 102, 578, 387);
		add(scrollPane);
		
		
	/*
	 * BUTTON
	 * */
		
		Button btnUpdate = new Button("Làm mới");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		btnUpdate.setBounds(10, 145, 192, 35);
		add(btnUpdate);
		
		Button btnThemHK = new Button("Đăng ký Dịch vụ");
		btnThemHK.setBounds(10, 191, 192, 35);
		add(btnThemHK);
		btnThemHK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dangKy();
			}
		});
		
		Button btnXoaHK = new Button("Xoá thông tin");
		btnXoaHK.setBounds(10, 237, 192, 35);
		add(btnXoaHK);
		btnXoaHK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaThongTin();
			}
		});
		
		Button btnXemThanhVien = new Button("Chi tiết");
		btnXemThanhVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chiTiet();
			}
		});
		btnXemThanhVien.setBounds(10, 282, 192, 35);
		add(btnXemThanhVien);
		
		update();
	}
	
	public void update() {
		list = controller.xemTT();
		hienThiTable(list);
		scrollPane.setViewportView(table);
	}
	
	public void dangKy() {
		scrollPane.setViewportView(dangKy);
	}
	
	public void xoaThongTin() {
		scrollPane.setViewportView(table);
		DefaultTableModel mta = (DefaultTableModel)table.getModel();
		int i = table.getSelectedRow();
		if(i>=0) {
			int a = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xóa?");
			if(a==0) {
				if(list.get(i).getTenDichVu().equals("Khai sinh")) {
					DichVu_KhaiSinh k = controller.xemKhaiSinh(list.get(i).getId());
					if(controller.xoaKhaiSinh(k)) {
						controller.xoaNKHK(list.get(i).getNhanKhau());
						controller.xoaNhanKhau(list.get(i).getNhanKhau());
						JOptionPane.showMessageDialog(this, "Xóa thành công!");
					}else JOptionPane.showMessageDialog(this, "Xóa thất bại!");
				}else if(list.get(i).getTenDichVu().equals("Khai tử")) {
					DichVu_KhaiTu k = controller.xemKhaiTu(list.get(i).getId());
					if(controller.xoaKhaiTu(k)) {
						NhanKhau n = nC.timNhanKhauId(k.getNhanKhau().getId());
						n.setGhiChu(null);
						nC.updateNhanKhau(n);
						JOptionPane.showMessageDialog(this, "Xóa thành công!");
					}else JOptionPane.showMessageDialog(this, "Xóa thất bại!");
				}else if(list.get(i).getTenDichVu().equals("Tạm trú")) {
					DichVu_TamTru k = controller.xemTamTru(list.get(i).getId());
					if(controller.xoaTamTru(k)) JOptionPane.showMessageDialog(this, "Xóa thành công!");
					else JOptionPane.showMessageDialog(this, "Xóa thất bại!");
				}else if(list.get(i).getTenDichVu().equals("Tạm vắng")) {
					DichVu_TamVang k = controller.xemTamVang(list.get(i).getId());
					if(controller.xoaTamVang(k)) JOptionPane.showMessageDialog(this, "Xóa thành công!");
					else JOptionPane.showMessageDialog(this, "Xóa thất bại!");
				}else if(list.get(i).getTenDichVu().equals("Chuyển nhân khẩu")) {
					DichVu_ChuyenNhanKhau k = controller.xemChuyenKhau(list.get(i).getId());
					DangKy_ChuyenNhanKhau_ChiTiet d = new DangKy_ChuyenNhanKhau_ChiTiet(c,k);
					d.setVisible(true);
				}
			}
			update();
		}
		
	}
	
	public void chiTiet() {
		scrollPane.setViewportView(table);
		DefaultTableModel mta = (DefaultTableModel)table.getModel();
		int i = table.getSelectedRow();
		if(i>=0) {
			if(list.get(i).getTenDichVu().equals("Khai sinh")) {
				DichVu_KhaiSinh k = controller.xemKhaiSinh(list.get(i).getId());
				DangKy_KhaiSinh_ChiTiet d = new DangKy_KhaiSinh_ChiTiet(c,k);
				d.setVisible(true);
			}else if(list.get(i).getTenDichVu().equals("Khai tử")) {
				DichVu_KhaiTu k = controller.xemKhaiTu(list.get(i).getId());
				DangKy_KhaiTu_ChiTiet d = new DangKy_KhaiTu_ChiTiet(c,k);
				d.setVisible(true);
			}else if(list.get(i).getTenDichVu().equals("Tạm trú")) {
				DichVu_TamTru k = controller.xemTamTru(list.get(i).getId());
				DangKy_TamTru_ChiTiet d = new DangKy_TamTru_ChiTiet(c,k);
				d.setVisible(true);
			}else if(list.get(i).getTenDichVu().equals("Tạm vắng")) {
				DichVu_TamVang k = controller.xemTamVang(list.get(i).getId());
				DangKy_TamVang_ChiTiet d = new DangKy_TamVang_ChiTiet(c,k);
				d.setVisible(true);
			}else if(list.get(i).getTenDichVu().equals("Chuyển nhân khẩu")) {
				DichVu_ChuyenNhanKhau k = controller.xemChuyenKhau(list.get(i).getId());
				DangKy_ChuyenNhanKhau_ChiTiet d = new DangKy_ChuyenNhanKhau_ChiTiet(c,k);
				d.setVisible(true);
			}
		}
	}
	
	void hienThiTable(ArrayList<DichVu> l) {
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
						"ID", "Nhân khẩu","Ngày đăng kí","Dịch vụ"
				}
				));
		DefaultTableModel mta = (DefaultTableModel)table.getModel();
		
		for (int i = 0; i < l.size(); i++) {
			DichVu d = l.get(i);
			mta.addRow(new Object[] {
					d.getId(),d.getNhanKhau().getTen(),d.getDate(),d.getTenDichVu()
			});
		}
	}
}
