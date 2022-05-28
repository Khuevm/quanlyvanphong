/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlvphong.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qlvphong.data.HopDongDAO;
import qlvphong.model.HopDong;
import java.sql.Date;

/**
 *
 * @author OS
 */
public class HopDongServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // get current action
        String url = "/QLHD.jsp";
        String action = request.getParameter("action");
        if (action.equals("add")) {
            String message1 = "", message2 = "", message3 = "", message4 = "", message5 = "";
            String mahopdong = request.getParameter("mahopdong");
            String makhach = request.getParameter("makhach");
            String matoanha = request.getParameter("matoanha");
            String ngaybd = request.getParameter("ngaybd");
            String ngaykt = request.getParameter("ngaykt");
            String trangthai = "";
            HopDong hopdong = new HopDong(mahopdong, makhach, matoanha, ngaybd, ngaykt, trangthai);
            System.out.println(mahopdong + " " + makhach + " " + matoanha + " " + ngaybd + " " + ngaykt + " " + trangthai);
            //data validation 
            if (mahopdong == "") {
                message1 = "Hay nhap truong nay";
            } else if (makhach == "") {
                message2 = "Hay nhap truong nay";
            } else if (matoanha == "") {
                message3 = "Hay nhap truong nay";
            } else if (ngaybd == "") {
                message4 = "Hay nhap truong nay";
            } else if (ngaykt == "" || Date.valueOf(ngaybd).compareTo(Date.valueOf(ngaykt)) == 1) {
                message5 = "Hay nhap truong nay lon hon ngay bat dau";
            } else if (hopdong.isExist()) {
                message1 = "Ma da ton tai";
            } else {
                hopdong.setTrangthai(trangthai);
                trangthai = hopdong.getTrangthai();
                HopDongDAO c = new HopDongDAO();
                c.insertHopDong(mahopdong, makhach, matoanha, ngaybd, ngaykt, trangthai);
            }
            request.setAttribute("hopdong", hopdong);
            request.setAttribute("message1", message1);
            request.setAttribute("message2", message2);
            request.setAttribute("message3", message3);
            request.setAttribute("message4", message4);
            request.setAttribute("message5", message5);
        } else if (action.equals("getHDbyID")) {
            HopDongDAO c = new HopDongDAO();
            String mahopdong = request.getParameter("mahopdong");
            HopDong hopdong = c.getHopDongByID(mahopdong);
            request.setAttribute("hopdong", hopdong);
        } else if (action.equals("edit")) {
            String message1 = "", message2 = "", message3 = "", message4 = "", message5 = "";
            String mahopdong = request.getParameter("mahopdong");
            String mahopdongcu = request.getParameter("mahopdongcu");
            String makhach = request.getParameter("makhach");
            String matoanha = request.getParameter("matoanha");
            String ngaybd = request.getParameter("ngaybd");
            String ngaykt = request.getParameter("ngaykt");
            String trangthai = "";

            HopDong hopdong = new HopDong(mahopdong, makhach, matoanha, ngaybd, ngaykt, trangthai);
            System.out.println(mahopdong + " " + makhach + " " + matoanha + " " + ngaybd + " " + ngaykt + " " + trangthai + " " + mahopdongcu);
            //data validation 
            if (mahopdong == "") {
                message1 = "Hay nhap truong nay";
            } else if (makhach == "") {
                message2 = "Hay nhap truong nay";
            } else if (matoanha == "") {
                message3 = "Hay nhap truong nay";
            } else if (ngaybd == "") {
                message4 = "Hay nhap truong nay";
            } else if (ngaykt == "") {
                message5 = "Hay nhap truong nay";
            } else if (!mahopdong.equalsIgnoreCase(mahopdongcu)) {
                message1 = "Khong duoc sua";
            } else {
                hopdong.setTrangthai(trangthai);
                trangthai = hopdong.getTrangthai();
                HopDongDAO c = new HopDongDAO();
                c.editHopDong(mahopdong, makhach, matoanha, ngaybd, ngaykt, trangthai);
            }
            request.setAttribute("hopdong", hopdong);
            request.setAttribute("message1", message1);
            request.setAttribute("message2", message2);
            request.setAttribute("message3", message3);
            request.setAttribute("message4", message4);
            request.setAttribute("message5", message5);
        } else if (action.equals("delete")) {
            HopDongDAO c = new HopDongDAO();
            String mahopdong = request.getParameter("mahopdong");
            c.deleteHopDong(mahopdong);
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
