/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.KhuyenMai;
import Repositories.KhuyenMaiRepositoey;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class KhuyenMaiServiceImpl implements KhuyenMaiService {

    KhuyenMaiRepositoey khuyenMaiRepositoey = new KhuyenMaiRepositoey();

    @Override
    public ArrayList<KhuyenMai> getList() {
        return khuyenMaiRepositoey.getList();
    }

    @Override
    public String insert(KhuyenMai km) {
        if (khuyenMaiRepositoey.insert(km)) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(KhuyenMai km) {
        if (khuyenMaiRepositoey.update(km)) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public String delete(String id) {
        if (khuyenMaiRepositoey.delete(id)) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }

    @Override
    public ArrayList<KhuyenMai> getListConHan() {
        return khuyenMaiRepositoey.getListConHan();
    }

    @Override
    public String updateSoLanApDung(KhuyenMai km) {
        if (khuyenMaiRepositoey.updateSoLanApDung(km)) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public boolean updateTrangThai(KhuyenMai km) {
        if (khuyenMaiRepositoey.updateTrangThai(km)) {
            return true;
        }
        return false;
    }

}
