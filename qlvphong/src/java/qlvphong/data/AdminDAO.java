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
import qlvphong.model.Admin;

/**
 *
 * @author OS
 */
public class AdminDAO extends ConnectionPool{
    public List<Admin> getAll(){
        List<Admin> list = new ArrayList<>();
        String sql = "select * from admin";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                Admin u = new Admin();
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setName(rs.getString("name"));
                u.setEmail(rs.getString("email"));
                list.add(u);
            }
        } catch(SQLException e){  
            System.out.println(e);
        }
        return list;
    }

    public void insertAdmin(String username, String password, String name, String email){
        String sql = "insert into admin values ('" + username + "','" + password + "','" + name + "','" + email+ "')";
        System.out.println(sql);
        try{
            connection.createStatement().executeUpdate(sql);
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public Admin getAdminByID(String username) {
        String sql = "select * from admin where username='" + username + "'";
        System.out.println(sql);
        Admin u = new Admin();
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setName(rs.getString("name"));
                u.setEmail(rs.getString("email"));
            }
        } catch(SQLException e){   
            System.out.println(e);  
        }
        return u;
    }
}
