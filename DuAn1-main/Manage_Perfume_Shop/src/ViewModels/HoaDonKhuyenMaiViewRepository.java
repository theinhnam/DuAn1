/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import Repositories.*;
import Ultilities.DBConnection;
import ViewModels.HoaDonKhuyenMaiView;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author DELL
 */
public class HoaDonKhuyenMaiViewRepository {

    public ArrayList<HoaDonKhuyenMaiView> getList(int stt) {
        ArrayList<HoaDonKhuyenMaiView> lstHDKMV = new ArrayList<>();
        String sql = "select km.TenKhuyenMai as tenKhuyenMai, km.ChietKhau as chietKhau from KhuyenMai as km inner join HoaDon as hd on km.IDKhuyenMai=hd.IDKhuyenMai where hd.stt = ?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, stt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonKhuyenMaiView hdkmv = new HoaDonKhuyenMaiView();
                hdkmv.setTenKhuyenMai(rs.getString("tenKhuyenMai"));
                hdkmv.setChietKhau(rs.getInt("chietKhau"));
                lstHDKMV.add(hdkmv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstHDKMV;
    }
}
