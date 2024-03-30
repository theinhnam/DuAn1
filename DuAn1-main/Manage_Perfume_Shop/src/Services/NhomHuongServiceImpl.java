/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.NhomHuong;

import Repositories.NhomHuongRepositorys;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class NhomHuongServiceImpl implements NhomHuongService {

    NhomHuongRepositorys nhomHuongRepositorys = new NhomHuongRepositorys();

    @Override
    public ArrayList<NhomHuong> getList() {
        return nhomHuongRepositorys.getList();
    }

    @Override
    public String insert(NhomHuong nh) {
        if (nhomHuongRepositorys.insert(nh)) {
            return "Them thanh cong";
        } else {
            return "Them that bai";
        }
    }

    @Override
    public String update(NhomHuong nh) {
        if (nhomHuongRepositorys.update(nh)) {
            return "Sua thanh cong";
        } else {
            return "Sua that bai";
        }
    }

    @Override
    public String delete(String id) {
        if (nhomHuongRepositorys.delete(id)) {
            return "Xoa thanh cong";
        } else {
            return "Xoa that bai";
        }
    }

    @Override
    public String getIDByName(String nhomHuong) {
        return nhomHuongRepositorys.getIDByName(nhomHuong);
    }

    @Override
    public void updateTrangThai(String idNhomHuong) {
        nhomHuongRepositorys.updateTrangThai(idNhomHuong);
    }

    @Override
    public String checkTrung(String ten) {
        return nhomHuongRepositorys.checkTrung(ten);
    }

}
