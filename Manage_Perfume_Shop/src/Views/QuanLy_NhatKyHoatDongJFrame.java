/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Services.INhatKyHoatDong;
import Services.NhatKyHoatDongService;
import Ultilities.XImage;
import ViewModels.BanHang_HoaDonChiTietView;
import ViewModels.BanHang_HoaDonView;
import ViewModels.NhapSanPhamView;
import ViewModels.NhatKyHoatDong_HoaDonChiTietView;
import ViewModels.NhatKyHoatDong_HoaDonView;
import ViewModels.SanPhamView;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class QuanLy_NhatKyHoatDongJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    NhatKyHoatDongService nhatKyHoatDongService = new INhatKyHoatDong();
    DefaultTableModel nhapModel;
    DefaultTableModel xuatModel;
    List<NhapSanPhamView> lstNhap = nhatKyHoatDongService.getNhap();
    List<NhapSanPhamView> lstXuat = nhatKyHoatDongService.getXuat();
    List<NhatKyHoatDong_HoaDonView> lstHoaDon = nhatKyHoatDongService.getHoaDon();
    DefaultTableModel modelHoaDon;
    List<NhatKyHoatDong_HoaDonChiTietView> lstHoaDonChiTietView;
    DefaultTableModel modelHoaDonChiTiet;
    int hoaDonIndex = 0;
    List<String> lstEmail;

    public QuanLy_NhatKyHoatDongJFrame() {
        initComponents();
        fillToTableNhap(lstNhap);
        fillToTableXuat(lstXuat);
        init();
        fillToTableHoaDon(lstHoaDon);
        fillToCboEmail();
    }

    public void fillToTableNhap(List<NhapSanPhamView> lstNhapSanPhamView) {
        if (lstNhapSanPhamView.isEmpty()) {
            System.out.println("List nhap Rong");
        } else {

            nhapModel = (DefaultTableModel) tblNhap.getModel();
            nhapModel.setRowCount(0);
            for (NhapSanPhamView nhapSanPhamView : lstNhapSanPhamView) {
                nhapModel.addRow(new Object[]{
                    nhapSanPhamView.getemail(),
                    nhapSanPhamView.getTenSanPham(),
                    nhapSanPhamView.getSoLuong(),
                    nhapSanPhamView.getDonGia(),
                    nhapSanPhamView.getNgayThem(),});
            }

        }
    }

    public void fillToTableXuat(List<NhapSanPhamView> lstNhapSanPhamView) {
        if (lstNhapSanPhamView.isEmpty()) {
            System.out.println("List xuat Rong");
        } else {
            xuatModel = (DefaultTableModel) tblXuat.getModel();
            xuatModel.setRowCount(0);
            for (NhapSanPhamView nhapSanPhamView : lstNhapSanPhamView) {
                xuatModel.addRow(new Object[]{
                    nhapSanPhamView.getemail(),
                    nhapSanPhamView.getTenSanPham(),
                    nhapSanPhamView.getSoLuong(),
                    nhapSanPhamView.getDonGia(),
                    nhapSanPhamView.getNgayThem(),});
            }
        }
    }

    public void fillToTableHoaDon(List<NhatKyHoatDong_HoaDonView> lstHoaDonView) {
        if (lstHoaDonView.isEmpty()) {
            System.out.println("List San Pham Rong");
        } else {
            modelHoaDon = (DefaultTableModel) tblHoaDon.getModel();
            modelHoaDon.setRowCount(0);

            for (NhatKyHoatDong_HoaDonView HoaDonView : lstHoaDonView) {
                modelHoaDon.addRow(new Object[]{
                    HoaDonView.getStt(),
                    HoaDonView.getIdHoaDon(),
                    HoaDonView.getTenHoaDon(),
                    HoaDonView.getEmail(),
                    HoaDonView.getTongTien(),
                    HoaDonView.getNgayThem(),
                    HoaDonView.getGhiChu(),
                    HoaDonView.getTinhTrang()});

            }
        }

    }

    public void fillToTableHoaDonChiTiet(List<NhatKyHoatDong_HoaDonChiTietView> lstHoaDonChiTietView) {
        if (lstHoaDonChiTietView.isEmpty()) {
            System.out.println("List San Pham Rong");
        } else {
            modelHoaDonChiTiet = (DefaultTableModel) tblHoaDonChiTiet.getModel();
            modelHoaDonChiTiet.setRowCount(0);

            for (NhatKyHoatDong_HoaDonChiTietView HoaDonChiTietView : lstHoaDonChiTietView) {
                modelHoaDonChiTiet.addRow(new Object[]{
                    HoaDonChiTietView.getIdHoaDon(),
                    HoaDonChiTietView.getTenSanPham(),
                    HoaDonChiTietView.getSoLuong(),
                    HoaDonChiTietView.getDonGia(),
                    HoaDonChiTietView.getNgayThem(),
                    HoaDonChiTietView.getTrangThai(),});
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

    public void fillToCboEmail() {
        lstEmail = nhatKyHoatDongService.getEmail();
        if (lstEmail.isEmpty()) {
            System.out.println("List Cbo Rong");
        } else {
            cboEmail.removeAllItems();
            for (String string : lstEmail) {

                cboEmail.addItem(string);
            }
            cboEmail.addItem("All");
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
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
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDonChiTiet = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblNhap = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblXuat = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jToolBar2 = new javax.swing.JToolBar();
        txtLogoTollbar = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btntrangChu = new javax.swing.JButton();
        jSeparator11 = new javax.swing.JToolBar.Separator();
        btnDatBanHang = new javax.swing.JButton();
        jSeparator12 = new javax.swing.JToolBar.Separator();
        btnSanPham = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        btntaiKhoan = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JToolBar.Separator();
        btnKhuyenMai = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JToolBar.Separator();
        btnThongKe = new javax.swing.JButton();
        jSeparator21 = new javax.swing.JToolBar.Separator();
        jButton4 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jButton5 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stt", "Id hóa đơn", "Tên hóa đơn", "Email tài khoản", "Tổng tiền", "Ngày thêm", "Ghi chú", "Tình trạng"
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
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Tình trạng");

        cboTinhTrang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboTinhTrang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đã thanh toán", "Đã hủy", "Chờ thanh toán", "All", " " }));

        startDate.setDateFormatString("yyyy-MM-dd");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Email");

        cboEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        endDate.setDateFormatString("yyyy-MM-dd");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Ngày bắt đầu");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Ngày kết thúc");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 967, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnTimKiem)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(startDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(endDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addComponent(cboEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addComponent(startDate, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addComponent(endDate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cboTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(22, 22, 22)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi tiết hóa đơn ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tblHoaDonChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id hóa đơn", "Tên sản phẩm", "Số lượng", "Đơn giá", "Ngày thêm", "Tình trạng"
            }
        ));
        jScrollPane1.setViewportView(tblHoaDonChiTiet);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 973, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Hóa đơn", jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Nhập hàng"));

        tblNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Email người dùng", "Sản phẩm", "Số lượng nhập", "Đơn giá", "Ngày thêm"
            }
        ));
        jScrollPane3.setViewportView(tblNhap);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 875, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Xuất hàng "));

        tblXuat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Email người dùng", "Sản phẩm", "Số lượng xuất", "Đơn giá", "Ngày thêm"
            }
        ));
        jScrollPane4.setViewportView(tblXuat);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 875, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(190, 190, 190))
        );

        jTabbedPane1.addTab("Kho hàng", jPanel7);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 1130, 800));

        jPanel1.setBackground(new java.awt.Color(234, 162, 96));

        jToolBar2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar2.setRollover(true);
        jToolBar2.setEnabled(false);
        jToolBar2.setMargin(new java.awt.Insets(10, 0, 0, 0));
        jToolBar2.setOpaque(false);

        txtLogoTollbar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/logoTollbar.png"))); // NOI18N
        jToolBar2.add(txtLogoTollbar);

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jToolBar2.add(jSeparator1);

        btntrangChu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btntrangChu.setForeground(new java.awt.Color(63, 97, 173));
        btntrangChu.setText("Trang chủ");
        btntrangChu.setFocusable(false);
        btntrangChu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btntrangChu.setMargin(new java.awt.Insets(5, 14, 5, 14));
        btntrangChu.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(btntrangChu);

        jSeparator11.setForeground(new java.awt.Color(255, 255, 255));
        jToolBar2.add(jSeparator11);

        btnDatBanHang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDatBanHang.setForeground(new java.awt.Color(63, 97, 173));
        btnDatBanHang.setText("Đặt/Bán hàng");
        btnDatBanHang.setFocusable(false);
        btnDatBanHang.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDatBanHang.setMargin(new java.awt.Insets(5, 10, 5, 10));
        btnDatBanHang.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDatBanHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatBanHangActionPerformed(evt);
            }
        });
        jToolBar2.add(btnDatBanHang);

        jSeparator12.setForeground(new java.awt.Color(255, 255, 255));
        jToolBar2.add(jSeparator12);

        btnSanPham.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSanPham.setForeground(new java.awt.Color(63, 97, 173));
        btnSanPham.setText("Sản phẩm");
        btnSanPham.setFocusable(false);
        btnSanPham.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSanPham.setMargin(new java.awt.Insets(5, 14, 5, 14));
        btnSanPham.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(btnSanPham);

        jSeparator7.setForeground(new java.awt.Color(255, 255, 255));
        jToolBar2.add(jSeparator7);

        btntaiKhoan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btntaiKhoan.setForeground(new java.awt.Color(63, 97, 173));
        btntaiKhoan.setText("Tài khoản");
        btntaiKhoan.setFocusable(false);
        btntaiKhoan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btntaiKhoan.setMargin(new java.awt.Insets(5, 14, 5, 14));
        btntaiKhoan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(btntaiKhoan);

        jSeparator9.setForeground(new java.awt.Color(255, 255, 255));
        jToolBar2.add(jSeparator9);

        btnKhuyenMai.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnKhuyenMai.setForeground(new java.awt.Color(63, 97, 173));
        btnKhuyenMai.setText("Khuyến mãi");
        btnKhuyenMai.setFocusable(false);
        btnKhuyenMai.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnKhuyenMai.setMargin(new java.awt.Insets(5, 14, 5, 14));
        btnKhuyenMai.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(btnKhuyenMai);

        jSeparator10.setForeground(new java.awt.Color(255, 255, 255));
        jToolBar2.add(jSeparator10);

        btnThongKe.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThongKe.setForeground(new java.awt.Color(63, 97, 173));
        btnThongKe.setText("Thống kê");
        btnThongKe.setFocusable(false);
        btnThongKe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnThongKe.setMargin(new java.awt.Insets(5, 14, 5, 14));
        btnThongKe.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(btnThongKe);

        jSeparator21.setForeground(new java.awt.Color(255, 255, 255));
        jToolBar2.add(jSeparator21);

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(63, 97, 173));
        jButton4.setText("Kho hàng");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setMargin(new java.awt.Insets(5, 14, 5, 14));
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(jButton4);
        jToolBar2.add(jSeparator2);

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(63, 97, 173));
        jButton5.setText("Nhật ký hoạt động");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(jButton5);
        jToolBar2.add(jSeparator3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 781, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDatBanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatBanHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDatBanHangActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        if (((JTextField) startDate.getDateEditor().getUiComponent()).getText().isEmpty() || ((JTextField) endDate.getDateEditor().getUiComponent()).getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Khong dc de trong 1 trong 2 ngay bat dau hoac ket thuc");
        } else {
            String ngayBatDau = ((JTextField) startDate.getDateEditor().getUiComponent()).getText();
            String ngayKetThuc = ((JTextField) endDate.getDateEditor().getUiComponent()).getText();
            String idTaiKhoan = nhatKyHoatDongService.getIdTaiKhoan(String.valueOf(cboEmail.getSelectedItem()));
            String trangThai = "";
            if (idTaiKhoan.equalsIgnoreCase("All")) {
                idTaiKhoan = "";
            }
            if (String.valueOf(cboTinhTrang.getSelectedItem()).equalsIgnoreCase("All")) {
                trangThai = "";
            } else {
                trangThai = String.valueOf(conVertTinhTrangToInt(String.valueOf(cboTinhTrang.getSelectedItem())));
            }
            System.out.println(idTaiKhoan);
            System.out.println(trangThai);
            lstHoaDon = nhatKyHoatDongService.findHoaDon(idTaiKhoan, trangThai, ngayBatDau, ngayKetThuc);
            if (lstHoaDon.isEmpty()) {
                modelHoaDon.setRowCount(0);
                JOptionPane.showMessageDialog(this, "List Rong");
            } else {
                fillToTableHoaDon(lstHoaDon);
            }
        }


    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        hoaDonIndex = tblHoaDon.getSelectedRow();

        fillOnClickHoaDon(hoaDonIndex);
    }//GEN-LAST:event_tblHoaDonMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanLy_NhatKyHoatDongJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLy_NhatKyHoatDongJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLy_NhatKyHoatDongJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLy_NhatKyHoatDongJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLy_NhatKyHoatDongJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDatBanHang;
    private javax.swing.JButton btnKhuyenMai;
    private javax.swing.JButton btnSanPham;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btntaiKhoan;
    private javax.swing.JButton btntrangChu;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboEmail;
    private javax.swing.JComboBox<String> cboTinhTrang;
    private com.toedter.calendar.JDateChooser endDate;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator10;
    private javax.swing.JToolBar.Separator jSeparator11;
    private javax.swing.JToolBar.Separator jSeparator12;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator21;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar2;
    private com.toedter.calendar.JDateChooser startDate;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblHoaDonChiTiet;
    private javax.swing.JTable tblNhap;
    private javax.swing.JTable tblXuat;
    private javax.swing.JLabel txtLogoTollbar;
    // End of variables declaration//GEN-END:variables

    private void init() {
        this.setLocationRelativeTo(null);
        this.setIconImage(XImage.getApplcon());
    }

}
