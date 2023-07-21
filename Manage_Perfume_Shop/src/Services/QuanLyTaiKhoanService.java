/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.TaiKhoan;
import ViewModels.TaiKhoanViews;
import java.util.ArrayList;

/**
 *
 * @author theinhnam
 */
public interface QuanLyTaiKhoanService {
    ArrayList<TaiKhoanViews> findAll();
    ArrayList<String> getAllTenLoaiNguoiDung();
    String addTaiKhoan(TaiKhoanViews taiKhoan);
    String updateTaiKhoan(TaiKhoanViews taiKhoan);
    String deleteTaiKhoan(String email);
    String getIDByEmail(String email);
    boolean checkEmailMatch(String email);
    void deleteByEmail(String email);
}
