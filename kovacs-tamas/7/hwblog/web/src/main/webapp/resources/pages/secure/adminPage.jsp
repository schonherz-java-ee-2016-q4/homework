<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="../../favicon.ico">

        <title>Administrator</title>

        <link href="<c:url value="/resources/css/registration.css"/>" rel="stylesheet">
    </head>

    <body>

        <div class="login-page">
            <div id="req-inputs" class="form">
                <c:if test="${processMsg != null}">
                    <label <c:if test="${processMsg == 'Success!'}">
                            class="success-message"
                        </c:if>
                        <c:if test="${processMsg != 'Success!'}">
                            class="error-message"
                        </c:if>>${processMsg}</label>
                </c:if>
                <form method="POST">
                    <label>Username:</label>
                    <input type="text" placeholder="username" name="username"/><br>
                    <label>Role:</label>
                    <select name="role">
                        <option value="user">User</option>
                        <option value="admin">Admin</option>
                    </select><br>
                    <input type="submit" value="Set role"/>
                </form>
            </div>
        </div>
    </body>
</html>
