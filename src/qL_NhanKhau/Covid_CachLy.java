package qL_NhanKhau;

import java.sql.Date;

public class Covid_CachLy {
	private Integer idMaCachLy;
	private NhanKhau nhanKhau;
	private Date ngayBatDau;
	private int soNgay;
	private String loaiCachLy; //0-F0, 1-F1,...
	private String noiCachLy;
	public Covid_CachLy(Integer idMaCachLy, NhanKhau nhanKhau, Date ngayBatDau, int soNgay, String loaiCachLy,
			String noiCachLy) {
		super();
		this.idMaCachLy = idMaCachLy;
		this.nhanKhau = nhanKhau;
		this.ngayBatDau = ngayBatDau;
		this.soNgay = soNgay;
		this.loaiCachLy = loaiCachLy;
		this.noiCachLy = noiCachLy;
	}
	public Covid_CachLy(NhanKhau nhanKhau, Date ngayBatDau, int soNgay, String loaiCachLy, String noiCachLy) {
		super();
		this.nhanKhau = nhanKhau;
		this.ngayBatDau = ngayBatDau;
		this.soNgay = soNgay;
		this.loaiCachLy = loaiCachLy;
		this.noiCachLy = noiCachLy;
	}
	public Covid_CachLy() {
		super();
	}
	public Integer getIdMaCachLy() {
		return idMaCachLy;
	}
	public void setIdMaCachLy(Integer idMaCachLy) {
		this.idMaCachLy = idMaCachLy;
	}
	public NhanKhau getNhanKhau() {
		return nhanKhau;
	}
	public void setNhanKhau(NhanKhau nhanKhau) {
		this.nhanKhau = nhanKhau;
	}
	public Date getNgayBatDau() {
		return ngayBatDau;
	}
	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}
	public int getSoNgay() {
		return soNgay;
	}
	public void setSoNgay(int soNgay) {
		this.soNgay = soNgay;
	}
	public String getLoaiCachLy() {
		return loaiCachLy;
	}
	public void setLoaiCachLy(String loaiCachLy) {
		this.loaiCachLy = loaiCachLy;
	}
	public String getNoiCachLy() {
		return noiCachLy;
	}
	public void setNoiCachLy(String noiCachLy) {
		this.noiCachLy = noiCachLy;
	}
	
}
