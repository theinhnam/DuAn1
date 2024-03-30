/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.NhanHieu;

import Repositories.NhanHieuRepositorys;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class NhanHieuServiceImpl implements NhanHieuService{

    NhanHieuRepositorys nhanHieuRepositorys=new NhanHieuRepositorys();
    
    @Override
    public ArrayList<NhanHieu> getList() {
        return nhanHieuRepositorys.getList();
    }

    @Override
    public String insert(NhanHieu nh) {
        if(nhanHieuRepositorys.insert(nh)){
            return "Them thanh cong";
        }else{
            return "Them that bai";
        }
    }

    @Override
    public String update(NhanHieu nh) {
        if(nhanHieuRepositorys.update(nh)){
            return "Sua thanh cong";
        }else{
            return "Sua that bai";
        }
    }

    @Override
    public String delete(String id) {
        if(nhanHieuRepositorys.delete(id)){
            return "Xoa thanh cong";
        }else{
            return "Xoa that bai";
        }
    }

    @Override
    public void updateTrangThai(String nhanHieu) {
        nhanHieuRepositorys.updateTrangThai(nhanHieu);
    }

    @Override
    public String checkTrung(String ten) {
        return nhanHieuRepositorys.checkTrung(ten);
    }
    
}
