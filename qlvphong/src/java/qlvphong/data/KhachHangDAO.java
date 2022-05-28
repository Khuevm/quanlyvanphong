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
import qlvphong.model.KhachHang;

/**
 *
 * @author OS
 */
public class KhachHangDAO extends ConnectionPool{
    public List<KhachHang> getAll(){
        List<KhachHang> list = new ArrayList<>();
        String sql = "select * from khachhang";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                KhachHang u = new KhachHang();
                u.setMakhach(rs.getString("makhach"));
                u.setHoten(rs.getString("hoten"));
                u.setGioitinh(rs.getString("gioitinh"));
                u.setCmt(rs.getString("cmt"));
                u.setSdt(rs.getString("sdt"));
                u.setNghe(rs.getString("nghe"));
                list.add(u);
            }
        } catch(SQLException e){  
            System.out.println(e);
        }
        return list;
    }

    public void insertKhachHang(String makhach, String hoten, String gioitinh, String cmt, String sdt, String nghe){
        String sql = "insert into khachhang values ('" + makhach + "','" + hoten + "','" + gioitinh + "','" + cmt + "','" + sdt + "','" + nghe + "')";
        System.out.println(sql);
        try{
            connection.createStatement().executeUpdate(sql);
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public void deleteKhachHang(String makhach) {
        String sql = "delete from khachhang where makhach='"+makhach+"'";
        System.out.println(sql);
        try{
            connection.createStatement().executeUpdate(sql);
        }catch(SQLException e){
            System.out.println(e);
        }
    }

    public void editKhachHang(String makhach, String hoten, String gioitinh, String cmt, String sdt, String nghe){
        String sql = "update khachhang set makhach='" + makhach + "',hoten='" + hoten + "',gioitinh='" + gioitinh + "',cmt='" + cmt +
                "',sdt='" + sdt + "',nghe='" + nghe + "' where makhach='"+makhach+"'";
        System.out.println(sql);
        try{
            connection.createStatement().executeUpdate(sql);
        }catch(SQLException e){
        }
    }

    public KhachHang getKhachHangByID(String makhach) {
        String sql = "select * from khachhang where makhach='" + makhach + "'";
        System.out.println(sql);
        KhachHang u = new KhachHang();
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                u.setMakhach(rs.getString("makhach"));
                u.setHoten(rs.getString("hoten"));
                u.setGioitinh(rs.getString("gioitinh"));
                u.setCmt(rs.getString("cmt"));
                u.setSdt(rs.getString("sdt"));
                u.setNghe(rs.getString("nghe"));
            }
        } catch(SQLException e){   
            System.out.println(e);  
        }
        return u;
    }

    public static void main(String[] args) {
        KhachHangDAO ed = new KhachHangDAO();
        List<KhachHang> list = ed.getAll();
        System.out.println(list.get(0).getHoten());
    }
}
