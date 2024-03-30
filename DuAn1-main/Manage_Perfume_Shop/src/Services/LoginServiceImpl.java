/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.TaiKhoan;
import Repositories.LoginRepositories;
import ViewModels.TaiKhoanViews;
import java.util.ArrayList;

/**
 *
 * @author theinhnam
 */
public class LoginServiceImpl implements LoginService{
    
    LoginRepositories loginRepo = new LoginRepositories();
    
    @Override
    public ArrayList<TaiKhoanViews> checkLogin(TaiKhoanViews o) {
        TaiKhoan taiKhoan = new TaiKhoan();
        taiKhoan.setEmail(o.getEmail());
        taiKhoan.setMatKhau(o.getMatKhau());
        ArrayList<TaiKhoan> listAccount = loginRepo.checkLogin(taiKhoan);
        ArrayList<TaiKhoanViews> listAccountViews = new ArrayList<>();
        for (TaiKhoan list : listAccount) {
            TaiKhoanViews taiKhoanViews = new TaiKhoanViews(list.getHoTen(), list.getIdLoaiNguoiDung());
            listAccountViews.add(taiKhoanViews);
        }
        return listAccountViews;
    }

    @Override
    public String getIDLoaiNguoiDung() {
        return loginRepo.getIDLoaiNguoiDung();
    }

    @Override
    public String getIDByEmail(String email) {
        return loginRepo.getIDByEmail(email);
    }

    @Override
    public String getQuyenTaiKhoan(String idTaiKhoan) {
        return loginRepo.getQuyenTaiKhoan(idTaiKhoan);
    }

    @Override
    public String getIDNhanVienKho() {
        return loginRepo.getIDNhanVienKho();
    }
    
}
