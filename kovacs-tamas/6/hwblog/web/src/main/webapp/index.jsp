<%@page import="hu.schonherz.java.training.kovtamas.dbsupplier.DataBaseSupplier"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>
        <!--If user is already logged in, redirect to the secure page-->
        <c:if test="${sessionScope.user != null}">
            <c:redirect url="/secure/securePage.jsp"/>
        </c:if>
        <!--If user is not logged in, redirect to the login page-->
        <c:redirect url="/login"/>
    </body>
</html>
