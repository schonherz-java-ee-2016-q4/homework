<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login</title>
    </head>
    <body>
        <!--TODO: check if the 'invalidLogin' attribute is present, handle it and remove it from request scope-->
        <form action="/web/loginServlet" method="post">
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" class="form-control" id="userrname" name="usrname">
            </div>
            <div class="form-group">
                <label for="pwd">Password:</label>
                <input type="password" class="form-control" id="pwd" name="psw">
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
        </form>
    </body>
</html>
