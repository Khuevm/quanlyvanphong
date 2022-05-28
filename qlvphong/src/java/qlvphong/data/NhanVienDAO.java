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
import qlvphong.model.NhanVien;

/**
 *
 * @author OS
 */
public class NhanVienDAO extends ConnectionPool{
    public List<NhanVien> getAll(){
        List<NhanVien> list = new ArrayList<>();
        String sql = "select * from nhanvien";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                NhanVien u = new NhanVien();
                u.setManv(rs.getString("manv"));
                u.setHoten(rs.getString("hoten"));
                u.setGioitinh(rs.getString("gioitinh"));
                u.setNgaysinh(rs.getString("ngaysinh"));
                u.setSdt(rs.getString("sdt"));
                u.setChucvu(rs.getString("chucvu"));
                u.setLuong(Integer.parseInt(rs.getString("luong")));
                list.add(u);
            }
        } catch(SQLException e){  
            System.out.println(e);
        }
        return list;
    }

    public void insertNhanvien(String manv, String hoten, String gioitinh, String ngaysinh, String sdt, String chucvu, int luong){
        String sql = "insert into nhanvien values ('" + manv + "','" + hoten + "','" + gioitinh + "','" + ngaysinh + "','" + sdt + "','" + chucvu + "'," + luong + ")";
        System.out.println(sql);
        try{
            connection.createStatement().executeUpdate(sql);
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public void deleteNhanVien(String manv) {
        String sql = "delete from nhanvien where manv='"+manv+"'";
        System.out.println(sql);
        try{
            connection.createStatement().executeUpdate(sql);
        }catch(SQLException e){
            System.out.println(e);
        }
    }

    public void editNhanvien(String manv, String hoten, String gioitinh, String ngaysinh, String sdt, String chucvu, int luong){
        String sql = "update nhanvien set manv='" + manv + "',hoten='" + hoten + "',gioitinh='" + gioitinh + "',ngaysinh='" + ngaysinh +
                "',sdt='" + sdt + "',chucvu='" + chucvu + "',luong=" + luong + " where manv='"+manv+"'";
        System.out.println(sql);
        try{
            connection.createStatement().executeUpdate(sql);
        }catch(SQLException e){
        }
    }

    public NhanVien getNhanvienByID(String manv) {
        String sql = "select * from nhanvien where manv='" + manv + "'";
        System.out.println(sql);
        NhanVien u = new NhanVien();
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                u.setManv(rs.getString("manv"));
                u.setHoten(rs.getString("hoten"));
                u.setGioitinh(rs.getString("gioitinh"));
                u.setNgaysinh(rs.getString("ngaysinh"));
                u.setSdt(rs.getString("sdt"));
                u.setChucvu(rs.getString("chucvu"));
                u.setLuong(Integer.parseInt(rs.getString("luong")));
            }
        } catch(SQLException e){   
            System.out.println(e);  
        }
        return u;
    }
}
