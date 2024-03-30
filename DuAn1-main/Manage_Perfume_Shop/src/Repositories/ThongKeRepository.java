/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Ultilities.DBConnection;
import ViewModels.SanPhamView;
import ViewModels.TaiKhoanViews;
import ViewModels.ThongKeView;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author DELL
 */
public class ThongKeRepository {

//    public ArrayList<ThongKeView> getListThongKeSP() {
//        ArrayList<ThongKeView> lstTKV = new ArrayList<>();
//        String sql = "select HoaDonChiTiet.IDSanPham as idSP, SanPham.TenSanPham as tenSP, SUM(HoaDonChiTiet.SoLuong) as 'soLuongdaBan', SanPham.SoLuongTon from HoaDonChiTiet inner join HoaDon\n"
//                + "on HoaDonChiTiet.IDHoaDon = HoaDon.IDHoaDon inner join SanPham\n"
//                + "on SanPham.IDSanPham = HoaDonChiTiet.IDSanPham\n"
//                + "WHERE HoaDon.TrangThai = 1\n"
//                + "group by HoaDonChiTiet.IDSanPham, SanPham.TenSanPham, SanPham.SoLuongTon order by SanPham.SoLuongTon asc";
//        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                ThongKeView tk = new ThongKeView();
//                tk.setId(rs.getString("idSP"));
//                tk.setTen(rs.getString("tenSP"));
//                tk.setSoLuongDaBan(rs.getInt("soLuongdaBan"));
//                tk.setSoLuonTon(rs.getInt("soLuongTon"));
//                lstTKV.add(tk);
//
//            }
//            int a=0;
//            for (ThongKeView thongKeView : lstTKV) {
//                thongKeView.getId();
//                a++;
//            }
//            System.out.println("a = " + a  );
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return lstTKV;
//    }
    public ArrayList<ThongKeView> getListThongKeSP() {
        ArrayList<ThongKeView> lstTKV = new ArrayList<>();
        String sql = "select sp.TenSanPham as tenSP, sp.KichThuoc as dungTich, sum(hdct.SoLuong) as soLuongDaBan from HoaDonChiTiet as hdct inner join SanPham as sp on hdct.IDSanPham=sp.IDSanPham inner join HoaDon as hd on hdct.IDHoaDon=hd.IDHoaDon\n"
                + "where hd.TrangThai=1 \n"
                + "group by hdct.IDSanPham, sp.TenSanPham, sp.KichThuoc";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongKeView tk = new ThongKeView();
                tk.setTen(rs.getString("tenSP"));
                tk.setDungTich(rs.getInt("dungTich"));
                tk.setSoLuongDaBan(rs.getInt("soLuongDaBan"));
                lstTKV.add(tk);

            }
            int a = 0;
            for (ThongKeView thongKeView : lstTKV) {
                thongKeView.getId();
                a++;
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

    public BigDecimal getListThongKeDTTheoNgay(String tu, String den) {
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
        String sql = "select sp.TenSanPham as tenSP, sp.KichThuoc as dungTich, sum(hdct.SoLuong) as soLuongDaBan from HoaDonChiTiet as hdct inner join SanPham as sp on hdct.IDSanPham=sp.IDSanPham inner join HoaDon as hd on hdct.IDHoaDon=hd.IDHoaDon\n"
                + "where hd.TrangThai=1 and sp.TenSanPham like ?\n"
                + "group by hdct.IDSanPham, sp.TenSanPham, sp.KichThuoc";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, tenSP);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongKeView tk = new ThongKeView();
                tk.setTen(rs.getString("tenSP"));
                tk.setDungTich(rs.getInt("dungTich"));
                tk.setSoLuongDaBan(rs.getInt("soLuongdaBan"));
                lstTKV.add(tk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstTKV;
    }

    public ArrayList<ThongKeView> getListThongKeSPTheoNgay(String tu, String den) {
        ArrayList<ThongKeView> lstTKV = new ArrayList<>();
        String sql = "select sp.TenSanPham as tenSP, sp.KichThuoc as dungTich, sum(hdct.SoLuong) as soLuongDaBan from HoaDonChiTiet as hdct inner join SanPham as sp on hdct.IDSanPham=sp.IDSanPham inner join HoaDon as hd on hdct.IDHoaDon=hd.IDHoaDon\n"
                + "where hd.TrangThai=1 and hdct.NgayThem between ? and ?\n"
                + "group by hdct.IDSanPham, sp.TenSanPham, sp.KichThuoc";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, tu);
            ps.setObject(2, den);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongKeView tk = new ThongKeView();
                tk.setTen(rs.getString("tenSP"));
                tk.setDungTich(rs.getInt("dungTich"));
                tk.setSoLuongDaBan(rs.getInt("soLuongDaBan"));
                lstTKV.add(tk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstTKV;
    }

    public ArrayList<ThongKeView> getAllThongKeNV(String idNhanVien) {
        String sql = "SELECT SUM(HoaDonChiTiet.SoLuong) as SoLuongDaBan, SanPham.TenSanPham, SanPham.KichThuoc FROM HoaDonChiTiet INNER JOIN HoaDon on HoaDonChiTiet.IDHoaDon = HoaDon.IDHoaDon INNER JOIN SanPham on HoaDonChiTiet.IDSanPham = SanPham.IDSanPham\n"
                + "                WHERE (HoaDon.TrangThai = 1 ) and idTaiKhoan=?\n"
                + "                GROUP BY SanPham.TenSanPham, SanPham.KichThuoc";
        ArrayList<ThongKeView> listThongKe = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, idNhanVien);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongKeView thongKeView = new ThongKeView();
                thongKeView.setTen(rs.getString("TenSanPham"));
                thongKeView.setDungTich(rs.getInt("KichThuoc"));
                thongKeView.setSoLuongDaBan(rs.getInt("SoLuongDaBan"));
                listThongKe.add(thongKeView);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listThongKe;
    }

    public String getNhanHieuById(String idNhanHieu) {
        String sql = "SELECT TenNhanHieu FROM NhanHieu WHERE IdNhanHieu = ?";
        String tenNhanHieu = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, idNhanHieu);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                tenNhanHieu = rs.getString("TenNhanHieu");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tenNhanHieu;
    }

    public ArrayList<ThongKeView> getAllThongKeNVByDate(String tu, String den, String idNhanVien) {
        String sql = "SELECT SUM(HoaDonChiTiet.SoLuong) as SoLuongDaBan, SanPham.TenSanPham, SanPham.KichThuoc FROM HoaDonChiTiet INNER JOIN HoaDon on HoaDonChiTiet.IDHoaDon = HoaDon.IDHoaDon INNER JOIN SanPham on HoaDonChiTiet.IDSanPham = SanPham.IDSanPham\n"
                + "WHERE HoaDon.TrangThai = 1 and HoaDon.NgayThem between ? and ? and idTaiKhoan=?\n"
                + "GROUP BY SanPham.TenSanPham, SanPham.KichThuoc";
        ArrayList<ThongKeView> listThongKe = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, tu);
            ps.setObject(2, den);
            ps.setObject(3, idNhanVien);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongKeView thongKeView = new ThongKeView();
                thongKeView.setTen(rs.getString("TenSanPham"));
                thongKeView.setDungTich(rs.getInt("KichThuoc"));
                thongKeView.setSoLuongDaBan(rs.getInt("SoLuongDaBan"));
                listThongKe.add(thongKeView);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listThongKe;
    }

    public ArrayList<ThongKeView> getDataBieuDo() {
        String sql = "select sum(TongTien) as N'Tổng Tiền', MONTH(NgayThem) as 'Thang' from HoaDon\n"
                + "WHERE MONTH(NgayThem) <= 12 and YEAR(NgayThem) = YEAR(GETDATE())\n"
                + "GROUP BY MONTH(NgayThem)";
        ArrayList<ThongKeView> listData = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongKeView thongKeView = new ThongKeView();
                thongKeView.setThang(rs.getInt("Thang"));
                thongKeView.setDoanhThu(rs.getBigDecimal("Tổng Tiền"));
                listData.add(thongKeView);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    public ArrayList<ThongKeView> getListSoLuongTon() {
        ArrayList<ThongKeView> lstTKV = new ArrayList<>();
        String sql = "select TenSanPham, KichThuoc, SoLuongTon, SoLuongTrongKho from SanPham where trangThai = 1 or trangThai = 0";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongKeView tkv = new ThongKeView();
                tkv.setTen(rs.getString("TenSanPham"));
                tkv.setDungTich(rs.getInt("KichThuoc"));
                tkv.setSoLuonTon(rs.getInt("SoLuongTon"));
                tkv.setSoLuongTrongKho(rs.getInt("SoLuongTrongKho"));
                lstTKV.add(tkv);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstTKV;
    }
}
