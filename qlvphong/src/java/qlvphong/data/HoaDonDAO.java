/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlvphong.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import qlvphong.model.HoaDon;

/**
 *
 * @author OS
 */
public class HoaDonDAO extends ConnectionPool {

    public List<HoaDon> getAll() {
        List<HoaDon> list = new ArrayList<>();
        String sql = "select * from hoadon";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                HoaDon u = new HoaDon();
                u.setMahoadon(rs.getString("mahoadon"));
                u.setMahopdong(rs.getString("mahopdong"));
                u.setNgay(rs.getString("ngay"));
                u.setTienphong(Integer.parseInt(rs.getString("tienphong")));
                u.setTiendien(Integer.parseInt(rs.getString("tiendien")));
                u.setTiennuoc(Integer.parseInt(rs.getString("tiennuoc")));
                u.setTienmang(Integer.parseInt(rs.getString("tienmang")));
                u.setTongtien(u.getTiendien()+u.getTienmang()+u.getTiennuoc()+u.getTienphong());
                list.add(u);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void insertHoaDon(String mahoadon, String mahopdong, String ngay, int tienphong, int tiendien, int tiennuoc, int tienmang) {
        String sql = "insert into hoadon values ('" + mahoadon + "','" + mahopdong + "','" + ngay + "'," + tienphong + "," 
                + tiendien + "," + tiennuoc + "," + tienmang + ")";
        System.out.println(sql);
        try {
            connection.createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteHoaDon(String mahoadon) {
        String sql = "delete from hoadon where mahoadon='" + mahoadon + "'";
        System.out.println(sql);
        try {
            connection.createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void editHoaDon(String mahoadon, String mahopdong, String ngay, int tienphong, int tiendien, int tiennuoc, int tienmang) {
        String sql = "update hoadon set mahoadon='" + mahoadon + "',mahopdong='" + mahopdong + "',ngay='" + ngay
                + "',tienphong=" + tienphong + ",tiendien=" + tiendien + ",tiennuoc=" + tiennuoc+ ",tienmang=" + tienmang 
                + " where mahoadon='" + mahoadon + "'";
        System.out.println(sql);
        try {
            connection.createStatement().executeUpdate(sql);
        } catch (SQLException e) {
        }
    }

    public HoaDon getHoaDonByID(String mahoadon) {
        String sql = "select * from hoadon where mahoadon='" + mahoadon + "'";
        System.out.println(sql);
        HoaDon u = new HoaDon();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                u.setMahoadon(rs.getString("mahoadon"));
                u.setMahopdong(rs.getString("mahopdong"));
                u.setNgay(rs.getString("ngay"));
                u.setTienphong(Integer.parseInt(rs.getString("tienphong")));
                u.setTiendien(Integer.parseInt(rs.getString("tiendien")));
                u.setTiennuoc(Integer.parseInt(rs.getString("tiennuoc")));
                u.setTienmang(Integer.parseInt(rs.getString("tienmang")));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return u;
    }
}
