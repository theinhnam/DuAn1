/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Repositories.ThongKeRepository;
import ViewModels.ThongKeView;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class ThongKeServiceImpl implements ThongKeService{

    ThongKeRepository thongKeRepository=new ThongKeRepository();
    
    @Override
    public ArrayList<ThongKeView> getListThongKeSP() {
        return thongKeRepository.getListThongKeSP();
    }

    @Override
    public BigDecimal getListThongKeDT() {
        return thongKeRepository.getListThongKeDT();
    }

    @Override
    public BigDecimal getListThongKeDTTheoNgay(String tu, String den) {
        return thongKeRepository.getListThongKeDTTheoNgay(tu, den);
    }

    @Override
    public ArrayList<ThongKeView> getListThongKeDTTheoTenSP(String tenSP) {
        return thongKeRepository.getListThongKeDTTheoTenSP(tenSP);
    }

    @Override
    public ArrayList<ThongKeView> getListThongKeSPTheoTenSP(String tenSP) {
         return thongKeRepository.getListThongKeSPTheoTenSP(tenSP);
    }

    @Override
    public ArrayList<ThongKeView> getListThongKeSPTheoNgay(String tu, String den) {
        return thongKeRepository.getListThongKeSPTheoNgay(tu, den);
    }

    @Override
    public ArrayList<ThongKeView> getAllThongKeNV(String idNhanVien) {
        return thongKeRepository.getAllThongKeNV(idNhanVien);
    }

    @Override
    public ArrayList<ThongKeView> getAllThongKeNVByDate(String tu, String den,String idNhanVien) {
        return thongKeRepository.getAllThongKeNVByDate(tu, den,idNhanVien);
    }

    @Override
    public String getNhanHieuById(String idNhanHieu) {
        return thongKeRepository.getNhanHieuById(idNhanHieu);
    }

    @Override
    public ArrayList<ThongKeView> getDataBieuDo() {
        return thongKeRepository.getDataBieuDo();
    }

    @Override
    public ArrayList<ThongKeView> getListSoLuongTon() {
        return thongKeRepository.getListSoLuongTon();
    }


    
}
