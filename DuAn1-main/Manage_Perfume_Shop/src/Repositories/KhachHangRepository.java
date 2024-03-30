/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.HoaDon;
import DomainModels.KhachHang;
import Ultilities.DBConnection;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 *
 * @author theinhnam
 */
public class KhachHangRepository {
//    public ArrayList<KhachHang> findAll(){
//        String sql = "SELECT * FROM KhachHang WHERE TrangThai = 0 or TrangThai = 1 or TrangThai = 2";
//        ArrayList<KhachHang> listKhachHang = new ArrayList<>();
//        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {                
//                KhachHang kh = new KhachHang();
//                kh.setIdKhachHang(rs.getString("IDKhachHang"));
//                kh.setHoTen(rs.getString("HoTen"));
//                kh.setSoDienThoai(rs.getString("SoDienThoai"));
//                kh.setNgayThem(rs.getDate("NgayThem"));
//                kh.setNgaySua(rs.getDate("NgaySua"));
//                kh.setTrangThai(rs.getInt("TrangThai"));
//                listKhachHang.add(kh);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return listKhachHang;
//    }

    public boolean save(KhachHang kh) {
        String sql = "INSERT INTO KhachHang(IDKhachHang, HoTen, SoDienThoai, TrangThai)\n"
                + "VALUES(NEWID(), ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, kh.getHoTen());
            ps.setObject(2, kh.getSoDienThoai());
            ps.setObject(3, kh.getTrangThai());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(KhachHang kh) {
        String sql = "UPDATE KhachHang SET HoTen = ?, SoDienThoai = ?, NgaySua = GETDATE(), TrangThai = ? WHERE IDKhachHang = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, kh.getHoTen());
            ps.setObject(2, kh.getSoDienThoai());
            ps.setObject(3, kh.getTrangThai());
            ps.setObject(4, kh.getIdKhachHang());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(KhachHang kh) {
        String sql = "UPDATE KhachHang SET TrangThai = 3 WHERE IDKhachHang = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, kh.getIdKhachHang());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<KhachHang> search(String name, int start, int end) {
        String sql = "SELECT * FROM ( \n"
                + "SELECT  * , ROW_NUMBER() OVER (ORDER BY ngaythem desc) as row  FROM KhachHang \n"
                + "where (trangthai=1 or trangthai=0 or trangthai=2) and HoTen LIKE ?\n"
                + ") a WHERE ((row >= ? and row <= ?) ) ";
        ArrayList<KhachHang> listKH = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + name + "%");
            ps.setObject(2, start);
            ps.setObject(3, end);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setIdKhachHang(rs.getString("IDKhachHang"));
                kh.setHoTen(rs.getString("HoTen"));
                kh.setSoDienThoai(rs.getString("SoDienThoai"));
                kh.setNgayThem(rs.getDate("NgayThem"));
                kh.setNgaySua(rs.getDate("NgaySua"));
                kh.setTrangThai(rs.getInt("TrangThai"));
                listKH.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKH;
    }

    public int getSoDong(String name) {
        String sql = "SELECT count(IDKhachHang) as soDong FROM KhachHang WHERE HoTen LIKE ? and (trangthai=1 or trangthai=0 or trangthai=2) ";
        int soDong = 0;
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                soDong = rs.getInt("soDong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return soDong;
    }

    public ArrayList<HoaDon> getHoaDonKH(String idKhachHang, int start, int end) {
        String sql = "SELECT * FROM ( \n"
                + "SELECT  * , ROW_NUMBER() OVER (ORDER BY ngaythem desc) as row  FROM HoaDon \n"
                + "where trangthai=1 and IDKhachHang = ?\n"
                + ") a WHERE ((row >= ? and row <= ?) ) ";
        ArrayList<HoaDon> listHD = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, idKhachHang);
            ps.setObject(2, start);
            ps.setObject(3, end);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setIdKhachHang(rs.getString("IDKhachHang"));
                hd.setTenHoaDon(rs.getString("TenHoaDon"));
                hd.setTongTien(rs.getBigDecimal("TongTien"));
                hd.setNgayThem(rs.getString("NgayThem"));
                listHD.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHD;
    }
    
    public int getSoDongHD(String idKhachHang) {
        String sql = "select count(idhoadon) as soDong from HoaDon where trangthai=1 and IDKhachHang = ?";
        int soDong=0;
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, idKhachHang);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                soDong=rs.getInt("soDong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return soDong;
    }

    public String getHoTenByID(String idKhachHang) {
        String sql = "SELECT HoTen FROM KhachHang WHERE IDKhachHang = ? and (TrangThai = 0 or TrangThai = 1 or TrangThai = 2)";
        String hoTen = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, idKhachHang);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                hoTen = rs.getString("HoTen");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hoTen;
    }

    public String getSDTByID(String idKhachHang) {
        String sql = "SELECT SoDienThoai FROM KhachHang WHERE IDKhachHang = ? and (TrangThai = 0 or TrangThai = 1 or TrangThai = 2)";
        String soDienThoai = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, idKhachHang);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                soDienThoai = rs.getString("SoDienThoai");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return soDienThoai;
    }

    public boolean updateTTKH(KhachHang kh) {
        String sql = "update KhachHang set Hoten=? where SoDienThoai=?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, kh.getHoTen());
            ps.setObject(2, kh.getSoDienThoai());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean checkSDTMatch(String soDienThoai){
        String sql = "SELECT * FROM KhachHang WHERE SoDienThoai = ? and (TrangThai = 0 or TrangThai = 1 or TrangThai = 2)";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setObject(1, soDienThoai);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
