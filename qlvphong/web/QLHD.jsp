
<%@page import="java.util.List"%>
<%@page import="qlvphong.model.HopDong"%>
<%@page import="qlvphong.data.HopDongDAO"%>
<%@page import="qlvphong.model.KhachHang"%>
<%@page import="qlvphong.data.KhachHangDAO"%>
<%@page import="qlvphong.model.ToaNha"%>
<%@page import="qlvphong.data.ToaNhaDAO"%>
<html>
    <head>
        <title>Quan ly Hop Dong</title>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="css/qlsv.css">
        <link rel="icon" href="anh/logo.ico">
    </head>
    <body>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <div>				<!-- Ph?n header -->
            <div id="header1">

                <span><a href="trangchu.jsp"><button id="back"></button></a></span>
                <div id="usernamelogin" style="float: left; margin-top: 20px;
                     margin-left: 10px; color: white">Xin chao ${admin.username}</div>


            </div>
            <div id="header2">
                <span class ="eff6">THONG TIN HOP DONG</span>
            </div>
            <div id="header3">

                <div class="topnav" id="myTopnav" style="float: right;">
                    <a href="dangnhap.jsp" onclick="dangxuat()" style="color: white">Dang xuat</a>
                </div>

            </div>
        </div>	
        <%
            HopDongDAO c = new HopDongDAO();
            List<HopDong> list = c.getAll();
            request.setAttribute("all", list);
            KhachHangDAO kh = new KhachHangDAO();
            List<KhachHang> listKH = kh.getAll();
            request.setAttribute("allkhachhang", listKH);
            ToaNhaDAO tn = new ToaNhaDAO();
            List<ToaNha> listTN = tn.getAll();
            request.setAttribute("alltoanha", listTN);
        %>
        <div>		
            <div id="noidung1" style="background: url(anh/noidung1.jpg) no-repeat; background-size: cover;">     
                <table border=1>
                    <tr>
                        <th></th>
                        <th>Ma Hop Dong</th>
                        <th>Ma Khach Hang</th>
                        <th>Ma Toa Nha</th>
                        <th>Ngay bat dau</th>
                        <th>Ngay ket thuc</th>
                        <th>Trang thai</th>
                    </tr>

                    <c:forEach var="hopdong" items="${all}">
                        <tr>
                            <td>
                                <form action="hopdong" method="post">
                                    <input type="hidden" name="mahopdong" value="<c:out value='${hopdong.mahopdong}'/>">
                                    <button id="get" name="action" value="getHDbyID"></button>
                                </form>
                            </td>
                            <td>${hopdong.mahopdong}</td>
                            <td>${hopdong.makhach}</td>
                            <td>${hopdong.matoanha}</td>
                            <td>${hopdong.ngaybd}</td>
                            <td>${hopdong.ngaykt}</td>
                            <td>${hopdong.trangthai}</td>
                        </c:forEach>
                </table>
            </div>
            <div id="noidung2">
                <form action="hopdong" method="post">
                    <label>Ma hop dong</label>
                    <i id="message" style = "color: red">${message1}</i>
                    <input type="text" name="mahopdong" placeholder="Nhap ma hop dong" value="${hopdong.mahopdong}">
                    <input type="hidden" name="mahopdongcu" value="${hopdong.mahopdong}">

                    <label>Ma khach hang</label>
                    <i id="message" style = "color: red">${message2}</i>
                    <select name="makhach">
                        <c:forEach var="khachhang" items="${allkhachhang}">
                            <option <c:if test="${hopdong.makhach==khachhang.makhach}">selected="selected"</c:if>>${khachhang.makhach}</option>
                        </c:forEach>
                    </select>
                    
                    <label>Ma toa nha</label>
                    <i id="message" style = "color: red">${message3}</i>
                    <select name="matoanha">
                        <c:forEach var="toanha" items="${alltoanha}">
                            <option <c:if test="${hopdong.matoanha==toanha.matoanha}">selected="selected"</c:if>>${toanha.matoanha}</option>
                        </c:forEach>
                    </select>
                    
                    <label>Ngay bat dau</label>
                    <input type="date" name="ngaybd" value="${hopdong.ngaybd}"><br>
                    <i id="message" style = "color: red">${message4}</i><br>

                    <label>Ngay ket thuc</label>
                    <input type="date" name="ngaykt" value="${hopdong.ngaykt}"><br>
                    <i id="message" style = "color: red">${message5}</i><br>


                    <center>
                        <button name="action" value="add" style="background-color: gray;">Them</button>
                        <button name="action" value="edit" style="background-color: gray;">Sua</button>
                        <button name="action" value="delete" style="background-color: gray;">Xoa</button>
                    </center>
                </form>
            </div>
        </div>
        <!--            <script>
                        if (sessionStorage.username == "undefined") {
                            alert("Ban chua dang nhap!");
                            window.location.href = "dangnhap.html";
                        }
                         document.getElementById("usernamelogin").innerHTML = "Xin chào " + sessionStorage.username;
                    </script>-->
    </body>

</html>