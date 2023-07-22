/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.KhuyenMai;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public interface KhuyenMaiService {
    public ArrayList<KhuyenMai> getList();
    public ArrayList<KhuyenMai> getListConHan();
    public String insert(KhuyenMai km);
    public String update(KhuyenMai km);
    public String updateSoLanApDung(KhuyenMai km);
    public boolean updateTrangThai(KhuyenMai km);
    public String delete(String id);
}
