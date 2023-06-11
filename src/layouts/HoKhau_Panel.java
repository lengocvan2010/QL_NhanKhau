package layouts;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import index.Button;
import index.InputField;
import index.Label;
import index.ScrollPane;
import index.Table;
import qL_NhanKhau.HoKhau;
import sql.ConnectSQL;

import javax.swing.JSeparator;
import javax.swing.table.DefaultTableModel;

import controller.HoKhauController;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.event.ActionEvent;

public class HoKhau_Panel extends JPanel {
	private int indexOfChucVu;
	Table table;
	Button btnUpdate;
	Button btnThemHK;
	Button btnChinhSua;
	Button btnXemThanhVien;
	ArrayList<HoKhau> list;
	HoKhauController hC;
	ConnectSQL c;
	InputField txtTimKiem;
	private static final long serialVersionUID = 2645128917383602723L;

	/**
	 * Create the panel.
	 */
	public HoKhau_Panel(int indexOfChucVu,ConnectSQL cc) {
		c=cc;
		this.hC= new HoKhauController(c);
		setLayout(null);
		setBounds(100, 100, 800, 500);
		this.indexOfChucVu = indexOfChucVu;
	/*
	 * TABLE
	 * */
		table = new Table();
		
		ScrollPane scrollPane = new ScrollPane(table);
		scrollPane.setBounds(212, 149, 578, 340);
		add(scrollPane);
		
		/*
		 * Label
		 * */
			Label lblNewLabel = new Label("Quản lý hộ khẩu");
			lblNewLabel.setBounds(0, 10, 790, 35);
			add(lblNewLabel);
			
			JSeparator separator = new JSeparator();
			separator.setBounds(212, 45, 400, 10);
			add(separator);
			
			JButton btnUpdate_1 = new JButton();
			btnUpdate_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					timKiemHoKhau();
				}
			});
			btnUpdate_1.setIcon(new ImageIcon("otherResource/Search32.png"));
			btnUpdate_1.setBounds(752, 74, 38, 35);
			add(btnUpdate_1);
			
			txtTimKiem = new InputField("Tìm kiếm");
			txtTimKiem.setFont(new Font("Tahoma", Font.BOLD, 10));
			txtTimKiem.setBounds(212, 66, 523, 45);
			add(txtTimKiem);
			
		/*
		 * BUTTON
		 * */
			btnUpdate = new Button("Làm mới");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					update();
				}
			});
			btnUpdate.setBounds(10, 157, 192, 35);
			add(btnUpdate);
			
			btnThemHK = new Button("Thêm hộ khẩu");
			btnThemHK.setBounds(10, 203, 192, 35);
			add(btnThemHK);
			btnThemHK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					themHoKhau();
				}
			});
			
			btnChinhSua = new Button("Chỉnh sửa");
			btnChinhSua.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					chinhSua();
				}
			});
			btnChinhSua.setBounds(10, 249, 192, 35);
			add(btnChinhSua);
			
			Button btnXoaHK = new Button("Xoá hộ khẩu");
			btnXoaHK.setBounds(10, 297, 192, 35);
			add(btnXoaHK);
			btnXoaHK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					XoaHK();
				}
			});
			
			btnXemThanhVien = new Button("Xem thành viên");
			btnXemThanhVien.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					xemThanhVien();
				}
			});
			btnXemThanhVien.setBounds(10, 342, 192, 35);
			add(btnXemThanhVien);
			
			update();
	}
	
	/*
	 * Events
	 * */
	public void update() {
		list = hC.xemTT();
		hienThiThongTin(list);
	}
	public void themHoKhau() {
		if(indexOfChucVu > 1) {
			JOptionPane.showMessageDialog(this, "Không đủ thẩm quyền!");
		}
		else {
			HoKhau_Them themHoKhauDialog = new HoKhau_Them(c);
			themHoKhauDialog.setVisible(true);
		}
	}
	public void chinhSua() {
		if(indexOfChucVu > 1) {
			JOptionPane.showMessageDialog(this, "Không đủ thẩm quyền!");
		}
		else {
			int i = table.getSelectedRow();
			if(i>=0) {
				DefaultTableModel mta = (DefaultTableModel)table.getModel();
				String str = (String)mta.getValueAt(i, 0);
				HoKhau hT = hC.timHoKhau(str);
				HoKhau_ChinhSua chinhSuaHoKhauDialog = new HoKhau_ChinhSua(hT,c);
				chinhSuaHoKhauDialog.setVisible(true);
			}else JOptionPane.showMessageDialog(this,"Hãy chọn hộ cần chỉnh sửa!");
		}
	}
	public void XoaHK() {
		if(indexOfChucVu > 1) {
			JOptionPane.showMessageDialog(this, "Không đủ thẩm quyền!");
		}
		else {
			int i = table.getSelectedRow();
			if(i>=0) {
				int input = JOptionPane.showConfirmDialog(table, "Bạn có chắc muốn xoá hộ khẩu?");
				if(input == 0) {
					DefaultTableModel mta = (DefaultTableModel) table.getModel();
					String str = (String) mta.getValueAt(i,0);
					HoKhau hT = hC.timHoKhau(str);
					if(hC.xoaNK_HK(hT)) {
						hC.xoaHK(hT);
						JOptionPane.showMessageDialog(this, "Xóa thành công!");
						update();
					}else JOptionPane.showMessageDialog(this, "Xóa thất bại!");
				}
			}
			else {
				JOptionPane.showMessageDialog(table, "Chọn hộ khẩu muốn xoá!");
			}
		}
	}
	public void xemThanhVien() {
		int i = table.getSelectedRow();
		if(i>=0) {
			DefaultTableModel mta = (DefaultTableModel)table.getModel();
			String str = (String)mta.getValueAt(i, 0);
			HoKhau hT = hC.timHoKhau(str);
			HoKhau_ThongTin thongTinHoKhau = new HoKhau_ThongTin(hT, hC);
			thongTinHoKhau.setVisible(true);
		}else JOptionPane.showMessageDialog(this, "Chọn 1 hộ khẩu!!!");
	}
	
	void hienThiThongTin(ArrayList<HoKhau> l) {
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
						"Số hộ khẩu","Chủ hộ","Địa chỉ"
				}
				));
		DefaultTableModel mta = (DefaultTableModel) table.getModel();
		for (int i = 0; i < l.size(); i++) {
			mta.addRow(new Object[] {
					l.get(i).getSoHoKhau(),l.get(i).getChuHo().getTen(),l.get(i).getDiaChi()
			}); 
		}
	}
	
	public void timKiemHoKhau() {
			String str = txtTimKiem.getText().toLowerCase();
			if(str.isBlank()) {
				hienThiThongTin(list);
			}else {
				ArrayList<HoKhau> l = hC.timKiem(str);
				hienThiThongTin(l);	
		}
	}
}
