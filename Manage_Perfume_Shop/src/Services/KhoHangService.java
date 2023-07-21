/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.SanPham;
import ViewModels.NhapSanPhamView;
import ViewModels.SanPhamView;
import java.util.List;

/**
 *
 * @author Duc Toan
 */
public interface KhoHangService {
    public List<SanPhamView> getSp ();
    public String nhap (NhapSanPhamView nhapSanPhamView);
    public String xuat (NhapSanPhamView nhapSanPhamView);
    public  List<SanPhamView> findSp (String tenSp);
}
