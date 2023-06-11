package controller;

import java.sql.Date;
import java.util.ArrayList;

import qL_NhanKhau.*;
import sql.ConnectSQL;

public class HoKhauController extends CONTROLLER{
	
	
	public HoKhauController(ConnectSQL c) {
		super(c);
	}
	
	
	//HoKhau
	public boolean tachHoKhau(HoKhau cu, HoKhau m) {
		boolean check = true;
		try {
			for (int i = 0; i < m.getNkL().size(); i++) {
				xoaThanhVien(cu, m.getNkL().get(i));
			}
			themHK(m);
			
		} catch (Exception e) {
			check  = false;
			e.printStackTrace();
		}
		return check;
	}
	
	public HoKhau timHoKhau(String soHK) {
		HoKhau h = new HoKhau();
		NhanKhau n = new NhanKhau();
		try {
			String str = sql.HO_KHAU_QUERY_TIMHO;
			pstmt = jdbc.getConnect().prepareStatement(str);
			pstmt.setString(1, soHK);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String sohk = rs.getString("SoHoKhau");
				String dc = rs.getString("DiaChi");
				NhanKhau chuho = new NhanKhau();
				chuho.setTen(rs.getString("Ten"));
				h = new HoKhau(sohk, chuho, dc);
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

		return h;
	}
	
	public boolean xoaHK(HoKhau h) {
		boolean check = true;
		try {
			String str = sql.HO_KHAU_QUERY_Delete_HK;
			pstmt = jdbc.getConnect().prepareStatement(str);
			pstmt.setString(1, h.getSoHoKhau());
			pstmt.execute();
		} catch (Exception e) {
			check = false;
			e.printStackTrace();
		}finally {
			try {
				jdbc.releaseResource(rs, stmt, pstmt, null, null);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return check;
	}
	

	public boolean suaHK(HoKhau h) {
		boolean check = true;
		try {
			try {
				String str = sql.HO_KHAU_UPDATE;
				pstmt = jdbc.getConnect().prepareStatement(str);
				pstmt.setString(1, h.getSoHoKhau());
				pstmt.setString(2, h.getDiaChi());
				pstmt.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			check = false;
			e.printStackTrace();
		}finally {
			try {
				jdbc.releaseResource(rs, stmt, pstmt, null, null);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return check;
	}
	
	public boolean themHK(HoKhau h) {
		boolean check = false;
		try {//FIX
				String str = sql.NHAN_KHAU_QUERY_INSERT_HoKhau;
				pstmt = jdbc.getConnect().prepareStatement(str);
				pstmt.setString(1, h.getSoHoKhau());
				pstmt.setString(2, h.getDiaChi());
				pstmt.execute();
				check = true;
		} catch (Exception e) {
			check = false;
			e.printStackTrace();
		}finally {
			try {
				jdbc.releaseResource(rs, stmt, pstmt, null, null);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return check;
	}
	
	public ArrayList<HoKhau> xemTT(){
		ArrayList<HoKhau> l = new ArrayList<>();
		try {
			String str = sql.HO_KHAU_QUERY_LAY_THONG_TIN;
			pstmt = jdbc.getConnect().prepareStatement(str);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String sohk = rs.getString("SoHoKhau");
				String dc = rs.getString("DiaChi");
				NhanKhau chuho = new NhanKhau();
				chuho.setTen(rs.getString("Ten"));
				l.add(new HoKhau(sohk, chuho, dc));	
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
		
		return l;
	}
	
	public ArrayList<HoKhau> timKiem(String tkS){
		ArrayList<HoKhau> l = new ArrayList<>();
		try {
			String str = sql.HO_KHAU_QUERY_TIMKIEM_TENCHUHO;
			pstmt = jdbc.getConnect().prepareStatement(str);
			pstmt.setString(1, "%"+tkS+"%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String sohk = rs.getString("SoHoKhau");
				String dc = rs.getString("DiaChi");
				NhanKhau chuho = new NhanKhau();
				chuho.setTen(rs.getString("Ten"));
				l.add(new HoKhau(sohk, chuho, dc));	
			}
			jdbc.releaseResource(rs, stmt, pstmt, null, null);
			str = sql.HO_KHAU_QUERY_TIMKIEM_DIACHI;
			
			pstmt = jdbc.getConnect().prepareStatement(str);
			pstmt.setString(1, "%"+tkS+"%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String sohk = rs.getString("SoHoKhau");
				String dc = rs.getString("DiaChi");
				NhanKhau chuho = new NhanKhau();
				chuho.setTen(rs.getString("Ten"));
				l.add(new HoKhau(sohk, chuho, dc));	
			}
			jdbc.releaseResource(rs, stmt, pstmt, null, null);
			
			str = sql.HO_KHAU_QUERY_TIMKIEM_SOHO;
			pstmt = jdbc.getConnect().prepareStatement(str);
			pstmt.setString(1, "%"+tkS+"%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String sohk = rs.getString("SoHoKhau");
				String dc = rs.getString("DiaChi");
				NhanKhau chuho = new NhanKhau();
				chuho.setTen(rs.getString("Ten"));
				l.add(new HoKhau(sohk, chuho, dc));	
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
		return l;
	}
	
	//HK_MK
	public ArrayList<NhanKhau> dsThanhVien(HoKhau h){
		ArrayList<NhanKhau> l = new ArrayList<>();
		try {
			String str = sql.HO_KHAU_LIST_NHANKHAU;
			pstmt = jdbc.getConnect().prepareStatement(str);
			pstmt.setString(1, h.getSoHoKhau());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String id_nk = rs.getString("ID");
				Date ngaySinh = rs.getDate("NgaySinh");
				String hoten = rs.getString("Ten");
				String biDanh = rs.getString("BiDanh");
				String gioiTinh = rs.getString("GioiTinh");
				String noiSinh = rs.getString("NoiSinh");
				String CCCD = rs.getString("CCCD");
				String danToc = rs.getString("DanToc");
				String queQuan = rs.getString("QueQuan");
				String noiThuongTruTruoc=rs.getString("DiaChiThuongTruTruoc");
				String noiThuongTru = rs.getString("DiaChiThuongTru");
				String ngheNghiep=rs.getString("NgheNghiep");
				String noiLamViec=rs.getString("NoiLamViec");
				String noiCap=rs.getString("NoiCapCCCD");
				String ghiChu = rs.getString("GhiChu");
				Date ngayDKThuongTru = rs.getDate("NgayDKThuongTru");
				String noiChuyen = rs.getString("NoiChuyen");
				Date ngayCap=rs.getDate("NgayCapCCCD");
				Date ngayChuyenDi= rs.getDate("NgayChuyenDi");
				String quanHe = rs.getString("QuanHeVoiChuHo");
				
				NhanKhau n = new NhanKhau(id_nk, hoten, gioiTinh, biDanh, ngaySinh, noiSinh, queQuan, danToc, ngheNghiep, 
						noiLamViec, CCCD, ngayCap, noiCap, ngayDKThuongTru, noiThuongTru, noiThuongTruTruoc, ngayChuyenDi,
						noiChuyen, ghiChu);
				n.setQuanHeChuHo(quanHe);
				l.add(n);
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
		return l;
	}
	
	public NhanKhau timVogiacu(String C){
		NhanKhau l = new NhanKhau();
		try {
			String str = sql.NHAN_KHAU_TIMVOGIACU;
			pstmt = jdbc.getConnect().prepareStatement(str);
			pstmt.setString(1, C);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String id_nk = rs.getString("ID");
				Date ngaySinh = rs.getDate("NgaySinh");
				String hoten = rs.getString("Ten");
				String biDanh = rs.getString("BiDanh");
				String gioiTinh = rs.getString("GioiTinh");
				String noiSinh = rs.getString("NoiSinh");
				String CCCD = rs.getString("CCCD");
				String danToc = rs.getString("DanToc");
				String queQuan = rs.getString("QueQuan");
				String noiThuongTruTruoc=rs.getString("DiaChiThuongTruTruoc");
				String noiThuongTru = rs.getString("DiaChiThuongTru");
				String ngheNghiep=rs.getString("NgheNghiep");
				String noiLamViec=rs.getString("NoiLamViec");
				String noiCap=rs.getString("NoiCapCCCD");
				String ghiChu = rs.getString("GhiChu");
				Date ngayDKThuongTru = rs.getDate("NgayDKThuongTru");
				String noiChuyen = rs.getString("NoiChuyen");
				Date ngayCap=rs.getDate("NgayCapCCCD");
				Date ngayChuyenDi= rs.getDate("NgayChuyenDi");
			
				l = new NhanKhau(id_nk, hoten, biDanh, gioiTinh, ngaySinh, noiSinh, queQuan, danToc, ngheNghiep, 
						noiLamViec, CCCD, ngayCap, noiCap, ngayDKThuongTru, noiThuongTru, noiThuongTruTruoc, ngayChuyenDi,
						noiChuyen, ghiChu);
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
		return l;
	}
	
	public boolean checkTonTaiTrongNK_HK(NhanKhau n) {
		boolean check = false;
		try {
			String str = sql.NK_HK_TIM_NK;
			pstmt = jdbc.getConnect().prepareStatement(str);
			pstmt.setString(1, n.getId());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				check = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}
	
	public boolean themThanhVien(HoKhau h, NhanKhau n) {
		boolean check = true;
		try {
			String str = sql.HO_KHAU_QUERY_THEMNHANKHAU_TO_nkhk;
			pstmt = jdbc.getConnect().prepareStatement(str);
			pstmt.setString(1, n.getId());
			pstmt.setString(2, h.getSoHoKhau());
			pstmt.setString(3, n.getQuanHeChuHo());
			pstmt.execute();
		} catch (Exception e) {
			check = false;
			e.printStackTrace();
		}finally {
			try {
				jdbc.releaseResource(rs, stmt, pstmt, null, null);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return check;
	}
	
	public boolean suaQuanHe(HoKhau h,NhanKhau n) {
		boolean check = true;
		try {
			String str=sql.NK_HK_DoiQuanHe;
			pstmt = jdbc.getConnect().prepareStatement(str);
			pstmt.setString(1, n.getQuanHeChuHo());
			pstmt.setString(2, h.getSoHoKhau());
			pstmt.setString(3, n.getId());
			pstmt.execute();
		} catch (Exception e) {
			check = false;
			e.printStackTrace();
		}finally {
			try {
				jdbc.releaseResource(rs, stmt, pstmt, null, null);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return check;
	}
	
	public boolean xoaThanhVien(HoKhau h, NhanKhau n) {
		boolean check = true;
		try {
			String str = sql.NK_HK_XOA;
			pstmt = jdbc.getConnect().prepareStatement(str);
			pstmt.setString(1, h.getSoHoKhau());
			pstmt.setString(2, n.getId());
			pstmt.execute();
		} catch (Exception e) {
			check = false;
			e.printStackTrace();
		}finally {
			try {
				jdbc.releaseResource(rs, stmt, pstmt, null, null);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return check;
	}
	public boolean xoaNK_HK(HoKhau h) {
		boolean check = true;
		try {
			String str = sql.NK_HK_XOA_HK;
			pstmt = jdbc.getConnect().prepareStatement(str);
			pstmt.setString(1, h.getSoHoKhau());
			pstmt.execute();
		} catch (Exception e) {
			check = false;
			e.printStackTrace();
		}finally {
			try {
				jdbc.releaseResource(rs, stmt, pstmt, null, null);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return check;
	}
	
	

}
