/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controler;

import Views.DatBanHangJpanel;
import Views.KhachHangJPanel;
import Views.KhoHangJPanel;
import Views.QuanLyKhuyenMaiJPanel;
import Views.QuanLyNhatKyHoatDongJPanel;
import Views.QuanLySanPhamJPanel;
import Views.QuanLyTaiKhoanJPanel;
import Views.QuanLyThongKeJPanel;
import Views.ThongKeJPanel;
import Views.TrangChuJPanel;
import bean.DanhMucBean;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author DELL
 */
public class QuanLyChuyenManHinhControler {

    private JPanel root;
    private String kindSelected = "";

    private List<DanhMucBean> lstItem = null;

    public QuanLyChuyenManHinhControler(JPanel jpnRoot) {
        this.root = jpnRoot;
    }

    public void setView(JPanel jpnItem, JLabel jlbItem) {
        kindSelected = "trangChu";
        jpnItem.setBackground(new Color(96, 100, 191));
        jlbItem.setBackground(new Color(96, 100, 191));

        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new TrangChuJPanel());
        root.validate();
        root.repaint();
    }

    public void setEven(List<DanhMucBean> lstItem) {
        this.lstItem = lstItem;

        for (DanhMucBean item : lstItem) {
            item.getJlb().addMouseListener(new labelEven(item.getKind(), item.getJpn(), item.getJlb()));
        }
    }

    class labelEven implements MouseListener {

        private JPanel node;
        private String kind;

        private JPanel jpnItem;
        private JLabel jlbItem;

        public labelEven(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "trangChu":
                    node = new TrangChuJPanel();
                    break;
                case "sanPham":
                    node = new QuanLySanPhamJPanel();
                    break;
                case "khuyenMai":
                    node = new QuanLyKhuyenMaiJPanel();
                    break;
                case "nhatKyHoatDong":
                    node = new QuanLyNhatKyHoatDongJPanel();
                    break;
                case "thongKe":
                    node = new QuanLyThongKeJPanel();
                    break;
                case "taiKhoan":
                    node = new QuanLyTaiKhoanJPanel();
                    break;
                case "khachHang":
                    node = new KhachHangJPanel();
                    break;
                default:
                    node = new TrangChuJPanel();
                    break;
            }

            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackgroud(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(96, 100, 191));
            jlbItem.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(96, 100, 191));
            jlbItem.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!kindSelected.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(76, 175, 80));
                jlbItem.setBackground(new Color(76, 175, 80));
            }
        }

        private void setChangeBackgroud(String kind) {
            for (DanhMucBean item : lstItem) {
                if (item.getKind().equalsIgnoreCase(kind)) {
                    item.getJlb().setBackground(new Color(96, 100, 191));
                    item.getJpn().setBackground(new Color(96, 100, 191));
                } else {
                    item.getJlb().setBackground(new Color(76, 175, 80));
                    item.getJpn().setBackground(new Color(76, 175, 80));
                }
            }
        }

    }

}
