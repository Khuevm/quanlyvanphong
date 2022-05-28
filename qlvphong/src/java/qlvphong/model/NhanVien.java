/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlvphong.model;

import java.util.List;
import qlvphong.data.NhanVienDAO;

/**
 *
 * @author OS
 */
public class NhanVien {
    private String manv;
    private String hoten;
    private String gioitinh;
    private String ngaysinh;
    private String sdt;
    private String chucvu;
    private int luong;

    public NhanVien() {
    }

    public NhanVien(String manv, String hoten, String gioitinh, String ngaysinh, String sdt, String chucvu, int luong) {
        this.manv = manv;
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.ngaysinh = ngaysinh;
        this.sdt = sdt;
        this.chucvu = chucvu;
        this.luong = luong;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
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

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }

    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }

    public boolean isExist() {
        NhanVienDAO u = new NhanVienDAO();
        List<NhanVien> list = u.getAll();
        if (list == null) return false;
        for (int i=0;i<list.size();i++){
            if (list.get(i).getManv().equalsIgnoreCase(this.manv)){
                return true;
            }
        }
        return false;
    }
}
