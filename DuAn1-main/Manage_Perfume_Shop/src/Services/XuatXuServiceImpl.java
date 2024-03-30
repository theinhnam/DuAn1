/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.XuatXu;

import Repositories.XuatXuRepositorys;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class XuatXuServiceImpl implements XuatXuService {

    XuatXuRepositorys xuatXuRepositorys = new XuatXuRepositorys();


    @Override
    public ArrayList<XuatXu> getList() {
        return xuatXuRepositorys.getList();
    }

    @Override
    public String insert(XuatXu xx) {
        if(xuatXuRepositorys.insert(xx)){
            return "Them thanh cong";
        }else{
            return "Them that bai";
        }
    }

    @Override
    public String update(XuatXu xx) {
        if(xuatXuRepositorys.update(xx)){
            return "Sua thanh cong";
        }else{
            return "Sua that bai";
        }
    }

    @Override
    public String delete(String id) {
        if(xuatXuRepositorys.delete(id)){
            return "Xoa thanh cong";
        }else{
            return "Xoa that bai";
        }
    }

    @Override
    public void updateTrangThai(String xuatXu) {
        xuatXuRepositorys.updateTrangThai(xuatXu);
    }

    @Override
    public String checkTrung(String ten) {
        return xuatXuRepositorys.checkTrung(ten);
    }

}
