/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Repositories.HoaDonKhuyenMaiViewRepository;
import ViewModels.HoaDonKhuyenMaiView;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class HoaDonKhuyenMaiViewServiceImpl implements HoaDonKhuyenMaiViewService{

    HoaDonKhuyenMaiViewRepository hoaDonKhuyenMaiViewRepository=new HoaDonKhuyenMaiViewRepository();
    
    @Override
    public ArrayList<HoaDonKhuyenMaiView> getList(String idHoaDon) {
         return hoaDonKhuyenMaiViewRepository.getList(idHoaDon);
    }
    
}
