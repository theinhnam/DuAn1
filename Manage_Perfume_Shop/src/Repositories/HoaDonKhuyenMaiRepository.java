/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.HoaDonKhuyenMai;
import Ultilities.DBConnection;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author DELL
 */
public class HoaDonKhuyenMaiRepository {
    public ArrayList<HoaDonKhuyenMai> getList(){
        ArrayList<HoaDonKhuyenMai> lstHDKM=new ArrayList<>();
        String sql="select * from HoaDonKhuyenMai";
        try(Connection con=DBConnection.getConnection();
                PreparedStatement ps=con.prepareStatement(sql)) {
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                HoaDonKhuyenMai hdkm=new HoaDonKhuyenMai();
                hdkm.setIdHoaDon(rs.getString("IDHoaDon"));
                hdkm.setIfKhuyenMai(rs.getString("IDKhuyenMai"));
                lstHDKM.add(hdkm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstHDKM;
    }   
    
    public boolean insert(HoaDonKhuyenMai hdkm){
        String sql="insert into HoaDonKhuyenMai(IDHoaDon,IDKhuyenMai) values(?,?)";
        try(Connection con=DBConnection.getConnection();
                PreparedStatement ps=con.prepareStatement(sql)) {
            ps.setObject(1, hdkm.getIdHoaDon());
            ps.setObject(2, hdkm.getIfKhuyenMai());
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean delete(HoaDonKhuyenMai hdkm){
        String sql="delete HoaDonKhuyenMai where IDKhuyenMai=? and IDHoaDon=?";
        try(Connection con=DBConnection.getConnection();
                PreparedStatement ps=con.prepareStatement(sql)) {
            ps.setObject(1, hdkm.getIfKhuyenMai());
            ps.setObject(2, hdkm.getIdHoaDon());
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
