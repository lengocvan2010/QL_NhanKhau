package qL_NhanKhau;

import java.sql.Date;

public class DichVu_KhaiTu extends DichVu {
	private NhanKhau nguoiKhai;
	public DichVu_KhaiTu() {
		super();
		super.setTenDichVu("Khai tu");
	}
	public DichVu_KhaiTu(NhanKhau nhanKhau, String tenDichVu, Date date,NhanKhau nguoiKhai) {
		super(nhanKhau,tenDichVu,date);
		this.nguoiKhai = nguoiKhai;
		super.setTenDichVu("Khai tu");
	}
	public NhanKhau getNguoiKhai() {
		return nguoiKhai;
	}
	public void setNguoiKhai(NhanKhau nguoiKhai) {
		this.nguoiKhai = nguoiKhai;
	}
}
