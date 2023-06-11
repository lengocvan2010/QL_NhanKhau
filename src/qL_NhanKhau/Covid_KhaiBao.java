package qL_NhanKhau;

import java.sql.Date;

public class Covid_KhaiBao {
	private Integer idKhaiBao;
	private NhanKhau nhanKhau;
	private Date ngayKhaiBao;
	private String trieuChung;
	private String tinhTrang;
	public Covid_KhaiBao(int idKhaiBao, NhanKhau nhanKhau, Date ngayKhaiBao, String trieuChung, String tinhTrang) {
		super();
		this.idKhaiBao = idKhaiBao;
		this.nhanKhau = nhanKhau;
		this.ngayKhaiBao = ngayKhaiBao;
		this.trieuChung = trieuChung;
		this.tinhTrang = tinhTrang;
	}
	public Covid_KhaiBao(NhanKhau nhanKhau, Date ngayKhaiBao, String trieuChung, String tinhTrang) {
		super();
		this.nhanKhau = nhanKhau;
		this.ngayKhaiBao = ngayKhaiBao;
		this.trieuChung = trieuChung;
		this.tinhTrang = tinhTrang;
	}
	public Integer getIdKhaiBao() {
		return idKhaiBao;
	}
	public void setIdKhaiBao(int idKhaiBao) {
		this.idKhaiBao = idKhaiBao;
	}
	public NhanKhau getNhanKhau() {
		return nhanKhau;
	}
	public void setNhanKhau(NhanKhau nhanKhau) {
		this.nhanKhau = nhanKhau;
	}
	public Date getNgayKhaiBao() {
		return ngayKhaiBao;
	}
	public void setNgayKhaiBao(Date ngayKhaiBao) {
		this.ngayKhaiBao = ngayKhaiBao;
	}
	public String getTrieuChung() {
		return trieuChung;
	}
	public void setTrieuChung(String trieuChung) {
		this.trieuChung = trieuChung;
	}
	public String getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	
}
