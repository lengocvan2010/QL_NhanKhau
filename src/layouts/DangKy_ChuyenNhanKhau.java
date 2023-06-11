package layouts;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import qL_NhanKhau.*;
import sql.ConnectSQL;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import index.ComboBox;

public class DangKy_ChuyenNhanKhau extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	InputField txtCCCD, txtSoHoKhau, txtNamDK, txtQuanHe;
	Table table;
	Table table1;
	ConnectSQL c;
	HoKhauController hC;
	HoKhau hL;
	NhanKhauController nC;
	NhanKhau nL;
	DichVuController dC;
	
	ComboBox<String> txtNgayDK, txtThangDK;
	/**
	 * Create the dialog.
	 */
	public DangKy_ChuyenNhanKhau(ConnectSQL cc) {
		setTitle("Tạm vắng");
		getContentPane().setLayout(null);
		setBounds(100, 100, 500, 650);
		setLocationRelativeTo(null);
		c = cc;
		nC = new NhanKhauController(c);
		hC = new HoKhauController(c);
		dC = new DichVuController(c);
		
		/*
		 * Labels
		 */
		
			Label lblThemHK = new Label("Tạm vắng");
			lblThemHK.setText("Chuyển nhân khẩu");
			lblThemHK.setIcon(new ImageIcon("otherResource/HoKhau16.png"));
			lblThemHK.setBounds(10, 10, 167, 19);
			getContentPane().add(lblThemHK);
			
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 35, 850, 2);
			getContentPane().add(separator);
			JSeparator separator_1 = new JSeparator();
			separator_1.setBounds(10, 534, 850, 2);
			getContentPane().add(separator_1);
			
			JLabel lblThngTinCh = new JLabel("CCCD người chuyển");
			lblThngTinCh.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblThngTinCh.setBounds(10, 40, 167, 25);
			getContentPane().add(lblThngTinCh);
			
			JSeparator separator_1_1 = new JSeparator();
			separator_1_1.setBounds(10, 193, 850, 2);
			getContentPane().add(separator_1_1);
			
		/*
		 * Text Field
		 * */
			txtCCCD = new InputField("CCCD/CMND");
			txtCCCD.setBounds(10, 63, 328, 51);
			getContentPane().add(txtCCCD);
			txtCCCD.setColumns(10);
			
			txtSoHoKhau = new InputField("Số hộ khẩu chuyển tới");
			txtSoHoKhau.setColumns(10);
			txtSoHoKhau.setBounds(10, 206, 333, 45);
			getContentPane().add(txtSoHoKhau);
			
			txtNamDK = new InputField("Năm");
			txtNamDK.setBounds(271, 478, 111, 45);
			getContentPane().add(txtNamDK);
			

			txtQuanHe = new InputField("Quan hệ chủ hộ mới");
			txtQuanHe.setColumns(10);
			txtQuanHe.setBounds(10, 421, 464, 45);
			getContentPane().add(txtQuanHe);
			
			txtNgayDK = new ComboBox<String>();
			txtNgayDK.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
			txtNgayDK.setSelectedIndex(-1);
			txtNgayDK.setMaximumRowCount(32);
			txtNgayDK.setLabelText("Ngày");
			txtNgayDK.setBounds(10, 478, 111, 45);
			getContentPane().add(txtNgayDK);
			
			txtThangDK = new ComboBox<String>();
			txtThangDK.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
			txtThangDK.setSelectedIndex(-1);
			txtThangDK.setMaximumRowCount(30);
			txtThangDK.setLabelText("Tháng");
			txtThangDK.setBounds(139, 478, 111, 45);
			getContentPane().add(txtThangDK);
			
		/*
		 * Table
		 * */
			table = new Table();
			Object[] columns =  {"CCCD", "Họ tên", "Số Hộ khẩu", "Ghi chú"};
			table.model.setColumnIdentifiers(columns);
				
			ScrollPane scrollPane = new ScrollPane(table);
			scrollPane.setBounds(10, 125, 464, 57);
			getContentPane().add(scrollPane);
			
			
			table1 = new Table();
			Object[] columns1 =  {"Số Hộ khẩu", "Chủ Hộ", "Địa chỉ"};
			table1.model.setColumnIdentifiers(columns1);
				
			ScrollPane scrollPane1 = new ScrollPane(table1);
			scrollPane1.setBounds(10, 262, 464, 153);
			getContentPane().add(scrollPane1);
			
		/*
		 ** Buttons
		 */
			Button btnXcNhn = new Button("Xác nhận");
			btnXcNhn.setBounds(31, 547, 118, 53);
			getContentPane().add(btnXcNhn);
			btnXcNhn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					xacNhanThem();
				}
			});
			
			Button btnReset = new Button("Reset");
			btnReset.setBounds(179, 547, 118, 53);
			getContentPane().add(btnReset);
			btnReset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					reset();
				}
			});
			
			Button btnThoat = new Button("Thoát");
			btnThoat.setBounds(332, 547, 118, 53);
			getContentPane().add(btnThoat);
			btnThoat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			
			Button btnXcNhn_1 = new Button("Xác nhận");
			btnXcNhn_1.setBounds(370, 78, 104, 29);
			getContentPane().add(btnXcNhn_1);
			btnXcNhn_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					xacNhanNhanKhau();
				}
			});
			
			Button btnXcNhn_1_1 = new Button("Xác nhận");
			btnXcNhn_1_1.setBounds(370, 219, 104, 29);
			getContentPane().add(btnXcNhn_1_1);
			btnXcNhn_1_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					xacNhanHoKhau();
				}
			});
	}
	
	/*
	 * Events
	 * */
	public void xacNhanThem() {
		nL = nC.timNhanKhauId(txtCCCD.getText());
		hL = hC.timHoKhau(txtSoHoKhau.getText());
		boolean check = false;
		if(nL.getId()==null) {
			JOptionPane.showMessageDialog(this, "Nhập nhân khẩu!");
		}else if(hL.getSoHoKhau()==null) {
			JOptionPane.showMessageDialog(this, "Nhập hộ khẩu!");
		}else if(txtNgayDK.getSelectedIndex()==-1||txtThangDK.getSelectedIndex()==-1||txtNamDK.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "Nhập ngày, tháng, năm!");
		}else if(txtQuanHe.getText().isBlank()){
			JOptionPane.showMessageDialog(this, "Nhập quan hệ với chủ hộ mới!");
		}else check = true;
		int ngay = txtNgayDK.getSelectedIndex()+1;
		int thang = txtThangDK.getSelectedIndex();
		int nam = -1;
		try {
			nam = Integer.parseInt(txtNamDK.getText())-1900;
		} catch (Exception e) {
			check = false;
			JOptionPane.showMessageDialog(this, "Năm phải là số!");
		}
		
		int a = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn?");
		if(a==0) {
			String quanHeChuHoMoi = txtQuanHe.getText();
			if(quanHeChuHoMoi.equals("Chủ hộ")) {
				JOptionPane.showMessageDialog(this, "Không thể là chủ hộ!");
				check=false;
			}
			if(check) {
				if(!nL.getGhiChu().equals("Đã qua đời")) {
					if(!nL.getQuanHeChuHo().equals("Chủ hộ")) {
						String soHKcu = nL.getSoHK();
						HoKhau cu = new HoKhau();
						cu.setSoHoKhau(soHKcu);
						String quanhecu = nL.getQuanHeChuHo();
						Date date = new Date(nam,thang,ngay);
						nL.setQuanHeChuHo(quanHeChuHoMoi);
						nC.xoaNKHK(nL);
						nL.setSoHK(hL.getSoHoKhau());
						hC.themThanhVien(hL, nL);
						DichVu_ChuyenNhanKhau d = new DichVu_ChuyenNhanKhau(nL, null, date, cu, hL);
						if(dC.themChuyenNhanKhau(d)) {
							JOptionPane.showMessageDialog(this, "Thêm thành công!");
							dispose();
						}else {
							nL.setQuanHeChuHo(quanhecu);
							nC.xoaNKHK(nL);
							nL.setSoHK(cu.getSoHoKhau());
							hC.themThanhVien(cu, nL);
							JOptionPane.showMessageDialog(this, "Thêm thất bại!");
						}
					}else JOptionPane.showMessageDialog(this, "Hãy đổi chủ hộ cũ trước!");
				}else JOptionPane.showMessageDialog(this, "Nhân khẩu này đã qua đời!");
			}
		}
	}
	
	public void reset() {
		txtCCCD.setText("");
		if(table.getRowCount() > 0) {
			table.model.removeRow(0);
		}
	}
	
	public void xacNhanNhanKhau() {
		nL = nC.timNhanKhauId(txtCCCD.getText());
		
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
						"CCCD","Họ tên", "Số Hộ khẩu", "Ghi chú"
				}
				));
		DefaultTableModel mta = (DefaultTableModel) table.getModel();
		if(nL.getCCCD()!=null) {
			mta.addRow(new Object[] {
					nL.getCCCD(),nL.getTen(),nL.getSoHK(),nL.getGhiChu()
			});
		}
	}
	
	public void xacNhanHoKhau() {
		hL = hC.timHoKhau(txtSoHoKhau.getText());
		table1.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
						"Số Hộ khẩu", "Chủ Hộ", "Địa chỉ"
				}
				));
		DefaultTableModel mta = (DefaultTableModel) table1.getModel();
		if(hL.getSoHoKhau()!=null) {
			mta.addRow(new Object[] {
					hL.getSoHoKhau(),hL.getChuHo().getTen(),hL.getDiaChi()
			});
		}
	}
}
