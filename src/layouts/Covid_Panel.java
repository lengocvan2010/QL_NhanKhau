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
import qL_NhanKhau.Covid_CachLy;
import qL_NhanKhau.Covid_KhaiBao;
import qL_NhanKhau.Covid_TestCovid;
import qL_NhanKhau.HoKhau;
import sql.ConnectSQL;

import javax.swing.JSeparator;
import javax.swing.table.DefaultTableModel;

import controller.CovidController;
import controller.HoKhauController;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.event.ActionEvent;

public class Covid_Panel extends JPanel {
	private int indexOfNghiepVu; // 0-Khai bao, 1-Test, 2-Cách ly
	private int indexOfChucVu;
	Table table_KhaiBao, table_Test, table_CachLy;
	ScrollPane scrollPane;
	Button btnKhaiBao, btnTest, btnCachLy;
	Button btnThem, btnXoa;
	CovidController controller;
	ConnectSQL c;
	InputField txtTimKiem;
	ArrayList<Covid_KhaiBao> khaiBaoL;
	ArrayList<Covid_TestCovid> testL;
	ArrayList<Covid_CachLy> cachLyL;
	
	
	
	private static final long serialVersionUID = 2645128917383602723L;

	/**
	 * Create the panel.
	 */
	public Covid_Panel(int indexOfChucVu,ConnectSQL cc) {
		c=cc;
		controller= new CovidController(c);
		khaiBaoL = controller.xem_khaibao();
		testL = controller.xem_test();
		cachLyL = controller.xem_cachly();
		
		setLayout(null);
		setBounds(100, 100, 800, 500);
		this.indexOfChucVu = indexOfChucVu;
		
		
	/*
	 * TABLE
	 * */
		table_KhaiBao = new Table();
		Object[] columns_NguoiKhai =  {"Mã khai báo","ID Nhân khẩu", "Họ và tên", "Ngày khai báo", "Triệu chứng", "Tình trạng"};
		table_KhaiBao.model.setColumnIdentifiers(columns_NguoiKhai);
		
		table_Test = new Table();
		Object[] columns_Test =  {"Mã test","ID Nhân khẩu", "Họ và tên", "Ngày test", "Kết quả"};
		table_Test.model.setColumnIdentifiers(columns_Test);
		
		table_CachLy = new Table();
		Object[] columns_CachLy =  {"Mã cách ly","ID Nhân khẩu", "Họ và tên", "Ngày bắt đầu", "Số ngày", "Loại cách ly", "Nơi cách ly"};
		table_CachLy.model.setColumnIdentifiers(columns_CachLy);
		
		scrollPane = new ScrollPane((Table) null);
		scrollPane.setBounds(212, 149, 578, 340);
		add(scrollPane);
		
		/*
		 * Label
		 * */
			Label lblNewLabel = new Label("Quản lý Covid-19");
			lblNewLabel.setBounds(0, 10, 790, 35);
			add(lblNewLabel);
			
			JSeparator separator = new JSeparator();
			separator.setBounds(212, 45, 400, 10);
			add(separator);
			
		/*
		 * Input
		 * */
			txtTimKiem = new InputField("Tìm kiếm");
			txtTimKiem.setFont(new Font("Tahoma", Font.BOLD, 10));
			txtTimKiem.setBounds(212, 66, 523, 45);
			add(txtTimKiem);
			
		/*
		 * Button
		 * */
			JButton btnTimKiem = new JButton();
			btnTimKiem.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					timKiem();
				}
			});
			btnTimKiem.setIcon(new ImageIcon("otherResource/Search32.png"));
			btnTimKiem.setBounds(752, 74, 38, 35);
			add(btnTimKiem);
			
			btnKhaiBao = new Button("Khai báo");
			btnKhaiBao.setBounds(10, 157, 192, 35);
			add(btnKhaiBao);
			btnKhaiBao.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					khaiBaoL = controller.xem_khaibao();
					hienThiKhaiBao(khaiBaoL);
				}
			});
			
			btnTest = new Button("Test Covid");
			btnTest.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					testL = controller.xem_test();
					hienThiTest(testL);
				}
			});
			btnTest.setBounds(10, 203, 192, 35);
			add(btnTest);
			
			btnCachLy = new Button("Cách ly");
			btnCachLy.setBounds(10, 251, 192, 35);
			add(btnCachLy);
			btnCachLy.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cachLyL=controller.xem_cachly();
					hienThiCachLy(cachLyL);
				}
			});
			
			btnThem = new Button("Thêm nghiệp vụ");
			btnThem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					them();
				}
			});
			btnThem.setBounds(10, 296, 192, 35);
			add(btnThem);
			
			btnXoa = new Button("Xoá nghiệp vụ");
			btnXoa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					xoa();
				}
			});
			btnXoa.setBounds(10, 342, 192, 35);
			add(btnXoa);
			
	}
	
	/*
	 * Events
	 * */
	public void hienThiKhaiBao(ArrayList<Covid_KhaiBao> l) {
		this.indexOfNghiepVu = 0;
		table_KhaiBao.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"Mã khai báo","ID Nhân khẩu", "Họ và tên", "Ngày khai báo", "Triệu chứng", "Tình trạng"
				}
				));
		DefaultTableModel mta = (DefaultTableModel) table_KhaiBao.getModel();
		for (int i = 0; i < l.size(); i++) {
			Covid_KhaiBao k = l.get(i);
			mta.addRow(new Object[] {
					k.getIdKhaiBao(),k.getNhanKhau().getId(),k.getNhanKhau().getTen(),k.getNgayKhaiBao(),k.getTrieuChung(),k.getTinhTrang()
			});
		}
		scrollPane.setViewportView(table_KhaiBao);
	}
	public void hienThiTest(ArrayList<Covid_TestCovid> l) {
		this.indexOfNghiepVu = 1;
		table_Test.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
						"Mã test","ID Nhân khẩu", "Họ và tên", "Ngày test", "Kết quả"
				}
				));
		DefaultTableModel mta = (DefaultTableModel) table_Test.getModel();
		for (int i = 0; i < l.size(); i++) {
			Covid_TestCovid k = l.get(i);
			mta.addRow(new Object[] {
					k.getIdTest(),k.getNhanKhau().getId(),k.getNhanKhau().getTen(),k.getNgayTest(),k.getKetQua()
			});
		}
		scrollPane.setViewportView(table_Test);
	}
	public void hienThiCachLy(ArrayList<Covid_CachLy> l) {
		this.indexOfNghiepVu = 2;
		table_CachLy.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
						"Mã cách ly","ID Nhân khẩu", "Họ và tên", "Ngày bắt đầu", "Số ngày","Loại cách ly","Nơi cách ly"
				}
				));
		DefaultTableModel mta = (DefaultTableModel) table_CachLy.getModel();
		for (int i = 0; i < l.size(); i++) {
			Covid_CachLy k = l.get(i);
			mta.addRow(new Object[] {
					k.getIdMaCachLy(),k.getNhanKhau().getId(),k.getNhanKhau().getTen(),k.getNgayBatDau(),k.getSoNgay(),k.getLoaiCachLy(),k.getNoiCachLy()
			});
		}
		scrollPane.setViewportView(table_CachLy);
	}
	public void them() {
		if(indexOfNghiepVu == 0) {
			Covid_KhaiBao_Dialog khaiBao = new Covid_KhaiBao_Dialog(c);
			khaiBao.setVisible(true);
		}
		else if(indexOfNghiepVu == 1) {
			Covid_Test_Dialog test = new Covid_Test_Dialog(c);
			test.setVisible(true);
		}
		else if(indexOfNghiepVu == 2) {
			Covid_CachLy_Dialog cachLy = new Covid_CachLy_Dialog(c);
			cachLy.setVisible(true);
		}
	}
	public void xoa() {
		DefaultTableModel mta = null;
		String a = "";
		int i=-1;
		int ma;
		
		if(indexOfNghiepVu == 0) {
			a = "KhaiBao";
			mta = (DefaultTableModel)table_KhaiBao.getModel();
			i = table_KhaiBao.getSelectedRow();
		}
		else if(indexOfNghiepVu == 1) {
			a = "TestCovid";
			mta = (DefaultTableModel)table_Test.getModel();
			i = table_Test.getSelectedRow();
		}
		else if(indexOfNghiepVu == 2){
			a = "CachLy";
			mta = (DefaultTableModel)table_CachLy.getModel();
			i = table_CachLy.getSelectedRow();
		}
		if(i>=0&&!a.isBlank()&&mta!=null) {
			int x = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xóa?");
			if(x==0) {
				ma = (int)mta.getValueAt(i, 0);
				if(controller.xoa(a, ma)) {
					JOptionPane.showMessageDialog(this, "Xóa thành công!");
					mta.removeRow(i);
				}else JOptionPane.showMessageDialog(this, "Xóa thất bại!");
			}
		}else JOptionPane.showMessageDialog(this, "Chọn thông tin cần xóa!");
	}
	public void timKiem() {
		String str = txtTimKiem.getText().toLowerCase();
		if(indexOfNghiepVu == 0) {
			if(str.isBlank()) hienThiKhaiBao(khaiBaoL);
			else{
				ArrayList<Covid_KhaiBao> l = new ArrayList<>();
				l = controller.timkiemKhaiBao(str);
				hienThiKhaiBao(l);
			}
		}
		else if(indexOfNghiepVu == 2) {
			if(str.isBlank()) hienThiCachLy(cachLyL);
			else{
				ArrayList<Covid_CachLy> l = new ArrayList<>();
				l = controller.timkiemCachLy(str);
				hienThiCachLy(l);
			}
		}
		else if(indexOfNghiepVu == 1) {
			if(str.isBlank()) hienThiTest(testL);
			else{
				ArrayList<Covid_TestCovid> l = new ArrayList<>();
				l = controller.timkiemTest(str);
				hienThiTest(l);
			}
		}
	}
}
