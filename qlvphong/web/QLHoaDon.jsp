
<%@page import="java.util.List"%>
<%@page import="qlvphong.model.HopDong"%>
<%@page import="qlvphong.data.HopDongDAO"%>
<%@page import="qlvphong.model.HoaDon"%>
<%@page import="qlvphong.data.HoaDonDAO"%>
<html>
    <head>
        <title>Quan ly Hoa Don</title>
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
                     margin-left: 10px; color: white">Xin chao ${admin.name}</div>


            </div>
            <div id="header2">
                <span class ="eff6">THONG TIN HOA DON</span>
            </div>
            <div id="header3">

                <div class="topnav" id="myTopnav" style="float: right;">
                    <a href="dangnhap.jsp" onclick="dangxuat()" style="color: white">Dang xuat</a>
                </div>

            </div>
        </div>	
        <%
            HopDongDAO hd = new HopDongDAO();
            List<HopDong> listHD = hd.getAll();
            request.setAttribute("allhopdong", listHD);
            HoaDonDAO c = new HoaDonDAO();
            List<HoaDon> list = c.getAll();
            request.setAttribute("all", list);
        %>
        <div>		
            <div id="noidung1" style="background: url(anh/noidung1.jpg) no-repeat; background-size: cover;">     
                <table border=1>
                    <tr>
                        <th></th>
                        <th>Ma Hoa Don</th>
                        <th>Ma Hop Dong</th>
                        <th>Ngay</th>
                        <th>Tien phong</th>
                        <th>Tien dien</th>
                        <th>Tien nuoc</th>
                        <th>Internet</th>
                        <th>Tong tien</th>
                    </tr>

                    <c:forEach var="hoadon" items="${all}">
                        <tr>
                            <td>
                                <form action="hoadon" method="post">
                                    <input type="hidden" name="mahoadon" value="<c:out value='${hoadon.mahoadon}'/>">
                                    <button id="get" name="action" value="getHoaDonbyID"></button>
                                </form>
                            </td>
                            <td>${hoadon.mahoadon}</td>
                            <td>${hoadon.mahopdong}</td>
                            <td>${hoadon.ngay}</td>
                            <td>${hoadon.tienphong}</td>
                            <td>${hoadon.tiendien}</td>
                            <td>${hoadon.tiennuoc}</td>
                            <td>${hoadon.tienmang}</td>
                            <td>${hoadon.tongtien}</td>
                        </c:forEach>
                </table>
            </div>
            <div id="noidung2">
                <form action="hoadon" method="post">
                    <label>Ma hoa don</label>
                    <i id="message" style = "color: red">${message1}</i>
                    <input type="text" name="mahoadon" placeholder="Nhap ma hoa don" value="${hoadon.mahoadon}">
                    <input type="hidden" name="mahoadoncu" value="${hoadon.mahoadon}">

                    <label>Ma hop dong</label>
                    <i id="message" style = "color: red">${message2}</i>
                    <select name="mahopdong">
                        <c:forEach var="hopdong" items="${allhopdong}">
                            <option <c:if test="${hoadon.mahopdong==hopdong.mahopdong}">selected="selected"</c:if>>${hopdong.mahopdong}</option>
                        </c:forEach>
                    </select>
                    
                    <label>Ngay</label>
                    <input type="date" name="ngay" value="${hoadon.ngay}"><br>
                    <i id="message" style = "color: red">${message3}</i><br>
                    
                    <label>Tien phong</label>
                    <i id="message" style = "color: red">${message4}</i>
                    <input type="text" name="tienphong" placeholder="Nhap tien phong" value="${hoadon.tienphong}">
                    
                    <label>Tien dien</label>
                    <i id="message" style = "color: red">${message5}</i>
                    <input type="text" name="tiendien" placeholder="Nhap tien dien" value="${hoadon.tiendien}">

                    <label>Tien nuoc</label>
                    <i id="message" style = "color: red">${message6}</i>
                    <input type="text" name="tiennuoc" placeholder="Nhap tien nuoc" value="${hoadon.tiennuoc}">

                    <label>Internet</label>
                    <i id="message" style = "color: red">${message7}</i>
                    <input type="text" name="tienmang" placeholder="Nhap tien internet" value="${hoadon.tienmang}">
                    
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