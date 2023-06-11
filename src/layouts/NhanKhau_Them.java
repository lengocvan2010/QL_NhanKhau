package layouts;


import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JSeparator;

import index.InputField;
import index.Label;
import index.Button;
import index.ScrollPane;
import index.Table;
import qL_NhanKhau.HoKhau;
import qL_NhanKhau.NhanKhau;
import sql.ConnectSQL;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import controller.HoKhauController;
import controller.NhanKhauController;

public class NhanKhau_Them extends JDialog {
	
	NhanKhauController nController;
	HoKhauController hController;
	ConnectSQL c;
	HoKhau hL;
	private static final long serialVersionUID = 1L;
	NhanKhau_Them_ThongTin panel;
	private Table table;
	JScrollPane scrollPane_1;
	InputField txtSoHoKhau;
	InputField txtQuanHe;

	/**
	 * Create the dialog.
	 */
	public NhanKhau_Them(ConnectSQL c) {
		this.c=c;
		setTitle("Thêm nhân khẩu");
		getContentPane().setLayout(null);
		setBounds(100, 100, 700, 700);
		setLocationRelativeTo(null);
		nController = new NhanKhauController(c);
		hController = new HoKhauController(c);
		panel = new NhanKhau_Them_ThongTin();
		
	/*
	 * Label
	 * */
		Label lblNewLabel = new Label("Thêm nhân khẩu");
		lblNewLabel.setIcon(new ImageIcon("otherResource/NhanKhau16.png"));
		lblNewLabel.setBounds(10, 10, 167, 19);
		getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 40, 664, 7);
		getContentPane().add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Thông tin chung");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 169, 140, 25);
		getContentPane().add(lblNewLabel_1);
		
		
	/*
	 * Table
	 * */
		table = new Table();
		Object[] columns =  {"Số hộ khẩu", "Chủ hộ", "Địa chỉ"};
		table.model.setColumnIdentifiers(columns);
		
		ScrollPane scrollPane = new ScrollPane(table);
		scrollPane.setBounds(10, 107, 664, 51);
		getContentPane().add(scrollPane);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(10, 205, 664, 284);
		getContentPane().add(scrollPane_1);
		scrollPane_1.setViewportView(panel);
		
	/*
	 * Field Text
	 * */
		txtSoHoKhau = new InputField("Số hộ khẩu sáp nhập");
		txtSoHoKhau.setBounds(10, 51, 537, 45);
		getContentPane().add(txtSoHoKhau);
		
		txtQuanHe = new InputField("Quan hệ với chủ hộ");
		txtQuanHe.setBounds(10, 508, 470, 45);
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
		btnXcNhnThm.setBounds(65, 570, 136, 68);
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
		btnReset.setBounds(281, 570, 136, 68);
		getContentPane().add(btnReset);
		
		Button btnThot = new Button("Thoát");
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThot.setBounds(486, 570, 136, 68);
		getContentPane().add(btnThot);
		
		
	}

	public void xacNhan() {
		hL = hController.timHoKhau(txtSoHoKhau.getText());
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			}, 
			new String[] {
				"Số hộ khẩu", "Chủ hộ", "Địa chỉ"
			}));
		DefaultTableModel mta =(DefaultTableModel) table.getModel();
		
		if(hL.getSoHoKhau()!=null) {
			
			mta.addRow(new Object[] {
					hL.getSoHoKhau(),hL.getChuHo().getTen(),hL.getDiaChi()
			});
		}
	}
	
	public void xacNhanThem() {
		NhanKhau n = panel.getNhanKhau();
		if(n!=null) {
			if(hL.getSoHoKhau()==null) {
				n.setQuanHeChuHo("Vô gia cư");
				n.setSoHK("Vô gia cư");
			}else {
				n.setSoHK(hL.getSoHoKhau());
				n.setQuanHeChuHo(txtQuanHe.getText());
			}
			if(nController.themNhanKhau(n)) {
				JOptionPane.showMessageDialog(this, "Thêm thành công !!!");
				if(hL!=null) nController.themThanhVien(hL, n);
				dispose();
			}else JOptionPane.showMessageDialog(this, "Lỗi!!! Thêm thất bại!!!");
		}
	}
	
	
	public void reset() {
		txtQuanHe.setText("");
		txtSoHoKhau.setText("");

		table.model.removeRow(0);
	}
	
	
	
}
