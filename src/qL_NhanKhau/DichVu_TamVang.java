package qL_NhanKhau;

import java.sql.Date;

public class DichVu_TamVang extends DichVu{
	private String diaChiTamTru;
	private Date tuNgay;
	private Date denNgay;
	String lyDo;
	public DichVu_TamVang() {
		super();
		this.setTenDichVu("Tam vang");
	}
	
	public DichVu_TamVang(NhanKhau nhanKhau, String tenDichVu, Date date,String diaChiTamTru, Date tuNgay, Date denNgay,String lydo) {
		super(nhanKhau,tenDichVu,date);
		this.diaChiTamTru = diaChiTamTru;
		this.tuNgay = tuNgay;
		this.denNgay = denNgay;
		this.setTenDichVu("Tam vang");
		this.lyDo = lydo;
	}
	public String getDiaChiTamTru() {
		return diaChiTamTru;
	}
	public void setDiaChiTamTru(String diaChiTamTru) {
		this.diaChiTamTru = diaChiTamTru;
	}
	public Date getTuNgay() {
		return tuNgay;
	}
	public void setTuNgay(Date tuNgay) {
		this.tuNgay = tuNgay;
	}
	public Date getDenNgay() {
		return denNgay;
	}
	public void setDenNgay(Date denNgay) {
		this.denNgay = denNgay;
	}
	public String getLyDo() {
		return lyDo;
	}
	public void setLyDo(String lyDo) {
		this.lyDo = lyDo;
	}
	
}
