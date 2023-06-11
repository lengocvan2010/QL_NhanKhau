package qL_NhanKhau;

import java.sql.Date;

public class DichVu {
	private int id;
	NhanKhau nhanKhau;
	private String tenDichVu;
	Date date;
	
	public DichVu() {
		
	}
	public DichVu(int id, NhanKhau nhanKhau, String tenDichVu, Date date) {
		super();
		this.id = id;
		this.nhanKhau = nhanKhau;
		this.tenDichVu = tenDichVu;
		this.date = date;
	}
	public DichVu(NhanKhau nhanKhau, String tenDichVu, Date date) {
		super();
		this.nhanKhau = nhanKhau;
		this.tenDichVu = tenDichVu;
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public NhanKhau getNhanKhau() {
		return nhanKhau;
	}
	public void setNhanKhau(NhanKhau nhanKhau) {
		this.nhanKhau = nhanKhau;
	}
	public String getTenDichVu() {
		if(tenDichVu.equals("Khai tu")) return "Khai tử";
		if(tenDichVu.equals("Tam tru")) return "Tạm trú";
		if(tenDichVu.equals("Tam vang")) return "Tạm vắng";
		if(tenDichVu.equals("Chuyen nhan khau")) return "Chuyển nhân khẩu";
		return tenDichVu;
	}
	public void setTenDichVu(String tenDichVu) {
		this.tenDichVu = tenDichVu;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
