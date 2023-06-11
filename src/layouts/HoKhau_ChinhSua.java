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

public class HoKhau_ChinhSua extends JDialog {
	Table table;
	InputField txtDiaChi;
	InputField txtSoHoKhau;
	HoKhau hL;
	NhanKhau chuHoMoi;
	ConnectSQL c;
	HoKhauController hC;
	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public HoKhau_ChinhSua(HoKhau ho, ConnectSQL cc) {
		c = cc;
		hC = new HoKhauController(c);
		this.hL=ho;
		hL.setNkL(hC.dsThanhVien(hL));
		setIconImage(Toolkit.getDefaultToolkit().getImage("otherResource/HoKhau16.png"));
		setTitle("Thông tin hộ khẩu");
		getContentPane().setLayout(null);
		setBounds(100, 100, 600, 700);
		setLocationRelativeTo(null);
		
		/*
		 * Table
		 * */
			table = new Table();
			table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			Object[] columns =  {"ID", "Họ và tên", "Ngày sinh", "Giới tính", "CCCD/CMND", "Quan hệ chủ hộ"};
			table.model.setColumnIdentifiers(columns);
			
			ScrollPane scrollPane = new ScrollPane(table);
			scrollPane.setBounds(10, 234, 564, 371);
			getContentPane().add(scrollPane);
			
		
	/*
	 * Label
	 * */
		Label lblThemHK = new Label("Chỉnh sửa hộ khẩu");
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
		txtDiaChi.setText("");
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(10, 131, 564, 57);
		getContentPane().add(txtDiaChi);
		
		txtSoHoKhau = new InputField("Số hộ khẩu");
		txtSoHoKhau.setText("");
		txtSoHoKhau.setColumns(10);
		txtSoHoKhau.setBounds(10, 69, 564, 51);
		getContentPane().add(txtSoHoKhau);
		txtDiaChi.setText(hL.getDiaChi());
		txtSoHoKhau.setText(hL.getSoHoKhau());
		
	/*
	 * Button
	 * */

		Button btnNewButton = new Button("Close");
		btnNewButton.setBounds(234, 616, 89, 23);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		Button btnTachHK = new Button("Tách hộ khẩu");
		btnTachHK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tachHoKhau();
			}
		});
		btnTachHK.setBounds(379, 616, 133, 23);
		getContentPane().add(btnTachHK);
		
		Button btnXoaThanhVien_1 = new Button("Đổi chủ hộ");
		btnXoaThanhVien_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doiChuHo(hL.getNkL());
			}
		});
		btnXoaThanhVien_1.setBounds(53, 616, 133, 23);
		getContentPane().add(btnXoaThanhVien_1);
		
		hienThiDanhSachThanhVien(hL.getNkL());
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
	
	public void doiChuHo(ArrayList<NhanKhau> l) {
		HoKhau_ChinhSua_DoiChuHo doiChuHo = new HoKhau_ChinhSua_DoiChuHo(hL, c);
		doiChuHo.setVisible(true);
		dispose();
	} 
	
	public void tachHoKhau() {
		int arr[] = table.getSelectedRows();
		HoKhau hkm = new HoKhau();
		ArrayList<NhanKhau> nkL = new ArrayList<>();
		boolean check  = true;
		for (int i = 0; i < arr.length; i++) {
			nkL.add(hL.getNkL().get(arr[i]));
			if(hL.getNkL().get(arr[i]).getQuanHeChuHo().equals("Chủ hộ")) {
				JOptionPane.showMessageDialog(this, "Không được tách chủ hộ!");
				check = false;
			}
		}
		if(check) {
			hkm.setNkL(nkL);
			HoKhau_ChinhSua_TachHoKhau doiChuHo = new HoKhau_ChinhSua_TachHoKhau(hkm, c);
			doiChuHo.setVisible(true);
		}
		dispose();
	}
	
}
