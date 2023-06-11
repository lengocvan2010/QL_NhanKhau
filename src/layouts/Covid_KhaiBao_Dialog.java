package layouts;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.table.DefaultTableModel;

import controller.CovidController;
import controller.NhanKhauController;
import index.Button;
import index.InputField;
import index.Label;
import index.ScrollPane;
import index.Table;
import qL_NhanKhau.Covid_KhaiBao;
import qL_NhanKhau.NhanKhau;
import sql.ConnectSQL;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import index.ComboBox;

public class Covid_KhaiBao_Dialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	InputField txtCCCD;
	InputField txtTinhTrang;
	InputField txtNamKhaiBao;
	
	Table table;
	
	ComboBox<String> txtNgayKhaiBao;
	ComboBox<String> txtThangKhaiBao;
	ComboBox<String> txtTrieuChung;
	
	ConnectSQL c;
	CovidController controller;
	NhanKhauController nC;
	NhanKhau nL;
	/**
	 * Create the dialog.
	 */
	public Covid_KhaiBao_Dialog(ConnectSQL cc) {
		setTitle("Khai báo");
		getContentPane().setLayout(null);
		setBounds(100, 100, 500, 500);
		setLocationRelativeTo(null);
		c= cc;
		controller= new CovidController(c);
		nC = new NhanKhauController(c);
		
		/*
		 * Labels
		 */
		
			Label lblThemHK = new Label("Khai báo y tế");
			lblThemHK.setBounds(10, 10, 167, 19);
			getContentPane().add(lblThemHK);
			
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 35, 850, 2);
			getContentPane().add(separator);
			JSeparator separator_1 = new JSeparator();
			separator_1.setBounds(10, 355, 850, 2);
			getContentPane().add(separator_1);
			
			JLabel lblThngTinCh = new JLabel("Thông tin người khai");
			lblThngTinCh.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblThngTinCh.setBounds(10, 40, 167, 25);
			getContentPane().add(lblThngTinCh);
			
			JSeparator separator_1_1 = new JSeparator();
			separator_1_1.setBounds(10, 193, 850, 2);
			getContentPane().add(separator_1_1);
			
			JLabel lblThngTinCh_1 = new JLabel("Thông tin khai báo");
			lblThngTinCh_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblThngTinCh_1.setBounds(10, 206, 140, 25);
			getContentPane().add(lblThngTinCh_1);
			
		/*
		 * Text Field
		 * */
			txtCCCD = new InputField("ID người khai(*)");
			txtCCCD.setBounds(10, 63, 328, 51);
			getContentPane().add(txtCCCD);
			txtCCCD.setColumns(10);
			
			txtTinhTrang = new InputField("Tình trạng(*)");
			txtTinhTrang.setBounds(149, 293, 328, 54);
			getContentPane().add(txtTinhTrang);
			txtTinhTrang.setColumns(10);
			
			txtNamKhaiBao = new InputField("Năm khai báo (*)");
			txtNamKhaiBao.setBounds(271, 237, 128, 45);
			getContentPane().add(txtNamKhaiBao);
			
			txtNgayKhaiBao = new ComboBox<String>();
			txtNgayKhaiBao.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
			txtNgayKhaiBao.setSelectedIndex(-1);
			txtNgayKhaiBao.setMaximumRowCount(32);
			txtNgayKhaiBao.setLabelText("Ngày khai báo (*)");
			txtNgayKhaiBao.setBounds(10, 237, 111, 45);
			getContentPane().add(txtNgayKhaiBao);
			
			txtThangKhaiBao = new ComboBox<String>();
			txtThangKhaiBao.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
			txtThangKhaiBao.setSelectedIndex(-1);
			txtThangKhaiBao.setMaximumRowCount(30);
			txtThangKhaiBao.setLabelText("Tháng khai báo (*)");
			txtThangKhaiBao.setBounds(139, 237, 111, 45);
			getContentPane().add(txtThangKhaiBao);
			
			txtTrieuChung = new ComboBox<String>();
			txtTrieuChung.setModel(new DefaultComboBoxModel<String>(new String[] {"Không có triệu chứng", "Ho", "Sốt", "Mất vị giác", "Khác"}));
			txtTrieuChung.setSelectedIndex(-1);
			txtTrieuChung.setMaximumRowCount(30);
			txtTrieuChung.setLabelText("Triệu chứng");
			txtTrieuChung.setBounds(10, 293, 118, 51);
			getContentPane().add(txtTrieuChung);
			
		/*
		 * Table
		 * */
			table = new Table();
			Object[] columns =  {"ID", "Họ tên", "CCCD", "Ghi chú"};
			table.model.setColumnIdentifiers(columns);
				
			ScrollPane scrollPane = new ScrollPane(table);
			scrollPane.setBounds(10, 125, 464, 57);
			getContentPane().add(scrollPane);
			
		/*
		 ** Buttons
		 */
			Button btnXcNhn = new Button("Xác nhận");
			btnXcNhn.setBounds(31, 368, 118, 68);
			getContentPane().add(btnXcNhn);
			btnXcNhn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					xacNhanThem();
				}
			});
			
			Button btnReset = new Button("Reset");
			btnReset.setBounds(179, 368, 118, 68);
			getContentPane().add(btnReset);
			btnReset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					reset();
				}
			});
			
			Button btnThoat = new Button("Thoát");
			btnThoat.setBounds(332, 368, 118, 68);
			getContentPane().add(btnThoat);
			btnThoat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			
			Button btnXcNhn_NguoiKhai = new Button("Xác nhận");
			btnXcNhn_NguoiKhai.setBounds(370, 78, 104, 29);
			getContentPane().add(btnXcNhn_NguoiKhai);
			btnXcNhn_NguoiKhai.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					xacNhan_NguoiKhai();
				}
			});
			
	}
	
	/*
	 * Events
	 * */
	@SuppressWarnings("deprecation")
	public void xacNhanThem() {
		nL = nC.timNhanKhauId(txtCCCD.getText());
		boolean check = false;
		if(nL.getCCCD()==null) {
			JOptionPane.showMessageDialog(this, "Nhập nhân khẩu khai báo!");
		}else if(txtTinhTrang.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "Nhập tình trạng!");
		}else if(txtTrieuChung.getSelectedItem().toString().isBlank()) {
			JOptionPane.showMessageDialog(this, "Nhập triệu chứng!");
		}else if(txtNgayKhaiBao.getSelectedIndex()==-1) {
			JOptionPane.showMessageDialog(this, "Chọn ngày khai báo!");
		}else if(txtThangKhaiBao.getSelectedIndex()==-1) {
			JOptionPane.showMessageDialog(this, "Chọn tháng khai báo!");
		}else if(txtNamKhaiBao.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "Nhập năm khai báo!");
		}else if(nL.getGhiChu().equals("Đã qua đời")) {
			JOptionPane.showMessageDialog(this, "Nhân khẩu đã qua đời!");
		}else check = true;
		int nam = -1;
		try {
			nam = Integer.parseInt(txtNamKhaiBao.getText())-1900;
		} catch (Exception e) {
			check = false;
			JOptionPane.showMessageDialog(this, "Năm phải là số!");
		}
		
		if(check) {
			String trieuChung = txtTrieuChung.getSelectedItem().toString();
			String tinhTrang = txtTinhTrang.getText();
			int ngay = txtNgayKhaiBao.getSelectedIndex()+1;
			int thang = txtThangKhaiBao.getSelectedIndex();
			Date ngaykb = new Date(nam, thang, ngay);
			Covid_KhaiBao khaiBao = new Covid_KhaiBao(nL, ngaykb, trieuChung, tinhTrang);
			if(controller.themKhaiBao(khaiBao)) {
				JOptionPane.showMessageDialog(this, "Thêm thành công!");
				dispose();
			}else JOptionPane.showMessageDialog(this, "Thêm thất bại!");
		}
	}
	
	public void reset() {
		txtCCCD.setText("");
		txtTrieuChung.setSelectedIndex(-1);
		txtTinhTrang.setText("");
		if(table.getRowCount() > 0) {
			table.model.removeRow(0);
		}
	}
	
	public void xacNhan_NguoiKhai() {
		nL = nC.timNhanKhauId(txtCCCD.getText());
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"ID", "Họ tên", "CCCD", "Ghi chu"
				}
				));
		DefaultTableModel mta = (DefaultTableModel) table.getModel();
		if(nL.getId()!=null) {
			mta.addRow(new Object[] {
					nL.getId(),nL.getTen(),nL.getCCCD(),nL.getGhiChu()
			});
		}
	}
}
