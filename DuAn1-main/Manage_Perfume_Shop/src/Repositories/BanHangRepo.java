/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.DanhMuc;
import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
import DomainModels.KhachHang;
import DomainModels.KhuyenMai;
import DomainModels.SanPham;
import Ultilities.DBConnection;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

/**
 *
 * @author Duc Toan
 */
public class BanHangRepo {

    public boolean taoHoaDOn(String idTaiKhoan) {
        String sql = "insert into HoaDon \n"
                + "values (newid(),?,default,null,null,GETDATE(),2,null,null)";
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, idTaiKhoan);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean taoHoaDonChiTiet(HoaDonChiTiet hoaDonChiTiet, String idHoaDon) {
        String sql = "insert into HoaDonChiTiet (IDHoaDon,IDSanPham,SoLuong,NgayThem,DonGia,TrangThai)\n"
                + "values (?,\n"
                + "?,?,GETDATE(),?,1)";
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, hoaDonChiTiet.getIdHoaDon());
            ps.setObject(2, hoaDonChiTiet.getIdSanPham());
            ps.setObject(3, hoaDonChiTiet.getSoLuong());
            ps.setObject(4, hoaDonChiTiet.getDonGia());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

//    public List<SanPham> getSanPham() {
//        List<SanPham> lstSanPham = new ArrayList<>();
//
//        String sql = "SELECT TenSanPham,IDDanhMuc,IDNhanHieu,IDNhomHuong,IDXuatXu,KichThuoc,GiaGiam \n" +
//"FROM SANPHAM where trangthai=1 or trangthai=0";
//        try (Connection conn = DBConnection.getConnection()) {
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                SanPham sanPham = new SanPham();
//                sanPham.setTenSanPham(rs.getString("tenSanPham"));
//                sanPham.setIdDanhMuc(rs.getString("IDDanhMuc"));
//                sanPham.setIdNhomHuong(rs.getString("IDNhomHuong"));
//                sanPham.setKichThuoc(rs.getInt("KichThuoc"));
//                sanPham.setIdNhanHieu(rs.getString("IDNhanHieu"));
//                sanPham.setIdXuatxu(rs.getString("IDXuatXu"));
//                sanPham.setGiaGiam(rs.getBigDecimal("giaGiam"));
//                
//                lstSanPham.add(sanPham);
//
//            }
//            return lstSanPham;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//    public List<SanPham> getSanPham(int start, int end) {
//        List<SanPham> lstSanPham = new ArrayList<>();
//
//        String sql = "SELECT * FROM ( \n"
//                + "  SELECT *, ROW_NUMBER() OVER (ORDER BY ngaythem) as row FROM sanpham \n"
//                + " ) a WHERE row >= ? and row <= ?";
//        try (Connection conn = DBConnection.getConnection()) {
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setObject(1, start);
//            ps.setObject(2, end);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                SanPham sanPham = new SanPham();
//                sanPham.setTenSanPham(rs.getString("tenSanPham"));
//                sanPham.setIdDanhMuc(rs.getString("IDDanhMuc"));
//                sanPham.setIdNhomHuong(rs.getString("IDNhomHuong"));
//                sanPham.setKichThuoc(rs.getInt("KichThuoc"));
//                sanPham.setIdNhanHieu(rs.getString("IDNhanHieu"));
//                sanPham.setIdXuatxu(rs.getString("IDXuatXu"));
//                sanPham.setGiaGiam(rs.getBigDecimal("giaGiam"));
//
//                lstSanPham.add(sanPham);
//
//            }
//            return lstSanPham;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
    public int getSoDong(String danhMuc, String nhanHieu, String nhomHuong, String xuatXu) {
        String sql = "select count(idsanpham) as soDong from SanPham\n"
                + "where (trangthai=1 or trangthai=0)";
        List<String> lstId = new ArrayList<>();
        lstId.add("IDDanhMuc");
        lstId.add("IDNhanHieu");
        lstId.add("IDNhomHuong");
        lstId.add("IDXuatXu");
        List<String> lstInputId = new ArrayList<>();
        lstInputId.add(danhMuc);
        lstInputId.add(nhanHieu);
        lstInputId.add(nhomHuong);
        lstInputId.add(xuatXu);
        List<String> lstInputIdNotEmpty = new ArrayList<>();
        List<Integer> lstIndex = new ArrayList<>();
        for (int i = 0; i < lstInputId.size(); i++) {
            if (lstInputId.get(i).isEmpty() == false) {
                lstInputIdNotEmpty.add(lstInputId.get(i));
                lstIndex.add(i);
            }
        }
        if (lstInputIdNotEmpty.size() == 1) {
            sql = sql + " AND "
                    + lstId.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'";

        } else if (lstInputIdNotEmpty.size() == 2) {
            sql = sql + " AND "
                    + lstId.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                    + " and " + lstId.get(lstIndex.get(1)) + "=" + "'" + lstInputIdNotEmpty.get(1) + "'";

        } else if (lstInputIdNotEmpty.size() == 3) {
            sql = sql + " AND "
                    + lstId.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                    + " and " + lstId.get(lstIndex.get(1)) + "=" + "'" + lstInputIdNotEmpty.get(1) + "'"
                    + " and " + lstId.get(lstIndex.get(2)) + "=" + "'" + lstInputIdNotEmpty.get(2) + "'";

        } else if (lstInputIdNotEmpty.size() == 4) {
            sql = sql + " AND "
                    + lstId.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                    + " and " + lstId.get(lstIndex.get(1)) + "=" + "'" + lstInputIdNotEmpty.get(1) + "'"
                    + " and " + lstId.get(lstIndex.get(2)) + "=" + "'" + lstInputIdNotEmpty.get(2) + "'"
                    + " and " + lstId.get(lstIndex.get(3)) + "=" + "'" + lstInputIdNotEmpty.get(3) + "'";

        }
        int soDong = 0;
        try (Connection conn = DBConnection.getConnection();) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                soDong = rs.getInt("soDong");
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return soDong;
    }

//    public List<HoaDonChiTiet> getHoaDonChiTiet() {
//        List<HoaDonChiTiet> lstHoaDonChiTiet = new ArrayList<>();
//
//        String sql = "select * from HoaDonChiTiet where IDHoaDon in (SELECT TOP 1 IDHoaDon FROM HoaDon ORDER BY STT DESC)";
//        try (Connection conn = DBConnection.getConnection()) {
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                HoaDonChiTiet HoaDonChiTiet = new HoaDonChiTiet();
//                HoaDonChiTiet.setDonGia(rs.getBigDecimal("donGia"));
//                HoaDonChiTiet.setIdHoaDon(rs.getString("IdHoaDon"));
//                HoaDonChiTiet.setIdSanPham(rs.getString("IdSanPham"));
//                HoaDonChiTiet.setNgaySua(rs.getString("NgaySua"));
//                HoaDonChiTiet.setNgayThem(rs.getString("NgayThem"));
//                HoaDonChiTiet.setSoLuong(rs.getInt("SoLuong"));
//                HoaDonChiTiet.setTrangThai(rs.getInt("TrangThai"));
//                HoaDonChiTiet.setDungTich(rs.getInt("kichThuoc"));
//                lstHoaDonChiTiet.add(HoaDonChiTiet);
//            }
//
//            return lstHoaDonChiTiet;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
    public List<HoaDonChiTiet> getHoaDonChiTietByIdHoaDon(String idHoaDon) {
        List<HoaDonChiTiet> lstHoaDonChiTiet = new ArrayList<>();

        String sql = "select donGia,IdSanPham,SoLuong from HoaDonChiTiet\n"
                + "where IDHoaDon=?";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, idHoaDon);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonChiTiet HoaDonChiTiet = new HoaDonChiTiet();
                HoaDonChiTiet.setDonGia(rs.getBigDecimal("donGia"));
                HoaDonChiTiet.setIdSanPham(rs.getString("IdSanPham"));
                HoaDonChiTiet.setSoLuong(rs.getInt("SoLuong"));

                lstHoaDonChiTiet.add(HoaDonChiTiet);
            }

            return lstHoaDonChiTiet;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<HoaDon> getHoaDonDaThanhToan(String idTaiKhoan) {
        List<HoaDon> lstHoaDon = new ArrayList<>();

        String sql = "select IdTaiKhoan,IdHoaDon,NgayThem,TenHoaDon,TongTien from HoaDon where TrangThai =1 and IdTaiKhoan = ? ORDER BY ngaythem desc";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, idTaiKhoan);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon HoaDon = new HoaDon();
                HoaDon.setIdTaiKhoan(rs.getString("IdTaiKhoan"));
                HoaDon.setIdHoaDon(rs.getString("IdHoaDon"));
                HoaDon.setNgayThem(rs.getString("NgayThem"));
                HoaDon.setTenHoaDon(rs.getString("TenHoaDon"));
                HoaDon.setTongTien(rs.getBigDecimal("TongTien"));
                lstHoaDon.add(HoaDon);
            }

            return lstHoaDon;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<HoaDon> getHoaDon() {
        List<HoaDon> lstHoaDon = new ArrayList<>();

        String sql = "select IdTaiKhoan,IdHoaDon,NgayThem,TenHoaDon,TongTien from HoaDon where TrangThai =2 ORDER BY ngaythem desc";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon HoaDon = new HoaDon();
                HoaDon.setIdTaiKhoan(rs.getString("IdTaiKhoan"));
                HoaDon.setIdHoaDon(rs.getString("IdHoaDon"));
                HoaDon.setNgayThem(rs.getString("NgayThem"));
                HoaDon.setTenHoaDon(rs.getString("TenHoaDon"));
                HoaDon.setTongTien(rs.getBigDecimal("TongTien"));
                lstHoaDon.add(HoaDon);
            }

            return lstHoaDon;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getDungTich(String idSanPham) {
        String sql = "select KichThuoc from SanPham where IDSanPham=?";
        int dungTich = 0;
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, idSanPham);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dungTich = rs.getInt("KichThuoc");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dungTich;
    }

    public String getIdKhachHang(String sdt) {
        String sql = "select idKhachHang from KhachHang where soDienThoai=?";
        String idKhachHang = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, sdt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                idKhachHang = rs.getString("idKhachHang");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idKhachHang;
    }

    public boolean deleteHoaDonChiTiet(String idSanPham, String idHoaDon) {
        String sql = "delete HoaDonChiTiet\n"
                + "where IDHoaDon =? and IDSanPham=? ";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, idHoaDon);
            ps.setObject(2, idSanPham);
            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getTenNhomHuong(String idNhomHuong) {
        String sql = "SELECT tenNhomHuong from NhomHuong WHERE idNhomHuong = ?";
        String tenNhomHuong = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, idNhomHuong);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tenNhomHuong = rs.getString("tenNhomHuong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tenNhomHuong;
    }

    public String getTenNhanHieu(String idNhanHieu) {
        String sql = "SELECT tenNhanHieu from NhanHieu WHERE idNhanHieu = ?";
        String tenNhanHieu = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, idNhanHieu);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tenNhanHieu = rs.getString("tenNhanHieu");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tenNhanHieu;
    }

    public String getTenDanhMuc(String idDanhMuc) {
        String sql = "SELECT tenDanhMuc from DANHMUC WHERE idDanhMuc = ?";
        String tenDanhMuc = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, idDanhMuc);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tenDanhMuc = rs.getString("tenDanhMuc");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tenDanhMuc;
    }

    public String getTenXuatXu(String idXuatXu) {
        String sql = "SELECT tenXuatXu from XuatXu WHERE idXuatXu = ?";
        String tenXuatXu = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, idXuatXu);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tenXuatXu = rs.getString("tenXuatXu");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tenXuatXu;
    }

    public String getTenSanPham(String idSanPham) {
        String sql = "SELECT TenSanPham from SanPham WHERE idSanPham = ?";
        String tenNhomHuong = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, idSanPham);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tenNhomHuong = rs.getString("TenSanPham");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tenNhomHuong;
    }

    public List<String> getDanhMuc() {
        List<String> lstDanhMuc = new ArrayList<>();
        String sql = "select * from danhmuc where TrangThai = 1";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lstDanhMuc.add(rs.getString("Tendanhmuc"));
            }
            return lstDanhMuc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getNhomHuong() {
        List<String> lstHuong = new ArrayList<>();
        String sql = "select * from nhomHuong where TrangThai =1";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lstHuong.add(rs.getString("TennhomHuong"));
            }
            return lstHuong;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getNhanHieu() {
        List<String> lstNhanHieu = new ArrayList<>();
        String sql = "select * from nhanhieu where TrangThai =1";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lstNhanHieu.add(rs.getString("Tennhanhieu"));
            }
            return lstNhanHieu;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getXuatXu() {
        List<String> lstXuatXu = new ArrayList<>();
        String sql = "select * from XuatXu where TrangThai =1";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lstXuatXu.add(rs.getString("TenXuatXu"));
            }
            return lstXuatXu;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//    public ArrayList<SanPham> findSanPham(String danhMuc, String nhanHieu, String nhomHuong, String xuatXu) {
//        String sql = "SELECT TenSanPham,IDDanhMuc,IDNhanHieu,IDNhomHuong,IDXuatXu,KichThuoc,GiaGiam,SoLuongTrongKho \n" +
//"FROM SANPHAM where (trangthai=1 or trangthai=0)";
//        List<String> lstId = new ArrayList<>();
//        lstId.add("IDDanhMuc");
//        lstId.add("IDNhanHieu");
//        lstId.add("IDNhomHuong");
//        lstId.add("IDXuatXu");
//        List<String> lstInputId = new ArrayList<>();
//        lstInputId.add(danhMuc);
//        lstInputId.add(nhanHieu);
//        lstInputId.add(nhomHuong);
//        lstInputId.add(xuatXu);
//        List<String> lstInputIdNotEmpty = new ArrayList<>();
//        List<Integer> lstIndex = new ArrayList<>();
//        for (int i = 0; i < lstInputId.size(); i++) {
//            if (lstInputId.get(i).isEmpty() == false) {
//                lstInputIdNotEmpty.add(lstInputId.get(i));
//                lstIndex.add(i);
//            }
//        }
//        if (lstInputIdNotEmpty.size() == 1) {
//            sql = sql + " AND "
//                    + lstId.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
//                    + " order by NgayThem desc";
//        } else if (lstInputIdNotEmpty.size() == 2) {
//            sql = sql + " AND "
//                    + lstId.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
//                    + " and " + lstId.get(lstIndex.get(1)) + "=" + "'" + lstInputIdNotEmpty.get(1) + "'"
//                    + " order by NgayThem desc";
//        } else if (lstInputIdNotEmpty.size() == 3) {
//            sql = sql + " AND "
//                    + lstId.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
//                    + " and " + lstId.get(lstIndex.get(1)) + "=" + "'" + lstInputIdNotEmpty.get(1) + "'"
//                    + " and " + lstId.get(lstIndex.get(2)) + "=" + "'" + lstInputIdNotEmpty.get(2) + "'"
//                    + " order by NgayThem desc";
//        } else if (lstInputIdNotEmpty.size() == 4) {
//            sql = sql + " AND "
//                    + lstId.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
//                    + " and " + lstId.get(lstIndex.get(1)) + "=" + "'" + lstInputIdNotEmpty.get(1) + "'"
//                    + " and " + lstId.get(lstIndex.get(2)) + "=" + "'" + lstInputIdNotEmpty.get(2) + "'"
//                    + " and " + lstId.get(lstIndex.get(3)) + "=" + "'" + lstInputIdNotEmpty.get(3) + "'"
//                    + " order by NgayThem desc";
//        }
//        System.out.println(sql);
//        ArrayList<SanPham> lstSanPham = new ArrayList<>();
//        try (Connection conn = DBConnection.getConnection();) {
//
//            System.out.println(sql);
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                SanPham sanPham = new SanPham();
//                sanPham.setTenSanPham(rs.getString("tenSanPham"));
//                sanPham.setIdDanhMuc(rs.getString("IDDanhMuc"));
//                sanPham.setIdNhomHuong(rs.getString("IDNhomHuong"));
//                sanPham.setKichThuoc(rs.getInt("KichThuoc"));
//                sanPham.setIdNhanHieu(rs.getString("IDNhanHieu"));
//                sanPham.setIdXuatxu(rs.getString("IDXuatXu"));
//                sanPham.setGiaGiam(rs.getBigDecimal("giaGiam"));
//                sanPham.setSoLuongTrongKho(rs.getInt("SoLuongTrongKho"));
//                lstSanPham.add(sanPham);
//            }
//            ps.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return lstSanPham;
//
//    }
    public ArrayList<SanPham> findSanPham(String danhMuc, String nhanHieu, String nhomHuong, String xuatXu, int start, int end) {
        String sql = "SELECT * FROM ( \n"
                + " SELECT  * , ROW_NUMBER() OVER (ORDER BY ngaythem) as row  FROM sanpham where (trangthai=1 or trangthai=0) \n"
                + ") a WHERE ((row >= ? and row <= ?) )  ";
        String p1 = "SELECT * FROM ( \n"
                + "SELECT  * , ROW_NUMBER() OVER (ORDER BY ngaythem) as row  FROM sanpham where (trangthai=1 or trangthai=0) ";
        String p2 = " ) a WHERE ((row >= ? and row <= ?) ) ";
        List<String> lstId = new ArrayList<>();
        lstId.add("IDDanhMuc");
        lstId.add("IDNhanHieu");
        lstId.add("IDNhomHuong");
        lstId.add("IDXuatXu");
        List<String> lstInputId = new ArrayList<>();
        lstInputId.add(danhMuc);
        lstInputId.add(nhanHieu);
        lstInputId.add(nhomHuong);
        lstInputId.add(xuatXu);
        List<String> lstInputIdNotEmpty = new ArrayList<>();
        List<Integer> lstIndex = new ArrayList<>();
        for (int i = 0; i < lstInputId.size(); i++) {
            if (lstInputId.get(i).isEmpty() == false) {
                lstInputIdNotEmpty.add(lstInputId.get(i));
                lstIndex.add(i);
            }
        }
        if (lstInputIdNotEmpty.size() == 1) {
            sql = p1 + " AND "
                    + lstId.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                    + p2;
        } else if (lstInputIdNotEmpty.size() == 2) {
            sql = p1 + " AND "
                    + lstId.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                    + " and " + lstId.get(lstIndex.get(1)) + "=" + "'" + lstInputIdNotEmpty.get(1) + "'"
                    + p2;
        } else if (lstInputIdNotEmpty.size() == 3) {
            sql = p1 + " AND "
                    + lstId.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                    + " and " + lstId.get(lstIndex.get(1)) + "=" + "'" + lstInputIdNotEmpty.get(1) + "'"
                    + " and " + lstId.get(lstIndex.get(2)) + "=" + "'" + lstInputIdNotEmpty.get(2) + "'"
                    + p2;
        } else if (lstInputIdNotEmpty.size() == 4) {
            sql = p1 + " AND "
                    + lstId.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                    + " and " + lstId.get(lstIndex.get(1)) + "=" + "'" + lstInputIdNotEmpty.get(1) + "'"
                    + " and " + lstId.get(lstIndex.get(2)) + "=" + "'" + lstInputIdNotEmpty.get(2) + "'"
                    + " and " + lstId.get(lstIndex.get(3)) + "=" + "'" + lstInputIdNotEmpty.get(3) + "'"
                    + p2;
        }
        ArrayList<SanPham> lstSanPham = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, start);
            ps.setObject(2, end);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sanPham = new SanPham();
                sanPham.setTenSanPham(rs.getString("tenSanPham"));
                sanPham.setIdDanhMuc(rs.getString("IDDanhMuc"));
                sanPham.setIdNhomHuong(rs.getString("IDNhomHuong"));
                sanPham.setKichThuoc(rs.getInt("KichThuoc"));
                sanPham.setIdNhanHieu(rs.getString("IDNhanHieu"));
                sanPham.setIdXuatxu(rs.getString("IDXuatXu"));
                sanPham.setGiaGiam(rs.getBigDecimal("giaGiam"));
               
                lstSanPham.add(sanPham);
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstSanPham;

    }

    public String getIDDanhMuc(String tenDanhMuc) {
        String sql = "SELECT IDDanhMuc from DANHMUC WHERE TenDanhMuc = ?";
        String idDanhMuc = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, tenDanhMuc);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                idDanhMuc = rs.getString("IDDanhMuc");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idDanhMuc;
    }

    public String getIDNhomHuong(String tenNhomHuong) {
        String sql = "SELECT IDNhomHuong from NhomHuong WHERE TenNhomHuong = ?";
        String idNhomHuong = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, tenNhomHuong);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                idNhomHuong = rs.getString("IDNhomHuong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idNhomHuong;
    }

    public String getIDNhanHieu(String tenNhanHieu) {
        String sql = "SELECT IDNhanHieu from NhanHieu WHERE TenNhanHieu = ?";
        String idNhanHieu = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, tenNhanHieu);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                idNhanHieu = rs.getString("IDNhanHieu");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idNhanHieu;
    }

    public String getIDXuatXu(String tenXuatXu) {
        String sql = "SELECT IDXuatXu from XuatXu WHERE TenXuatXu = ?";
        String idXuatXu = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, tenXuatXu);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                idXuatXu = rs.getString("IDXuatXu");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idXuatXu;
    }

    public String getIDSanPham(String tenSanPham, int dungTich) {
        String sql = "SELECT IDSanPham from SanPham WHERE TenSanPham = ? and KichThuoc = ? and trangThai =1";
        String idSanPham = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, tenSanPham);
            ps.setObject(2, dungTich);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                idSanPham = rs.getString("IDSanPham");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idSanPham;
    }

    public String getEmail(String idTaiKhoan) {
        String sql = "SELECT email from taiKhoan WHERE idTaiKhoan = ?";
        String email = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, idTaiKhoan);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                email = rs.getString("email");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return email;
    }

    public int getSoLuongTon(String idSanPham) {
        String sql = "select SoLuongTon from SanPham\n"
                + "where IDSanPham = ?";
        int soLuongTon = 0;
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, idSanPham);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                soLuongTon = rs.getInt("SoLuongTon");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return soLuongTon;
    }

    public boolean updateHoaDonChiTiet(int soLuong, String idHoaDon, String idSanPham) {
        String sql = "update HoaDonChiTiet\n"
                + "set SoLuong = SoLuong + ?\n"
                + "where IDSanPham= ? and IDHoaDon = ?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, soLuong);
            ps.setObject(2, idSanPham);
            ps.setObject(3, idHoaDon);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateHoaDon(HoaDon hd) {
        String sql = "update HoaDon set TongTien=?, GhiChu=?, TrangThai=?, IDKhachHang=? where IDHoaDon=?";
        try (Connection con = DBConnection.getConnection() ) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, hd.getTongTien());
            ps.setObject(2, hd.getGhiChu());
            ps.setObject(3, hd.getTinhTrang());
            ps.setObject(4, hd.getIdKhachHang());
            ps.setObject(5, hd.getIdHoaDon());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Date getNgayThem(String idHoaDon) {
        String sql = "SELECT NgayThem From HoaDon WHERE IdHoadon = ?";
        Date ngayThem = new Date(0);
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, idHoaDon);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ngayThem = rs.getDate("NgayThem");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ngayThem;
    }

    public BigDecimal getTongTien(String idHoaDon) {
        String sql = "SELECT TongTien from HoaDon WHERE IdHoaDon = ?";
        BigDecimal tongTien = new BigDecimal(0);
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, idHoaDon);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                tongTien = rs.getBigDecimal("TongTien");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tongTien;
    }

    public int getSoLuongFromHoaDonChiTiet(String idHoaDon, String idSanPham) {
        String sql = "select SoLuong from HoaDonChiTiet\n"
                + "where IDHoaDon = ? and IDSanPham = ?";
        int soLuong = 0;
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, idHoaDon);
            ps.setObject(2, idSanPham);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                soLuong = rs.getInt("SoLuong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return soLuong;
    }

    public boolean updateKhuyenMai(HoaDon hd) {
        String sql = "update HoaDon set IDKhuyenMai=? where IDHoaDon=?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, hd.getIdKhuyenMai());
            ps.setObject(2, hd.getIdHoaDon());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getKHByPhone(String phoneNumber) {
        String sql = "SELECT HoTen From KhachHang WHERE SoDienThoai = ?";
        String hoTen = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, phoneNumber);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                hoTen = rs.getString("HoTen");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hoTen;
    }

    public String getTenByIDNV(String idNV) {
        String sql = "SELECT HoTen From TaiKhoan WHERE IDTaiKhoan = ? and TrangThai = 1";
        String hoTen = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, idNV);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                hoTen = rs.getString("HoTen");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hoTen;
    }
    
    public String getKMBIDHD(String idHoaDon){
        String sql = "Select IDKhuyenMai FROM HoaDon WHERE IDHoaDon = ?";
        String idKhuyenMai = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setObject(1, idHoaDon);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                idKhuyenMai = rs.getString("IDKhuyenMai");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idKhuyenMai;
    }
    
    public ArrayList<KhuyenMai> getThongTinKM(String idKhuyenMai){
        String sql = "SELECT * FROM KhuyenMai WHERE IDKhuyenMai = ?";
        ArrayList<KhuyenMai> listKM = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setObject(1, idKhuyenMai);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                KhuyenMai km = new KhuyenMai();
                km.setTenKhuyenMai(rs.getString("TenKhuyenMai"));
                km.setChietKhau(rs.getInt("ChietKhau"));
                listKM.add(km);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKM;
    }
}
