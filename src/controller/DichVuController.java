package controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import qL_NhanKhau.DichVu;
import qL_NhanKhau.DichVu_ChuyenNhanKhau;
import qL_NhanKhau.DichVu_KhaiSinh;
import qL_NhanKhau.DichVu_KhaiTu;
import qL_NhanKhau.DichVu_TamTru;
import qL_NhanKhau.DichVu_TamVang;
import qL_NhanKhau.HoKhau;
import qL_NhanKhau.NhanKhau;
import sql.ConnectSQL;

public class DichVuController extends CONTROLLER{

	public DichVuController(ConnectSQL c) {
		super(c);
	}
	
	public boolean themDV(DichVu d) {
		boolean check = true;
		
		return check;
	}
	
	public ArrayList<DichVu> xemTT(){
		ArrayList<DichVu> l = new ArrayList<>();
		try {
			String str = sql.DICHVU_THONGTIN;
			pstmt = jdbc.getConnect().prepareStatement(str);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NhanKhau n = new NhanKhau();
				n.setId(rs.getString("ID_NhanKhau"));
				n.setTen(rs.getString("Ten"));
				DichVu d = new DichVu(rs.getInt("ID"), n, rs.getString("DichVu"), rs.getDate("NgayDangKy"));
				
				l.add(d);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			try {
				jdbc.releaseResource(rs, stmt, pstmt, null, null);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return l;
	}
	
	
	//KhaiSinh
	public DichVu_KhaiSinh xemKhaiSinh(int id) {
		DichVu_KhaiSinh d = new DichVu_KhaiSinh();
		try {
			String str = sql.KHAISINH_XEM;
			pstmt = jdbc.getConnect().prepareStatement(str);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NhanKhau n = new NhanKhau();
				n.setId(rs.getString("ID_NhanKhau"));
				d.setNhanKhau(n);
				
				NhanKhau nk = new NhanKhau();
				nk.setId(rs.getString("ID_NguoiKhai"));
				d.setNguoiKhai(nk);
				
				d.setId(id);
				d.setDate(rs.getDate("NgayDangKy"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				jdbc.releaseResource(rs, stmt, pstmt, null, null);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		
		return d;
	}
	
	public boolean themKhaiSinh(DichVu_KhaiSinh khaiSinh) {
		boolean check = true;
		String them = sql.KHAISINH_THEM;
		try {
			pstmt = jdbc.getConnect().prepareStatement(them);
			pstmt.setString(1, khaiSinh.getNhanKhau().getId());
            pstmt.setString(2, khaiSinh.getNguoiKhai().getId());
            LocalDate ngay = java.time.LocalDate.now();
            int n = ngay.getDayOfMonth();
            int thang = ngay.getMonthValue()-1;
            int nam = ngay.getYear()-1900;
            Date date = new Date(nam, thang, n);
            pstmt.setDate(3, date);
            pstmt.execute();
		} catch (Exception e) {
			check = false;
			e.printStackTrace();
		} finally {
			try {
				jdbc.releaseResource(rs, stmt, pstmt, null, null);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return check;
	}
	public boolean xoaKhaiSinh(DichVu_KhaiSinh khaiSinh) {
		boolean check = true;
		String them = sql.KHAISINH_XOATT;
		try {
			pstmt = jdbc.getConnect().prepareStatement(them);
			pstmt.setInt(1, khaiSinh.getId());
            pstmt.execute();
		} catch (Exception e) {
			check = false;
			e.printStackTrace();
		} finally {
			try {
				jdbc.releaseResource(rs, stmt, pstmt, null, null);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return check;
	}
	
	//KhaiTu
	
	public DichVu_KhaiTu xemKhaiTu(int id) {
		DichVu_KhaiTu d = new DichVu_KhaiTu();
		try {
			String str = sql.KHAITU_XEM;
			pstmt = jdbc.getConnect().prepareStatement(str);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NhanKhau n = new NhanKhau();
				n.setId(rs.getString("ID_NhanKhau"));
				d.setNhanKhau(n);
				
				NhanKhau nk = new NhanKhau();
				nk.setId(rs.getString("ID_NguoiKhai"));
				d.setNguoiKhai(nk);
				
				d.setId(id);
				d.setDate(rs.getDate("NgayDangKy"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				jdbc.releaseResource(rs, stmt, pstmt, null, null);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		
		return d;
	}
	public boolean themKhaiTu(DichVu_KhaiTu khaiTu) {
		boolean check = true;
		String them = sql.KHAITU_THEM;
		try {
			pstmt = jdbc.getConnect().prepareStatement(them);
			pstmt.setString(1, khaiTu.getNhanKhau().getId());
            pstmt.setString(2, khaiTu.getNguoiKhai().getId());
            LocalDate ngay = java.time.LocalDate.now();
            int n = ngay.getDayOfMonth();
            int thang = ngay.getMonthValue()-1;
            int nam = ngay.getYear()-1900;
            Date date = new Date(nam, thang, n);
            
            pstmt.setDate(3, date);
            pstmt.execute();
		} catch (Exception e) {
			check = false;
			e.printStackTrace();
		} finally {
			try {
				jdbc.releaseResource(rs, stmt, pstmt, null, null);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return check;
	}
	public boolean xoaKhaiTu(DichVu_KhaiTu khaiTu) {
		boolean check = true;
		String them = sql.KHAITU_XOATT;
		try {
			pstmt = jdbc.getConnect().prepareStatement(them);
			pstmt.setInt(1, khaiTu.getId());
            pstmt.execute();
		} catch (Exception e) {
			check = false;
			e.printStackTrace();
		} finally {
			try {
				jdbc.releaseResource(rs, stmt, pstmt, null, null);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return check;
	}
	
	
	//TamTru
	public DichVu_TamTru xemTamTru(int id) {
		DichVu_TamTru d = new DichVu_TamTru(null,null,null,null,null);
		try {
			String str = sql.TAMTRU_XEM;
			pstmt = jdbc.getConnect().prepareStatement(str);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NhanKhau n = new NhanKhau();
				n.setId(rs.getString("ID_NhanKhau"));
				d.setNhanKhau(n);
				d.setId(id);
				d.setDate(rs.getDate("NgayDangKy"));
				d.setDiaChiTamTru(rs.getString("DiaChiTamTru"));
				d.setDiaChiThuongTru(rs.getString("DiaChiThuongTru"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				jdbc.releaseResource(rs, stmt, pstmt, null, null);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		
		return d;
	}
	public boolean themTamTru(DichVu_TamTru tamTru) {
		boolean check = true;
		String them = sql.TAMTRU_THEM;
		try {
			pstmt = jdbc.getConnect().prepareStatement(them);
			pstmt.setString(1, tamTru.getNhanKhau().getId());
            pstmt.setString(2, tamTru.getDiaChiThuongTru());
            pstmt.setString(3, tamTru.getDiaChiTamTru());
            pstmt.setDate(4, tamTru.getDate());
            pstmt.execute();
		} catch (Exception e) {
			check = false;
			e.printStackTrace();
		} finally {
			try {
				jdbc.releaseResource(rs, stmt, pstmt, null, null);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return check;
	}
	public boolean xoaTamTru(DichVu_TamTru tamTru) {
		boolean check = true;
		String them = sql.TAMTRU_XOATT;
		try {
			pstmt = jdbc.getConnect().prepareStatement(them);
			pstmt.setInt(1, tamTru.getId());
            pstmt.execute();
		} catch (Exception e) {
			check = false;
			e.printStackTrace();
		} finally {
			try {
				jdbc.releaseResource(rs, stmt, pstmt, null, null);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return check;
	}
	
	//TamVang
	public DichVu_TamVang xemTamVang(int id) {
		DichVu_TamVang d = new DichVu_TamVang(null,null,null,null,null,null,null);
		try {
			String str = sql.TAMVANG_XEM;
			pstmt = jdbc.getConnect().prepareStatement(str);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NhanKhau n = new NhanKhau();
				n.setId(rs.getString("ID_NhanKhau"));
				d.setNhanKhau(n);
				d.setLyDo(rs.getString("LyDo"));
				d.setTuNgay(rs.getDate("TuNgay"));
				d.setDenNgay(rs.getDate("DenNgay"));
				d.setId(id);
				d.setDiaChiTamTru(rs.getString("DiaChiTamTru"));
				d.setDate(rs.getDate("NgayDangKy"));
				d.setNhanKhau(n);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				jdbc.releaseResource(rs, stmt, pstmt, null, null);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		
		return d;
	}
	public boolean themTamVang(DichVu_TamVang tamVang) {
		boolean check = true;
		String them = sql.NHAN_KHAU_QUERY_INSERT_TamVang;
		try {
			pstmt = jdbc.getConnect().prepareStatement(them);
			pstmt.setString(1, tamVang.getNhanKhau().getId());
            pstmt.setString(2, tamVang.getDiaChiTamTru());
            pstmt.setDate(3, tamVang.getTuNgay());
            pstmt.setDate(4, tamVang.getDenNgay());
            pstmt.setString(5, tamVang.getLyDo());
            pstmt.setDate(6, tamVang.getDate());
            pstmt.execute();
		} catch (Exception e) {
			check = false;
			e.printStackTrace();
		} finally {
			try {
				jdbc.releaseResource(rs, stmt, pstmt, null, null);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return check;
	}
	public boolean xoaTamVang(DichVu_TamVang tamVang) {
		boolean check = true;
		String them = sql.NHAN_KHAU_QUERY_INSERT_TamVang;
		try {
			pstmt = jdbc.getConnect().prepareStatement(them);
			pstmt.setInt(1, tamVang.getId());
            pstmt.execute();
		} catch (Exception e) {
			check = false;
			e.printStackTrace();
		} finally {
			try {
				jdbc.releaseResource(rs, stmt, pstmt, null, null);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return check;
	}
	
	
	//ChuyenNhanKhau
	public boolean themChuyenNhanKhau(DichVu_ChuyenNhanKhau chuyenNhanKhau) {
		boolean check = true;
		String them = sql.NHAN_KHAU_QUERY_INSERT_ChuyenNhanKhau;
		try {
			pstmt = jdbc.getConnect().prepareStatement(them);
			pstmt.setString(1, chuyenNhanKhau.getNhanKhau().getId());
            pstmt.setString(2, chuyenNhanKhau.getHoKhauChuyenDi().getSoHoKhau());
            pstmt.setString(3, chuyenNhanKhau.getHoKhauChuyenDen().getSoHoKhau());
            pstmt.setDate(4, chuyenNhanKhau.getDate());
          
            pstmt.execute();
		} catch (Exception e) {
			check = false;
			e.printStackTrace();
		} finally {
			try {
				jdbc.releaseResource(rs, stmt, pstmt, null, null);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return check;
	}
	public DichVu_ChuyenNhanKhau xemChuyenKhau(int id) {
		DichVu_ChuyenNhanKhau d = new DichVu_ChuyenNhanKhau(null,null,null,null,null);
		try {
			String str = sql.CHUYENKHAU_XEM;
			pstmt = jdbc.getConnect().prepareStatement(str);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NhanKhau n = new NhanKhau();
				n.setId(rs.getString("ID_NhanKhau"));
				d.setNhanKhau(n);
				
				HoKhau di = new HoKhau();
				di.setSoHoKhau(rs.getString("HoKhauChuyenDi"));
				d.setHoKhauChuyenDi(di);
				HoKhau den = new HoKhau();
				den.setSoHoKhau(rs.getString("HoKhauChuyenDen"));
				d.setHoKhauChuyenDen(den);
				d.setId(id);
				d.setDate(rs.getDate("NgayDangKy"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				jdbc.releaseResource(rs, stmt, pstmt, null, null);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}	
		return d;
	}
	public boolean xoaChuyenNhanKhau(DichVu_ChuyenNhanKhau chuyenNhanKhau) {
		boolean check = true;
		String them = sql.CHUYENKHAU_XOATT;
		try {
			pstmt = jdbc.getConnect().prepareStatement(them);
			pstmt.setInt(1, chuyenNhanKhau.getId());
            pstmt.execute();
		} catch (Exception e) {
			check = false;
			e.printStackTrace();
		} finally {
			try {
				jdbc.releaseResource(rs, stmt, pstmt, null, null);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return check;
	}
	

}
