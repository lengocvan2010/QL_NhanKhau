package qL_NhanKhau;

import java.sql.Date;

public class DichVu_TamTru extends DichVu{
	private String diaChiThuongTru;
	private String diaChiTamTru;
	
	public DichVu_TamTru() {
		super();
		this.setTenDichVu("Tam tru");
	}
	public DichVu_TamTru(NhanKhau nhanKhau, String tenDichVu, Date date,String diaChiThuongTru, String diaChiTamTru) {
		super(nhanKhau,tenDichVu,date);
		this.diaChiTamTru = diaChiTamTru;
		this.diaChiThuongTru = diaChiThuongTru;
		this.setTenDichVu("Tam tru");
	}
	public String getDiaChiThuongTru() {
		return diaChiThuongTru;
	}
	public void setDiaChiThuongTru(String diaChiThuongTru) {
		this.diaChiThuongTru = diaChiThuongTru;
	}
	public String getDiaChiTamTru() {
		return diaChiTamTru;
	}
	public void setDiaChiTamTru(String diaChiTamTru) {
		this.diaChiTamTru = diaChiTamTru;
	}
	
}
