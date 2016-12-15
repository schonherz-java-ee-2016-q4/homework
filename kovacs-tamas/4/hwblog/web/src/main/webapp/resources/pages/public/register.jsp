<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="<c:url value="/resources/css/registration.css"/>" rel="stylesheet">
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    </head>

    <body>
        <div class="login-page">
            <div id="req-inputs" class="form">
                <p><h1>Register</h1></p>
                <span id="errorMessage" class="hidden error-message">Empty or invalid data</span>
                <form class="login-form" action="/web/RegistrationServlet" method="post" onsubmit="return validateRegForm()">

                    <p><label>Username:</label>
                        <input id="username" name="username" class="req-input" type="text"
                               placeholder="username" required="true"/></p>
                    <p><label>Password:</label>
                        <input id="password" name="password" class="req-input" type="password"
                               placeholder="password" required="true"/></p>
                    <p><label>Confirm password:</label>
                        <input id="confirmPassword" name="confirmPassword" class="req-input"
                               type="password" placeholder="reenter password" required="true"/></p>

                    <p><label>First name:</label>
                        <input id="firstName" name="firstName" class="req-input" type="text"
                               placeholder="first name" required="true"/></p>
                    <p><label>Last name:</label>
                        <input id="lastName" name="lastName" class="req-input" type="text"
                               placeholder="last name" required="true"/></p>
                    <p><label>Email:</label>
                        <input id="email" name="email" class="req-input" type="email"
                               placeholder="email" required="true"/></p>

                    <p><input id="male" type="radio" name="gender" value="male" checked> Male
                        <input id="female" type="radio" name="gender" value="female"> Female</p>
                    <p><label>Date of birth:</label>
                        <input type="text" id="datepicker" name="dob" readonly="true" required="true"></p>

                    <p><label>Title:</label>
                        <input id="title" name="title" class="req-input" type="text"
                               placeholder="title" required="true"/></p>

                    <p><label>State:</label>
                        <input id="state" name="state" class="req-input" type="text"
                               placeholder="state" required="true"/></p>
                    <p><label>Post code:</label>
                        <input id="postCode" name="postCode" class="req-input" type="number"
                               placeholder="post code" required="true"/></p>
                    <p><label>City:</label>
                        <input id="city" name="city" class="req-input" type="text"
                               placeholder="city" required="true"/></p>
                    <p><label>Street:</label>
                        <input id="street" name="street" class="req-input" type="text"
                               placeholder="street" required="true"/></p>

                    <p><label>Phone:</label>
                        <input id="phone" name="phone" class="req-input" type="number"
                               placeholder="phone" required="true"/></p>
                    <p><label>Cell:</label>
                        <input id="cell" name="cell" class="req-input" type="text"
                               placeholder="cell" required="true"/></p>

                    <input id="submitReg" class="submit" type="submit" value="Register">
                    </div>
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