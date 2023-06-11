package layouts;

import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.table.DefaultTableModel;

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

public class DangKy_KhaiTu extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	NhanKhau nguoiKhai;
	NhanKhau nguoiMat;
	NhanKhauController nC;
	DichVuController dC;
	ConnectSQL c;
	InputField txtCCCD_NguoiKhai;
	InputField txtCCCD_NguoiMat;
	Table table_NguoiKhai, table_NguoiMat;
	ScrollPane scrollPane_NguoiKhai;
	ScrollPane scrollPane_NguoiMat;
	
	
	
	/**
	 * Create the dialog.
	 */
	public DangKy_KhaiTu(ConnectSQL cc) {
		this.c = cc;
		nC = new NhanKhauController(c);
		dC = new DichVuController(c);
		setTitle("Khai tử");
		getContentPane().setLayout(null);
		setBounds(100, 100, 500, 500);
		setLocationRelativeTo(null);
	
		/*
		 * Labels
		 */
		
			Label lblThemHK = new Label("Khai tử");
			lblThemHK.setBounds(10, 10, 167, 19);
			getContentPane().add(lblThemHK);
			
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 35, 850, 2);
			getContentPane().add(separator);
			JSeparator separator_1 = new JSeparator();
			separator_1.setBounds(10, 356, 850, 2);
			getContentPane().add(separator_1);
			
			JLabel lblThngTinCh = new JLabel("CCCD người khai");
			lblThngTinCh.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblThngTinCh.setBounds(10, 40, 140, 25);
			getContentPane().add(lblThngTinCh);
			
			JSeparator separator_1_1 = new JSeparator();
			separator_1_1.setBounds(10, 193, 850, 2);
			getContentPane().add(separator_1_1);
			
			JLabel lblThngTinCh_1 = new JLabel("CCCD người đã mất");
			lblThngTinCh_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblThngTinCh_1.setBounds(10, 206, 140, 25);
			getContentPane().add(lblThngTinCh_1);
			
		/*
		 * Text Field
		 * */
			txtCCCD_NguoiKhai = new InputField("CCCD/CMND(*)");
			txtCCCD_NguoiKhai.setBounds(10, 63, 328, 51);
			getContentPane().add(txtCCCD_NguoiKhai);
			txtCCCD_NguoiKhai.setColumns(10);
			
			txtCCCD_NguoiMat = new InputField("CCCD/CMND(*)");
			txtCCCD_NguoiMat.setColumns(10);
			txtCCCD_NguoiMat.setBounds(10, 232, 328, 51);
			getContentPane().add(txtCCCD_NguoiMat);
			
		/*
		 * Table
		 * */
			table_NguoiKhai = new Table();
			Object[] columns_NguoiKhai =  {"ID", "Họ tên", "CCCD", "Ghi chu"};
			table_NguoiKhai.model.setColumnIdentifiers(columns_NguoiKhai);
			
			scrollPane_NguoiKhai = new ScrollPane(table_NguoiKhai);
			scrollPane_NguoiKhai.setBounds(10, 125, 464, 57);
			getContentPane().add(scrollPane_NguoiKhai);
			
			table_NguoiMat = new Table();
			Object[] columns_NguoiMat =  {"ID", "Họ tên", "CCCD", "Ghi chu"};
			table_NguoiMat.model.setColumnIdentifiers(columns_NguoiMat);
			
			scrollPane_NguoiMat = new ScrollPane(table_NguoiMat);
			scrollPane_NguoiMat.setBounds(10, 288, 464, 57);
			getContentPane().add(scrollPane_NguoiMat);
			
		/*
		 ** Buttons
		 */
			Button btnXcNhn = new Button("Xác nhận");
			btnXcNhn.setBounds(31, 369, 118, 68);
			getContentPane().add(btnXcNhn);
			btnXcNhn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					xacNhan();
				}
			});
			
			Button btnReset = new Button("Reset");
			btnReset.setBounds(179, 369, 118, 68);
			getContentPane().add(btnReset);
			btnReset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					reset();
				}
			});
			
			Button btnThoat = new Button("Thoát");
			btnThoat.setBounds(332, 369, 118, 68);
			getContentPane().add(btnThoat);
			btnThoat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			
			Button btnXacNhan_NguoiKhai = new Button("Xác nhận");
			btnXacNhan_NguoiKhai.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					xacNhan_NguoiKhai();
				}
			});
			btnXacNhan_NguoiKhai.setBounds(370, 78, 104, 29);
			getContentPane().add(btnXacNhan_NguoiKhai);
			
			Button btnXacNhan_NguoiMat= new Button("Xác nhận");
			btnXacNhan_NguoiMat.setBounds(370, 247, 104, 29);
			getContentPane().add(btnXacNhan_NguoiMat);
			btnXacNhan_NguoiMat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					xacNhan_NguoiMat();
				}
			});
	}
	
	/*
	 * Events
	 * */
	public void xacNhan() {
		nguoiKhai = nC.timNhanKhauId(txtCCCD_NguoiKhai.getText());
		nguoiMat = nC.timNhanKhauId(txtCCCD_NguoiMat.getText());
		boolean check = false;
		
		if(nguoiKhai.getCCCD()==null) {
			JOptionPane.showMessageDialog(this, "Nhập người khai!");
		}else if(nguoiMat.getCCCD()==null) {
			JOptionPane.showMessageDialog(this, "Nhập người mất!");
		}else if(nguoiKhai.getGhiChu().equals("Đã qua đời")) {
			JOptionPane.showMessageDialog(this, "Người khai đã qua đời!");
		}else check=true;
		
		if(check) {
			int a = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn?");
			if(a==0) {
				if(!nguoiMat.getQuanHeChuHo().equals("Chủ hộ")) {
					nC.xoaNKHK(nguoiMat);
					nguoiMat.setGhiChu("Đã qua đời");
					nC.updateNhanKhau(nguoiMat);
					DichVu_KhaiTu k = new DichVu_KhaiTu(nguoiMat, null, null, nguoiKhai);
					dC.themKhaiTu(k);
					JOptionPane.showMessageDialog(this, "Thêm thành công!");
					dispose();
				}else JOptionPane.showMessageDialog(this, "Bạn phải đổi chủ hộ trước!");
			}
		}
		
	}
	
	public void reset() {
		txtCCCD_NguoiKhai.setText("");
		txtCCCD_NguoiMat.setText("");
		if(table_NguoiKhai.getRowCount() > 0) {
			table_NguoiKhai.model.removeRow(0);
		}
		if(table_NguoiMat.getRowCount() > 0) {
			table_NguoiMat.model.removeRow(0);
		}
	}
	
	public void xacNhan_NguoiKhai() {
		nguoiKhai  =  nC.timNhanKhauId(txtCCCD_NguoiKhai.getText());
		table_NguoiKhai.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"ID", "Họ tên", "CCCD", "Ghi chú"
				}
				));
		DefaultTableModel mta_NguoiKhai = (DefaultTableModel) table_NguoiKhai.getModel();
		if(nguoiKhai.getCCCD()!=null) {
			mta_NguoiKhai.addRow(new Object[] {
					nguoiKhai.getId(),nguoiKhai.getTen(),nguoiKhai.getCCCD(),nguoiKhai.getGhiChu()
			});
		}
	}
	
	public void xacNhan_NguoiMat() {
		nguoiMat  =  nC.timNhanKhauId(txtCCCD_NguoiMat.getText());
		table_NguoiMat.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"ID", "Họ tên", "CCCD", "Ghi chu"
				}
				));
		DefaultTableModel mta_NguoiMat = (DefaultTableModel) table_NguoiMat.getModel();
		if(nguoiMat.getCCCD()!=null) {
			mta_NguoiMat.addRow(new Object[] {
					nguoiMat.getId(),nguoiMat.getTen(),nguoiMat.getCCCD(),nguoiMat.getGhiChu()
			});
		}
	}
}
