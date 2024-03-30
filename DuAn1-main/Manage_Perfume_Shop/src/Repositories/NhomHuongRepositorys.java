/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.NhomHuong;
import Ultilities.DBConnection;

import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author DELL
 */
public class NhomHuongRepositorys {

    DBConnection dBConnection;

    public ArrayList<NhomHuong> getList() {
        ArrayList<NhomHuong> lstNH = new ArrayList<>();
        String sql = "select * from NhomHuong where trangThai =1 or trangThai=0";
        try (Connection con = dBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhomHuong nh = new NhomHuong();
                nh.setIdNhomHuong(rs.getString("IDNhomHuong"));
                nh.setTenNhomHuong(rs.getString("TenNhomHuong"));
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

    public boolean insert(NhomHuong nh) {
        String sql = "insert into NhomHuong(IDNhomHuong,TenNhomHuong,TrangThai) values(NEWID(),?,?)";
        try (Connection con = dBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, nh.getTenNhomHuong());
            ps.setObject(2, nh.getTrangThai());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(NhomHuong nh) {
        String sql = "update NhomHuong set TenNhomHuong=?, TrangThai=? where IDNhomHuong=?";
        try (Connection con = dBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, nh.getTenNhomHuong());
            ps.setObject(2, nh.getTrangThai());
            ps.setObject(3, nh.getIdNhomHuong());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(String id) {
        String sql = "update NhomHuong set trangThai=2 where IDNhomHuong=?";
        try (Connection con = dBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1,id);
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public String getIDByName(String tenNhomHuong){
        String sql = "SELECT IDNhomHuong FROM NhomHuong WHERE TenNhomHuong = ?";
        String idNhomHuong = "";
        try (Connection conn = dBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setObject(1, tenNhomHuong);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                idNhomHuong = rs.getString("IDNhomHuong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idNhomHuong;
    }
    
    public void updateTrangThai(String idNhomHuong){
        String sql = "UPDATE NhomHuong SET TrangThai = 1 WHERE IDNhomHuong = ?";
        try (Connection conn = dBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setObject(1, idNhomHuong);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String checkTrung(String ten){
        String sql="select TenNhomHuong from NhomHuong where TenNhomHuong=? and (TrangThai=1 or TrangThai=0)";
        String tenNH="";
        try(Connection con=dBConnection.getConnection();
                PreparedStatement ps=con.prepareStatement(sql)) {
            ps.setObject(1, ten);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                tenNH=rs.getString("TenNhomHuong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tenNH;
    }

}
