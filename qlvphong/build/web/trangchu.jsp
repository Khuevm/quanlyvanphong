<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="css/trangchu.css">
        <link rel="icon" href="anh/logo.ico">
        <title>Quan ly Van Phong</title>
    </head>
    <body>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <div id="main"> 
            <div id="header">
                <div>
                    <h1 id="usernamelogin" style="text-align: center; color: white;">Xin chao ${admin.name}</h1>
                </div>
                <div class="dangxuat" id="myTopnav" style="float: right; border-radius: 60%; float: right;">              
                    <a href="dangnhap.jsp" onclick="dangxuat()">Dang xuat</a>          
                </div>
            </div>
            <center>
            <a href="QLNV.jsp"><button class="nut" style="  ; background: url(anh/user.png); background-size: 100% 100%; " >Nhan vien</button></a>
            <a href="QLKH.jsp"><button class="nut" style="background: url(anh/customer.png); background-size: 100% 100%;">Khach Hang</button></a>
            <a href="QLTN.jsp"><button class="nut" style="background: url(anh/vanphong.png); background-size: 100% 100%; ">Toa Nha</button></a><br>
            <a href="QLHD.jsp"><button class="nut" style=" background: url(anh/hopdong.png); background-size: 100% 100%;">Hop Dong</button></a>
            <a href="QLHoaDon.jsp"><button class="nut" style="background: url(anh/bill.png); background-size: 100% 100%;">Hoa Don</button></a>
              </center>
        </div>
    </body>
</html> 
