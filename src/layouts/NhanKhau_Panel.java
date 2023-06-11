package layouts;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controller.NhanKhauController;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import index.Button;
import index.InputField;
import index.ScrollPane;
import index.Table;
import qL_NhanKhau.NhanKhau;
import sql.ConnectSQL;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class NhanKhau_Panel extends JPanel {

	ArrayList<NhanKhau> list;
	NhanKhauController controller;
	private static final long serialVersionUID = 1L;
	Table table;
	private int indexOfChucVu;
	ConnectSQL c;
	InputField txtTimKiem;
	/**
	 * Create the panel.
	 */
	public NhanKhau_Panel(int indexOfChucVu,ConnectSQL n) {
		c=n;
		controller = new NhanKhauController(c);
		list = controller.danhSachNhanKhau();
		this.indexOfChucVu = indexOfChucVu;
		setLayout(null);
		setBounds(100, 100, 800, 500);
		
	/*
	 * Label
	 * */
		JSeparator separator = new JSeparator();
		separator.setBounds(212, 45, 400, 10);
		add(separator);
		
		JLabel lblNewLabel = new JLabel("Quản lý nhân khẩu");
		lblNewLabel.setForeground(Color.magenta);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 10, 790, 35);
		add(lblNewLabel);
		
	/*
	 * Input
	 * */
		txtTimKiem = new InputField("Tìm kiếm");
		txtTimKiem.setFont(new Font("Tahoma", Font.BOLD, 10));
		txtTimKiem.setBounds(212, 66, 523, 45);
		add(txtTimKiem);
		
	/*
	 * TABLE
	 */
		table = new Table();
		
		ScrollPane scrollPane = new ScrollPane(table);
		scrollPane.setBounds(212, 136, 578, 353);
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
		btnUpdate.setBounds(10, 144, 192, 35);
		add(btnUpdate);
		
		Button btnThemNK = new Button("Thêm nhân khẩu");
		btnThemNK.setBounds(10, 190, 192, 35);
		add(btnThemNK);
		btnThemNK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themNhanKhau();
			}
		});
		
		Button btnChinhSua = new Button("Chỉnh sửa");
		btnChinhSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chinhSua();
			}
		});
		btnChinhSua.setBounds(10, 236, 192, 35);
		add(btnChinhSua);
		
		Button btnXoaNK = new Button("Xoá nhân khẩu");
		btnXoaNK.setBounds(10, 284, 192, 35);
		add(btnXoaNK);
		btnXoaNK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaNhanKhau();
			}
		});
		
		Button btnChiTiet = new Button("Thông tin chi tiết");
		btnChiTiet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chiTiet();
			}
		});
		btnChiTiet.setBounds(10, 329, 192, 35);
		add(btnChiTiet);
		
		JButton btnTimKiem = new JButton();
		btnTimKiem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				timKiemNhanKhau();
			}
		});
		btnTimKiem.setIcon(new ImageIcon("otherResource/Search32.png"));
		btnTimKiem.setBounds(752, 74, 38, 35);
		add(btnTimKiem);
		update();
	}
	
	/*
	 * Event
	 * */
	
	public void update() {
		list = controller.danhSachNhanKhau();
		hienThiThongTin(list);
	}
	
	public void themNhanKhau() {
		if(indexOfChucVu > 1) {
			JOptionPane.showMessageDialog(this, "Không đủ thẩm quyền!!");
		}
		else {
			NhanKhau_Them themNhanKhauDialog = new NhanKhau_Them(c);
			themNhanKhauDialog.setVisible(true);
		}
	}
	
	public void chinhSua() {
		if(indexOfChucVu > 1) {
			JOptionPane.showMessageDialog(this, "Không đủ thẩm quyền!!");
		}
		else {
			int i = table.getSelectedRow();
			if(i>=0) {
				DefaultTableModel mta = (DefaultTableModel) table.getModel();
				String id = (String)mta.getValueAt(i, 0);
				NhanKhau n = controller.timNhanKhauId(id);
				NhanKhau_ChinhSua nhanKhau_ChinhSua = new NhanKhau_ChinhSua(n,c);
				nhanKhau_ChinhSua.setVisible(true);
			}else JOptionPane.showMessageDialog(this, "Chọn 1 nhân khẩu!!!");
		}
	}
	
	public void xoaNhanKhau() {
		if(indexOfChucVu > 1) {
			JOptionPane.showMessageDialog(this, "Không đủ thẩm quyền!!");
		}
		else {
			int i = table.getSelectedRow();
			
			if(i>=0) {
				int input = JOptionPane.showConfirmDialog(table, "Bạn có chắc muốn xoá nhân khẩu??");
				if(input == 0) {
					DefaultTableModel mta = (DefaultTableModel) table.getModel();
					String id = (String)mta.getValueAt(i, 0);
					NhanKhau n = controller.timNhanKhauId(id);
					if(!n.getQuanHeChuHo().equals("Chủ hộ")) {
						controller.xoaNKHK(n);
						controller.xoaNhanKhau(n);
						JOptionPane.showMessageDialog(this, "Xoá thành công!!");
						update();
					}else JOptionPane.showMessageDialog(this, "Không thể xoá chủ hộ!!!");
					
				}
			}
			else {
				JOptionPane.showMessageDialog(table, "Chọn nhân khẩu muốn xoá!!");
			}
		}
	}
	
	public void chiTiet() {
		int i = table.getSelectedRow();
		if(i>=0) {
			DefaultTableModel mta = (DefaultTableModel) table.getModel();
			String id = (String)mta.getValueAt(i, 0);
			NhanKhau n = controller.timNhanKhauId(id);
			NhanKhau_ThongTin thongTin = new NhanKhau_ThongTin(n);
			thongTin.setVisible(true);
		}else JOptionPane.showMessageDialog(this, "Chọn nhân khẩu cần xem!!!");
	}
	
	void hienThiThongTin(ArrayList<NhanKhau> l) {
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
						"ID", "Họ tên", "CCCD/CMND","Số hộ" ,"Ghi chú"
				}
				));
		DefaultTableModel mta = (DefaultTableModel) table.getModel();
		for (int i = 0; i < l.size(); i++) {
			mta.addRow(new Object[] {
					l.get(i).getId(),l.get(i).getTen(),l.get(i).getCCCD(),l.get(i).getSoHK(),l.get(i).getGhiChu()
			});
		}
	}
	
	public void timKiemNhanKhau() {
		String str = txtTimKiem.getText().toLowerCase();
		if(str.isBlank()) {
			hienThiThongTin(list);
		}else {
			ArrayList<NhanKhau> l = controller.timKiem(str);
			hienThiThongTin(l);
		}
	}
}
