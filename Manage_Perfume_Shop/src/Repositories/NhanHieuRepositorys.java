/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.NhanHieu;
import Ultilities.DBConnection;

import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author DELL
 */
public class NhanHieuRepositorys {

    DBConnection dBConnection;

    public ArrayList<NhanHieu> getList() {
        ArrayList<NhanHieu> lstNH = new ArrayList<>();
        String sql = "select * from NhanHieu";
        try (Connection con = dBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanHieu nh = new NhanHieu();
                nh.setIdNhanHieu(rs.getString("IDNhanHieu"));
                nh.setTenNhanHieu(rs.getString("TenNhanHieu"));
                nh.setNgayThem(rs.getDate("NgayThem"));
                nh.setNgaySua(rs.getDate("NgaySua"));
                nh.setTrangThai(rs.getInt("TrangThai"));
                lstNH.add(nh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstNH;
    }

    public boolean insert(NhanHieu nh) {
        String sql = "insert into NhanHieu(IDNhanHieu,TenNhanHieu,TrangThai) values(NEWID(),?,?)";
        try (Connection con = dBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, nh.getTenNhanHieu());
            ps.setObject(2, nh.getTrangThai());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(NhanHieu nh) {
        String sql = "update nhanHieu set TenNhanHieu=?, TrangThai=? where IDNhanHieu=?";
        try (Connection con = dBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, nh.getTenNhanHieu());
            ps.setObject(2, nh.getTrangThai());
            ps.setObject(3, nh.getIdNhanHieu());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(String id) {
        String sql = "update NhanHieu set trangThai=0 where IDNhanHieu=?";
        try (Connection con = dBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1,id);
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
