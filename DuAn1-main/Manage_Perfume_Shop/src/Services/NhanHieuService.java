/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.NhanHieu;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public interface NhanHieuService {
    public ArrayList<NhanHieu> getList();
    public String insert(NhanHieu nh);
    public String update(NhanHieu nh);
    public String delete(String id);
    public void updateTrangThai(String nhanHieu);
    public String checkTrung(String ten);
}
