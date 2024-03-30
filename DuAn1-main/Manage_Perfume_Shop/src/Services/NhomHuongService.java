/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.NhomHuong;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public interface NhomHuongService {
    public ArrayList<NhomHuong> getList();
    public String insert(NhomHuong nh);
    public String update(NhomHuong nh);
    public String delete(String id);
    public String getIDByName(String nhomHuong);
    public void updateTrangThai(String idNhomHuong);
    public String checkTrung(String ten);
}
