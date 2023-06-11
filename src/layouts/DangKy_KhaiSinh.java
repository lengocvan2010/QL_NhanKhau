package layouts;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.table.DefaultTableModel;

import controller.DichVuController;
import controller.HoKhauController;
import controller.NhanKhauController;
import index.Button;
import index.InputField;
import index.Label;
import index.ScrollPane;
import index.Table;
import qL_NhanKhau.DichVu_KhaiSinh;
import qL_NhanKhau.HoKhau;
import qL_NhanKhau.NhanKhau;
import sql.ConnectSQL;

public class DangKy_KhaiSinh extends JDialog {

	private static final long serialVersionUID = 1L;
	DangKy_KhaiSinh_ThongTin panel = new DangKy_KhaiSinh_ThongTin();
	private Table table_HoKhau, table_NguoiKhai;
	JScrollPane scrollPane_HoKhau;
	JScrollPane scrollPane_NguoiKhai;
	JScrollPane scrollPane_ThongTinChung;
	InputField txtSoHoKhau;
	InputField txtQuanHe;
	InputField txtNguoiKhai;
	
	NhanKhauController nC;
	HoKhauController hC;
	DichVuController dC;
	
	ConnectSQL c;
	HoKhau hL;
	NhanKhau nL;
	/**
	 * Create the dialog.
	 */
	public DangKy_KhaiSinh(ConnectSQL cc) {
		c=cc;
		nC = new NhanKhauController(c);
		hC = new HoKhauController(c);
		dC = new DichVuController(c);
		
		setTitle("Khai sinh");
		getContentPane().setLayout(null);
		setBounds(100, 100, 700, 700);
		setLocationRelativeTo(null);
	
	/*
	 * Label
	 * */
		
		
		Label lblNewLabel = new Label("Khai sinh");
		lblNewLabel.setIcon(new ImageIcon("otherResource/NhanKhau16.png"));
		lblNewLabel.setBounds(10, 10, 167, 19);
		getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 40, 664, 7);
		getContentPane().add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Thông tin chung");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 236, 140, 25);
		getContentPane().add(lblNewLabel_1);
		
		
	/*
	 * Table
	 * */
		table_HoKhau = new Table();
		Object[] columns_HoKhau =  {"Số hộ khẩu", "Chủ hộ", "Địa chỉ"};
		table_HoKhau.model.setColumnIdentifiers(columns_HoKhau);
		
		scrollPane_HoKhau = new JScrollPane(table_HoKhau);
		scrollPane_HoKhau.setBounds(10, 107, 664, 51);
		getContentPane().add(scrollPane_HoKhau);
		scrollPane_HoKhau.setColumnHeaderView(panel);
		
		table_NguoiKhai = new Table();
		Object[] columns_NguoiKhai =  {"ID", "Họ tên", "CCCD", "Ghi chu"};
		table_NguoiKhai.model.setColumnIdentifiers(columns_NguoiKhai);
		
		scrollPane_NguoiKhai = new ScrollPane(table_NguoiKhai);
		scrollPane_NguoiKhai.setBounds(10, 174, 664, 51);
		getContentPane().add(scrollPane_NguoiKhai);
		
	/*
	 * Field Text
	 * */
		txtSoHoKhau = new InputField("Số hộ khẩu sáp nhập(*)");
		txtSoHoKhau.setBounds(10, 51, 224, 45);
		getContentPane().add(txtSoHoKhau);
		
		txtQuanHe = new InputField("Quan hệ với chủ hộ(*)");
		txtQuanHe.setBounds(10, 567, 470, 45);
		getContentPane().add(txtQuanHe);
		
	/*
	 * Button
	 * */	
		Button btnXcNhn = new Button("Xác nhận");
		btnXcNhn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xacNhan();
			}
		});
		btnXcNhn.setBounds(570, 58, 104, 29);
		getContentPane().add(btnXcNhn);

		Button btnXcNhnThm = new Button("Xác nhận thêm");
		btnXcNhnThm.setText("Xác nhận");
		btnXcNhnThm.setBounds(64, 623, 136, 27);
		getContentPane().add(btnXcNhnThm);
		btnXcNhnThm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xacNhanThem();
			}
		});
		
		Button btnReset = new Button("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		btnReset.setBounds(280, 623, 136, 27);
		getContentPane().add(btnReset);
		
		Button btnThot = new Button("Thoát");
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThot.setBounds(485, 623, 136, 27);
		getContentPane().add(btnThot);
		
		txtNguoiKhai = new InputField("CCCD Nguoi khai(*)");
		txtNguoiKhai.setBounds(244, 51, 315, 45);
		getContentPane().add(txtNguoiKhai);
		
		scrollPane_ThongTinChung = new JScrollPane(panel);
		scrollPane_ThongTinChung.setBounds(10, 272, 664, 284);
		getContentPane().add(scrollPane_ThongTinChung);
		
	}
	
	public void xacNhan() {
		hL = hC.timHoKhau(txtSoHoKhau.getText());
		table_HoKhau.setModel(new DefaultTableModel(
			new Object[][] {
				
			}, 
			new String[] {
				"Số hộ khẩu", "Chủ hộ", "Địa chỉ"
			}));
		DefaultTableModel mta_HoKhau =(DefaultTableModel) table_HoKhau.getModel();
		if(hL.getSoHoKhau()!=null) {
			
			mta_HoKhau.addRow(new Object[] {
					hL.getSoHoKhau(),hL.getChuHo().getTen(),hL.getDiaChi()
			});
		}
		
		nL  =  nC.timNhanKhauCCCD(txtNguoiKhai.getText());
		table_NguoiKhai.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"ID", "Họ tên", "CCCD", "Ghi chu"
				}
				));
		DefaultTableModel mta_NguoiKhai = (DefaultTableModel) table_NguoiKhai.getModel();
		if(nL.getCCCD()!=null) {
			mta_NguoiKhai.addRow(new Object[] {
					nL.getId(),nL.getTen(),nL.getCCCD(),nL.getGhiChu()
			});
		}
		
	}
	
	public void xacNhanThem() {
		nL = nC.timNhanKhauId(txtNguoiKhai.getText());
		hL = hC.timHoKhau(txtSoHoKhau.getText());
		
		NhanKhau n = panel.getNhanKhau();
		if(n!=null) {
			boolean check = false;
		
			if(hL.getSoHoKhau()==null) {
				JOptionPane.showMessageDialog(this, "Nhập hộ khẩu sát nhập!");
			}else if(nL.getCCCD()==null) {
				JOptionPane.showMessageDialog(this, "Nhập người khai!");
			}else check = true;
			if(check) {
				if(!nL.getGhiChu().equals("Đã qua đời")) {
					n.setSoHK(hL.getSoHoKhau());
					n.setQuanHeChuHo(txtQuanHe.getText());
			
					if(nC.themNhanKhau(n)) {
						JOptionPane.showMessageDialog(this, "Thêm thành công !!!");
						DichVu_KhaiSinh k = new DichVu_KhaiSinh(n, null, null, nL);
						dC.themKhaiSinh(k);
				
						nC.themThanhVien(hL, n);
						dispose();
					}else JOptionPane.showMessageDialog(this, "Lỗi!!! Thêm thất bại!!!");
				}else JOptionPane.showMessageDialog(this, "Nhân khẩu người khai đã qua đời!");
			}else JOptionPane.showMessageDialog(this, "Nhập sai thông tin!");
		}
	}
	public void reset() {
		txtQuanHe.setText("");
		txtSoHoKhau.setText("");

		table_HoKhau.model.removeRow(0);
	}
}
