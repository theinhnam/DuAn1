/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import Services.IKhoHangService;
import Services.KhoHangService;

import ViewModels.KhoHang_HoaDonChiTietView;
import ViewModels.KhoHang_HoaDonView;
import ViewModels.KhoHang_SanPhamView;
import java.math.BigDecimal;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class KhoHangJPanel extends javax.swing.JPanel {

    /**
     * Creates new form TrangChuJPanel
     */
    //    Chung ------------------------------------------------------------------------    
    List<String> lstDanhMuc;
    List<String> lstNhomHuong;
    List<String> lstNhanHieu;
    List<String> lstXuatXu;
    String idNhanVienKho = new LoginJFrame()._idAccountLogin ;
    KhoHangService khoHangService = new IKhoHangService();

//    Nhap ------------------------------------------------------------------------
    String idDanhMucNhap;
    String idNhomHuongNhap;
    String idNhanHieuNhap;
    String idXuatXuNhap;
    List<KhoHang_SanPhamView> lstSanPhamViewNhap;
    DefaultTableModel modelSanPhamNhap;
    DefaultTableModel modelHoaDonNhap;
    List<KhoHang_HoaDonView> lstHoaDonNhap = khoHangService.getHoaDon(5);
    int sanPhamNhapIndex = 0;
    int hoaDonNhapIndex = 0;
    int gioHangNhapIndex = 0;
    List<KhoHang_HoaDonChiTietView> lstHoaDonChiTietViewNhap;
    DefaultTableModel modelHoaDonChiTietNhap;
    int _soTrangSpNhap = 1;
    String DanhMucNhap;
    String NhanHieuNhap;
    String NhomHuongNhap;
    String XuatXuNhap;
//    Xuat ------------------------------------------------------------------------
    DefaultTableModel modelSanPhamXuat;
    List<KhoHang_SanPhamView> lstSanPhamViewXuat;
    String idDanhMucXuat;
    String idNhomHuongXuat;
    String idNhanHieuXuat;
    String idXuatXuXuat;
    List<KhoHang_HoaDonView> lstHoaDonXuat = khoHangService.getHoaDon(6);
    List<KhoHang_HoaDonView> lstHoaDonXuatThatBai = khoHangService.getHoaDon(4);
    DefaultTableModel modelHoaDonXuat;
    int sanPhamXuatIndex = 0;
    int hoaDonXuatIndex = 0;
    int gioHangXuatIndex = 0;
    List<KhoHang_HoaDonChiTietView> lstHoaDonChiTietViewXuat;
    DefaultTableModel modelHoaDonChiTietXuat;
    int _soTrangSpXuat = 1;
    DefaultTableModel modelHoaDonXuatThatBai;
    int indexHoaDonXuatThatBai = 0;
    String DanhMucXuat;
    String NhanHieuXuat;
    String NhomHuongXuat;
    String XuatXuXuat;

    public KhoHangJPanel() {
        initComponents();
        fillToCboSanPham();
        initCboTimKiem();
        DanhMucXuat = cboDanhMucXuat.getSelectedItem() + "";
        NhanHieuXuat = cboNhanHieuXuat.getSelectedItem() + "";
        NhomHuongXuat = cboNhomHuongXuat.getSelectedItem() + "";
        XuatXuXuat = cboXuatXuXuat.getSelectedItem() + "";
        DanhMucNhap = cboDanhMucNhap.getSelectedItem() + "";
        NhanHieuNhap = cboNhanHieuNhap.getSelectedItem() + "";
        NhomHuongNhap = cboNhomHuongNhap.getSelectedItem() + "";
        XuatXuNhap = cboXuatXuNhap.getSelectedItem() + "";
        idDanhMucNhap = khoHangService.getIDDanhMuc(cboDanhMucNhap.getSelectedItem() + "");
        idNhanHieuNhap = khoHangService.getIDNhanHieu(cboNhanHieuNhap.getSelectedItem() + "");
        idNhomHuongNhap = khoHangService.getIDNhomHuong(cboNhomHuongNhap.getSelectedItem() + "");
        idXuatXuNhap = khoHangService.getIDXuatXu(cboXuatXuNhap.getSelectedItem() + "");
        lblSoTrangNhap.setText(_soTrangSpNhap + "");
        lstSanPhamViewNhap = khoHangService.findSanPham(idDanhMucNhap, idNhanHieuNhap, idNhomHuongNhap, idXuatXuNhap, getStart(_soTrangSpNhap), getEnd(_soTrangSpNhap));
        fillToTableSanPhamNhap(lstSanPhamViewNhap);
        idDanhMucXuat = khoHangService.getIDDanhMuc(cboDanhMucXuat.getSelectedItem() + "");
        idNhanHieuXuat = khoHangService.getIDNhanHieu(cboNhanHieuXuat.getSelectedItem() + "");
        idNhomHuongXuat = khoHangService.getIDNhomHuong(cboNhomHuongXuat.getSelectedItem() + "");
        idXuatXuXuat = khoHangService.getIDXuatXu(cboXuatXuXuat.getSelectedItem() + "");
        lblSoTrangXuat.setText(_soTrangSpXuat + "");
        lstSanPhamViewXuat = khoHangService.findSanPham(idDanhMucXuat, idNhanHieuXuat, idNhomHuongXuat, idXuatXuXuat, getStart(_soTrangSpXuat), getEnd(_soTrangSpXuat));
        fillToTableSanPhamXuat(lstSanPhamViewXuat);
        fillToTableHoaDonNhap(lstHoaDonNhap);
        fillToTableHoaDonXuat(lstHoaDonXuat);
        fillToTableHoaDonXuatThatBai(lstHoaDonXuatThatBai);
        modelHoaDonChiTietXuat = (DefaultTableModel) tblGioHangXuat.getModel();
        tblGioHangXuat.getColumnModel().getColumn(3).setMinWidth(0);
        tblGioHangXuat.getColumnModel().getColumn(3).setMaxWidth(0);
        tblGioHangXuat.getColumnModel().getColumn(4).setMinWidth(0);
        tblGioHangXuat.getColumnModel().getColumn(4).setMaxWidth(0);
    }
    
    public void setCboTimKiemTruocKhiFillLaiNhap () {
        cboDanhMucNhap.setSelectedItem(DanhMucNhap);
        cboNhanHieuNhap.setSelectedItem(NhanHieuNhap);
        cboNhomHuongNhap.setSelectedItem(NhomHuongNhap);
        cboXuatXuNhap.setSelectedItem(XuatXuNhap);
    }
    public void setCboTimKiemTruocKhiFillLaiXuat () {
        cboDanhMucXuat.setSelectedItem(DanhMucXuat);
        cboNhanHieuXuat.setSelectedItem(NhanHieuXuat);
        cboNhomHuongXuat.setSelectedItem(NhomHuongXuat);
        cboXuatXuXuat.setSelectedItem(XuatXuXuat);
    }

    public int getStart(int soTrang) {
        int end = soTrang * 4;
        int start = end - 4 + 1;
        return start;
    }

    public int getEnd(int soTrang) {
        int end = soTrang * 4;

        return end;
    }

    public void initCboTimKiem() {
        cboDanhMucNhap.setSelectedItem("All");
        cboNhanHieuNhap.setSelectedItem("All");
        cboNhomHuongNhap.setSelectedItem("All");
        cboXuatXuNhap.setSelectedItem("All");
        cboDanhMucXuat.setSelectedItem("All");
        cboNhanHieuXuat.setSelectedItem("All");
        cboNhomHuongXuat.setSelectedItem("All");
        cboXuatXuXuat.setSelectedItem("All");
    }

    public void fillToTableSanPhamNhap(List<KhoHang_SanPhamView> lstSanPhamViewNhap) {
        if (lstSanPhamViewNhap.isEmpty()) {
            System.out.println("List San Pham Rong");
        } else {
            modelSanPhamNhap = (DefaultTableModel) tblSanPhamNhap.getModel();
            modelSanPhamNhap.setRowCount(0);

            for (KhoHang_SanPhamView sanPhamView : lstSanPhamViewNhap) {
                modelSanPhamNhap.addRow(new Object[]{
                    sanPhamView.getTenSp(),
                    sanPhamView.getDungTich(),
                    sanPhamView.getNhanHieu(),
                    sanPhamView.getNhomHuong(),
                    sanPhamView.getDanhMuc(),
                    sanPhamView.getXuatXu(),
                    sanPhamView.getSoLuongTon()});
            }
        }

    }
//    public void fillToTableSanPhamNhapIndex(List<KhoHang_SanPhamView> lstSanPhamView, int index) {
//        if (lstSanPhamView.isEmpty()) {
//            System.out.println("List San Pham Rong");
//        } else {
//            modelSanPhamNhap = (DefaultTableModel) tblSanPhamNhap.getModel();
//            modelSanPhamNhap.setRowCount(0);
//            int end = index * 4;
//            int start = end - 4;
//            if (lstSanPhamView.size() < end) {
//                end = lstSanPhamView.size();
//            }
//
//            for (int i = start; i < end; i++) {
//                modelSanPhamNhap.addRow(new Object[]{
//                    lstSanPhamView.get(i).getTenSp(),
//                    lstSanPhamView.get(i).getDungTich(),
//                    lstSanPhamView.get(i).getNhanHieu(),
//                    lstSanPhamView.get(i).getNhomHuong(),
//                    lstSanPhamView.get(i).getDanhMuc(),
//                    lstSanPhamView.get(i).getXuatXu(),
//                    lstSanPhamView.get(i).getSoLuongTon()});
//
//            }
//        }
//
//    }

//    public void fillToTableSanPhamXuatIndex(List<KhoHang_SanPhamView> lstSanPhamView, int index) {
//        if (lstSanPhamView.isEmpty()) {
//            System.out.println("List San Pham Rong");
//        } else {
//            modelSanPhamXuat = (DefaultTableModel) tblSanPhamXuat.getModel();
//            modelSanPhamXuat.setRowCount(0);
//            int end = index * 4;
//            int start = end - 4;
//            if (lstSanPhamView.size() < end) {
//                end = lstSanPhamView.size();
//            }
//
//            for (int i = start; i < end; i++) {
//                modelSanPhamXuat.addRow(new Object[]{
//                    lstSanPhamView.get(i).getTenSp(),
//                    lstSanPhamView.get(i).getDungTich(),
//                    lstSanPhamView.get(i).getNhanHieu(),
//                    lstSanPhamView.get(i).getNhomHuong(),
//                    lstSanPhamView.get(i).getDanhMuc(),
//                    lstSanPhamView.get(i).getXuatXu(),
//                    lstSanPhamView.get(i).getSoLuongTon()});
//
//            }
//        }
//
//    }
    public void fillToTableSanPhamXuat(List<KhoHang_SanPhamView> lstSanPhamViewXuat) {
        if (lstSanPhamViewXuat.isEmpty()) {
            System.out.println("List San Pham Rong");
        } else {
            modelSanPhamXuat = (DefaultTableModel) tblSanPhamXuat.getModel();
            modelSanPhamXuat.setRowCount(0);

            for (KhoHang_SanPhamView sanPhamView : lstSanPhamViewXuat) {
                modelSanPhamXuat.addRow(new Object[]{
                    sanPhamView.getTenSp(),
                    sanPhamView.getDungTich(),
                    sanPhamView.getNhanHieu(),
                    sanPhamView.getNhomHuong(),
                    sanPhamView.getDanhMuc(),
                    sanPhamView.getXuatXu(),
                    sanPhamView.getSoLuongTon()});
            }
        }

    }

    public void fillToCboSanPham() {
        lstDanhMuc = khoHangService.getDanhMuc();
        lstNhomHuong = khoHangService.getNhomHuong();
        lstNhanHieu = khoHangService.getNhanHieu();
        lstXuatXu = khoHangService.getXuatXu();
        if (lstDanhMuc.isEmpty() || lstNhomHuong.isEmpty() || lstNhanHieu.isEmpty() || lstXuatXu.isEmpty()) {
            System.out.println("Mot Trong Cac List Cbo Rong");
        } else {

            lstDanhMuc.add("All");
            cboDanhMucNhap.removeAllItems();
            cboDanhMucXuat.removeAllItems();
            for (String string : lstDanhMuc) {
                cboDanhMucXuat.addItem(string);
                cboDanhMucNhap.addItem(string);
            }
            lstNhomHuong.add("All");
            cboNhomHuongNhap.removeAllItems();
            cboNhomHuongXuat.removeAllItems();
            for (String string : lstNhomHuong) {
                cboNhomHuongXuat.addItem(string);
                cboNhomHuongNhap.addItem(string);
            }
            lstNhanHieu.add("All");
            cboNhanHieuNhap.removeAllItems();
            cboNhanHieuXuat.removeAllItems();
            for (String string : lstNhanHieu) {
                cboNhanHieuXuat.addItem(string);
                cboNhanHieuNhap.addItem(string);
            }
            lstXuatXu.add("All");
            cboXuatXuNhap.removeAllItems();
            cboXuatXuXuat.removeAllItems();
            for (String string : lstXuatXu) {
                cboXuatXuXuat.addItem(string);
                cboXuatXuNhap.addItem(string);
            }
        }

    }

    public void fillToTableHoaDonNhap(List<KhoHang_HoaDonView> lstHoaDonView) {
        if (lstHoaDonView.isEmpty()) {
            System.out.println("List Hoa Don Rong");
        } else {
            modelHoaDonNhap = (DefaultTableModel) tblHoaDonNhap.getModel();
            modelHoaDonNhap.setRowCount(0);
            int stt = lstHoaDonView.size();
            for (KhoHang_HoaDonView HoaDonView : lstHoaDonView) {
                modelHoaDonNhap.addRow(new Object[]{
                    stt,
                    HoaDonView.getNguoiThem(),
                    HoaDonView.getTenHoaDon(),
                    HoaDonView.getTongTien(),
                    HoaDonView.getNgayThem(),});
                stt--;
            }
        }

    }

    public void fillToTableHoaDonXuat(List<KhoHang_HoaDonView> lstHoaDonView) {
        if (lstHoaDonView.isEmpty()) {
            System.out.println("List Hoa Don Rong");
        } else {
            modelHoaDonXuat = (DefaultTableModel) tblHoaDonXuat.getModel();
            modelHoaDonXuat.setRowCount(0);
            int stt = lstHoaDonView.size();
            for (KhoHang_HoaDonView HoaDonView : lstHoaDonView) {
                modelHoaDonXuat.addRow(new Object[]{
                    stt,
                    HoaDonView.getNguoiThem(),
                    HoaDonView.getTenHoaDon(),
                    HoaDonView.getNgayThem(),});
                stt--;
            }
        }

    }

    public void fillToTableHoaDonXuatThatBai(List<KhoHang_HoaDonView> lstHoaDonView) {
        if (lstHoaDonView.isEmpty()) {
            System.out.println("List Hoa Don Rong");
        } else {
            modelHoaDonXuatThatBai = (DefaultTableModel) tblHoaDonXuatThatBai.getModel();
            modelHoaDonXuatThatBai.setRowCount(0);
            int stt = lstHoaDonView.size();
            for (KhoHang_HoaDonView HoaDonView : lstHoaDonView) {
                modelHoaDonXuatThatBai.addRow(new Object[]{
                    stt,
                    HoaDonView.getNgayThem(),
                    HoaDonView.getGhiChu(),});
                stt--;
            }
        }

    }

    public void fillToTableHoaDonChiTietNhap(List<KhoHang_HoaDonChiTietView> lstHoaDonChiTietView) {
        if (lstHoaDonChiTietView.isEmpty()) {
            System.out.println("List Hoa Don Chi Tiet Rong");
        } else {
            modelHoaDonChiTietNhap = (DefaultTableModel) tblGioHangNhap.getModel();
            modelHoaDonChiTietNhap.setRowCount(0);

            for (KhoHang_HoaDonChiTietView HoaDonChiTietView : lstHoaDonChiTietView) {
                modelHoaDonChiTietNhap.addRow(new Object[]{
                    HoaDonChiTietView.getTenSp(),
                    HoaDonChiTietView.getDungTich(),
                    HoaDonChiTietView.getSoLuong(),
                    HoaDonChiTietView.getDonGia(),});
            }
        }

    }

    public void fillToTableHoaDonChiTietXuat(List<KhoHang_HoaDonChiTietView> lstHoaDonChiTietView) {
        if (lstHoaDonChiTietView.isEmpty()) {
            System.out.println("List Hoa Don Chi Tiet Rong");
        } else {

            modelHoaDonChiTietXuat.setRowCount(0);

            for (KhoHang_HoaDonChiTietView HoaDonChiTietView : lstHoaDonChiTietView) {
                modelHoaDonChiTietXuat.addRow(new Object[]{
                    HoaDonChiTietView.getTenSp(),
                    HoaDonChiTietView.getDungTich(),
                    HoaDonChiTietView.getSoLuong(),
                    HoaDonChiTietView.getSoLuongThucTe(),
                    HoaDonChiTietView.getEmailNv()});
            }
        }

    }

    public void fillOnClickHoaDonNhap(int index, List<KhoHang_HoaDonView> lst) {
        if (khoHangService.getHoaDonChiTietByIdHoaDon(lst.get(index).getIdHoaDon()).isEmpty()) {
            System.out.println("List HOA DON CHI TIET Rong");
            modelHoaDonChiTietNhap = (DefaultTableModel) tblGioHangNhap.getModel();
            modelHoaDonChiTietNhap.setRowCount(0);
        } else {
            lstHoaDonChiTietViewNhap = khoHangService.getHoaDonChiTietByIdHoaDon(lst.get(index).getIdHoaDon());
            fillToTableHoaDonChiTietNhap(lstHoaDonChiTietViewNhap);
        }

    }

    public void fillOnClickHoaDonXuat(int index, List<KhoHang_HoaDonView> lst) {
        if (khoHangService.getHoaDonChiTietByIdHoaDon(lst.get(index).getIdHoaDon()).isEmpty()) {
            System.out.println(lst.get(index).getIdHoaDon() + " STT VIEW CLICK");
            System.out.println("List HOA DON CHI TIET Rong");

            modelHoaDonChiTietXuat.setRowCount(0);
        } else {
            System.out.println("Vao ELSE ---------------------------");
            lstHoaDonChiTietViewXuat = khoHangService.getHoaDonChiTietByIdHoaDon(lst.get(index).getIdHoaDon());
            System.out.println(lstHoaDonChiTietViewXuat.get(0).getEmailNv() + "LST SIZE");
            fillToTableHoaDonChiTietXuat(lstHoaDonChiTietViewXuat);
        }

    }

    public boolean checkThemKoVuotQuaSoLuongTon(int soLuongThem) {

        String tenSanPham = lstSanPhamViewXuat.get(sanPhamXuatIndex).getTenSp();
        int dungTich = lstSanPhamViewXuat.get(sanPhamXuatIndex).getDungTich();
        String idSanPham = khoHangService.getIDSanPham(tenSanPham, dungTich);
        int soLuongTon = khoHangService.getSoLuongTon(idSanPham);

        System.out.println(tenSanPham + " Ten");
        System.out.println(idSanPham + " idSp");
        System.out.println(dungTich + " DungTich");
        System.out.println(soLuongTon + " Ton");
        System.out.println(soLuongThem + " Them");
        String idHoaDon = lstHoaDonXuat.get(hoaDonXuatIndex).getIdHoaDon();
        if (soLuongThem > soLuongTon) {
            return false;
        } else {
            return true;
        }

    }

    public boolean checkThemTrungSanPhamNhap(String tenSanPham, int dungTich) {
        lstHoaDonChiTietViewNhap = khoHangService.getHoaDonChiTietByIdHoaDon(lstHoaDonNhap.get(hoaDonNhapIndex).getIdHoaDon());
        if (lstHoaDonChiTietViewNhap.isEmpty()) {
            return true;
        } else {
            for (KhoHang_HoaDonChiTietView khoHang_HoaDonChiTietView : lstHoaDonChiTietViewNhap) {
                if (tenSanPham.equalsIgnoreCase(khoHang_HoaDonChiTietView.getTenSp()) && dungTich == khoHang_HoaDonChiTietView.getDungTich()) {
                    return false;
                }
            }
            return true;
        }

    }

    public boolean checkThemTrungSanPhamXuat(String tenSanPham, int dungTich) {
        lstHoaDonChiTietViewXuat = khoHangService.getHoaDonChiTietByIdHoaDon(lstHoaDonXuat.get(hoaDonXuatIndex).getIdHoaDon());
        if (lstHoaDonChiTietViewXuat.isEmpty()) {
            return true;
        } else {
            for (KhoHang_HoaDonChiTietView khoHang_HoaDonChiTietView : lstHoaDonChiTietViewXuat) {
                if (tenSanPham.equalsIgnoreCase(khoHang_HoaDonChiTietView.getTenSp()) && dungTich == khoHang_HoaDonChiTietView.getDungTich()) {
                    return false;
                }
            }
            return true;
        }

    }

    public boolean checkRongTxt(JTextField txt) {
        if (txt.getText().trim().equalsIgnoreCase("")) {
            return false;
        }
        return true;
    }

    public boolean checkPhaiLaSo(JTextField txt) {
        try {
            new BigDecimal(txt.getText());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean checkDonGiaLonHon0(JTextField txt) {
        BigDecimal bd = new BigDecimal(txt.getText());
        BigDecimal bd1 = new BigDecimal(0);
        int result = bd.compareTo(bd1);
        if (result == 0 || result == -1) {
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jblNhap = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnTaoHoaDonNhap = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        btnNhap = new javax.swing.JButton();
        btnHuyNhap = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtGhiChuNhap = new javax.swing.JTextArea();
        jLabel22 = new javax.swing.JLabel();
        txtNhaCungUngNhap = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtDonGiaNhap = new javax.swing.JTextField();
        lblSTTNhap = new javax.swing.JLabel();
        lblTongTienNhap = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPhamNhap = new javax.swing.JTable();
        btnThemNhap = new javax.swing.JButton();
        cboDanhMucNhap = new javax.swing.JComboBox<>();
        cboNhomHuongNhap = new javax.swing.JComboBox<>();
        cboXuatXuNhap = new javax.swing.JComboBox<>();
        cboNhanHieuNhap = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnLocSpNhap = new javax.swing.JButton();
        btnDauNhap = new javax.swing.JButton();
        btnPrevNhap = new javax.swing.JButton();
        lblSoTrangNhap = new javax.swing.JLabel();
        btnNextNhap = new javax.swing.JButton();
        btnCuoiNhap = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGioHangNhap = new javax.swing.JTable();
        btnXoaGioHangNhap = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblHoaDonNhap = new javax.swing.JTable();
        jblXuat = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblGioHangXuat = new javax.swing.JTable();
        btnXoaGioHangXuat = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblSanPhamXuat = new javax.swing.JTable();
        btnThemXuat = new javax.swing.JButton();
        cboDanhMucXuat = new javax.swing.JComboBox<>();
        cboNhomHuongXuat = new javax.swing.JComboBox<>();
        cboXuatXuXuat = new javax.swing.JComboBox<>();
        cboNhanHieuXuat = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        btnLocSpXuat = new javax.swing.JButton();
        btnDauXuat = new javax.swing.JButton();
        btnPrevXuat = new javax.swing.JButton();
        lblSoTrangXuat = new javax.swing.JLabel();
        btnNextXuat = new javax.swing.JButton();
        btnCuoiXuat = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        btnTaoHoaDonXuat = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        btnXuat = new javax.swing.JButton();
        btnHuyXuat = new javax.swing.JButton();
        lblSTTXuat = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        txtGhiChuXuat = new javax.swing.JTextArea();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jplHoaDonChoXuat = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblHoaDonXuat = new javax.swing.JTable();
        jplXuatThatBai = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblHoaDonXuatThatBai = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1100, 780));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseEntered(evt);
            }
        });

        jblNhap.setBackground(new java.awt.Color(255, 255, 255));
        jblNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblNhapMouseClicked(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Đơn hàng"));
        jPanel4.setEnabled(false);

        btnTaoHoaDonNhap.setBackground(new java.awt.Color(234, 162, 96));
        btnTaoHoaDonNhap.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnTaoHoaDonNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/iconHoaDon.png"))); // NOI18N
        btnTaoHoaDonNhap.setText("Tạo hóa đơn");
        btnTaoHoaDonNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonNhapActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Hóa đơn");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Tổng tiền");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Ghi chú");

        btnNhap.setBackground(new java.awt.Color(0, 255, 0));
        btnNhap.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnNhap.setText("Nhập");
        btnNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapActionPerformed(evt);
            }
        });

        btnHuyNhap.setBackground(new java.awt.Color(255, 51, 51));
        btnHuyNhap.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnHuyNhap.setForeground(new java.awt.Color(255, 255, 255));
        btnHuyNhap.setText("Hủy");
        btnHuyNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyNhapActionPerformed(evt);
            }
        });

        txtGhiChuNhap.setColumns(20);
        txtGhiChuNhap.setLineWrap(true);
        txtGhiChuNhap.setRows(5);
        jScrollPane4.setViewportView(txtGhiChuNhap);

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("Nhà cung ứng");

        txtNhaCungUngNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNhaCungUngNhapActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setText("Đơn giá");

        txtDonGiaNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDonGiaNhapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                    .addComponent(btnHuyNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnTaoHoaDonNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(36, 36, 36)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel22)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel23)
                            .addGap(256, 256, 256))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(36, 36, 36)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtNhaCungUngNhap)
                                        .addComponent(lblSTTNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblTongTienNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                    .addGap(118, 118, 118)
                                    .addComponent(txtDonGiaNhap)))
                            .addGap(6, 6, 6)))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnTaoHoaDonNhap)
                .addGap(12, 12, 12)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblSTTNhap))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblTongTienNhap))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtNhaCungUngNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtDonGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(116, 116, 116)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnNhap)
                .addGap(18, 18, 18)
                .addComponent(btnHuyNhap)
                .addGap(28, 28, 28))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách sản phẩm"));
        jPanel3.setEnabled(false);

        tblSanPhamNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên sản phẩm", "Dung tích", "Nhãn hiệu", "Hương", "Danh mục", "Xuất xứ", "Số lượng tồn "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPhamNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamNhapMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanPhamNhap);

        btnThemNhap.setBackground(new java.awt.Color(234, 162, 96));
        btnThemNhap.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Them.png"))); // NOI18N
        btnThemNhap.setText("Thêm sản phẩm");
        btnThemNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNhapActionPerformed(evt);
            }
        });

        jLabel8.setText("Danh mục");

        jLabel9.setText("Nhãn hiệu");

        jLabel10.setText("Nhóm hương");

        jLabel11.setText("Xuất xứ");

        btnLocSpNhap.setBackground(new java.awt.Color(51, 255, 51));
        btnLocSpNhap.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLocSpNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Untitled-1.png"))); // NOI18N
        btnLocSpNhap.setText("Lọc");
        btnLocSpNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocSpNhapActionPerformed(evt);
            }
        });

        btnDauNhap.setText("Đầu");
        btnDauNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDauNhapMouseClicked(evt);
            }
        });

        btnPrevNhap.setText("<");
        btnPrevNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPrevNhapMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPrevNhapMouseEntered(evt);
            }
        });
        btnPrevNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevNhapActionPerformed(evt);
            }
        });

        btnNextNhap.setText(">");
        btnNextNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNextNhapMouseClicked(evt);
            }
        });
        btnNextNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextNhapActionPerformed(evt);
            }
        });

        btnCuoiNhap.setText("Cuối");
        btnCuoiNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCuoiNhapMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(btnLocSpNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(121, 121, 121))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel9))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cboNhanHieuNhap, 0, 178, Short.MAX_VALUE)
                                            .addComponent(cboDanhMucNhap, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cboXuatXuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cboNhomHuongNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnThemNhap, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btnDauNhap)
                        .addGap(18, 18, 18)
                        .addComponent(btnPrevNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblSoTrangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnNextNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCuoiNhap)
                        .addGap(157, 157, 157))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLocSpNhap))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboDanhMucNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboNhomHuongNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboNhanHieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboXuatXuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNextNhap)
                        .addComponent(btnPrevNhap)
                        .addComponent(btnCuoiNhap)
                        .addComponent(btnDauNhap))
                    .addComponent(lblSoTrangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Giỏ hàng"));

        tblGioHangNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên sản phẩm", "Dung tích", "Số lượng", "Đơn giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGioHangNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGioHangNhapMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblGioHangNhap);

        btnXoaGioHangNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Xoa.png"))); // NOI18N
        btnXoaGioHangNhap.setText("Xóa sản phẩm");
        btnXoaGioHangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaGioHangNhapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnXoaGioHangNhap)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnXoaGioHangNhap)
                        .addGap(81, 81, 81))))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Hóa đơn chờ"));

        tblHoaDonNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stt", "Người thêm", "Tên hóa đơn", "Tổng tiền", "Ngày thêm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDonNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonNhapMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblHoaDonNhap);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jblNhapLayout = new javax.swing.GroupLayout(jblNhap);
        jblNhap.setLayout(jblNhapLayout);
        jblNhapLayout.setHorizontalGroup(
            jblNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jblNhapLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jblNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jblNhapLayout.setVerticalGroup(
            jblNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jblNhapLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jblNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jblNhapLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34))
        );

        jTabbedPane1.addTab("Nhập hàng", jblNhap);

        jblXuat.setBackground(new java.awt.Color(255, 255, 255));
        jblXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblXuatMouseClicked(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Giỏ hàng"));

        tblGioHangXuat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên sản phẩm", "Dung tích", "Số lượng", "Số lượng thực tế", "Email NVCH"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGioHangXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGioHangXuatMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblGioHangXuat);

        btnXoaGioHangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Xoa.png"))); // NOI18N
        btnXoaGioHangXuat.setText("Xóa sản phẩm");
        btnXoaGioHangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaGioHangXuatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXoaGioHangXuat)
                .addGap(14, 14, 14))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(btnXoaGioHangXuat)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách sản phẩm"));
        jPanel9.setEnabled(false);

        tblSanPhamXuat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên sản phẩm", "Dung tích", "Nhãn hiệu", "Hương", "Danh mục", "Xuất xứ", "Số lượng tồn"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPhamXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamXuatMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tblSanPhamXuat);

        btnThemXuat.setBackground(new java.awt.Color(234, 162, 96));
        btnThemXuat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Them.png"))); // NOI18N
        btnThemXuat.setText("Thêm sản phẩm");
        btnThemXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemXuatActionPerformed(evt);
            }
        });

        jLabel17.setText("Danh mục");

        jLabel18.setText("Nhãn hiệu");

        jLabel19.setText("Nhóm hương");

        jLabel20.setText("Xuất xứ");

        btnLocSpXuat.setBackground(new java.awt.Color(51, 255, 51));
        btnLocSpXuat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLocSpXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Untitled-1.png"))); // NOI18N
        btnLocSpXuat.setText("Lọc");
        btnLocSpXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocSpXuatActionPerformed(evt);
            }
        });

        btnDauXuat.setText("Đầu");
        btnDauXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDauXuatMouseClicked(evt);
            }
        });

        btnPrevXuat.setText("<");
        btnPrevXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPrevXuatMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPrevXuatMouseEntered(evt);
            }
        });
        btnPrevXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevXuatActionPerformed(evt);
            }
        });

        btnNextXuat.setText(">");
        btnNextXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNextXuatMouseClicked(evt);
            }
        });
        btnNextXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextXuatActionPerformed(evt);
            }
        });

        btnCuoiXuat.setText("Cuối");
        btnCuoiXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCuoiXuatMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(btnLocSpXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(121, 121, 121))
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel17)
                                            .addComponent(jLabel18))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cboNhanHieuXuat, 0, 178, Short.MAX_VALUE)
                                            .addComponent(cboDanhMucXuat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cboXuatXuXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cboNhomHuongXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnThemXuat, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(btnDauXuat)
                        .addGap(18, 18, 18)
                        .addComponent(btnPrevXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblSoTrangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnNextXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCuoiXuat)
                        .addGap(156, 156, 156))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLocSpXuat))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboDanhMucXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboNhomHuongXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboNhanHieuXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboXuatXuXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNextXuat)
                        .addComponent(btnPrevXuat)
                        .addComponent(btnCuoiXuat)
                        .addComponent(btnDauXuat))
                    .addComponent(lblSoTrangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(92, 92, 92))
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Đơn hàng"));
        jPanel10.setEnabled(false);

        btnTaoHoaDonXuat.setBackground(new java.awt.Color(234, 162, 96));
        btnTaoHoaDonXuat.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnTaoHoaDonXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/iconHoaDon.png"))); // NOI18N
        btnTaoHoaDonXuat.setText("Tạo hóa đơn");
        btnTaoHoaDonXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonXuatActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Hóa đơn");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Ghi chú");

        btnXuat.setBackground(new java.awt.Color(0, 255, 0));
        btnXuat.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnXuat.setText("Xuất");
        btnXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatActionPerformed(evt);
            }
        });

        btnHuyXuat.setBackground(new java.awt.Color(255, 51, 51));
        btnHuyXuat.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnHuyXuat.setForeground(new java.awt.Color(255, 255, 255));
        btnHuyXuat.setText("Hủy");
        btnHuyXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyXuatActionPerformed(evt);
            }
        });

        lblSTTXuat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtGhiChuXuat.setColumns(20);
        txtGhiChuXuat.setLineWrap(true);
        txtGhiChuXuat.setRows(5);
        jScrollPane9.setViewportView(txtGhiChuXuat);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnXuat, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                    .addComponent(btnHuyXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnTaoHoaDonXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(36, 36, 36)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblSTTXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                            .addContainerGap()))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnTaoHoaDonXuat)
                .addGap(12, 12, 12)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblSTTXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 289, Short.MAX_VALUE)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnXuat)
                .addGap(18, 18, 18)
                .addComponent(btnHuyXuat)
                .addGap(28, 28, 28))
        );

        jTabbedPane2.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTabbedPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane2MouseClicked(evt);
            }
        });

        jplHoaDonChoXuat.setBackground(new java.awt.Color(255, 255, 255));

        tblHoaDonXuat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stt", "Người thêm", "Tên hóa đơn", "Ngày thêm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDonXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonXuatMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblHoaDonXuat);

        javax.swing.GroupLayout jplHoaDonChoXuatLayout = new javax.swing.GroupLayout(jplHoaDonChoXuat);
        jplHoaDonChoXuat.setLayout(jplHoaDonChoXuatLayout);
        jplHoaDonChoXuatLayout.setHorizontalGroup(
            jplHoaDonChoXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplHoaDonChoXuatLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jplHoaDonChoXuatLayout.setVerticalGroup(
            jplHoaDonChoXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplHoaDonChoXuatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Hóa đơn chờ", jplHoaDonChoXuat);

        jplXuatThatBai.setBackground(new java.awt.Color(255, 255, 255));

        tblHoaDonXuatThatBai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stt", "Ngày thêm", "Ghi chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDonXuatThatBai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonXuatThatBaiMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tblHoaDonXuatThatBai);

        javax.swing.GroupLayout jplXuatThatBaiLayout = new javax.swing.GroupLayout(jplXuatThatBai);
        jplXuatThatBai.setLayout(jplXuatThatBaiLayout);
        jplXuatThatBaiLayout.setHorizontalGroup(
            jplXuatThatBaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplXuatThatBaiLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jplXuatThatBaiLayout.setVerticalGroup(
            jplXuatThatBaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplXuatThatBaiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Xuất thất bại", jplXuatThatBai);

        javax.swing.GroupLayout jblXuatLayout = new javax.swing.GroupLayout(jblXuat);
        jblXuat.setLayout(jblXuatLayout);
        jblXuatLayout.setHorizontalGroup(
            jblXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jblXuatLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jblXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        jblXuatLayout.setVerticalGroup(
            jblXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jblXuatLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jblXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jblXuatLayout.createSequentialGroup()
                        .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Xuất hàng", jblXuat);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        
//        if (jblNhap.isShowing()) {
//            fillToTableSanPhamNhap(lstSanPhamViewNhap);
//        }else if (jblXuat.isShowing()) {
//            fillToTableSanPhamXuat(lstSanPhamViewXuat);
//        }
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jTabbedPane1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1MouseEntered

    private void jblXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblXuatMouseClicked

    }//GEN-LAST:event_jblXuatMouseClicked

    private void jblNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblNhapMouseClicked

    }//GEN-LAST:event_jblNhapMouseClicked

    private void btnTaoHoaDonNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonNhapActionPerformed

        JOptionPane.showMessageDialog(this, khoHangService.taoHoaDon(idNhanVienKho, 5));
        lstHoaDonNhap = khoHangService.getHoaDon(5);
        fillToTableHoaDonNhap(lstHoaDonNhap);

        lblSTTNhap.setText("");
        lblTongTienNhap.setText("");
    }//GEN-LAST:event_btnTaoHoaDonNhapActionPerformed

    private void btnNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapActionPerformed
        if (checkRongTxt(txtNhaCungUngNhap) == false) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập nhà cung ứng");
        } else if (tblGioHangNhap.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng thêm sản phẩm");
        } else {
            if (JOptionPane.showConfirmDialog(this, "Bạn có muốn nhập không") == JOptionPane.YES_OPTION) {
                KhoHang_HoaDonView khoHang_HoaDonView = new KhoHang_HoaDonView();
                khoHang_HoaDonView.setGhiChu(txtGhiChuNhap.getText());
                khoHang_HoaDonView.setNhaCungUng(txtNhaCungUngNhap.getText());
                khoHang_HoaDonView.setIdHoaDon(lstHoaDonNhap.get(hoaDonNhapIndex).getIdHoaDon());
                JOptionPane.showMessageDialog(this, khoHangService.nhap(khoHang_HoaDonView, idNhanVienKho));
                lstHoaDonNhap = khoHangService.getHoaDon(5);
                if (lstHoaDonNhap.isEmpty()) {
                    modelHoaDonNhap.setRowCount(0);
                } else {
                    fillToTableHoaDonNhap(lstHoaDonNhap);
                    lstSanPhamViewXuat = khoHangService.findSanPham(idDanhMucXuat, idNhanHieuXuat, idNhomHuongXuat, idXuatXuXuat, getStart(_soTrangSpXuat), getEnd(_soTrangSpXuat));
                    fillToTableSanPhamXuat(lstSanPhamViewXuat);
                }
                modelHoaDonChiTietNhap.setRowCount(0);
                lblSTTNhap.setText("");
                txtGhiChuNhap.setText("");
                lblTongTienNhap.setText("");
                txtDonGiaNhap.setText("");
                txtNhaCungUngNhap.setText("");
            }

        }

    }//GEN-LAST:event_btnNhapActionPerformed

    private void btnHuyNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyNhapActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Bạn có muốn hủy không") == JOptionPane.YES_OPTION) {
            lstHoaDonChiTietViewNhap = khoHangService.getHoaDonChiTietByIdHoaDon(lstHoaDonNhap.get(hoaDonNhapIndex).getIdHoaDon());
            if (khoHangService.huy(lstHoaDonChiTietViewNhap, lstHoaDonNhap.get(hoaDonNhapIndex).getIdHoaDon(), 5)) {
                lstHoaDonNhap = khoHangService.getHoaDon(5);
                if (lstHoaDonNhap.isEmpty()) {
                    modelHoaDonNhap.setRowCount(0);
                } else {
                    fillToTableHoaDonNhap(lstHoaDonNhap);
                }

                modelHoaDonChiTietNhap.setRowCount(0);

                lstSanPhamViewNhap = khoHangService.findSanPham(idDanhMucNhap, idNhanHieuNhap, idNhomHuongNhap, idXuatXuNhap, getStart(_soTrangSpNhap), getEnd(_soTrangSpNhap));
                fillToTableSanPhamNhap(lstSanPhamViewNhap);

                JOptionPane.showMessageDialog(this, "Hủy thành công");
                lblSTTNhap.setText("");
                txtGhiChuNhap.setText("");
                lblTongTienNhap.setText("");
                txtDonGiaNhap.setText("");
                txtNhaCungUngNhap.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Hủy thất bại");
            }
        }


    }//GEN-LAST:event_btnHuyNhapActionPerformed

    private void tblSanPhamNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamNhapMouseClicked
        sanPhamNhapIndex = tblSanPhamNhap.getSelectedRow();
    }//GEN-LAST:event_tblSanPhamNhapMouseClicked

    private void btnThemNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNhapActionPerformed

        KhoHang_HoaDonChiTietView khoHang_HoaDonChiTietView = new KhoHang_HoaDonChiTietView();
        khoHang_HoaDonChiTietView.setDungTich(lstSanPhamViewNhap.get(sanPhamNhapIndex).getDungTich());
        khoHang_HoaDonChiTietView.setTenSp(lstSanPhamViewNhap.get(sanPhamNhapIndex).getTenSp());
        khoHang_HoaDonChiTietView.setSoLuong(Integer.parseInt(JOptionPane.showInputDialog("Nhap so luong")));

        if (lblSTTNhap.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn");
        } else if (checkRongTxt(txtDonGiaNhap) == false) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đơn giá");
        } else if (checkPhaiLaSo(txtDonGiaNhap) == false) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đơn giá là số");
        } else if (checkDonGiaLonHon0(txtDonGiaNhap) == false) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đơn > 0");
        } else if (khoHang_HoaDonChiTietView.getSoLuong() < 1) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng > 0");
        } else {
            khoHang_HoaDonChiTietView.setDonGia(new BigDecimal(txtDonGiaNhap.getText()));
            if (checkThemTrungSanPhamNhap(khoHang_HoaDonChiTietView.getTenSp(), khoHang_HoaDonChiTietView.getDungTich()) == false) {
                int soLuong = khoHang_HoaDonChiTietView.getSoLuong();
                String idHoaDon = lstHoaDonNhap.get(hoaDonNhapIndex).getIdHoaDon();
                String idSanPham = khoHangService.getIDSanPham(khoHang_HoaDonChiTietView.getTenSp(), khoHang_HoaDonChiTietView.getDungTich());
                JOptionPane.showMessageDialog(this, khoHangService.updateHoaDonChiTiet(soLuong, idHoaDon, idSanPham, 5));
                lstHoaDonChiTietViewNhap = khoHangService.getHoaDonChiTietByIdHoaDon(lstHoaDonNhap.get(hoaDonNhapIndex).getIdHoaDon());
                fillToTableHoaDonChiTietNhap(lstHoaDonChiTietViewNhap);
                lstSanPhamViewNhap = khoHangService.findSanPham(idDanhMucNhap, idNhanHieuNhap, idNhomHuongNhap, idXuatXuNhap, getStart(_soTrangSpNhap), getEnd(_soTrangSpNhap));

                fillToTableSanPhamNhap(lstSanPhamViewNhap);

                lstHoaDonNhap = khoHangService.getHoaDon(5);
                fillToTableHoaDonNhap(lstHoaDonNhap);

                lblTongTienNhap.setText(String.valueOf(lstHoaDonNhap.get(hoaDonNhapIndex).getTongTien()));
            } else {
                JOptionPane.showMessageDialog(this, khoHangService.taoHoaDonChiTiet(khoHang_HoaDonChiTietView, lstHoaDonNhap.get(hoaDonNhapIndex).getIdHoaDon(), 5));
                lstHoaDonChiTietViewNhap = khoHangService.getHoaDonChiTietByIdHoaDon(lstHoaDonNhap.get(hoaDonNhapIndex).getIdHoaDon());
                fillToTableHoaDonChiTietNhap(lstHoaDonChiTietViewNhap);
                lstSanPhamViewNhap = khoHangService.findSanPham(idDanhMucNhap, idNhanHieuNhap, idNhomHuongNhap, idXuatXuNhap, getStart(_soTrangSpNhap), getEnd(_soTrangSpNhap));

                fillToTableSanPhamNhap(lstSanPhamViewNhap);

                lstHoaDonNhap = khoHangService.getHoaDon(5);
                fillToTableHoaDonNhap(lstHoaDonNhap);

                lblTongTienNhap.setText(String.valueOf(lstHoaDonNhap.get(hoaDonNhapIndex).getTongTien()));
            }

        }

    }//GEN-LAST:event_btnThemNhapActionPerformed

    private void btnLocSpNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocSpNhapActionPerformed
        _soTrangSpNhap = 1;
        idDanhMucNhap = khoHangService.getIDDanhMuc(cboDanhMucNhap.getSelectedItem() + "");
        idNhanHieuNhap = khoHangService.getIDNhanHieu(cboNhanHieuNhap.getSelectedItem() + "");
        idNhomHuongNhap = khoHangService.getIDNhomHuong(cboNhomHuongNhap.getSelectedItem() + "");
        idXuatXuNhap = khoHangService.getIDXuatXu(cboXuatXuNhap.getSelectedItem() + "");
        DanhMucNhap = cboDanhMucNhap.getSelectedItem() + "";
        NhanHieuNhap = cboNhanHieuNhap.getSelectedItem() + "";
        NhomHuongNhap = cboNhomHuongNhap.getSelectedItem() + "";
        XuatXuNhap = cboXuatXuNhap.getSelectedItem() + "";
        lstSanPhamViewNhap = khoHangService.findSanPham(idDanhMucNhap, idNhanHieuNhap, idNhomHuongNhap, idXuatXuNhap, getStart(_soTrangSpNhap), getEnd(_soTrangSpNhap));
        if (lstSanPhamViewNhap.size() == 0) {
            modelSanPhamNhap.setRowCount(0);
            JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm");
        } else {
            lblSoTrangNhap.setText(_soTrangSpNhap + "");
            fillToTableSanPhamNhap(lstSanPhamViewNhap);
        }

    }//GEN-LAST:event_btnLocSpNhapActionPerformed

    private void tblGioHangNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHangNhapMouseClicked
        gioHangNhapIndex = tblGioHangNhap.getSelectedRow();
    }//GEN-LAST:event_tblGioHangNhapMouseClicked

    private void btnXoaGioHangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaGioHangNhapActionPerformed
        if (lblSTTNhap.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn");
        } else {
            if (JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không") == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(this, khoHangService.deleteHoaDonChiTiet(lstHoaDonChiTietViewNhap.get(gioHangNhapIndex).getTenSp(), lstHoaDonNhap.get(hoaDonNhapIndex).getIdHoaDon(), lstHoaDonChiTietViewNhap.get(gioHangNhapIndex).getSoLuong(), 5, lstHoaDonChiTietViewNhap.get(gioHangNhapIndex).getDungTich()));
                lstHoaDonChiTietViewNhap = khoHangService.getHoaDonChiTietByIdHoaDon(lstHoaDonNhap.get(hoaDonNhapIndex).getIdHoaDon());
                if (lstHoaDonChiTietViewNhap.isEmpty()) {
                    modelHoaDonChiTietNhap.setRowCount(0);
                } else {
                    lstHoaDonChiTietViewNhap = khoHangService.getHoaDonChiTietByIdHoaDon(lstHoaDonNhap.get(hoaDonNhapIndex).getIdHoaDon());
                    fillToTableHoaDonChiTietNhap(lstHoaDonChiTietViewNhap);
                }
                lstSanPhamViewNhap = khoHangService.findSanPham(idDanhMucNhap, idNhanHieuNhap, idNhomHuongNhap, idXuatXuNhap, getStart(_soTrangSpNhap), getEnd(_soTrangSpNhap));
                fillToTableSanPhamNhap(lstSanPhamViewNhap);
                lstHoaDonNhap = khoHangService.getHoaDon(5);
                fillToTableHoaDonNhap(lstHoaDonNhap);
                lblTongTienNhap.setText(String.valueOf(lstHoaDonNhap.get(hoaDonNhapIndex).getTongTien()));
            }

        }
    }//GEN-LAST:event_btnXoaGioHangNhapActionPerformed

    private void tblHoaDonNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonNhapMouseClicked
        hoaDonNhapIndex = tblHoaDonNhap.getSelectedRow();
        lstHoaDonNhap = khoHangService.getHoaDon(5);
        fillOnClickHoaDonNhap(hoaDonNhapIndex, lstHoaDonNhap);
        lblSTTNhap.setText(String.valueOf(tblHoaDonNhap.getValueAt(hoaDonNhapIndex, 0)));
        lblTongTienNhap.setText(String.valueOf(lstHoaDonNhap.get(hoaDonNhapIndex).getTongTien()));
    }//GEN-LAST:event_tblHoaDonNhapMouseClicked

    private void tblHoaDonXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonXuatMouseClicked
        hoaDonXuatIndex = tblHoaDonXuat.getSelectedRow();
        lstHoaDonXuat = khoHangService.getHoaDon(6);
        fillOnClickHoaDonXuat(hoaDonXuatIndex, lstHoaDonXuat);
        lblSTTXuat.setText(String.valueOf(tblHoaDonXuat.getValueAt(hoaDonXuatIndex, 0)));

    }//GEN-LAST:event_tblHoaDonXuatMouseClicked

    private void tblGioHangXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHangXuatMouseClicked
        gioHangXuatIndex = tblGioHangXuat.getSelectedRow();
    }//GEN-LAST:event_tblGioHangXuatMouseClicked

    private void btnXoaGioHangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaGioHangXuatActionPerformed
        if (lblSTTXuat.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn");
        } else {
            if (JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không") == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(this, khoHangService.deleteHoaDonChiTiet(lstHoaDonChiTietViewXuat.get(gioHangXuatIndex).getTenSp(), lstHoaDonXuat.get(hoaDonXuatIndex).getIdHoaDon(), lstHoaDonChiTietViewXuat.get(gioHangXuatIndex).getSoLuong(), 6, lstHoaDonChiTietViewXuat.get(gioHangXuatIndex).getDungTich()));
                lstHoaDonChiTietViewXuat = khoHangService.getHoaDonChiTietByIdHoaDon(lstHoaDonXuat.get(hoaDonXuatIndex).getIdHoaDon());
                if (lstHoaDonChiTietViewXuat.isEmpty()) {
                    modelHoaDonChiTietXuat.setRowCount(0);
                } else {
                    lstHoaDonChiTietViewXuat = khoHangService.getHoaDonChiTietByIdHoaDon(lstHoaDonXuat.get(hoaDonXuatIndex).getIdHoaDon());
                    fillToTableHoaDonChiTietXuat(lstHoaDonChiTietViewXuat);
                }

                lstSanPhamViewXuat = khoHangService.findSanPham(idDanhMucXuat, idNhanHieuXuat, idNhomHuongXuat, idXuatXuXuat, getStart(_soTrangSpXuat), getEnd(_soTrangSpXuat));
                fillToTableSanPhamXuat(lstSanPhamViewXuat);

                lstHoaDonXuat = khoHangService.getHoaDon(6);
                fillToTableHoaDonXuat(lstHoaDonXuat);
            }

        }
    }//GEN-LAST:event_btnXoaGioHangXuatActionPerformed

    private void tblSanPhamXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamXuatMouseClicked
        sanPhamXuatIndex = tblSanPhamXuat.getSelectedRow();
    }//GEN-LAST:event_tblSanPhamXuatMouseClicked

    private void btnThemXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemXuatActionPerformed

        lstHoaDonChiTietViewXuat = khoHangService.getHoaDonChiTietByIdHoaDon(lstHoaDonXuat.get(hoaDonXuatIndex).getIdHoaDon());
        KhoHang_HoaDonChiTietView khoHang_HoaDonChiTietView = new KhoHang_HoaDonChiTietView();
        khoHang_HoaDonChiTietView.setDungTich(lstSanPhamViewXuat.get(sanPhamXuatIndex).getDungTich());
        khoHang_HoaDonChiTietView.setTenSp(lstSanPhamViewXuat.get(sanPhamXuatIndex).getTenSp());
        khoHang_HoaDonChiTietView.setSoLuong(Integer.parseInt(JOptionPane.showInputDialog("Nhap so luong")));
        khoHang_HoaDonChiTietView.setDonGia(BigDecimal.valueOf(0));

        if (lblSTTXuat.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn");
        } else if (khoHang_HoaDonChiTietView.getSoLuong() < 1) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng > 0");
        } else if (checkThemKoVuotQuaSoLuongTon(khoHang_HoaDonChiTietView.getSoLuong()) == false) {
            JOptionPane.showMessageDialog(this, "Vui lòng không nhập quá số lượng trong kho");
        } else {

            if (checkThemTrungSanPhamXuat(khoHang_HoaDonChiTietView.getTenSp(), khoHang_HoaDonChiTietView.getDungTich()) == false) {
                int soLuong = khoHang_HoaDonChiTietView.getSoLuong();
                String idHoaDon = lstHoaDonXuat.get(hoaDonXuatIndex).getIdHoaDon();

                String idSanPham = khoHangService.getIDSanPham(khoHang_HoaDonChiTietView.getTenSp(), khoHang_HoaDonChiTietView.getDungTich());
                JOptionPane.showMessageDialog(this, khoHangService.updateHoaDonChiTiet(soLuong, idHoaDon, idSanPham, 6));
                lstHoaDonChiTietViewXuat = khoHangService.getHoaDonChiTietByIdHoaDon(lstHoaDonXuat.get(hoaDonXuatIndex).getIdHoaDon());
                fillToTableHoaDonChiTietXuat(lstHoaDonChiTietViewXuat);

                lstSanPhamViewXuat = khoHangService.findSanPham(idDanhMucXuat, idNhanHieuXuat, idNhomHuongXuat, idXuatXuXuat, getStart(_soTrangSpXuat), getEnd(_soTrangSpXuat));
                fillToTableSanPhamXuat(lstSanPhamViewXuat);

                fillToTableHoaDonChiTietNhap(lstHoaDonChiTietViewNhap);
                lstHoaDonXuat = khoHangService.getHoaDon(6);
                fillToTableHoaDonXuat(lstHoaDonXuat);

            } else {
                JOptionPane.showMessageDialog(this, khoHangService.taoHoaDonChiTiet(khoHang_HoaDonChiTietView, lstHoaDonXuat.get(hoaDonXuatIndex).getIdHoaDon(), 6));
                lstHoaDonChiTietViewXuat = khoHangService.getHoaDonChiTietByIdHoaDon(lstHoaDonXuat.get(hoaDonXuatIndex).getIdHoaDon());
                fillToTableHoaDonChiTietXuat(lstHoaDonChiTietViewXuat);

                lstSanPhamViewXuat = khoHangService.findSanPham(idDanhMucXuat, idNhanHieuXuat, idNhomHuongXuat, idXuatXuXuat, getStart(_soTrangSpXuat), getEnd(_soTrangSpXuat));
                fillToTableSanPhamXuat(lstSanPhamViewXuat);

                fillToTableHoaDonChiTietNhap(lstHoaDonChiTietViewNhap);
                lstHoaDonXuat = khoHangService.getHoaDon(6);
                fillToTableHoaDonXuat(lstHoaDonXuat);

            }

        }
    }//GEN-LAST:event_btnThemXuatActionPerformed

    private void btnLocSpXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocSpXuatActionPerformed
        _soTrangSpXuat = 1;
        idDanhMucXuat = khoHangService.getIDDanhMuc(cboDanhMucXuat.getSelectedItem() + "");
        idNhanHieuXuat = khoHangService.getIDNhanHieu(cboNhanHieuXuat.getSelectedItem() + "");
        idNhomHuongXuat = khoHangService.getIDNhomHuong(cboNhomHuongXuat.getSelectedItem() + "");
        idXuatXuXuat = khoHangService.getIDXuatXu(cboXuatXuXuat.getSelectedItem() + "");
        DanhMucXuat = cboDanhMucXuat.getSelectedItem() + "";
        NhanHieuXuat = cboNhanHieuXuat.getSelectedItem() + "";
        NhomHuongXuat = cboNhomHuongXuat.getSelectedItem() + "";
        XuatXuXuat = cboXuatXuXuat.getSelectedItem() + "";
        lstSanPhamViewXuat = khoHangService.findSanPham(idDanhMucXuat, idNhanHieuXuat, idNhomHuongXuat, idXuatXuXuat, getStart(_soTrangSpXuat), getEnd(_soTrangSpXuat));
        if (lstSanPhamViewXuat.size() == 0) {
            modelSanPhamXuat.setRowCount(0);
            JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm");
        } else {
            lblSoTrangXuat.setText(_soTrangSpXuat + "");
            fillToTableSanPhamXuat(lstSanPhamViewXuat);
        }
    }//GEN-LAST:event_btnLocSpXuatActionPerformed

    private void btnTaoHoaDonXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonXuatActionPerformed
        JOptionPane.showMessageDialog(this, khoHangService.taoHoaDon(idNhanVienKho, 6));
        lstHoaDonXuat = khoHangService.getHoaDon(6);
        fillToTableHoaDonXuat(lstHoaDonXuat);

        lblSTTXuat.setText("");

    }//GEN-LAST:event_btnTaoHoaDonXuatActionPerformed

    private void btnXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatActionPerformed
        if (tblGioHangXuat.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng thêm sản phẩm");
        } else {
            if (JOptionPane.showConfirmDialog(this, "Bạn có muốn xuất không") == JOptionPane.YES_OPTION) {
                KhoHang_HoaDonView khoHang_HoaDonView = new KhoHang_HoaDonView();
                khoHang_HoaDonView.setGhiChu(txtGhiChuXuat.getText());

                khoHang_HoaDonView.setIdHoaDon(lstHoaDonXuat.get(hoaDonXuatIndex).getIdHoaDon());
                JOptionPane.showMessageDialog(this, khoHangService.xuat(khoHang_HoaDonView, idNhanVienKho));
                lstHoaDonXuat = khoHangService.getHoaDon(6);
                if (lstHoaDonXuat.isEmpty()) {
                    modelHoaDonXuat.setRowCount(0);
                } else {
                    fillToTableHoaDonXuat(lstHoaDonXuat);
                    lstSanPhamViewNhap = khoHangService.findSanPham(idDanhMucNhap, idNhanHieuNhap, idNhomHuongNhap, idXuatXuNhap, getStart(_soTrangSpNhap), getEnd(_soTrangSpNhap));
                    fillToTableSanPhamNhap(lstSanPhamViewNhap);
                }
                modelHoaDonChiTietXuat.setRowCount(0);
                lblSTTXuat.setText("");
                txtGhiChuXuat.setText("");
            }

        }


    }//GEN-LAST:event_btnXuatActionPerformed

    private void btnHuyXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyXuatActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Bạn có muốn hủy không") == JOptionPane.YES_OPTION) {
            lstHoaDonChiTietViewXuat = khoHangService.getHoaDonChiTietByIdHoaDon(lstHoaDonXuat.get(hoaDonXuatIndex).getIdHoaDon());
            if (khoHangService.huy(lstHoaDonChiTietViewXuat, lstHoaDonXuat.get(hoaDonXuatIndex).getIdHoaDon(), 6)) {
                lstHoaDonXuat = khoHangService.getHoaDon(6);
                if (lstHoaDonXuat.isEmpty()) {
                    modelHoaDonXuat.setRowCount(0);
                } else {
                    fillToTableHoaDonXuat(lstHoaDonXuat);
                }
                modelHoaDonChiTietXuat.setRowCount(0);
                lstSanPhamViewXuat = khoHangService.findSanPham(idDanhMucXuat, idNhanHieuXuat, idNhomHuongXuat, idXuatXuXuat, getStart(_soTrangSpXuat), getEnd(_soTrangSpXuat));
                fillToTableSanPhamXuat(lstSanPhamViewXuat);
                JOptionPane.showMessageDialog(this, "Hủy thành công");
                lblSTTXuat.setText("");
                txtGhiChuXuat.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Hủy thất bại");
            }
        }

    }//GEN-LAST:event_btnHuyXuatActionPerformed

    private void txtNhaCungUngNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNhaCungUngNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNhaCungUngNhapActionPerformed

    private void txtDonGiaNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDonGiaNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDonGiaNhapActionPerformed

    private void tblHoaDonXuatThatBaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonXuatThatBaiMouseClicked
        indexHoaDonXuatThatBai = tblHoaDonXuatThatBai.getSelectedRow();
        fillOnClickHoaDonXuat(indexHoaDonXuatThatBai, lstHoaDonXuatThatBai);
    }//GEN-LAST:event_tblHoaDonXuatThatBaiMouseClicked

    private void jTabbedPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane2MouseClicked
        if (jblXuat.isShowing() && jplXuatThatBai.isShowing()) {
            modelHoaDonChiTietXuat.setRowCount(0);
            btnXoaGioHangXuat.setVisible(false);
            tblGioHangXuat.getColumnModel().getColumn(3).setMinWidth(130);
            tblGioHangXuat.getColumnModel().getColumn(3).setMaxWidth(130);
            tblGioHangXuat.getColumnModel().getColumn(4).setMinWidth(130);
            tblGioHangXuat.getColumnModel().getColumn(4).setMaxWidth(130);
        } else if (jblXuat.isShowing() && jplHoaDonChoXuat.isShowing()) {
            modelHoaDonChiTietXuat.setRowCount(0);
            btnXoaGioHangXuat.setVisible(true);
            tblGioHangXuat.getColumnModel().getColumn(3).setMinWidth(0);
            tblGioHangXuat.getColumnModel().getColumn(3).setMaxWidth(0);
            tblGioHangXuat.getColumnModel().getColumn(4).setMinWidth(0);
            tblGioHangXuat.getColumnModel().getColumn(4).setMaxWidth(0);

        }

    }//GEN-LAST:event_jTabbedPane2MouseClicked

    private void btnDauXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDauXuatMouseClicked
        _soTrangSpXuat = 1;
        lblSoTrangXuat.setText(String.valueOf(_soTrangSpXuat));
        lstSanPhamViewXuat = khoHangService.findSanPham(idDanhMucXuat, idNhanHieuXuat, idNhomHuongXuat, idXuatXuXuat, getStart(_soTrangSpXuat), getEnd(_soTrangSpXuat));
        fillToTableSanPhamXuat(lstSanPhamViewXuat);
        setCboTimKiemTruocKhiFillLaiXuat();
    }//GEN-LAST:event_btnDauXuatMouseClicked

    private void btnPrevXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrevXuatMouseClicked
        _soTrangSpXuat--;
        int soTrang;
        int soDong = khoHangService.getSoDong(idDanhMucXuat, idNhanHieuXuat, idNhomHuongXuat, idXuatXuXuat);
        double page = soDong % 4.0;
        if (page != 0.0) {
            soTrang = soDong / 4;
            soTrang++;
        } else {
            soTrang = soDong / 4;
        }
        if (_soTrangSpXuat == 0) {
            _soTrangSpXuat = soTrang;
            lblSoTrangXuat.setText(String.valueOf(_soTrangSpXuat));
            lstSanPhamViewXuat = khoHangService.findSanPham(idDanhMucXuat, idNhanHieuXuat, idNhomHuongXuat, idXuatXuXuat, getStart(_soTrangSpXuat), getEnd(_soTrangSpXuat));
            fillToTableSanPhamXuat(lstSanPhamViewXuat);
            setCboTimKiemTruocKhiFillLaiXuat();
        } else {
            lblSoTrangXuat.setText(String.valueOf(_soTrangSpXuat));
            lstSanPhamViewXuat = khoHangService.findSanPham(idDanhMucXuat, idNhanHieuXuat, idNhomHuongXuat, idXuatXuXuat, getStart(_soTrangSpXuat), getEnd(_soTrangSpXuat));
            fillToTableSanPhamXuat(lstSanPhamViewXuat);
            setCboTimKiemTruocKhiFillLaiXuat();
        }
    }//GEN-LAST:event_btnPrevXuatMouseClicked

    private void btnPrevXuatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrevXuatMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrevXuatMouseEntered

    private void btnPrevXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevXuatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrevXuatActionPerformed

    private void btnNextXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextXuatMouseClicked
        _soTrangSpXuat++;
        int soTrang;
        int soDong = khoHangService.getSoDong(idDanhMucXuat, idNhanHieuXuat, idNhomHuongXuat, idXuatXuXuat);
        double page = soDong % 4.0;
        if (page != 0.0) {
            soTrang = soDong / 4;
            soTrang++;
        } else {
            soTrang = soDong / 4;
        }
        if (_soTrangSpXuat > soTrang) {
            _soTrangSpXuat = 1;
            lblSoTrangXuat.setText(String.valueOf(_soTrangSpXuat));
            lstSanPhamViewXuat = khoHangService.findSanPham(idDanhMucXuat, idNhanHieuXuat, idNhomHuongXuat, idXuatXuXuat, getStart(_soTrangSpXuat), getEnd(_soTrangSpXuat));
            fillToTableSanPhamXuat(lstSanPhamViewXuat);
            setCboTimKiemTruocKhiFillLaiXuat();
        } else {
            lblSoTrangXuat.setText(String.valueOf(_soTrangSpXuat));
            lstSanPhamViewXuat = khoHangService.findSanPham(idDanhMucXuat, idNhanHieuXuat, idNhomHuongXuat, idXuatXuXuat, getStart(_soTrangSpXuat), getEnd(_soTrangSpXuat));
            fillToTableSanPhamXuat(lstSanPhamViewXuat);
            setCboTimKiemTruocKhiFillLaiXuat();
        }
    }//GEN-LAST:event_btnNextXuatMouseClicked

    private void btnNextXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextXuatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNextXuatActionPerformed

    private void btnCuoiXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCuoiXuatMouseClicked
        int soDong = khoHangService.getSoDong(idDanhMucXuat, idNhanHieuXuat, idNhomHuongXuat, idXuatXuXuat);
        double page = soDong % 4.0;
        if (page != 0.0) {
            _soTrangSpXuat = soDong / 4;
            _soTrangSpXuat++;
        } else {
            _soTrangSpXuat = soDong / 4;
        }
        lblSoTrangXuat.setText(String.valueOf(_soTrangSpXuat));
        lstSanPhamViewXuat = khoHangService.findSanPham(idDanhMucXuat, idNhanHieuXuat, idNhomHuongXuat, idXuatXuXuat, getStart(_soTrangSpXuat), getEnd(_soTrangSpXuat));
        fillToTableSanPhamXuat(lstSanPhamViewXuat);
        setCboTimKiemTruocKhiFillLaiXuat ();
    }//GEN-LAST:event_btnCuoiXuatMouseClicked

    private void btnDauNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDauNhapMouseClicked
        _soTrangSpNhap = 1;
        lblSoTrangNhap.setText(String.valueOf(_soTrangSpNhap));
        lstSanPhamViewNhap = khoHangService.findSanPham(idDanhMucNhap, idNhanHieuNhap, idNhomHuongNhap, idXuatXuNhap, getStart(_soTrangSpNhap), getEnd(_soTrangSpNhap));
        fillToTableSanPhamNhap(lstSanPhamViewNhap);
        setCboTimKiemTruocKhiFillLaiNhap ();
    }//GEN-LAST:event_btnDauNhapMouseClicked

    private void btnPrevNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrevNhapMouseClicked
        _soTrangSpNhap--;
        int soTrang;
        int soDong = khoHangService.getSoDong(idDanhMucNhap, idNhanHieuNhap, idNhomHuongNhap, idXuatXuNhap);
        double page = soDong % 4.0;
        if (page != 0.0) {
            soTrang = soDong / 4;
            soTrang++;
        } else {
            soTrang = soDong / 4;
        }
        if (_soTrangSpNhap == 0) {
            _soTrangSpNhap = soTrang;
            lblSoTrangNhap.setText(String.valueOf(_soTrangSpNhap));
            lstSanPhamViewNhap = khoHangService.findSanPham(idDanhMucNhap, idNhanHieuNhap, idNhomHuongNhap, idXuatXuNhap, getStart(_soTrangSpNhap), getEnd(_soTrangSpNhap));
            fillToTableSanPhamNhap(lstSanPhamViewNhap);
            setCboTimKiemTruocKhiFillLaiNhap ();
        } else {
            lblSoTrangNhap.setText(String.valueOf(_soTrangSpNhap));
            lstSanPhamViewNhap = khoHangService.findSanPham(idDanhMucNhap, idNhanHieuNhap, idNhomHuongNhap, idXuatXuNhap, getStart(_soTrangSpNhap), getEnd(_soTrangSpNhap));
            fillToTableSanPhamNhap(lstSanPhamViewNhap);
            setCboTimKiemTruocKhiFillLaiNhap ();
        }
    }//GEN-LAST:event_btnPrevNhapMouseClicked

    private void btnPrevNhapMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrevNhapMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrevNhapMouseEntered

    private void btnPrevNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrevNhapActionPerformed

    private void btnNextNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextNhapMouseClicked
        _soTrangSpNhap++;
        int soTrang;
        int soDong = khoHangService.getSoDong(idDanhMucNhap, idNhanHieuNhap, idNhomHuongNhap, idXuatXuNhap);
        double page = soDong % 4.0;
        if (page != 0.0) {
            soTrang = soDong / 4;
            soTrang++;
        } else {
            soTrang = soDong / 4;
        }
        if (_soTrangSpNhap > soTrang) {
            _soTrangSpNhap = 1;
            lblSoTrangNhap.setText(String.valueOf(_soTrangSpNhap));
            lstSanPhamViewNhap = khoHangService.findSanPham(idDanhMucNhap, idNhanHieuNhap, idNhomHuongNhap, idXuatXuNhap, getStart(_soTrangSpNhap), getEnd(_soTrangSpNhap));
            fillToTableSanPhamNhap(lstSanPhamViewNhap);
            setCboTimKiemTruocKhiFillLaiNhap ();
        } else {
            lblSoTrangNhap.setText(String.valueOf(_soTrangSpNhap));
            lstSanPhamViewNhap = khoHangService.findSanPham(idDanhMucNhap, idNhanHieuNhap, idNhomHuongNhap, idXuatXuNhap, getStart(_soTrangSpNhap), getEnd(_soTrangSpNhap));
            fillToTableSanPhamNhap(lstSanPhamViewNhap);
            setCboTimKiemTruocKhiFillLaiNhap ();
        }
    }//GEN-LAST:event_btnNextNhapMouseClicked

    private void btnNextNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNextNhapActionPerformed

    private void btnCuoiNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCuoiNhapMouseClicked
        int soDong = khoHangService.getSoDong(idDanhMucNhap, idNhanHieuNhap, idNhomHuongNhap, idXuatXuNhap);
        double page = soDong % 4.0;
        if (page != 0.0) {
            _soTrangSpNhap = soDong / 4;
            _soTrangSpNhap++;
        } else {
            _soTrangSpNhap = soDong / 4;
        }
        lblSoTrangNhap.setText(String.valueOf(_soTrangSpNhap));
        lstSanPhamViewNhap = khoHangService.findSanPham(idDanhMucNhap, idNhanHieuNhap, idNhomHuongNhap, idXuatXuNhap, getStart(_soTrangSpNhap), getEnd(_soTrangSpNhap));
        fillToTableSanPhamNhap(lstSanPhamViewNhap);
        setCboTimKiemTruocKhiFillLaiNhap ();
    }//GEN-LAST:event_btnCuoiNhapMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCuoiNhap;
    private javax.swing.JButton btnCuoiXuat;
    private javax.swing.JButton btnDauNhap;
    private javax.swing.JButton btnDauXuat;
    private javax.swing.JButton btnHuyNhap;
    private javax.swing.JButton btnHuyXuat;
    private javax.swing.JButton btnLocSpNhap;
    private javax.swing.JButton btnLocSpXuat;
    private javax.swing.JButton btnNextNhap;
    private javax.swing.JButton btnNextXuat;
    private javax.swing.JButton btnNhap;
    private javax.swing.JButton btnPrevNhap;
    private javax.swing.JButton btnPrevXuat;
    private javax.swing.JButton btnTaoHoaDonNhap;
    private javax.swing.JButton btnTaoHoaDonXuat;
    private javax.swing.JButton btnThemNhap;
    private javax.swing.JButton btnThemXuat;
    private javax.swing.JButton btnXoaGioHangNhap;
    private javax.swing.JButton btnXoaGioHangXuat;
    private javax.swing.JButton btnXuat;
    private javax.swing.JComboBox<String> cboDanhMucNhap;
    private javax.swing.JComboBox<String> cboDanhMucXuat;
    private javax.swing.JComboBox<String> cboNhanHieuNhap;
    private javax.swing.JComboBox<String> cboNhanHieuXuat;
    private javax.swing.JComboBox<String> cboNhomHuongNhap;
    private javax.swing.JComboBox<String> cboNhomHuongXuat;
    private javax.swing.JComboBox<String> cboXuatXuNhap;
    private javax.swing.JComboBox<String> cboXuatXuXuat;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JPanel jblNhap;
    private javax.swing.JPanel jblXuat;
    private javax.swing.JPanel jplHoaDonChoXuat;
    private javax.swing.JPanel jplXuatThatBai;
    private javax.swing.JLabel lblSTTNhap;
    private javax.swing.JLabel lblSTTXuat;
    private javax.swing.JLabel lblSoTrangNhap;
    private javax.swing.JLabel lblSoTrangXuat;
    private javax.swing.JLabel lblTongTienNhap;
    private javax.swing.JTable tblGioHangNhap;
    private javax.swing.JTable tblGioHangXuat;
    private javax.swing.JTable tblHoaDonNhap;
    private javax.swing.JTable tblHoaDonXuat;
    private javax.swing.JTable tblHoaDonXuatThatBai;
    private javax.swing.JTable tblSanPhamNhap;
    private javax.swing.JTable tblSanPhamXuat;
    private javax.swing.JTextField txtDonGiaNhap;
    private javax.swing.JTextArea txtGhiChuNhap;
    private javax.swing.JTextArea txtGhiChuXuat;
    private javax.swing.JTextField txtNhaCungUngNhap;
    // End of variables declaration//GEN-END:variables
}
