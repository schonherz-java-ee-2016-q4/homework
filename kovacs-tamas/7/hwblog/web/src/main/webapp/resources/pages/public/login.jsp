<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login</title>
        <link href="<c:url value="/resources/css/bootstrap-login.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/css/login.css"/>" rel="stylesheet">
    </head>
    <body>
        <div class="login-page">
            <div class="form">
                <!-- Error messages -->
                <span id="empty-field-message" class="hidden error-message">
                    Missing username or password</span>

                <c:if test="${error != null}">
                    <span id="invalid-field-message" class="error-message">
                        <br>Invalid username or password</span>
                        <c:remove var="invalidLogin" scope="request"/>
                    </c:if>

                <!-- Old login form -->
                <form onsubmit="return validateLogin()" class="login-form" method="post">
                    <input type="text" placeholder="username" id="username" name="username"/>
                    <input type="password" placeholder="password" id="psw" name="password"/>
                    <input id="submitLogin" type="submit" value="Login"/>
                    <p class="message">Not registered?
                        <a href="<c:url value="/registration"/>">Register here</a>
                        <!--<a href="/web/resources/pages/public/register.jsp">Register here</a>-->
                    </p>
                </form>
            </div>
        </div>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="<c:url value="/resources/js/loginValidation.js"/>"></script>
    </body>
</html>
