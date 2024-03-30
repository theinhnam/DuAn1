/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import DomainModels.DanhMuc;
import DomainModels.NhanHieu;
import DomainModels.NhomHuong;

import DomainModels.XuatXu;
import Services.DanhMucService;
import Services.DanhMucServiceImpl;
import Services.ISanPhamService;
import Services.NhanHieuService;
import Services.NhanHieuServiceImpl;
import Services.NhomHuongService;
import Services.NhomHuongServiceImpl;
import Services.SanPhamService;
import Services.XuatXuService;
import Services.XuatXuServiceImpl;

import ViewModels.SanPhamView;
import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;

import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.apache.poi.ss.usermodel.CellType;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author DELL
 */
public class QuanLySanPhamJPanel extends javax.swing.JPanel {

    SanPhamService sanPhamService = new ISanPhamService();
    List<String> lstDanhMuc;
    List<String> lstNhomHuong;
    List<String> lstNhanHieu;
    List<String> lstXuatXu;
    String idDanhMuc;
    String idNhanHieu;
    String idNhomHuong;
    String idXuatXu;
    List<SanPhamView> _lstSanPhamView;
    DefaultTableModel model;
    String imageUrl;
    int indexSp = 0;
    NhanHieuService nhanHieuService = new NhanHieuServiceImpl();
    NhomHuongService nhomHuongService = new NhomHuongServiceImpl();
    XuatXuService xuatXuService = new XuatXuServiceImpl();
    DanhMucService danhMucService = new DanhMucServiceImpl();
    DefaultTableModel tblThuocTinhModel = new DefaultTableModel();
    int _soTrang = 1;
    boolean check;
    int index = 0;
    String DanhMuc;
    String NhanHieu;
    String NhomHuong;
    String XuatXu;

    /**
     * Creates new form TrangChuJPanel
     */
    public QuanLySanPhamJPanel() {
        initComponents();
        fillToCboSanPham();
        initCboTimKiem();
        DanhMuc = cboDanhMuc1.getSelectedItem() + "";
        NhomHuong = cboNhomHuong1.getSelectedItem() + "";
        NhanHieu = cboNhanHieu1.getSelectedItem() + "";
        XuatXu = cboXuatXu1.getSelectedItem() + "";
        idDanhMuc = sanPhamService.getIDDanhMuc(cboDanhMuc1.getSelectedItem() + "");
        idNhomHuong = sanPhamService.getIDNhomHuong(cboNhomHuong1.getSelectedItem() + "");
        idNhanHieu = sanPhamService.getIDNhanHieu(cboNhanHieu1.getSelectedItem() + "");
        idXuatXu = sanPhamService.getIDXuatXu(cboXuatXu1.getSelectedItem() + "");
        _lstSanPhamView = sanPhamService.findSanPham(idDanhMuc, idNhanHieu, idNhomHuong, idXuatXu, getStart(_soTrang), getEnd(_soTrang));
        fillToTableSanPham(_lstSanPhamView);
        lblSoTrang.setText(String.valueOf(_soTrang));
        if (_lstSanPhamView.isEmpty()) {
            System.out.println("");
        } else {
            imageUrl = _lstSanPhamView.get(indexSp).getImageUrl();
            showImage(imageUrl);
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

    public void initCboTimKiem() {
        cboDanhMuc1.setSelectedItem("All");
        cboNhanHieu1.setSelectedItem("All");
        cboNhomHuong1.setSelectedItem("All");
        cboXuatXu1.setSelectedItem("All");
    }

    public void fillOnClickSanPham() {
        if (_lstSanPhamView.isEmpty()) {
            System.out.println("");
        } else {
            txtTenSp.setText(String.valueOf(tblSanPham.getValueAt(indexSp, 0)));
            cboDanhMuc.setSelectedItem(String.valueOf(tblSanPham.getValueAt(indexSp, 1)));
            cboHuong.setSelectedItem(String.valueOf(tblSanPham.getValueAt(indexSp, 2)));
            txtDungTich.setText(String.valueOf(tblSanPham.getValueAt(indexSp, 3)));
            cboNhanHieu.setSelectedItem(String.valueOf(tblSanPham.getValueAt(indexSp, 4)));
            cboXuatXu.setSelectedItem(String.valueOf(tblSanPham.getValueAt(indexSp, 5)));
            txtMoTa.setText(String.valueOf(tblSanPham.getValueAt(indexSp, 6)));
            txtGiaGoc.setText(String.valueOf(tblSanPham.getValueAt(indexSp, 7)));
            txtChietKhau.setText(String.valueOf(tblSanPham.getValueAt(indexSp, 8)));
            lblGiaGiam.setText(String.valueOf(tblSanPham.getValueAt(indexSp, 9)));
            lblNgayThem.setText(String.valueOf(tblSanPham.getValueAt(indexSp, 10)));
            cboTinhTrang.setSelectedItem(String.valueOf(tblSanPham.getValueAt(indexSp, 11)));
            String tenSp = String.valueOf(tblSanPham.getValueAt(indexSp, 0));
            int dungTich = Integer.parseInt(String.valueOf(tblSanPham.getValueAt(indexSp, 3)));
            String idSanPham = sanPhamService.getIDSanPham(tenSp, dungTich);
            String imageUrl = sanPhamService.getImageUrl(idSanPham);
            lblIdSp.setText(idSanPham);
            showImage(imageUrl);
        }

    }

    public void clearThuocTinh() {
        lblIdThuocTinh.setText("");
        txtTenThuocTinh.setText("");
        cboTinhTrangThuocTinh.setSelectedIndex(0);
    }

//    public void themSanPham(SanPhamView sanPhamView) {
//        model = (DefaultTableModel) tblSanPham.getModel();
//        model.addRow(new Object[]{
//            sanPhamView.getTenSanPham(),
//            sanPhamView.getTenDanhMuc(),
//            sanPhamView.getTenNhomHuong(),
//            sanPhamView.getKichThuoc(),
//            sanPhamView.getTenNhanHieu(),
//            sanPhamView.getTenXuatxu(),
//            sanPhamView.getMoTa(),
//            sanPhamView.getGiaGoc(),
//            sanPhamView.getChietKhau(),
//            sanPhamView.getGiaGiam(),
//            sanPhamView.getNgayThem(),
//            conVertTinhTrangSanPhamToString(sanPhamView.getTinhTrang())});
//
//    }
//
//    public void suaSanPham() {
//        tblSanPham.setValueAt(txtTenSp.getText(), indexSp, 0);
//        tblSanPham.setValueAt(cboDanhMuc.getSelectedItem(), indexSp, 1);
//        tblSanPham.setValueAt(cboHuong.getSelectedItem(), indexSp, 2);
//        tblSanPham.setValueAt(txtDungTich.getText(), indexSp, 3);
//        tblSanPham.setValueAt(cboNhanHieu.getSelectedItem(), indexSp, 4);
//        tblSanPham.setValueAt(cboXuatXu.getSelectedItem(), indexSp, 5);
//        tblSanPham.setValueAt(txtMoTa.getText(), indexSp, 6);
//        tblSanPham.setValueAt(txtGiaGoc.getText(), indexSp, 7);
//        tblSanPham.setValueAt(txtChietKhau.getText(), indexSp, 8);
//        tblSanPham.setValueAt(lblGiaGiam.getText(), indexSp, 9);
//        tblSanPham.setValueAt(lblNgayThem.getText(), indexSp, 10);
//        tblSanPham.setValueAt(cboTinhTrang.getSelectedItem(), indexSp, 11);
//    }
    public void clearSanPham() {
        txtChietKhau.setText("");
        txtDungTich.setText("");
        txtGiaGoc.setText("");
        txtMoTa.setText("");
        txtTenSp.setText("");
        cboDanhMuc.setSelectedItem("None");
        cboHuong.setSelectedItem("None");
        cboNhanHieu.setSelectedItem("None");
        cboXuatXu.setSelectedItem("None");
        lblIdSp.setText("");

    }

    public String conVertTinhTrangSanPhamToString(int tinhTrang) {
        if (tinhTrang == 0) {
            return "Tạm ngừng bán";
        }
        return "Đang bán";
    }

    public String conVertTinhTrangThuocTinhToString(int tinhTrang) {
        if (tinhTrang == 0) {
            return "Đã xóa";
        }
        return "Còn tồn tại";
    }

    public int conVertTinhTrangToInt(String tinhTrang) {

        if (tinhTrang.equalsIgnoreCase("Tạm ngưng bán")) {
            return 0;
        } else {
            return 1;
        }
    }

    public void fillToTableSanPham(List<SanPhamView> lstSanPhamView) {
        if (lstSanPhamView.isEmpty()) {
            System.out.println("");
        } else {
            model = (DefaultTableModel) tblSanPham.getModel();
            model.setRowCount(0);

            for (SanPhamView sanPhamView : lstSanPhamView) {
                model.addRow(new Object[]{
                    sanPhamView.getTenSanPham(),
                    sanPhamView.getTenDanhMuc(),
                    sanPhamView.getTenNhomHuong(),
                    sanPhamView.getKichThuoc(),
                    sanPhamView.getTenNhanHieu(),
                    sanPhamView.getTenXuatxu(),
                    sanPhamView.getMoTa(),
                    sanPhamView.getGiaGoc(),
                    sanPhamView.getChietKhau(),
                    sanPhamView.getGiaGiam(),
                    sanPhamView.getNgayThem(),
                    conVertTinhTrangSanPhamToString(sanPhamView.getTinhTrang())});
            }
        }

    }

    public void setCboTimKiemTruocKhiFillLai() {
        cboDanhMuc1.setSelectedItem(DanhMuc);
        cboNhanHieu1.setSelectedItem(NhanHieu);
        cboNhomHuong1.setSelectedItem(NhomHuong);
        cboXuatXu1.setSelectedItem(XuatXu);
    }
//    public void fillToTableSanPhamIndex(List<SanPhamView> lstSanPhamView, int index) {
//        if (lstSanPhamView.isEmpty()) {
//            System.out.println("List San Pham Rong");
//        } else {
//            model = (DefaultTableModel) tblSanPham.getModel();
//            model.setRowCount(0);
//            int end = index * 10;
//            int start = end - 10;
//            if (lstSanPhamView.size() < end) {
//                end = lstSanPhamView.size();
//            }
//
//
//            for (int i = start; i < end; i++) {
//                model.addRow(new Object[]{
//                    lstSanPhamView.get(i).getTenSanPham(),
//                    lstSanPhamView.get(i).getTenDanhMuc(),
//                    lstSanPhamView.get(i).getTenNhomHuong(),
//                    lstSanPhamView.get(i).getKichThuoc(),
//                    lstSanPhamView.get(i).getTenNhanHieu(),
//                    lstSanPhamView.get(i).getTenXuatxu(),
//                    lstSanPhamView.get(i).getMoTa(),
//                    lstSanPhamView.get(i).getGiaGoc(),
//                    lstSanPhamView.get(i).getChietKhau(),
//                    lstSanPhamView.get(i).getGiaGiam(),
//                    lstSanPhamView.get(i).getNgayThem(),
//                    conVertTinhTrangSanPhamToString(lstSanPhamView.get(i).getTinhTrang())});
//            }
//        }
//
//    }

    public void fillToCboSanPham() {
        lstDanhMuc = sanPhamService.getDanhMuc();
        lstNhomHuong = sanPhamService.getNhomHuong();
        lstNhanHieu = sanPhamService.getNhanHieu();
        lstXuatXu = sanPhamService.getXuatXu();
        if (lstDanhMuc.isEmpty() || lstNhomHuong.isEmpty() || lstNhanHieu.isEmpty() || lstXuatXu.isEmpty()) {
            System.out.println("");
        } else {
            cboDanhMuc.removeAllItems();
            for (String string : lstDanhMuc) {

                cboDanhMuc.addItem(string);
            }

            cboHuong.removeAllItems();
            for (String string : lstNhomHuong) {

                cboHuong.addItem(string);
            }

            cboNhanHieu.removeAllItems();
            for (String string : lstNhanHieu) {

                cboNhanHieu.addItem(string);

            }

            cboXuatXu.removeAllItems();
            for (String string : lstXuatXu) {

                cboXuatXu.addItem(string);
            }
            lstDanhMuc.add("All");
            cboDanhMuc1.removeAllItems();
            for (String string : lstDanhMuc) {

                cboDanhMuc1.addItem(string);
            }
            lstNhomHuong.add("All");
            cboNhomHuong1.removeAllItems();
            for (String string : lstNhomHuong) {

                cboNhomHuong1.addItem(string);
            }
            lstNhanHieu.add("All");
            cboNhanHieu1.removeAllItems();
            for (String string : lstNhanHieu) {

                cboNhanHieu1.addItem(string);
            }
            lstXuatXu.add("All");
            cboXuatXu1.removeAllItems();
            for (String string : lstXuatXu) {

                cboXuatXu1.addItem(string);
            }
        }

    }

    public String getImageUrl() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        fileChooser.setDialogTitle("Chon anh");
        File img = fileChooser.getSelectedFile();

        return img.getAbsolutePath();

    }

    public void showImage(String imageUrl) {
        if (imageUrl != null) {
            ImageIcon imgBeforeResize = new ImageIcon(imageUrl);
            Image img = imgBeforeResize.getImage();
            if (anhSp.getWidth() == 0 && anhSp.getHeight() == 0) {
                anhSp.setSize(1, 1);
            }
            Image newImg = img.getScaledInstance(anhSp.getWidth(), anhSp.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon imgAfterResize = new ImageIcon(newImg);
            anhSp.setIcon(imgAfterResize);
        } else {
            anhSp.setIcon(null);
        }

    }

    private void loadThuoctinh() {
        if (rdoDanhMuc.isSelected()) {
            tblThuocTinhModel = (DefaultTableModel) tblThuocTinh.getModel();
            tblThuocTinhModel.setRowCount(0);
            if (danhMucService.getList().isEmpty()) {

                clearThuocTinh();
            } else {
                for (DanhMuc dm : danhMucService.getList()) {
                    tblThuocTinhModel.addRow(new Object[]{
                        dm.getIdDanhMuc(),
                        dm.getTenDanhMuc(),
                        dm.getNgayThem(),
                        conVertTinhTrangThuocTinhToString(dm.getTrangThai())});
                }
            }

        } else if (rdoNhanHieu.isSelected()) {
            tblThuocTinhModel = (DefaultTableModel) tblThuocTinh.getModel();
            tblThuocTinhModel.setRowCount(0);
            if (nhanHieuService.getList().isEmpty()) {
                clearThuocTinh();;
            } else {
                for (NhanHieu nh : nhanHieuService.getList()) {
                    tblThuocTinhModel.addRow(new Object[]{nh.getIdNhanHieu(), nh.getTenNhanHieu(), nh.getNgayThem(), conVertTinhTrangThuocTinhToString(nh.getTrangThai())});
                }
            }

        } else if (rdoNhomHuong.isSelected()) {
            tblThuocTinhModel = (DefaultTableModel) tblThuocTinh.getModel();
            tblThuocTinhModel.setRowCount(0);
            if (nhomHuongService.getList().isEmpty()) {
                clearThuocTinh();
            } else {
                for (NhomHuong nh : nhomHuongService.getList()) {
                    tblThuocTinhModel.addRow(new Object[]{nh.getIdNhomHuong(), nh.getTenNhomHuong(), nh.getNgayThem(), conVertTinhTrangThuocTinhToString(nh.getTrangThai())});
                }
            }

        } else if (rdoXuatXu.isSelected()) {
            tblThuocTinhModel = (DefaultTableModel) tblThuocTinh.getModel();
            tblThuocTinhModel.setRowCount(0);
            if (xuatXuService.getList().isEmpty()) {
                clearThuocTinh();
            } else {
                for (XuatXu xx : xuatXuService.getList()) {
                    tblThuocTinhModel.addRow(new Object[]{xx.getIdXuatXu(), xx.getTen(), xx.getNgayThem(), conVertTinhTrangThuocTinhToString(xx.getTrangThai())});
                }
            }

        } else {
            tblThuocTinhModel = (DefaultTableModel) tblThuocTinh.getModel();
            tblThuocTinhModel.setRowCount(0);
        }
    }

    public boolean checkRongTxt(JTextField txt) {
        if (txt.getText().trim().equalsIgnoreCase("")) {
            return false;
        }
        return true;
    }

    public boolean checkRongTxtArea(JTextArea txtA) {
        if (txtA.getText().trim().equalsIgnoreCase("")) {
            return false;
        }
        return true;
    }

    public boolean checkPhaiLaSo(JTextField txt) {
        try {
            int a = Integer.parseInt(txt.getText());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkPhaiDuong(JTextField txt) {
        if (Integer.parseInt(txt.getText()) <= 0) {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnChonAnh = new javax.swing.JButton();
        anhSp = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cboXuatXu = new javax.swing.JComboBox<>();
        cboHuong = new javax.swing.JComboBox<>();
        txtDungTich = new javax.swing.JTextField();
        cboNhanHieu = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtGiaGoc = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        txtTenSp = new javax.swing.JTextField();
        cboTinhTrang = new javax.swing.JComboBox<>();
        cboDanhMuc = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        txtChietKhau = new javax.swing.JTextField();
        lblIdSp = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lblNgayThem = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lblGiaGiam = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLocSp = new javax.swing.JButton();
        btnNhapFile = new javax.swing.JButton();
        cboDanhMuc1 = new javax.swing.JComboBox<>();
        cboNhomHuong1 = new javax.swing.JComboBox<>();
        cboNhanHieu1 = new javax.swing.JComboBox<>();
        cboXuatXu1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        lblSoTrang = new javax.swing.JLabel();
        btnCuoi = new javax.swing.JButton();
        btnDau = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtTenThuocTinh = new javax.swing.JTextField();
        cboTinhTrangThuocTinh = new javax.swing.JComboBox<>();
        lblIdThuocTinh = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblThuocTinh = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnThemThuocTinh = new javax.swing.JButton();
        btnSuaThuocTinh = new javax.swing.JButton();
        btnXoaThuocTinh = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        rdoNhanHieu = new javax.swing.JRadioButton();
        rdoNhomHuong = new javax.swing.JRadioButton();
        rdoXuatXu = new javax.swing.JRadioButton();
        rdoDanhMuc = new javax.swing.JRadioButton();

        setPreferredSize(new java.awt.Dimension(1100, 780));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setEnabled(false);

        jPanel4.setBackground(new java.awt.Color(255, 218, 187));
        jPanel4.setEnabled(false);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnChonAnh.setText("Chọn ảnh");
        btnChonAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonAnhActionPerformed(evt);
            }
        });
        jPanel4.add(btnChonAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, -1, -1));
        jPanel4.add(anhSp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 220, 273));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Id");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Tên sản phẩm");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 65, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Dung tích");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, -1, -1));

        jPanel4.add(cboXuatXu, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, 240, -1));

        jPanel4.add(cboHuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 135, 240, -1));
        jPanel4.add(txtDungTich, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 240, -1));

        jPanel4.add(cboNhanHieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 205, 240, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Mô tả");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 30, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Giá gốc");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 120, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Ngày thêm");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 240, -1, -1));
        jPanel4.add(txtGiaGoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 120, 230, -1));

        txtMoTa.setColumns(20);
        txtMoTa.setLineWrap(true);
        txtMoTa.setRows(5);
        jScrollPane2.setViewportView(txtMoTa);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 30, 230, 80));
        jPanel4.add(txtTenSp, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 65, 240, -1));

        cboTinhTrang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang bán", "Tạm ngưng bán" }));
        cboTinhTrang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTinhTrangActionPerformed(evt);
            }
        });
        jPanel4.add(cboTinhTrang, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 210, 230, -1));

        jPanel4.add(cboDanhMuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 240, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Chiết khấu %");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 150, -1, -1));
        jPanel4.add(txtChietKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 150, 230, -1));
        jPanel4.add(lblIdSp, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 240, 20));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Danh mục");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Nhãn hiệu");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 205, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Hương");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 135, -1, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Xuất sứ");
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, 60, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Id");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, -1, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Tình trạng");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 210, -1, -1));
        jPanel4.add(lblNgayThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 240, 230, 20));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("Giá gốc");
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 180, -1, -1));
        jPanel4.add(lblGiaGiam, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 180, 230, 20));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách sản phẩm"));
        jPanel12.setEnabled(false);

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên sản phẩm", "Danh mục", "Hương", "Dung tích", "Nhãn hiệu", "Xuất xứ", "Mô tả", "Giá gốc", "Chiết khấu", "Giá giảm", "Ngày thêm", "Tinh trang"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
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
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(234, 162, 96));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Sua.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(234, 162, 96));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Xoa.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnLocSp.setBackground(new java.awt.Color(51, 255, 51));
        btnLocSp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLocSp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Untitled-1.png"))); // NOI18N
        btnLocSp.setText("Lọc");
        btnLocSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocSpActionPerformed(evt);
            }
        });

        btnNhapFile.setBackground(new java.awt.Color(234, 162, 96));
        btnNhapFile.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNhapFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/iconExcel.png"))); // NOI18N
        btnNhapFile.setText("Nhập File");
        btnNhapFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapFileActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Danh mục");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Nhãn hiệu");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Hương");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Xuất sứ");

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

        btnCuoi.setText("Cuối");
        btnCuoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCuoiMouseClicked(evt);
            }
        });

        btnDau.setText("Đầu");
        btnDau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDauMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(btnThem)
                                .addGap(18, 18, 18)
                                .addComponent(btnSua)
                                .addGap(18, 18, 18)
                                .addComponent(btnXoa))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
                                .addComponent(btnNhapFile, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLocSp, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboNhanHieu1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboDanhMuc1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboXuatXu1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboNhomHuong1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 983, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnDau)
                .addGap(18, 18, 18)
                .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblSoTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCuoi)
                .addGap(326, 326, 326))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(cboDanhMuc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboNhomHuong1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNhapFile)
                    .addComponent(btnLocSp)
                    .addComponent(cboNhanHieu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboXuatXu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSoTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNext)
                        .addComponent(btnPrev)
                        .addComponent(btnCuoi)
                        .addComponent(btnDau)))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sản phẩm", jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setEnabled(false);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel8.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Id");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Tên");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Tình trạng");

        txtTenThuocTinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cboTinhTrangThuocTinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboTinhTrangThuocTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đã xóa", "Còn tồn tại" }));
        cboTinhTrangThuocTinh.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboTinhTrangThuocTinhItemStateChanged(evt);
            }
        });
        cboTinhTrangThuocTinh.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cboTinhTrangThuocTinhPropertyChange(evt);
            }
        });
        cboTinhTrangThuocTinh.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                cboTinhTrangThuocTinhVetoableChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboTinhTrangThuocTinh, 0, 382, Short.MAX_VALUE)
                    .addComponent(txtTenThuocTinh)
                    .addComponent(lblIdThuocTinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(lblIdThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtTenThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboTinhTrangThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel7.setEnabled(false);

        tblThuocTinh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id ", "Tên", "Ngày thêm", "Tình trạng"
            }
        ));
        tblThuocTinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThuocTinhMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblThuocTinh);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 962, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 918, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(26, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 442, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(17, 17, 17)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(18, Short.MAX_VALUE)))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setEnabled(false);

        btnThemThuocTinh.setBackground(new java.awt.Color(234, 162, 96));
        btnThemThuocTinh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemThuocTinh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Them.png"))); // NOI18N
        btnThemThuocTinh.setText("Thêm");
        btnThemThuocTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemThuocTinhActionPerformed(evt);
            }
        });

        btnSuaThuocTinh.setBackground(new java.awt.Color(234, 162, 96));
        btnSuaThuocTinh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSuaThuocTinh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Sua.png"))); // NOI18N
        btnSuaThuocTinh.setText("Sửa");
        btnSuaThuocTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaThuocTinhActionPerformed(evt);
            }
        });

        btnXoaThuocTinh.setBackground(new java.awt.Color(234, 162, 96));
        btnXoaThuocTinh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXoaThuocTinh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Xoa.png"))); // NOI18N
        btnXoaThuocTinh.setText("Xóa");
        btnXoaThuocTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaThuocTinhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnThemThuocTinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSuaThuocTinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoaThuocTinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnThemThuocTinh)
                .addGap(43, 43, 43)
                .addComponent(btnSuaThuocTinh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXoaThuocTinh)
                .addGap(22, 22, 22))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel9.setEnabled(false);

        buttonGroup1.add(rdoNhanHieu);
        rdoNhanHieu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoNhanHieu.setText("Nhãn hiệu");
        rdoNhanHieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNhanHieuActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoNhomHuong);
        rdoNhomHuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoNhomHuong.setText("Nhóm hương");
        rdoNhomHuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNhomHuongActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoXuatXu);
        rdoXuatXu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoXuatXu.setText("Xuất xứ");
        rdoXuatXu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoXuatXuActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoDanhMuc);
        rdoDanhMuc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoDanhMuc.setText("Danh mục");
        rdoDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoDanhMucActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdoNhanHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoNhomHuong))
                .addContainerGap(7, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(rdoNhanHieu)
                .addGap(27, 27, 27)
                .addComponent(rdoNhomHuong)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(rdoXuatXu)
                .addGap(28, 28, 28)
                .addComponent(rdoDanhMuc)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(159, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thuộc tính", jPanel6);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1151, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 812, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnChonAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonAnhActionPerformed
        imageUrl = getImageUrl();
        showImage(imageUrl);
    }//GEN-LAST:event_btnChonAnhActionPerformed

    private void cboTinhTrangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTinhTrangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboTinhTrangActionPerformed

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        indexSp = tblSanPham.getSelectedRow();
        fillOnClickSanPham();
        imageUrl = sanPhamService.getImageUrl(lblIdSp.getText());

    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (checkRongTxtArea(txtMoTa) == false || checkRongTxt(txtTenSp) == false || checkRongTxt(txtDungTich) == false || checkRongTxt(txtGiaGoc) == false || checkRongTxt(txtChietKhau) == false) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
        } else if (checkPhaiLaSo(txtDungTich) == false || checkPhaiLaSo(txtChietKhau) == false || checkPhaiLaSo(txtGiaGoc) == false) {
            JOptionPane.showMessageDialog(this, "Dung tích, chiết khấu, giá gốc phải là số");
        } else if (checkPhaiDuong(txtGiaGoc) == false || checkPhaiDuong(txtDungTich) == false) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập giá, dung tích  >0");
        } else if (Integer.parseInt(txtChietKhau.getText()) < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập chiết khấu >= 0");
        } else if (sanPhamService.getIDSanPham(txtTenSp.getText(), Integer.parseInt(txtDungTich.getText())).isEmpty() == false) {
            JOptionPane.showMessageDialog(this, "Sản phẩm đã bị trùng");
        } else {
            if (JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm không") == JOptionPane.YES_OPTION) {
                SanPhamView sanPhamView = new SanPhamView();
                sanPhamView.setGiaGoc(new BigDecimal(txtGiaGoc.getText()));
//            sanPhamView.setIdSanPham(lblIdSp.getText());
                sanPhamView.setKichThuoc(Integer.parseInt(txtDungTich.getText()));
                sanPhamView.setMoTa(txtMoTa.getText());
                sanPhamView.setSoLuongTon(0);
                sanPhamView.setTenSanPham(txtTenSp.getText());
                sanPhamView.setImageUrl(imageUrl);
                sanPhamView.setTinhTrang(conVertTinhTrangToInt(String.valueOf(cboTinhTrang.getSelectedItem())));
                sanPhamView.setChietKhau(Integer.parseInt(txtChietKhau.getText()));

                sanPhamView.setTenDanhMuc(String.valueOf(cboDanhMuc.getSelectedItem()));
                sanPhamView.setTenNhomHuong(String.valueOf(cboHuong.getSelectedItem()));
                sanPhamView.setTenNhanHieu(String.valueOf(cboNhanHieu.getSelectedItem()));
                sanPhamView.setTenXuatxu(String.valueOf(cboXuatXu.getSelectedItem()));
                JOptionPane.showMessageDialog(this, sanPhamService.addSanPham(sanPhamView));
                String idSanPham = sanPhamService.getIDSanPham(sanPhamView.getTenSanPham(), sanPhamView.getKichThuoc());
                _lstSanPhamView = sanPhamService.findSanPham(idDanhMuc, idNhanHieu, idNhomHuong, idXuatXu, getStart(_soTrang), getEnd(_soTrang));
                sanPhamView.setGiaGiam(sanPhamService.getGiaGiam(idSanPham));
                sanPhamView.setNgayThem(sanPhamService.getNgayThem(idSanPham));
                _soTrang = 1;
                fillToTableSanPham(_lstSanPhamView);
                lblSoTrang.setText(String.valueOf(_soTrang));
                showImage(imageUrl);
            }

        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (checkRongTxtArea(txtMoTa) == false || checkRongTxt(txtTenSp) == false || checkRongTxt(txtDungTich) == false || checkRongTxt(txtGiaGoc) == false || checkRongTxt(txtChietKhau) == false) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
        } else if (checkPhaiLaSo(txtDungTich) == false || checkPhaiLaSo(txtChietKhau) == false || checkPhaiLaSo(txtGiaGoc) == false) {
            JOptionPane.showMessageDialog(this, "Dung tích, chiết khấu, giá gốc phải là số");
        } else if (checkPhaiDuong(txtDungTich) == false || checkPhaiDuong(txtGiaGoc) == false) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập dung tích, giá >0");
        } else if (Integer.parseInt(txtChietKhau.getText()) < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập chiết khấu >= 0");
        } else {
            if (JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa không") == JOptionPane.YES_OPTION) {
                String tenCu = tblSanPham.getValueAt(indexSp, 0) + "";
                int dungTichCu = Integer.parseInt(tblSanPham.getValueAt(indexSp, 3) + "");
                String tenMoi = txtTenSp.getText();
                int dungTichMoi = Integer.parseInt(txtDungTich.getText());
                if (tenMoi.equalsIgnoreCase(tenCu) && dungTichMoi == dungTichCu) {
                    SanPhamView sanPhamView = new SanPhamView();
                    sanPhamView.setGiaGoc(new BigDecimal(txtGiaGoc.getText()));
                    sanPhamView.setIdSanPham(lblIdSp.getText());
                    sanPhamView.setKichThuoc(Integer.parseInt(txtDungTich.getText()));
                    sanPhamView.setMoTa(txtMoTa.getText());

                    sanPhamView.setTenSanPham(txtTenSp.getText());
                    sanPhamView.setImageUrl(imageUrl);
                    sanPhamView.setTinhTrang(conVertTinhTrangToInt(String.valueOf(cboTinhTrang.getSelectedItem())));
                    sanPhamView.setChietKhau(Integer.parseInt(txtChietKhau.getText()));
                    sanPhamView.setTenDanhMuc(String.valueOf(cboDanhMuc.getSelectedItem()));
                    sanPhamView.setTenNhomHuong(String.valueOf(cboHuong.getSelectedItem()));
                    sanPhamView.setTenNhanHieu(String.valueOf(cboNhanHieu.getSelectedItem()));
                    sanPhamView.setTenXuatxu(String.valueOf(cboXuatXu.getSelectedItem()));
                    JOptionPane.showMessageDialog(this, sanPhamService.updateSanPham(sanPhamView));
                    _lstSanPhamView = sanPhamService.findSanPham(idDanhMuc, idNhanHieu, idNhomHuong, idXuatXu, getStart(_soTrang), getEnd(_soTrang));
                    fillToTableSanPham(_lstSanPhamView);
                    showImage(imageUrl);
                } else {
                    if (sanPhamService.getIDSanPham(tenMoi, dungTichMoi).isEmpty() == false) {
                        JOptionPane.showMessageDialog(this, "Sản phẩm đã bị trùng");
                    }else {
                        SanPhamView sanPhamView = new SanPhamView();
                    sanPhamView.setGiaGoc(new BigDecimal(txtGiaGoc.getText()));
                    sanPhamView.setIdSanPham(lblIdSp.getText());
                    sanPhamView.setKichThuoc(Integer.parseInt(txtDungTich.getText()));
                    sanPhamView.setMoTa(txtMoTa.getText());

                    sanPhamView.setTenSanPham(txtTenSp.getText());
                    sanPhamView.setImageUrl(imageUrl);
                    sanPhamView.setTinhTrang(conVertTinhTrangToInt(String.valueOf(cboTinhTrang.getSelectedItem())));
                    sanPhamView.setChietKhau(Integer.parseInt(txtChietKhau.getText()));
                    sanPhamView.setTenDanhMuc(String.valueOf(cboDanhMuc.getSelectedItem()));
                    sanPhamView.setTenNhomHuong(String.valueOf(cboHuong.getSelectedItem()));
                    sanPhamView.setTenNhanHieu(String.valueOf(cboNhanHieu.getSelectedItem()));
                    sanPhamView.setTenXuatxu(String.valueOf(cboXuatXu.getSelectedItem()));
                    JOptionPane.showMessageDialog(this, sanPhamService.updateSanPham(sanPhamView));
                    _lstSanPhamView = sanPhamService.findSanPham(idDanhMuc, idNhanHieu, idNhomHuong, idXuatXu, getStart(_soTrang), getEnd(_soTrang));
                    fillToTableSanPham(_lstSanPhamView);
                    showImage(imageUrl);    
                    }
                }

            }

        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không");
        if (confirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, sanPhamService.deleteSanPham(_lstSanPhamView.get(indexSp).getIdSanPham()));
            _lstSanPhamView = sanPhamService.findSanPham(idDanhMuc, idNhanHieu, idNhomHuong, idXuatXu, getStart(_soTrang), getEnd(_soTrang));
            if (_lstSanPhamView.isEmpty()) {
                model = (DefaultTableModel) tblSanPham.getModel();
                model.setRowCount(0);
                clearSanPham();
            } else {
                fillToTableSanPham(_lstSanPhamView);
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnLocSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocSpActionPerformed
        idDanhMuc = sanPhamService.getIDDanhMuc(cboDanhMuc1.getSelectedItem() + "");
        idNhomHuong = sanPhamService.getIDNhomHuong(cboNhomHuong1.getSelectedItem() + "");
        idNhanHieu = sanPhamService.getIDNhanHieu(cboNhanHieu1.getSelectedItem() + "");
        idXuatXu = sanPhamService.getIDXuatXu(cboXuatXu1.getSelectedItem() + "");
        DanhMuc = cboDanhMuc1.getSelectedItem() + "";
        NhomHuong = cboNhomHuong1.getSelectedItem() + "";
        NhanHieu = cboNhanHieu1.getSelectedItem() + "";
        XuatXu = cboXuatXu1.getSelectedItem() + "";
        _soTrang = 1;
        _lstSanPhamView = sanPhamService.findSanPham(idDanhMuc, idNhanHieu, idNhomHuong, idXuatXu, getStart(_soTrang), getEnd(_soTrang));
        lblSoTrang.setText(_soTrang + "");
        if (_lstSanPhamView.size() == 0) {
            model.setRowCount(0);
            JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm");
            return;
        }
        fillToTableSanPham(_lstSanPhamView);
    }//GEN-LAST:event_btnLocSpActionPerformed

    private void btnNhapFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapFileActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Bạn có muốn nhập Excel không") == JOptionPane.YES_OPTION) {
            File excelFile;
            FileInputStream excelFIS = null;
            BufferedInputStream excelBIS = null;
            XSSFWorkbook excelJTableImport = null;
            String defaultCurrentDirectoryPath = "D:\\NetbeanWorkspace\\Manage_Perfume_Shop\\FileExcel";
            JFileChooser excelFileChooser = new JFileChooser(defaultCurrentDirectoryPath);
            int excelChooser = excelFileChooser.showOpenDialog(null);
            if (excelChooser == JFileChooser.APPROVE_OPTION) {
                try {
                    excelFile = excelFileChooser.getSelectedFile();
                    excelFIS = new FileInputStream(excelFile);
                    excelBIS = new BufferedInputStream(excelFIS);
                    excelJTableImport = new XSSFWorkbook(excelBIS);
                    XSSFSheet excelSheet = excelJTableImport.getSheetAt(0);
                    for (int row = 1; row < excelSheet.getLastRowNum(); row++) {
                        XSSFRow excelRow = excelSheet.getRow(row);
                        if (excelRow.getCell(1) == null || excelRow.getCell(1).getCellType() == CellType.BLANK) {
                            break;
                        }
                        if (sanPhamService.checkProduct(excelRow.getCell(1).toString(), (int) excelRow.getCell(4).getNumericCellValue()) == false) {
                            SanPhamView sanPhamView = new SanPhamView();
                            sanPhamView.setTenSanPham(excelRow.getCell(1).toString());
                            if (excelRow.getCell(2) == null || excelRow.getCell(2).getCellType() == CellType.BLANK) {
                                sanPhamView.setTenDanhMuc("None");
                            } else {
                                sanPhamView.setTenDanhMuc(excelRow.getCell(2).toString());
                            }
                            if (sanPhamService.checkDanhMuc(sanPhamView.getTenDanhMuc()) == false) {
                                DanhMuc dm = new DanhMuc();
                                dm.setTenDanhMuc(sanPhamView.getTenDanhMuc());
                                dm.setTrangThai(1);
                                danhMucService.insert(dm);
                            } else {
                                danhMucService.updateTrangThai(sanPhamView.getTenDanhMuc());
                            }
                            if (excelRow.getCell(3) == null || excelRow.getCell(3).getCellType() == CellType.BLANK) {
                                sanPhamView.setTenNhomHuong("None");
                            } else {
                                sanPhamView.setTenNhomHuong(excelRow.getCell(3).toString());
                            }
                            if (sanPhamService.checkNhomHuong(sanPhamView.getTenNhomHuong()) == false) {
                                NhomHuong nh = new NhomHuong();
                                nh.setTenNhomHuong(sanPhamView.getTenNhomHuong());
                                nh.setTrangThai(1);
                                nhomHuongService.insert(nh);
                            } else {
                                nhomHuongService.updateTrangThai(nhomHuongService.getIDByName(sanPhamView.getTenNhomHuong()));
                            }
                            sanPhamView.setKichThuoc((int) excelRow.getCell(4).getNumericCellValue());
                            if (excelRow.getCell(5) == null || excelRow.getCell(5).getCellType() == CellType.BLANK) {
                                sanPhamView.setTenNhanHieu("None");
                            } else {
                                sanPhamView.setTenNhanHieu(excelRow.getCell(5).toString());
                            }
                            if (sanPhamService.checkNhanHieu(sanPhamView.getTenNhanHieu()) == false) {
                                NhanHieu nh = new NhanHieu();
                                nh.setTenNhanHieu(sanPhamView.getTenNhanHieu());
                                nh.setTrangThai(1);
                                nhanHieuService.insert(nh);
                            } else {
                                nhanHieuService.updateTrangThai(sanPhamView.getTenNhanHieu());
                            }
                            if (excelRow.getCell(6) == null || excelRow.getCell(6).getCellType() == CellType.BLANK) {
                                sanPhamView.setTenXuatxu("None");
                            } else {
                                sanPhamView.setTenXuatxu(excelRow.getCell(6).toString());
                            }
                            if (sanPhamService.checkXuatXu(sanPhamView.getTenXuatxu()) == false) {
                                XuatXu xx = new XuatXu();
                                xx.setTen(sanPhamView.getTenXuatxu());
                                xx.setTrangThai(1);
                                xuatXuService.insert(xx);
                            } else {
                                xuatXuService.updateTrangThai(sanPhamView.getTenXuatxu());
                            }
                            sanPhamView.setMoTa(excelRow.getCell(7).toString());
                            sanPhamView.setGiaGoc(new BigDecimal(excelRow.getCell(8).toString()));

                            String tinhTrangSTR = excelRow.getCell(14).toString();
                            int tinhTrang;
                            if (tinhTrangSTR.equalsIgnoreCase("Đang bán")) {
                                tinhTrang = 1;
                            } else {
                                tinhTrang = 0;
                            }
                            sanPhamView.setTinhTrang(tinhTrang);
                            sanPhamView.setChietKhau((int) excelRow.getCell(15).getNumericCellValue());
                            sanPhamView.setImageUrl(excelRow.getCell(16).toString());
                            sanPhamService.addSanPham(sanPhamView);
                        }
                    }
                    _soTrang = 1;
                    _lstSanPhamView = sanPhamService.findSanPham(idDanhMuc, idNhanHieu, idNhomHuong, idXuatXu, getStart(_soTrang), getEnd(_soTrang));
                    fillToTableSanPham(_lstSanPhamView);
                    fillToCboSanPham();
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(this, "File này không tồn tại");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Nhập file excel thất bại");
                } catch (Exception ex) { // handle your exception
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Vui lòng chọn lại file");
                }

            }
        }

    }//GEN-LAST:event_btnNhapFileActionPerformed

    private void tblThuocTinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThuocTinhMouseClicked
        index = tblThuocTinh.getSelectedRow();
        lblIdThuocTinh.setText(tblThuocTinh.getValueAt(index, 0).toString());
        txtTenThuocTinh.setText(tblThuocTinh.getValueAt(index, 1).toString());
        if (tblThuocTinh.getValueAt(index, 3).toString().trim().equals("Đã xóa")) {
            cboTinhTrangThuocTinh.setSelectedIndex(0);
        } else {
            cboTinhTrangThuocTinh.setSelectedIndex(1);
        }
    }//GEN-LAST:event_tblThuocTinhMouseClicked

    private void btnThemThuocTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemThuocTinhActionPerformed
        if (!rdoDanhMuc.isSelected() && !rdoNhanHieu.isSelected() && !rdoNhomHuong.isSelected() && !rdoXuatXu.isSelected()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn thuộc tính");
            return;
        }
        if (txtTenThuocTinh.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui long khong de trong");
            return;
        }
        String idThuocTinh;
        try {
            idThuocTinh = lblIdThuocTinh.getText();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui long nhap id la so");
            return;
        }
        String tenThuocTinh = txtTenThuocTinh.getText();
        int trangThai;
        if (cboTinhTrangThuocTinh.getSelectedItem().toString().equals("Đã xóa")) {
            trangThai = 0;
        } else {
            trangThai = 1;
        }
        if (JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm không") == JOptionPane.YES_OPTION) {
            if (rdoDanhMuc.isSelected()) {
                if (danhMucService.checkTrung(tenThuocTinh).isEmpty() == false) {
                    JOptionPane.showMessageDialog(this, "Đã tồn tại");
                    return;
                }
                DanhMuc dm = new DanhMuc(idThuocTinh, tenThuocTinh, null, null, trangThai);
                JOptionPane.showMessageDialog(this, danhMucService.insert(dm));
                loadThuoctinh();
                fillToCboSanPham();
            } else if (rdoNhanHieu.isSelected()) {
                if (nhanHieuService.checkTrung(tenThuocTinh).isEmpty() == false) {
                    JOptionPane.showMessageDialog(this, "Đã tồn tại");
                    return;
                }
                NhanHieu nh = new NhanHieu(idThuocTinh, tenThuocTinh, trangThai);
                JOptionPane.showMessageDialog(this, nhanHieuService.insert(nh));
                loadThuoctinh();
                fillToCboSanPham();
            } else if (rdoNhomHuong.isSelected()) {
                if (nhomHuongService.checkTrung(tenThuocTinh).isEmpty() == false) {
                    JOptionPane.showMessageDialog(this, "Đã tồn tại");
                    return;
                }
                NhomHuong nh = new NhomHuong(idThuocTinh, tenThuocTinh, trangThai);
                JOptionPane.showMessageDialog(this, nhomHuongService.insert(nh));
                loadThuoctinh();
                fillToCboSanPham();
            } else {
                if (xuatXuService.checkTrung(tenThuocTinh).isEmpty() == false) {
                    JOptionPane.showMessageDialog(this, "Đã tồn tại");
                    return;
                }
                XuatXu xx = new XuatXu(idThuocTinh, tenThuocTinh, trangThai);
                JOptionPane.showMessageDialog(this, xuatXuService.insert(xx));
                loadThuoctinh();
                fillToCboSanPham();
            }

        }


    }//GEN-LAST:event_btnThemThuocTinhActionPerformed

    private void btnSuaThuocTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaThuocTinhActionPerformed
        if (!rdoDanhMuc.isSelected() && !rdoNhanHieu.isSelected() && !rdoNhomHuong.isSelected() && !rdoXuatXu.isSelected()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn thuộc tính");
            return;
        }
        if (lblIdThuocTinh.getText().trim().equals("") || txtTenThuocTinh.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui long khong de trong");
            return;
        }
        String idThuocTinh;
        try {
            idThuocTinh = lblIdThuocTinh.getText();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui long nhap id la so");
            return;
        }
        String tenThuocTinh = txtTenThuocTinh.getText();
        int trangThai;
        if (cboTinhTrangThuocTinh.getSelectedItem().toString().equals("Đã xóa")) {
            trangThai = 0;
        } else {
            trangThai = 1;
        }
        String tenThuocTinhTruocSua = tblThuocTinh.getValueAt(index, 1) + "";
        if (JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa không") == JOptionPane.YES_OPTION) {
            if (rdoDanhMuc.isSelected()) {
                if (tenThuocTinhTruocSua.equalsIgnoreCase(tenThuocTinh)) {
                    DanhMuc dm = new DanhMuc(idThuocTinh, tenThuocTinh, null, null, trangThai);
                    if (trangThai == 0) {
                        sanPhamService.setDanhMucNone(idThuocTinh);
                    }
                    JOptionPane.showMessageDialog(this, danhMucService.update(dm));
                    loadThuoctinh();
                    fillToCboSanPham();
                    _lstSanPhamView = sanPhamService.findSanPham(idDanhMuc, idNhanHieu, idNhomHuong, idXuatXu, getStart(_soTrang), getEnd(_soTrang));
                    fillToTableSanPham(_lstSanPhamView);
                } else {
                    if (danhMucService.checkTrung(tenThuocTinh).isEmpty() == false) {
                        JOptionPane.showMessageDialog(this, "Đã tồn tại");
                        return;
                    }
                    DanhMuc dm = new DanhMuc(idThuocTinh, tenThuocTinh, null, null, trangThai);
                    if (trangThai == 0) {
                        sanPhamService.setDanhMucNone(idThuocTinh);
                    }
                    JOptionPane.showMessageDialog(this, danhMucService.update(dm));
                    loadThuoctinh();
                    fillToCboSanPham();
                    _lstSanPhamView = sanPhamService.findSanPham(idDanhMuc, idNhanHieu, idNhomHuong, idXuatXu, getStart(_soTrang), getEnd(_soTrang));
                    fillToTableSanPham(_lstSanPhamView);
                }

            } else if (rdoNhanHieu.isSelected()) {
                if (tenThuocTinhTruocSua.equalsIgnoreCase(tenThuocTinh)) {
                    NhanHieu nh = new NhanHieu(idThuocTinh, tenThuocTinh, trangThai);
                    if (trangThai == 0) {
                        sanPhamService.setNhanHieuNone(idThuocTinh);
                    }
                    JOptionPane.showMessageDialog(this, nhanHieuService.update(nh));
                    loadThuoctinh();
                    fillToCboSanPham();
                    _lstSanPhamView = sanPhamService.findSanPham(idDanhMuc, idNhanHieu, idNhomHuong, idXuatXu, getStart(_soTrang), getEnd(_soTrang));
                    fillToTableSanPham(_lstSanPhamView);
                } else {
                    if (nhanHieuService.checkTrung(tenThuocTinh).isEmpty() == false) {
                        JOptionPane.showMessageDialog(this, "Đã tồn tại");
                        return;
                    }
                    NhanHieu nh = new NhanHieu(idThuocTinh, tenThuocTinh, trangThai);
                    if (trangThai == 0) {
                        sanPhamService.setNhanHieuNone(idThuocTinh);
                    }
                    JOptionPane.showMessageDialog(this, nhanHieuService.update(nh));
                    loadThuoctinh();
                    fillToCboSanPham();
                    _lstSanPhamView = sanPhamService.findSanPham(idDanhMuc, idNhanHieu, idNhomHuong, idXuatXu, getStart(_soTrang), getEnd(_soTrang));
                    fillToTableSanPham(_lstSanPhamView);
                }

            } else if (rdoNhomHuong.isSelected()) {
                if (tenThuocTinhTruocSua.equalsIgnoreCase(tenThuocTinh)) {
                    NhomHuong nh = new NhomHuong(idThuocTinh, tenThuocTinh, trangThai);
                    if (trangThai == 0) {
                        sanPhamService.setNhomHuongNone(idThuocTinh);
                    }
                    JOptionPane.showMessageDialog(this, nhomHuongService.update(nh));
                    loadThuoctinh();
                    fillToCboSanPham();
                    _lstSanPhamView = sanPhamService.findSanPham(idDanhMuc, idNhanHieu, idNhomHuong, idXuatXu, getStart(_soTrang), getEnd(_soTrang));
                    fillToTableSanPham(_lstSanPhamView);
                } else {
                    if (nhomHuongService.checkTrung(tenThuocTinh).isEmpty() == false) {
                        JOptionPane.showMessageDialog(this, "Đã tồn tại");
                        return;
                    }
                    NhomHuong nh = new NhomHuong(idThuocTinh, tenThuocTinh, trangThai);
                    if (trangThai == 0) {
                        sanPhamService.setNhomHuongNone(idThuocTinh);
                    }
                    JOptionPane.showMessageDialog(this, nhomHuongService.update(nh));
                    loadThuoctinh();
                    fillToCboSanPham();
                    _lstSanPhamView = sanPhamService.findSanPham(idDanhMuc, idNhanHieu, idNhomHuong, idXuatXu, getStart(_soTrang), getEnd(_soTrang));
                    fillToTableSanPham(_lstSanPhamView);
                }

            } else {
                if (tenThuocTinhTruocSua.equalsIgnoreCase(tenThuocTinh)) {
                    XuatXu xx = new XuatXu(idThuocTinh, tenThuocTinh, trangThai);
                    if (trangThai == 0) {
                        sanPhamService.setXuatXuNone(idThuocTinh);
                    }
                    JOptionPane.showMessageDialog(this, xuatXuService.update(xx));
                    loadThuoctinh();
                    fillToCboSanPham();
                    _lstSanPhamView = sanPhamService.findSanPham(idDanhMuc, idNhanHieu, idNhomHuong, idXuatXu, getStart(_soTrang), getEnd(_soTrang));
                    fillToTableSanPham(_lstSanPhamView);
                } else {
                    if (xuatXuService.checkTrung(tenThuocTinh).isEmpty() == false) {
                        JOptionPane.showMessageDialog(this, "Đã tồn tại");
                        return;
                    }
                    XuatXu xx = new XuatXu(idThuocTinh, tenThuocTinh, trangThai);
                    if (trangThai == 0) {
                        sanPhamService.setXuatXuNone(idThuocTinh);
                    }
                    JOptionPane.showMessageDialog(this, xuatXuService.update(xx));
                    loadThuoctinh();
                    fillToCboSanPham();
                    _lstSanPhamView = sanPhamService.findSanPham(idDanhMuc, idNhanHieu, idNhomHuong, idXuatXu, getStart(_soTrang), getEnd(_soTrang));
                    fillToTableSanPham(_lstSanPhamView);
                }

            }
        }


    }//GEN-LAST:event_btnSuaThuocTinhActionPerformed

    private void btnXoaThuocTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaThuocTinhActionPerformed
        int index = tblThuocTinh.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần xóa");
            return;
        }
        int hoi = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa?");
        if (hoi == JOptionPane.NO_OPTION || hoi == JOptionPane.CANCEL_OPTION || hoi == JOptionPane.CLOSED_OPTION) {
            return;
        }
        String id = lblIdThuocTinh.getText();
        if (rdoDanhMuc.isSelected()) {
            JOptionPane.showMessageDialog(this, danhMucService.delete(id));
            sanPhamService.setDanhMucNone(id);
            clearThuocTinh();
            loadThuoctinh();
            fillToCboSanPham();
            setCboTimKiemTruocKhiFillLai();
            cboDanhMuc1.setSelectedItem("NONE");
            idDanhMuc = sanPhamService.getIDDanhMuc("NONE");
            _lstSanPhamView = sanPhamService.findSanPham(idDanhMuc, idNhanHieu, idNhomHuong, idXuatXu, getStart(_soTrang), getEnd(_soTrang));
            fillToTableSanPham(_lstSanPhamView);
        } else if (rdoNhanHieu.isSelected()) {
            JOptionPane.showMessageDialog(this, nhanHieuService.delete(id));
            sanPhamService.setNhanHieuNone(id);
            clearThuocTinh();
            loadThuoctinh();
            fillToCboSanPham();
            setCboTimKiemTruocKhiFillLai();
            cboNhanHieu1.setSelectedItem("NONE");
            idNhanHieu = sanPhamService.getIDNhanHieu("NONE");
            _lstSanPhamView = sanPhamService.findSanPham(idDanhMuc, idNhanHieu, idNhomHuong, idXuatXu, getStart(_soTrang), getEnd(_soTrang));
            fillToTableSanPham(_lstSanPhamView);
        } else if (rdoNhomHuong.isSelected()) {
            JOptionPane.showMessageDialog(this, nhomHuongService.delete(id));
            sanPhamService.setNhomHuongNone(id);
            clearThuocTinh();
            loadThuoctinh();
            fillToCboSanPham();
            setCboTimKiemTruocKhiFillLai();
            cboNhomHuong1.setSelectedItem("NONE");
            idNhomHuong = sanPhamService.getIDNhomHuong("NONE");
            _lstSanPhamView = sanPhamService.findSanPham(idDanhMuc, idNhanHieu, idNhomHuong, idXuatXu, getStart(_soTrang), getEnd(_soTrang));
            fillToTableSanPham(_lstSanPhamView);
        } else {
            JOptionPane.showMessageDialog(this, xuatXuService.delete(id));
            sanPhamService.setXuatXuNone(id);
            clearThuocTinh();
            loadThuoctinh();
            fillToCboSanPham();
            setCboTimKiemTruocKhiFillLai();
            cboXuatXu1.setSelectedItem("NONE");
            idXuatXu = sanPhamService.getIDXuatXu("NONE");
            _lstSanPhamView = sanPhamService.findSanPham(idDanhMuc, idNhanHieu, idNhomHuong, idXuatXu, getStart(_soTrang), getEnd(_soTrang));
            fillToTableSanPham(_lstSanPhamView);
        }

    }//GEN-LAST:event_btnXoaThuocTinhActionPerformed

    private void rdoNhanHieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNhanHieuActionPerformed
        loadThuoctinh();
    }//GEN-LAST:event_rdoNhanHieuActionPerformed

    private void rdoNhomHuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNhomHuongActionPerformed
        loadThuoctinh();
    }//GEN-LAST:event_rdoNhomHuongActionPerformed

    private void rdoXuatXuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoXuatXuActionPerformed
        loadThuoctinh();
    }//GEN-LAST:event_rdoXuatXuActionPerformed

    private void rdoDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoDanhMucActionPerformed
        loadThuoctinh();
    }//GEN-LAST:event_rdoDanhMucActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed


    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPrevMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrevMouseClicked
        _soTrang--;
        int soTrang;
        int soDong = sanPhamService.getSoDong(idDanhMuc, idNhanHieu, idNhomHuong, idXuatXu);
        double page = soDong % 10.0;
        if (page != 0.0) {
            soTrang = soDong / 10;
            soTrang++;
        } else {
            soTrang = soDong / 10;
        }
        if (_soTrang == 0) {
            _soTrang = soTrang;
            _lstSanPhamView = sanPhamService.findSanPham(idDanhMuc, idNhanHieu, idNhomHuong, idXuatXu, getStart(_soTrang), getEnd(_soTrang));
            fillToTableSanPham(_lstSanPhamView);
            lblSoTrang.setText(String.valueOf(_soTrang));
            setCboTimKiemTruocKhiFillLai();
        } else {
            _lstSanPhamView = sanPhamService.findSanPham(idDanhMuc, idNhanHieu, idNhomHuong, idXuatXu, getStart(_soTrang), getEnd(_soTrang));
            fillToTableSanPham(_lstSanPhamView);
            lblSoTrang.setText(String.valueOf(_soTrang));
            setCboTimKiemTruocKhiFillLai();
        }
    }//GEN-LAST:event_btnPrevMouseClicked

    private void btnDauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDauMouseClicked
        _soTrang = 1;
        _lstSanPhamView = sanPhamService.findSanPham(idDanhMuc, idNhanHieu, idNhomHuong, idXuatXu, getStart(_soTrang), getEnd(_soTrang));
        fillToTableSanPham(_lstSanPhamView);
        lblSoTrang.setText(String.valueOf(_soTrang));
        setCboTimKiemTruocKhiFillLai();
    }//GEN-LAST:event_btnDauMouseClicked

    private void btnCuoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCuoiMouseClicked
        int soDong = sanPhamService.getSoDong(idDanhMuc, idNhanHieu, idNhomHuong, idXuatXu);
        double page = soDong % 10.0;
        if (page != 0.0) {
            _soTrang = soDong / 10;
            _soTrang++;
        } else {
            _soTrang = soDong / 10;
        }
        _lstSanPhamView = sanPhamService.findSanPham(idDanhMuc, idNhanHieu, idNhomHuong, idXuatXu, getStart(_soTrang), getEnd(_soTrang));
        fillToTableSanPham(_lstSanPhamView);
        lblSoTrang.setText(String.valueOf(_soTrang));
        setCboTimKiemTruocKhiFillLai();
    }//GEN-LAST:event_btnCuoiMouseClicked

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnPrevMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrevMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrevMouseEntered

    private void btnNextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextMouseClicked
        _soTrang++;
        int soTrang;
        int soDong = sanPhamService.getSoDong(idDanhMuc, idNhanHieu, idNhomHuong, idXuatXu);
        double page = soDong % 10.0;
        if (page != 0.0) {
            soTrang = soDong / 10;
            soTrang++;
        } else {
            soTrang = soDong / 10;
        }
        if (_soTrang > soTrang) {
            _soTrang = 1;
            _lstSanPhamView = sanPhamService.findSanPham(idDanhMuc, idNhanHieu, idNhomHuong, idXuatXu, getStart(_soTrang), getEnd(_soTrang));
            fillToTableSanPham(_lstSanPhamView);
            lblSoTrang.setText(String.valueOf(_soTrang));
            setCboTimKiemTruocKhiFillLai();
        } else {
            _lstSanPhamView = sanPhamService.findSanPham(idDanhMuc, idNhanHieu, idNhomHuong, idXuatXu, getStart(_soTrang), getEnd(_soTrang));
            fillToTableSanPham(_lstSanPhamView);
            lblSoTrang.setText(String.valueOf(_soTrang));
            setCboTimKiemTruocKhiFillLai();
        }
    }//GEN-LAST:event_btnNextMouseClicked

    private void cboTinhTrangThuocTinhPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cboTinhTrangThuocTinhPropertyChange

    }//GEN-LAST:event_cboTinhTrangThuocTinhPropertyChange

    private void cboTinhTrangThuocTinhVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_cboTinhTrangThuocTinhVetoableChange

    }//GEN-LAST:event_cboTinhTrangThuocTinhVetoableChange

    private void cboTinhTrangThuocTinhItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboTinhTrangThuocTinhItemStateChanged
        check = true;
    }//GEN-LAST:event_cboTinhTrangThuocTinhItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel anhSp;
    private javax.swing.JButton btnChonAnh;
    private javax.swing.JButton btnCuoi;
    private javax.swing.JButton btnDau;
    private javax.swing.JButton btnLocSp;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnNhapFile;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnSuaThuocTinh;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemThuocTinh;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoaThuocTinh;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboDanhMuc;
    private javax.swing.JComboBox<String> cboDanhMuc1;
    private javax.swing.JComboBox<String> cboHuong;
    private javax.swing.JComboBox<String> cboNhanHieu;
    private javax.swing.JComboBox<String> cboNhanHieu1;
    private javax.swing.JComboBox<String> cboNhomHuong1;
    private javax.swing.JComboBox<String> cboTinhTrang;
    private javax.swing.JComboBox<String> cboTinhTrangThuocTinh;
    private javax.swing.JComboBox<String> cboXuatXu;
    private javax.swing.JComboBox<String> cboXuatXu1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblGiaGiam;
    private javax.swing.JLabel lblIdSp;
    private javax.swing.JLabel lblIdThuocTinh;
    private javax.swing.JLabel lblNgayThem;
    private javax.swing.JLabel lblSoTrang;
    private javax.swing.JRadioButton rdoDanhMuc;
    private javax.swing.JRadioButton rdoNhanHieu;
    private javax.swing.JRadioButton rdoNhomHuong;
    private javax.swing.JRadioButton rdoXuatXu;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTable tblThuocTinh;
    private javax.swing.JTextField txtChietKhau;
    private javax.swing.JTextField txtDungTich;
    private javax.swing.JTextField txtGiaGoc;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JTextField txtTenSp;
    private javax.swing.JTextField txtTenThuocTinh;
    // End of variables declaration//GEN-END:variables
}
