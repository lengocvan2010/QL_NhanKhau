package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import qL_NhanKhau.HoKhau;
import qL_NhanKhau.NhanKhau;
import sql.ConnectSQL;

public class NhanKhauController extends CONTROLLER{
	HoKhauController hc;
	public NhanKhauController(ConnectSQL conn) {
		super(conn);
		hc = new HoKhauController(conn);
	}
    
	public boolean themNhanKhau(NhanKhau f) {
		boolean check = true;
		String them = sql.NHAN_KHAU_QUERY_INSERT_NhanKhau;
		try {
			pstmt = jdbc.getConnect().prepareStatement(them);
			pstmt.setString(1, f.getTen());
            pstmt.setString(2, f.getBiDanh());
            pstmt.setString(3, f.getGioiTinh());
            pstmt.setDate(4, f.getNgaySinh());
            pstmt.setString(5, f.getNoiSinh());
            pstmt.setString(6, f.getQueQuan());
            pstmt.setString(7, f.getDanToc());
            pstmt.setString(8, f.getNgheNghiep());
            pstmt.setString(9, f.getNoiLamViec());
            pstmt.setString(10, f.getCCCD());
            pstmt.setDate(11, f.getNgayCap());
            pstmt.setString(12, f.getNoiCap());
            pstmt.setDate(13, f.getNgayDangKyThuongTru());
            pstmt.setString(14, f.getDiaChiThuongTru());
            pstmt.setString(15, f.getDiaChiThuongTruTruoc());
            pstmt.setDate(16, f.getNgayChuyen());
            pstmt.setString(17, f.getNoiChuyen());
            pstmt.setString(18, f.getGhiChu());
            pstmt.setString(19, f.getId());
            pstmt.executeUpdate();
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
	
	public ArrayList<NhanKhau> danhSachNhanKhau() {
		String ctiet = sql.NHAN_KHAU_QUERY_LAY_THONG_TIN;
		ArrayList<NhanKhau> f = new ArrayList<NhanKhau>();
		try {
			pstmt = jdbc.getConnect().prepareStatement(ctiet);
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
				String qh = rs.getString("QuanHeVoiChuHo");
				String soHK = rs.getString("SoHoKhau"); 
				
				NhanKhau n = new NhanKhau(id_nk, hoten, gioiTinh, biDanh, ngaySinh, noiSinh, queQuan, danToc, ngheNghiep, 
						noiLamViec, CCCD, ngayCap, noiCap, ngayDKThuongTru, noiThuongTru, noiThuongTruTruoc, ngayChuyenDi,
						noiChuyen, ghiChu);
				n.setQuanHeChuHo(qh);
				n.setSoHK(soHK);
				f.add(n);
			}
      }catch(Exception e) {
            e.printStackTrace();

    	  try {
    		  jdbc.releaseResource(rs, stmt, pstmt, null, null);
    	  } catch (Exception e2) {
			// TODO: handle exception
    	  }
      	}
		return f;
	}	
    
  
    
    public boolean updateNhanKhau(NhanKhau f){
    	boolean check = true;
    	String suaNK = sql.NHAN_KHAU_QUERY_UPDATE;
        try {
            pstmt = jdbc.getConnect().prepareStatement(sql.NHAN_KHAU_QUERY_UPDATE);
            
            pstmt.setString(1, f.getTen());
            pstmt.setString(2, f.getBiDanh());
            pstmt.setString(3, f.getGioiTinh());
            pstmt.setDate(4, f.getNgaySinh());
            pstmt.setString(5, f.getNoiSinh());
            pstmt.setString(6, f.getQueQuan());
            pstmt.setString(7, f.getDanToc());
            pstmt.setString(8, f.getNgheNghiep());
            pstmt.setString(9, f.getNoiLamViec());
            pstmt.setString(10, f.getCCCD());
            pstmt.setDate(11, f.getNgayCap());
            pstmt.setString(12, f.getNoiCap());
            pstmt.setDate(13, f.getNgayDangKyThuongTru());
            pstmt.setString(14, f.getDiaChiThuongTru());
            pstmt.setString(15, f.getDiaChiThuongTruTruoc());
            pstmt.setDate(16, f.getNgayChuyen());
            pstmt.setString(17, f.getNoiChuyen());
            pstmt.setString(18, f.getGhiChu());
            pstmt.setString(19, f.getId());
            pstmt.execute();
        } catch (SQLException e) {
        	check = false;
            e.printStackTrace();
        }finally {
           try {
			jdbc.releaseResource(rs, stmt, pstmt, null, null);;
		} catch (Exception e2) {
			// TODO: handle exception
		}
        }
        return check;
    }
    
    public NhanKhau timNhanKhauId(String id) {
    	NhanKhau n = new NhanKhau();
    	try {
			String str = sql.NHAN_KHAU_THONG_TIN_NHANKHAU_ID;
			pstmt = jdbc.getConnect().prepareStatement(str);
			pstmt.setString(1, id);
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
				String qh = rs.getString("QuanHeVoiChuHo");
				String soHK = rs.getString("SoHoKhau"); 
				
				n = new NhanKhau(id_nk, hoten, gioiTinh, biDanh, ngaySinh, noiSinh, queQuan, danToc, ngheNghiep, 
						noiLamViec, CCCD, ngayCap, noiCap, ngayDKThuongTru, noiThuongTru, noiThuongTruTruoc, ngayChuyenDi,
						noiChuyen, ghiChu);
				n.setQuanHeChuHo(qh);
				n.setSoHK(soHK);
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
    	
    	return n;
    }
    
    public NhanKhau timNhanKhauCCCD(String cccd) {
    	NhanKhau n = new NhanKhau();
    	try {
			String str = sql.NHAN_KHAU_THONG_TIN_NHANKHAU_CCCD;
			pstmt = jdbc.getConnect().prepareStatement(str);
			pstmt.setString(1, cccd);
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
				String qh = rs.getString("QuanHeVoiChuHo");
				String soHK = rs.getString("SoHoKhau"); 
				
				n = new NhanKhau(id_nk, hoten, gioiTinh, biDanh, ngaySinh, noiSinh, queQuan, danToc, ngheNghiep, 
						noiLamViec, CCCD, ngayCap, noiCap, ngayDKThuongTru, noiThuongTru, noiThuongTruTruoc, ngayChuyenDi,
						noiChuyen, ghiChu);
				n.setQuanHeChuHo(qh);
				n.setSoHK(soHK);
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
    	
    	return n;
    }
    
    public ArrayList<NhanKhau> timKiem(String tkS){
    	ArrayList<NhanKhau> l = new ArrayList<>();
    	try {
    		String str = sql.NHAN_KHAU_TIMKIEM_TEN;
			pstmt = jdbc.getConnect().prepareStatement(str);
			pstmt.setString(1, "%"+tkS+"%");
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
				String qh = rs.getString("QuanHeVoiChuHo");
				String soHK = rs.getString("SoHoKhau"); 
				
				NhanKhau n = new NhanKhau(id_nk, hoten, gioiTinh, biDanh, ngaySinh, noiSinh, queQuan, danToc, ngheNghiep, 
						noiLamViec, CCCD, ngayCap, noiCap, ngayDKThuongTru, noiThuongTru, noiThuongTruTruoc, ngayChuyenDi,
						noiChuyen, ghiChu);
				n.setQuanHeChuHo(qh);
				n.setSoHK(soHK);
				l.add(n);
			}
			jdbc.releaseResource(rs, stmt, pstmt, null, null);
			
			str = sql.NHAN_KHAU_TIMKIEM_CCCD;
			pstmt = jdbc.getConnect().prepareStatement(str);
			pstmt.setString(1, "%"+tkS+"%");
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
				String qh = rs.getString("QuanHeVoiChuHo");
				String soHK = rs.getString("SoHoKhau"); 
				
				NhanKhau n = new NhanKhau(id_nk, hoten, gioiTinh, biDanh, ngaySinh, noiSinh, queQuan, danToc, ngheNghiep, 
						noiLamViec, CCCD, ngayCap, noiCap, ngayDKThuongTru, noiThuongTru, noiThuongTruTruoc, ngayChuyenDi,
						noiChuyen, ghiChu);
				n.setQuanHeChuHo(qh);
				n.setSoHK(soHK);
				l.add(n);
			}
			jdbc.releaseResource(rs, stmt, pstmt, null, null);
			
			str = sql.NHAN_KHAU_TIMKIEM_GHICHU;
			pstmt = jdbc.getConnect().prepareStatement(str);
			pstmt.setString(1, "%"+tkS+"%");
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
				String qh = rs.getString("QuanHeVoiChuHo");
				String soHK = rs.getString("SoHoKhau"); 
				
				NhanKhau n = new NhanKhau(id_nk, hoten, gioiTinh, biDanh, ngaySinh, noiSinh, queQuan, danToc, ngheNghiep, 
						noiLamViec, CCCD, ngayCap, noiCap, ngayDKThuongTru, noiThuongTru, noiThuongTruTruoc, ngayChuyenDi,
						noiChuyen, ghiChu);
				n.setQuanHeChuHo(qh);
				n.setSoHK(soHK);
				l.add(n);
			}
      }catch(Exception e) {
            e.printStackTrace();

    	  try {
    		  jdbc.releaseResource(rs, stmt, pstmt, null, null);
    	  } catch (Exception e2) {
			// TODO: handle exception
    	  }
      	}
    	return l;
    }
    
    //NH_HK
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
    //THONG KE
    public int tongNK() {
    	int a = 0;
    	try {
			String str = sql.TONGNHANKHAU;
			pstmt = jdbc.getConnect().prepareStatement(str);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				a = rs.getInt("Tong");
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
    	return a;
    }
    public int tongNam() {
    	int a = 0;
    	try {
			String str = sql.TONGNAM;
			pstmt = jdbc.getConnect().prepareStatement(str);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				a = rs.getInt("Tong");
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
    	return a;
    }
    public int tongNu() {
    	int a = 0;
    	try {
			String str = sql.TONGNU;
			pstmt = jdbc.getConnect().prepareStatement(str);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				a = rs.getInt("Tong");
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
    	return a;
    }
    public int tongKhac() {
    	int a = 0;
    	try {
			String str = sql.TONGKHAC;
			pstmt = jdbc.getConnect().prepareStatement(str);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				a = rs.getInt("Tong");
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
    	return a;
    }
    public int tongDuoiLd() {
    	int a = 0;
    	try {
			String str = sql.TONGDUOILD;
			pstmt = jdbc.getConnect().prepareStatement(str);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				a = rs.getInt("Tong");
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
    	return a;
    }
    public int tongLd() {
    	int a = 0;
    	try {
			String str = sql.TONGTRONGLD;
			pstmt = jdbc.getConnect().prepareStatement(str);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				a = rs.getInt("Tong");
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
    	return a;
    }public int tongNghiHuu() {
    	int a = 0;
    	try {
			String str = sql.TONGNGHIHUU;
			pstmt = jdbc.getConnect().prepareStatement(str);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				a = rs.getInt("Tong");
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
    	return a;
    }
    public int tongThuongTru() {
    	int a = 0;
    	try {
			String str = sql.THUONGTRU;
			pstmt = jdbc.getConnect().prepareStatement(str);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				a = rs.getInt("Tong");
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
    	return a;
    }
    public int tongTamTru() {
    	int a = 0;
    	try {
			String str = sql.TAMTRU;
			pstmt = jdbc.getConnect().prepareStatement(str);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				a = rs.getInt("Tong");
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
    	return a;
    }
    public int tongTamVang() {
    	int a = 0;
    	try {
			String str = sql.TAMVANG;
			pstmt = jdbc.getConnect().prepareStatement(str);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				a = rs.getInt("Tong");
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
    	return a;
    }
    public int tongVGC() {
    	int a = 0;
    	try {
			String str = sql.VOGIACU;
			pstmt = jdbc.getConnect().prepareStatement(str);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				a = rs.getInt("Tong");
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
    	return a;
    }
    
}