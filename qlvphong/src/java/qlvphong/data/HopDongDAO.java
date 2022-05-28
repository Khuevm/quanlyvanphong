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
import qlvphong.model.HopDong;

/**
 *
 * @author OS
 */
public class HopDongDAO extends ConnectionPool{
    public List<HopDong> getAll(){
        List<HopDong> list = new ArrayList<>();
        String sql = "select * from hopdong";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                HopDong u = new HopDong();
                u.setMahopdong(rs.getString("mahopdong"));
                u.setMakhach(rs.getString("makhach"));
                u.setMatoanha(rs.getString("matoanha"));
                u.setNgaybd(rs.getString("ngaybd"));
                u.setNgaykt(rs.getString("ngaykt"));
                u.setTrangthai(rs.getString("trangthai"));
                list.add(u);
            }
        } catch(SQLException e){  
            System.out.println(e);
        }
        return list;
    }

    public void insertHopDong(String mahopdong, String makhach, String matoanha, String ngaybd, String ngaykt, String trangthai){
        String sql = "insert into hopdong values ('" + mahopdong + "','" + makhach + "','" + matoanha + "','" + ngaybd + "','" + ngaykt + "','" + trangthai +"')";
        System.out.println(sql);
        try{
            connection.createStatement().executeUpdate(sql);
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public void deleteHopDong(String mahopdong) {
        String sql = "delete from hopdong where mahopdong='"+mahopdong+"'";
        System.out.println(sql);
        try{
            connection.createStatement().executeUpdate(sql);
        }catch(SQLException e){
            System.out.println(e);
        }
    }

    public void editHopDong(String mahopdong, String makhach, String matoanha, String ngaybd, String ngaykt, String trangthai){
        String sql = "update hopdong set mahopdong='" + mahopdong + "',makhach='" + makhach + "',matoanha='" + matoanha+
                "',ngaybd='" + ngaybd + "',ngaykt='" + ngaykt + "',trangthai='" + trangthai + "' where mahopdong='"+mahopdong+"'";
        System.out.println(sql);
        try{
            connection.createStatement().executeUpdate(sql);
        }catch(SQLException e){
        }
    }

    public HopDong getHopDongByID(String mahopdong) {
        String sql = "select * from hopdong where mahopdong='" + mahopdong + "'";
        System.out.println(sql);
        HopDong u = new HopDong();
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                u.setMahopdong(rs.getString("mahopdong"));
                u.setMakhach(rs.getString("makhach"));
                u.setMatoanha(rs.getString("matoanha"));
                u.setNgaybd(rs.getString("ngaybd"));
                u.setNgaykt(rs.getString("ngaykt"));
                u.setTrangthai(rs.getString("trangthai"));
            }
        } catch(SQLException e){   
            System.out.println(e);  
        }
//        System.out.println(u.getMahopdong()); 
        return u;
    }
}
