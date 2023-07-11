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
    public String checkLogin(TaiKhoanViews o) {
        TaiKhoan taiKhoan = new TaiKhoan();
        taiKhoan.setEmail(o.getEmail());
        taiKhoan.setMatKhau(o.getMatKhau());
        ArrayList<TaiKhoan> listAccount = loginRepo.checkLogin(taiKhoan);
        if (listAccount == null) {
            return null;
        }
        String tenLoaiNguoiDung = loginRepo.getLoaiNguoiDung(listAccount.get(0).getIdLoaiNguoiDung());
        return tenLoaiNguoiDung;  
    }
    
}
