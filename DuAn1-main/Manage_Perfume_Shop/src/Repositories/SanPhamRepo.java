/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.SanPham;
import Ultilities.DBConnection;
import ViewModels.SanPhamView;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Duc Toan
 */
public class SanPhamRepo {

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

    public boolean addSanPham(SanPham sanPham) {
        String sql = "insert into SanPham (IDSanPham,TenSanPham,IDDanhMuc,IDNhomHuong,KichThuoc,IDNhanHieu,IDXuatXu,MoTa,GiaGoc,GiaGiam,soLuongTon,\n"
                + "NgayThem,NgaySua,TrangThai,ChietKhau,imageurl,SoLuongTrongKho)  values \n"
                + "(newid(),\n"
                + "?,\n"
                + "?,\n"
                + "?,\n"
                + "?,\n"
                + "?,\n"
                + "?,\n"
                + "?,\n"
                + "?,\n"
                + "? - (? * ? / 100),\n"
                + "?,\n"
                + "getdate(),\n"
                + "NULL,\n"
                + "?,\n"
                + "?,\n"
                + "?,\n"
                + "?)";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, sanPham.getTenSanPham());
            ps.setObject(2, sanPham.getIdDanhMuc());
            ps.setObject(3, sanPham.getIdNhomHuong());
            ps.setObject(4, sanPham.getKichThuoc());
            ps.setObject(5, sanPham.getIdNhanHieu());
            ps.setObject(6, sanPham.getIdXuatxu());
            ps.setObject(7, sanPham.getMoTa());
            ps.setObject(8, sanPham.getGiaGoc());
            ps.setObject(9, sanPham.getGiaGoc());
            ps.setObject(10, sanPham.getGiaGoc());
            ps.setObject(11, sanPham.getChietKhau());
            ps.setObject(12, 0);
            ps.setObject(13, sanPham.getTinhTrang());
            ps.setObject(14, sanPham.getChietKhau());
            ps.setObject(15, sanPham.getImageUrl());
            ps.setObject(16, sanPham.getSoLuongTrongKho());
            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

//    public List<SanPham> getSanPham() {
//        List<SanPham> lstSanPham = new ArrayList<>();
//
//        String sql = "SELECT * FROM SANPHAM where trangThai =1 or trangThai=0 order by ngayThem desc";
//        try (Connection conn = DBConnection.getConnection()) {
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                SanPham sanPham = new SanPham();
//                sanPham.setIdSanPham(rs.getString("idSanPham"));
//                sanPham.setTenSanPham(rs.getString("tenSanPham"));
//                sanPham.setIdDanhMuc(rs.getString("IDDanhMuc"));
//                sanPham.setIdNhomHuong(rs.getString("IDNhomHuong"));
//                sanPham.setKichThuoc(rs.getInt("KichThuoc"));
//                sanPham.setIdNhanHieu(rs.getString("IDNhanHieu"));
//                sanPham.setIdXuatxu(rs.getString("IDXuatXu"));
//                sanPham.setMoTa(rs.getString("moTa"));
//                sanPham.setGiaGoc(rs.getBigDecimal("giagoc"));
//                sanPham.setGiaGiam(rs.getBigDecimal("giaGiam"));
//                sanPham.setSoLuongTon(rs.getInt("soLuongTon"));
//                sanPham.setNgayThem(rs.getString("ngayThem"));
//                sanPham.setNgaySua(rs.getString("ngaySua"));
//                sanPham.setTinhTrang(rs.getInt("trangThai"));
////                sanPham.setIdKhuyenMai(rs.getString("IDKhuyenMai"));
//                sanPham.setChietKhau(rs.getInt("chietkhau"));
//                sanPham.setImageUrl(rs.getString("imageUrl"));
//                lstSanPham.add(sanPham);
//            }
//            return lstSanPham;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
    public List<SanPham> getSanPhamByIndex(int index) {
        List<SanPham> lstSanPham = new ArrayList<>();
        String top = " top " + index;
        String sql = "SELECT" + top + " * FROM SANPHAM where trangThai =1 or trangThai=0 order by NgayThem desc";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sanPham = new SanPham();
                sanPham.setIdSanPham(rs.getString("idSanPham"));
                sanPham.setTenSanPham(rs.getString("tenSanPham"));
                sanPham.setIdDanhMuc(rs.getString("IDDanhMuc"));
                sanPham.setIdNhomHuong(rs.getString("IDNhomHuong"));
                sanPham.setKichThuoc(rs.getInt("KichThuoc"));
                sanPham.setIdNhanHieu(rs.getString("IDNhanHieu"));
                sanPham.setIdXuatxu(rs.getString("IDXuatXu"));
                sanPham.setMoTa(rs.getString("moTa"));
                sanPham.setGiaGoc(rs.getBigDecimal("giagoc"));
                sanPham.setGiaGiam(rs.getBigDecimal("giaGiam"));
                sanPham.setSoLuongTon(rs.getInt("soLuongTon"));
                sanPham.setNgayThem(rs.getString("ngayThem"));
                sanPham.setNgaySua(rs.getString("ngaySua"));
                sanPham.setTinhTrang(rs.getInt("trangThai"));
//                sanPham.setIdKhuyenMai(rs.getString("IDKhuyenMai"));
                sanPham.setChietKhau(rs.getInt("chietkhau"));
                sanPham.setImageUrl(rs.getString("imageUrl"));
                lstSanPham.add(sanPham);
            }
            return lstSanPham;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateSanPham(SanPham sanPham) {
        String sql = "{CALL updateSanPham(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try (Connection conn = DBConnection.getConnection()) {
            CallableStatement cs = conn.prepareCall(sql);
            cs.setObject(1, sanPham.getIdSanPham());
            cs.setObject(2, sanPham.getTenSanPham());
            cs.setObject(3, sanPham.getIdDanhMuc());
            cs.setObject(4, sanPham.getIdNhomHuong());
            cs.setObject(5, sanPham.getKichThuoc());
            cs.setObject(6, sanPham.getIdNhanHieu());
            cs.setObject(7, sanPham.getIdXuatxu());
            cs.setObject(8, sanPham.getMoTa());
            cs.setObject(9, sanPham.getGiaGoc());
            cs.setObject(10, 0);
            cs.setObject(11, sanPham.getTinhTrang());
            cs.setObject(12, sanPham.getChietKhau());
            cs.setObject(13, sanPham.getImageUrl());

            int result = cs.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteSanPham(String idSanPham) {
        String sql = "update SanPham \n"
                + "set TrangThai=2\n"
                + "where IDSanPham =?";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, idSanPham);
            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<SanPham> findSanPham(String danhMuc, String nhanHieu, String nhomHuong, String xuatXu, int start, int end) {
        String sql = "SELECT * FROM ( \n"
                + "SELECT  * , ROW_NUMBER() OVER (ORDER BY ngaythem desc) as row  FROM SanPham where (TrangThai = 1 OR TrangThai=0)\n"
                + ") a WHERE ((row >= ? and row <= ?) ) ";
        String p1 = "SELECT * FROM ( \n"
                + "SELECT  * , ROW_NUMBER() OVER (ORDER BY ngaythem desc) as row  FROM SanPham where (TrangThai = 1 OR TrangThai=0) and ";
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
            sql = p1
                    + lstId.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                    + p2;
        } else if (lstInputIdNotEmpty.size() == 2) {
            sql = p1
                    + lstId.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                    + " and " + lstId.get(lstIndex.get(1)) + "=" + "'" + lstInputIdNotEmpty.get(1) + "'"
                    + p2;
        } else if (lstInputIdNotEmpty.size() == 3) {
            sql = p1
                    + lstId.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                    + " and " + lstId.get(lstIndex.get(1)) + "=" + "'" + lstInputIdNotEmpty.get(1) + "'"
                    + " and " + lstId.get(lstIndex.get(2)) + "=" + "'" + lstInputIdNotEmpty.get(2) + "'"
                    + p2;
        } else if (lstInputIdNotEmpty.size() == 4) {
            sql = p1
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
                sanPham.setIdSanPham(rs.getString("idSanPham"));
                sanPham.setTenSanPham(rs.getString("tenSanPham"));
                sanPham.setIdDanhMuc(rs.getString("IDDanhMuc"));
                sanPham.setIdNhomHuong(rs.getString("IDNhomHuong"));
                sanPham.setKichThuoc(rs.getInt("KichThuoc"));
                sanPham.setIdNhanHieu(rs.getString("IDNhanHieu"));
                sanPham.setIdXuatxu(rs.getString("IDXuatXu"));
                sanPham.setMoTa(rs.getString("moTa"));
                sanPham.setGiaGoc(rs.getBigDecimal("giagoc"));
                sanPham.setGiaGiam(rs.getBigDecimal("giaGiam"));
                sanPham.setSoLuongTon(rs.getInt("soLuongTon"));
                sanPham.setNgayThem(rs.getString("ngayThem"));
                sanPham.setNgaySua(rs.getString("ngaySua"));
                sanPham.setTinhTrang(rs.getInt("trangThai"));
                sanPham.setChietKhau(rs.getInt("chietkhau"));
                sanPham.setImageUrl(rs.getString("imageUrl"));
                lstSanPham.add(sanPham);
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstSanPham;

    }

    public int getSoDong(String danhMuc, String nhanHieu, String nhomHuong, String xuatXu) {
        String sql = "SELECT count(idSanPham) as soDong FROM SANPHAM where (TrangThai = 1 OR TrangThai=0)";
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
            sql = sql + " and "
                    + lstId.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'";

        } else if (lstInputIdNotEmpty.size() == 2) {
            sql = sql + " and "
                    + lstId.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                    + " and " + lstId.get(lstIndex.get(1)) + "=" + "'" + lstInputIdNotEmpty.get(1) + "'";

        } else if (lstInputIdNotEmpty.size() == 3) {
            sql = sql + " and "
                    + lstId.get(lstIndex.get(0)) + "=" + "'" + lstInputIdNotEmpty.get(0) + "'"
                    + " and " + lstId.get(lstIndex.get(1)) + "=" + "'" + lstInputIdNotEmpty.get(1) + "'"
                    + " and " + lstId.get(lstIndex.get(2)) + "=" + "'" + lstInputIdNotEmpty.get(2) + "'";

        } else if (lstInputIdNotEmpty.size() == 4) {
            sql = sql + " and "
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

    public String getIDSanPham(String tenSanPham, int dungTich) {

        String sql = "SELECT IDSanPham from SanPham WHERE TenSanPham = ? and KichThuoc = ? and (trangThai =1 or trangThai =0)";
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

    public String getIDKhuyenMai(String tenKhuyenMai) {
        String sql = "SELECT IDKhuyenMai from KhuyenMai WHERE TenKhuyenMai = ?";
        String idKhuyenMai = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, tenKhuyenMai);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                idKhuyenMai = rs.getString("IDKhuyenMai");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idKhuyenMai;
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

    public String getTenKhuyenMai(String idKhuyenMai) {
        String sql = "SELECT tenKhuyenMai from KhuyenMai WHERE idKhuyenMai = ?";
        String tenKhuyenMai = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, idKhuyenMai);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tenKhuyenMai = rs.getString("tenKhuyenMai");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tenKhuyenMai;
    }

    public boolean setDanhMucNone(String idDanhMuc) {
        String sql = " update SanPham\n"
                + "set IDDanhMuc = (SELECT IDDanhMuc FROM DanhMuc WHERE TenDanhMuc=N'NONE')\n"
                + "where IDDanhMuc = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, idDanhMuc);
            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean setNhanHieuNone(String idNhanHieu) {
        String sql = " update SanPham\n"
                + "set idNhanHieu = (SELECT idNhanHieu FROM NhanHieu WHERE TenNhanHieu=N'NONE')\n"
                + "where idNhanHieu = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, idNhanHieu);
            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean setNhomHuongNone(String idNhomHuong) {
        String sql = " update SanPham\n"
                + "set idNhomHuong = (SELECT idNhomHuong FROM NhomHuong WHERE TenNhomHuong=N'NONE')\n"
                + "where idNhomHuong = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, idNhomHuong);
            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean setXuatXuNone(String idXuatXu) {
        String sql = " update SanPham\n"
                + "set idXuatXu = (SELECT idXuatXu FROM XuatXu WHERE TenXuatXu=N'NONE')\n"
                + "where idXuatXu = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, idXuatXu);
            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //Nam code ---------------------------------------------------------------------
    public boolean updateSoLuongTon(SanPham sp) {
        String sql = "update SanPham set SoLuongTon= SoLuongTon - ? where IDSanPham=?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, sp.getSoLuongTon());
            ps.setObject(2, sp.getIdSanPham());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkDanhMuc(String danhMuc) {
        String sql = "SELECT * FROM DanhMuc WHERE ? in (SELECT TenDanhMuc FROM DanhMuc)";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, danhMuc);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkNhomHuong(String nhomHuong) {
        String sql = "SELECT * FROM NhomHuong WHERE ? in (SELECT TenNhomHuong FROM NhomHuong)";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, nhomHuong);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkXuatXu(String xuatXu) {
        String sql = "SELECT * FROM XuatXu WHERE ? in (SELECT TenXuatXu FROM XuatXu)";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, xuatXu);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkNhanHieu(String nhanHieu) {
        String sql = "SELECT * FROM NhanHieu WHERE ? in (SELECT TenNhanHieu FROM NhanHieu)";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, nhanHieu);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkProduct(String tenSanPham, int kichThuoc) {
        String sql = "SELECT * FROM SanPham WHERE TenSanPham = ? and KichThuoc = ? and (TrangThai = 1 or TrangThai = 0)";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, tenSanPham);
            ps.setObject(2, kichThuoc);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getImageUrl(String idSanPham) {
        String imageUrl = "";
        String sql = "select ImageUrl from SanPham where IDSanPham=?";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, idSanPham);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                imageUrl = rs.getString("ImageUrl");
            }

            return imageUrl;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public BigDecimal getGiaGiam(String idSanPham) {
        BigDecimal giaGiam = new BigDecimal(0);
        String sql = "select GiaGiam from SanPham where IDSanPham=?";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, idSanPham);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                giaGiam = rs.getBigDecimal("GiaGiam");
            }

            return giaGiam;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getNgayThem(String idSanPham) {
        String ngayThem = "";
        String sql = "select NgayThem from SanPham where IDSanPham=?";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, idSanPham);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ngayThem = rs.getString("NgayThem");
            }

            return ngayThem;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean checkNoneDanhMuc(String tenDanhMuc) {
        String sql = "SELECT * FROM DanhMuc WHERE TenDanhMuc = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, tenDanhMuc);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
