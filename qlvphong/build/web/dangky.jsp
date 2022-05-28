<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Dang ky</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="css/dangki.css">
    </head>
    <body>
        <div class="container">

    <form id="signup" action="admin" method="post">

        <div class="header">
        
            <h3>Sign Up</h3>
            
            <p>You want to fill out this form</p>
            
        </div>
        
        <div class="sep"></div>

        <div class="inputs">
        
            <i id="message" style = "color: red">${message1}</i>
            <input type="text" placeholder="Username" name="username" value="${admin.username}" autofocus />
            
            <i id="message" style = "color: red">${message2}</i>
            <input type="password" placeholder="Password" name="password" value="${admin.password}"/>
            
            <i id="message" style = "color: red">${message3}</i>
            <input type="text" placeholder="Ho ten" name="name" value="${admin.name}"/>
            
            <i id="message" style = "color: red">${message4}</i>
            <input type="email" placeholder="E-mail" name="email" value="${admin.email}"/>
            
            <button id="submit" name="action" value="signup">SIGN UP</button>
            <center style=" margin-top: 15px">
                <a href="dangnhap.jsp" style = "font-size: 20px; color: #4c7060eb">Dang nhap</a>
            </center>
        </div>

    </form>

</div>
    </body>
</html>
