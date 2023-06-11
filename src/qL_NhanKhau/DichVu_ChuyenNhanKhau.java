package qL_NhanKhau;

import java.sql.Date;

public class DichVu_ChuyenNhanKhau extends DichVu {
	private HoKhau hoKhauChuyenDi;
	private HoKhau hoKhauChuyenDen;
	public DichVu_ChuyenNhanKhau(NhanKhau nhanKhau,String tenDichVu,Date date,HoKhau hoKhauChuyenDi, HoKhau hoKhauChuyenDen) {
		super(nhanKhau,tenDichVu,date);
		this.hoKhauChuyenDen = hoKhauChuyenDen;
		this.hoKhauChuyenDi = hoKhauChuyenDi;
		super.setTenDichVu("Chuyen nhan khau");
	}
	public DichVu_ChuyenNhanKhau() {
		super();
		super.setTenDichVu("Chuyen nhan khau");
	}
	public HoKhau getHoKhauChuyenDi() {
		return hoKhauChuyenDi;
	}
	public void setHoKhauChuyenDi(HoKhau hoKhauChuyenDi) {
		this.hoKhauChuyenDi = hoKhauChuyenDi;
	}
	public HoKhau getHoKhauChuyenDen() {
		return hoKhauChuyenDen;
	}
	public void setHoKhauChuyenDen(HoKhau hoKhauChuyenDen) {
		this.hoKhauChuyenDen = hoKhauChuyenDen;
	}
}
