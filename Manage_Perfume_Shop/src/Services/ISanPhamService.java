/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.SanPham;
import Repositories.SanPhamRepo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Duc Toan
 */
public class ISanPhamService implements SanPhamService {

    SanPhamRepo sanPhamRepo = new SanPhamRepo();

    @Override
    public List<String> getDanhMuc() {
        return sanPhamRepo.getDanhMuc();
    }

    @Override
    public List<String> getNhomHuong() {
        return sanPhamRepo.getNhomHuong();
    }

    @Override
    public List<String> getNhanHieu() {
        return sanPhamRepo.getNhanHieu();
    }

    @Override
    public List<String> getXuatXu() {
        return sanPhamRepo.getXuatXu();
    }

    @Override
    public String addSanPham(SanPham sanPham, String danhMuc, String nhomHuong, String nhanHieu, String xuatXu) {
        if (sanPhamRepo.addSanPham(sanPham, danhMuc, nhomHuong, nhanHieu, xuatXu)) {
            return "Thanh cong";
        }
        return "That bai";

    }

    @Override
    public List<SanPham> getSanPham() {
        return sanPhamRepo.getSanPham();
    }

    @Override
    public String updateSanPham(SanPham sanPham, String danhMuc, String nhomHuong, String nhanHieu, String xuatXu) {
        if (sanPhamRepo.updateSanPham(sanPham, danhMuc, nhomHuong, nhanHieu, xuatXu)) {
            return "Thanh cong";
        }
        return "That bai";
    }

    @Override
    public String deleteSanPham(String idSanPham) {
        if (sanPhamRepo.deleteSanPham(idSanPham)) {
            return "Thanh cong";
        }
        return "That bai";
    }

    @Override
    public ArrayList<SanPham> findSanPham(String danhMuc, String nhanHieu, String nhomHuong, String xuatXu) {
        return sanPhamRepo.findSanPham(danhMuc, nhanHieu, nhomHuong, xuatXu);
    }

    @Override
    public String getIDDanhMuc(String tenDanhMuc) {
        return sanPhamRepo.getIDDanhMuc(tenDanhMuc);
    }

    @Override
    public String getIDNhomHuong(String tenNhomHuong) {
        return sanPhamRepo.getIDNhomHuong(tenNhomHuong);
    }

    @Override
    public String getIDNhanHieu(String tenNhanHieu) {
        return sanPhamRepo.getIDNhanHieu(tenNhanHieu);
    }

    @Override
    public String getIDXuatXu(String tenXuatXu) {
        return sanPhamRepo.getIDXuatXu(tenXuatXu);
    }

}
