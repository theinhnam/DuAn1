/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.ThongKeView;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * // * @author DELL
 */
public interface ThongKeService {

    public ArrayList<ThongKeView> getListThongKeSP();

    public BigDecimal getListThongKeDT();

    public BigDecimal getListThongKeDTTheoNgay(String tu, String den);

    public ArrayList<ThongKeView> getListThongKeDTTheoTenSP(String tenSP);

    public ArrayList<ThongKeView> getListThongKeSPTheoTenSP(String tenSP);

    public ArrayList<ThongKeView> getListThongKeSPTheoNgay(String tu, String den);

    public ArrayList<ThongKeView> getAllThongKeNV(String idNhanVien);
    
    public ArrayList<ThongKeView> getAllThongKeNVByDate(String tu, String den,String idNhanVien);
    
    public String getNhanHieuById(String idNhanHieu);
    
    public ArrayList<ThongKeView> getDataBieuDo();
    
    public ArrayList<ThongKeView> getListSoLuongTon();
}
