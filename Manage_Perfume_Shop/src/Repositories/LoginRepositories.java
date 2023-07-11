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
        String sql = "SELECT * FROM TaiKhoan WHERE Email = ? and MatKhau = ?";
        ArrayList<TaiKhoan> listAccount = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, o.getEmail());
            ps.setObject(2, o.getMatKhau());
            ResultSet rs = ps.executeQuery();
            if (rs.next() == false) {
                return null;
            } else {
                while (rs.next()) {
                    TaiKhoan taiKhoan = new TaiKhoan(rs.getInt("IDLoaiNguoiDung"), rs.getString("Email"), rs.getString("MatKhau"));
                    listAccount.add(taiKhoan);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listAccount;
    }
    
    public String getLoaiNguoiDung(int idLoaiNguoiDung){
        String sql = "SELECT Ten FROM LoaiNguoiDung WHERE IDLoaiNguoiDung = ?";
        String tenLoaiNguoiDung = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setObject(1, idLoaiNguoiDung);
            ResultSet rs = ps.executeQuery();
            if (rs.next() == false) {
                return null;
            }else{
                tenLoaiNguoiDung = rs.getString("Ten");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tenLoaiNguoiDung;
    }
}
