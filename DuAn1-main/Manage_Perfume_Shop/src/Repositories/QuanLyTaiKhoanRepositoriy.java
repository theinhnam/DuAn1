/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.TaiKhoan;
import Ultilities.DBConnection;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author theinhnam
 */
public class QuanLyTaiKhoanRepositoriy {
    public ArrayList<TaiKhoan> findAll(){
        String sql = "SELECT * FROM TaiKhoan WHERE TrangThai = 1 or TrangThai = 0 order by NgayThem desc";
        ArrayList<TaiKhoan> listTaiKhoan = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                TaiKhoan taiKhoan = new TaiKhoan();
                taiKhoan.setIdTaiKhoan(rs.getString("IDTaiKhoan"));
                taiKhoan.setIdLoaiNguoiDung(rs.getString("IDLoaiNguoiDung"));
                taiKhoan.setEmail(rs.getString("Email"));
                taiKhoan.setMatKhau(rs.getString("MatKhau"));
                taiKhoan.setHoTen(rs.getString("HoTen"));
                taiKhoan.setNgayThem(rs.getDate("NgayThem"));
                taiKhoan.setNgaySua(rs.getDate("NgaySua"));
                taiKhoan.setTrangThai(rs.getInt("TrangThai"));
                listTaiKhoan.add(taiKhoan);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTaiKhoan;
    }
    
    public String getTenLoaiNguoiDung(String idLoaiNguoiDung){
        String sql = "SELECT Ten FROM LoaiNguoiDung WHERE IDLoaiNguoiDung = ?";
        String tenLoaiNguoiDung = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setObject(1, idLoaiNguoiDung);
            ResultSet rs = ps.executeQuery();
            if (rs.next() == true) {
               tenLoaiNguoiDung = rs.getString("Ten");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tenLoaiNguoiDung;
    }
    
    public ArrayList<String> getAllLoaiNguoiDung(){
        String sql = "SELECT Ten FROM LoaiNguoiDung WHERE TrangThai = 1 ";
        ArrayList<String> listLoaiNguoiDung = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                listLoaiNguoiDung.add(rs.getString("Ten"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listLoaiNguoiDung;
    }
    
    public boolean addTaiKhoan(TaiKhoan tk){
        String sql = "INSERT INTO TaiKhoan(IDTaiKhoan,IDLoaiNguoiDung, Email, MatKhau, HoTen, TrangThai)VALUES(NEWID(),?,?,?,?,?)";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setObject(1, tk.getIdLoaiNguoiDung());
            ps.setObject(2, tk.getEmail());
            ps.setObject(3, tk.getMatKhau());
            ps.setObject(4, tk.getHoTen());
            ps.setInt(5, tk.getTrangThai());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public String getIDLoaiNguoiDung(String tenLoaiNguoiDung){
        String sql = "SELECT IDLoaiNguoiDung FROM LoaiNguoiDung WHERE Ten = ?";
        String idLoaiNguoiDung = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setObject(1,tenLoaiNguoiDung);
            ResultSet rs = ps.executeQuery();
            if (rs.next() == true) {
               idLoaiNguoiDung = rs.getString("IDLoaiNguoiDung");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idLoaiNguoiDung;
    }
    
    public boolean updateTaiKhoan(TaiKhoan taiKhoan){
        String sql = "UPDATE TaiKhoan SET IDLoaiNguoiDung = ?, Email = ?, MatKhau = ?, HoTen = ?, NgaySua = GETDATE(), TrangThai = ? WHERE IDTaiKhoan = CAST(? AS UNIQUEIDENTIFIER)";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setObject(1, taiKhoan.getIdLoaiNguoiDung());
            ps.setObject(2, taiKhoan.getEmail());
            ps.setObject(3, taiKhoan.getMatKhau());
            ps.setObject(4, taiKhoan.getHoTen());
            ps.setObject(5, taiKhoan.getTrangThai());
            ps.setObject(6, taiKhoan.getIdTaiKhoan());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public String getIDByEmail(String email){
        String sql = "SELECT IDTaiKhoan FROM TaiKhoan WHERE Email = ? and TrangThai = 1";
        String idTaiKhoan = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setObject(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                idTaiKhoan = rs.getString("IDTaiKhoan");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idTaiKhoan;
    }
    
    public boolean deleteTaiKhoan(String idTaiKhoan){
        String sql = "UPDATE TaiKhoan SET TrangThai = 2 WHERE IDTaiKhoan = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setObject(1, idTaiKhoan);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean checkEmailMatch(String email){
        String sql = "SELECT * FROM TaiKhoan WHERE Email = ? and (TrangThai = 0 or TrangThai = 1)";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setObject(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next() == true) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public void deleteByEmail(String email){
        String sql = "DELETE FROM TaiKhoan WHERE Email = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setObject(1, email);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
