/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import Services.INhatKyHoatDong;
import Services.NhatKyHoatDongService;

import ViewModels.NhatKyHoatDong_HoaDonChiTietView;
import ViewModels.NhatKyHoatDong_HoaDonNhapChiTietView;
import ViewModels.NhatKyHoatDong_HoaDonNhapView;
import ViewModels.NhatKyHoatDong_HoaDonView;
import java.util.Date;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class QuanLyNhatKyHoatDongJPanel extends javax.swing.JPanel {

    NhatKyHoatDongService nhatKyHoatDongService = new INhatKyHoatDong();
    DefaultTableModel nhapModel;
    DefaultTableModel xuatModel;

    List<NhatKyHoatDong_HoaDonView> lstHoaDon;
    String idTaiKhoanHD;
    String trangThaiHD;
    String startTimeHD;
    String endTimeHD;
    String TaiKhoanHD;
    String tenTrangThaiHD;
    String startTimeHD0;
    String endTimeHD0;
    DefaultTableModel modelHoaDon;
    List<NhatKyHoatDong_HoaDonChiTietView> lstHoaDonChiTietView;
    DefaultTableModel modelHoaDonChiTiet;

    int hoaDonIndex = 0;
    int hoaDonXuatIndex = 0;
    int hoaDonNhapIndex = 0;
    List<String> lstEmailCuaHang;
    List<String> lstEmailKho;
    List<String> lstTenSanPham;

    String idTaiKhoanHDNhap;
    String trangThaiHDNhap;
    String startTimeHDNhap;
    String endTimeHDNhap;
    String TaiKhoanHDNhap;
    String tenTrangThaiHDNhap;
    List<NhatKyHoatDong_HoaDonNhapView> lstHoaDonNhap;
    DefaultTableModel modelHoaDonNhap;
    List<NhatKyHoatDong_HoaDonNhapChiTietView> lstHoaDonNhapChiTiet;
    DefaultTableModel modelHoaDonNhapChiTiet;

    String idTaiKhoanCuaHangXuat;
    String idTaiKhoanKhoXuat;
    String trangThaiHDXuat;
    String startTimeHDXuat;
    String endTimeHDXuat;
    String TaiKhoanCHXuat;
    String TaiKhoanKhoXuat;
    String tenTrangThaiHDXuat;
    List<NhatKyHoatDong_HoaDonNhapView> lstHoaDonXuat;
    DefaultTableModel modelHoaDonXuat;
    List<NhatKyHoatDong_HoaDonNhapChiTietView> lstHoaDonXuatChiTiet;
    DefaultTableModel modelHoaDonXuatChiTiet;
    int _soTrangHd = 1;
    int _soTrangHdNhap = 1;
    int _soTrangHdXuat = 1;

    /**
     * Creates new form TrangChuJPanel
     */
    public QuanLyNhatKyHoatDongJPanel() {
        initComponents();
        fillToCbo();
        initCboTimKiem();
        startTimeHD = ((JTextField) startDate.getDateEditor().getUiComponent()).getText();
        endTimeHD = ((JTextField) endDate.getDateEditor().getUiComponent()).getText();
        idTaiKhoanHD = nhatKyHoatDongService.getIdTaiKhoan(String.valueOf(cboEmail.getSelectedItem())) + "";
        trangThaiHD = conVertTinhTrangToInt(String.valueOf(cboTinhTrang.getSelectedItem())) + "";
        if (trangThaiHD.equalsIgnoreCase("2")) {
            trangThaiHD = "";
        }
        lblSoTrangHdBan.setText(_soTrangHd + "");
        lstHoaDon = nhatKyHoatDongService.findHoaDon(idTaiKhoanHD, trangThaiHD, startTimeHD, endTimeHD, getStart(_soTrangHd), getEnd(_soTrangHd));
        fillToTableHoaDon(lstHoaDon);

        startTimeHDNhap = ((JTextField) startDateNhap.getDateEditor().getUiComponent()).getText();
        endTimeHDNhap = ((JTextField) endDateNhap.getDateEditor().getUiComponent()).getText();
        idTaiKhoanHDNhap = nhatKyHoatDongService.getIdTaiKhoan(String.valueOf(cboEmailNhap.getSelectedItem())) + "";
        trangThaiHDNhap = conVertTinhTrangNhapXuatToInt(String.valueOf(cboTinhTrangNhap.getSelectedItem())) + "";
        if (trangThaiHDNhap.equalsIgnoreCase("7")) {
            trangThaiHDNhap = "";
        }
        lblSoTrangHdNhap.setText(_soTrangHdNhap + "");
        lstHoaDonNhap = nhatKyHoatDongService.findHoaDonNhap(idTaiKhoanHDNhap, trangThaiHDNhap, startTimeHDNhap, endTimeHDNhap, getStart(_soTrangHdNhap), getEnd(_soTrangHdNhap));
        fillToTableHoaDonNhap(lstHoaDonNhap);

        startTimeHDXuat = ((JTextField) startDateXuat.getDateEditor().getUiComponent()).getText();
        endTimeHDXuat = ((JTextField) endDateXuat.getDateEditor().getUiComponent()).getText();
        idTaiKhoanCuaHangXuat = nhatKyHoatDongService.getIdTaiKhoan(String.valueOf(cboEmailCuaHangXuat.getSelectedItem())) + "";
        idTaiKhoanKhoXuat = nhatKyHoatDongService.getIdTaiKhoan(String.valueOf(cboEmailKhoXuat.getSelectedItem())) + "";
        trangThaiHDXuat = conVertTinhTrangNhapXuatToInt(String.valueOf(cboTinhTrangXuat.getSelectedItem())) + "";
        if (trangThaiHDXuat.equalsIgnoreCase("7")) {
            trangThaiHDXuat = "";
        }
        lblSoTrangHdXuat.setText(_soTrangHdXuat + "");
        lstHoaDonXuat = nhatKyHoatDongService.findHoaDonXuat(idTaiKhoanKhoXuat, idTaiKhoanCuaHangXuat, trangThaiHDXuat, startTimeHDXuat, endTimeHDXuat, getStart(_soTrangHdXuat), getEnd(_soTrangHdXuat));
        fillToTableHoaDonXuat(lstHoaDonXuat);

        TaiKhoanHD = cboEmail.getSelectedItem() + "";
        tenTrangThaiHD = cboTinhTrang.getSelectedItem() + "";

        TaiKhoanHDNhap = cboEmailNhap.getSelectedItem() + "";
        tenTrangThaiHDNhap = cboTinhTrangNhap.getSelectedItem() + "";

        TaiKhoanCHXuat = cboEmailCuaHangXuat.getSelectedItem() + "";
        TaiKhoanKhoXuat = cboEmailKhoXuat.getSelectedItem() + "";
        tenTrangThaiHDXuat = cboTinhTrangXuat.getSelectedItem() + "";
    }

    public void setCboTimKiemHDBanTruocKhiFillLaiNhap() {
        cboEmail.setSelectedItem(TaiKhoanHD);
        cboTinhTrang.setSelectedItem(tenTrangThaiHD);
    }

    public void setCboTimKiemHDNhapTruocKhiFillLaiNhap() {
        cboEmailNhap.setSelectedItem(TaiKhoanHDNhap);
        cboTinhTrangNhap.setSelectedItem(tenTrangThaiHDNhap);
    }

    public void setCboTimKiemHDXuatTruocKhiFillLaiNhap() {
        cboEmailCuaHangXuat.setSelectedItem(TaiKhoanCHXuat);
        cboEmailKhoXuat.setSelectedItem(TaiKhoanKhoXuat);
        cboTinhTrangXuat.setSelectedItem(tenTrangThaiHDXuat);
    }

    public void initCboTimKiem() {
        cboEmail.setSelectedItem("All");
        cboEmailNhap.setSelectedItem("All");
        cboEmailKhoXuat.setSelectedItem("All");
        cboTinhTrang.setSelectedItem("All");
        cboTinhTrangNhap.setSelectedItem("All");
        cboTinhTrangXuat.setSelectedItem("All");
        cboEmailCuaHangXuat.setSelectedItem("All");
    }

    public void fillToTableHoaDonNhap(List<NhatKyHoatDong_HoaDonNhapView> lstHoaDonNhap) {
        if (lstHoaDonNhap.isEmpty()) {
            System.out.println("List San Pham Rong");
        } else {
            modelHoaDonNhap = (DefaultTableModel) tblNhap.getModel();
            modelHoaDonNhap.setRowCount(0);
            int stt = _soTrangHdNhap*10-9;
            for (NhatKyHoatDong_HoaDonNhapView HoaDonNhapView : lstHoaDonNhap) {
                modelHoaDonNhap.addRow(new Object[]{
                    stt,
                    HoaDonNhapView.getEmailNhanVienKho(),
                    HoaDonNhapView.getTenHoaDon(),
                    HoaDonNhapView.getNhaCungUng(),
                    HoaDonNhapView.getTongTien(),
                    HoaDonNhapView.getNgayThem(),
                    HoaDonNhapView.getGhiChu(),
                    HoaDonNhapView.getTinhTrang()});
                stt++;
            }
        }

    }

    public void fillToTableHoaDonXuat(List<NhatKyHoatDong_HoaDonNhapView> lstHoaDonXuat) {
        if (lstHoaDonXuat.isEmpty()) {
            System.out.println("List San Pham Rong");
        } else {
            modelHoaDonXuat = (DefaultTableModel) tblXuat.getModel();
            modelHoaDonXuat.setRowCount(0);
            int stt = _soTrangHdXuat*10-9;
            System.out.println("");
            for (NhatKyHoatDong_HoaDonNhapView HoaDonXuatView : lstHoaDonXuat) {
                modelHoaDonXuat.addRow(new Object[]{
                    stt,
                    HoaDonXuatView.getEmailNhanVienKho(),
                    HoaDonXuatView.getEmailNhanVienCuaHang(),
                    HoaDonXuatView.getTenHoaDon(),
                    HoaDonXuatView.getNgayThem(),
                    HoaDonXuatView.getGhiChu(),
                    HoaDonXuatView.getTinhTrang()});
                stt++;
            }
        }

    }

    public void fillToTableHoaDon(List<NhatKyHoatDong_HoaDonView> lstHoaDonView) {
        if (lstHoaDonView.isEmpty()) {
            System.out.println("List San Pham Rong");
        } else {
            modelHoaDon = (DefaultTableModel) tblHoaDon.getModel();
            modelHoaDon.setRowCount(0);
            int stt = _soTrangHd*10 -9;
            for (NhatKyHoatDong_HoaDonView HoaDonView : lstHoaDonView) {
                modelHoaDon.addRow(new Object[]{
                    stt,
                    //                    HoaDonView.getIdHoaDon(),
                    HoaDonView.getTenHoaDon(),
                    HoaDonView.getEmail(),
                    HoaDonView.getSdtKhachHang(),
                    HoaDonView.getTongTien(),
                    HoaDonView.getNgayThem(),
                    HoaDonView.getGhiChu(),
                    conVertTinhTrangToString(HoaDonView.getTinhTrang())});
                stt++;
            }
        }

    }

    public int getStart(int soTrang) {
        int end = soTrang * 10;
        int start = end - 10 + 1;
        return start;
    }

    public int getEnd(int soTrang) {
        int end = soTrang * 10;

        return end;
    }

//    public void fillToTableHoaDonNhapIndex(List<NhatKyHoatDong_HoaDonNhapView> lstHoaDonView, int index) {
//        if (lstHoaDonView.isEmpty()) {
//            System.out.println("List San Pham Rong");
//        } else {
//            modelHoaDonNhap = (DefaultTableModel) tblNhap.getModel();
//            modelHoaDonNhap.setRowCount(0);
//            int end = index * 10;
//            int start = end - 10;
//            if (lstHoaDonView.size() < end) {
//                end = lstHoaDonView.size();
//            }
//            int stt = 1;
//            for (int i = start; i < end; i++) {
//                modelHoaDonNhap.addRow(new Object[]{
//                    stt,
//                    lstHoaDonView.get(i).getEmailNhanVienKho(),
//                    lstHoaDonView.get(i).getTenHoaDon(),
//                    lstHoaDonView.get(i).getNhaCungUng(),
//                    lstHoaDonView.get(i).getTongTien(),
//                    lstHoaDonView.get(i).getNgayThem(),
//                    lstHoaDonView.get(i).getGhiChu(),
//                    lstHoaDonView.get(i).getTinhTrang()});
//                stt++;
//            }
//        }
//
//    }
//    public void fillToTableHoaDonXuatIndex(List<NhatKyHoatDong_HoaDonNhapView> lstHoaDonView, int index) {
//        if (lstHoaDonView.isEmpty()) {
//            System.out.println("List San Pham Rong");
//        } else {
//            modelHoaDonXuat = (DefaultTableModel) tblXuat.getModel();
//            modelHoaDonXuat.setRowCount(0);
//            int end = index * 10;
//            int start = end - 10;
//            if (lstHoaDonView.size() < end) {
//                end = lstHoaDonView.size();
//            }
//            int stt = 1;
//            for (int i = start; i < end; i++) {
//                modelHoaDonXuat.addRow(new Object[]{
//                    stt,
//                    lstHoaDonView.get(i).getEmailNhanVienKho(),
//                    lstHoaDonView.get(i).getEmailNhanVienCuaHang(),
//                    lstHoaDonView.get(i).getTenHoaDon(),
//                    lstHoaDonView.get(i).getNgayThem(),
//                    lstHoaDonView.get(i).getGhiChu(),
//                    lstHoaDonView.get(i).getTinhTrang()});
//                stt++;
//            }
//        }
//
//    }
//    public void fillToTableHoaDonIndex(List<NhatKyHoatDong_HoaDonView> lstHoaDonView, int index) {
//        if (lstHoaDonView.isEmpty()) {
//            System.out.println("List San Pham Rong");
//        } else {
//            modelHoaDon = (DefaultTableModel) tblHoaDon.getModel();
//            modelHoaDon.setRowCount(0);
//            int end = index * 10;
//            int start = end - 10;
//            if (lstHoaDonView.size() < end) {
//                end = lstHoaDonView.size();
//            }
//            int stt = 1;
//            for (int i = start; i < end; i++) {
//                modelHoaDon.addRow(new Object[]{
//                    stt,
//                    lstHoaDonView.get(i).getTenHoaDon(),
//                    lstHoaDonView.get(i).getEmail(),
//                    lstHoaDonView.get(i).getSdtKhachHang(),
//                    lstHoaDonView.get(i).getTongTien(),
//                    lstHoaDonView.get(i).getNgayThem(),
//                    lstHoaDonView.get(i).getGhiChu(),
//                    conVertTinhTrangToString(lstHoaDonView.get(i).getTinhTrang())});
//                stt++;
//            }
//        }
//
//    }
    public void fillToTableHoaDonChiTiet(List<NhatKyHoatDong_HoaDonChiTietView> lstHoaDonChiTietView) {
        if (lstHoaDonChiTietView.isEmpty()) {
            System.out.println("List San Pham Rong");
        } else {
            modelHoaDonChiTiet = (DefaultTableModel) tblHoaDonChiTiet.getModel();
            modelHoaDonChiTiet.setRowCount(0);

            for (NhatKyHoatDong_HoaDonChiTietView HoaDonChiTietView : lstHoaDonChiTietView) {
                modelHoaDonChiTiet.addRow(new Object[]{
                    HoaDonChiTietView.getTenSanPham(),
                    HoaDonChiTietView.getDungTich(),
                    HoaDonChiTietView.getSoLuong(),
                    HoaDonChiTietView.getDonGia(),
                    HoaDonChiTietView.getNgayThem(),
                    HoaDonChiTietView.getTrangThai(),});
            }
        }

    }

    public void fillToTableHoaDonNhapChiTiet(List<NhatKyHoatDong_HoaDonNhapChiTietView> lstHoaDonChiTietView) {
        if (lstHoaDonChiTietView.isEmpty()) {
            System.out.println("List Nhap Rong");
        } else {
            modelHoaDonNhapChiTiet = (DefaultTableModel) tblNhapChiTiet.getModel();
            modelHoaDonNhapChiTiet.setRowCount(0);

            for (NhatKyHoatDong_HoaDonNhapChiTietView HoaDonChiTietView : lstHoaDonChiTietView) {
                modelHoaDonNhapChiTiet.addRow(new Object[]{
                    HoaDonChiTietView.getTenSanPham(),
                    HoaDonChiTietView.getDungTich(),
                    HoaDonChiTietView.getSoLuong(),
                    HoaDonChiTietView.getDonGia(),});
            }
        }

    }

    public void fillToTableHoaDonXuatChiTiet(List<NhatKyHoatDong_HoaDonNhapChiTietView> lstHoaDonChiTietView) {
        if (lstHoaDonChiTietView.isEmpty()) {
            System.out.println("List Xuat Rong");
        } else {
            modelHoaDonXuatChiTiet = (DefaultTableModel) tblXuatChiTiet.getModel();
            modelHoaDonXuatChiTiet.setRowCount(0);

            for (NhatKyHoatDong_HoaDonNhapChiTietView HoaDonChiTietView : lstHoaDonChiTietView) {
                modelHoaDonXuatChiTiet.addRow(new Object[]{
                    HoaDonChiTietView.getTenSanPham(),
                    HoaDonChiTietView.getDungTich(),
                    HoaDonChiTietView.getSoLuong(),
                    HoaDonChiTietView.getSoLuongThucTe()});
            }
        }

    }

    public void fillOnClickHoaDon(int index) {
        if (nhatKyHoatDongService.getHoaDonChiTietByIdHoaDon(lstHoaDon.get(hoaDonIndex).getIdHoaDon()).isEmpty()) {
            System.out.println("List San Pham Rong");
            modelHoaDonChiTiet = (DefaultTableModel) tblHoaDonChiTiet.getModel();
            modelHoaDonChiTiet.setRowCount(0);
        } else {
            System.out.println("Vao else");
            lstHoaDonChiTietView = nhatKyHoatDongService.getHoaDonChiTietByIdHoaDon(lstHoaDon.get(hoaDonIndex).getIdHoaDon());
            fillToTableHoaDonChiTiet(lstHoaDonChiTietView);
        }

    }

    public void fillOnClickNhap(int index) {
        if (nhatKyHoatDongService.getHoaDonChiTietNhap(lstHoaDonNhap.get(hoaDonNhapIndex).getIdHoaDon()).isEmpty()) {
            System.out.println("List Hoa don nhap chi tiet Rong");
            modelHoaDonNhapChiTiet = (DefaultTableModel) tblNhapChiTiet.getModel();
            modelHoaDonNhapChiTiet.setRowCount(0);
        } else {
            System.out.println("Vao else");
            lstHoaDonNhapChiTiet = nhatKyHoatDongService.getHoaDonChiTietNhap(lstHoaDonNhap.get(hoaDonNhapIndex).getIdHoaDon());
            fillToTableHoaDonNhapChiTiet(lstHoaDonNhapChiTiet);
        }

    }

    public void fillOnClickXuat(int index) {
        if (nhatKyHoatDongService.getHoaDonChiTietXuat(lstHoaDonXuat.get(hoaDonXuatIndex).getIdHoaDon()).isEmpty()) {
            System.out.println("List Hoa don Xuat chi tiet Rong");
            modelHoaDonXuatChiTiet = (DefaultTableModel) tblXuatChiTiet.getModel();
            modelHoaDonXuatChiTiet.setRowCount(0);
        } else {
            System.out.println("Vao else");
            lstHoaDonXuatChiTiet = nhatKyHoatDongService.getHoaDonChiTietXuat(lstHoaDonXuat.get(hoaDonXuatIndex).getIdHoaDon());
            fillToTableHoaDonXuatChiTiet(lstHoaDonXuatChiTiet);
        }

    }

    public void fillToCbo() {
        lstEmailCuaHang = nhatKyHoatDongService.getEmail();
        lstEmailKho = nhatKyHoatDongService.getEmailNhanVienKho();
        if (lstEmailCuaHang.isEmpty() || lstEmailKho.isEmpty()) {
            System.out.println("List Email Rong");
            cboEmail.addItem("All");
            cboEmailNhap.addItem("All");
            cboEmailKhoXuat.addItem("All");
            cboEmailCuaHangXuat.addItem("All");
        } else {
            cboEmail.removeAllItems();
            cboEmailCuaHangXuat.removeAllItems();
            for (String string : lstEmailCuaHang) {
                cboEmail.addItem(string);
                cboEmailCuaHangXuat.addItem(string);
            }
            cboEmailNhap.removeAllItems();
            cboEmailKhoXuat.removeAllItems();
            for (String string : lstEmailKho) {
                cboEmailNhap.addItem(string);
                cboEmailKhoXuat.addItem(string);
            }
            cboEmail.addItem("All");
            cboEmailNhap.addItem("All");
            cboEmailKhoXuat.addItem("All");
            cboEmailCuaHangXuat.addItem("All");
        }

    }

    public int conVertTinhTrangToInt(String tinhTrang) {
        int number = 0;
        if (tinhTrang.equalsIgnoreCase("Đã thanh toán")) {
            return 1;
        } else if (tinhTrang.equalsIgnoreCase("Đã hủy")) {
            return 0;
        } else {
            return 2;
        }

    }

    public int conVertTinhTrangNhapXuatToInt(String tinhTrang) {

        if (tinhTrang.equalsIgnoreCase("Đã hủy")) {
            return 0;
        } else if (tinhTrang.equalsIgnoreCase("Đã hủy ")) {
            return -1;
        } else if (tinhTrang.equalsIgnoreCase("Đã nhập")) {
            return 1;
        } else if (tinhTrang.equalsIgnoreCase("Đang xuất")) {
            return 2;
        } else if (tinhTrang.equalsIgnoreCase("Xuất thành công")) {
            return 3;
        } else if (tinhTrang.equalsIgnoreCase("Xuất thất bại")) {
            return 4;
        } else if (tinhTrang.equalsIgnoreCase("Chờ nhập")) {
            return 5;
        } else if (tinhTrang.equalsIgnoreCase("Chờ xuất")) {
            return 6;
        }
        return 7;
    }

    public String conVertTinhTrangToString(int tinhTrang) {
        if (tinhTrang == 1) {
            return "Đã thanh toán";
        } else if (tinhTrang == 0) {
            return "Đã hủy";
        }
        return "Chờ thanh toán";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jplHoaDon = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        btnTimKiem = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cboTinhTrang = new javax.swing.JComboBox<>();
        startDate = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        cboEmail = new javax.swing.JComboBox<>();
        endDate = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnLocHoaDonBan = new javax.swing.JButton();
        btnCuoiHdBan = new javax.swing.JButton();
        btnNextHdBan = new javax.swing.JButton();
        btnPrevHdBan = new javax.swing.JButton();
        btnDauHdBan = new javax.swing.JButton();
        lblSoTrangHdBan = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDonChiTiet = new javax.swing.JTable();
        jplKhoHang = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblNhap = new javax.swing.JTable();
        btnCuoiHdNhap = new javax.swing.JButton();
        btnNextHdNhap = new javax.swing.JButton();
        btnPrevHdNhap = new javax.swing.JButton();
        btnDauHdNhap = new javax.swing.JButton();
        lblSoTrangHdNhap = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblNhapChiTiet = new javax.swing.JTable();
        btnTimKiemNhap = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cboEmailNhap = new javax.swing.JComboBox<>();
        endDateNhap = new com.toedter.calendar.JDateChooser();
        startDateNhap = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cboTinhTrangNhap = new javax.swing.JComboBox<>();
        jplKhoHang1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblXuat = new javax.swing.JTable();
        btnDauHdXuat = new javax.swing.JButton();
        btnPrevHdXuat = new javax.swing.JButton();
        btnNextHdXuat = new javax.swing.JButton();
        btnCuoiHdXuat = new javax.swing.JButton();
        lblSoTrangHdXuat = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblXuatChiTiet = new javax.swing.JTable();
        btnTimKiemXuat = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cboEmailKhoXuat = new javax.swing.JComboBox<>();
        endDateXuat = new com.toedter.calendar.JDateChooser();
        startDateXuat = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cboTinhTrangXuat = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        cboEmailCuaHangXuat = new javax.swing.JComboBox<>();

        setPreferredSize(new java.awt.Dimension(1100, 780));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jplHoaDon.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stt", "Tên hóa đơn", "Email nhân viên", "SĐT khách hàng", "Tổng tiền", "Ngày thêm", "Ghi chú", "Tình trạng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblHoaDon);

        btnTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Untitled-1.png"))); // NOI18N
        btnTimKiem.setText("Tìm IDHĐ");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Tình trạng");

        cboTinhTrang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboTinhTrang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đã thanh toán", "Đã hủy", "Chờ thanh toán", "All" }));

        startDate.setDateFormatString("yyyy-MM-dd");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Email");

        cboEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        endDate.setDateFormatString("yyyy-MM-dd");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Ngày bắt đầu");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Ngày kết thúc");

        btnLocHoaDonBan.setBackground(new java.awt.Color(51, 255, 51));
        btnLocHoaDonBan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLocHoaDonBan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Untitled-1.png"))); // NOI18N
        btnLocHoaDonBan.setText("Lọc");
        btnLocHoaDonBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocHoaDonBanActionPerformed(evt);
            }
        });

        btnCuoiHdBan.setText("Cuối");
        btnCuoiHdBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCuoiHdBanMouseClicked(evt);
            }
        });

        btnNextHdBan.setText(">");
        btnNextHdBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNextHdBanMouseClicked(evt);
            }
        });
        btnNextHdBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextHdBanActionPerformed(evt);
            }
        });

        btnPrevHdBan.setText("<");
        btnPrevHdBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPrevHdBanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPrevHdBanMouseEntered(evt);
            }
        });
        btnPrevHdBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevHdBanActionPerformed(evt);
            }
        });

        btnDauHdBan.setText("Đầu");
        btnDauHdBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDauHdBanMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLocHoaDonBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(53, 53, 53)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(83, 83, 83)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(startDate, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(endDate, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 983, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnDauHdBan)
                .addGap(18, 18, 18)
                .addComponent(btnPrevHdBan, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblSoTrangHdBan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNextHdBan, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCuoiHdBan)
                .addGap(342, 342, 342))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cboEmail, cboTinhTrang, endDate, startDate});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTimKiem)
                            .addComponent(jLabel2)
                            .addComponent(cboEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cboTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLocHoaDonBan)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(startDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(endDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSoTrangHdBan, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNextHdBan)
                        .addComponent(btnPrevHdBan)
                        .addComponent(btnCuoiHdBan)
                        .addComponent(btnDauHdBan)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cboEmail, cboTinhTrang, endDate, startDate});

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi tiết hóa đơn ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tblHoaDonChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên sản phẩm", "Dung tích", "Số lượng", "Đơn giá"
            }
        ));
        jScrollPane1.setViewportView(tblHoaDonChiTiet);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1001, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(201, 201, 201))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jplHoaDonLayout = new javax.swing.GroupLayout(jplHoaDon);
        jplHoaDon.setLayout(jplHoaDonLayout);
        jplHoaDonLayout.setHorizontalGroup(
            jplHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jplHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1060, Short.MAX_VALUE))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jplHoaDonLayout.setVerticalGroup(
            jplHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Hóa đơn bán hàng", jplHoaDon);

        jplKhoHang.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Nhập hàng"));

        tblNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stt", "Email nhân viên kho", "Tên hóa đơn", "Nhà cung ứng", "Tổng tiền", "Ngày thêm", "Ghi chú", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhapMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblNhap);

        btnCuoiHdNhap.setText("Cuối");
        btnCuoiHdNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCuoiHdNhapMouseClicked(evt);
            }
        });

        btnNextHdNhap.setText(">");
        btnNextHdNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNextHdNhapMouseClicked(evt);
            }
        });
        btnNextHdNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextHdNhapActionPerformed(evt);
            }
        });

        btnPrevHdNhap.setText("<");
        btnPrevHdNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPrevHdNhapMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPrevHdNhapMouseEntered(evt);
            }
        });
        btnPrevHdNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevHdNhapActionPerformed(evt);
            }
        });

        btnDauHdNhap.setText("Đầu");
        btnDauHdNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDauHdNhapMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 966, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(332, 332, 332)
                        .addComponent(btnDauHdNhap)
                        .addGap(18, 18, 18)
                        .addComponent(btnPrevHdNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblSoTrangHdNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnNextHdNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCuoiHdNhap)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNextHdNhap)
                    .addComponent(btnPrevHdNhap)
                    .addComponent(btnCuoiHdNhap)
                    .addComponent(btnDauHdNhap)
                    .addComponent(lblSoTrangHdNhap))
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Xuất hàng "));

        tblNhapChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên sản phẩm", "Dung tích", "Số lượng", "Đơn giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblNhapChiTiet);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 962, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        btnTimKiemNhap.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTimKiemNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Untitled-1.png"))); // NOI18N
        btnTimKiemNhap.setText("Tìm kiếm");
        btnTimKiemNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemNhapActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Email");

        cboEmailNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        endDateNhap.setDateFormatString("yyyy-MM-dd");

        startDateNhap.setDateFormatString("yyyy-MM-dd");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Ngày bắt đầu");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Ngày kết thúc");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Tình trạng");

        cboTinhTrangNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboTinhTrangNhap.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Chờ nhập", "Đã nhập", "Đã hủy" }));

        javax.swing.GroupLayout jplKhoHangLayout = new javax.swing.GroupLayout(jplKhoHang);
        jplKhoHang.setLayout(jplKhoHangLayout);
        jplKhoHangLayout.setHorizontalGroup(
            jplKhoHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplKhoHangLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jplKhoHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jplKhoHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jplKhoHangLayout.createSequentialGroup()
                        .addComponent(btnTimKiemNhap)
                        .addGap(64, 64, 64)
                        .addGroup(jplKhoHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jplKhoHangLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(48, 48, 48)
                                .addComponent(cboEmailNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jplKhoHangLayout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboTinhTrangNhap, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(109, 109, 109)
                        .addGroup(jplKhoHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jplKhoHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(startDateNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(endDateNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jplKhoHangLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cboEmailNhap, endDateNhap, startDateNhap});

        jplKhoHangLayout.setVerticalGroup(
            jplKhoHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jplKhoHangLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jplKhoHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jplKhoHangLayout.createSequentialGroup()
                        .addGroup(jplKhoHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnTimKiemNhap)
                            .addComponent(jLabel7)
                            .addComponent(startDateNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 36, Short.MAX_VALUE)
                        .addGroup(jplKhoHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jplKhoHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jplKhoHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(cboTinhTrangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel8))
                            .addComponent(endDateNhap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jplKhoHangLayout.createSequentialGroup()
                        .addGroup(jplKhoHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cboEmailNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(27, 27, 27)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jplKhoHangLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cboEmailNhap, cboTinhTrangNhap, endDateNhap, startDateNhap});

        jTabbedPane1.addTab("Nhập hàng", jplKhoHang);

        jplKhoHang1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Nhập hàng"));

        tblXuat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stt", "Email nhân viên kho", "Email nhân viên cửa hàng", "Tên hóa đơn", "Ngày thêm", "Ghi chú", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblXuatMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblXuat);

        btnDauHdXuat.setText("Đầu");
        btnDauHdXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDauHdXuatMouseClicked(evt);
            }
        });

        btnPrevHdXuat.setText("<");
        btnPrevHdXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPrevHdXuatMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPrevHdXuatMouseEntered(evt);
            }
        });
        btnPrevHdXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevHdXuatActionPerformed(evt);
            }
        });

        btnNextHdXuat.setText(">");
        btnNextHdXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNextHdXuatMouseClicked(evt);
            }
        });
        btnNextHdXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextHdXuatActionPerformed(evt);
            }
        });

        btnCuoiHdXuat.setText("Cuối");
        btnCuoiHdXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCuoiHdXuatMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 966, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDauHdXuat)
                .addGap(18, 18, 18)
                .addComponent(btnPrevHdXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblSoTrangHdXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNextHdXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCuoiHdXuat)
                .addGap(340, 340, 340))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNextHdXuat)
                    .addComponent(btnPrevHdXuat)
                    .addComponent(btnCuoiHdXuat)
                    .addComponent(btnDauHdXuat)
                    .addComponent(lblSoTrangHdXuat))
                .addContainerGap())
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Xuất hàng "));

        tblXuatChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên sản phẩm", "Dung tích", "Số lượng", "Số lượng thực tế"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tblXuatChiTiet);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 962, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        btnTimKiemXuat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTimKiemXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Untitled-1.png"))); // NOI18N
        btnTimKiemXuat.setText("Tìm kiếm");
        btnTimKiemXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemXuatActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Email nhân viên kho");

        cboEmailKhoXuat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        endDateXuat.setDateFormatString("yyyy-MM-dd");

        startDateXuat.setDateFormatString("yyyy-MM-dd");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Ngày bắt đầu");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Ngày kết thúc");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Tình trạng");

        cboTinhTrangXuat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboTinhTrangXuat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Chờ xuất", "Đang xuất", "Xuất thành công", "Xuất thất bại", "Đã hủy " }));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Email nhân viên cửa hàng");

        cboEmailCuaHangXuat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jplKhoHang1Layout = new javax.swing.GroupLayout(jplKhoHang1);
        jplKhoHang1.setLayout(jplKhoHang1Layout);
        jplKhoHang1Layout.setHorizontalGroup(
            jplKhoHang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplKhoHang1Layout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addComponent(btnTimKiemXuat)
                .addGap(64, 64, 64)
                .addGroup(jplKhoHang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jplKhoHang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboEmailKhoXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboTinhTrangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboEmailCuaHangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jplKhoHang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jplKhoHang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(startDateXuat, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                    .addComponent(endDateXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(38, 38, 38))
            .addGroup(jplKhoHang1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jplKhoHang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jplKhoHang1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {endDateXuat, startDateXuat});

        jplKhoHang1Layout.setVerticalGroup(
            jplKhoHang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jplKhoHang1Layout.createSequentialGroup()
                .addGroup(jplKhoHang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jplKhoHang1Layout.createSequentialGroup()
                        .addGroup(jplKhoHang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jplKhoHang1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jplKhoHang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnTimKiemXuat)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jplKhoHang1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cboEmailKhoXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(jplKhoHang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(cboEmailCuaHangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jplKhoHang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(cboTinhTrangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jplKhoHang1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jplKhoHang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(startDateXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jplKhoHang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(endDateXuat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)))
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jplKhoHang1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {endDateXuat, startDateXuat});

        jTabbedPane1.addTab("Xuất hàng", jplKhoHang1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1078, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 43, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1100, 800));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        hoaDonIndex = tblHoaDon.getSelectedRow();
        fillOnClickHoaDon(hoaDonIndex);
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        String idHoaDon = JOptionPane.showInputDialog("Nhập ID hóa đơn");
        lstHoaDon = nhatKyHoatDongService.getHoaDonById(idHoaDon);
        if (lstHoaDon.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy");
        } else {
            _soTrangHd = 1;
            lblSoTrangHdBan.setText(_soTrangHd + "");
            fillToTableHoaDon(lstHoaDon);

        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnTimKiemNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemNhapActionPerformed
        if (((JTextField) startDateNhap.getDateEditor().getUiComponent()).getText().isEmpty() && ((JTextField) endDateNhap.getDateEditor().getUiComponent()).getText().isEmpty() == false) {
            JOptionPane.showMessageDialog(this, "Khong dc de trong 1 trong 2 ngay bat dau hoac ket thuc");
        } else if (((JTextField) startDateNhap.getDateEditor().getUiComponent()).getText().isEmpty() == false && ((JTextField) endDateNhap.getDateEditor().getUiComponent()).getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Khong dc de trong 1 trong 2 ngay bat dau hoac ket thuc");
        } else {
            _soTrangHdNhap=1;
            TaiKhoanHDNhap = cboEmailNhap.getSelectedItem() + "";
            tenTrangThaiHDNhap = cboTinhTrangNhap.getSelectedItem() + "";
            String timeStart = " 00:00:00.000";
            String timeEnd = " 23:59:59.000";
            startTimeHDNhap = ((JTextField) startDateNhap.getDateEditor().getUiComponent()).getText();
            endTimeHDNhap = ((JTextField) endDateNhap.getDateEditor().getUiComponent()).getText();
            if (!startTimeHDNhap.isEmpty() && !endTimeHDNhap.isEmpty()) {

                startTimeHDNhap = ((JTextField) startDateNhap.getDateEditor().getUiComponent()).getText() + timeStart;
                endTimeHDNhap = ((JTextField) endDateNhap.getDateEditor().getUiComponent()).getText() + timeEnd;
            }
            idTaiKhoanHDNhap = nhatKyHoatDongService.getIdTaiKhoan(String.valueOf(cboEmailNhap.getSelectedItem())) + "";
            trangThaiHDNhap = conVertTinhTrangNhapXuatToInt(String.valueOf(cboTinhTrangNhap.getSelectedItem())) + "";
            if (trangThaiHDNhap.equalsIgnoreCase("7")) {
                trangThaiHDNhap = "";
            }
            lstHoaDonNhap = nhatKyHoatDongService.findHoaDonNhap(idTaiKhoanHDNhap, trangThaiHDNhap, startTimeHDNhap, endTimeHDNhap, getStart(_soTrangHdNhap), getEnd(_soTrangHdNhap));

            if (lstHoaDonNhap.isEmpty()) {
                modelHoaDonNhap.setRowCount(0);
                JOptionPane.showMessageDialog(this, "List Rong");
            } else {
                _soTrangHdNhap = 1;
                lblSoTrangHdNhap.setText(_soTrangHdNhap + "");
                fillToTableHoaDonNhap(lstHoaDonNhap);
            }
        }

    }//GEN-LAST:event_btnTimKiemNhapActionPerformed

    private void btnTimKiemXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemXuatActionPerformed
        if (((JTextField) startDateXuat.getDateEditor().getUiComponent()).getText().isEmpty() && ((JTextField) endDateXuat.getDateEditor().getUiComponent()).getText().isEmpty() == false) {
            JOptionPane.showMessageDialog(this, "Khong dc de trong 1 trong 2 ngay bat dau hoac ket thuc");
        } else if (((JTextField) startDateXuat.getDateEditor().getUiComponent()).getText().isEmpty() == false && ((JTextField) endDateXuat.getDateEditor().getUiComponent()).getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Khong dc de trong 1 trong 2 ngay bat dau hoac ket thuc");
        } else {
            TaiKhoanCHXuat = cboEmailCuaHangXuat.getSelectedItem() + "";
            TaiKhoanKhoXuat = cboEmailKhoXuat.getSelectedItem() + "";
            tenTrangThaiHDXuat = cboTinhTrangXuat.getSelectedItem() + "";
            String timeStart = " 00:00:00.000";
            String timeEnd = " 23:59:59.000";
            startTimeHDXuat = ((JTextField) startDateXuat.getDateEditor().getUiComponent()).getText();
            endTimeHDXuat = ((JTextField) endDateXuat.getDateEditor().getUiComponent()).getText();
            if (!startTimeHDXuat.isEmpty() && !endTimeHDXuat.isEmpty()) {

                startTimeHDXuat = ((JTextField) startDateXuat.getDateEditor().getUiComponent()).getText() + timeStart;
                endTimeHDXuat = ((JTextField) endDateXuat.getDateEditor().getUiComponent()).getText() + timeEnd;
            }
            idTaiKhoanCuaHangXuat = nhatKyHoatDongService.getIdTaiKhoan(String.valueOf(cboEmailCuaHangXuat.getSelectedItem())) + "";
            idTaiKhoanKhoXuat = nhatKyHoatDongService.getIdTaiKhoan(String.valueOf(cboEmailKhoXuat.getSelectedItem())) + "";
            trangThaiHDXuat = conVertTinhTrangNhapXuatToInt(String.valueOf(cboTinhTrangXuat.getSelectedItem())) + "";
            if (trangThaiHDXuat.equalsIgnoreCase("7")) {
                trangThaiHDXuat = "";
            }
            _soTrangHdXuat = 1;
            lstHoaDonXuat = nhatKyHoatDongService.findHoaDonXuat(idTaiKhoanKhoXuat, idTaiKhoanCuaHangXuat, trangThaiHDXuat, startTimeHDXuat, endTimeHDXuat, getStart(_soTrangHdXuat), getEnd(_soTrangHdXuat));
            if (lstHoaDonXuat.isEmpty()) {
                modelHoaDonXuat.setRowCount(0);
                JOptionPane.showMessageDialog(this, "List Rong");
            } else {
                _soTrangHdXuat = 1;
                lblSoTrangHdXuat.setText(_soTrangHdXuat + "");
                fillToTableHoaDonXuat(lstHoaDonXuat);
            }
        }
    }//GEN-LAST:event_btnTimKiemXuatActionPerformed

    private void tblNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhapMouseClicked
        hoaDonNhapIndex = tblNhap.getSelectedRow();
        fillOnClickNhap(hoaDonNhapIndex);
    }//GEN-LAST:event_tblNhapMouseClicked

    private void tblXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblXuatMouseClicked

        hoaDonXuatIndex = tblXuat.getSelectedRow();
        fillOnClickXuat(hoaDonXuatIndex);
    }//GEN-LAST:event_tblXuatMouseClicked

    private void btnLocHoaDonBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocHoaDonBanActionPerformed
        if (((JTextField) startDate.getDateEditor().getUiComponent()).getText().isEmpty() && ((JTextField) endDate.getDateEditor().getUiComponent()).getText().isEmpty() == false) {
            JOptionPane.showMessageDialog(this, "Khong dc de trong 1 trong 2 ngay bat dau hoac ket thuc");
        } else if (((JTextField) startDate.getDateEditor().getUiComponent()).getText().isEmpty() == false && ((JTextField) endDate.getDateEditor().getUiComponent()).getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Khong dc de trong 1 trong 2 ngay bat dau hoac ket thuc");
        } else {
            TaiKhoanHD = cboEmail.getSelectedItem() + "";
            tenTrangThaiHD = cboTinhTrang.getSelectedItem() + "";
            startTimeHD0 = ((JTextField) startDate.getDateEditor().getUiComponent()).getText();
            endTimeHD0 = ((JTextField) endDate.getDateEditor().getUiComponent()).getText();
            String timeStart = " 00:00:00.000";
            String timeEnd = " 23:59:59.000";
            startTimeHD = ((JTextField) startDate.getDateEditor().getUiComponent()).getText();
            endTimeHD = ((JTextField) endDate.getDateEditor().getUiComponent()).getText();
            if (!startTimeHD.isEmpty() && !endTimeHD.isEmpty()) {

                startTimeHD = ((JTextField) startDate.getDateEditor().getUiComponent()).getText() + timeStart;
                endTimeHD = ((JTextField) endDate.getDateEditor().getUiComponent()).getText() + timeEnd;
            }
            idTaiKhoanHD = nhatKyHoatDongService.getIdTaiKhoan(String.valueOf(cboEmail.getSelectedItem())) + "";
            trangThaiHD = conVertTinhTrangToInt(String.valueOf(cboTinhTrang.getSelectedItem())) + "";
//            if (trangThaiHD.equalsIgnoreCase("2")) {
//                trangThaiHD = "";
//            }
            _soTrangHd = 1;
            lstHoaDon = nhatKyHoatDongService.findHoaDon(idTaiKhoanHD, trangThaiHD, startTimeHD, endTimeHD, getStart(_soTrangHd), getEnd(_soTrangHd));
            if (lstHoaDon.isEmpty()) {
                modelHoaDon.setRowCount(0);
                JOptionPane.showMessageDialog(this, "List Rong");
            } else {
                _soTrangHd = 1;
                lblSoTrangHdBan.setText(_soTrangHd + "");
                fillToTableHoaDon(lstHoaDon);
            }
        }
    }//GEN-LAST:event_btnLocHoaDonBanActionPerformed

    private void btnCuoiHdBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCuoiHdBanMouseClicked
        int soDong = nhatKyHoatDongService.getSoDongHD(idTaiKhoanHD, trangThaiHD, startTimeHD, endTimeHD);
        double page = soDong % 10.0;
        if (page != 0.0) {
            _soTrangHd = soDong / 10;
            _soTrangHd++;
        } else {
            _soTrangHd = soDong / 10;
        }
        lstHoaDon = nhatKyHoatDongService.findHoaDon(idTaiKhoanHD, trangThaiHD, startTimeHD, endTimeHD, getStart(_soTrangHd), getEnd(_soTrangHd));
        lblSoTrangHdBan.setText(String.valueOf(_soTrangHd));
        fillToTableHoaDon(lstHoaDon);
        setCboTimKiemHDBanTruocKhiFillLaiNhap();
    }//GEN-LAST:event_btnCuoiHdBanMouseClicked

    private void btnNextHdBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextHdBanMouseClicked
        _soTrangHd++;
        int soTrang;
        int soDong = nhatKyHoatDongService.getSoDongHD(idTaiKhoanHD, trangThaiHD, startTimeHD, endTimeHD);
        double page = soDong % 10.0;
        if (page != 0.0) {
            soTrang = soDong / 10;
            soTrang++;
        } else {
            soTrang = soDong / 10;
        }
        if (_soTrangHd > soTrang) {
            _soTrangHd = 1;
            lstHoaDon = nhatKyHoatDongService.findHoaDon(idTaiKhoanHD, trangThaiHD, startTimeHD, endTimeHD, getStart(_soTrangHd), getEnd(_soTrangHd));
            lblSoTrangHdBan.setText(String.valueOf(_soTrangHd));
            fillToTableHoaDon(lstHoaDon);
            setCboTimKiemHDBanTruocKhiFillLaiNhap();
        } else {
            lstHoaDon = nhatKyHoatDongService.findHoaDon(idTaiKhoanHD, trangThaiHD, startTimeHD, endTimeHD, getStart(_soTrangHd), getEnd(_soTrangHd));
            lblSoTrangHdBan.setText(String.valueOf(_soTrangHd));
            fillToTableHoaDon(lstHoaDon);
            setCboTimKiemHDBanTruocKhiFillLaiNhap();
        }
    }//GEN-LAST:event_btnNextHdBanMouseClicked

    private void btnNextHdBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextHdBanActionPerformed

    }//GEN-LAST:event_btnNextHdBanActionPerformed

    private void btnPrevHdBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrevHdBanMouseClicked
        _soTrangHd--;
        int soTrang;
        int soDong = nhatKyHoatDongService.getSoDongHD(idTaiKhoanHD, trangThaiHD, startTimeHD, endTimeHD);
        double page = soDong % 10.0;
        if (page != 0.0) {
            soTrang = soDong / 10;
            soTrang++;
        } else {
            soTrang = soDong / 10;
        }
        if (_soTrangHd == 0) {
            _soTrangHd = soTrang;
            lstHoaDon = nhatKyHoatDongService.findHoaDon(idTaiKhoanHD, trangThaiHD, startTimeHD, endTimeHD, getStart(_soTrangHd), getEnd(_soTrangHd));
            lblSoTrangHdBan.setText(String.valueOf(_soTrangHd));
            fillToTableHoaDon(lstHoaDon);
            setCboTimKiemHDBanTruocKhiFillLaiNhap();
        } else {
            lstHoaDon = nhatKyHoatDongService.findHoaDon(idTaiKhoanHD, trangThaiHD, startTimeHD, endTimeHD, getStart(_soTrangHd), getEnd(_soTrangHd));
            lblSoTrangHdBan.setText(String.valueOf(_soTrangHd));
            fillToTableHoaDon(lstHoaDon);
            setCboTimKiemHDBanTruocKhiFillLaiNhap();
        }
    }//GEN-LAST:event_btnPrevHdBanMouseClicked

    private void btnPrevHdBanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrevHdBanMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrevHdBanMouseEntered

    private void btnPrevHdBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevHdBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrevHdBanActionPerformed

    private void btnDauHdBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDauHdBanMouseClicked
        _soTrangHd = 1;
        lstHoaDon = nhatKyHoatDongService.findHoaDon(idTaiKhoanHD, trangThaiHD, startTimeHD, endTimeHD, getStart(_soTrangHd), getEnd(_soTrangHd));
        lblSoTrangHdBan.setText(String.valueOf(_soTrangHd));
        fillToTableHoaDon(lstHoaDon);
        setCboTimKiemHDBanTruocKhiFillLaiNhap();
    }//GEN-LAST:event_btnDauHdBanMouseClicked

    private void btnCuoiHdNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCuoiHdNhapMouseClicked
        int soDong = nhatKyHoatDongService.getSoDongNhap(idTaiKhoanHDNhap, trangThaiHDNhap, startTimeHDNhap, endTimeHDNhap);
        double page = soDong % 10.0;
        if (page != 0.0) {
            _soTrangHdNhap = soDong / 10;
            _soTrangHdNhap++;
        } else {
            _soTrangHdNhap = soDong / 10;
        }
        lstHoaDonNhap = nhatKyHoatDongService.findHoaDonNhap(idTaiKhoanHDNhap, trangThaiHDNhap, startTimeHDNhap, endTimeHDNhap, getStart(_soTrangHdNhap), getEnd(_soTrangHdNhap));
        fillToTableHoaDonNhap(lstHoaDonNhap);
        lblSoTrangHdNhap.setText(_soTrangHdNhap + "");
        setCboTimKiemHDNhapTruocKhiFillLaiNhap();
    }//GEN-LAST:event_btnCuoiHdNhapMouseClicked

    private void btnNextHdNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextHdNhapMouseClicked
        _soTrangHdNhap++;
        int soTrang;
        int soDong = nhatKyHoatDongService.getSoDongNhap(idTaiKhoanHDNhap, trangThaiHDNhap, startTimeHDNhap, endTimeHDNhap);
        double page = soDong % 10.0;
        if (page != 0.0) {
            soTrang = soDong / 10;
            soTrang++;
        } else {
            soTrang = soDong / 10;
        }
        if (_soTrangHdNhap > soTrang) {
            _soTrangHdNhap = 1;
            lstHoaDonNhap = nhatKyHoatDongService.findHoaDonNhap(idTaiKhoanHDNhap, trangThaiHDNhap, startTimeHDNhap, endTimeHDNhap, getStart(_soTrangHdNhap), getEnd(_soTrangHdNhap));
            fillToTableHoaDonNhap(lstHoaDonNhap);
            lblSoTrangHdNhap.setText(_soTrangHdNhap + "");
            setCboTimKiemHDNhapTruocKhiFillLaiNhap();
        } else {
            lstHoaDonNhap = nhatKyHoatDongService.findHoaDonNhap(idTaiKhoanHDNhap, trangThaiHDNhap, startTimeHDNhap, endTimeHDNhap, getStart(_soTrangHdNhap), getEnd(_soTrangHdNhap));
            fillToTableHoaDonNhap(lstHoaDonNhap);
            lblSoTrangHdNhap.setText(_soTrangHdNhap + "");
            setCboTimKiemHDNhapTruocKhiFillLaiNhap();
        }
    }//GEN-LAST:event_btnNextHdNhapMouseClicked

    private void btnNextHdNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextHdNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNextHdNhapActionPerformed

    private void btnPrevHdNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrevHdNhapMouseClicked
        _soTrangHdNhap--;
        int soTrang;
        int soDong = nhatKyHoatDongService.getSoDongNhap(idTaiKhoanHDNhap, trangThaiHDNhap, startTimeHDNhap, endTimeHDNhap);
        double page = soDong % 10.0;
        if (page != 0.0) {
            soTrang = soDong / 10;
            soTrang++;
        } else {
            soTrang = soDong / 10;
        }
        System.out.println(soTrang + " so trang");
        if (_soTrangHdNhap == 0) {
            _soTrangHdNhap = soTrang;
            lstHoaDonNhap = nhatKyHoatDongService.findHoaDonNhap(idTaiKhoanHDNhap, trangThaiHDNhap, startTimeHDNhap, endTimeHDNhap, getStart(_soTrangHdNhap), getEnd(_soTrangHdNhap));
            fillToTableHoaDonNhap(lstHoaDonNhap);
            lblSoTrangHdNhap.setText(_soTrangHdNhap + "");
            setCboTimKiemHDNhapTruocKhiFillLaiNhap();
        } else {
            lstHoaDonNhap = nhatKyHoatDongService.findHoaDonNhap(idTaiKhoanHDNhap, trangThaiHDNhap, startTimeHDNhap, endTimeHDNhap, getStart(_soTrangHdNhap), getEnd(_soTrangHdNhap));
            fillToTableHoaDonNhap(lstHoaDonNhap);
            lblSoTrangHdNhap.setText(_soTrangHdNhap + "");
            setCboTimKiemHDNhapTruocKhiFillLaiNhap();
        }
    }//GEN-LAST:event_btnPrevHdNhapMouseClicked

    private void btnPrevHdNhapMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrevHdNhapMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrevHdNhapMouseEntered

    private void btnPrevHdNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevHdNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrevHdNhapActionPerformed

    private void btnDauHdNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDauHdNhapMouseClicked
        _soTrangHdNhap = 1;
        lstHoaDonNhap = nhatKyHoatDongService.findHoaDonNhap(idTaiKhoanHDNhap, trangThaiHDNhap, startTimeHDNhap, endTimeHDNhap, getStart(_soTrangHdNhap), getEnd(_soTrangHdNhap));
        fillToTableHoaDonNhap(lstHoaDonNhap);
        lblSoTrangHdNhap.setText(_soTrangHdNhap + "");
        setCboTimKiemHDNhapTruocKhiFillLaiNhap();
    }//GEN-LAST:event_btnDauHdNhapMouseClicked

    private void btnDauHdXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDauHdXuatMouseClicked
        _soTrangHdXuat = 1;
        lblSoTrangHdXuat.setText(_soTrangHdXuat + "");
        lstHoaDonXuat = nhatKyHoatDongService.findHoaDonXuat(idTaiKhoanKhoXuat, idTaiKhoanCuaHangXuat, trangThaiHDXuat, startTimeHDXuat, endTimeHDXuat, getStart(_soTrangHdXuat), getEnd(_soTrangHdXuat));
        fillToTableHoaDonXuat(lstHoaDonXuat);
        setCboTimKiemHDXuatTruocKhiFillLaiNhap();
    }//GEN-LAST:event_btnDauHdXuatMouseClicked

    private void btnPrevHdXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrevHdXuatMouseClicked
        _soTrangHdXuat--;
        int soTrang;
        int soDong = nhatKyHoatDongService.getSoDongXuat(idTaiKhoanKhoXuat, idTaiKhoanCuaHangXuat, trangThaiHDXuat, startTimeHDXuat, endTimeHDXuat);
        double page = soDong % 10.0;
        if (page != 0.0) {
            soTrang = soDong / 10;
            soTrang++;
        } else {
            soTrang = soDong / 10;
        }
        if (_soTrangHdXuat == 0) {
            _soTrangHdXuat = soTrang;
            lblSoTrangHdXuat.setText(_soTrangHdXuat + "");
            lstHoaDonXuat = nhatKyHoatDongService.findHoaDonXuat(idTaiKhoanKhoXuat, idTaiKhoanCuaHangXuat, trangThaiHDXuat, startTimeHDXuat, endTimeHDXuat, getStart(_soTrangHdXuat), getEnd(_soTrangHdXuat));
            fillToTableHoaDonXuat(lstHoaDonXuat);
            setCboTimKiemHDXuatTruocKhiFillLaiNhap();
        } else {
            lblSoTrangHdXuat.setText(_soTrangHdXuat + "");
            lstHoaDonXuat = nhatKyHoatDongService.findHoaDonXuat(idTaiKhoanKhoXuat, idTaiKhoanCuaHangXuat, trangThaiHDXuat, startTimeHDXuat, endTimeHDXuat, getStart(_soTrangHdXuat), getEnd(_soTrangHdXuat));
            fillToTableHoaDonXuat(lstHoaDonXuat);
            setCboTimKiemHDXuatTruocKhiFillLaiNhap();
        }
    }//GEN-LAST:event_btnPrevHdXuatMouseClicked

    private void btnPrevHdXuatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrevHdXuatMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrevHdXuatMouseEntered

    private void btnPrevHdXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevHdXuatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrevHdXuatActionPerformed

    private void btnNextHdXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextHdXuatMouseClicked
        _soTrangHdXuat++;
        int soTrang;
        int soDong = nhatKyHoatDongService.getSoDongXuat(idTaiKhoanKhoXuat, idTaiKhoanCuaHangXuat, trangThaiHDXuat, startTimeHDXuat, endTimeHDXuat);
        double page = soDong % 10.0;
        if (page != 0.0) {
            soTrang = soDong / 10;
            soTrang++;
        } else {
            soTrang = soDong / 10;
        }
        if (_soTrangHdXuat > soTrang) {
            _soTrangHdXuat = 1;
            lblSoTrangHdXuat.setText(_soTrangHdXuat + "");
            lstHoaDonXuat = nhatKyHoatDongService.findHoaDonXuat(idTaiKhoanKhoXuat, idTaiKhoanCuaHangXuat, trangThaiHDXuat, startTimeHDXuat, endTimeHDXuat, getStart(_soTrangHdXuat), getEnd(_soTrangHdXuat));
            fillToTableHoaDonXuat(lstHoaDonXuat);
            setCboTimKiemHDXuatTruocKhiFillLaiNhap();
        } else {
            lblSoTrangHdXuat.setText(_soTrangHdXuat + "");
            lstHoaDonXuat = nhatKyHoatDongService.findHoaDonXuat(idTaiKhoanKhoXuat, idTaiKhoanCuaHangXuat, trangThaiHDXuat, startTimeHDXuat, endTimeHDXuat, getStart(_soTrangHdXuat), getEnd(_soTrangHdXuat));
            fillToTableHoaDonXuat(lstHoaDonXuat);
            setCboTimKiemHDXuatTruocKhiFillLaiNhap();
        }
    }//GEN-LAST:event_btnNextHdXuatMouseClicked

    private void btnNextHdXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextHdXuatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNextHdXuatActionPerformed

    private void btnCuoiHdXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCuoiHdXuatMouseClicked
        int soDong = nhatKyHoatDongService.getSoDongXuat(idTaiKhoanKhoXuat, idTaiKhoanCuaHangXuat, trangThaiHDXuat, startTimeHDXuat, endTimeHDXuat);
        double page = soDong % 10.0;
        if (page != 0.0) {
            _soTrangHdXuat = soDong / 10;
            _soTrangHdXuat++;
        } else {
            _soTrangHdXuat = soDong / 10;
        }
        lblSoTrangHdXuat.setText(_soTrangHdXuat + "");
        lstHoaDonXuat = nhatKyHoatDongService.findHoaDonXuat(idTaiKhoanKhoXuat, idTaiKhoanCuaHangXuat, trangThaiHDXuat, startTimeHDXuat, endTimeHDXuat, getStart(_soTrangHdXuat), getEnd(_soTrangHdXuat));
        fillToTableHoaDonXuat(lstHoaDonXuat);
        setCboTimKiemHDXuatTruocKhiFillLaiNhap();
    }//GEN-LAST:event_btnCuoiHdXuatMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCuoiHdBan;
    private javax.swing.JButton btnCuoiHdNhap;
    private javax.swing.JButton btnCuoiHdXuat;
    private javax.swing.JButton btnDauHdBan;
    private javax.swing.JButton btnDauHdNhap;
    private javax.swing.JButton btnDauHdXuat;
    private javax.swing.JButton btnLocHoaDonBan;
    private javax.swing.JButton btnNextHdBan;
    private javax.swing.JButton btnNextHdNhap;
    private javax.swing.JButton btnNextHdXuat;
    private javax.swing.JButton btnPrevHdBan;
    private javax.swing.JButton btnPrevHdNhap;
    private javax.swing.JButton btnPrevHdXuat;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnTimKiemNhap;
    private javax.swing.JButton btnTimKiemXuat;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboEmail;
    private javax.swing.JComboBox<String> cboEmailCuaHangXuat;
    private javax.swing.JComboBox<String> cboEmailKhoXuat;
    private javax.swing.JComboBox<String> cboEmailNhap;
    private javax.swing.JComboBox<String> cboTinhTrang;
    private javax.swing.JComboBox<String> cboTinhTrangNhap;
    private javax.swing.JComboBox<String> cboTinhTrangXuat;
    private com.toedter.calendar.JDateChooser endDate;
    private com.toedter.calendar.JDateChooser endDateNhap;
    private com.toedter.calendar.JDateChooser endDateXuat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel jplHoaDon;
    private javax.swing.JPanel jplKhoHang;
    private javax.swing.JPanel jplKhoHang1;
    private javax.swing.JLabel lblSoTrangHdBan;
    private javax.swing.JLabel lblSoTrangHdNhap;
    private javax.swing.JLabel lblSoTrangHdXuat;
    private com.toedter.calendar.JDateChooser startDate;
    private com.toedter.calendar.JDateChooser startDateNhap;
    private com.toedter.calendar.JDateChooser startDateXuat;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblHoaDonChiTiet;
    private javax.swing.JTable tblNhap;
    private javax.swing.JTable tblNhapChiTiet;
    private javax.swing.JTable tblXuat;
    private javax.swing.JTable tblXuatChiTiet;
    // End of variables declaration//GEN-END:variables
}
