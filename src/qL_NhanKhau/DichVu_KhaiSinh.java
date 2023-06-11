package qL_NhanKhau;

import java.sql.Date;

public class DichVu_KhaiSinh extends DichVu {
	private NhanKhau nguoiKhai;
	public DichVu_KhaiSinh() {
		super();
		super.setTenDichVu("Khai sinh");
	}
	public DichVu_KhaiSinh(NhanKhau nhanKhau, String tenDichVu, Date date,NhanKhau nguoiKhai) {
		super(nhanKhau,tenDichVu,date);
		this.nguoiKhai = nguoiKhai;
		super.setTenDichVu("Khai sinh");
	}
	public NhanKhau getNguoiKhai() {
		return nguoiKhai;
	}
	public void setNguoiKhai(NhanKhau nguoiKhai) {
		this.nguoiKhai = nguoiKhai;
	}
}
