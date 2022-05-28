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

import qlvphong.data.ToaNhaDAO;
import qlvphong.model.ToaNha;

/**
 *
 * @author OS
 */
public class ToaNhaServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // get current action
        String url = "/QLTN.jsp";
        String action = request.getParameter("action");
        if (action.equals("add")) {
            String message1 = "", message2 = "", message3 = "", message4 = "", message5 = "";
            String matoanha = request.getParameter("matoanha");
            String dientich = request.getParameter("dientich");
            String ghichu = request.getParameter("ghichu");
String loai = request.getParameter("loai");
            int soluong = 0;
            try { 
                soluong = Integer.parseInt(request.getParameter("soluong"));
            } catch (NumberFormatException e) {
            }
            ToaNha toanha = new ToaNha(matoanha, soluong, dientich, loai, ghichu);
            System.out.println(matoanha +" "+ soluong +" "+ dientich+" "+ loai +" "+ ghichu);
            //data validation 
            if (matoanha == "") {
                message1 = "Hay nhap truong nay";
            } else if (dientich == "") {
                message2 = "Hay nhap truong nay";
            } else if (soluong <= 0) {
                message3 = "Hay nhap truong nay la so nguyen";
            } else if (loai == "") {
                message4 = "Hay nhap truong nay";
            } else if (ghichu == "") {
                message5 = "Hay nhap truong nay";
            } else if (toanha.isExist()) {
                message1 = "Ma da ton tai";
            } else {
                ToaNhaDAO c = new ToaNhaDAO();
                c.insert(matoanha, dientich, soluong, loai, ghichu);
            }

            request.setAttribute("toanha", toanha);
            request.setAttribute("message1", message1);
            request.setAttribute("message2", message2);
            request.setAttribute("message3", message3);
            request.setAttribute("message4", message4);
            request.setAttribute("message5", message5);
        } else if (action.equals("getToaNhaByID")) {
            ToaNhaDAO c = new ToaNhaDAO();
            String matoanha = request.getParameter("matoanha");
            ToaNha toanha = c.getToaNhaByID(matoanha);
            request.setAttribute("toanha", toanha);
        } else if (action.equals("edit")) {
            String message1 = "", message2 = "", message3 = "", message4 = "", message5 = "";
            String matoanha = request.getParameter("matoanha");
            String matoanhacu = request.getParameter("matoanhacu");
            String dientich = request.getParameter("dientich");
            String ghichu = request.getParameter("ghichu");
String loai = request.getParameter("loai");
            int soluong = 0;
            try { 
                soluong = Integer.parseInt(request.getParameter("soluong"));
            } catch (NumberFormatException e) {
            }
            ToaNha toanha = new ToaNha(matoanha, soluong, dientich, loai, ghichu);
            System.out.println(matoanha +" "+ soluong +" "+ dientich+" "+ loai+" "+ ghichu);
            //data validation 
            if (matoanha == "") {
                message1 = "Hay nhap truong nay";
            } else if (dientich == "") {
                message2 = "Hay nhap truong nay";
            } else if (soluong <= 0) {
                message3 = "Hay nhap truong nay la so nguyen";
            } else if (loai == "") {
                message4 = "Hay nhap truong nay";
            } else if (ghichu == "") {
                message5 = "Hay nhap truong nay";
            } else if (!matoanha.equalsIgnoreCase(matoanhacu)) {
                message1 = "Khong duoc sua";
            } else {
                ToaNhaDAO c = new ToaNhaDAO();
                c.edit(matoanha, dientich, soluong, loai, ghichu);
            }

            request.setAttribute("toanha", toanha);
            request.setAttribute("message1", message1);
            request.setAttribute("message2", message2);
            request.setAttribute("message3", message3);
            request.setAttribute("message4", message4);
            request.setAttribute("message5", message5);
        } else if (action.equals("delete")) {
            ToaNhaDAO c = new ToaNhaDAO();
            String matoanha = request.getParameter("matoanha");
            c.delete(matoanha);
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
