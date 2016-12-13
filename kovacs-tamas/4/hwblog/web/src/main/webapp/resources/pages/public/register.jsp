<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="<c:url value="/resources/css/registration.css"/>" rel="stylesheet">
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    </head>

    <body>
        <div class="form-container">
            <label>Register</label><br>
            <span id="errorMessage" class="hidden error-message">Empty or invalid data</span>
            <form action="/web/RegistrationServlet" method="post" onsubmit="return validateRegForm()">

                <label>Username:</label>
                <input id="username" class="req-input" type="text" placeholder="username"/><br>
                <label>Password:</label>
                <input id="password" class="req-input" type="text" placeholder="password"/><br>
                <label>Reenter password:</label>
                <input id="rePassword" class="req-input" type="text" placeholder="reenter password"/><br>

                <label>First name:</label>
                <input id="firstName" class="req-input" type="text" placeholder="first name"/><br>
                <label>Last name:</label>
                <input id="lastName" class="req-input" type="text" placeholder="last name"/><br>
                <label>Email:</label>
                <input id="email" class="req-input" type="email" placeholder="email"/><br>

                <label>Gender:</label><br>
                <input type="radio" name="gender" value="male" checked> Male<br>
                <input type="radio" name="gender" value="female"> Female<br>
                <label>Date of birth:</label>
                <input type="text" id="datepicker" readonly=""><br>

                <label>Title:</label>
                <input id="title" class="req-input" type="text" placeholder="title"/><br>

                <label>State:</label>
                <input id="state" class="req-input" type="text" placeholder="state"/><br>
                <label>Post code:</label>
                <input id="postCode" class="req-input" type="number" placeholder="post code"/><br>
                <label>City:</label>
                <input id="city" class="req-input" type="text" placeholder="city"/><br>
                <label>Street:</label>
                <input id="street" class="req-input" type="text" placeholder="street"/><br>

                <label>Phone:</label>
                <input id="phone" class="req-input" type="number" placeholder="phone"/><br>
                <label>Cell:</label>
                <input id="cell" class="req-input" type="text" placeholder="cell"/><br>


                <input id="reg-submit" class="submit" type="submit" value="Register">
            </form>
        </div>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="<c:url value="/resources/js/registrationValidater.js"/>"></script>
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
                $(function () {
                    $("#datepicker").datepicker();
                });
        </script>
    </body>
</html>