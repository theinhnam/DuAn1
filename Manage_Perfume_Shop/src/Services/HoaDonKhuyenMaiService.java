/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.HoaDonKhuyenMai;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public interface HoaDonKhuyenMaiService {
    public ArrayList<HoaDonKhuyenMai> getList();
    public String insert(HoaDonKhuyenMai hdkm);
    public String delete(HoaDonKhuyenMai hdkm);
}
