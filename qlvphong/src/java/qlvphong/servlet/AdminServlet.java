/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlvphong.servlet;

import java.io.IOException;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import qlvphong.data.AdminDAO;
import qlvphong.model.Admin;

/**
 *
 * @author OS
 */
public class AdminServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // get current action
HttpSession session = request.getSession();
        String url = "/dangky.jsp";
        String action = request.getParameter("action");
        if (action.equals("signup")) {
            String message1 = "", message2 = "", message3 = "", message4 = "";
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String name = request.getParameter("name");
            String email = request.getParameter("email");

            Admin admin = new Admin(username, password, name, email);
            System.out.println(username + " " + password + " " + name + " " + email);
            //data validation 
            if (username == "") {
                message1 = "Hay nhap truong nay";
            } else if (password == "") {
                message2 = "Hay nhap truong nay";
            } else if (name == "") {
                message3 = "Hay nhap truong nay";
            } else if (email == "") {
                message4 = "Hay nhap truong nay voi name@example.com";
            } else if (admin.isExist()) {
                message1 = "Username da ton tai";
            } else {
                url = "/dangnhap.jsp";
                AdminDAO c = new AdminDAO();
                c.insertAdmin(username, password, name, email);
            }

            request.setAttribute("admin", admin);
            request.setAttribute("message1", message1);
            request.setAttribute("message2", message2);
            request.setAttribute("message3", message3);
            request.setAttribute("message4", message4);
        } else if (action.equals("login")) {
            url = "/dangnhap.jsp";
            String message1 = "", message2 = "";
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            System.out.println(username + " " + password);
            //data validation 
            if (username == "") {
                message1 = "Hay nhap truong nay";
            } else if (password == "") {
                message2 = "Hay nhap truong nay";
            } else {
                AdminDAO c = new AdminDAO();
                Admin admin = c.getAdminByID(username);
                if (admin.getUsername() == null) {
                    message1 = "Username khong ton tai";
                } else if (!admin.getPassword().equals(password)) {
                    message2 = "Sai mat khau";
                } else {
                    session.setAttribute("admin", admin);
                    url = "/trangchu.jsp";
                }
            }
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            request.setAttribute("message1", message1);
            request.setAttribute("message2", message2);
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
