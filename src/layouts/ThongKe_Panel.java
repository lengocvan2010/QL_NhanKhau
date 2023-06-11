package layouts;

import javax.swing.JPanel;
import index.Label;
import qL_NhanKhau.ThongKe;
import sql.ConnectSQL;

import javax.swing.JSeparator;

import controller.NhanKhauController;
import index.InputField;
import javax.swing.JLabel;
import java.awt.Font;

public class ThongKe_Panel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	NhanKhauController nC;
	ThongKe tk;
	public ThongKe_Panel(ConnectSQL c) {
		setLayout(null);
		nC = new NhanKhauController(c);
		tk = new ThongKe();
		tk.setTong(nC.tongNK());
		tk.setNam(nC.tongNam());
		tk.setNu(nC.tongNu());
		tk.setKhac(nC.tongKhac());
		tk.setDuoild(nC.tongDuoiLd());
		tk.setTrongld(nC.tongLd());
		tk.setTrenld(nC.tongNghiHuu());
		tk.setThuongtru(nC.tongThuongTru());
		tk.setTamtru(nC.tongTamTru());
		tk.setTamvang(nC.tongTamVang());
		tk.setVogiacu(nC.tongVGC());
		
	/*
	 * Label
	 * */
		
		Label lblNewLabel = new Label("Thống kê");
		lblNewLabel.setBounds(233, 11, 76, 20);
		add(lblNewLabel);
		JSeparator separator = new JSeparator();
		separator.setBounds(163, 42, 238, 20);
		add(separator);
		
		JLabel lblNewLabel_2_1 = new JLabel("Độ tuổi");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(20, 168, 82, 27);
		add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Tình trạng cư trú");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1.setBounds(20, 264, 126, 27);
		add(lblNewLabel_2_1_1);
		
	/*
	 * Information
	 * */
		InputField txtTong = new InputField("Tổng số nhân khẩu");
		txtTong.setEditable(false);
		txtTong.setColumns(10);
		txtTong.setBounds(20, 99, 160, 47);
		txtTong.setText(""+tk.getTong());
		add(txtTong);
		
		InputField txtNam = new InputField("Nam");
		txtNam.setEditable(false);
		txtNam.setColumns(10);
		txtNam.setBounds(230, 99, 95, 47);
		txtNam.setText(""+tk.getNam());
		add(txtNam);
		
		InputField txtNu = new InputField("Nữ");
		txtNu.setEditable(false);
		txtNu.setColumns(10);
		txtNu.setBounds(335, 99, 95, 47);
		txtNu.setText(""+tk.getNu());
		add(txtNu);
		
		InputField txtKhac = new InputField("Khác");
		txtKhac.setEditable(false);
		txtKhac.setColumns(10);
		txtKhac.setBounds(441, 99, 95, 47);
		txtKhac.setText(""+tk.getKhac());
		add(txtKhac);	
		
		InputField txtDuoi = new InputField("Dưới tuổi lao động");
		txtDuoi.setEditable(false);
		txtDuoi.setColumns(10);
		txtDuoi.setBounds(20, 199, 160, 47);
		txtDuoi.setText(""+tk.getDuoild());
		add(txtDuoi);
		
		InputField txtDang = new InputField("Đang tuổi lao động");
		txtDang.setEditable(false);
		txtDang.setColumns(10);
		txtDang.setBounds(215, 199, 153, 47);
		txtDang.setText(""+tk.getTrongld());
		add(txtDang);
		
		InputField txtTren = new InputField("Nghỉ hưu");
		txtTren.setEditable(false);
		txtTren.setColumns(10);
		txtTren.setBounds(402, 199, 95, 47);
		txtTren.setText(""+tk.getTrenld());
		add(txtTren);
		
		InputField txtThuongTru = new InputField("Thường trú");
		txtThuongTru.setEditable(false);
		txtThuongTru.setColumns(10);
		txtThuongTru.setBounds(20, 295, 126, 47);
		txtThuongTru.setText(""+tk.getThuongtru());
		add(txtThuongTru);
		
		InputField txtTamTru = new InputField("Tạm trú");
		txtTamTru.setEditable(false);
		txtTamTru.setColumns(10);
		txtTamTru.setBounds(174, 295, 120, 47);
		txtTamTru.setText(""+tk.getTamtru());
		add(txtTamTru);
		
		InputField txtTamVang = new InputField("Tạm vắng");
		txtTamVang.setEditable(false);
		txtTamVang.setColumns(10);
		txtTamVang.setBounds(324, 295, 95, 47);
		txtTamVang.setText(""+tk.getTamvang());
		add(txtTamVang);
		
		InputField txtVoGiaCu = new InputField("Vô gia cư");
		txtVoGiaCu.setEditable(false);
		txtVoGiaCu.setColumns(10);
		txtVoGiaCu.setBounds(441, 295, 95, 47);
		txtVoGiaCu.setText(""+tk.getVogiacu());
		add(txtVoGiaCu);

	}
}
