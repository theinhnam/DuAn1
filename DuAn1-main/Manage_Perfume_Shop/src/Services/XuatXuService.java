/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.XuatXu;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public interface XuatXuService {
    public ArrayList<XuatXu> getList();
    public String insert(XuatXu xx);
    public String update(XuatXu xx);
    public String delete(String id);
    public void updateTrangThai(String xuatXu);
    public String checkTrung(String ten);
}
