/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.TaiKhoan;
import Ultilities.DBConnection;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 *
 * @author theinhnam
 */
public class LoginRepositories {

    public ArrayList<TaiKhoan> checkLogin(TaiKhoan o) {
        String sql = "SELECT * FROM TaiKhoan WHERE Email = ? and MatKhau = ? and TrangThai = 1";
        ArrayList<TaiKhoan> listAccount = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, o.getEmail());
            ps.setObject(2, o.getMatKhau());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TaiKhoan taiKhoan = new TaiKhoan(rs.getString("IDLoaiNguoiDung"), rs.getString("HoTen"));
                listAccount.add(taiKhoan);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listAccount;
    }

    public String getIDLoaiNguoiDung() {
        String sql = "SELECT IDLoaiNguoiDung FROM LoaiNguoiDung WHERE Ten = N'Quản lý'";
        String idLoaiNguoiDung = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                idLoaiNguoiDung = rs.getString("IDLoaiNguoiDung");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idLoaiNguoiDung;
    }

    public String getIDByEmail(String email) {
        String sql = "SELECT IDTaiKhoan FROM TaiKhoan WHERE Email = ? and TrangThai = 1";
        String idTaiKhoan = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
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

    public String getQuyenTaiKhoan(String idTaiKhoan) {
        String sql = "select LoaiNguoiDung.Ten from taikhoan inner join LoaiNguoiDung\n"
                + "on TaiKhoan.IDLoaiNguoiDung = LoaiNguoiDung.IDLoaiNguoiDung\n"
                + "WHERE TaiKhoan.IDTaiKhoan = ? ";
        String quyenAccount = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, idTaiKhoan);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                quyenAccount = rs.getString("Ten");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return quyenAccount;
    }
    
    public String getIDNhanVienKho(){
        String sql = "SELECT IDLoaiNguoiDung FROM LoaiNguoiDung WHERE Ten = N'Nhân Viên Kho'";
        String idLoaiNguoiDung = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                idLoaiNguoiDung = rs.getString("IDLoaiNguoiDung");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idLoaiNguoiDung;
    }
}
