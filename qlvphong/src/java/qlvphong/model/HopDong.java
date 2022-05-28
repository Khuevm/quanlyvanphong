/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlvphong.model;

import java.util.List;
import qlvphong.data.HopDongDAO;
import java.sql.Date;
/**
 *
 * @author OS
 */
public class HopDong {

    private String mahopdong;
    private String makhach;
    private String matoanha;
    private String ngaybd;
    private String ngaykt;
    private String trangthai;

    public HopDong() {
    }

    public String getMahopdong() {
        return mahopdong;
    }

    public void setMahopdong(String mahopdong) {
        this.mahopdong = mahopdong;
    }

    public String getMakhach() {
        return makhach;
    }

    public void setMakhach(String makhach) {
        this.makhach = makhach;
    }

    public String getMatoanha() {
        return matoanha;
    }

    public void setMatoanha(String matoanha) {
        this.matoanha = matoanha;
    }

    public String getNgaybd() {
        return ngaybd;
    }

    public void setNgaybd(String ngaybd) {
        this.ngaybd = ngaybd;
    }

    public String getNgaykt() {
        return ngaykt;
    }

    public void setNgaykt(String ngaykt) {
        this.ngaykt = ngaykt;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        if (date.compareTo(Date.valueOf(this.ngaykt)) == 1) {
            this.trangthai = "Het thoi han";
        } else {
            this.trangthai = "Con thoi han";
        }
    }

    public HopDong(String mahopdong, String makhach, String matoanha, String ngaybd, String ngaykt, String trangthai) {
        this.mahopdong = mahopdong;
        this.makhach = makhach;
        this.matoanha = matoanha;
        this.ngaybd = ngaybd;
        this.ngaykt = ngaykt;
        this.trangthai = trangthai;
    }

    public boolean isExist() {
        HopDongDAO u = new HopDongDAO();
        List<HopDong> list = u.getAll();
        if (list == null) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMahopdong().equalsIgnoreCase(this.mahopdong)) {
                return true;
            }
        }
        return false;
    }
}
