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
    public ArrayList<TaiKhoan> findAll(){
        String sql = "SELECT * FROM TaiKhoan";
        ArrayList<TaiKhoan> listAccount = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                TaiKhoan taiKhoan = new TaiKhoan(rs.getInt("IDTaiKhoan"), rs.getInt("IDLoaiNguoiDung"), rs.getString("Email"), rs.getString("MatKhau"), rs.getString("HoTen"));
                listAccount.add(taiKhoan);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listAccount;
    }
}
