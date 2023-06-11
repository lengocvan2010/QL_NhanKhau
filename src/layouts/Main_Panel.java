package layouts;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import sql.ConnectSQL;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Main_Panel extends JFrame {

	private int indexOfChucVu;
	Login_Panel login;
	private NhanKhau_Panel tabHienThiNhanKhau;
	private HoKhau_Panel tabHienThiHoKhau;
	private DichVu_Panel tabDichVu;
	private Covid_Panel tabCovid;
	private ThongKe_Panel thongKe;
	JTabbedPane tab;
	ConnectSQL connectSQL;
	
	private static final long serialVersionUID = 2730626704474033277L;
	JTabbedPane menu;

	/**
	 * Create the frame.
	 */
	public Main_Panel(Login_Panel login, int indexOfChucVu) {
		this.indexOfChucVu = indexOfChucVu;
		this.login = login;
		connectSQL = new ConnectSQL();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		getContentPane().setLayout(null);
		setTitle("Quản lý nhân khẩu");
		setIconImage(Toolkit.getDefaultToolkit().getImage("otherResource/icon.png"));
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 900, 32);
		getContentPane().add(menuBar);
		
		tab = new JTabbedPane(JTabbedPane.TOP);
		tab.setBounds(10, 116, 870, 530);
		getContentPane().add(tab);
		
	/* 
	 * SYSTEM Management
	 */
		JMenu HeThong = new JMenu("Hệ thống");
		HeThong.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuBar.add(HeThong);
		
		JMenuItem DangXuat = new JMenuItem("Đăng xuất");
		DangXuat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		DangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.setVisible(true);
				dispose();
			}
		});
		DangXuat.setIcon(new ImageIcon("otherResource/LogOut16.png"));
		HeThong.add(DangXuat);
		
		JSeparator separator = new JSeparator();
		HeThong.add(separator);
		
		JMenuItem Thoat = new JMenuItem("Thoát");
		Thoat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Thoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		HeThong.add(Thoat);
		Thoat.setIcon(new ImageIcon("otherResource/Thoat16.png"));
		
	/*
	 * MANAGEMENT
	 */
		JMenu QuanLy = new JMenu("Quản lý");
		QuanLy.setFont(new Font("Tahoma", Font.PLAIN, 12));
		menuBar.add(QuanLy);
		
		JMenuItem QuanLyNhanKhau = new JMenuItem("Quản lý nhân khẩu");
		QuanLyNhanKhau.setFont(new Font("Tahoma", Font.PLAIN, 12));
		QuanLy.add(QuanLyNhanKhau);
		QuanLyNhanKhau.setIcon(new ImageIcon("otherResource/NhanKhau16.png"));
	// Event NhanKhau
		QuanLyNhanKhau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTabHienThiNhanKhau();
			}
		});
		
		JSeparator separator_1 = new JSeparator();
		QuanLy.add(separator_1);
		
		JMenuItem QuanLyHoKhau = new JMenuItem("Quản lý hộ khẩu");
		QuanLyHoKhau.setFont(new Font("Tahoma", Font.PLAIN, 12));
		QuanLy.add(QuanLyHoKhau);
		QuanLyHoKhau.setIcon(new ImageIcon("otherResource/HoKhau16.png"));
		
	/*
	 * SUPPORT
	 */
		
		JMenu mnDchV = new JMenu("Dịch Vụ");
		mnDchV.setFont(new Font("Tahoma", Font.PLAIN, 12));
		menuBar.add(mnDchV);
		
		JMenuItem mntmKhaiSinh = new JMenuItem("Khai Sinh");
		mntmKhaiSinh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mntmKhaiSinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addKhaiSinhDialog();
			}
		});
		mnDchV.add(mntmKhaiSinh);
		
		JSeparator separator_1_1 = new JSeparator();
		mnDchV.add(separator_1_1);
		
		JMenuItem mntmKhaiT = new JMenuItem("Khai tử");
		mntmKhaiT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addKhaiTuDialog();
			}
		});
		mntmKhaiT.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mnDchV.add(mntmKhaiT);
		
		JSeparator separator_3 = new JSeparator();
		mnDchV.add(separator_3);
		
		JMenuItem mntmTm = new JMenuItem("Tạm trú");
		mntmTm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTamTruDialog();
			}
		});
		mntmTm.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		mnDchV.add(mntmTm);
		
		JSeparator separator_4 = new JSeparator();
		mnDchV.add(separator_4);
		
		JMenuItem menuTamVang = new JMenuItem("Tạm vắng");
		menuTamVang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTamVangDialog();
			}
		});
		menuTamVang.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mnDchV.add(menuTamVang);
		
		JSeparator separator_4_1 = new JSeparator();
		mnDchV.add(separator_4_1);
		
		JMenuItem mntmKhaiT_1_1_1 = new JMenuItem("Tách Hộ khẩu");
		mntmKhaiT_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTachHoKhauDialog();
			}
		});
		mntmKhaiT_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mnDchV.add(mntmKhaiT_1_1_1);
		
		JSeparator separator_5 = new JSeparator();
		mnDchV.add(separator_5);
		
		JMenuItem mntmKhaiT_1_1 = new JMenuItem("Chuyển nhân khẩu");
		mntmKhaiT_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addChuyenNhanKhau();
			}
		});
		mntmKhaiT_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mnDchV.add(mntmKhaiT_1_1);
		JMenu TroGiup = new JMenu("Trợ giúp");
		TroGiup.setFont(new Font("Tahoma", Font.PLAIN, 12));
		menuBar.add(TroGiup);
		
		JMenuItem NoiDung = new JMenuItem("Thống kê");
		NoiDung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTabThongKe();
			}
		});
		NoiDung.setFont(new Font("Tahoma", Font.PLAIN, 12));
		TroGiup.add(NoiDung);
		NoiDung.setIcon(new ImageIcon("otherResource/NoiDung16.png"));
		
		JSeparator separator_2 = new JSeparator();
		TroGiup.add(separator_2);
		
		JMenuItem GioiThieu = new JMenuItem("Hướng dẫn");
		GioiThieu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		TroGiup.add(GioiThieu);
		GioiThieu.setIcon(new ImageIcon("otherResource/GioiThieu16.png"));
		
	/*
	 * Tool Bar
	 */
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 32, 890, 77);
		getContentPane().add(toolBar);
		
		JButton dangXuatButton = new JButton("Đăng xuất");
		dangXuatButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.setVisible(true);
				dispose();
			}
		});
		dangXuatButton.setIcon(new ImageIcon("otherResource/LogOut48.png"));
		toolBar.add(dangXuatButton);
		
		JButton quanLyHoKhauButton = new JButton("QL Hộ khẩu");
		quanLyHoKhauButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTabHienThiHoKhau();
			}
		});
		quanLyHoKhauButton.setIcon(new ImageIcon("otherResource/HoKhau48.png"));
		toolBar.add(quanLyHoKhauButton);
		
		JButton quanLyNhanKhauButton = new JButton("QL Nhân khẩu");
		quanLyNhanKhauButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTabHienThiNhanKhau();
			}
		});
		quanLyNhanKhauButton.setIcon(new ImageIcon("otherResource/NhanKhau48.png"));
		toolBar.add(quanLyNhanKhauButton);
		
		JButton btnNewButton = new JButton("Dịch vụ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTabDichVu();
			}
		});
		btnNewButton.setIcon(new ImageIcon("otherResource/Service48.png"));
		toolBar.add(btnNewButton);
		
		JButton covidButton = new JButton("Covid-19");
		covidButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTabCovid();
			}
		});
		covidButton.setIcon(new ImageIcon("otherResource/covid48.png"));
		toolBar.add(covidButton);
		
		JButton thongKeButton = new JButton("Thống kê");
		thongKeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTabThongKe();
			}
		});
		thongKeButton.setIcon(new ImageIcon("otherResource/ThongKe48.png"));
		toolBar.add(thongKeButton);
		
		JButton thoatButton = new JButton("Thoát");
		thoatButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		thoatButton.setIcon(new ImageIcon("otherResource/Thoat48.png"));
		toolBar.add(thoatButton);
		
		JMenuItem menuItem = new JMenuItem("New menu item");
		menuItem.setBounds(0, 43, 137, 26);
		getContentPane().add(menuItem);
	
	}
	
	/*
	 * Event
	 */
	
		public void addTabHienThiNhanKhau() {
			if(tabHienThiNhanKhau == null) {
				tabHienThiNhanKhau = new NhanKhau_Panel(indexOfChucVu,connectSQL);
				tab.addTab("Quản lý nhân khẩu", new ImageIcon(), tabHienThiNhanKhau, "Quản lý nhân khẩu");
			}
			tab.setSelectedComponent(tabHienThiNhanKhau);
		}
		
		
		public void addTabHienThiHoKhau() {
			if(tabHienThiHoKhau == null) {
				tabHienThiHoKhau = new HoKhau_Panel(indexOfChucVu, connectSQL);
				tab.addTab("Quản lý hộ khẩu", new ImageIcon(), tabHienThiHoKhau, "Quản lý hộ khẩu");
			}
			tab.setSelectedComponent(tabHienThiHoKhau);
		}
		
		public void addTabDichVu() {
			if(tabDichVu == null) {
				tabDichVu = new DichVu_Panel(connectSQL);
				tab.addTab("Dịch Vụ", new ImageIcon(), tabDichVu, "Dịch Vụ");
			}
			tab.setSelectedComponent(tabDichVu);
		}
		
		public void addTabCovid() {
			if(tabCovid == null) {
				tabCovid = new Covid_Panel(indexOfChucVu, connectSQL);
				tab.addTab("Covid-19", new ImageIcon(), tabCovid, "Covid-19");
			}
			tab.setSelectedComponent(tabCovid);
		}
		
		public void addTabThongKe() {
			if(thongKe == null) {
				thongKe = new ThongKe_Panel(connectSQL);
				tab.addTab("Thống kê", new ImageIcon(), thongKe, "Thống kê");
			}
			else {
				tab.remove(thongKe);
				thongKe = new ThongKe_Panel(connectSQL);
				tab.addTab("Thống kê", new ImageIcon(), thongKe, "Thống kê");
			}
			
		}
	/*
	 * Service dialogs
	 * */
		public void addKhaiSinhDialog() {
			if(indexOfChucVu > 2) {
				JOptionPane.showMessageDialog(this, "Không đủ thẩm quyền!");
			}
			else {
				DangKy_KhaiSinh khaiSinh = new DangKy_KhaiSinh(connectSQL);
				khaiSinh.setVisible(true);
			}
		}
		public void addKhaiTuDialog() {
			if(indexOfChucVu > 2) {
				JOptionPane.showMessageDialog(this, "Không đủ thẩm quyền!");
			}
			else {
				DangKy_KhaiTu khaiTu = new DangKy_KhaiTu(connectSQL);
				khaiTu.setVisible(true);
			}
		}
		public void addTamTruDialog() {
			if(indexOfChucVu > 2) {
				JOptionPane.showMessageDialog(this, "Không đủ thẩm quyền!");
			}
			else {
				DangKy_TamTru tamTru = new DangKy_TamTru(connectSQL);
				tamTru.setVisible(true);
			}
		}
		public void addTamVangDialog() {
			if(indexOfChucVu > 2) {
				JOptionPane.showMessageDialog(this, "Không đủ thẩm quyền!");
			}
			else {
				DangKy_TamVang tamVang = new DangKy_TamVang(connectSQL);
				tamVang.setVisible(true);
			}
		}
		public void addChuyenNhanKhau() {
			if(indexOfChucVu > 2) {
				JOptionPane.showMessageDialog(this, "Không đủ thẩm quyền!");
			}
			else {
				DangKy_ChuyenNhanKhau chuyenNhanKhau = new DangKy_ChuyenNhanKhau(connectSQL);
				chuyenNhanKhau.setVisible(true);
			}
		}
		public void addTachHoKhauDialog() {
			if(indexOfChucVu > 2) {
				JOptionPane.showMessageDialog(this, "Không đủ thẩm quyền!");
			}
			else {
				
			}
		}
}
