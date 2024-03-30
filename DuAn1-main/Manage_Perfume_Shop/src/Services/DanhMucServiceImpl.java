/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.DanhMuc;

import Repositories.DanhMucRepositorys;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class DanhMucServiceImpl implements DanhMucService{

    DanhMucRepositorys danhMucRepositorys=new DanhMucRepositorys();
    
    @Override
    public ArrayList<DanhMuc> getList() {
        return danhMucRepositorys.getList();
    }

    @Override
    public String insert(DanhMuc dm) {
        if(danhMucRepositorys.insert(dm)){
            return "Them thanh cong";
        }else{
            return "Them that bai";
        }
    }

    @Override
    public String update(DanhMuc dm) {
        if(danhMucRepositorys.update(dm)){
            return "Sua thanh cong";
        }else{
            return "Sua that bai";
        }
    }

    @Override
    public String delete(String id) {
        if(danhMucRepositorys.delete(id)){
            return "Xoa thanh cong";
        }else{
            return "Xoa that bai";
        }
    }

    @Override
    public void updateTrangThai(String idDanhMuc) {
        danhMucRepositorys.updateTrangThai(idDanhMuc);
    }

    @Override
    public String checkTrung(String ten) {
        return danhMucRepositorys.checkTrung(ten);
    }
    
}
