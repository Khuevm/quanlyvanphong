/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlvphong.model;

import java.util.List;
import qlvphong.data.ToaNhaDAO;

/**
 *
 * @author OS
 */
public class ToaNha {
    private String matoanha;
    private int soluong;
    private String dientich, ghichu, loai;

    public ToaNha() {
    }

    public ToaNha(String matoanha, int soluong, String dientich, String loai, String ghichu) {
        this.matoanha = matoanha;
        this.loai = loai;
        this.soluong = soluong;
        this.dientich = dientich;
        this.ghichu = ghichu;
    }

    public String getMatoanha() {
        return matoanha;
    }

    public void setMatoanha(String matoanha) {
        this.matoanha = matoanha;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getDientich() {
        return dientich;
    }

    public void setDientich(String dientich) {
        this.dientich = dientich;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public boolean isExist() {
        ToaNhaDAO u = new ToaNhaDAO();
        List<ToaNha> list = u.getAll();
        if (list == null) return false;
        for (int i=0;i<list.size();i++){
            if (list.get(i).getMatoanha().equalsIgnoreCase(this.matoanha)){
                return true;
            }
        }
        return false;
    }
}
