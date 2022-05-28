<!DOCTYPE html>
<html >
    <head>
        <title>Dang nhap</title>
        <meta charset="utf-8"> 	
        <link rel="stylesheet" type="text/css" href="css/dangnhap.css">
        <link rel="icon" href="anh/login.png">
    </head>
    
    <%
        session.removeAttribute("admin");
    %>
        
    <body>
        <div class="cont">
            <div class="demo">
                <div class="login">
                    <center><img src="anh/login.png"/></center>        
                    <center> <h1> <span style="color: #4c7060eb; font-size: 45px">Login</span></h1></center>                                                                            
                    <form class="login_form" action="admin" method="post">
                        <div class="login_row">
                            <svg class="login_icon name svg-icon" viewBox="0 0 20 20" >
                                <path d="M0,20 a10,8 0 0,1 20,0z M10,0 a4,4 0 0,1 0,8 a4,4 0 0,1 0,-8" />
                            </svg>
                            <input type="text" id="username" class="login_input name" placeholder="Username" name="username" value="${username}" style="color:#4CAF50" />
                            <i id="message" style = "color: red; font-size: 20px">${message1}</i>
                        </div>
                        
                        <div class="login_row">
                            <svg class="login_icon pass svg-icon" viewBox="0 0 20 20">
                                <path d="M0,20 20,20 20,8 0,8z M10,13 10,16z M4,8 a6,8 0 0,1 12,0" />
                            </svg>
                            <input type="password" id="password" class="login_input pass" placeholder="Password" name="password" value="${password}" />
                            <i id="message" style = "color: red; font-size: 20px">${message2}</i>
                        </div>
                        
                        <button type="submit" name="action" value="login" class="login_submit">Dang nhap</button>
                        <a href="dangky.jsp" style = "font-size: 20px; color: #4c7060eb;">Dang ky</a>
                    </form>
                    
                </div>

            </div>
        </div>

    </body>
</html>
