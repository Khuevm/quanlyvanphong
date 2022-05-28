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
import qlvphong.model.ToaNha;

/**
 *
 * @author OS
 */
public class ToaNhaDAO extends ConnectionPool{
    public List<ToaNha> getAll(){
        List<ToaNha> list = new ArrayList<>();
        String sql = "select * from toanha";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                ToaNha u = new ToaNha();
                u.setMatoanha(rs.getString("matoanha"));
                u.setDientich(rs.getString("dientich"));
                u.setSoluong(Integer.parseInt(rs.getString("soluong")));
                u.setLoai(rs.getString("loai"));
                u.setGhichu(rs.getString("ghichu"));
                list.add(u);
            }
        } catch(SQLException e){  
            System.out.println(e);
        }
        return list;
    }

    public void insert(String matoanha, String dientich, int soluong, String loai, String ghichu){
        String sql = "insert into toanha values ('" + matoanha + "','"  + dientich + "'," 
            + soluong+ ",'" + loai + "','" + ghichu+ "')";
        System.out.println(sql);
        try{
            connection.createStatement().executeUpdate(sql);
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public void delete(String matoanha) {
        String sql = "delete from toanha where matoanha='"+matoanha+"'";
        System.out.println(sql);
        try{
            connection.createStatement().executeUpdate(sql);
        }catch(SQLException e){
            System.out.println(e);
        }
    }

    public void edit(String matoanha, String dientich, int soluong, String loai, String ghichu){
        String sql = "update toanha set matoanha='" + matoanha + "',dientich='" + dientich + "',soluong=" + soluong
                    + ",loai='" + loai+ "',ghichu='" + ghichu+ "' where matoanha='"+matoanha+"'";
        System.out.println(sql);
        try{
            connection.createStatement().executeUpdate(sql);
        }catch(SQLException e){
        }
    }

    public ToaNha getToaNhaByID(String matoanha) {
        String sql = "select * from toanha where matoanha='" + matoanha +"'";
        System.out.println(sql);
        ToaNha u = new ToaNha();
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                u.setMatoanha(rs.getString("matoanha"));
                u.setDientich(rs.getString("dientich"));
                u.setSoluong(Integer.parseInt(rs.getString("soluong")));
                u.setLoai(rs.getString("loai"));
                u.setGhichu(rs.getString("ghichu"));
            }
        } catch(SQLException e){   
            System.out.println(e);  
        }
        return u;
    }
}
