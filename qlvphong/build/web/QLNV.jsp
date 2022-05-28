
<%@page import="java.util.List"%>
<%@page import="qlvphong.model.NhanVien"%>
<%@page import="qlvphong.data.NhanVienDAO"%>
<html>
    <head>
        <title>Quan ly Nhan vien</title>
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
                 <span class ="eff6">THONG TIN NHAN VIEN</span>
            </div>
            <div id="header3">
                  
                <div class="topnav" id="myTopnav" style="float: right;">
                    <a href="dangnhap.jsp" style="color: white">Dang xuat</a>
                </div>
               
            </div>
        </div>	
        <%
            NhanVienDAO c = new NhanVienDAO();
            List<NhanVien> list = c.getAll();
            request.setAttribute("allnhanvien", list);
        %>
        <div>		
            <div id="noidung1" style="background: url(anh/noidung1.jpg) no-repeat; background-size: cover;">     
                <table border=1>
                    <tr>
                        <th></th>
                        <th>Ma NV</th>
                        <th>Ho ten</th>
                        <th>Gioi tinh</th>
                        <th>Ngay Sinh</th>
                        <th>So dien thoai</th>
                        <th>Chuc vu</th>
                        <th>Luong</th>
                    </tr>
                    
                  <c:forEach var="nhanvien" items="${allnhanvien}">
                    <tr>
                        <td>
                            <form action="nhanvien" method="post">
                                <input type="hidden" name="manv" value="<c:out value='${nhanvien.manv}'/>">
                                <button id="get" name="action" value="getNVbyID"></button>
                            </form>
                        </td>
                        <td>${nhanvien.manv}</td>
                        <td>${nhanvien.hoten}</td>
                        <td>${nhanvien.gioitinh}</td>
                        <td>${nhanvien.ngaysinh}</td>
                        <td>${nhanvien.sdt}</td>
                        <td>${nhanvien.chucvu}</td>
                        <td>${nhanvien.luong}</td>
                    </c:forEach>
                </table>
            </div>
            <div id="noidung2">
                <form action="nhanvien" method="post">
                    <label>Ma nhan vien</label>
                    <i id="message" style = "color: red">${message1}</i>
                    <input type="text" name="manv" placeholder="Nhap ma nhan vien" value="${nhanvien.manv}">
                    <input type="hidden" name="manvcu" value="${nhanvien.manv}">
                    
                    <label>Ho va ten</label>
                    <i id="message" style = "color: red">${message2}</i>
                    <input type="text" name="hoten" placeholder="Nhap ho va ten" value="${nhanvien.hoten}">

                    <label>Gioi tinh</label>
                    <i id="message" style = "color: red">${message3}</i>
                    <input type="text" name="gioitinh" placeholder="Nhap gioi tinh" value="${nhanvien.gioitinh}">
                    
                    <label>Ngay sinh</label>
                    <input type="date" name="ngaysinh" value="${nhanvien.ngaysinh}">
                    <i id="message" style = "color: red">${message4}</i><br><br>

                    <label>So dien thoai</label>
                    <i id="message" style = "color: red">${message5}</i>
                    <input type="text" name="sdt"  placeholder="So dien thoai" value="${nhanvien.sdt}">
                    
                    <label>Chuc vu</label>
                    <i id="message" style = "color: red">${message6}</i>
                    <input type="text" name="chucvu" placeholder="Chuc vu" value="${nhanvien.chucvu}">
                    
                    <label>Luong</label>
                    <i id="message" style = "color: red">${message7}</i>
                    <input type="text" name="luong"  placeholder="Nhap luong" value="${nhanvien.luong}">
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