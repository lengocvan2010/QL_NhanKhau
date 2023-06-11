package qL_NhanKhau;

import java.sql.Date;

public class Covid_TestCovid {
	private Integer idTest;
	private NhanKhau nhanKhau;
	private Date ngayTest;
	private String ketQua;
	public Covid_TestCovid(Integer idTest, NhanKhau nhanKhau, Date ngayTest, String ketQua) {
		super();
		this.idTest = idTest;
		this.nhanKhau = nhanKhau;
		this.ngayTest = ngayTest;
		this.ketQua = ketQua;
	}
	public Covid_TestCovid(NhanKhau nhanKhau, Date ngayTest, String ketQua) {
		super();
		this.nhanKhau = nhanKhau;
		this.ngayTest = ngayTest;
		this.ketQua = ketQua;
	}
	public Integer getIdTest() {
		return idTest;
	}
	public void setIdTest(Integer idTest) {
		this.idTest = idTest;
	}
	public NhanKhau getNhanKhau() {
		return nhanKhau;
	}
	public void setNhanKhau(NhanKhau nhanKhau) {
		this.nhanKhau = nhanKhau;
	}
	public Date getNgayTest() {
		return ngayTest;
	}
	public void setNgayTest(Date ngayTest) {
		this.ngayTest = ngayTest;
	}
	public String getKetQua() {
		return ketQua;
	}
	public void setKetQua(String ketQua) {
		this.ketQua = ketQua;
	}
	
	
}
