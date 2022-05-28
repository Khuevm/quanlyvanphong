/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlvphong.model;

import java.util.List;
import qlvphong.data.HoaDonDAO;

/**
 *
 * @author OS
 */
public class HoaDon {

    private String mahoadon;
    private String mahopdong;
    private String ngay;
    private int tienmang, tiendien, tiennuoc, tienphong, tongtien;

    public HoaDon() {
    }

    public HoaDon(String mahoadon, String mahopdong, String ngay, int tienphong, int tiendien, int tiennuoc, int tienmang) {
        this.mahoadon = mahoadon;
        this.mahopdong = mahopdong;
        this.ngay = ngay;
        this.tienmang = tienmang;
        this.tiendien = tiendien;
        this.tiennuoc = tiennuoc;
        this.tienphong = tienphong;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    public String getMahoadon() {
        return mahoadon;
    }

    public void setMahoadon(String mahoadon) {
        this.mahoadon = mahoadon;
    }

    public String getMahopdong() {
        return mahopdong;
    }

    public void setMahopdong(String mahopdong) {
        this.mahopdong = mahopdong;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public int getTienmang() {
        return tienmang;
    }

    public void setTienmang(int tienmang) {
        this.tienmang = tienmang;
    }

    public int getTiendien() {
        return tiendien;
    }

    public void setTiendien(int tiendien) {
        this.tiendien = tiendien;
    }

    public int getTiennuoc() {
        return tiennuoc;
    }

    public void setTiennuoc(int tiennuoc) {
        this.tiennuoc = tiennuoc;
    }

    public int getTienphong() {
        return tienphong;
    }

    public void setTienphong(int tienphong) {
        this.tienphong = tienphong;
    }

    public boolean isExist() {
        HoaDonDAO u = new HoaDonDAO();
        List<HoaDon> list = u.getAll();
        if (list == null) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMahoadon().equalsIgnoreCase(this.mahoadon)) {
                return true;
            }
        }
        return false;
    }
}
