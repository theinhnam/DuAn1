/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.KhuyenMai;
import Ultilities.DBConnection;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author DELL
 */
public class KhuyenMaiRepositoey {

    public ArrayList<KhuyenMai> getList() {
        ArrayList<KhuyenMai> lstKhuyenMais = new ArrayList<>();
        String sql = "select * from KhuyenMai WHERE TrangThai = 0 or TrangThai = 1";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhuyenMai km = new KhuyenMai();
                km.setIdKhuyenMai(rs.getString("IDKhuyenMai"));
                km.setTenKhuyenMai(rs.getString("TenKhuyenMai"));
                km.setNgayThem(rs.getDate("NgayThem"));
                km.setNgaySua(rs.getDate("NgaySua"));
                km.setSoLanApDung(rs.getInt("SoLanApDung"));
                km.setChietKhau(rs.getInt("ChietKhau"));
                km.setTinhTrang(rs.getInt("TrangThai"));
                lstKhuyenMais.add(km);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstKhuyenMais;
    }

    public ArrayList<KhuyenMai> getListConHan() {
        ArrayList<KhuyenMai> lstKhuyenMais = new ArrayList<>();
        String sql = "select * from KhuyenMai where SoLanApDung>0 and TrangThai=1";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhuyenMai km = new KhuyenMai();
                km.setIdKhuyenMai(rs.getString("IDKhuyenMai"));
                km.setTenKhuyenMai(rs.getString("TenKhuyenMai"));
                km.setNgayThem(rs.getDate("NgayThem"));
                km.setNgaySua(rs.getDate("NgaySua"));
                km.setSoLanApDung(rs.getInt("SoLanApDung"));
                km.setChietKhau(rs.getInt("ChietKhau"));
                km.setTinhTrang(rs.getInt("TrangThai"));
                lstKhuyenMais.add(km);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstKhuyenMais;
    }

    public boolean insert(KhuyenMai km) {
        String sql = "insert into KhuyenMai(IDKhuyenMai,TenKhuyenMai,SoLanApDung,ChietKhau,TrangThai) values (newid(),?,?,?,?)";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, km.getTenKhuyenMai());
            ps.setObject(2, km.getSoLanApDung());
            ps.setObject(3, km.getChietKhau());
            ps.setObject(4, km.getTinhTrang());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(KhuyenMai km) {
        String sql = "update KhuyenMai set TenKhuyenMai=?, SoLanApDung=?,ChietKhau=?,TrangThai=? where IDKhuyenMai=?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, km.getTenKhuyenMai());
            ps.setObject(2, km.getSoLanApDung());
            ps.setObject(3, km.getChietKhau());
            ps.setObject(4, km.getTinhTrang());
            ps.setObject(5, km.getIdKhuyenMai());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateSoLanApDung(KhuyenMai km) {
        String sql = "update KhuyenMai set SoLanApDung=SoLanApDung-1 where TenKhuyenMai=?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, km.getTenKhuyenMai());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateTrangThai(KhuyenMai km) {
        String sql = "update KhuyenMai set TrangThai=? where SoLanApDung=? and IDKhuyenMai=?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, km.getTinhTrang());
            ps.setObject(2, km.getSoLanApDung());
            ps.setObject(3, km.getIdKhuyenMai());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(String id) {
        String sql = "Update KhuyenMai set TrangThai = 2 where IDKhuyenMai=?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
