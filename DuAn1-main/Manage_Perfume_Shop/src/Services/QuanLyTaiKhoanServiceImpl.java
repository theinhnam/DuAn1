/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.TaiKhoan;
import Repositories.QuanLyTaiKhoanRepositoriy;
import Ultilities.DBConnection;
import ViewModels.TaiKhoanViews;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 *
 * @author theinhnam
 */
public class QuanLyTaiKhoanServiceImpl implements QuanLyTaiKhoanService {

    QuanLyTaiKhoanRepositoriy quanLyTaiKhoanRepo = new QuanLyTaiKhoanRepositoriy();

    @Override
    public ArrayList<TaiKhoanViews> findAll() {
        ArrayList<TaiKhoan> listTaiKhoan = quanLyTaiKhoanRepo.findAll();
        ArrayList<TaiKhoanViews> listTaiKhoanView = new ArrayList<>();
        for (TaiKhoan taiKhoan : listTaiKhoan) {
            TaiKhoanViews taiKhoanViews = new TaiKhoanViews(taiKhoan.getIdTaiKhoan(),taiKhoan.getEmail(), taiKhoan.getMatKhau(), taiKhoan.getHoTen(), quanLyTaiKhoanRepo.getTenLoaiNguoiDung(taiKhoan.getIdLoaiNguoiDung()), taiKhoan.getNgayThem(), taiKhoan.getNgaySua(), taiKhoan.getTrangThai());
            listTaiKhoanView.add(taiKhoanViews);
        }
        return listTaiKhoanView;
    }

    @Override
    public ArrayList<String> getAllTenLoaiNguoiDung() {
        return quanLyTaiKhoanRepo.getAllLoaiNguoiDung();
    }

    @Override
    public String addTaiKhoan(TaiKhoanViews taiKhoan) {
        TaiKhoan tk = new TaiKhoan(quanLyTaiKhoanRepo.getIDLoaiNguoiDung(taiKhoan.getTenLoaiNguoiDung()), taiKhoan.getEmail(), taiKhoan.getMatKhau(), taiKhoan.getHoTen(), taiKhoan.getTinhTrang());
        return quanLyTaiKhoanRepo.addTaiKhoan(tk) == true?"Thêm thành công":"Thêm không thành công";
    }

    @Override
    public String updateTaiKhoan(TaiKhoanViews taiKhoan) {
        TaiKhoan tk = new TaiKhoan(taiKhoan.getIdTaiKhoan(),quanLyTaiKhoanRepo.getIDLoaiNguoiDung(taiKhoan.getTenLoaiNguoiDung()), taiKhoan.getEmail(), taiKhoan.getMatKhau(), taiKhoan.getHoTen(), taiKhoan.getTinhTrang());
        return quanLyTaiKhoanRepo.updateTaiKhoan(tk) == true?"Cập nhật thành công":"Cập nhật không thành công";
    }

    @Override
    public String deleteTaiKhoan(String idTaiKhoan) {
        return quanLyTaiKhoanRepo.deleteTaiKhoan(idTaiKhoan) == true ? "Xóa thành công":"Xóa thất bại";
    }

    @Override
    public String getIDByEmail(String email) {
        return quanLyTaiKhoanRepo.getIDByEmail(email);
    }

    @Override
    public boolean checkEmailMatch(String email) {
        if (quanLyTaiKhoanRepo.checkEmailMatch(email)) {
            return true;
        }
        return false;
    }

    @Override
    public void deleteByEmail(String email) {
        quanLyTaiKhoanRepo.deleteByEmail(email);
    }

}
