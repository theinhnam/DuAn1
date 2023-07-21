/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.HoaDonKhuyenMai;
import Repositories.HoaDonKhuyenMaiRepository;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class HoaDonKhuyenMaiServiceImpl implements HoaDonKhuyenMaiService{

    HoaDonKhuyenMaiRepository hoaDonKhuyenMaiRepository=new HoaDonKhuyenMaiRepository();
    
    @Override
    public ArrayList<HoaDonKhuyenMai> getList() {
        return hoaDonKhuyenMaiRepository.getList();
    }

    @Override
    public String insert(HoaDonKhuyenMai hdkm) {
        if(hoaDonKhuyenMaiRepository.insert(hdkm)){
            return "thanh cong";
        }else{
            return "that bai";
        }
    }

    @Override
    public String delete(HoaDonKhuyenMai hdkm) {
        if(hoaDonKhuyenMaiRepository.delete(hdkm)){
            return "thanh cong";
        }else{
            return "that bai";
        }
    }
    
}
