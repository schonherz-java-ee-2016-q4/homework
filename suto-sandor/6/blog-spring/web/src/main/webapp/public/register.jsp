<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Register</title>

<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
    rel="stylesheet">

<link href="<c:url value="/resources/css/reg.css"/>" rel="stylesheet">

<link href="<c:url value="/resources/css/pickadate/classic.css"/>"
    rel="stylesheet">
<link href="<c:url value="/resources/css/pickadate/classic.date.css"/>"
    rel="stylesheet">
<link href="<c:url value="/resources/css/fileinput.min.css"/>"
    rel="stylesheet">


</head>
<body>

    <div class="container">

        <div class="panel panel-default">



            <div class="panel-heading">

                <h1>
                    Registration <small id="panelName"></small>
                </h1>
            </div>

            <c:if test="${requestScope.error != null}">
                <div class="alert alert-danger" role="alert" style="display: block;">
                    <span class="glyphicon glyphicon-exclamation-sign"
                        aria-hidden="true"></span> ${requestScope.error}
                </div>
            </c:if>
            <div class="alert alert-danger" role="alert" id="mail_alert">
                <span class="glyphicon glyphicon-exclamation-sign"
                    aria-hidden="true"></span> E-mail address is invalid!
            </div>
            <div class="alert alert-danger" role="alert" id="passwd_alert">
                <span class="glyphicon glyphicon-exclamation-sign"
                    aria-hidden="true"></span><span id="passwd_alert_text"></span>
            </div>
            <div class="alert alert-danger" role="alert" id="empty_alert">
                <span class="glyphicon glyphicon-exclamation-sign"
                    aria-hidden="true"></span> There are empty fields in the form! Go back...
            </div>

            <form class="form-horizontal"
                action="<c:url value="/Register" ></c:url>" method="post">

                <div id="loginPanel" class="panel-body">

                    <h4 class="list-group-item-heading name">Login details</h4>
                    <div class="form-group">
                        <label for="user_username" class="col-sm-2 control-label">Username</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="user_username"
                                placeholder="Username" name="username">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="user_passw1" class="col-sm-2 control-label">Password</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="user_passw1"
                                placeholder="Password" name="password">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="user_passw2" class="col-sm-2 control-label">Confirm
                            password</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="user_passw2"
                                placeholder="Re-enter Password">
                        </div>
                    </div>

                </div>
                <div id="personalPanel" class="panel-body">

                    <h4 class="list-group-item-heading">Personal details</h4>
                    <div class="form-group">
                        <label for="user_title" class="col-sm-2 control-label">Gender</label>
                        <div class="col-sm-10">

                            <div class="radio">
                                <label> <input type="radio" name="gender"
                                    id="gender_male" value="male">male
                                </label>
                            </div>
                            <div class="radio">
                                <label> <input type="radio" name="gender"
                                    id="gender_female" value="female">female
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="user_title" class="col-sm-2 control-label">Name</label>
                        <div class="col-sm-2">
                            <select class="form-control" name="title">
                                <option value="mr">mr</option>
                                <option value="miss">miss</option>
                                <option value="mrs">mrs</option>
                            </select>
                        </div>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="user_firstName"
                                placeholder="Type First Name" name="firstname">
                        </div>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="user_lastName"
                                placeholder="Type Last Name" name="lastname">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="user_title" class="col-sm-2 control-label">Date
                            of Birth</label>
                        <div class="col-sm-10">
                            <input class="datepicker form-control" id="user_dob" name="dob">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="user_image" class="col-sm-2 control-label">Large Image URL</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="user_image_large"
                                placeholder="Type Image URL" name="image_large">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="user_image" class="col-sm-2 control-label">Medium Image URL</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="user_image_medium"
                                placeholder="Type Image URL" name="image_medium">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="user_image" class="col-sm-2 control-label">Thumbnail Image URL</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="user_image_thumbnail"
                                placeholder="Type Image URL" name="image_thumbnail">
                        </div>
                    </div>


                </div>
                <div id="contactsPanel" class="panel-body">

                    <h4 class="list-group-item-heading">Contacts / Location</h4>
                    <div class="form-group">
                        <label for="user_phone" class="col-sm-2 control-label">Phone
                            number</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="user_phone"
                                placeholder="Phone number" name="phone">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="user_cell" class="col-sm-2 control-label">Mobile
                            number</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="user_cell"
                                placeholder="Mobile number" name="cell">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="user_email" class="col-sm-2 control-label">Email</label>
                        <div class="col-sm-10">
                            <input type="email" class="form-control" id="user_email"
                                placeholder="example@example.com" name="email">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="user_state" class="col-sm-2 control-label">State</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="user_state"
                                placeholder="State" name="state">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="user_postcode" class="col-sm-2 control-label">City</label>
                        <div class="col-sm-3">
                            <input type="number" class="form-control" id="user_postcode"
                                placeholder="Postcode" name="postcode">
                        </div>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="user_city"
                                placeholder="City" name="city">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="user_street" class="col-sm-2 control-label">Street</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="user_street"
                                placeholder="Street" name="street">
                        </div>
                    </div>
                </div>
                <div class="col-sm-4">
                    <button class="btn btn-lg btn-primary btn-block" type="submit" id="register_button">Finish</button>
                </div>
                <br><br><br>
            </form>

            <div class="panel-footer">

                <ul class="pager">
                    <li class="previous"><a href="#" onclick="onBack()"><span class="glyphicon glyphicon-chevron-left"></span> Back</a></li>
                    <li class="next"><a href="#" onclick="onNext()">Next <span class="glyphicon glyphicon-chevron-right"></span></a></li>
                </ul>

            </div>
        </div>
        <!-- panel-end -->

    </div>
    <!-- container-end -->



    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script
        src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
    <script src="<c:url value="/resources/js/picker.js"/>"></script>
    <script src="<c:url value="/resources/js/picker.date.js"/>"></script>
    <script src="<c:url value="/resources/js/reg.js"/>"></script>

</body>
</html>