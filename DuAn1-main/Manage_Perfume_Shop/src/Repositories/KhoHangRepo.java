/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.DanhMuc;
import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
import DomainModels.HoaDonNhap;
import DomainModels.HoaDonNhapChiTiet;
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
public class KhoHangRepo {

//    public List<SanPham> getSanPham() {
//        List<SanPham> lstSanPham = new ArrayList<>();
//        String sql = "SELECT TenSanPham,IDDanhMuc,IDNhanHieu,IDNhomHuong,IDXuatXu,KichThuoc,GiaGiam,SoLuongTrongKho \n"
//                + "FROM SANPHAM where trangthai=1 or trangthai=0";
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
//                sanPham.setSoLuongTrongKho(rs.getInt("SoLuongTrongKho"));
//                lstSanPham.add(sanPham);
//
//            }
//            return lstSanPham;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

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

    public boolean nhap(HoaDonNhap hoaDonNhap) {
        String sql = "update HoaDonNhap\n"
                + "set TrangThai = 1, nhacungung = ?, GhiChu=?, idNhanVienKho =?\n"
                + "where idHoaDon = ?";
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, hoaDonNhap.getNhaCungUng());
            ps.setObject(2, hoaDonNhap.getGhiChu());
            ps.setObject(3, hoaDonNhap.getIdNhanVienKho());
            ps.setObject(4, hoaDonNhap.getIdHoaDon());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean xuat(HoaDonNhap hoaDonNhap) {
        String sql = "update HoaDonNhap\n"
                + "set TrangThai = 2, GhiChu=?, idNhanVienKho =?\n"
                + "where idHoaDon = ?";
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, hoaDonNhap.getGhiChu());
            ps.setObject(2, hoaDonNhap.getIdNhanVienKho());
            ps.setObject(3, hoaDonNhap.getIdHoaDon());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean huy(List<HoaDonNhapChiTiet> lsthoaDonNhapChiTiet, String idHoaDon, int trangThai) {
        String sql = "";
        String sql2 = "";
        if (trangThai == 5) {
            sql = "update SanPham\n"
                    + "set SoLuongTrongKho = SoLuongTrongKho - ?\n"
                    + "where IDSanPham = ?";
        } else if (trangThai == 6) {
            sql = "update SanPham\n"
                    + "set SoLuongTrongKho = SoLuongTrongKho + ?\n"
                    + "where IDSanPham = ?";
        }
        if (trangThai == 5) {
             sql2 = "update HoaDonNhap\n"
                + "set TrangThai = 0\n"
                + "where idHoaDon = ?";
        } else if (trangThai == 6) {
             sql2 = "update HoaDonNhap\n"
                + "set TrangThai = -1\n"
                + "where idHoaDon = ?";
        }
        
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps;
            int result = 0;
            if (lsthoaDonNhapChiTiet.isEmpty()) {
                ps = con.prepareStatement(sql2);
                ps.setObject(1, idHoaDon);
                result = ps.executeUpdate();

            } else {
                for (int i = 0; i < lsthoaDonNhapChiTiet.size(); i++) {
                    ps = con.prepareStatement(sql);
                    ps.setObject(1, lsthoaDonNhapChiTiet.get(i).getSoLuong());
                    ps.setObject(2, lsthoaDonNhapChiTiet.get(i).getIdSanPham());
                    ps.executeUpdate();
                    result++;
                }
                ps = con.prepareStatement(sql2);
                ps.setObject(1, idHoaDon);
                ps.executeUpdate();
            }

            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean taoHoaDOn(String idTaiKhoan, int trangThai) {
        String sql = "insert into HoaDonNhap values (newid(),null,N'Hóa đơn nhập kho',?,null,getdate(),0,null,?)";
        String sql2 = "insert into HoaDonNhap values (newid(),null,N'Hóa đơn xuất kho',?,null,getdate(),0,null,?)";
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps;
            if (trangThai == 5) {
                ps = con.prepareStatement(sql);
                ps.setObject(1, idTaiKhoan);
                ps.setObject(2, trangThai);
                ps.executeUpdate();
            } else if (trangThai == 6) {
                ps = con.prepareStatement(sql2);
                ps.setObject(1, idTaiKhoan);
                ps.setObject(2, trangThai);
                ps.executeUpdate();
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
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

    public List<HoaDonNhap> getHoaDon(int trangThai) {
        List<HoaDonNhap> lstHoaDon = new ArrayList<>();

        String sql = "select IDNhanVienKho,NgayThem,IDHoaDon,TenHoaDon,TongTien,GhiChu\n"
                + "from HoaDonNhap where TrangThai =? ORDER BY ngayThem desc";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, trangThai);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonNhap HoaDon = new HoaDonNhap();
                HoaDon.setIdNhanVienKho(rs.getString("IdNhanVienKho"));
                HoaDon.setNgayThem(rs.getString("NgayThem"));
                HoaDon.setIdHoaDon(rs.getString("idHoaDon"));
                HoaDon.setTenHoaDon(rs.getString("TenHoaDon"));
                HoaDon.setTongTien(rs.getBigDecimal("TongTien"));
                HoaDon.setGhiChu(rs.getString("GhiChu"));
                lstHoaDon.add(HoaDon);
            }

            return lstHoaDon;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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

    public int getSoLuongTon(String idSanPham) {
        String sql = "select SoLuongTrongKho from SanPham\n"
                + "where IDSanPham = ?";
        int soLuongTon = 0;
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, idSanPham);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                soLuongTon = rs.getInt("SoLuongTrongKho");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return soLuongTon;
    }

    public int getSoLuongFromHoaDonChiTiet(String idHoaDon, String idSanPham) {
        String sql = "select SoLuong from HoaDonNhapChiTiet where IDHoaDon = ? and idSanPham=?";
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

    public List<HoaDonNhapChiTiet> getHoaDonChiTietByIdHoaDon(String idHoaDon) {
        List<HoaDonNhapChiTiet> lstHoaDonChiTiet = new ArrayList<>();
        String sql = "select donGia,IdHoaDon,IdSanPham,SoLuong,SoluongThucTe from HoaDonNhapChiTiet \n"
                + "where IDHoaDon= ?";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, idHoaDon);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonNhapChiTiet HoaDonChiTiet = new HoaDonNhapChiTiet();
                HoaDonChiTiet.setDonGia(rs.getBigDecimal("donGia"));
                HoaDonChiTiet.setIdHoaDon(rs.getString("IdHoaDon"));
                HoaDonChiTiet.setIdSanPham(rs.getString("IdSanPham"));
                HoaDonChiTiet.setSoLuong(rs.getInt("SoLuong"));
                HoaDonChiTiet.setSoLuongThucTe(rs.getInt("SoluongThucTe"));
                lstHoaDonChiTiet.add(HoaDonChiTiet);
            }
            return lstHoaDonChiTiet;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getEmailNhanVienCuaHang(String idHoaDon) {
        String sql = "select Email from TaiKhoan where IDTaiKhoan= (select IDNhanVienCuaHang from HoaDonNhap where IDHoaDon=?)";
        String email = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, idHoaDon);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                email = rs.getString("email");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return email;
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

    public boolean updateHoaDonChiTiet(int soLuong, String idHoaDon, String idSanPham, int trangThai) {
        System.out.println("Vao update");
        String sql = "update HoaDonNhapChiTiet\n"
                + "set SoLuong = SoLuong + ?\n"
                + "where IDSanPham= ? and IDHoaDon = ?";
        String sql2 = "";
        if (trangThai == 5) {
            sql2 = "update SanPham\n"
                    + "set SoLuongTrongKho = SoLuongTrongKho + ?\n"
                    + "where IDSanPham = ?";
        } else if (trangThai == 6) {
            sql2 = "update SanPham\n"
                    + "set SoLuongTrongKho = SoLuongTrongKho - ?\n"
                    + "where IDSanPham = ?";
        }
        String sql3 = "update HoaDonNhap\n"
                + "set TongTien = TongTien + ((select DonGia from HoaDonNhapChiTiet \n"
                + "where IDSanPham= ? and IDHoaDon = ?)* ?)\n"
                + "where IDHoaDon= ?";
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps;

            if (trangThai == 5) {
                ps = con.prepareStatement(sql);
                ps.setObject(1, soLuong);
                ps.setObject(2, idSanPham);
                ps.setObject(3, idHoaDon);
                ps.executeUpdate();
                ps = con.prepareStatement(sql2);
                ps.setObject(1, soLuong);
                ps.setObject(2, idSanPham);
                ps.executeUpdate();
                ps = con.prepareStatement(sql3);
                ps.setObject(1, idSanPham);
                ps.setObject(2, idHoaDon);
                ps.setObject(3, soLuong);
                ps.setObject(4, idHoaDon);
                ps.executeUpdate();
            } else if (trangThai == 6) {
                ps = con.prepareStatement(sql);
                ps.setObject(1, soLuong);
                ps.setObject(2, idSanPham);
                ps.setObject(3, idHoaDon);
                ps.executeUpdate();
                ps = con.prepareStatement(sql2);
                ps.setObject(1, soLuong);
                ps.setObject(2, idSanPham);
                ps.executeUpdate();
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean taoHoaDonChiTiet(HoaDonNhapChiTiet hoaDonNhapChiTiet, int trangThai) {
        String sql = "insert into HoaDonNhapChiTiet (IDHoaDon,IDSanPham,SoLuong,DonGia,ngaythem)\n"
                + "values (?,\n"
                + "?,?,?,getdate())";
        String sql2 = "";
        if (trangThai == 5) {
            sql2 = "update SanPham\n"
                    + "set SoLuongTrongKho = SoLuongTrongKho + ?\n"
                    + "where IDSanPham = ?";
        } else if (trangThai == 6) {
            sql2 = "update SanPham\n"
                    + "set SoLuongTrongKho = SoLuongTrongKho - ?\n"
                    + "where IDSanPham = ?";
        }

        String sql3 = "update HoaDonNhap\n"
                + "set TongTien = TongTien + ((select DonGia from HoaDonNhapChiTiet \n"
                + "where IDSanPham= ? and IDHoaDon = ?)* ?)\n"
                + "where IDHoaDon= ?";
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps;

            if (trangThai == 5) {
                ps = con.prepareStatement(sql);
                ps.setObject(1, hoaDonNhapChiTiet.getIdHoaDon());
                ps.setObject(2, hoaDonNhapChiTiet.getIdSanPham());
                ps.setObject(3, hoaDonNhapChiTiet.getSoLuong());
                ps.setObject(4, hoaDonNhapChiTiet.getDonGia());

                ps.executeUpdate();
                ps = con.prepareStatement(sql2);
                ps.setObject(1, hoaDonNhapChiTiet.getSoLuong());
                ps.setObject(2, hoaDonNhapChiTiet.getIdSanPham());
                ps.executeUpdate();
                ps = con.prepareStatement(sql3);
                ps.setObject(1, hoaDonNhapChiTiet.getIdSanPham());
                ps.setObject(2, hoaDonNhapChiTiet.getIdHoaDon());
                ps.setObject(3, hoaDonNhapChiTiet.getSoLuong());
                ps.setObject(4, hoaDonNhapChiTiet.getIdHoaDon());
                ps.executeUpdate();
            } else if (trangThai == 6) {
                ps = con.prepareStatement(sql);
                ps.setObject(1, hoaDonNhapChiTiet.getIdHoaDon());
                ps.setObject(2, hoaDonNhapChiTiet.getIdSanPham());
                ps.setObject(3, hoaDonNhapChiTiet.getSoLuong());
                ps.setObject(4, hoaDonNhapChiTiet.getDonGia());

                ps.executeUpdate();
                ps = con.prepareStatement(sql2);
                ps.setObject(1, hoaDonNhapChiTiet.getSoLuong());
                ps.setObject(2, hoaDonNhapChiTiet.getIdSanPham());
                ps.executeUpdate();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteHoaDonChiTiet(String idSanPham, String idHoaDon, int soLuong, int trangThai) {
        String sql2 = "delete HoaDonNhapChiTiet\n"
                + "where IDHoaDon= ? and IDSanPham=? ";
        String sql3 = "";
        if (trangThai == 5) {
            sql3 = "update SanPham\n"
                    + "set SoLuongTrongKho = SoLuongTrongKho - ?\n"
                    + "where IDSanPham = ?";
        } else if (trangThai == 6) {
            sql3 = "update SanPham\n"
                    + "set SoLuongTrongKho = SoLuongTrongKho + ?\n"
                    + "where IDSanPham = ?";
        }

        String sql = "update HoaDonNhap\n"
                + "set TongTien = TongTien - ((select DonGia from HoaDonNhapChiTiet \n"
                + "where IDSanPham= ? and IDHoaDon = ?)* ?)\n"
                + "where IDHoaDon= ?";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps;

            if (trangThai == 5) {
                ps = conn.prepareStatement(sql);
                ps.setObject(1, idSanPham);
                ps.setObject(2, idHoaDon);
                ps.setObject(3, soLuong);
                ps.setObject(4, idHoaDon);
                ps.executeUpdate();
                ps = conn.prepareStatement(sql3);
                ps.setObject(1, soLuong);
                ps.setObject(2, idSanPham);
                ps.executeUpdate();
                ps = conn.prepareStatement(sql2);
                ps.setObject(1, idHoaDon);
                ps.setObject(2, idSanPham);
                ps.executeUpdate();
            } else if (trangThai == 6) {
                ps = conn.prepareStatement(sql3);
                ps.setObject(1, soLuong);
                ps.setObject(2, idSanPham);
                ps.executeUpdate();
                ps = conn.prepareStatement(sql2);
                ps.setObject(1, idHoaDon);
                ps.setObject(2, idSanPham);
                ps.executeUpdate();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

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
        System.out.println(sql);
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
                sanPham.setSoLuongTrongKho(rs.getInt("SoLuongTrongKho"));
                lstSanPham.add(sanPham);
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstSanPham;

    }
    
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
        System.out.println(sql);
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

}
