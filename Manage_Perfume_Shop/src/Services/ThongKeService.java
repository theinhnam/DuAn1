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

    public BigDecimal getListThongKeDTTheoNgay(Date tu, Date den);

    public ArrayList<ThongKeView> getListThongKeDTTheoTenSP(String tenSP);

    public ArrayList<ThongKeView> getListThongKeSPTheoTenSP(String tenSP);

    public ArrayList<ThongKeView> getListThongKeSPTheoNgay(Date tu, Date den);
}
