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
        String sql = "select * from XuatXu where trangThai =1 or trangThai=0";
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
        String sql = "update XuatXu set trangThai=2 where IDXuatXu=?";
        try (Connection con = dBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1,id);
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public void updateTrangThai(String tenXuatXu){
        String sql = "UPDATE XuatXu SET TrangThai = 1 WHERE TenXuatXu = ?";
        try (Connection conn = dBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setObject(1, tenXuatXu);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String checkTrung(String ten){
        String sql="select TenXuatXu from XuatXu where TenXuatXu=? and (TrangThai=1 or TrangThai=0)";
        String tenXX="";
        try(Connection con=dBConnection.getConnection();
                PreparedStatement ps=con.prepareStatement(sql)) {
            ps.setObject(1, ten);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                tenXX=rs.getString("TenXuatXu");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tenXX;
    }
    
}
