/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.DanhMuc;
import Ultilities.DBConnection;

import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author DELL
 */
public class DanhMucRepositorys {

    DBConnection dBConnection;

    public ArrayList<DanhMuc> getList() {
        ArrayList<DanhMuc> lstDM = new ArrayList<>();
        String sql = "select * from DanhMuc where trangThai =1 or trangThai=0";
        try (Connection con = dBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DanhMuc dm = new DanhMuc();
                dm.setIdDanhMuc(rs.getString("IDDanhMuc"));
                dm.setTenDanhMuc(rs.getString("TenDanhMuc"));
                dm.setNgayThem(rs.getDate("NgayThem"));
                dm.setNgaySua(rs.getDate("NgaySua"));
                dm.setTrangThai(rs.getInt("TrangThai"));
                lstDM.add(dm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstDM;
    }

    public boolean insert(DanhMuc dm) {
        String sql = "insert into DanhMuc(IDDanhMuc,TenDanhMuc,TrangThai) values(NEWID(),?,?)";
        try (Connection con = dBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, dm.getTenDanhMuc());
            ps.setObject(2, dm.getTrangThai());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(DanhMuc dm) {
        String sql = "update DanhMuc set TenDanhMuc=?, TrangThai=? where IDDanhMuc=?";
        try (Connection con = dBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, dm.getTenDanhMuc());
            ps.setObject(2, dm.getTrangThai());
            ps.setObject(3, dm.getIdDanhMuc());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(String id) {
        String sql = "update DanhMuc set trangThai=2 where IDDanhMuc=? ";
        try (Connection con = dBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void updateTrangThai(String idDanhMuc) {
        String sql = "UPDATE DanhMuc SET TrangThai = 1 WHERE TenDanhMuc = ?";
        try (Connection conn = dBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, idDanhMuc);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String checkTrung(String ten) {
        String sql = "select TenDanhMuc from DanhMuc where TenDanhMuc=? and (TrangThai=1 or TrangThai=0)";
        String tenDM = "";
        try (Connection con = dBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tenDM = rs.getString("TenDanhMuc");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tenDM;
    }
}
