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

import qlvphong.data.HoaDonDAO;
import qlvphong.model.HoaDon;

/**
 *
 * @author OS
 */
public class HoaDonServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // get current action
        String url = "/QLHoaDon.jsp";
        String action = request.getParameter("action");
        if (action.equals("add")) {
            String message1 = "", message2 = "", message3 = "", message4 = "", message5 = "", message6 = "", message7 = "";
            String mahoadon = request.getParameter("mahoadon");
            String mahopdong = request.getParameter("mahopdong");
            String ngay = request.getParameter("ngay");
            int tienphong = 0, tiendien = 0, tiennuoc = 0, tienmang = 0, tongtien = 0;
            try {
                tienphong = Integer.parseInt(request.getParameter("tienphong"));
                tiendien = Integer.parseInt(request.getParameter("tiendien"));
                tiennuoc = Integer.parseInt(request.getParameter("tiennuoc"));
                tienmang = Integer.parseInt(request.getParameter("tienmang"));
                tongtien = tienphong + tiendien + tiennuoc + tienmang;
            } catch (NumberFormatException e) {
            }

            HoaDon hoadon = new HoaDon(mahoadon, mahopdong, ngay, tienphong, tiendien, tiennuoc, tienmang);
            System.out.println(mahoadon + " " + mahopdong + " " + ngay + " " + tienphong + " " + tiendien + " " + tiennuoc + " " + tienmang + " " + tongtien);
            //data validation 
            if (mahoadon == "") {
                message1 = "Hay nhap truong nay";
            } else if (mahopdong == "") {
                message2 = "Hay nhap truong nay";
            } else if (ngay == "") {
                message3 = "Hay nhap truong nay";
            } else if (tienphong < 0) {
                message4 = "Hay nhap truong nay la so nguyen";
            } else if (tiendien < 0) {
                message5 = "Hay nhap truong nay la so nguyen";
            } else if (tiennuoc < 0) {
                message6 = "Hay nhap truong nay la so nguyen";
            } else if (tienmang < 0) {
                message7 = "Hay nhap truong nay la so nguyen";
            } else if (hoadon.isExist()) {
                message1 = "Ma da ton tai";
            } else {
                hoadon.setTongtien(tongtien);
                HoaDonDAO c = new HoaDonDAO();
                c.insertHoaDon(mahoadon, mahopdong, ngay, tienphong, tiendien, tiennuoc, tienmang);
            }
            request.setAttribute("hoadon", hoadon);
            request.setAttribute("message1", message1);
            request.setAttribute("message2", message2);
            request.setAttribute("message3", message3);
            request.setAttribute("message4", message4);
            request.setAttribute("message5", message5);
            request.setAttribute("message5", message6);
            request.setAttribute("message5", message7);
        } else if (action.equals("getHoaDonbyID")) {
            HoaDonDAO c = new HoaDonDAO();
            String mahoadon = request.getParameter("mahoadon");
            HoaDon hoadon = c.getHoaDonByID(mahoadon);
            request.setAttribute("hoadon", hoadon);
        } else if (action.equals("edit")) {
            String message1 = "", message2 = "", message3 = "", message4 = "", message5 = "", message6 = "", message7 = "";
            String mahoadon = request.getParameter("mahoadon");
            String mahoadoncu = request.getParameter("mahoadoncu");
            String mahopdong = request.getParameter("mahopdong");
            String ngay = request.getParameter("ngay");
            int tienphong = 0, tiendien = 0, tiennuoc = 0, tienmang = 0, tongtien = 0;
            try {
                tienphong = Integer.parseInt(request.getParameter("tienphong"));
                tiendien = Integer.parseInt(request.getParameter("tiendien"));
                tiennuoc = Integer.parseInt(request.getParameter("tiennuoc"));
                tienmang = Integer.parseInt(request.getParameter("tienmang"));
                tongtien = tienphong + tiendien + tiennuoc + tienmang;
            } catch (NumberFormatException e) {
            }

            HoaDon hoadon = new HoaDon(mahoadon, mahopdong, ngay, tienphong, tiendien, tiennuoc, tienmang);
            System.out.println(mahoadon + " " + mahopdong + " " + ngay + " " + tienphong + " " + tiendien + " " + tiennuoc + " " + tienmang);
            //data validation 
            if (mahoadon == "") {
                message1 = "Hay nhap truong nay";
            } else if (mahopdong == "") {
                message2 = "Hay nhap truong nay";
            } else if (ngay == "") {
                message3 = "Hay nhap truong nay";
            } else if (tienphong < 0) {
                message4 = "Hay nhap truong nay la so nguyen";
            } else if (tiendien < 0) {
                message5 = "Hay nhap truong nay la so nguyen";
            } else if (tiennuoc < 0) {
                message6 = "Hay nhap truong nay la so nguyen";
            } else if (tienmang < 0) {
                message7 = "Hay nhap truong nay la so nguyen";
            } else if (!mahoadon.equalsIgnoreCase(mahoadoncu)) {
                message1 = "Khong duoc sua";
            } else {
                hoadon.setTongtien(tongtien);
                HoaDonDAO c = new HoaDonDAO();
                c.editHoaDon(mahoadon, mahopdong, ngay, tienphong, tiendien, tiennuoc, tienmang);
            }
            request.setAttribute("hoadon", hoadon);
            request.setAttribute("message1", message1);
            request.setAttribute("message2", message2);
            request.setAttribute("message3", message3);
            request.setAttribute("message4", message4);
            request.setAttribute("message5", message5);
            request.setAttribute("message6", message6);
            request.setAttribute("message7", message7);
        } else if (action.equals("delete")) {
            HoaDonDAO c = new HoaDonDAO();
            String mahoadon = request.getParameter("mahoadon");
            c.deleteHoaDon(mahoadon);
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
