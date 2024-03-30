/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
import DomainModels.HoaDonNhap;
import DomainModels.HoaDonNhapChiTiet;

import DomainModels.SanPham;
import Ultilities.DBConnection;
import ViewModels.NhatKyHoatDong_HoaDonNhapView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Duc Toan
 */
public class NhatKyHoatDongRepo {

//    public List<HoaDonNhap> getHoaDonNhap() {
//        List<HoaDonNhap> lstHoaDonNhap = new ArrayList<>();
//        String sql = "select IdHoaDon,IdNhanVienKho,TenHoaDon,NhaCungUng,TongTien,NgayThem,GhiChu,TrangThai from HoaDonNhap where TrangThai=1 or TrangThai=0 or TrangThai=5 order by ngaythem desc";
//        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                HoaDonNhap hoaDonNhap = new HoaDonNhap();
//                hoaDonNhap.setIdHoaDon(rs.getString("IdHoaDon"));
//                hoaDonNhap.setIdNhanVienKho(rs.getString("IdNhanVienKho"));
//                hoaDonNhap.setTenHoaDon(rs.getString("TenHoaDon"));
//                hoaDonNhap.setNhaCungUng(rs.getString("NhaCungUng"));
//                hoaDonNhap.setTongTien(rs.getBigDecimal("TongTien"));
//                hoaDonNhap.setNgayThem(rs.getString("NgayThem"));
//                hoaDonNhap.setGhiChu(rs.getString("GhiChu"));
//                hoaDonNhap.setTrangThai(rs.getInt("TrangThai"));
//                lstHoaDonNhap.add(hoaDonNhap);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return lstHoaDonNhap;
//    }
//    public List<HoaDonNhap> getHoaDonXuat() {
//        List<HoaDonNhap> lstHoaDonNhap = new ArrayList<>();
//        String sql = "select idHoaDon,IdNhanVienKho,IdNhanVienCuaHang,TenHoaDon,TongTien,NgayThem,GhiChu,TrangThai from HoaDonNhap where  TrangThai=-1 or TrangThai=2  or TrangThai=3 or TrangThai=4 or TrangThai=6 order by ngaythem desc";
//        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                HoaDonNhap hoaDonNhap = new HoaDonNhap();
//                hoaDonNhap.setIdHoaDon(rs.getString("idHoaDon"));
//                hoaDonNhap.setIdNhanVienKho(rs.getString("IdNhanVienKho"));
//                hoaDonNhap.setIdNhanVienCuaHang(rs.getString("IdNhanVienCuaHang"));
//                hoaDonNhap.setTenHoaDon(rs.getString("TenHoaDon"));
//                hoaDonNhap.setTongTien(rs.getBigDecimal("TongTien"));
//                hoaDonNhap.setNgayThem(rs.getString("NgayThem"));
//                hoaDonNhap.setGhiChu(rs.getString("GhiChu"));
//                hoaDonNhap.setTrangThai(rs.getInt("TrangThai"));
//                lstHoaDonNhap.add(hoaDonNhap);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return lstHoaDonNhap;
//    }

    public int getDungTich(String idSanPham) {
        String sql = "select KichThuoc from SanPham where IDSanPham=?";
        int dungTich = 0;
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, idSanPham);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dungTich = rs.getInt("KichThuoc");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dungTich;
    }

    public String getEmailById(String idTaiKhoan) {
        String sql = "SELECT email from taiKhoan WHERE idTaiKhoan = ?";
        String email = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, idTaiKhoan);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                email = rs.getString("email");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return email;
    }

    public String getSdtKhachHang(String idKhacHang) {
        String sql = "select SoDienThoai from KhachHang\n"
                + "where IDKhachHang=?";
        String sdt = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, idKhacHang);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sdt = rs.getString("SoDienThoai");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sdt;
    }

    public String getIdTaiKhoanByEmail(String email) {
        String sql = "SELECT IdTaiKhoan from taiKhoan WHERE email = ?";
        String IdTaiKhoan = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                IdTaiKhoan = rs.getString("IdTaiKhoan");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return IdTaiKhoan;
    }

    public List<String> getEmail() {
        List<String> lstEmail = new ArrayList<>();
        String sql = "SELECT email from taiKhoan where idLoaiNguoiDung in (SELECT IDLoaiNguoiDung FROM LoaiNguoiDung WHERE Ten = N'Nhân viên') and trangThai=1";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lstEmail.add(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstEmail;
    }

    public List<String> getEmailNhanVienKho() {
        List<String> lstEmail = new ArrayList<>();
        String sql = "SELECT email from taiKhoan where idLoaiNguoiDung in (SELECT IDLoaiNguoiDung FROM LoaiNguoiDung WHERE Ten = N'Nhân viên kho') and trangThai=1";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lstEmail.add(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstEmail;
    }

    public String getTenSp(String idSp) {
        String sql = "SELECT TenSanPham from sanpham WHERE idSanPham = ?";
        String tenSp = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, idSp);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tenSp = rs.getString("tensanpham");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tenSp;
    }

    public String getIdSp(String tenSp) {
        String sql = "SELECT idSanPham from sanpham WHERE tenSanPham = ?";
        String idSp = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, tenSp);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                idSp = rs.getString("idSanPham");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idSp;
    }

    public List<String> getTenSpForCbo() {
        String sql = "SELECT TenSanPham from sanpham ";
        List<String> lstTenSp = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lstTenSp.add(rs.getString("tenSanPham"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstTenSp;
    }

//    public List<HoaDon> getHoaDon() {
//        List<HoaDon> lstHoaDon = new ArrayList<>();
//
//        String sql = "select IdTaiKhoan,IdHoaDon,ghiChu,NgayThem,IdHoaDon,TenHoaDon,TrangThai,TongTien,IdKhachHang from HoaDon order by ngaythem desc";
//        try (Connection conn = DBConnection.getConnection()) {
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                HoaDon HoaDon = new HoaDon();
//                HoaDon.setIdTaiKhoan(rs.getString("IdTaiKhoan"));
//                HoaDon.setIdHoaDon(rs.getString("IdHoaDon"));
//                HoaDon.setGhiChu(rs.getString("ghiChu"));
//                HoaDon.setNgayThem(rs.getString("NgayThem"));
//                HoaDon.setIdHoaDon(rs.getString("IdHoaDon"));
//                HoaDon.setTenHoaDon(rs.getString("TenHoaDon"));
//                HoaDon.setTinhTrang(rs.getInt("TrangThai"));
//                HoaDon.setTongTien(rs.getBigDecimal("TongTien"));
//                HoaDon.setIdKhachHang(rs.getString("IdKhachHang"));
//                lstHoaDon.add(HoaDon);
//            }
//
//            return lstHoaDon;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
    public List<HoaDon> getHoaDonById(String idHoaDon) {
        List<HoaDon> lstHoaDon = new ArrayList<>();

        String sql = "select IdTaiKhoan,IdHoaDon,ghiChu,NgayThem,IdHoaDon,TenHoaDon,TrangThai,TongTien,IdKhachHang from hoadon where IDHoaDon=?";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, idHoaDon);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon HoaDon = new HoaDon();
                HoaDon.setIdTaiKhoan(rs.getString("IdTaiKhoan"));
                HoaDon.setIdHoaDon(rs.getString("IdHoaDon"));
                HoaDon.setGhiChu(rs.getString("ghiChu"));
                HoaDon.setNgayThem(rs.getString("NgayThem"));
                HoaDon.setIdHoaDon(rs.getString("IdHoaDon"));
                HoaDon.setTenHoaDon(rs.getString("TenHoaDon"));
                HoaDon.setTinhTrang(rs.getInt("TrangThai"));
                HoaDon.setTongTien(rs.getBigDecimal("TongTien"));
                HoaDon.setIdKhachHang(rs.getString("IdKhachHang"));
                lstHoaDon.add(HoaDon);
            }

            return lstHoaDon;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<HoaDon> findHoaDon(String idTaiKhoan, String trangThai, String ngayBatDau, String ngayKetThuc, int start, int end) {
        String sql = "SELECT * FROM ( \n"
                + "SELECT  * , ROW_NUMBER() OVER (ORDER BY ngaythem desc) as row  FROM HoaDon \n"
                + "\n"
                + ") a WHERE ((row >= ? and row <= ?) ) ";
        String p1 = "SELECT * FROM ( \n"
                + "SELECT  * , ROW_NUMBER() OVER (ORDER BY ngaythem desc) as row  FROM HoaDon ";
        String p2 = " ) a WHERE ((row >= ? and row <= ?) ) ";
        List<String> lstColumnName = new ArrayList<>();
        lstColumnName.add("idTaiKhoan");
        lstColumnName.add("trangThai");
        lstColumnName.add("ngayThem");
        lstColumnName.add("ngayThem");
        List<String> lstInputId = new ArrayList<>();
        lstInputId.add(idTaiKhoan);
        lstInputId.add(trangThai);
        lstInputId.add(ngayBatDau);
        lstInputId.add(ngayKetThuc);
        List<String> lstInputIdNotEmpty = new ArrayList<>();
        List<Integer> lstIndex = new ArrayList<>();
        for (int i = 0; i < lstInputId.size(); i++) {
            if (lstInputId.get(i).isEmpty() == false) {
                lstInputIdNotEmpty.add(lstInputId.get(i));
                lstIndex.add(i);
            }
        }
        if (lstInputIdNotEmpty.size() == 1) {
            sql = p1 + " where "
                    + lstColumnName.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                    + p2;
        } else if (lstInputIdNotEmpty.size() == 2) {
            if (lstInputId.get(2).isEmpty() == false && lstInputId.get(3).isEmpty() == false) {

                sql = p1 + " where "
                        + lstColumnName.get(lstIndex.get(0)) + ">=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                        + " and " + lstColumnName.get(lstIndex.get(1)) + "<=" + "'" + lstInputIdNotEmpty.get(1) + "'"
                        + p2;
            } else {
                sql = p1 + " where "
                        + lstColumnName.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                        + " and " + lstColumnName.get(lstIndex.get(1)) + "=" + "'" + lstInputIdNotEmpty.get(1) + "'"
                        + p2;
            }

        } else if (lstInputIdNotEmpty.size() == 3) {
            sql = p1 + " where "
                    + lstColumnName.get(lstIndex.get(1)) + ">=" + "'" + lstInputIdNotEmpty.get(1) + "'"
                    + " and " + lstColumnName.get(lstIndex.get(2)) + "<=" + "'" + lstInputIdNotEmpty.get(2) + "'"
                    + " and " + lstColumnName.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                    + p2;

        } else if (lstInputIdNotEmpty.size() == 4) {
            sql = p1 + " where "
                    + lstColumnName.get(lstIndex.get(2)) + ">=" + "'" + lstInputIdNotEmpty.get(2) + "'"
                    + " and " + lstColumnName.get(lstIndex.get(3)) + "<=" + "'" + lstInputIdNotEmpty.get(3) + "'"
                    + " and " + lstColumnName.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                    + " and " + lstColumnName.get(lstIndex.get(1)) + "=" + "'" + lstInputIdNotEmpty.get(1) + "'"
                    + p2;

        }
        System.out.println(sql);
        List<HoaDon> lstHoaDon = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, start);
            ps.setObject(2, end);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon HoaDon = new HoaDon();
                HoaDon.setIdTaiKhoan(rs.getString("IdTaiKhoan"));
                HoaDon.setIdHoaDon(rs.getString("IdHoaDon"));
                HoaDon.setGhiChu(rs.getString("ghiChu"));
                HoaDon.setNgayThem(rs.getString("NgayThem"));
                HoaDon.setIdHoaDon(rs.getString("IdHoaDon"));
                HoaDon.setTenHoaDon(rs.getString("TenHoaDon"));
                HoaDon.setTinhTrang(rs.getInt("TrangThai"));
                HoaDon.setTongTien(rs.getBigDecimal("TongTien"));
                lstHoaDon.add(HoaDon);
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstHoaDon;
    }

    public int getSoDongHD(String idTaiKhoan, String trangThai, String ngayBatDau, String ngayKetThuc) {
        String sql = "select count(IDHoaDon) as soDong from HoaDon ";

        List<String> lstColumnName = new ArrayList<>();
        lstColumnName.add("idTaiKhoan");
        lstColumnName.add("trangThai");
        lstColumnName.add("ngayThem");
        lstColumnName.add("ngayThem");
        List<String> lstInputId = new ArrayList<>();
        lstInputId.add(idTaiKhoan);
        lstInputId.add(trangThai);
        lstInputId.add(ngayBatDau);
        lstInputId.add(ngayKetThuc);
        List<String> lstInputIdNotEmpty = new ArrayList<>();
        List<Integer> lstIndex = new ArrayList<>();
        for (int i = 0; i < lstInputId.size(); i++) {
            if (lstInputId.get(i).isEmpty() == false) {
                lstInputIdNotEmpty.add(lstInputId.get(i));
                lstIndex.add(i);
            }
        }
        if (lstInputIdNotEmpty.size() == 1) {
            sql = sql + " where "
                    + lstColumnName.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'";

        } else if (lstInputIdNotEmpty.size() == 2) {
            if (lstInputId.get(2).isEmpty() == false && lstInputId.get(3).isEmpty() == false) {

                sql = sql + " where "
                        + lstColumnName.get(lstIndex.get(0)) + ">=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                        + " and " + lstColumnName.get(lstIndex.get(1)) + "<=" + "'" + lstInputIdNotEmpty.get(1) + "'";

            } else {
                sql = sql + " where "
                        + lstColumnName.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                        + " and " + lstColumnName.get(lstIndex.get(1)) + "=" + "'" + lstInputIdNotEmpty.get(1) + "'";

            }

        } else if (lstInputIdNotEmpty.size() == 3) {
            sql = sql + " where "
                    + lstColumnName.get(lstIndex.get(1)) + ">=" + "'" + lstInputIdNotEmpty.get(1) + "'"
                    + " and " + lstColumnName.get(lstIndex.get(2)) + "<=" + "'" + lstInputIdNotEmpty.get(2) + "'"
                    + " and " + lstColumnName.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'";

        } else if (lstInputIdNotEmpty.size() == 4) {
            sql = sql + " where "
                    + lstColumnName.get(lstIndex.get(2)) + ">=" + "'" + lstInputIdNotEmpty.get(2) + "'"
                    + " and " + lstColumnName.get(lstIndex.get(3)) + "<=" + "'" + lstInputIdNotEmpty.get(3) + "'"
                    + " and " + lstColumnName.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                    + " and " + lstColumnName.get(lstIndex.get(1)) + "=" + "'" + lstInputIdNotEmpty.get(1) + "'";

        }

        int soDong = 0;
        try (Connection conn = DBConnection.getConnection();) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                soDong = rs.getInt("soDong");
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return soDong;
    }

    public List<HoaDonNhap> findHoaDonNhap(String idTaiKhoan, String trangThai, String ngayBatDau, String ngayKetThuc, int start, int end) {
        String sql = "SELECT * FROM ( \n"
                + "SELECT  * , ROW_NUMBER() OVER (ORDER BY ngaythem desc) as row  FROM HoaDonNhap where (TrangThai=1 or TrangThai=0 or TrangThai=5)\n"
                + ") a WHERE ((row >= ? and row <= ?) ) ";
        String sql2 = "SELECT * FROM ( \n"
                + "SELECT  * , ROW_NUMBER() OVER (ORDER BY ngaythem desc) as row  FROM HoaDonNhap \n"
                + ") a WHERE ((row >= ? and row <= ?) ) ";
        String p1Sql = "SELECT * FROM ( \n"
                + "SELECT  * , ROW_NUMBER() OVER (ORDER BY ngaythem desc) as row  FROM HoaDonNhap where (TrangThai=1 or TrangThai=0 or TrangThai=5) ";
        String p1Sql2 = "SELECT * FROM ( \n"
                + "SELECT  * , ROW_NUMBER() OVER (ORDER BY ngaythem desc) as row  FROM HoaDonNhap  ";
        String p2 =") a WHERE ((row >= ? and row <= ?) )  ";
        List<String> lstColumnName = new ArrayList<>();
        lstColumnName.add("idNhanVienKho");
        lstColumnName.add("trangThai");
        lstColumnName.add("ngayThem");
        lstColumnName.add("ngayThem");
        List<String> lstInputId = new ArrayList<>();
        lstInputId.add(idTaiKhoan);
        lstInputId.add(trangThai);
        lstInputId.add(ngayBatDau);
        lstInputId.add(ngayKetThuc);
        List<String> lstInputIdNotEmpty = new ArrayList<>();
        List<Integer> lstIndex = new ArrayList<>();
        for (int i = 0; i < lstInputId.size(); i++) {
            if (lstInputId.get(i).isEmpty() == false) {
                lstInputIdNotEmpty.add(lstInputId.get(i));
                lstIndex.add(i);
            }
        }
        if (lstInputIdNotEmpty.size() == 1) {
            if (lstInputId.get(1).equalsIgnoreCase("")) {
                sql = p1Sql + " and "
                        + lstColumnName.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                        + p2;
            } else {
                sql = p1Sql2 + " where "
                        + lstColumnName.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                        + p2;
            }
        } else if (lstInputIdNotEmpty.size() == 2) {
            if (lstInputId.get(2).isEmpty() && lstInputId.get(3).isEmpty()) {
                sql = p1Sql2 + " where "
                        + lstColumnName.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                        + " and " + lstColumnName.get(lstIndex.get(1)) + "=" + "'" + lstInputIdNotEmpty.get(1) + "'"
                        + p2;
            } else {
                sql = p1Sql + " and "
                        + lstColumnName.get(lstIndex.get(0)) + ">=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                        + " and " + lstColumnName.get(lstIndex.get(1)) + "<=" + "'" + lstInputIdNotEmpty.get(1) + "'"
                        + p2;
            }

        } else if (lstInputIdNotEmpty.size() == 3) {
            if (lstInputId.get(1).equalsIgnoreCase("")) {
                sql = p1Sql + " and "
                        + lstColumnName.get(lstIndex.get(1)) + ">=" + "'" + lstInputIdNotEmpty.get(1) + "'"
                        + " and " + lstColumnName.get(lstIndex.get(2)) + "<=" + "'" + lstInputIdNotEmpty.get(2) + "'"
                        + " and " + lstColumnName.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                        + p2;
            } else {
                sql = p1Sql2 + " where "
                        + lstColumnName.get(lstIndex.get(1)) + ">=" + "'" + lstInputIdNotEmpty.get(1) + "'"
                        + " and " + lstColumnName.get(lstIndex.get(2)) + "<=" + "'" + lstInputIdNotEmpty.get(2) + "'"
                        + " and " + lstColumnName.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                        + p2;
            }

        } else if (lstInputIdNotEmpty.size() == 4) {
            sql = p1Sql2 + " where "
                    + lstColumnName.get(lstIndex.get(2)) + ">=" + "'" + lstInputIdNotEmpty.get(2) + "'"
                    + " and " + lstColumnName.get(lstIndex.get(3)) + "<=" + "'" + lstInputIdNotEmpty.get(3) + "'"
                    + " and " + lstColumnName.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                    + " and " + lstColumnName.get(lstIndex.get(1)) + "=" + "'" + lstInputIdNotEmpty.get(1) + "'"
                    + p2;

        }

        List<HoaDonNhap> lstHoaDon = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, start);
            ps.setObject(2, end);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonNhap hoaDonNhap = new HoaDonNhap();
                hoaDonNhap.setIdHoaDon(rs.getString("idHoaDon"));
                hoaDonNhap.setIdNhanVienKho(rs.getString("IdNhanVienKho"));
                hoaDonNhap.setTenHoaDon(rs.getString("TenHoaDon"));
                hoaDonNhap.setNhaCungUng(rs.getString("NhaCungUng"));
                hoaDonNhap.setTongTien(rs.getBigDecimal("TongTien"));
                hoaDonNhap.setNgayThem(rs.getString("NgayThem"));
                hoaDonNhap.setGhiChu(rs.getString("GhiChu"));
                hoaDonNhap.setTrangThai(rs.getInt("TrangThai"));
                lstHoaDon.add(hoaDonNhap);
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstHoaDon;
    }
    
    public int getSoDongNhap(String idTaiKhoan, String trangThai, String ngayBatDau, String ngayKetThuc) {
        String sql = "select count(IdHoaDon) as soDong from HoaDonNhap where (TrangThai=1 or TrangThai=0 or TrangThai=5)";
        String sql2 = "select count(IdHoaDon) as soDong from HoaDonNhap";
        List<String> lstColumnName = new ArrayList<>();
        lstColumnName.add("idNhanVienKho");
        lstColumnName.add("trangThai");
        lstColumnName.add("ngayThem");
        lstColumnName.add("ngayThem");
        List<String> lstInputId = new ArrayList<>();
        lstInputId.add(idTaiKhoan);
        lstInputId.add(trangThai);
        lstInputId.add(ngayBatDau);
        lstInputId.add(ngayKetThuc);
        List<String> lstInputIdNotEmpty = new ArrayList<>();
        List<Integer> lstIndex = new ArrayList<>();
        for (int i = 0; i < lstInputId.size(); i++) {
            if (lstInputId.get(i).isEmpty() == false) {
                lstInputIdNotEmpty.add(lstInputId.get(i));
                lstIndex.add(i);
            }
        }
        if (lstInputIdNotEmpty.size() == 1) {
            if (lstInputId.get(1).equalsIgnoreCase("")) {
                sql =sql+ " and "
                        + lstColumnName.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'";
               
            } else {
                sql = sql2+ " where "
                        + lstColumnName.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'";
                  
            }
        } else if (lstInputIdNotEmpty.size() == 2) {
            if (lstInputId.get(2).isEmpty() && lstInputId.get(3).isEmpty()) {
                sql = sql2+ " where "
                        + lstColumnName.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                        + " and " + lstColumnName.get(lstIndex.get(1)) + "=" + "'" + lstInputIdNotEmpty.get(1) + "'";
                   
            } else {
                sql = sql+ " and "
                        + lstColumnName.get(lstIndex.get(0)) + ">=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                        + " and " + lstColumnName.get(lstIndex.get(1)) + "<=" + "'" + lstInputIdNotEmpty.get(1) + "'";
                    
            }

        }else if (lstInputIdNotEmpty.size() == 3) {
            if (lstInputId.get(1).equalsIgnoreCase("")) {
                sql = sql+ " and "
                        + lstColumnName.get(lstIndex.get(1)) + ">=" + "'" + lstInputIdNotEmpty.get(1) + "'"
                        + " and " + lstColumnName.get(lstIndex.get(2)) + "<=" + "'" + lstInputIdNotEmpty.get(2) + "'"
                        + " and " + lstColumnName.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'";
              
            } else {
                sql = sql2+ " where "
                        + lstColumnName.get(lstIndex.get(1)) + ">=" + "'" + lstInputIdNotEmpty.get(1) + "'"
                        + " and " + lstColumnName.get(lstIndex.get(2)) + "<=" + "'" + lstInputIdNotEmpty.get(2) + "'"
                        + " and " + lstColumnName.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'";
                
            }

        } else if (lstInputIdNotEmpty.size() == 4) {
            sql = sql2+ " where "
                    + lstColumnName.get(lstIndex.get(2)) + ">=" + "'" + lstInputIdNotEmpty.get(2) + "'"
                    + " and " + lstColumnName.get(lstIndex.get(3)) + "<=" + "'" + lstInputIdNotEmpty.get(3) + "'"
                    + " and " + lstColumnName.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                    + " and " + lstColumnName.get(lstIndex.get(1)) + "=" + "'" + lstInputIdNotEmpty.get(1) + "'";
               

        }

        int soDong=0;
        try (Connection conn = DBConnection.getConnection();) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                soDong= rs.getInt("soDong");
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return soDong;
    }

    public List<HoaDonNhap> findHoaDonXuat(String idNhanVienKho, String idNhanVienCuaHang, String trangThai, String ngayBatDau, String ngayKetThuc, int start, int end) {
        String sql = "SELECT * FROM ( \n"
                + "SELECT  * , ROW_NUMBER() OVER (ORDER BY ngaythem desc) as row  FROM HoaDonNhap where (TrangThai=-1 or TrangThai=2  or TrangThai=3 or TrangThai=4 or TrangThai=6)\n"
                + ") a WHERE ((row >= ? and row <= ?) ) ";
        String sql2 = "SELECT * FROM ( \n"
                + "SELECT  * , ROW_NUMBER() OVER (ORDER BY ngaythem desc) as row  FROM HoaDonNhap \n"
                + ") a WHERE ((row >= ? and row <= ?) ) ";
        String p1Sql = "SELECT * FROM ( \n"
                + "SELECT  * , ROW_NUMBER() OVER (ORDER BY ngaythem desc) as row  FROM HoaDonNhap where (TrangThai=-1 or TrangThai=2  or TrangThai=3 or TrangThai=4 or TrangThai=6) ";
        String p1Sql2 = "SELECT * FROM ( \n"
                + "SELECT  * , ROW_NUMBER() OVER (ORDER BY ngaythem desc) as row  FROM HoaDonNhap  ";
        String p2 =") a WHERE ((row >= ? and row <= ?) )  ";
        List<String> lstColumnName = new ArrayList<>();
        lstColumnName.add("idNhanVienKho");
        lstColumnName.add("idNhanVienCuaHang");
        lstColumnName.add("trangThai");
        lstColumnName.add("ngayThem");
        lstColumnName.add("ngayThem");
        List<String> lstInputId = new ArrayList<>();
        lstInputId.add(idNhanVienKho);
        lstInputId.add(idNhanVienCuaHang);
        lstInputId.add(trangThai);
        lstInputId.add(ngayBatDau);
        lstInputId.add(ngayKetThuc);
        List<String> lstInputIdNotEmpty = new ArrayList<>();
        List<Integer> lstIndex = new ArrayList<>();
        for (int i = 0; i < lstInputId.size(); i++) {
            if (lstInputId.get(i).isEmpty() == false) {
                lstInputIdNotEmpty.add(lstInputId.get(i));
                lstIndex.add(i);
            }
        }
        if (lstInputIdNotEmpty.size() == 1) {
            if (lstInputId.get(2).equalsIgnoreCase("")) {
                sql = p1Sql + " and "
                        + lstColumnName.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                        + p2;
            } else {
                sql = p1Sql2 + " where "
                        + lstColumnName.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                        + p2;
            }
        } else if (lstInputIdNotEmpty.size() == 2) {
            if (lstInputId.get(3).isEmpty() == false && lstInputId.get(4).isEmpty() == false) {
                sql = p1Sql + " and "
                        + lstColumnName.get(lstIndex.get(0)) + ">=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                        + " and " + lstColumnName.get(lstIndex.get(1)) + "<=" + "'" + lstInputIdNotEmpty.get(1) + "'"
                        + p2;
            } else {
                if (lstInputId.get(2).equalsIgnoreCase("")) {
                    sql = p1Sql + " and "
                            + lstColumnName.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                            + " and " + lstColumnName.get(lstIndex.get(1)) + "=" + "'" + lstInputIdNotEmpty.get(1) + "'"
                            + p2;
                } else {
                    sql = p1Sql2 + " where "
                            + lstColumnName.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                            + " and " + lstColumnName.get(lstIndex.get(1)) + "=" + "'" + lstInputIdNotEmpty.get(1) + "'"
                            + p2;
                }
            }
        } else if (lstInputIdNotEmpty.size() == 3) {
            if (lstInputId.get(3).isEmpty() == false && lstInputId.get(4).isEmpty() == false) {
                if (lstInputId.get(2).equalsIgnoreCase("")) {
                    sql = p1Sql + " and "
                            + lstColumnName.get(lstIndex.get(1)) + ">=" + "'" + lstInputIdNotEmpty.get(1) + "'"
                            + " and " + lstColumnName.get(lstIndex.get(2)) + "<=" + "'" + lstInputIdNotEmpty.get(2) + "'"
                            + " and " + lstColumnName.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                            + p2;
                } else {
                    sql = p1Sql2 + " where "
                            + lstColumnName.get(lstIndex.get(1)) + ">=" + "'" + lstInputIdNotEmpty.get(1) + "'"
                            + " and " + lstColumnName.get(lstIndex.get(2)) + "<=" + "'" + lstInputIdNotEmpty.get(2) + "'"
                            + " and " + lstColumnName.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                            + p2;
                }
            } else {
                sql = p1Sql2 + " where "
                        + lstColumnName.get(lstIndex.get(1)) + "=" + "'" + lstInputIdNotEmpty.get(1) + "'"
                        + " and " + lstColumnName.get(lstIndex.get(2)) + "=" + "'" + lstInputIdNotEmpty.get(2) + "'"
                        + " and " + lstColumnName.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                        + p2;
            }
        } else if (lstInputIdNotEmpty.size() == 4) {
            if (lstInputId.get(2).equalsIgnoreCase("")) {
                sql = p1Sql + " and "
                        + lstColumnName.get(lstIndex.get(2)) + ">=" + "'" + lstInputIdNotEmpty.get(2) + "'"
                        + " and " + lstColumnName.get(lstIndex.get(3)) + "<=" + "'" + lstInputIdNotEmpty.get(3) + "'"
                        + " and " + lstColumnName.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                        + " and " + lstColumnName.get(lstIndex.get(1)) + "=" + "'" + lstInputIdNotEmpty.get(1) + "'"
                        + p2;
            } else {
                sql = p1Sql2 + " where "
                        + lstColumnName.get(lstIndex.get(2)) + ">=" + "'" + lstInputIdNotEmpty.get(2) + "'"
                        + " and " + lstColumnName.get(lstIndex.get(3)) + "<=" + "'" + lstInputIdNotEmpty.get(3) + "'"
                        + " and " + lstColumnName.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                        + " and " + lstColumnName.get(lstIndex.get(1)) + "=" + "'" + lstInputIdNotEmpty.get(1) + "'"
                        + p2;
            }
        } else if (lstInputIdNotEmpty.size() == 5) {
            sql = p1Sql2 + " where "
                    + lstColumnName.get(lstIndex.get(3)) + ">=" + "'" + lstInputIdNotEmpty.get(3) + "'"
                    + " and " + lstColumnName.get(lstIndex.get(4)) + "<=" + "'" + lstInputIdNotEmpty.get(4) + "'"
                    + " and " + lstColumnName.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                    + " and " + lstColumnName.get(lstIndex.get(1)) + "=" + "'" + lstInputIdNotEmpty.get(1) + "'"
                    + " and " + lstColumnName.get(lstIndex.get(2)) + "=" + "'" + lstInputIdNotEmpty.get(2) + "'"
                    + p2;
        }

        List<HoaDonNhap> lstHoaDon = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, start);
            ps.setObject(2, end);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonNhap hoaDonNhap = new HoaDonNhap();
                hoaDonNhap.setIdHoaDon(rs.getString("idHoaDon"));
                hoaDonNhap.setIdNhanVienKho(rs.getString("IdNhanVienKho"));
                hoaDonNhap.setIdNhanVienCuaHang(rs.getString("IdNhanVienCuaHang"));
                hoaDonNhap.setTenHoaDon(rs.getString("TenHoaDon"));
                hoaDonNhap.setNgayThem(rs.getString("NgayThem"));
                hoaDonNhap.setGhiChu(rs.getString("GhiChu"));
                hoaDonNhap.setTrangThai(rs.getInt("TrangThai"));
                lstHoaDon.add(hoaDonNhap);
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstHoaDon;
    }
    
    public int getSoDongXuat(String idNhanVienKho, String idNhanVienCuaHang, String trangThai, String ngayBatDau, String ngayKetThuc) {
        String sql = "select count(idHoaDon) as soDong from HoaDonNhap where  (TrangThai=-1 or TrangThai=2  or TrangThai=3 or TrangThai=4 or TrangThai=6)";
        String sql2 = "select count(idHoaDon) as soDong from HoaDonNhap";
        List<String> lstColumnName = new ArrayList<>();
        lstColumnName.add("idNhanVienKho");
        lstColumnName.add("idNhanVienCuaHang");
        lstColumnName.add("trangThai");
        lstColumnName.add("ngayThem");
        lstColumnName.add("ngayThem");
        List<String> lstInputId = new ArrayList<>();
        lstInputId.add(idNhanVienKho);
        lstInputId.add(idNhanVienCuaHang);
        lstInputId.add(trangThai);
        lstInputId.add(ngayBatDau);
        lstInputId.add(ngayKetThuc);
        List<String> lstInputIdNotEmpty = new ArrayList<>();
        List<Integer> lstIndex = new ArrayList<>();
        for (int i = 0; i < lstInputId.size(); i++) {
            if (lstInputId.get(i).isEmpty() == false) {
                lstInputIdNotEmpty.add(lstInputId.get(i));
                lstIndex.add(i);
            }
        }
        if (lstInputIdNotEmpty.size() == 1) {
            if (lstInputId.get(2).equalsIgnoreCase("")) {
                sql = sql + " and "
                        + lstColumnName.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'";
                       
            } else {
                sql = sql2 + " where "
                        + lstColumnName.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'";
                       
            }
        } else if (lstInputIdNotEmpty.size() == 2) {
            if (lstInputId.get(3).isEmpty() == false && lstInputId.get(4).isEmpty() == false) {
                sql = sql + " and "
                        + lstColumnName.get(lstIndex.get(0)) + ">=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                        + " and " + lstColumnName.get(lstIndex.get(1)) + "<=" + "'" + lstInputIdNotEmpty.get(1) + "'";
                     
            } else {
                if (lstInputId.get(2).equalsIgnoreCase("")) {
                    sql = sql + " and "
                            + lstColumnName.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                            + " and " + lstColumnName.get(lstIndex.get(1)) + "=" + "'" + lstInputIdNotEmpty.get(1) + "'";
                       
                } else {
                    sql = sql2 + " where "
                            + lstColumnName.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                            + " and " + lstColumnName.get(lstIndex.get(1)) + "=" + "'" + lstInputIdNotEmpty.get(1) + "'";
                          
                }
            }
        } else if (lstInputIdNotEmpty.size() == 3) {
            if (lstInputId.get(3).isEmpty() == false && lstInputId.get(4).isEmpty() == false) {
                if (lstInputId.get(2).equalsIgnoreCase("")) {
                    sql = sql + " and "
                            + lstColumnName.get(lstIndex.get(1)) + ">=" + "'" + lstInputIdNotEmpty.get(1) + "'"
                            + " and " + lstColumnName.get(lstIndex.get(2)) + "<=" + "'" + lstInputIdNotEmpty.get(2) + "'"
                            + " and " + lstColumnName.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'";
                         
                } else {
                    sql = sql2 + " where "
                            + lstColumnName.get(lstIndex.get(1)) + ">=" + "'" + lstInputIdNotEmpty.get(1) + "'"
                            + " and " + lstColumnName.get(lstIndex.get(2)) + "<=" + "'" + lstInputIdNotEmpty.get(2) + "'"
                            + " and " + lstColumnName.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'";
                          
                }
            } else {
                sql = sql2 + " where "
                        + lstColumnName.get(lstIndex.get(1)) + "=" + "'" + lstInputIdNotEmpty.get(1) + "'"
                        + " and " + lstColumnName.get(lstIndex.get(2)) + "=" + "'" + lstInputIdNotEmpty.get(2) + "'"
                        + " and " + lstColumnName.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'";
                   
            }
        } else if (lstInputIdNotEmpty.size() == 4) {
            if (lstInputId.get(2).equalsIgnoreCase("")) {
                sql = sql + " and "
                        + lstColumnName.get(lstIndex.get(2)) + ">=" + "'" + lstInputIdNotEmpty.get(2) + "'"
                        + " and " + lstColumnName.get(lstIndex.get(3)) + "<=" + "'" + lstInputIdNotEmpty.get(3) + "'"
                        + " and " + lstColumnName.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                        + " and " + lstColumnName.get(lstIndex.get(1)) + "=" + "'" + lstInputIdNotEmpty.get(1) + "'";
              
            } else {
                sql = sql2 + " where "
                        + lstColumnName.get(lstIndex.get(2)) + ">=" + "'" + lstInputIdNotEmpty.get(2) + "'"
                        + " and " + lstColumnName.get(lstIndex.get(3)) + "<=" + "'" + lstInputIdNotEmpty.get(3) + "'"
                        + " and " + lstColumnName.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                        + " and " + lstColumnName.get(lstIndex.get(1)) + "=" + "'" + lstInputIdNotEmpty.get(1) + "'";
             
            }
        } else if (lstInputIdNotEmpty.size() == 5) {
            sql = sql2 + " where "
                    + lstColumnName.get(lstIndex.get(3)) + ">=" + "'" + lstInputIdNotEmpty.get(3) + "'"
                    + " and " + lstColumnName.get(lstIndex.get(4)) + "<=" + "'" + lstInputIdNotEmpty.get(4) + "'"
                    + " and " + lstColumnName.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                    + " and " + lstColumnName.get(lstIndex.get(1)) + "=" + "'" + lstInputIdNotEmpty.get(1) + "'"
                    + " and " + lstColumnName.get(lstIndex.get(2)) + "=" + "'" + lstInputIdNotEmpty.get(2) + "'";
               
        }

        int soDong=0;
        try (Connection conn = DBConnection.getConnection();) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                soDong=rs.getInt("soDong");
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return soDong;
    }

    public List<HoaDonChiTiet> getHoaDonChiTietByIdHoaDon(String idHoaDon) {
        List<HoaDonChiTiet> lstHoaDonChiTiet = new ArrayList<>();

        String sql = "select * from HoaDonChiTiet\n"
                + "where IDHoaDon=? order by soLuong desc";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, idHoaDon);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonChiTiet HoaDonChiTiet = new HoaDonChiTiet();
                HoaDonChiTiet.setDonGia(rs.getBigDecimal("donGia"));
                HoaDonChiTiet.setIdHoaDon(rs.getString("IdHoaDon"));
                HoaDonChiTiet.setIdSanPham(rs.getString("IdSanPham"));
                HoaDonChiTiet.setNgayThem(rs.getString("NgayThem"));
                HoaDonChiTiet.setSoLuong(rs.getInt("SoLuong"));
                HoaDonChiTiet.setTrangThai(rs.getInt("TrangThai"));
                lstHoaDonChiTiet.add(HoaDonChiTiet);
            }

            return lstHoaDonChiTiet;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<HoaDonNhapChiTiet> getHoaDonChiTietNhap(String idHoaDon) {
        List<HoaDonNhapChiTiet> lstHoaDonChiTiet = new ArrayList<>();

        String sql = "select * from HoaDonNhapChiTiet\n"
                + "where IDHoaDon = ? order by soLuong desc";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, idHoaDon);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonNhapChiTiet HoaDonChiTiet = new HoaDonNhapChiTiet();
                HoaDonChiTiet.setDonGia(rs.getBigDecimal("donGia"));
                HoaDonChiTiet.setIdSanPham(rs.getString("IdSanPham"));
                HoaDonChiTiet.setSoLuong(rs.getInt("SoLuong"));

                lstHoaDonChiTiet.add(HoaDonChiTiet);
            }

            return lstHoaDonChiTiet;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<HoaDonNhapChiTiet> getHoaDonChiTietXuat(String idHoaDon) {
        List<HoaDonNhapChiTiet> lstHoaDonChiTiet = new ArrayList<>();

        String sql = "select * from HoaDonNhapChiTiet\n"
                + "where IDHoaDon = ? order by soLuong desc";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, idHoaDon);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonNhapChiTiet HoaDonChiTiet = new HoaDonNhapChiTiet();
                HoaDonChiTiet.setDonGia(rs.getBigDecimal("donGia"));
                HoaDonChiTiet.setIdSanPham(rs.getString("IdSanPham"));
                HoaDonChiTiet.setSoLuong(rs.getInt("SoLuong"));

                HoaDonChiTiet.setSoLuongThucTe(rs.getInt("SoLuongThucTe"));
                lstHoaDonChiTiet.add(HoaDonChiTiet);
            }

            return lstHoaDonChiTiet;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
