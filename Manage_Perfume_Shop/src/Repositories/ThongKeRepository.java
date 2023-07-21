/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Ultilities.DBConnection;
import ViewModels.ThongKeView;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author DELL
 */
public class ThongKeRepository {

    public ArrayList<ThongKeView> getListThongKeSP() {
        ArrayList<ThongKeView> lstTKV = new ArrayList<>();
        String sql = "select HoaDonChiTiet.IDSanPham as idSP, SanPham.TenSanPham as tenSP, SUM(HoaDonChiTiet.SoLuong) as 'soLuongdaBan', SanPham.SoLuongTon from HoaDonChiTiet inner join HoaDon\n"
                + "on HoaDonChiTiet.IDHoaDon = HoaDon.IDHoaDon inner join SanPham\n"
                + "on SanPham.IDSanPham = HoaDonChiTiet.IDSanPham\n"
                + "WHERE HoaDon.TrangThai = 1\n"
                + "group by HoaDonChiTiet.IDSanPham, SanPham.TenSanPham, SanPham.SoLuongTon";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongKeView tk = new ThongKeView();
                tk.setId(rs.getString("idSP"));
                tk.setTen(rs.getString("tenSP"));
                tk.setSoLuongDaBan(rs.getInt("soLuongdaBan"));
                tk.setSoLuonTon(rs.getInt("soLuongTon"));
                lstTKV.add(tk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstTKV;
    }

    public BigDecimal getListThongKeDT() {
        ArrayList<ThongKeView> lstTKV = new ArrayList<>();
        String sql = "select sum(TongTien) as doanhThu from HoaDon where TrangThai=1";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongKeView tk = new ThongKeView();
                tk.setDoanhThu(rs.getBigDecimal("doanhThu"));
                lstTKV.add(tk);
                if (tk.getDoanhThu() == null) {
                    return new BigDecimal(0);
                }
                return tk.getDoanhThu();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new BigDecimal(0);
    }

    public BigDecimal getListThongKeDTTheoNgay(java.util.Date tu, java.util.Date den) {
        ArrayList<ThongKeView> lstTKV = new ArrayList<>();
        String sql = "select sum(TongTien) as doanhThu from HoaDon where TrangThai=1 and NgayThem between ? and ?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, tu);
            ps.setObject(2, den);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongKeView tk = new ThongKeView();
                tk.setDoanhThu(rs.getBigDecimal("doanhThu"));
                lstTKV.add(tk);
                if (tk.getDoanhThu() == null) {
                    return new BigDecimal(0);
                }
                return tk.getDoanhThu();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new BigDecimal(0);
    }

    public ArrayList<ThongKeView> getListThongKeDTTheoTenSP(String tenSP) {
        ArrayList<ThongKeView> lstTKV = new ArrayList<>();
        String sql = "select sp.IDSanPham as idSP,sp.TenSanPham as tenSP, sum(SoLuong) as soLuongDaBan, sum(hdct.DonGia) as doanhThu, hd.TrangThai from HoaDonChiTiet as hdct inner join HoaDon as hd on hdct.IDHoaDon=hd.IDHoaDon\n"
                + "									inner join SanPham as sp on hdct.IDSanPham=sp.IDSanPham\n"
                + "where hd.TrangThai=1 and sp.TenSanPham like ?\n"
                + "group by sp.IDSanPham,sp.TenSanPham,SoLuong, hdct.DonGia, hd.TrangThai";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, tenSP);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongKeView tk = new ThongKeView();
                tk.setId(rs.getString("idSP"));
                tk.setTen(rs.getString("tenSP"));
                tk.setSoLuongDaBan(rs.getInt("soLuongdaBan"));
                tk.setDoanhThu(rs.getBigDecimal("doanhThu"));
                lstTKV.add(tk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstTKV;
    }

    public ArrayList<ThongKeView> getListThongKeSPTheoTenSP(String tenSP) {
        ArrayList<ThongKeView> lstTKV = new ArrayList<>();
        String sql = "select sp.IDSanPham as idSP,sp.TenSanPham as tenSP, sum(SoLuong) as soLuongDaBan, SoLuongTon, hd.TrangThai from HoaDonChiTiet as hdct inner join HoaDon as hd on hdct.IDHoaDon=hd.IDHoaDon\n"
                + "									inner join SanPham as sp on hdct.IDSanPham=sp.IDSanPham\n"
                + "where hd.TrangThai=1 and sp.TenSanPham like ?\n"
                + "group by sp.IDSanPham,sp.TenSanPham,SoLuong, SoLuongTon, hd.TrangThai";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, tenSP);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongKeView tk = new ThongKeView();
                tk.setId(rs.getString("idSP"));
                tk.setTen(rs.getString("tenSP"));
                tk.setSoLuongDaBan(rs.getInt("soLuongdaBan"));
                tk.setSoLuonTon(rs.getInt("SoLuongTon"));
                lstTKV.add(tk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstTKV;
    }

    public ArrayList<ThongKeView> getListThongKeSPTheoNgay(java.util.Date tu, java.util.Date den) {
        ArrayList<ThongKeView> lstTKV = new ArrayList<>();
        String sql = "select HoaDonChiTiet.IDSanPham as idSP, SanPham.TenSanPham as tenSP, SUM(HoaDonChiTiet.SoLuong) as 'soLuongdaBan', SanPham.SoLuongTon from HoaDonChiTiet inner join HoaDon\n"
                + "on HoaDonChiTiet.IDHoaDon = HoaDon.IDHoaDon inner join SanPham\n"
                + "on SanPham.IDSanPham = HoaDonChiTiet.IDSanPham\n"
                + "WHERE HoaDon.TrangThai = 1 and HoaDonChiTiet.NgayThem between ? and ?\n"
                + "group by HoaDonChiTiet.IDSanPham, SanPham.TenSanPham, SanPham.SoLuongTon";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, tu);
            ps.setObject(2, den);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongKeView tk = new ThongKeView();
                tk.setId(rs.getString("idSP"));
                tk.setTen(rs.getString("tenSP"));
                tk.setSoLuongDaBan(rs.getInt("soLuongdaBan"));
                tk.setSoLuonTon(rs.getInt("SoLuongTon"));
                lstTKV.add(tk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstTKV;
    }

}
