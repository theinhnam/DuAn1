/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.HoaDon;
import Ultilities.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
public class BanHangRepository {
    public boolean createHoaDonBanHang(HoaDon hoaDon){
        String sql = "INSERT INTO HoaDon(IDHoaDon, IDTaiKhoan, TongTien, NgayThanhToan, DiaChiNhanHang, GhiChu, TrangThai)VALUES(NEWID(),?,0,GETDATE(),?,?,1)";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setObject(1, hoaDon.getIdTaiKhoan());
            ps.setObject(1, hoaDon.getIdTaiKhoan());
            ps.setObject(1, hoaDon.getIdTaiKhoan());
            ps.setObject(1, hoaDon.getIdTaiKhoan());
            ps.setObject(1, hoaDon.getIdTaiKhoan());
        } catch (Exception e) {
        }
        return false;
    }
}
