package qL_NhanKhau;

import java.sql.Date;

public class NhanKhau {
	private String id;
	private String ten;
	String gioiTinh;
	private String biDanh;
	private Date ngaySinh;
	private String noiSinh;
	private String queQuan;
	private String danToc;
	private String ngheNghiep;
	private String noiLamViec;
	private String CCCD;
	private Date ngayCap;
	private String noiCap;
	private Date ngayDangKyThuongTru;
	private String diaChiThuongTru;
	private String diaChiThuongTruTruoc;
	private String quanHeChuHo;
	private Date ngayChuyen;
	private String noiChuyen;
	private String ghiChu;
	
	String soHK;
	
	
 
	public NhanKhau(String id, String ten, String gioiTinh, String biDanh, Date ngaySinh, String noiSinh,
			String queQuan, String danToc, String ngheNghiep, String noiLamViec, String cCCD, Date ngayCap,
			String noiCap, Date ngayDangKyThuongTru, String diaChiThuongTru, String diaChiThuongTruTruoc,
			Date ngayChuyen, String noiChuyen, String ghiChu) {
		super();
		this.id = id;
		this.ten = ten;
		this.gioiTinh = gioiTinh;
		this.biDanh = biDanh;
		this.ngaySinh = ngaySinh;
		this.noiSinh = noiSinh;
		this.queQuan = queQuan;
		this.danToc = danToc;
		this.ngheNghiep = ngheNghiep;
		this.noiLamViec = noiLamViec;
		CCCD = cCCD;
		this.ngayCap = ngayCap;
		this.noiCap = noiCap;
		this.ngayDangKyThuongTru = ngayDangKyThuongTru;
		this.diaChiThuongTru = diaChiThuongTru;
		this.diaChiThuongTruTruoc = diaChiThuongTruTruoc;
		this.ngayChuyen = ngayChuyen;
		this.noiChuyen = noiChuyen;
		this.ghiChu = ghiChu;
	}

	public String getDiaChiThuongTru() {
		return diaChiThuongTru;
	}

	public NhanKhau(String ten, String gioiTinh, String biDanh, Date ngaySinh, String noiSinh, String queQuan,
			String danToc, String ngheNghiep, String noiLamViec, String cCCD, Date ngayCap, String noiCap,
			Date ngayDangKyThuongTru, String diaChiThuongTru, String diaChiThuongTruTruoc, String quanHeChuHo,
			Date ngayChuyen, String noiChuyen, String ghiChu) {
		super();
		this.ten = ten;
		this.gioiTinh = gioiTinh;
		this.biDanh = biDanh;
		this.ngaySinh = ngaySinh;
		this.noiSinh = noiSinh;
		this.queQuan = queQuan;
		this.danToc = danToc;
		this.ngheNghiep = ngheNghiep;
		this.noiLamViec = noiLamViec;
		CCCD = cCCD;
		this.ngayCap = ngayCap;
		this.noiCap = noiCap;
		this.ngayDangKyThuongTru = ngayDangKyThuongTru;
		this.diaChiThuongTru = diaChiThuongTru;
		this.diaChiThuongTruTruoc = diaChiThuongTruTruoc;
		this.quanHeChuHo = quanHeChuHo;
		this.ngayChuyen = ngayChuyen;
		this.noiChuyen = noiChuyen;
		this.ghiChu = ghiChu;
	}

	public NhanKhau(String id, String ten, String gioiTinh, String biDanh, Date ngaySinh, String noiSinh,
			String queQuan, String danToc, String ngheNghiep, String noiLamViec, String cCCD, Date ngayCap,
			String noiCap, Date ngayDangKyThuongTru, String diaChiThuongTru, String diaChiThuongTruTruoc,
			String quanHeChuHo, Date ngayChuyen, String noiChuyen, String ghiChu) {
		super();
		this.id = id;
		this.ten = ten;
		this.gioiTinh = gioiTinh;
		this.biDanh = biDanh;
		this.ngaySinh = ngaySinh;
		this.noiSinh = noiSinh;
		this.queQuan = queQuan;
		this.danToc = danToc;
		this.ngheNghiep = ngheNghiep;
		this.noiLamViec = noiLamViec;
		CCCD = cCCD;
		this.ngayCap = ngayCap;
		this.noiCap = noiCap;
		this.ngayDangKyThuongTru = ngayDangKyThuongTru;
		this.diaChiThuongTru = diaChiThuongTru;
		this.diaChiThuongTruTruoc = diaChiThuongTruTruoc;
		this.quanHeChuHo = quanHeChuHo;
		this.ngayChuyen = ngayChuyen;
		this.noiChuyen = noiChuyen;
		this.ghiChu = ghiChu;
	}

	public NhanKhau() {
		// TODO Auto-generated constructor stub
	}

	


	public NhanKhau(String ten, String gioiTinh, String biDanh, Date ngaySinh, String noiSinh, String queQuan,
			String danToc, String ngheNghiep, String noiLamViec, String cCCD, Date ngayCap, String noiCap,
			Date ngayDangKyThuongTru, String diaChiThuongTru, String diaChiThuongTruTruoc, Date ngayChuyen,
			String noiChuyen, String ghiChu) {
		super();
		this.ten = ten;
		this.gioiTinh = gioiTinh;
		this.biDanh = biDanh;
		this.ngaySinh = ngaySinh;
		this.noiSinh = noiSinh;
		this.queQuan = queQuan;
		this.danToc = danToc;
		this.ngheNghiep = ngheNghiep;
		this.noiLamViec = noiLamViec;
		CCCD = cCCD;
		this.ngayCap = ngayCap;
		this.noiCap = noiCap;
		this.ngayDangKyThuongTru = ngayDangKyThuongTru;
		this.diaChiThuongTru = diaChiThuongTru;
		this.diaChiThuongTruTruoc = diaChiThuongTruTruoc;
		this.ngayChuyen = ngayChuyen;
		this.noiChuyen = noiChuyen;
		this.ghiChu = ghiChu;
	}

	public void setDiaChiThuongTru(String diaChiThuongTru) {
		this.diaChiThuongTru = diaChiThuongTru;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}
 
	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getBiDanh() {
		if(biDanh==null||biDanh.isBlank()) return "Không";
		return biDanh;
	}

	public void setBiDanh(String biDanh) {
		this.biDanh = biDanh;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getNoiSinh() {
		return noiSinh;
	}

	public void setNoiSinh(String noiSinh) {
		this.noiSinh = noiSinh;
	}

	public String getQueQuan() {
		return queQuan;
	}

	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}

	public String getDanToc() {
		return danToc;
	}

	public void setDanToc(String danToc) {
		this.danToc = danToc;
	}

	public String getNgheNghiep() {
		if(ngheNghiep==null||ngheNghiep.isBlank()) return "Không";
		return ngheNghiep;
	}

	public void setNgheNghiep(String ngheNghiep) {
		this.ngheNghiep = ngheNghiep;
	}

	public String getNoiLamViec() {
		if(noiLamViec==null||noiLamViec.isBlank()) return "Không";
		return noiLamViec;
	}

	public void setNoiLamViec(String noiLamViec) {
		this.noiLamViec = noiLamViec;
	}

	public String getCCCD() {
		if(CCCD==null||CCCD.isBlank()) return "Không";
		return CCCD;
	}

	public void setCCCD(String cCCD) {
		CCCD = cCCD;
	}

	public Date getNgayCap() {
		return ngayCap;
	}

	public void setNgayCap(Date ngayCap) {
		this.ngayCap = ngayCap;
	}

	public String getNoiCap() {
		if(noiCap==null||noiCap.isBlank()) return "Không";
		return noiCap;
	}

	public void setNoiCap(String noiCap) {
		this.noiCap = noiCap;
	}

	public Date getNgayDangKyThuongTru() {
		return ngayDangKyThuongTru;
	}

	public void setNgayDangKyThuongTru(Date ngayDangKyThuongTru) {
		this.ngayDangKyThuongTru = ngayDangKyThuongTru;
	}

	public String getQuanHeChuHo() {
		if(quanHeChuHo==null) return "Vô gia cư";
		return quanHeChuHo;
	}

	public void setQuanHeChuHo(String quanHeChuHo) {
		this.quanHeChuHo = quanHeChuHo;
	}

	public String getDiaChiThuongTruTruoc() {
		if(diaChiThuongTruTruoc==null||diaChiThuongTruTruoc.isBlank()) return "Không";
		return diaChiThuongTruTruoc;
	}

	public void setDiaChiThuongTruTruoc(String diaChiThuongTruTruoc) {
		this.diaChiThuongTruTruoc = diaChiThuongTruTruoc;
	}
	
	public Date getNgayChuyen() {
		return ngayChuyen;
	}

	public void setNgayChuyen(Date ngayChuyen) {
		this.ngayChuyen = ngayChuyen;
	}

	public String getNoiChuyen() {
		if(noiChuyen==null||noiChuyen.isBlank()) return "Không";
		return noiChuyen;
	}

	public void setNoiChuyen(String noiChuyen) {
		this.noiChuyen = noiChuyen;
	}

	public String getGhiChu() {
		if(ghiChu==null||ghiChu.isBlank()) return "Không";
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	
	public int getInGioiTinh() {
		if(getGioiTinh().equals("Nam")) return 0;
		if(getGioiTinh().equals("Nữ")) return 1;
		if(getGioiTinh().equals("Khác")) return 2;
		return 0;
	}

	public String getSoHK() {
		if(soHK==null) return "Vô gia cư";
		return soHK;
	}

	public void setSoHK(String soHK) {
		this.soHK = soHK;
	}
	
}
