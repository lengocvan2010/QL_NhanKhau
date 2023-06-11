package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import qL_NhanKhau.NhanKhau;
import sql.*;

public class CONTROLLER {
	ConnectSQL jdbc; 
	ResultSet rs;
	PreparedStatement pstmt;
	Statement stmt;
	SQL_java sql;
	
	public CONTROLLER(ConnectSQL c) {
		jdbc = c;
		sql = new SQL_java();
	}
	
	public boolean xoaDichVuNhanKhau(NhanKhau n) {
		boolean check = true;
		try {
			String str = sql.KHAISINH_XOA;
			pstmt = jdbc.getConnect().prepareStatement(str);
			pstmt.setString(1, n.getId());
			pstmt.execute();
			jdbc.releaseResource(rs, stmt, pstmt, null, null);
			
			str = sql.KHAITU_XOA;
			pstmt = jdbc.getConnect().prepareStatement(str);
			pstmt.setString(1, n.getId());
			pstmt.execute();
			jdbc.releaseResource(rs, stmt, pstmt, null, null);
			
			str = sql.TAMTRU_XOA;
			pstmt = jdbc.getConnect().prepareStatement(str);
			pstmt.setString(1, n.getId());
			pstmt.execute();
			jdbc.releaseResource(rs, stmt, pstmt, null, null);
			
			str = sql.TAMVANG_XOA;
			pstmt = jdbc.getConnect().prepareStatement(str);
			pstmt.setString(1, n.getId());
			pstmt.execute();
			jdbc.releaseResource(rs, stmt, pstmt, null, null);
			
			str = sql.CHUYENKHAU_XOA;
			pstmt = jdbc.getConnect().prepareStatement(str);
			pstmt.setString(1, n.getId());
			pstmt.execute();
			jdbc.releaseResource(rs, stmt, pstmt, null, null);
			
			str = sql.KHAIBAO_XOA;
			pstmt = jdbc.getConnect().prepareStatement(str);
			pstmt.setString(1, n.getId());
			pstmt.execute();
			jdbc.releaseResource(rs, stmt, pstmt, null, null);
			
			str = sql.TEST_XOA;
			pstmt = jdbc.getConnect().prepareStatement(str);
			pstmt.setString(1, n.getId());
			pstmt.execute();
			jdbc.releaseResource(rs, stmt, pstmt, null, null);
			
			str = sql.CACHLY_XOA;
			pstmt = jdbc.getConnect().prepareStatement(str);
			pstmt.setString(1, n.getId());
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
	
	public boolean xoaNhanKhau(NhanKhau n) {
		boolean check = true;
    	String xoa = sql.NHAN_KHAU_DELETE_NK;
    	try {
			pstmt = jdbc.getConnect().prepareStatement(xoa);
			pstmt.setString(1,n.getId());
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
	public boolean xoaNKHK(NhanKhau n) {
    	boolean check = true;
    	try {
			String str = sql.NK_HK_XOA_NK;
			pstmt = jdbc.getConnect().prepareStatement(str);
			pstmt.setString(1, n.getId());
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
 
}
