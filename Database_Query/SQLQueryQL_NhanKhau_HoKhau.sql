
use master
go
drop database QL_NhanKhau
go

-- Create database
CREATE DATABASE QL_NhanKhau
go
use QL_NhanKhau
go

-- Create table
create table NhanKhau(
	ID varchar(10) Primary Key,

	Ten nvarchar(100) not null,
	BiDanh nvarchar(100),

	GioiTinh nvarchar(10) not null,

	NgaySinh DateTime not null,
	NoiSinh nvarchar(100) not null,
	QueQuan nvarchar(100) not null,
	DanToc nvarchar(20) not null,

	NgheNghiep nvarchar(100),
	NoiLamViec nvarchar(100),
	
	CCCD varchar(20),
	NgayCapCCCD DateTime,
	NoiCapCCCD nvarchar(100),

	NgayDKThuongTru DateTime,
	DiaChiThuongTru nvarchar(100),
	DiaChiThuongTruTruoc nvarchar(100),
	
	-- Ap dung voi nhan khau chuyen di
	ngayChuyenDi DateTime,
	noiChuyen nvarchar(100),
	ghiChu nvarchar(100),
)
go 

create table HoKhau(
	SoHoKhau varchar(10) primary key,
	DiaChi nvarchar(100) not null
)
go 

create table NhanKhau_HoKhau(
	SoHoKhau varchar(10) not null,
	ID_NhanKhau varchar(10) primary key,
	QuanHeVoiChuHo nvarchar(20) not null,
)
go

create table KhaiSinh(
	ID_KhaiSinh numeric(18) identity(1,1) primary key,
	ID_NhanKhau varchar(10),
	ID_NguoiKhai varchar(10),
	NgayDangKy Date
)
go
create table KhaiTu(
	ID_KhaiTu numeric(18) identity(1,1) primary key,
	ID_NhanKhau varchar(10),
	ID_NguoiKhai varchar(10),
	NgayDangKy Date
)
go

create table TamTru(
	ID_TamTru numeric(18) identity(1,1) Primary Key,
	ID_NhanKhau varchar(10) not null,
	DiachiThuongTru nvarchar(100),
	DiaChiTamTru nvarchar(100),
	NgayDangKy Date
)
go
create table TamVang(
	ID_TamVang numeric(18) identity(1,1) Primary Key,
	ID_NhanKhau varchar(10) not null,
	DiaChiTamTru nvarchar(100),
	TuNgay Date,
	DenNgay Date,
	NgayDangKy Date,
	LyDo nvarchar(100)
)
go

create table ChuyenNhanKhau(
	ID_ChuyenNhanKhau numeric(18) identity(1,1) Primary Key,
	ID_NhanKhau varchar(10) not null,
	HoKhauChuyenDi varchar(10) not null,
	HoKhauChuyenDen varchar(10) not null,
	NgayDangKy Date
)
go

create table ThayDoiHoKhau(
	STT numeric(18) primary key,
	SoHoKhau varchar(10),
	NoiDungThayDoi nvarchar(200) not null,
	NgayThayDoi Date not null
)
go

create table users_ChucVu(
	ID varchar(10) Primary Key,
	Ten nvarchar(20),
	ChucVu nvarchar(20),
	DiaChiQL nvarchar(100),
	usename varchar(20),
	passwords varchar(20)
)
go

create table KhaiBao(
	MaKhaiBao numeric(18) identity(1,1) Primary Key,
	ID_NhanKhau varchar(10),
	NgayKhaiBao date,
	TrieuChung nvarchar(100),
	TinhTrang nvarchar(100),
)
go
create table TestCovid(
	MaTest numeric(18) identity(1,1)  Primary Key,
	ID_NhanKhau varchar(10),
	NgayTest date,
	KetQua nvarchar(100)
)
go
create table CachLy(
	MaCachLy numeric(18) identity(1,1)  Primary Key,
	ID_NhanKhau varchar(10),
	NgayBatDau date,
	SoNgay int,
	LoaiCachLy varchar(10), --F0, F1, F2 ...
	NoiCachLy nvarchar(100)
)
go

-- Create foreign key
-- users - users_ChucVu

-- Nhan Khau
alter table dbo.NhanKhau_HoKhau add constraint FK_NhanKhau_HoKhau_HoKhau foreign key (SoHoKhau) references dbo.HoKhau(SoHoKhau)
go
alter table dbo.NhanKhau_HoKhau add constraint FK_NhanKhau_HoKhau_NhanKhau foreign key (ID_NhanKhau) references dbo.NhanKhau(ID)
go

alter table dbo.KhaiSinh add constraint FK_KhaiSinh_NhanKhau foreign key (ID_NhanKhau) references dbo.NhanKhau(ID)
go
alter table dbo.KhaiTu add constraint FK_KhaiTu_NhanKhau foreign key (ID_NhanKhau) references dbo.NhanKhau(ID)
go

alter table dbo.TamVang add constraint FK_TamVang_NhanKhau foreign key (ID_NhanKhau) references dbo.NhanKhau(ID)
go
alter table dbo.TamTru add constraint FK_TamTru_NhanKhau foreign key (ID_NhanKhau) references dbo.NhanKhau(ID)
go

alter table dbo.ChuyenNhanKhau add constraint FK_ChuyenNhanKhau_NhanKhau foreign key (ID_NhanKhau) references dbo.NhanKhau(ID)
go
alter table dbo.ChuyenNhanKhau add constraint FK_ChuyenNhanKhau_HoKhau_Di foreign key (HoKhauChuyenDi) references dbo.HoKhau(SoHoKhau)
go
alter table dbo.ChuyenNhanKhau add constraint FK_ChuyenNhanKhau_HoKhau_Den foreign key (HoKhauChuyenDen) references dbo.HoKhau(SoHoKhau)
go

alter table dbo.ThayDoiHoKhau add constraint FK_ThayDoiHoKhau_HoKhau foreign key (SoHoKhau) references dbo.HoKhau(SoHoKhau)
go

alter table dbo.KhaiBao add constraint FK_KhaiBao_NhanKhau foreign key (ID_NhanKhau) references dbo.NhanKhau(ID)
go
alter table dbo.TestCovid add constraint FK_TestCovid_NhanKhau foreign key (ID_NhanKhau) references dbo.NhanKhau(ID)
go
alter table dbo.CachLy add constraint FK_CachLy_NhanKhau foreign key (ID_NhanKhau) references dbo.NhanKhau(ID)
go


-- select data
use QL_NhanKhau
go
---------------------
select * from NhanKhau
go
select * from HoKhau
go
select * from NhanKhau_HoKhau
go 
---------------------
select * from KhaiSinh
go
select * from KhaiTu
go
select * from TamTru
go
select * from TamVang
go
select * from ChuyenNhanKhau
go
----------------------
select * from KhaiBao
go
select * from TestCovid
go
select * from CachLy
go
----------------------
select * from users_ChucVu
go

--- Test
insert into users_ChucVu(ID, Ten, ChucVu, DiaChiQL, usename, passwords)
values('1', 'Ace','Tổ trưởng', 'Vương quốc Goa', 'a', 'a')
go

--------------------------

insert into NhanKhau(ID, Ten, BiDanh, GioiTinh, NgaySinh, NoiSinh, QueQuan, DanToc, NgheNghiep, NoiLamViec, 
	CCCD, NgayCapCCCD, NoiCapCCCD, NgayDKThuongTru, DiaChiThuongTru, DiaChiThuongTruTruoc, ngayChuyenDi, noiChuyen, ghiChu)
values('1', N'Monkey D. Dragon', N'Dragon', N'Nam', N'19671005', N'Vương quốc Goa', N'Vương quốc Goa' , N'D.', N'Thủ lĩnh Quân Cách Mạng', N'Quân Cách Mạng', 
	N'1', '19901005', N'Vương quốc Goa', '20201005', N'Đảo Okamas', N'Đảo Baltigo', null, null, null)
go

insert into NhanKhau(ID, Ten, BiDanh, GioiTinh, NgaySinh, NoiSinh, QueQuan, DanToc, NgheNghiep, NoiLamViec, 
	CCCD, NgayCapCCCD, NoiCapCCCD, NgayDKThuongTru, DiaChiThuongTru, DiaChiThuongTruTruoc, ngayChuyenDi, noiChuyen, ghiChu)
values('2', N'Sabo', N'Viêm Đế', N'Nam', N'20000320', N'Vương quốc Goa', N'Vương quốc Goa' , N'Quý tộc thế giới', N'Tổng tham mưu trưởng Quân Cách Mạng', N'Quân Cách Mạng', 
	N'2', '20200320', N'Đảo Baltigo', '20201005', N'Đảo Okamas', N'Đảo Baltigo', null, null, null)
go

insert into NhanKhau(ID, Ten, BiDanh, GioiTinh, NgaySinh, NoiSinh, QueQuan, DanToc, NgheNghiep, NoiLamViec, 
	CCCD, NgayCapCCCD, NoiCapCCCD, NgayDKThuongTru, DiaChiThuongTru, DiaChiThuongTruTruoc, ngayChuyenDi, noiChuyen, ghiChu)
values('3', N'Edward Newgate', N'Râu trắng', N'Nam', N'19460406', N'Chưa rõ', N'Chưa rõ' , N'Con người', N'Thuyền trưởng', N'Hải tặc Râu Trắng', 
	N'3', '19660406', N'Chưa rõ', '19660406', N'Biển', N'Chưa rõ', null, null, N'Đã qua đời')
go
insert into NhanKhau(ID, Ten, BiDanh, GioiTinh, NgaySinh, NoiSinh, QueQuan, DanToc, NgheNghiep, NoiLamViec, 
	CCCD, NgayCapCCCD, NoiCapCCCD, NgayDKThuongTru, DiaChiThuongTru, DiaChiThuongTruTruoc, ngayChuyenDi, noiChuyen, ghiChu)
values('4', N'Portgas D. Ace', N'Hoả Quyền', N'Nam', N'20000101', N'Vương quốc Goa', N'Vương quốc Goa' , N'D.', N'Đội trưởng đội 2', N'Hải tặc Râu Trắng', 
	N'4', '20200101', N'Vương quốc Goa', '20200101', N'Biển', N'Làng Foosha', null, null, N'Đã qua đời')
go
insert into NhanKhau(ID, Ten, BiDanh, GioiTinh, NgaySinh, NoiSinh, QueQuan, DanToc, NgheNghiep, NoiLamViec, 
	CCCD, NgayCapCCCD, NoiCapCCCD, NgayDKThuongTru, DiaChiThuongTru, DiaChiThuongTruTruoc, ngayChuyenDi, noiChuyen, ghiChu)
values('5', N'Monkey D. Luffy', N'Mũ rơm', N'Nam', N'20010505', N'Vương quốc Goa', N'Vương quốc Goa' , N'D.', N'Thuyền trưởng', N'Hải tặc Mũ Rơm', 
	N'5', '20210505', N'Vương quốc Goa', '20210505', N'Biển', N'Làng Foosha', null, null, null)
go
insert into NhanKhau(ID, Ten, BiDanh, GioiTinh, NgaySinh, NoiSinh, QueQuan, DanToc, NgheNghiep, NoiLamViec, 
	CCCD, NgayCapCCCD, NoiCapCCCD, NgayDKThuongTru, DiaChiThuongTru, DiaChiThuongTruTruoc, ngayChuyenDi, noiChuyen, ghiChu)
values('6', N'Marco', N'Phượng Hoàng', N'Nam', N'19981005', N'Chưa rõ', N'Chưa rõ' , N'Con người', N'Đội trưởng đội 1', N'Hải tặc Râu Trắng', 
	N'6', '20181005', N'Chưa rõ', '20181005', N'Biển', N'Chưa rõ', null, null, null)
go

insert into HoKhau(SoHoKhau, DiaChi)
values('1', N'Quân Cách mạng')
go

insert into HoKhau(SoHoKhau, DiaChi)
values('2', N'Hải tặc Râu Trắng')
go

insert into HoKhau(SoHoKhau, DiaChi)
values('3', N'Hải tặc Mũ Rơm')
go

insert into NhanKhau_HoKhau(SoHoKhau, ID_NhanKhau, QuanHeVoiChuHo)
values('1', '1', N'Chủ hộ')
go
insert into NhanKhau_HoKhau(SoHoKhau, ID_NhanKhau, QuanHeVoiChuHo)
values('1', '2', N'Nhận nuôi')
go
insert into NhanKhau_HoKhau(SoHoKhau, ID_NhanKhau, QuanHeVoiChuHo)
values('2', '3', N'Chủ hộ')
go
insert into NhanKhau_HoKhau(SoHoKhau, ID_NhanKhau, QuanHeVoiChuHo)
values('2', '4', N'Thuyền viên')
go
insert into NhanKhau_HoKhau(SoHoKhau, ID_NhanKhau, QuanHeVoiChuHo)
values('3', '5', N'Chủ hộ')
go
----------------------------
insert into KhaiSinh(ID_NhanKhau, ID_NguoiKhai)
values('5', '1')
go

insert into KhaiTu(ID_NhanKhau, ID_NguoiKhai)
values('', '')
go
-----------------------------
insert into TamTru(ID_NhanKhau, DiachiThuongTru, DiaChiTamTru)
values('', N'', N'')
go

insert into TamVang(ID_NhanKhau, DiaChiTamTru, TuNgay, DenNgay)
values('', N'', '', '')
go

insert into ChuyenNhanKhau(ID_NhanKhau, HoKhauChuyenDi, HoKhauChuyenDen)
values('', '', '')
go