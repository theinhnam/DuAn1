/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.TaiKhoanViews;
import java.util.ArrayList;

/**
 *
 * @author theinhnam
 */
public interface LoginService {
    ArrayList<TaiKhoanViews> checkLogin(TaiKhoanViews o);
    
    String getIDLoaiNguoiDung();
    
    String getIDByEmail(String email);
    
    public String getQuyenTaiKhoan(String idTaiKhoan);
    
    String getIDNhanVienKho();
}
