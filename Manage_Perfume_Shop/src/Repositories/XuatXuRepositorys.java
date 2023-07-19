/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.XuatXu;
import Ultilities.DBConnection;

import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author DELL
 */
public class XuatXuRepositorys {

    DBConnection dBConnection;

    public ArrayList<XuatXu> getList() {
        ArrayList<XuatXu> lstXX = new ArrayList<>();
        String sql = "select * from XuatXu";
        try (Connection con = dBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                XuatXu xx = new XuatXu();
                xx.setIdXuatXu(rs.getString("IDXuatXu"));
                xx.setTen(rs.getString("TenXuatXu"));
                xx.setNgayThem(rs.getDate("NgayThem"));
                xx.setNgaySua(rs.getDate("NgaySua"));
                xx.setTrangThai(rs.getInt("TrangThai"));
                lstXX.add(xx);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstXX;
    }

    public boolean insert(XuatXu xx) {
        String sql = "insert into XuatXu(IDXuatXu,TenXuatXu,TrangThai) values(NEWID(),?,?)";
        try (Connection con = dBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, xx.getTen());
            ps.setObject(2, xx.getTrangThai());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(XuatXu xx) {
        String sql = "update XuatXu set TenXuatXu=?, TrangThai=? where IDXuatXu=?";
        try (Connection con = dBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, xx.getTen());
            ps.setObject(2, xx.getTrangThai());
            ps.setObject(3, xx.getIdXuatXu());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(String id) {
        String sql = "update XuatXu set trangThai=0 where IDXuatXu=?";
        try (Connection con = dBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1,id);
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
