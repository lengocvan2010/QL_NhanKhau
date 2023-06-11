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
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import controller.HoKhauController;
import controller.NhanKhauController;
import index.Button;
import index.InputField;
import index.Label;
import index.ScrollPane;
import index.Table;
import qL_NhanKhau.HoKhau;
import qL_NhanKhau.NhanKhau;
import sql.ConnectSQL;

public class NhanKhau_ChinhSua extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	NhanKhau_ChinhSua_Panel panel;
	private Table table;
	JScrollPane scrollPane_1;
	InputField txtID;
	InputField txtQuanHe;
	InputField txtGhiChu;
	NhanKhauController nC;
	HoKhauController hC;
	NhanKhau nL;
	ConnectSQL c;
	HoKhau hL;
	/**
	 * Create the dialog.
	 */
	public NhanKhau_ChinhSua(NhanKhau n,ConnectSQL cc) {
		setTitle("Chỉnh sửa nhân khẩu");
		getContentPane().setLayout(null);
		setBounds(100, 100, 700, 725);
		setLocationRelativeTo(null);
		this.c=cc;
		nL=n;
		nC= new NhanKhauController(c);
		hC = new HoKhauController(c);
		panel = new NhanKhau_ChinhSua_Panel(n);
		hL = hC.timHoKhau(n.getSoHK());
	/*
	 * Label
	 * */
		Label lblNewLabel = new Label("Chỉnh sửa nhân khẩu");
		lblNewLabel.setIcon(new ImageIcon("otherResource/Edit16.png"));
		lblNewLabel.setBounds(10, 10, 206, 19);
		getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 40, 664, 7);
		getContentPane().add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Thông tin chung");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 163, 140, 25);
		getContentPane().add(lblNewLabel_1);
		
		
	/*
	 * Table
	 * */
		table = new Table();
		Object[] columns =  {"Số hộ khẩu", "Chủ hộ", "Địa chỉ"};
		table.model.setColumnIdentifiers(columns);
		if(hL.getSoHoKhau()!=null) {
			table.model.addRow(new Object[] {
				hL.getSoHoKhau(),hL.getChuHo().getTen(),hL.getDiaChi()
			});
		}
		ScrollPane scrollPane = new ScrollPane(table);
		scrollPane.setBounds(10, 107, 664, 45);
		getContentPane().add(scrollPane);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(10, 199, 664, 290);
		getContentPane().add(scrollPane_1);
		scrollPane_1.setViewportView(panel);
		
		
	/*
	 * Field Text
	 * */
		txtID = new InputField("Số Hộ");
		txtID.setText(""+hL.getSoHoKhau());
		txtID.setBounds(10, 51, 537, 45);
		getContentPane().add(txtID);
		
		txtQuanHe = new InputField("Quan hệ với chủ hộ");
		txtQuanHe.setText(n.getQuanHeChuHo());
		txtQuanHe.setBounds(10, 508, 664, 45);
		getContentPane().add(txtQuanHe);
		
		txtGhiChu = new InputField("Ghi chú");
		txtGhiChu.setText(n.getGhiChu());
		txtGhiChu.setBounds(10, 565, 664, 45);
		getContentPane().add(txtGhiChu);
		
	/*
	 * Button
	 * */	
		Button btnXcNhn = new Button("Nhập");
		btnXcNhn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xacNhan();
			}
		});
		btnXcNhn.setBounds(570, 58, 104, 29);
		getContentPane().add(btnXcNhn);

		Button btnXcNhnChinhSua = new Button("Xác nhận");
		btnXcNhnChinhSua.setBounds(64, 631, 136, 45);
		getContentPane().add(btnXcNhnChinhSua);
		btnXcNhnChinhSua.addActionListener(new ActionListener() {
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
		btnReset.setBounds(280, 631, 136, 45);
		getContentPane().add(btnReset);
		
		Button btnThot = new Button("Thoát");
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThot.setBounds(485, 631, 136, 45);
		getContentPane().add(btnThot);
		
	}
	
	public void xacNhanThem() {
		NhanKhau n = panel.getNhanKhau();
		n.setId(nL.getId());
		if(hL.getSoHoKhau()==null) {
			n.setQuanHeChuHo("Vô gia cư");
			n.setSoHK("Vô gia cư");
		}else {
			n.setSoHK(hL.getSoHoKhau());
			n.setQuanHeChuHo(txtQuanHe.getText());
		}
		if(nC.updateNhanKhau(n)) {
			if(hL.getSoHoKhau()!=null&&nL.getQuanHeChuHo().equals("Vô gia cư")) hC.themThanhVien(hL, n);
			else if(hL.getSoHoKhau()!=null&&!nL.getQuanHeChuHo().equals(n.getQuanHeChuHo())) hC.suaQuanHe(hL, n);
			JOptionPane.showMessageDialog(this, "Sửa thành công !!!");
			dispose();
		}else JOptionPane.showMessageDialog(this, "Lỗi!!! Sửa thất bại!!!");
		
	}
	
	public void xacNhan() {
		hL = hC.timHoKhau(txtID.getText());
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
						"Số hộ khẩu","Chủ hộ","Địa chỉ"
				}
				));
		DefaultTableModel mta = (DefaultTableModel) table.getModel();
		if(hL.getSoHoKhau()!=null) {
		mta.addRow(new Object[] {
				hL.getSoHoKhau(),hL.getChuHo().getTen(),hL.getDiaChi()
		});}
	}
	
	public void reset() {
		txtQuanHe.setText("");
		txtID.setText("");
		scrollPane_1.setViewportView(null);
		table.model.removeRow(0);
	}
}
