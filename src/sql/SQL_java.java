package sql;

public class SQL_java{
	public static String USER_DANGNHAP = "select * from ACCOUNT where userName = ? and password = ?";
	
	public static String NHAN_KHAU_QUERY_LAY_THONG_TIN = "select NhanKhau.*,NhanKhau_HoKhau.* from NhanKhau left join NhanKhau_HoKhau on NhanKhau.ID=NhanKhau_HoKhau.ID_NhanKhau ";
			
	public static String NHAN_KHAU_THONG_TIN_NHANKHAU_ID = "select NhanKhau.*,NhanKhau_HoKhau.* from NhanKhau left join NhanKhau_HoKhau on NhanKhau.ID=NhanKhau_HoKhau.ID_NhanKhau where NhanKhau.ID = ?";
	
	public static String NHAN_KHAU_THONG_TIN_NHANKHAU_CCCD = "select NhanKhau.*,NhanKhau_HoKhau.* from NhanKhau left join NhanKhau_HoKhau on NhanKhau.ID=NhanKhau_HoKhau.ID_NhanKhau where NhanKhau.CCCD = ?";
	
	
	public static String NHAN_KHAU_VOGIACU = "select * from NhanKhau where ID not in (select ID_NhanKhau from NhanKhau_HoKhau) and ID not in (selsect ID_NhanKhau from KhauTu)";
	public static String NHAN_KHAU_TIMVOGIACU = "select * from NhanKhau where ID not in (select ID_NhanKhau from NhanKhau_HoKhau) and ID not in (select ID_NhanKhau from KhaiTu) and CCCD like ?";
	public static String NHAN_KHAU_DAMAT = "select * from NhanKhau where ID in (select ID_NhanKhau from KhaiTu)";
	public static String NHAN_KHAU_QUERY_INSERT_NhanKhau = "insert into NhanKhau(Ten, BiDanh, GioiTinh, NgaySinh, NoiSinh, "
			+ "QueQuan, DanToc, NgheNghiep, NoiLamViec, CCCD, NgayCapCCCD, NoiCapCCCD, NgayDKThuongTru, DiaChiThuongTru, DiaChiThuongTruTruoc, "
			+ "ngayChuyenDi, noiChuyen, ghiChu,ID) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
			
	public static String NHAN_KHAU_QUERY_UPDATE = "update NhanKhau set "
			+ "	Ten = ?,"
			+ "	BiDanh = ?,"
			+ "	GioiTinh = ?,"
			+ "	NgaySinh = ?,"
			+ "	NoiSinh = ?,"
			+ "	QueQuan = ?,"
			+ "	DanToc = ?,"
			+ "	NgheNghiep = ?,"
			+ "	NoiLamViec = ?,"
			+ "	CCCD = ?,"
			+ "	NgayCapCCCD = ?,"
			+ "	NoiCapCCCD = ?,"
			+ "	NgayDKThuongTru = ?,"
			+ "	DiaChiThuongTru = ?,"
			+ "	DiaChiThuongTruTruoc = ?,"
			+ "	NgayChuyenDi = ?,"
			+ "	NoiChuyen = ?,"
			+ "	GhiChu = ? where ID = ?" ;
			
	public static String NHAN_KHAU_DELETE_NK = "delete from NhanKhau where ID = ? ";
	
	public static String NHAN_KHAU_TIMKIEM_TEN = "select NhanKhau.*,NhanKhau_HoKhau.* from NhanKhau left join NhanKhau_HoKhau on NhanKhau.ID=NhanKhau_HoKhau.ID_NhanKhau where NhanKhau.Ten like ?";
	
	public static String NHAN_KHAU_TIMKIEM_CCCD = "select NhanKhau.*,NhanKhau_HoKhau.* from NhanKhau left join NhanKhau_HoKhau on NhanKhau.ID=NhanKhau_HoKhau.ID_NhanKhau where NhanKhau.CCCD like ?";
	
	public static String NHAN_KHAU_TIMKIEM_GHICHU = "select NhanKhau.*,NhanKhau_HoKhau.* from NhanKhau left join NhanKhau_HoKhau on NhanKhau.ID=NhanKhau_HoKhau.ID_NhanKhau where NhanKhau.GhiChu like ?";
	
	
	//Table HoKhau
	public static String HO_KHAU_QUERY_LAY_THONG_TIN = "select HoKhau.*,NhanKhau.Ten from HoKhau,NhanKhau, NhanKhau_HoKhau where NhanKhau.ID=NhanKhau_HoKhau.ID_NhanKhau and HoKhau.SoHoKhau = NhanKhau_HoKhau.SoHoKhau and NhanKhau_HoKhau.QuanHeVoiChuHo = N'Chủ hộ'";
	
	public static String HO_KHAU_QUERY_TIMKIEM_TENCHUHO = "select HoKhau.*,NhanKhau.Ten from HoKhau,NhanKhau, NhanKhau_HoKhau where NhanKhau.ID=NhanKhau_HoKhau.ID_NhanKhau and HoKhau.SoHoKhau = NhanKhau_HoKhau.SoHoKhau and NhanKhau_HoKhau.QuanHeVoiChuHo = N'Chủ hộ' and NhanKhau.Ten like ?";
	
	public static String HO_KHAU_QUERY_TIMKIEM_SOHO = "select HoKhau.*,NhanKhau.Ten from HoKhau,NhanKhau, NhanKhau_HoKhau where NhanKhau.ID=NhanKhau_HoKhau.ID_NhanKhau and HoKhau.SoHoKhau = NhanKhau_HoKhau.SoHoKhau and NhanKhau_HoKhau.QuanHeVoiChuHo = N'Chủ hộ' and HoKhau.SoHoKhau like ?";
	
	public static String HO_KHAU_QUERY_TIMKIEM_DIACHI = "select HoKhau.*,NhanKhau.Ten from HoKhau,NhanKhau, NhanKhau_HoKhau where NhanKhau.ID=NhanKhau_HoKhau.ID_NhanKhau and HoKhau.SoHoKhau = NhanKhau_HoKhau.SoHoKhau and NhanKhau_HoKhau.QuanHeVoiChuHo = N'Chủ hộ' and HoKhau.DiaChi like ?";
	
	public static String HO_KHAU_UPDATE = "update HoKhau set SoHoKhau = ?,DiaChi = ? where SoHoKhau = ?";
	
	public static String NHAN_KHAU_QUERY_INSERT_HoKhau = "insert into HoKhau(SoHoKhau, DiaChi) values(?, ?) ";
			
	public static String HO_KHAU_QUERY_THEMNHANKHAU_TO_nkhk = "insert into NhanKhau_HoKhau(ID_NhanKhau, SoHoKhau, QuanHeVoiChuHo) values (?, ?, ?)";
						
	public static String HO_KHAU_QUERY_CHECK_NHAN_KHAU_EXIST_NhanKhau = "select * from NhanKhau_HoKhau ";
			
	public static String HO_KHAU_QUERY_CHECK_NHAN_KHAU_EXIST_1_NhanKhau ="select * from NhanKhau_HoKhau where SoHoKhau = ? ";
			
	public static String HO_KHAU_QUERY_TIMHO = "select HoKhau.*,NhanKhau.Ten from HoKhau,NhanKhau, NhanKhau_HoKhau where NhanKhau.ID=NhanKhau_HoKhau.ID_NhanKhau and HoKhau.SoHoKhau = NhanKhau_HoKhau.SoHoKhau and NhanKhau_HoKhau.QuanHeVoiChuHo = N'Chủ hộ' and HoKhau.SoHoKhau = ? ";
				
	public static String HO_KHAU_QUERY_Delete_HKNK = "delete from NhanKhau_HoKhau where SoHoKhau = ? ";
			
	public static String HO_KHAU_QUERY_Delete_HK ="delete from HoKhau where SoHoKhau =? ";
			
	public static String NK_HK_XOA = "delete from NhanKhau_HoKhau where SoHoKhau=? and ID_NhanKhau=?";
	
	public static String NK_HK_XOA_HK = "delete from NhanKhau_HoKhau where SoHoKhau=?";
	
	public static String NK_HK_XOA_NK = "delete from NhanKhau_HoKhau where ID_NhanKhau=?";
	public static String NK_HK_TIM_NK = "select * from NhanKhau_HoKhau where ID_NhanKhau = ?";
	public static String NK_HK_DoiQuanHe = "update NhanKhau_HoKhau set QuanHeVoiChuHo = ? where SoHoKhau=? and ID_NhanKhau=?";
	
	public static String HO_KHAU_LIST_NHANKHAU = "select NhanKhau.*,NhanKhau_HoKhau.QuanHeVoiChuHo from NhanKhau,NhanKhau_HoKhau where NhanKhau.ID=NhanKhau_HoKhau.ID_NhanKhau and NhanKhau_HoKhau.SoHoKhau = ?";

/*
 * DichVu
 **/
	public static String DICHVU_THONGTIN = "select ks.ID_KhaiSinh as ID, nk.Ten, ks.ID_NhanKhau, ks.NgayDangKy, 'Khai sinh' as DichVu from NhanKhau nk, KhaiSinh ks where nk.ID = ks.ID_NhanKhau\r\n"
			+ "			union select kt.ID_KhaiTu as ID, nk.Ten, kt.ID_NhanKhau, kt.NgayDangKy, 'Khai tu' as DichVu from NhanKhau nk, KhaiTu kt where nk.ID = kt.ID_NhanKhau\r\n"
			+ "						union select tt.ID_TamTru as ID, nk.Ten, tt.ID_NhanKhau, tt.NgayDangKy, 'Tam tru' as DichVu from NhanKhau nk, TamTru tt where nk.ID = tt.ID_NhanKhau\r\n"
			+ "					union select tv.ID_TamVang as ID, nk.Ten, tv.ID_NhanKhau, tv.NgayDangKy, 'Tam vang' as DichVu from NhanKhau nk, TamVang tv where nk.ID = tv.ID_NhanKhau\r\n"
			+ "						union select cnk.ID_ChuyenNhanKhau as ID, nk.Ten, cnk.ID_NhanKhau, cnk.NgayDangKy, 'Chuyen nhan khau' as DichVu from NhanKhau nk, ChuyenNhanKhau cnk where nk.ID = cnk.ID_NhanKhau\r\n"
			+ "						order by NgayDangKy desc";
	
	
	
	//KhaiSinh
	public static String KHAISINH_THEM = "insert into KhaiSinh(ID_NhanKhau,ID_NguoiKhai,NgayDangKy) values(?,?,?)";
	public static String KHAISINH_XOA = "delete from KhaiSinh where ID_NhanKhau = ?";
	public static String KHAISINH_XEM = "select *from KhaiSinh where ID_KhaiSinh = ?";
	public static String KHAISINH_XOATT = "delete from KhaiSinh where ID_KhaiSinh = ?";
	
	//KhaiTu
	public static String KHAITU_THEM = "insert into KhaiTu(ID_NhanKhau,ID_NguoiKhai,NgayDangKy) values(?,?,?)";
	public static String KHAITU_XOA = "delete from KhaiTu where ID_NhanKhau = ?";
	public static String KHAITU_XEM = "select * from KhaiTu where ID_KhaiTu = ?";
	public static String KHAITU_XOATT = "delete from KhaiTu where ID_KhaiTu = ?";
	
	//Table TamTru
	public static String TAMTRU_THEM = "insert into TamTru(ID_NhanKhau, DiachiThuongTru, DiaChiTamTru,NgayDangKy) values(?, ?, ?,?) ";
	public static String TAMTRU_XOA = "delete from TamTru where ID_NhanKhau = ?";		
	public static String TAMTRU_XEM = "select * from TamTru where ID_TamTru = ?";
	public static String TAMTRU_XOATT = "delete from TamTru where ID_TamTru = ?";
	
	//Table TamVang
	public static String NHAN_KHAU_QUERY_INSERT_TamVang = "insert into TamVang(ID_NhanKhau, DiaChiTamTru, TuNgay, DenNgay,Lydo,NgayDangKy) values(?, ?,?, ?, ?,?) ";
	public static String TAMVANG_XOA = "delete from TamVang where ID_NhanKhau = ?";		
	public static String TAMVANG_XEM = "select * from TamVang where ID_TamVang = ?";
	public static String TAMVANG_XOATT = "delete from TamVang where ID_TamVang = ?";
	
	//Table ChuyenNhanKhau
	public static String NHAN_KHAU_QUERY_INSERT_ChuyenNhanKhau = "insert into ChuyenNhanKhau(ID_NhanKhau, HoKhauChuyenDi, HoKhauChuyenDen,NgayDangKy) values(?, ?, ?,?) ";
	public static String CHUYENKHAU_XOA = "delete from ChuyenNhanKhau where ID_NhanKhau = ?";
	public static String CHUYENKHAU_XEM = "select * from ChuyenNhanKhau where ID_ChuyenNhanKhau = ?";
	public static String CHUYENKHAU_XOATT = "delete from ChuyenNhanKhau where ID_ChuyenNhanKhau = ?";
	
	//Table KhaiBao
	public static String KHAIBAO_THONGTIN ="select kb.*, nk.* from Khaibao kb inner join NhanKhau nk on kb.ID_NhanKhau = nk.ID";
	public static String KHAIBAO_XOA = "delete from Khaibao where ID_NhanKhau = ?";
		
	public static String KhaiBao_Query_INSERT_KhaiBao ="insert into KhaiBao(ID_NhanKhau, NgayKhaiBao, TrieuChung, TinhTrang) values(?, ?, ?, ?)";
	
	public static String KhaiBao_Query_Delete_KhaiBao ="Delete from KhaiBao where MaKhaiBao = ?";
	
	public static String KhaiBao_Query_Tong_Khai_Bao ="select count(*) from KhaiBao";
	
	public static String KhaiBao_Query_Tong_Theo_Thang ="select count(*) from KhaiBao where Month(NgayKhaiBao) = ?";
	
	public static String KHAIBAO_TIMKIEM_TEN = "select kb.*, nk.* from Khaibao kb inner join NhanKhau nk on kb.ID_NhanKhau = nk.ID where nk.Ten like ?";
	
	public static String KHAIBAO_TIMKIEM_TRIEUCHUNG = "select kb.*, nk.* from Khaibao kb inner join NhanKhau nk on kb.ID_NhanKhau = nk.ID where kb.TrieuChung like ?";
	
	public static String KHAIBAO_TIMKIEM_IDNK = "select kb.*, nk.* from Khaibao kb inner join NhanKhau nk on kb.ID_NhanKhau = nk.ID where nk.ID like ?";
	
	
	//Table TestCovid
	public static String Testcovid_Query_LayThongTin = "select test.*, nk.* from TestCovid test inner join NhanKhau nk on nk.ID = test.ID_NhanKhau";
	public static String TEST_XOA = "delete from TestCovid where ID_NhanKhau = ?";
	
	public static String Testcovid_Query_ThemTest = "insert into TestCovid(ID_NhanKhau, NgayTest, KetQua) values(?, ?, ?) ";
	
	public static String Testcovid_Query_Delete_Test = "delete from TestCovid where MaTest = ?";
	
	public static String Testcovid_Query_Tong_Test = "select count(*) from TestCovid";
	
	public static String Testcovid_Query_Tong_DuongTinh = "select count(*) from TestCovid where KetQua = N'Duong Tinh' ";
	
	public static String Testcovid_Query_Tong_Theo_Thang = "select count(*) from TestCovid where Month(NgayTest) = ? ";
	
	public static String TEST_TIMKIEM_TEN = "select test.*, nk.* from TestCovid test inner join NhanKhau nk on nk.ID = test.ID_NhanKhau where nk.Ten like ?";

	public static String TEST_TIMKIEM_IDNK = "select test.*, nk.* from TestCovid test inner join NhanKhau nk on nk.ID = test.ID_NhanKhau where nk.ID like ?";

	public static String TEST_TIMKIEM_KETQUA = "select test.*, nk.* from TestCovid test inner join NhanKhau nk on nk.ID = test.ID_NhanKhau where test.KetQua like ?";
	
	//Table CachLy
	public static String CachLy_Query_LayThongTin = "select cl.*, nk.* from CachLy cl inner join NhanKhau nk on nk.ID = cl.ID_NhanKhau";
	public static String CACHLY_XOA = "delete from CachLy where ID_NhanKhau = ?";
	public static String CachLy_Query_ThemCachLy = "insert into CachLy(ID_NhanKhau, NgayBatDau, SoNgay, LoaiCachLy, NoiCachLy) values(?, ?, ?, ?, ?) ";
	
	public static String CachLy_Query_Delete_CachLy = "delete from CachLy where MaCachLy = ?";
	
	public static String CachLy_Query_Tong_CachLy = "select count(*) from CachLy ";
	
	public static String CachLy_Query_Tong_Theo_Thang = "select count(*) from CachLy where Month(NgayBatDau) = ?";
	
	public static String CACHLY_TIMKIEM_IDNK = "select cl.*, nk.* from CachLy cl inner join NhanKhau nk on nk.ID = cl.ID_NhanKhau where nk.ID like ?"; 

	public static String CACHLY_TIMKIEM_TEN = "select cl.*, nk.* from CachLy cl inner join NhanKhau nk on nk.ID = cl.ID_NhanKhau where nk.Ten like ?";

	public static String CACHLY_TIMKIEM_LOAI = "select cl.*, nk.* from CachLy cl inner join NhanKhau nk on nk.ID = cl.ID_NhanKhau where cl.LoaiCachLy like ?";

	public static String CACHLY_TIMKIEM_NOI = "select cl.*, nk.* from CachLy cl inner join NhanKhau nk on nk.ID = cl.ID_NhanKhau where cl.NoiCachLy like ?";
	
	//THONG KE
	public static String TONGNHANKHAU = "select count(*) as Tong from NhanKhau where ID not in (select ID_NhanKhau from KhaiTu)";
	
	public static String TONGNAM = "select count(*) as Tong from NhanKhau where GioiTinh = 'Nam' and ID not in (select ID_NhanKhau from KhaiTu)";
	
	public static String TONGNU = "select count(*) as Tong from NhanKhau where GioiTinh =  N'Nữ' and ID not in (select ID_NhanKhau from KhaiTu)";
	
	public static String TONGKHAC = "select count(*) as Tong from NhanKhau where GioiTinh = N'Khác' and ID not in (select ID_NhanKhau from KhaiTu)";
	
	public static String TONGDUOILD = "SELECT COUNT(*) as Tong FROM NhanKhau WHERE FLOOR(DATEDIFF(Day, NgaySinh, GETDATE()) / 365.25) < 18 and ID not in (select ID_NhanKhau from KhaiTu)";
	
	public static String TONGTRONGLD ="SELECT COUNT(*) as Tong FROM NhanKhau WHERE FLOOR(DATEDIFF(Day, NgaySinh, GETDATE()) / 365.25) >= 18 and FLOOR(DATEDIFF(Day, NgaySinh, GETDATE()) / 365.25) <=60 and ID not in (select ID_NhanKhau from KhaiTu)";
	
	public static String TONGNGHIHUU = "SELECT COUNT(*) as Tong FROM NhanKhau WHERE FLOOR(DATEDIFF(Day, NgaySinh, GETDATE()) / 365.25) >60 and ID not in (select ID_NhanKhau from KhaiTu)";
	
	public static String THUONGTRU = "select count(*) as Tong from NhanKhau nk left join TamVang tv ON nk.ID = tv.ID_NhanKhau left join KhaiTu kt ON nk.ID = kt.ID_NhanKhau WHERE (nk.NgayDKThuongTru > tv.NgayDangKy or tv.ID_NhanKhau is null) and kt.ID_NhanKhau is null";
	public static String TAMTRU = "select count(*) as Tong from NhanKhau nk inner join TamTru tt on nk.ID = tt.ID_NhanKhau where nk.NgayDKThuongTru < tt.NgayDangKy";
	public static String TAMVANG = "select count(*) as Tong from NhanKhau nk inner join TamVang tv on nk.ID = tv.ID_NhanKhau where nk.NgayDKThuongTru < tv.NgayDangKy";
	
	public static String VOGIACU = "select count(*) as Tong from NhanKhau where ID not in (select ID_NhanKhau from NhanKhau_HoKhau) and ID not in (select ID_NhanKhau from KhaiTu)";
	
	
}
