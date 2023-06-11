package qL_NhanKhau;

import java.util.ArrayList;

public class HoKhau {
	private String soHoKhau;
	private NhanKhau chuHo;
	private String diaChi;
	ArrayList<NhanKhau> nkL;
	
	public HoKhau(String soHoKhau, NhanKhau chuHo, String diaChi, ArrayList<NhanKhau> nkL) {
		super();
		this.soHoKhau = soHoKhau;
		this.chuHo = chuHo;
		this.diaChi = diaChi;
		this.nkL = nkL;
	}

	public HoKhau(String soHoKhau, NhanKhau chuHo, String diaChi) {
		this.chuHo = chuHo;
		this.soHoKhau = soHoKhau;
		this.diaChi = diaChi;
	}

	public HoKhau() {
		// TODO Auto-generated constructor stub
	}

	public String getSoHoKhau() {
		return soHoKhau;
	}

	public void setSoHoKhau(String soHoKhau) {
		this.soHoKhau = soHoKhau;
	}

	public NhanKhau getChuHo() {
		return chuHo;
	}

	public void setChuHo(NhanKhau chuHo) {
		this.chuHo = chuHo;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public ArrayList<NhanKhau> getNkL() {
		return nkL;
	}

	public void setNkL(ArrayList<NhanKhau> nkL) {
		this.nkL = nkL;
	}
	
}
