<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Secure</title>
        <link href="resources/css/bootstrap.min.css" rel="stylesheet">
        <link href="resources/css/starter-template.css" rel="stylesheet">
    </head>
    <body>
        <!--Page header-->
        <!-- TODO: replace inline styles with the use of external css -->
        <div class="col-lg-3 col-md-4 col-xs-6">
            <div style="display: inline-block;">
                <label>Welcome, ${sessionScope.user.login.username}</label>
            </div>
            <div style="display: inline-block;">
                <form action="/web/logOutServlet" method="post">
                    <input type="submit" value="Sign out"/>
                </form>
            </div>
        </div>


    </body>
</html>
