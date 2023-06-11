package controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import qL_NhanKhau.Covid_CachLy;
import qL_NhanKhau.Covid_KhaiBao;
import qL_NhanKhau.Covid_TestCovid;
import qL_NhanKhau.NhanKhau;
import sql.ConnectSQL;

public class CovidController extends CONTROLLER {
	public CovidController(ConnectSQL conn) {
		super(conn);
	}
	//KhaiBao
	public boolean themKhaiBao(Covid_KhaiBao khaiBao) {
		boolean check = true;
		String them = sql.KhaiBao_Query_INSERT_KhaiBao;
		try {
			pstmt = jdbc.getConnect().prepareStatement(them);
			pstmt.setString(1, khaiBao.getNhanKhau().getId());
			pstmt.setString(3, khaiBao.getTrieuChung());
			pstmt.setString(4, khaiBao.getTinhTrang());
            pstmt.setDate(2, khaiBao.getNgayKhaiBao());
            
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
	
	public ArrayList<Covid_KhaiBao> xem_khaibao(){
		ArrayList<Covid_KhaiBao> l = new ArrayList<>();
		try {
			String str = sql.KHAIBAO_THONGTIN;
			pstmt = jdbc.getConnect().prepareStatement(str);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NhanKhau n = new NhanKhau();
				n.setId(rs.getString("ID"));
				n.setTen(rs.getString("Ten"));
				int ma = rs.getInt("MaKhaiBao");
				Covid_KhaiBao k = new Covid_KhaiBao(n, rs.getDate("NgayKhaiBao"), rs.getString("TrieuChung"), rs.getString("TinhTrang"));
				k.setIdKhaiBao(ma);
				l.add(k);
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
	
	public ArrayList<Covid_KhaiBao> timkiemKhaiBao(String str){
		ArrayList<Covid_KhaiBao> l = new ArrayList<>();
		try {
			String s = sql.KHAIBAO_TIMKIEM_TEN;
			pstmt = jdbc.getConnect().prepareStatement(s);
			pstmt.setString(1, "%"+str+"%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NhanKhau n = new NhanKhau();
				n.setId(rs.getString("ID"));
				n.setTen(rs.getString("Ten"));
				int ma = rs.getInt("MaKhaiBao");
				Covid_KhaiBao k = new Covid_KhaiBao(n, rs.getDate("NgayKhaiBao"), rs.getString("TrieuChung"), rs.getString("TinhTrang"));
				k.setIdKhaiBao(ma);
				l.add(k);	
			}
			jdbc.releaseResource(rs, stmt, pstmt, null, null);
			
			s=sql.KHAIBAO_TIMKIEM_TRIEUCHUNG;
			pstmt = jdbc.getConnect().prepareStatement(s);
			pstmt.setString(1, "%"+str+"%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NhanKhau n = new NhanKhau();
				n.setId(rs.getString("ID"));
				n.setTen(rs.getString("Ten"));
				int ma = rs.getInt("MaKhaiBao");
				Covid_KhaiBao k = new Covid_KhaiBao(n, rs.getDate("NgayKhaiBao"), rs.getString("TrieuChung"), rs.getString("TinhTrang"));
				k.setIdKhaiBao(ma);
				l.add(k);	
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
	
	//TestCovid
	public boolean themTest(Covid_TestCovid t) {
		boolean check = true;
		String them = sql.Testcovid_Query_ThemTest;
		try {
			pstmt = jdbc.getConnect().prepareStatement(them);
			pstmt.setString(1, t.getNhanKhau().getId());
            pstmt.setDate(2, t.getNgayTest());
            pstmt.setString(3, t.getKetQua());
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
	
	public ArrayList<Covid_TestCovid> xem_test(){
		ArrayList<Covid_TestCovid> l = new ArrayList<>();
		try {
			String str = sql.Testcovid_Query_LayThongTin;
			pstmt = jdbc.getConnect().prepareStatement(str);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NhanKhau n = new NhanKhau();
				n.setId(rs.getString("ID"));
				n.setTen(rs.getString("Ten"));
				int ma = rs.getInt("MaTest");
				Covid_TestCovid k = new Covid_TestCovid(n, rs.getDate("NgayTest"), rs.getString("KetQua"));
				k.setIdTest(ma);
				l.add(k);
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
	public ArrayList<Covid_TestCovid> timkiemTest(String str){
		ArrayList<Covid_TestCovid> l = new ArrayList<>();
		try {
			String s = sql.TEST_TIMKIEM_TEN;
			pstmt = jdbc.getConnect().prepareStatement(s);
			pstmt.setString(1, "%"+str+"%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NhanKhau n = new NhanKhau();
				n.setId(rs.getString("ID"));
				n.setTen(rs.getString("Ten"));
				int ma = rs.getInt("MaTest");
				Covid_TestCovid k = new Covid_TestCovid(n, rs.getDate("NgayTest"), rs.getString("KetQua"));
				k.setIdTest(ma);
				l.add(k);
			}
			jdbc.releaseResource(rs, stmt, pstmt, null, null);
			
			s=sql.TEST_TIMKIEM_KETQUA;
			pstmt = jdbc.getConnect().prepareStatement(s);
			pstmt.setString(1, "%"+str+"%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NhanKhau n = new NhanKhau();
				n.setId(rs.getString("ID"));
				n.setTen(rs.getString("Ten"));
				int ma = rs.getInt("MaTest");
				Covid_TestCovid k = new Covid_TestCovid(n, rs.getDate("NgayTest"), rs.getString("KetQua"));
				k.setIdTest(ma);
				l.add(k);
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
	
	//CachLy
	public boolean themCachly(Covid_CachLy t) {
		boolean check = true;
		String them = sql.CachLy_Query_ThemCachLy;
		try {
			pstmt = jdbc.getConnect().prepareStatement(them);
			pstmt.setString(1, t.getNhanKhau().getId());
            pstmt.setDate(2, t.getNgayBatDau());
            pstmt.setInt(3, t.getSoNgay());
            pstmt.setString(4, t.getLoaiCachLy());
            pstmt.setString(5, t.getNoiCachLy());
            
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
	
	public ArrayList<Covid_CachLy> xem_cachly(){
		ArrayList<Covid_CachLy> l = new ArrayList<>();
		try {
			String str = sql.CachLy_Query_LayThongTin;
			pstmt = jdbc.getConnect().prepareStatement(str);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NhanKhau n = new NhanKhau();
				n.setId(rs.getString("ID"));
				n.setTen(rs.getString("Ten"));
				int ma = rs.getInt("MaCachLy");
				Covid_CachLy k = new Covid_CachLy(n, rs.getDate("NgayBatDau"), rs.getInt("SoNgay"), rs.getString("LoaiCachLy"), rs.getString("NoiCachLy"));
				k.setIdMaCachLy(ma);
				l.add(k);
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
	public ArrayList<Covid_CachLy> timkiemCachLy(String str){
		ArrayList<Covid_CachLy> l = new ArrayList<>();
		try {
			String s = sql.CACHLY_TIMKIEM_TEN;
			pstmt = jdbc.getConnect().prepareStatement(s);
			pstmt.setString(1, "%"+str+"%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NhanKhau n = new NhanKhau();
				n.setId(rs.getString("ID"));
				n.setTen(rs.getString("Ten"));
				int ma = rs.getInt("MaCachLy");
				Covid_CachLy k = new Covid_CachLy(n, rs.getDate("NgayBatDau"), rs.getInt("SoNgay"), rs.getString("LoaiCachLy"), rs.getString("NoiCachLy"));
				k.setIdMaCachLy(ma);
				l.add(k);
			}
			jdbc.releaseResource(rs, stmt, pstmt, null, null);
			
			s=sql.CACHLY_TIMKIEM_NOI;
			pstmt = jdbc.getConnect().prepareStatement(s);
			pstmt.setString(1, "%"+str+"%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NhanKhau n = new NhanKhau();
				n.setId(rs.getString("ID"));
				n.setTen(rs.getString("Ten"));
				int ma = rs.getInt("MaCachLy");
				Covid_CachLy k = new Covid_CachLy(n, rs.getDate("NgayBatDau"), rs.getInt("SoNgay"), rs.getString("LoaiCachLy"), rs.getString("NoiCachLy"));
				k.setIdMaCachLy(ma);
				l.add(k);
			}
			jdbc.releaseResource(rs, stmt, pstmt, null, null);
			
			s=sql.CACHLY_TIMKIEM_LOAI;
			pstmt = jdbc.getConnect().prepareStatement(s);
			pstmt.setString(1, "%"+str+"%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NhanKhau n = new NhanKhau();
				n.setId(rs.getString("ID"));
				n.setTen(rs.getString("Ten"));
				int ma = rs.getInt("MaCachLy");
				Covid_CachLy k = new Covid_CachLy(n, rs.getDate("NgayBatDau"), rs.getInt("SoNgay"), rs.getString("LoaiCachLy"), rs.getString("NoiCachLy"));
				k.setIdMaCachLy(ma);
				l.add(k);
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
	
	//XOA
	public boolean xoa(String loai,int ma) {
		boolean check = true;
		try {
			String str;
			if(loai.equals("KhaiBao")) str = sql.KhaiBao_Query_Delete_KhaiBao;
			else if(loai.equals("CachLy")) str = sql.CachLy_Query_Delete_CachLy;
			else str = sql.Testcovid_Query_Delete_Test;
			pstmt = jdbc.getConnect().prepareStatement(str);
			pstmt.setInt(1, ma);
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
			check=false;
		}finally {
			try {
				jdbc.releaseResource(rs, stmt, pstmt, null, null);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return check;
	}
	
}
