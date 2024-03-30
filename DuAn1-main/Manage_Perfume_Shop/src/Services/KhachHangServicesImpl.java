/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.HoaDon;
import DomainModels.KhachHang;
import Repositories.KhachHangRepository;
import ViewModels.HoaDonKhachHangView;
import ViewModels.QLKhachHang;
import java.util.ArrayList;

/**
 *
 * @author theinhnam
 */
public class KhachHangServicesImpl implements KhachHangServices{

    KhachHangRepository khachHangRepo = new KhachHangRepository();
    
//   @Override
//  public ArrayList<QLKhachHang> findAll() {
//      ArrayList<QLKhachHang> listQLKH = new ArrayList<>();
//    ArrayList<KhachHang> listKH = khachHangRepo.findAll();
//       for (KhachHang khachHang : listKH) {
//           QLKhachHang qlkh = new QLKhachHang();
//          qlkh.setHoTen(khachHang.getHoTen());
//          qlkh.setSoDienThoai(khachHang.getSoDienThoai());
//          qlkh.setNgayThem(khachHang.getNgayThem());
//          qlkh.setNgaySua(khachHang.getNgaySua());
//          qlkh.setTrangThai(khachHang.getTrangThai());
//         listQLKH.add(qlkh);
//       }
//      return listQLKH;
//   }

    @Override
    public String save(QLKhachHang qLKhachHang) {
        KhachHang kh = new KhachHang(qLKhachHang.getHoTen(), qLKhachHang.getSoDienThoai(), qLKhachHang.getNgayThem(), qLKhachHang.getNgaySua(), qLKhachHang.getTrangThai());
        if (khachHangRepo.save(kh)) {
            return "Thêm thành công";
        }else{
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(QLKhachHang qLKhachHang) {
        KhachHang kh = new KhachHang(qLKhachHang.getIdKhachHang(), qLKhachHang.getHoTen(), qLKhachHang.getSoDienThoai(), qLKhachHang.getNgayThem(), qLKhachHang.getNgaySua(), qLKhachHang.getTrangThai());
        if (khachHangRepo.update(kh)) {
            return "Cập nhật thành công";
        }else{
            return "Cập nhật thất bại";
        }
    }

    @Override
    public String delete(QLKhachHang qLKhachHang) {
        KhachHang kh = new KhachHang();
        kh.setIdKhachHang(qLKhachHang.getIdKhachHang());
        if (khachHangRepo.delete(kh)) {
            return "Xóa thành công";
        }else{
            return "Xóa thất bại";
        }
    }

    @Override
    public ArrayList<QLKhachHang> search(String name, int start, int end) {
        ArrayList<QLKhachHang> listQLKH = new ArrayList<>();
        ArrayList<KhachHang> listKH = khachHangRepo.search(name,start,end);
        for (KhachHang khachHang : listKH) {
            QLKhachHang qlkh = new QLKhachHang();
            qlkh.setIdKhachHang(khachHang.getIdKhachHang());
            qlkh.setHoTen(khachHang.getHoTen());
            qlkh.setSoDienThoai(khachHang.getSoDienThoai());
            qlkh.setNgayThem(khachHang.getNgayThem());
            qlkh.setNgaySua(khachHang.getNgaySua());
            qlkh.setTrangThai(khachHang.getTrangThai());
            listQLKH.add(qlkh);
        }
        return listQLKH;
    }

    @Override
    public ArrayList<HoaDonKhachHangView> getHoaDonKH(String idKhachHang, int start, int end) {
        ArrayList<HoaDonKhachHangView> listHDKH = new ArrayList<>();
        ArrayList<HoaDon> listHD = khachHangRepo.getHoaDonKH(idKhachHang, start,end);
        for (HoaDon hoaDon : listHD) {
            HoaDonKhachHangView hoaDonKhachHangView = new HoaDonKhachHangView();
            hoaDonKhachHangView.setTenHoaDon(hoaDon.getTenHoaDon());
            hoaDonKhachHangView.setNgayMuaHang(hoaDon.getNgayThem());
            hoaDonKhachHangView.setTongTien(hoaDon.getTongTien());
            hoaDonKhachHangView.setHoTen(khachHangRepo.getHoTenByID(hoaDon.getIdKhachHang()));
            hoaDonKhachHangView.setSoDienThoai(khachHangRepo.getSDTByID(hoaDon.getIdKhachHang()));
            listHDKH.add(hoaDonKhachHangView);
        }
        return listHDKH;
    }

    @Override
    public QLKhachHang updateTTKH(QLKhachHang qlkh) {
        khachHangRepo.updateTTKH(new KhachHang(qlkh.getHoTen(), qlkh.getSoDienThoai(), null, null, 0));
        return qlkh;
    }

    @Override
    public QLKhachHang insertKHNew(QLKhachHang qlkh) {
        khachHangRepo.save(new KhachHang(qlkh.getHoTen(), qlkh.getSoDienThoai(), null, null, qlkh.getTrangThai()));
        return qlkh;
    }

    @Override
    public int getSoDong(String name) {
        return khachHangRepo.getSoDong(name);
    }

    @Override
    public int getSoDongHD(String idKhachHang) {
        return khachHangRepo.getSoDongHD(idKhachHang);
    }

    @Override
    public boolean checkSDTMatch(String soDienThoai) {
        return khachHangRepo.checkSDTMatch(soDienThoai);
    }


    
}
