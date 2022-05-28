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

import qlvphong.data.NhanVienDAO;
import qlvphong.model.NhanVien;

/**
 *
 * @author OS
 */
public class NhanVienServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // get current action
        String url = "/QLNV.jsp";
        String action = request.getParameter("action");
        if (action.equals("add")) {
            String message1 = "", message2 = "", message3 = "", message4 = "", message5 = "", message6 = "", message7 = "";
            String manv = request.getParameter("manv");
            String hoten = request.getParameter("hoten");
            String gioitinh = request.getParameter("gioitinh");
            String ngaysinh = request.getParameter("ngaysinh");
            String sdt = request.getParameter("sdt");
            String chucvu = request.getParameter("chucvu");
            int luong = 0;
            try {
                luong = Integer.parseInt(request.getParameter("luong"));
            } catch (NumberFormatException e) {
            }
            NhanVien nhanvien = new NhanVien(manv, hoten, gioitinh, ngaysinh, sdt, chucvu, luong);
            System.out.println(manv +" "+ hoten +" "+ gioitinh +" "+ ngaysinh +" "+ sdt +" "+ chucvu +" "+ luong);
            //data validation 
            if (manv == "") {
                message1 = "Hay nhap truong nay";
            } else if (hoten == "") {
                message2 = "Hay nhap truong nay";
            } else if (gioitinh == "") {
                message3 = "Hay nhap truong nay";
            } else if (ngaysinh == "") {
                message4 = "Hay nhap truong nay";
            } else if (sdt == "") {
                message5 = "Hay nhap truong nay";
            } else if (chucvu == "") {
                message6 = "Hay nhap truong nay";
            } else if (luong <= 0) {
                message7 = "Hay nhap truong nay la so nguyen";
            } else if (nhanvien.isExist()) {
                message1 = "Ma da ton tai";
            } else {
                NhanVienDAO c = new NhanVienDAO();
                c.insertNhanvien(manv, hoten, gioitinh, ngaysinh, sdt, chucvu, luong);
            }

            request.setAttribute("nhanvien", nhanvien);
            request.setAttribute("message1", message1);
            request.setAttribute("message2", message2);
            request.setAttribute("message3", message3);
            request.setAttribute("message4", message4);
            request.setAttribute("message5", message5);
            request.setAttribute("message6", message6);
            request.setAttribute("message7", message7);
        } else if (action.equals("getNVbyID")) {
            NhanVienDAO c = new NhanVienDAO();
            String manv = request.getParameter("manv");
            NhanVien nhanvien = c.getNhanvienByID(manv);
            request.setAttribute("nhanvien", nhanvien);
            System.out.println(nhanvien.getManv() + " " + manv);
        } else if (action.equals("edit")) {
            String message1 = "", message2 = "", message3 = "", message4 = "", message5 = "", message6 = "", message7 = "";
            String manv = request.getParameter("manv");
            String manvcu = request.getParameter("manvcu");
            String hoten = request.getParameter("hoten");
            String gioitinh = request.getParameter("gioitinh");
            String ngaysinh = request.getParameter("ngaysinh");
            String sdt = request.getParameter("sdt");
            String chucvu = request.getParameter("chucvu");
            int luong = 0;
            try {
                luong = Integer.parseInt(request.getParameter("luong"));
            } catch (NumberFormatException e) {
            }
            NhanVien nhanvien = new NhanVien(manvcu, hoten, gioitinh, ngaysinh, sdt, chucvu, luong);
            System.out.println(manv +" "+ hoten +" "+ gioitinh +" "+ ngaysinh +" "+ sdt +" "+ chucvu +" "+ luong+" "+manvcu);
            //data validation 
            if (manv == "") {
                message1 = "Hay nhap truong nay";
            } else if (hoten == "") {
                message2 = "Hay nhap truong nay";
            } else if (gioitinh == "") {
                message3 = "Hay nhap truong nay";
            } else if (ngaysinh == "") {
                message4 = "Hay nhap truong nay";
            } else if (sdt == "") {
                message5 = "Hay nhap truong nay";
            } else if (chucvu == "") {
                message6 = "Hay nhap truong nay";
            } else if (luong <= 0) {
                message7 = "Hay nhap truong nay la so nguyen";
            } else if (!manv.equalsIgnoreCase(manvcu)) {
                message1 = "Khong duoc sua";
            } else {
                NhanVienDAO c = new NhanVienDAO();
                c.editNhanvien(manv, hoten, gioitinh, ngaysinh, sdt, chucvu, luong);
            }
            request.setAttribute("nhanvien", nhanvien);
            request.setAttribute("message1", message1);
            request.setAttribute("message2", message2);
            request.setAttribute("message3", message3);
            request.setAttribute("message4", message4);
            request.setAttribute("message5", message5);
            request.setAttribute("message6", message6);
            request.setAttribute("message7", message7);
        } else if (action.equals("delete")) {
            NhanVienDAO c = new NhanVienDAO();
            String manv = request.getParameter("manv");
            c.deleteNhanVien(manv);
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
