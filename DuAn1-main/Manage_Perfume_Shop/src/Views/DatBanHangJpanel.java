/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import Services.BanHangService;
import Services.IBanHangService;
import Services.ISanPhamService;
import Services.KhuyenMaiService;
import Services.KhuyenMaiServiceImpl;
import Services.SanPhamService;

import DomainModels.KhuyenMai;

import Services.HoaDonKhuyenMaiViewService;
import Services.HoaDonKhuyenMaiViewServiceImpl;
import Services.KhachHangServices;
import Services.KhachHangServicesImpl;
import ViewModels.BanHang_HoaDonChiTietView;
import ViewModels.BanHang_HoaDonView;
import ViewModels.BanHang_SanPhamView;
import ViewModels.HoaDonKhuyenMaiView;
import ViewModels.QLKhachHang;
import ViewModels.SanPhamView;
import com.lowagie.text.Chunk;
import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;

import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author DELL
 */
public class DatBanHangJpanel extends javax.swing.JPanel {

    List<String> lstDanhMuc;
    List<String> lstNhomHuong;
    List<String> lstNhanHieu;
    List<String> lstXuatXu;
    BanHangService banHangService = new IBanHangService();
    SanPhamService sanPhamService = new ISanPhamService();
    KhuyenMaiService khuyenMaiService = new KhuyenMaiServiceImpl();
    HoaDonKhuyenMaiViewService hoaDonKhuyenMaiViewService = new HoaDonKhuyenMaiViewServiceImpl();
    KhachHangServices khachHangServices = new KhachHangServicesImpl();
    List<BanHang_HoaDonChiTietView> lstHoaDonChiTietView;
    DefaultTableModel modelSanPham;
    DefaultTableModel modelHoaDonChiTiet;
    DefaultTableModel modelKhuyenMai;
    DefaultComboBoxModel cboKhuyenMaiModel;
    DefaultTableModel modelKhuyenMaiTT;
    List<BanHang_HoaDonView> lstHoaDon = banHangService.getHoaDon();
    DefaultTableModel modelHoaDon;
    int sanPhamIndex = 0;
    int gioHangIndex = 0;
    int hoaDonIndex = 0;
    String _idHoaDon = "";
    List<BanHang_HoaDonView> lstHoaDonDaThanhToan;
    DefaultTableModel modelHoaDonDaThanhToan;
    int hoaDonDaThanhToanIndex = 0;
    String _idAccount = new LoginJFrame()._idAccountLogin;
    int _soTrang = 1;
    String idDanhMuc;
    String idNhomHuong;
    String idNhanHieu;
    String idXuatXu;
    List<BanHang_SanPhamView> _lstSanPhamView;
    String DanhMuc;
    String NhanHieu;
    String NhomHuong;
    String XuatXu;
    /**
     * Creates new form TrangChuJPanel
     */
    public DatBanHangJpanel() {
        initComponents();
        fillToCboSanPham();
        initCboTimKiem();
        DanhMuc = cboDanhMuc.getSelectedItem() + "";
        NhomHuong = cboNhomHuong.getSelectedItem() + "";
        NhanHieu = cboNhanHieu.getSelectedItem() + "";
        XuatXu = cboXuatXu.getSelectedItem() + "";
        idDanhMuc = banHangService.getIDDanhMuc(cboDanhMuc.getSelectedItem() + "");
        idNhomHuong = banHangService.getIDNhomHuong(cboNhomHuong.getSelectedItem() + "");
        idNhanHieu = banHangService.getIDNhanHieu(cboNhanHieu.getSelectedItem() + "");
        idXuatXu = banHangService.getIDXuatXu(cboXuatXu.getSelectedItem() + "");
        _lstSanPhamView = banHangService.findSanPham(idDanhMuc, idNhanHieu, idNhomHuong, idXuatXu, getStart(_soTrang), getEnd(_soTrang));
        fillToTableSanPham(_lstSanPhamView);
        lblSoTrang.setText(String.valueOf(_soTrang));
        fillToTableHoaDon(lstHoaDon);
        loadCboKhuyenMai();

    }

    public void initCboTimKiem() {
        cboDanhMuc.setSelectedItem("All");
        cboNhanHieu.setSelectedItem("All");
        cboNhomHuong.setSelectedItem("All");
        cboXuatXu.setSelectedItem("All");
    }
    
    public void setCboTimKiemTruocKhiFillLai () {
        cboDanhMuc.setSelectedItem(DanhMuc);
        cboNhanHieu.setSelectedItem(NhanHieu);
        cboNhomHuong.setSelectedItem(NhomHuong);
        cboXuatXu.setSelectedItem(XuatXu);
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

//    public void fillToTableSanPhamIndex(List<BanHang_SanPhamView> _lstSanPhamView, int index) {
//        if (_lstSanPhamView.isEmpty()) {
//            System.out.println("List San Pham Rong");
//        } else {
//            modelSanPham = (DefaultTableModel) tblSanPham.getModel();
//            modelSanPham.setRowCount(0);
//            int end = index * 4;
//            int start = end - 4;
//            if (_lstSanPhamView.size() < end) {
//                end = _lstSanPhamView.size();
//            }
//
//            for (int i = start; i < end; i++) {
//                modelSanPham.addRow(new Object[]{
//                    _lstSanPhamView.get(i).getTenSp(),
//                    _lstSanPhamView.get(i).getDungTich(),
//                    _lstSanPhamView.get(i).getGia(),
//                    _lstSanPhamView.get(i).getNhanHieu(),
//                    _lstSanPhamView.get(i).getNhomHuong(),
//                    _lstSanPhamView.get(i).getDanhMuc(),
//                    _lstSanPhamView.get(i).getXuatXu()});
//            }
//        }
//
//    }
    public void fillToTableSanPham(List<BanHang_SanPhamView> lstSanPhamView) {
        if (lstSanPhamView.isEmpty()) {
            System.out.println("");
        } else {
            modelSanPham = (DefaultTableModel) tblSanPham.getModel();
            modelSanPham.setRowCount(0);

            for (BanHang_SanPhamView sanPhamView : lstSanPhamView) {
                modelSanPham.addRow(new Object[]{
                    sanPhamView.getTenSp(),
                    sanPhamView.getDungTich(),
                    sanPhamView.getGia(),
                    sanPhamView.getNhanHieu(),
                    sanPhamView.getNhomHuong(),
                    sanPhamView.getDanhMuc(),
                    sanPhamView.getXuatXu(),});
            }
        }

    }

    public void fillToTableHoaDonChiTiet(List<BanHang_HoaDonChiTietView> lstHoaDonChiTietView) {
        if (lstHoaDonChiTietView.isEmpty()) {
            System.out.println("");
        } else {
            modelHoaDonChiTiet = (DefaultTableModel) tblGioHang.getModel();
            modelHoaDonChiTiet.setRowCount(0);

            for (BanHang_HoaDonChiTietView HoaDonChiTietView : lstHoaDonChiTietView) {
                modelHoaDonChiTiet.addRow(new Object[]{
                    HoaDonChiTietView.getTenSp(),
                    HoaDonChiTietView.getDungTich(),
                    HoaDonChiTietView.getSoLuong(),
                    HoaDonChiTietView.getDonGia(),});
            }
        }

    }

    public void fillToTableHoaDon(List<BanHang_HoaDonView> lstHoaDonView) {
        if (lstHoaDonView.isEmpty()) {
            System.out.println("");
        } else {
            modelHoaDon = (DefaultTableModel) tblHoaDon.getModel();
            modelHoaDon.setRowCount(0);
            int stt = lstHoaDonView.size();
            for (BanHang_HoaDonView HoaDonView : lstHoaDonView) {
                modelHoaDon.addRow(new Object[]{
                    stt,
                    HoaDonView.getNguoiThem(),
                    HoaDonView.getTenHoaDon(),
                    HoaDonView.getTongTien(),
                    HoaDonView.getNgayThem(),});
                stt--;
            }
        }

    }

    public void fillToTableHoaDonDaThanhToan(List<BanHang_HoaDonView> lstHoaDonDaThanhToan) {
        if (lstHoaDonDaThanhToan.isEmpty()) {
            System.out.println("");
        } else {
            modelHoaDonDaThanhToan = (DefaultTableModel) tblHoaDonDaThanhtoan.getModel();
            modelHoaDonDaThanhToan.setRowCount(0);
            int stt = lstHoaDonDaThanhToan.size();
            for (BanHang_HoaDonView HoaDonView : lstHoaDonDaThanhToan) {
                modelHoaDonDaThanhToan.addRow(new Object[]{
                    stt,
                    HoaDonView.getNguoiThem(),
                    HoaDonView.getTenHoaDon(),
                    HoaDonView.getTongTien(),
                    HoaDonView.getNgayThem(),});
                stt--;
            }
        }

    }

    public void fillToCboSanPham() {
        lstDanhMuc = banHangService.getDanhMuc();
        lstNhomHuong = banHangService.getNhomHuong();
        lstNhanHieu = banHangService.getNhanHieu();
        lstXuatXu = banHangService.getXuatXu();
        if (lstDanhMuc.isEmpty() || lstNhomHuong.isEmpty() || lstNhanHieu.isEmpty() || lstXuatXu.isEmpty()) {
            System.out.println("");
        } else {

            lstDanhMuc.add("All");
            cboDanhMuc.removeAllItems();
            for (String string : lstDanhMuc) {

                cboDanhMuc.addItem(string);
            }
            lstNhomHuong.add("All");
            cboNhomHuong.removeAllItems();
            for (String string : lstNhomHuong) {

                cboNhomHuong.addItem(string);
            }
            lstNhanHieu.add("All");
            cboNhanHieu.removeAllItems();
            for (String string : lstNhanHieu) {

                cboNhanHieu.addItem(string);
            }
            lstXuatXu.add("All");
            cboXuatXu.removeAllItems();
            for (String string : lstXuatXu) {

                cboXuatXu.addItem(string);
            }
        }

    }

    public void fillOnClickHoaDon(int index, List<BanHang_HoaDonView> lst) {
        if (banHangService.getHoaDonChiTietByIdHoaDon(lst.get(index).getIdHoaDon()).isEmpty()) {
            modelHoaDonChiTiet = (DefaultTableModel) tblGioHang.getModel();
            modelHoaDonChiTiet.setRowCount(0);
        } else {
            lstHoaDonChiTietView = banHangService.getHoaDonChiTietByIdHoaDon(lst.get(index).getIdHoaDon());
            fillToTableHoaDonChiTiet(lstHoaDonChiTietView);
        }

    }

//    public void fillOnClickHoaDonDaThanhToan(int index) {
//        if (banHangService.getHoaDonChiTietByIdHoaDon(lstHoaDonDaThanhToan.get(hoaDonDaThanhToanIndex).getIdHoaDon()).isEmpty()) {
//            System.out.println("List HOA DON CHI TIET Rong");
//            modelHoaDonChiTiet = (DefaultTableModel) tblGioHang.getModel();
//            modelHoaDonChiTiet.setRowCount(0);
//        } else {
//            lstHoaDonChiTietView = banHangService.getHoaDonChiTietByIdHoaDon(lstHoaDonDaThanhToan.get(index).getIdHoaDon());
//            fillToTableHoaDonChiTiet(lstHoaDonChiTietView);
//        }
//
//    }
    public String conVertTinhTrangToString(int tinhTrang) {
        if (tinhTrang == 0) {
            return "Da xoa";
        }
        return "Con ton tai";
    }

    public boolean checkThemKoVuotQuaSoLuongTon(int soLuongThem) {

        String tenSanPham = _lstSanPhamView.get(sanPhamIndex).getTenSp();
        int dungTich = _lstSanPhamView.get(sanPhamIndex).getDungTich();
        String idSanPham = banHangService.getIDSanPham(tenSanPham, dungTich);
        int soLuongTon = banHangService.getSoLuongTon(idSanPham);

        _idHoaDon = lstHoaDon.get(hoaDonIndex).getIdHoaDon();
        if (tblGioHang.getRowCount() == 0) {
            if (soLuongThem > soLuongTon) {
                return false;
            } else {
                return true;
            }
        } else if (lstHoaDonChiTietView.size() > 0) {
            for (int i = 0; i < lstHoaDonChiTietView.size(); i++) {
                if (tenSanPham.equalsIgnoreCase(lstHoaDonChiTietView.get(i).getTenSp()) && dungTich == lstHoaDonChiTietView.get(i).getDungTich()) {
                    int tongSoLuong = banHangService.getSoLuongFromHoaDonChiTiet(_idHoaDon, idSanPham) + soLuongThem;
                    if (tongSoLuong > soLuongTon) {
                        return false;
                    } else {
                        return true;
                    }

                }
            }
            if (soLuongThem > soLuongTon) {
                return false;
            } else {
                return true;
            }
        }
        return true;
    }

    public boolean checkThemTrungSanPham(String tenSanPham, int dungTich) {
        lstHoaDonChiTietView = banHangService.getHoaDonChiTietByIdHoaDon(lstHoaDon.get(hoaDonIndex).getIdHoaDon());
        if (lstHoaDonChiTietView.isEmpty()) {
            return true;
        } else {
            for (BanHang_HoaDonChiTietView banHang_HoaDonChiTietView : lstHoaDonChiTietView) {
                if (tenSanPham.equalsIgnoreCase(banHang_HoaDonChiTietView.getTenSp()) && dungTich == banHang_HoaDonChiTietView.getDungTich()) {
                    return false;
                }
            }
            return true;
        }

    }

    /**
     *
     * /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        cboDanhMuc = new javax.swing.JComboBox<>();
        cboNhomHuong = new javax.swing.JComboBox<>();
        cboXuatXu = new javax.swing.JComboBox<>();
        cboNhanHieu = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnLocSp = new javax.swing.JButton();
        btnDau = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        lblSoTrang = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        btnCuoi = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnTaoHoaDon = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        btnThanhToan = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        lblSTT = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        txtTienKhachTra = new javax.swing.JTextField();
        lblTienThua = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        btnApDungKhuyenMai = new javax.swing.JToggleButton();
        cboKhuyenMai = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        lblTenKhachHang = new javax.swing.JLabel();
        lblTenKhachHang1 = new javax.swing.JLabel();
        txtTenKhachHang = new javax.swing.JTextField();
        txtSoDienThoai = new javax.swing.JTextField();
        btnLuuKhachHang = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        btnXoaGioHang = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblKhuyenMai = new javax.swing.JTable();
        btnXoaChietKhau = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jblHoaDonCho = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jblHoaDonDaThanhToan = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblHoaDonDaThanhtoan = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1100, 780));

        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 780));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setEnabled(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách sản phẩm"));
        jPanel3.setEnabled(false);

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên sản phẩm", "Dung tích", "Giá", "Nhãn hiệu", "Hương", "Danh mục", "Xuất xứ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanPham);

        btnThem.setBackground(new java.awt.Color(234, 162, 96));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Them.png"))); // NOI18N
        btnThem.setText("Thêm sản phẩm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        jLabel8.setText("Danh mục");

        jLabel9.setText("Nhãn hiệu");

        jLabel10.setText("Nhóm hương");

        jLabel11.setText("Xuất xứ");

        btnLocSp.setBackground(new java.awt.Color(51, 255, 51));
        btnLocSp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLocSp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Untitled-1.png"))); // NOI18N
        btnLocSp.setText("Lọc");
        btnLocSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocSpActionPerformed(evt);
            }
        });

        btnDau.setText("Đầu");
        btnDau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDauMouseClicked(evt);
            }
        });

        btnPrev.setText("<");
        btnPrev.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPrevMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPrevMouseEntered(evt);
            }
        });
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnNext.setText(">");
        btnNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNextMouseClicked(evt);
            }
        });
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnCuoi.setText("Cuối");
        btnCuoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCuoiMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(btnLocSp, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(121, 121, 121))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel9))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cboNhanHieu, 0, 178, Short.MAX_VALUE)
                                            .addComponent(cboDanhMuc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cboXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cboNhomHuong, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnThem, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btnDau)
                        .addGap(18, 18, 18)
                        .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblSoTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCuoi)
                        .addGap(150, 150, 150))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLocSp))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboNhomHuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboNhanHieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNext)
                        .addComponent(btnPrev)
                        .addComponent(btnCuoi)
                        .addComponent(btnDau))
                    .addComponent(lblSoTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(112, 112, 112))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Đơn hàng"));
        jPanel4.setEnabled(false);

        btnTaoHoaDon.setBackground(new java.awt.Color(234, 162, 96));
        btnTaoHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnTaoHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/iconHoaDon.png"))); // NOI18N
        btnTaoHoaDon.setText("Tạo hóa đơn");
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Hóa đơn");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Tổng tiền");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Tiền khách trả");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Tiền thừa");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Ghi chú");

        btnThanhToan.setBackground(new java.awt.Color(0, 255, 0));
        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnHuy.setBackground(new java.awt.Color(255, 51, 51));
        btnHuy.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnHuy.setForeground(new java.awt.Color(255, 255, 255));
        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        lblSTT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblTongTien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtTienKhachTra.setText("0");
        txtTienKhachTra.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTienKhachTraCaretUpdate(evt);
            }
        });
        txtTienKhachTra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTienKhachTraMouseClicked(evt);
            }
        });
        txtTienKhachTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienKhachTraActionPerformed(evt);
            }
        });

        lblTienThua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtGhiChu.setColumns(20);
        txtGhiChu.setLineWrap(true);
        txtGhiChu.setRows(5);
        jScrollPane3.setViewportView(txtGhiChu);

        btnApDungKhuyenMai.setBackground(new java.awt.Color(234, 162, 96));
        btnApDungKhuyenMai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnApDungKhuyenMai.setText("Áp dụng khuyến mãi");
        btnApDungKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApDungKhuyenMaiActionPerformed(evt);
            }
        });

        cboKhuyenMai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Khách hàng"));

        lblTenKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTenKhachHang.setText("Tên khách hàng");

        lblTenKhachHang1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTenKhachHang1.setText("Số điện thoại");

        txtSoDienThoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoDienThoaiActionPerformed(evt);
            }
        });

        btnLuuKhachHang.setBackground(new java.awt.Color(51, 255, 51));
        btnLuuKhachHang.setText("Lưu khách hàng");
        btnLuuKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuKhachHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(lblTenKhachHang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(lblTenKhachHang1)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(btnLuuKhachHang))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(26, 26, 26))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTenKhachHang, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTenKhachHang1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(btnLuuKhachHang)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(21, 21, 21)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblTienThua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblSTT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                                    .addGap(13, 13, 13))
                                .addComponent(txtTienKhachTra, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(btnApDungKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cboKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(13, 13, 13)))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnTaoHoaDon)
                .addGap(12, 12, 12)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblSTT, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTienKhachTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel7))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnApDungKhuyenMai)
                    .addComponent(cboKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThanhToan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnHuy)
                .addGap(70, 70, 70))
        );

        jTabbedPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
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
        tblGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGioHangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblGioHang);

        btnXoaGioHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Xoa.png"))); // NOI18N
        btnXoaGioHang.setText("Xóa sản phẩm");
        btnXoaGioHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaGioHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXoaGioHang)
                .addGap(20, 20, 20))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(btnXoaGioHang)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Giỏ hàng", jPanel9);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        tblKhuyenMai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên khuyến mãi", "Chiết khấu"
            }
        ));
        tblKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhuyenMaiMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblKhuyenMai);

        btnXoaChietKhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Xoa.png"))); // NOI18N
        btnXoaChietKhau.setText("Xóa");
        btnXoaChietKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaChietKhauActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnXoaChietKhau)
                .addGap(33, 33, 33))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(btnXoaChietKhau)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Khuyến mãi", jPanel10);

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jblHoaDonCho.setBackground(new java.awt.Color(255, 255, 255));
        jblHoaDonCho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblHoaDonChoMouseClicked(evt);
            }
        });

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
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
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblHoaDon);

        javax.swing.GroupLayout jblHoaDonChoLayout = new javax.swing.GroupLayout(jblHoaDonCho);
        jblHoaDonCho.setLayout(jblHoaDonChoLayout);
        jblHoaDonChoLayout.setHorizontalGroup(
            jblHoaDonChoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jblHoaDonChoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jblHoaDonChoLayout.setVerticalGroup(
            jblHoaDonChoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jblHoaDonChoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Hóa đơn chờ", jblHoaDonCho);

        jblHoaDonDaThanhToan.setBackground(new java.awt.Color(255, 255, 255));
        jblHoaDonDaThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblHoaDonDaThanhToanMouseClicked(evt);
            }
        });

        tblHoaDonDaThanhtoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stt", "Người thêm", "Tên hóa đơn", "Tổng tiền", "Ngày thêm"
            }
        ));
        tblHoaDonDaThanhtoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonDaThanhtoanMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblHoaDonDaThanhtoan);

        javax.swing.GroupLayout jblHoaDonDaThanhToanLayout = new javax.swing.GroupLayout(jblHoaDonDaThanhToan);
        jblHoaDonDaThanhToan.setLayout(jblHoaDonDaThanhToanLayout);
        jblHoaDonDaThanhToanLayout.setHorizontalGroup(
            jblHoaDonDaThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jblHoaDonDaThanhToanLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jblHoaDonDaThanhToanLayout.setVerticalGroup(
            jblHoaDonDaThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jblHoaDonDaThanhToanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Hóa đơn đã thanh toán", jblHoaDonDaThanhToan);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(101, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1100, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        sanPhamIndex = tblSanPham.getSelectedRow();
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (lblSTT.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn");
        } else {
            BanHang_HoaDonChiTietView banHang_HoaDonChiTietView = new BanHang_HoaDonChiTietView();
            banHang_HoaDonChiTietView.setDungTich(_lstSanPhamView.get(sanPhamIndex).getDungTich());
            banHang_HoaDonChiTietView.setDonGia(_lstSanPhamView.get(sanPhamIndex).getGia());
            banHang_HoaDonChiTietView.setTenSp(_lstSanPhamView.get(sanPhamIndex).getTenSp());
            banHang_HoaDonChiTietView.setSoLuong(Integer.parseInt(JOptionPane.showInputDialog("Nhap so luong")));
            if (checkThemKoVuotQuaSoLuongTon(banHang_HoaDonChiTietView.getSoLuong()) == false) {
                JOptionPane.showMessageDialog(this, "Khong duoc them vuot qua so luong ton");
            } else if (checkThemTrungSanPham(banHang_HoaDonChiTietView.getTenSp(), banHang_HoaDonChiTietView.getDungTich()) == false) {
                int soLuong = banHang_HoaDonChiTietView.getSoLuong();
                String idHoaDon = lstHoaDon.get(hoaDonIndex).getIdHoaDon();
                String idSanPham = banHangService.getIDSanPham(banHang_HoaDonChiTietView.getTenSp(), banHang_HoaDonChiTietView.getDungTich());
                JOptionPane.showMessageDialog(this, banHangService.updateHoaDonChiTiet(soLuong, idHoaDon, idSanPham));
                lstHoaDonChiTietView = banHangService.getHoaDonChiTietByIdHoaDon(lstHoaDon.get(hoaDonIndex).getIdHoaDon());
                fillToTableHoaDonChiTiet(lstHoaDonChiTietView);
            } else {
                JOptionPane.showMessageDialog(this, banHangService.taoHoaDonChiTiet(banHang_HoaDonChiTietView, lstHoaDon.get(hoaDonIndex).getIdHoaDon()));
                lstHoaDonChiTietView = banHangService.getHoaDonChiTietByIdHoaDon(lstHoaDon.get(hoaDonIndex).getIdHoaDon());
                fillToTableHoaDonChiTiet(lstHoaDonChiTietView);
            }
            //nam code------------------------------------------------------------------------------
            loadDonHang();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnLocSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocSpActionPerformed
        _soTrang = 1;
        idDanhMuc = banHangService.getIDDanhMuc(cboDanhMuc.getSelectedItem() + "");
        idNhomHuong = banHangService.getIDNhomHuong(cboNhomHuong.getSelectedItem() + "");
        idNhanHieu = banHangService.getIDNhanHieu(cboNhanHieu.getSelectedItem() + "");
        idXuatXu = banHangService.getIDXuatXu(cboXuatXu.getSelectedItem() + "");
        DanhMuc = cboDanhMuc.getSelectedItem() + "";
        NhomHuong = cboNhomHuong.getSelectedItem() + "";
        NhanHieu = cboNhanHieu.getSelectedItem() + "";
        XuatXu = cboXuatXu.getSelectedItem() + "";
        _lstSanPhamView = banHangService.findSanPham(idDanhMuc, idNhanHieu, idNhomHuong, idXuatXu, getStart(_soTrang), getEnd(_soTrang));
        lblSoTrang.setText(_soTrang + "");
        if (_lstSanPhamView.size() == 0) {
            modelSanPham.setRowCount(0);
            JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm");
            return;
        }

        fillToTableSanPham(_lstSanPhamView);
    }//GEN-LAST:event_btnLocSpActionPerformed

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
        JOptionPane.showMessageDialog(this, banHangService.taoHoaDon(_idAccount));
        lstHoaDon = banHangService.getHoaDon();
        fillToTableHoaDon(lstHoaDon);

        lblSTT.setText("");
        lblTongTien.setText("");
        lblTienThua.setText("");
    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        lstHoaDon = banHangService.getHoaDon();
        _idHoaDon = lstHoaDon.get(hoaDonIndex).getIdHoaDon();
        if (lblSTT.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn");
            return;
        }
        int hoi = JOptionPane.showConfirmDialog(this, "Bạn có muốn thanh toán ?");
        if (hoi == JOptionPane.NO_OPTION || hoi == JOptionPane.CANCEL_OPTION || hoi == JOptionPane.CLOSED_OPTION) {
            return;
        }
        if (tblGioHang.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Không có sản phẩm để thanh toán");
            return;
        }
        int trangThai = 1;
        JOptionPane.showMessageDialog(this, banHangService.update(this.getTrangThaiHoaDon(trangThai)));

        for (int i = 0; i < lstHoaDonChiTietView.size(); i++) {
            String idSP = banHangService.getIDSanPham(lstHoaDonChiTietView.get(i).getTenSp(), lstHoaDonChiTietView.get(i).getDungTich());
            int soLuongTon = lstHoaDonChiTietView.get(i).getSoLuong();
            SanPhamView spv = new SanPhamView(idSP, null, null, null, WIDTH, null, null, null, BigDecimal.ZERO, BigDecimal.ZERO, soLuongTon, 0, null, WIDTH, null, null, null);
            sanPhamService.updateSoLuongTon(spv);
        }
        if (tblKhuyenMai.getRowCount() > 0) {
            String tenKM = String.valueOf(tblKhuyenMai.getValueAt(0, 0));
            KhuyenMai km = new KhuyenMai(null, tenKM, null, null, 0, WIDTH, 0);
            khuyenMaiService.updateSoLanApDung(km);
        }

        Phrase phrase5 = new Phrase(lstHoaDon.get(hoaDonIndex).getIdHoaDon());
        Phrase phrase2 = new Phrase("Nhan vien thanh toan: " + banHangService.getTenByIDNV(_idAccount));
        lstHoaDon = banHangService.getHoaDon();
        if (lstHoaDon.isEmpty()) {
            modelHoaDon.setRowCount(0);
        } else {
            fillToTableHoaDon(lstHoaDon);
        }
        txtTienKhachTra.setText(0 + "");//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        modelKhuyenMai.setRowCount(0);
        modelHoaDonChiTiet.setRowCount(0);
        loadCboKhuyenMai();
        clearDonHang();
        String path = "";
        FileOutputStream fos = null;
        try {
            String f_name = _idHoaDon;
            path = "D:\\";
            fos = new FileOutputStream(new File(path + (f_name + ".pdf")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Document doc = new Document();
        try {
            PdfWriter.getInstance(doc, fos);
            doc.open();
            Chunk chunk1 = new Chunk("");
            phrase5.add(chunk1);
            Paragraph paragraph5 = new Paragraph();
            paragraph5.setAlignment(Element.ALIGN_LEFT);
            paragraph5.setIndentationLeft(50);
            paragraph5.setSpacingAfter(15);
            paragraph5.add(phrase5);
            doc.add(paragraph5);
            Phrase phrase = new Phrase("Hoa don cua hang nuoc hoa Perfume");
            phrase.add(chunk1);
            Phrase phrase4 = new Phrase("Ngay thanh toan: " + banHangService.getNgayThem(_idHoaDon));
            phrase4.add(chunk1);
            Paragraph paragraph4 = new Paragraph();
            paragraph4.setAlignment(Element.ALIGN_LEFT);
            paragraph4.setIndentationLeft(50);
            paragraph4.setSpacingAfter(15);
            paragraph4.add(phrase4);
            phrase2.add(chunk1);
            Paragraph paragraph1 = new Paragraph();
            Paragraph paragraph2 = new Paragraph();
            paragraph1.setIndentationLeft(80);
            paragraph1.setIndentationRight(80);
            paragraph1.setAlignment(Element.ALIGN_CENTER);
            paragraph1.setSpacingAfter(15);
            paragraph1.add(phrase);
            paragraph2.setAlignment(Element.ALIGN_LEFT);
            paragraph2.setSpacingAfter(15);
            paragraph2.setIndentationLeft(50);
            paragraph2.add(phrase2);
            doc.add(paragraph1);
            doc.add(paragraph2);
            doc.add(paragraph4);
            PdfPTable tbl = new PdfPTable(3);
            tbl.addCell("Ten san pham");
            tbl.addCell("So luong");
            tbl.addCell("Don gia");
            for (int i = 0; i < lstHoaDonChiTietView.size(); i++) {
                String tenSP = lstHoaDonChiTietView.get(i).getTenSp();
                String soLuong = String.valueOf(lstHoaDonChiTietView.get(i).getSoLuong());
                String donGia = String.valueOf(lstHoaDonChiTietView.get(i).getDonGia());
                tbl.addCell(tenSP);
                tbl.addCell(soLuong);
                tbl.addCell(donGia);
            }
            doc.add(tbl);
            Phrase phrase3 = new Phrase("Tong tien: " + banHangService.getTongTien(_idHoaDon));
            phrase3.add(chunk1);
            Paragraph paragraph3 = new Paragraph();
            paragraph3.setAlignment(Element.ALIGN_LEFT);
            paragraph3.setSpacingAfter(15);
            paragraph3.setIndentationLeft(50);
            paragraph3.add(phrase3);
            doc.add(paragraph3);
        } catch (DocumentException ex) {
            Logger.getLogger(DatBanHangJpanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        doc.close();

    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        if (lblSTT.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn");
            return;
        }
        int hoi = JOptionPane.showConfirmDialog(this, "Bạn có muốn hủy ?");
        if (hoi == JOptionPane.NO_OPTION || hoi == JOptionPane.CANCEL_OPTION || hoi == JOptionPane.CLOSED_OPTION) {
            return;
        }

        int trangThai = 0;
        JOptionPane.showMessageDialog(this, "Hủy" + banHangService.update(this.getTrangThaiHoaDon(trangThai)));
        lstHoaDon = banHangService.getHoaDon();
        if (lstHoaDon.isEmpty()) {
            modelHoaDon.setRowCount(0);
        } else {
            fillToTableHoaDon(lstHoaDon);

        }
        txtTienKhachTra.setText(0 + "");//-----------------------------------------------------------------------------------------------------------------------------------------------------------------
        modelKhuyenMai.setRowCount(0);
        modelHoaDonChiTiet.setRowCount(0);

        clearDonHang();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void txtTienKhachTraCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTienKhachTraCaretUpdate
        //Nam code --------------------------------------------------------------------------
        try {
            if (lblSTT.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn hhh");
            } else {
                BigDecimal tongTien = new BigDecimal(Double.parseDouble(lblTongTien.getText().trim()));
                BigDecimal tienTra;
                if (txtTienKhachTra.getText().equals("")) {
                    tienTra = new BigDecimal(Double.parseDouble(0 + ""));
                    BigDecimal tienThua = tienTra.subtract(tongTien);
                    lblTienThua.setText(tienThua + "");

                } else {
                    double tienNhap;
                    try {
                        tienNhap = Double.parseDouble(txtTienKhachTra.getText().trim());
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Vui lòng nhập tiền là số");
                        return;
                    }
                    tienTra = new BigDecimal(tienNhap);
                    BigDecimal tienThua = tienTra.subtract(tongTien);
                    lblTienThua.setText(tienThua + "");
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_txtTienKhachTraCaretUpdate

    private void txtTienKhachTraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTienKhachTraMouseClicked
        txtTienKhachTra.setText(0 + "");//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    }//GEN-LAST:event_txtTienKhachTraMouseClicked

    private void txtTienKhachTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienKhachTraActionPerformed

    }//GEN-LAST:event_txtTienKhachTraActionPerformed

    private void btnApDungKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApDungKhuyenMaiActionPerformed
        int index = tblHoaDon.getSelectedRow();
        if (lblSTT.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui long chon hoa don");
            return;
        } else {
            if (JOptionPane.showConfirmDialog(this, "Bạn có muốn áp dụng khuyến mãi không") == JOptionPane.YES_OPTION) {
                String idKhuyenMai = this.getIdKhuyenMai(cboKhuyenMai.getSelectedItem().toString());
                String idHoaDon = banHangService.getHoaDon().get(index).getIdHoaDon();
                if (tblKhuyenMai.getRowCount() == 0) {
                    BanHang_HoaDonView bhhdv = new BanHang_HoaDonView(idHoaDon, null, null, BigDecimal.ONE, null, null, WIDTH, idKhuyenMai, null);
                    JOptionPane.showMessageDialog(this, "Ap dung " + banHangService.updateKhuyenMai(bhhdv));
                    loadTblKhuyenMai();
                } else {
                    for (int i = 0; i < tblKhuyenMai.getRowCount(); i++) {
                        if (idKhuyenMai.trim().equals(this.getIdKhuyenMai(tblKhuyenMai.getValueAt(i, 0).toString()))) {
                            JOptionPane.showMessageDialog(this, "Khuyen mai da duoc ap dung");
                            return;
                        }
                    }
                    BanHang_HoaDonView bhhdv = new BanHang_HoaDonView(idHoaDon, null, null, BigDecimal.ONE, null, null, WIDTH, idKhuyenMai, null);
                    JOptionPane.showMessageDialog(this, "Ap dung " + banHangService.updateKhuyenMai(bhhdv));
                    loadTblKhuyenMai();
                }
                loadDonHang();
            }

        }

        


    }//GEN-LAST:event_btnApDungKhuyenMaiActionPerformed

    private void tblGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHangMouseClicked
        gioHangIndex = tblGioHang.getSelectedRow();
    }//GEN-LAST:event_tblGioHangMouseClicked

    private void btnXoaGioHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaGioHangActionPerformed
        if (lblSTT.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn");
        } else {

            if (JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không") == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(this, banHangService.deleteHoaDonChiTiet(lstHoaDonChiTietView.get(gioHangIndex).getTenSp(), lstHoaDon.get(hoaDonIndex).getIdHoaDon(), lstHoaDonChiTietView.get(gioHangIndex).getDungTich()));
                lstHoaDonChiTietView = banHangService.getHoaDonChiTietByIdHoaDon(lstHoaDon.get(hoaDonIndex).getIdHoaDon());
                if (lstHoaDonChiTietView.isEmpty()) {
                    modelHoaDonChiTiet.setRowCount(0);
                } else {
                    lstHoaDonChiTietView = banHangService.getHoaDonChiTietByIdHoaDon(lstHoaDon.get(hoaDonIndex).getIdHoaDon());
                    fillToTableHoaDonChiTiet(lstHoaDonChiTietView);
                }

                //Nam code--------------------------------------------
                loadDonHang();
            }

        }
    }//GEN-LAST:event_btnXoaGioHangActionPerformed

    private void tblKhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhuyenMaiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblKhuyenMaiMouseClicked

    private void btnXoaChietKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaChietKhauActionPerformed
        if (lblSTT.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn");
            return;
        }
        String idHoaDon = this.getIdHoaDon(Integer.parseInt(lblSTT.getText()));
        int index = tblKhuyenMai.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Chưa áp dụng khuyến mãi");
            return;
        }
        BanHang_HoaDonView bhhdv = new BanHang_HoaDonView(idHoaDon, null, null, BigDecimal.ONE, null, null, 0, null, null);
        JOptionPane.showMessageDialog(this, "Xoa " + banHangService.updateKhuyenMai(bhhdv));
        loadTblKhuyenMai();
        loadDonHang();
    }//GEN-LAST:event_btnXoaChietKhauActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        hoaDonIndex = tblHoaDon.getSelectedRow();
        lstHoaDon = banHangService.getHoaDon();
        fillOnClickHoaDon(hoaDonIndex, lstHoaDon);

        //Nam code------------------------------------------------------------------------------
        loadTblKhuyenMai();

        loadDonHang();
        txtTienKhachTra.setText(0 + "");//------------------------------------------------------
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void tblHoaDonDaThanhtoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonDaThanhtoanMouseClicked
        hoaDonDaThanhToanIndex = tblHoaDonDaThanhtoan.getSelectedRow();
        lstHoaDon = banHangService.getHoaDonDaThanhToan(_idAccount);
        fillTableKMHoaDonTT(hoaDonDaThanhToanIndex, lstHoaDon);
        fillOnClickHoaDon(hoaDonDaThanhToanIndex, lstHoaDon);
    }//GEN-LAST:event_tblHoaDonDaThanhtoanMouseClicked

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        if (jblHoaDonCho.isShowing()) {
            btnXoaGioHang.setVisible(true);
            btnXoaChietKhau.setVisible(true);
            lstHoaDon = banHangService.getHoaDon();
            if (lstHoaDon.isEmpty()) {
                modelHoaDonChiTiet.setRowCount(0);
            } else {
                fillToTableHoaDon(lstHoaDon);
                fillOnClickHoaDon(hoaDonIndex, lstHoaDon);
            }

        }
        if (jblHoaDonDaThanhToan.isShowing()) {
            btnXoaGioHang.setVisible(false);
            btnXoaChietKhau.setVisible(false);
            lstHoaDonDaThanhToan = banHangService.getHoaDonDaThanhToan(_idAccount);
            if (lstHoaDonDaThanhToan.isEmpty()) {
                modelHoaDonChiTiet.setRowCount(0);
            } else {
                fillToTableHoaDonDaThanhToan(lstHoaDonDaThanhToan);
                fillOnClickHoaDon(hoaDonDaThanhToanIndex, lstHoaDonDaThanhToan);
            }

        }
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jblHoaDonChoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblHoaDonChoMouseClicked
        btnXoaGioHang.setVisible(true);
        btnXoaChietKhau.setVisible(true);
    }//GEN-LAST:event_jblHoaDonChoMouseClicked

    private void jblHoaDonDaThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblHoaDonDaThanhToanMouseClicked
        btnXoaGioHang.setVisible(false);
        btnXoaChietKhau.setVisible(false);
    }//GEN-LAST:event_jblHoaDonDaThanhToanMouseClicked

    private void txtSoDienThoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoDienThoaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoDienThoaiActionPerformed

    private void btnLuuKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuKhachHangActionPerformed
        if (txtSoDienThoai.getText().trim().equals("") || txtTenKhachHang.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng không để chống");
            return;
        }
        if (JOptionPane.showConfirmDialog(this, "Bạn có muốn lưu khách hàng không") == JOptionPane.YES_OPTION) {

            String tenKH = txtTenKhachHang.getText();
            String regex = "(84|0[3|5|7|8|9])+([0-9]{8})";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(txtSoDienThoai.getText());
            boolean check = matcher.matches();
            if (check == false) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại của Việt Nam");
                return;
            }
            String sdt = txtSoDienThoai.getText();
            if (banHangService.getKHByPhone(sdt).isEmpty()) {
                QLKhachHang qlkh = new QLKhachHang(null, tenKH, sdt, null, null, 0);
                khachHangServices.insertKHNew(qlkh);
                JOptionPane.showMessageDialog(this, "Lưu thành công");
            } else {
                JOptionPane.showMessageDialog(this, "Khách hàng đã tồn tại");;
            }
        }


    }//GEN-LAST:event_btnLuuKhachHangActionPerformed

    private void btnDauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDauMouseClicked
        _soTrang = 1;
        lblSoTrang.setText(String.valueOf(_soTrang));
        _lstSanPhamView = banHangService.findSanPham(idDanhMuc, idNhanHieu, idNhomHuong, idXuatXu, getStart(_soTrang), getEnd(_soTrang));
        fillToTableSanPham(_lstSanPhamView);
        setCboTimKiemTruocKhiFillLai ();
    }//GEN-LAST:event_btnDauMouseClicked

    private void btnPrevMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrevMouseClicked
        _soTrang--;
        int soTrang;
        int soDong = banHangService.getSoDong(idDanhMuc, idNhanHieu, idNhomHuong, idXuatXu);
        double page = soDong % 4.0;
        if (page != 0.0) {
            soTrang = soDong / 4;
            soTrang++;
        } else {
            soTrang = soDong / 4;
        }
        if (_soTrang == 0) {
            _soTrang = soTrang;
            _lstSanPhamView = banHangService.findSanPham(idDanhMuc, idNhanHieu, idNhomHuong, idXuatXu, getStart(_soTrang), getEnd(_soTrang));
            lblSoTrang.setText(String.valueOf(_soTrang));
            fillToTableSanPham(_lstSanPhamView);
            setCboTimKiemTruocKhiFillLai ();
        } else {
            _lstSanPhamView = banHangService.findSanPham(idDanhMuc, idNhanHieu, idNhomHuong, idXuatXu, getStart(_soTrang), getEnd(_soTrang));
            lblSoTrang.setText(String.valueOf(_soTrang));
            fillToTableSanPham(_lstSanPhamView);
            setCboTimKiemTruocKhiFillLai ();
        }
    }//GEN-LAST:event_btnPrevMouseClicked

    private void btnPrevMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrevMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrevMouseEntered

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnNextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextMouseClicked
        _soTrang++;
        int soTrang;
        int soDong = banHangService.getSoDong(idDanhMuc, idNhanHieu, idNhomHuong, idXuatXu);
        double page = soDong % 4.0;
        if (page != 0.0) {
            soTrang = soDong / 4;
            soTrang++;
        } else {
            soTrang = soDong / 4;
        }
        if (_soTrang > soTrang) {
            _soTrang = 1;
            _lstSanPhamView = banHangService.findSanPham(idDanhMuc, idNhanHieu, idNhomHuong, idXuatXu, getStart(_soTrang), getEnd(_soTrang));
            lblSoTrang.setText(String.valueOf(_soTrang));
            fillToTableSanPham(_lstSanPhamView);
            setCboTimKiemTruocKhiFillLai ();
        } else {
            _lstSanPhamView = banHangService.findSanPham(idDanhMuc, idNhanHieu, idNhomHuong, idXuatXu, getStart(_soTrang), getEnd(_soTrang));
            lblSoTrang.setText(String.valueOf(_soTrang));
            fillToTableSanPham(_lstSanPhamView);
            setCboTimKiemTruocKhiFillLai ();
        }


    }//GEN-LAST:event_btnNextMouseClicked

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed

    }//GEN-LAST:event_btnNextActionPerformed

    private void btnCuoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCuoiMouseClicked
        int soDong = banHangService.getSoDong(idDanhMuc, idNhanHieu, idNhomHuong, idXuatXu);
        double page = soDong % 4.0;
        if (page != 0.0) {
            _soTrang = soDong / 4;
            _soTrang++;
        } else {
            _soTrang = soDong / 4;
        }
        lblSoTrang.setText(String.valueOf(_soTrang));
        _lstSanPhamView = banHangService.findSanPham(idDanhMuc, idNhanHieu, idNhomHuong, idXuatXu, getStart(_soTrang), getEnd(_soTrang));
        fillToTableSanPham(_lstSanPhamView);
        setCboTimKiemTruocKhiFillLai ();
    }//GEN-LAST:event_btnCuoiMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnApDungKhuyenMai;
    private javax.swing.JButton btnCuoi;
    private javax.swing.JButton btnDau;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnLocSp;
    private javax.swing.JButton btnLuuKhachHang;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoaChietKhau;
    private javax.swing.JButton btnXoaGioHang;
    private javax.swing.JComboBox<String> cboDanhMuc;
    private javax.swing.JComboBox<String> cboKhuyenMai;
    private javax.swing.JComboBox<String> cboNhanHieu;
    private javax.swing.JComboBox<String> cboNhomHuong;
    private javax.swing.JComboBox<String> cboXuatXu;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JPanel jblHoaDonCho;
    private javax.swing.JPanel jblHoaDonDaThanhToan;
    private javax.swing.JLabel lblSTT;
    private javax.swing.JLabel lblSoTrang;
    private javax.swing.JLabel lblTenKhachHang;
    private javax.swing.JLabel lblTenKhachHang1;
    private javax.swing.JLabel lblTienThua;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblHoaDonDaThanhtoan;
    private javax.swing.JTable tblKhuyenMai;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTenKhachHang;
    private javax.swing.JTextField txtTienKhachTra;
    // End of variables declaration//GEN-END:variables

    private void loadDonHang() {
        if (lstHoaDon.isEmpty()) {
            System.out.println("");
        } else {
            lblSTT.setText(tblHoaDon.getValueAt(hoaDonIndex, 0).toString());
            if (tblGioHang.getRowCount() == 0 && tblKhuyenMai.getRowCount() == 0) {
                lblTongTien.setText(0 + "");
                lblTienThua.setText(0 + "");
            } else if (tblGioHang.getRowCount() > 0 && tblKhuyenMai.getRowCount() == 0) {
                BigDecimal thanhTien = new BigDecimal(0);
                for (int i = 0; i < tblGioHang.getRowCount(); i++) {
                    int soLuong = Integer.parseInt(tblGioHang.getValueAt(i, 2).toString());
                    BigDecimal donGia = new BigDecimal(tblGioHang.getValueAt(i, 3).toString());
                    thanhTien = thanhTien.add(donGia.multiply(new BigDecimal(soLuong)));
                }
                if (txtTienKhachTra.getText().trim().equals("")) {
                    BigDecimal tienTra = new BigDecimal(0);
                    lblTienThua.setText(tienTra.subtract(thanhTien) + "");
                    lblTongTien.setText(thanhTien + "");
                } else {
                    BigDecimal tienTra = new BigDecimal(txtTienKhachTra.getText().trim());
                    lblTienThua.setText(tienTra.subtract(thanhTien) + "");
                    lblTongTien.setText(thanhTien + "");
                }

            } else if (tblGioHang.getRowCount() == 0 && tblKhuyenMai.getRowCount() > 0) {
                lblTongTien.setText(0 + "");
                lblTienThua.setText(0 + "");
            } else {
                BigDecimal thanhTien = new BigDecimal(0);
                for (int i = 0; i < tblGioHang.getRowCount(); i++) {
                    int soLuong = Integer.parseInt(tblGioHang.getValueAt(i, 2).toString());
                    BigDecimal donGia = new BigDecimal(tblGioHang.getValueAt(i, 3).toString());
                    thanhTien = thanhTien.add(donGia.multiply(new BigDecimal(soLuong)));
                }
                for (int i = 0; i < tblKhuyenMai.getRowCount(); i++) {
                    int chietKhau = Integer.parseInt(tblKhuyenMai.getValueAt(i, 1).toString());
                    thanhTien = thanhTien.subtract(thanhTien.multiply(new BigDecimal(chietKhau).divide(new BigDecimal(100))));
                }
                if (txtTienKhachTra.getText().trim().equals("")) {
                    BigDecimal tienTra = new BigDecimal(0);
                    lblTienThua.setText(tienTra.subtract(thanhTien) + "");
                    lblTongTien.setText(thanhTien + "");
                } else {
                    BigDecimal tienTra = new BigDecimal(txtTienKhachTra.getText().trim());
                    lblTienThua.setText(tienTra.subtract(thanhTien) + "");
                    lblTongTien.setText(thanhTien + "");
                }
            }
        }
    }

    public BanHang_HoaDonView getTrangThaiHoaDon(int trangThai) {
        int index = tblHoaDon.getSelectedRow();
        BigDecimal thanhTien = new BigDecimal(lblTongTien.getText());
        String ghiChu = txtGhiChu.getText();
        //int stt = Integer.parseInt(lblSTT.getText());
        String idHoaDon = banHangService.getHoaDon().get(index).getIdHoaDon();
//        String idKH = this.getIdKH();
        String idKH = banHangService.getIdKhacHang(txtSoDienThoai.getText());
        if (idKH.isEmpty()) {
            idKH = null;
        }
        BanHang_HoaDonView bhhdv = new BanHang_HoaDonView(idHoaDon, null, null, thanhTien, ghiChu, null, trangThai, null, idKH);
        // BanHang_HoaDonView bhhdv = new BanHang_HoaDonView(null, null, stt, null, thanhTien, ghiChu, null, trangThai, idKH);
        return bhhdv;
    }

    private void clearDonHang() {
        lblSTT.setText("");
        lblTienThua.setText("");
        txtGhiChu.setText("");
        lblTongTien.setText("");
        txtTenKhachHang.setText("");
        txtSoDienThoai.setText("");
    }

    private void loadCboKhuyenMai() {
        cboKhuyenMaiModel = new DefaultComboBoxModel();
        cboKhuyenMaiModel = (DefaultComboBoxModel) cboKhuyenMai.getModel();
        ArrayList<KhuyenMai> lstKM = khuyenMaiService.getListConHan();
        cboKhuyenMaiModel.removeAllElements();
        for (KhuyenMai km : lstKM) {
            cboKhuyenMaiModel.addElement(km.getTenKhuyenMai());
        }
    }

    public String getIdKhuyenMai(String TenKhuyenMai) {
        ArrayList<KhuyenMai> lstKM = khuyenMaiService.getListConHan();
        for (int i = 0; i < lstKM.size(); i++) {
            if (TenKhuyenMai.trim().equals(lstKM.get(i).getTenKhuyenMai())) {
                return lstKM.get(i).getIdKhuyenMai();
            }
        }
        return null;
    }

    public String getIdHoaDon(int index) {
        index = tblHoaDon.getSelectedRow();
        List<BanHang_HoaDonView> lstBHHDV = banHangService.getHoaDon();
        return lstBHHDV.get(index).getIdHoaDon();
    }

//    public String getIdSanPham(String tenSP, int dungTich) {
//        List<SanPhamView> lstSP = sanPhamService.getSanPham();
//        for (int i = 0; i < lstSP.size(); i++) {
//            if (tenSP.equals(lstSP.get(i).getTenSanPham()) && dungTich == lstSP.get(i).getKichThuoc()) {
//                return lstSP.get(i).getIdSanPham();
//            }
//        }
//        return null;
//    }
    private void loadTblKhuyenMai() {
        int index = tblHoaDon.getSelectedRow();
        String idHoaDon = banHangService.getHoaDon().get(index).getIdHoaDon();
        //int stt = Integer.parseInt(tblHoaDon.getValueAt(hoaDonIndex, 0).toString());
        modelKhuyenMai = new DefaultTableModel();
        modelKhuyenMai = (DefaultTableModel) tblKhuyenMai.getModel();
        modelKhuyenMai.setRowCount(0);
        ArrayList<HoaDonKhuyenMaiView> lstJDKMV = hoaDonKhuyenMaiViewService.getList(idHoaDon);
        for (HoaDonKhuyenMaiView hdkmv : lstJDKMV) {
            modelKhuyenMai.addRow(new Object[]{hdkmv.getTenKhuyenMai(), hdkmv.getChietKhau()});
        }
    }

//    public String getIdKH() {
//        String sdt = txtSoDienThoai.getText();
//        ArrayList<QLKhachHang> lstKH = khachHangServices.findAll();
//        for (int i = 0; i < lstKH.size(); i++) {
//            if (sdt.trim().equals(lstKH.get(i).getSoDienThoai())) {
//                System.out.println("có id");
//                return lstKH.get(i).getIdKhachHang();
//            }
//        }
//        System.out.println("k id");
//        return null;
//    }

    private void fillTableKMHoaDonTT(int index, List<BanHang_HoaDonView> list) {
        modelKhuyenMaiTT = (DefaultTableModel) tblKhuyenMai.getModel();
        modelKhuyenMaiTT.setRowCount(0);
        List<KhuyenMai> listKM = banHangService.getTTKM(list.get(index).getIdHoaDon());
        for (KhuyenMai khuyenMai : listKM) {
            modelKhuyenMaiTT.addRow(new Object[]{
                khuyenMai.getTenKhuyenMai(),
                khuyenMai.getChietKhau()
            });
        }
    }
}
