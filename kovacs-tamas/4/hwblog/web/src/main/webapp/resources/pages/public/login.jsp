<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login</title>
        <link href="<c:url value="/resources/css/bootstrap-login.css"/>" rel="stylesheet">
        <script src="<c:url value="/resources/js/bootstrap-login.js"/>"></script>
    </head>
    <body>
        <div class="login-page">
            <div class="form">
                <form class="login-form" action="/web/loginServlet" method="post">
                    <input type="text" placeholder="username" id="userrname" name="usrname"/>
                    <input type="password" placeholder="password" id="pwd" name="psw"/>
                    <input id="submitLogin" type="submit" value="Login"/>
                    <p class="message">Not registered?
                        <a href="/web/resources/pages/public/register.jsp">Register here</a></p>
                </form>
            </div>
        </div>
    </body>
</html>
