/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.DanhMuc;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public interface DanhMucService {
    public ArrayList<DanhMuc> getList();
    public String insert(DanhMuc dm);
    public String update(DanhMuc dm);
    public String delete(String id);
    public void updateTrangThai(String idDanhMuc);
    public String checkTrung(String ten);
}
