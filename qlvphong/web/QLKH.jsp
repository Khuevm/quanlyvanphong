
<%@page import="java.util.List"%>
<%@page import="qlvphong.model.KhachHang"%>
<%@page import="qlvphong.data.KhachHangDAO"%>
<html>
    <head>
        <title>Quan ly Khach hang</title>
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
                 <span class ="eff6">THONG TIN KHACH HANG</span>
            </div>
            <div id="header3">
                  
                <div class="topnav" id="myTopnav" style="float: right;">
                    <a href="dangnhap.jsp" style="color: white">Dang xuat</a>
                </div>
               
            </div>
        </div>	
        <%
            KhachHangDAO c = new KhachHangDAO();
            List<KhachHang> list = c.getAll();
            request.setAttribute("allkhachhang", list);
        %>
        <div>		
            <div id="noidung1" style="background: url(anh/noidung1.jpg) no-repeat; background-size: cover;">     
                <table border=1>
                    <tr>
                        <th></th>
                        <th>Ma KH</th>
                        <th>Ho ten</th>
                        <th>Gioi tinh</th>
                        <th>Chung minh thu</th>
                        <th>So dien thoai</th>
                        <th>Nghe nghiep</th>
                    </tr>
                    
                  <c:forEach var="khachhang" items="${allkhachhang}">
                    <tr>
                        <td>
                            <form action="khachhang" method="post">
                                <input type="hidden" name="makhach" value="<c:out value='${khachhang.makhach}'/>">
                                <button id="get" name="action" value="getKHbyID"></button>
                            </form>
                        </td>
                        <td>${khachhang.makhach}</td>
                        <td>${khachhang.hoten}</td>
                        <td>${khachhang.gioitinh}</td>
                        <td>${khachhang.cmt}</td>
                        <td>${khachhang.sdt}</td>
                        <td>${khachhang.nghe}</td>
                    </c:forEach>
                </table>
            </div>
            <div id="noidung2">
                <form action="khachhang" method="post">
                    <label>Ma khach hang</label>
                    <i id="message" style = "color: red">${message1}</i>
                    <input type="text" name="makhach" placeholder="Nhap ma khach hang" value="${khachhang.makhach}">
                    <input type="hidden" name="makhachcu" value="${khachhang.makhach}">
                    
                    <label>Ho va ten</label>
                    <i id="message" style = "color: red">${message2}</i>
                    <input type="text" name="hoten" placeholder="Nhap ho va ten" value="${khachhang.hoten}">

                    <label>Gioi tinh</label>
                    <i id="message" style = "color: red">${message3}</i>
                    <input type="text" name="gioitinh" placeholder="Nhap gioi tinh" value="${khachhang.gioitinh}">
                    
                    <label>Chung minh thu</label>
                    <i id="message" style = "color: red">${message4}</i>
                    <input type="text" name="cmt" placeholder="Nhap chung minh thu" value="${khachhang.cmt}">

                    <label>So dien thoai</label>
                    <i id="message" style = "color: red">${message5}</i>
                    <input type="text" name="sdt"  placeholder="So dien thoai" value="${khachhang.sdt}">
                    
                    <label>Nghe nghiep</label>
                    <i id="message" style = "color: red">${message6}</i>
                    <input type="text" name="nghe" placeholder="Nghe nghiep" value="${khachhang.nghe}">
                    
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