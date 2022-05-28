
<%@page import="java.util.List"%>
<%@page import="qlvphong.model.ToaNha"%>
<%@page import="qlvphong.data.ToaNhaDAO"%>
<html>
    <head>
        <title>Quan ly toa nha</title>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="css/qlsv.css">
    </head>
    <body>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <div>		
            <div id="header1">
              
                <span><a href="trangchu.jsp"><button id="back"></button></a></span>
                <div id="usernamelogin" style="float: left; margin-top: 20px;
                     margin-left: 10px; color: white">Xin chao ${admin.name}</div>
                
       
            </div>
             <div id="header2">
                 <span class ="eff6">THONG TIN TOA NHA</span>
            </div>
            <div id="header3">
                  
                <div class="topnav" id="myTopnav" style="float: right;">
                    <a href="dangnhap.jsp" onclick="dangxuat()" style="color: white">Dang xuat</a>
                </div>
               
            </div>
        </div>	
        <%
            ToaNhaDAO c = new ToaNhaDAO();
            List<ToaNha> list = c.getAll();
            request.setAttribute("all", list);
        %>
        <div>		
            <div id="noidung1" style="background: url(anh/noidung1.jpg) no-repeat; background-size: cover;">     
                <table border=1>
                    <tr>
                        <th></th>
                        <th>Ma toa nha</th>
                        <th>Dien tich</th>
                        <th>So luong nguoi</th>
                        <th>Loai phong</th>
                        <th>Ghi chu</th>
                    </tr>
                    
                  <c:forEach var="toanha" items="${all}">
                    <tr>
                        <td>
                            <form action="toanha" method="post">
                                <input type="hidden" name="matoanha" value="<c:out value='${toanha.matoanha}'/>">
                                <button id="get" name="action" value="getToaNhaByID"></button>
                            </form>
                        </td>
                        <td>${toanha.matoanha}</td>
                        <td>${toanha.dientich}</td>
                        <td>${toanha.soluong}</td>
                        <td>${toanha.loai}</td>
                        <td>${toanha.ghichu}</td>
                    </c:forEach>
                </table>
            </div>
            <div id="noidung2">
                <form action="toanha" method="post">
                    <label>Ma toa nha</label>
                    <i id="message" style = "color: red">${message1}</i>
                    <input type="text" name="matoanha" placeholder="Nhap ma toa nha" value="${toanha.matoanha}">
                    <input type="hidden" name="matoanhacu" value="${toanha.matoanha}">
                    
                    <label>Dien tich</label>
                    <i id="message" style = "color: red">${message2}</i>
                    <input type="text" name="dientich" placeholder="Nhap dien tich" value="${toanha.dientich}">
                    
                    <label>So luong nguoi</label>
                    <i id="message" style = "color: red">${message3}</i>
                    <input type="text" name="soluong" placeholder="Nhap so luong nguoi" value="${toanha.soluong}">
                    
                    <label>Loai phong</label>
                    <i id="message" style = "color: red">${message4}</i>
                    <select name="loai">
                        <option <c:if test="${toanha.loai=='Khep kin' or toanha.loai==''}">selected="selected"</c:if>>Khep kin</option>
                        <option <c:if test="${toanha.loai=='Khong khep kin'}">selected="selected"</c:if>>Khong khep kin</option>
                    </select>
                    
                    <label>Ghi chu</label>
                    <i id="message" style = "color: red">${message5}</i>
                    <select name="ghichu">
                        <option <c:if test="${toanha.ghichu=='Con trong' or  toanha.ghichu==''}">selected="selected"</c:if>>Con trong</option>
                        <option <c:if test="${toanha.ghichu=='Het cho'}">selected="selected"</c:if>>Het cho</option>
                    </select>
                        
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