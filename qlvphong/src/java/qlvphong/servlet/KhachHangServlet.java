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

import qlvphong.data.KhachHangDAO;
import qlvphong.model.KhachHang;

/**
 *
 * @author OS
 */
public class KhachHangServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // get current action
        String url = "/QLKH.jsp";
        String action = request.getParameter("action");
        if (action.equals("add")) {
            String message1 = "", message2 = "", message3 = "", message4 = "", message5 = "", message6 = "";
            String makhach = request.getParameter("makhach");
            String hoten = request.getParameter("hoten");
            String gioitinh = request.getParameter("gioitinh");
            String cmt = request.getParameter("cmt");
            String sdt = request.getParameter("sdt");
            String nghe = request.getParameter("nghe");
            
            KhachHang khachhang = new KhachHang(makhach, hoten, gioitinh, cmt, sdt, nghe);
            System.out.println(makhach +" "+ hoten +" "+ gioitinh +" "+ cmt +" "+ sdt +" "+ nghe);
            //data validation 
            if (makhach == "") {
                message1 = "Hay nhap truong nay";
            } else if (hoten == "") {
                message2 = "Hay nhap truong nay";
            } else if (gioitinh == "") {
                message3 = "Hay nhap truong nay";
            } else if (cmt == "") {
                message4 = "Hay nhap truong nay";
            } else if (sdt == "") {
                message5 = "Hay nhap truong nay";
            } else if (nghe == "") {
                message6 = "Hay nhap truong nay";
            } else if (khachhang.isExist()) {
                message1 = "Ma da ton tai";
            } else {
                KhachHangDAO c = new KhachHangDAO();
                c.insertKhachHang(makhach, hoten, gioitinh, cmt, sdt, nghe);
            }

            request.setAttribute("khachhang", khachhang);
            request.setAttribute("message1", message1);
            request.setAttribute("message2", message2);
            request.setAttribute("message3", message3);
            request.setAttribute("message4", message4);
            request.setAttribute("message5", message5);
            request.setAttribute("message6", message6);
        } else if (action.equals("getKHbyID")) {
            KhachHangDAO c = new KhachHangDAO();
            String makhach = request.getParameter("makhach");
            KhachHang khachhang = c.getKhachHangByID(makhach);
            request.setAttribute("khachhang", khachhang);
            System.out.println(khachhang.getMakhach()+ " " + makhach);
        } else if (action.equals("edit")) {
            String message1 = "", message2 = "", message3 = "", message4 = "", message5 = "", message6 = "";
            String makhach = request.getParameter("makhach");
            String makhachcu = request.getParameter("makhachcu");
            String hoten = request.getParameter("hoten");
            String gioitinh = request.getParameter("gioitinh");
            String cmt = request.getParameter("cmt");
            String sdt = request.getParameter("sdt");
            String nghe = request.getParameter("nghe");
            
            KhachHang khachhang = new KhachHang(makhach, hoten, gioitinh, cmt, sdt, nghe);
            System.out.println(makhach +" "+ hoten +" "+ gioitinh +" "+ cmt +" "+ sdt +" "+ nghe + " "+makhachcu);
            //data validation 
            if (makhach == "") {
                message1 = "Hay nhap truong nay";
            } else if (hoten == "") {
                message2 = "Hay nhap truong nay";
            } else if (gioitinh == "") {
                message3 = "Hay nhap truong nay";
            } else if (cmt == "") {
                message4 = "Hay nhap truong nay";
            } else if (sdt == "") {
                message5 = "Hay nhap truong nay";
            } else if (nghe == "") {
                message6 = "Hay nhap truong nay";
            } else if (!makhach.equalsIgnoreCase(makhachcu)) {
                message1 = "Khong duoc sua";
            } else {
                KhachHangDAO c = new KhachHangDAO();
                c.editKhachHang(makhach, hoten, gioitinh, cmt, sdt, nghe);
            }
            request.setAttribute("khachhang", khachhang);
            request.setAttribute("message1", message1);
            request.setAttribute("message2", message2);
            request.setAttribute("message3", message3);
            request.setAttribute("message4", message4);
            request.setAttribute("message5", message5);
            request.setAttribute("message6", message6);
        } else if (action.equals("delete")) {
            KhachHangDAO c = new KhachHangDAO();
            String makhach = request.getParameter("makhach");
            c.deleteKhachHang(makhach);
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
