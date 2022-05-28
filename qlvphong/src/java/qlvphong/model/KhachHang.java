/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlvphong.model;

import java.util.List;
import qlvphong.data.KhachHangDAO;

/**
 *
 * @author OS
 */
public class KhachHang {
    private String makhach;
    private String hoten;
    private String gioitinh;
    private String cmt;
    private String sdt;
    private String nghe;

    public KhachHang() {
    }

    public KhachHang(String makhach, String hoten, String gioitinh, String cmt, String sdt, String nghe) {
        this.makhach = makhach;
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.cmt = cmt;
        this.sdt = sdt;
        this.nghe = nghe;
    }

    public String getMakhach() {
        return makhach;
    }

    public void setMakhach(String makhach) {
        this.makhach = makhach;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getCmt() {
        return cmt;
    }

    public void setCmt(String cmt) {
        this.cmt = cmt;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getNghe() {
        return nghe;
    }

    public void setNghe(String nghe) {
        this.nghe = nghe;
    }

    public boolean isExist() {
        KhachHangDAO u = new KhachHangDAO();
        List<KhachHang> list = u.getAll();
        if (list == null) return false;
        for (int i=0;i<list.size();i++){
            if (list.get(i).getMakhach().equalsIgnoreCase(this.makhach)){
                return true;
            }
        }
        return false;
    }
}
