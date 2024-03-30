/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.HoaDonKhuyenMaiView;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public interface HoaDonKhuyenMaiViewService {
    public ArrayList<HoaDonKhuyenMaiView> getList(String idHoaDon);
}
