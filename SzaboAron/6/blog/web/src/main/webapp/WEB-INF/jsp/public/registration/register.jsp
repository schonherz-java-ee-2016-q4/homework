<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">


    <title>Register</title>
    <script src="<c:url value="/resources/js/jquery-3.1.1.min.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.js"/>"></script>
    <script src="<c:url value="/resources/js/register.js"/>"></script>
    <script src="<c:url value="https://code.jquery.com/ui/1.12.1/jquery-ui.js"/>"></script>
    <link href="<c:url value="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"/>" rel="stylesheet">

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">

    <link href="<c:url value="/resources/css/register.css"/>" rel="stylesheet">

    <link href="<c:url value="/resources/css/blog.css"/>" rel="stylesheet">


    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/my.css"/>" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]>
    <script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="blog-masthead">
    <div class="container">
        <nav class="blog-nav">
            <a class="blog-nav-item " href="<c:url value="/"/>">Home</a> <a
                class="blog-nav-item active" href="<c:url value="/registration/"/>">Register</a>
            <c:if test="${sessionScope.user ==null}">
                <a class="blog-nav-item" href="<c:url value="/login/"/>">Login</a>
            </c:if>
            <c:if test="${sessionScope.user !=null}">
                <a class="blog-nav-item" href="<c:url value="/logout/"/>">Logout</a>
            </c:if>
            <a class="blog-nav-item" href="<c:url value="/users"/>">Users</a>
            <c:if test="${sessionScope.user !=null}">
                <div class="dropdown pull-right">
                    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">
                        <c:out value="${sessionScope.user.username}"></c:out>
                        <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                    </ul>
                </div>

            </c:if>

        </nav>
    </div>
</div>
<div class="container">
    <div class="col-sm-6 col-sm-offset-3">
        <c:if test="${requestScope.error != null}">
            <div class="alert alert-danger" role="alert">
                <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span> ${requestScope.error}
            </div>

        </c:if>
    </div>
</div>
<div class="container">
    <form class="form-horizontal" role="form" action="<c:url value="/registration/register" ></c:url>" method="post">
        <h2>Registration Form</h2>

        <div class="form-group">
            <label for="username" class="col-sm-3 control-label">Username</label>
            <div class="col-sm-9">
                <div>
                    <input type="text" id="username" name="username" placeholder="Username" class="form-control">
                </div>
                <div class="alert alert-danger" id="danger_username">
                    <strong>Dont't leave this section empty!</strong>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label for="title" class="col-sm-3 control-label">Title</label>
            <div class="col-sm-9">
                <select id="title" name="title" class="form-control">
                    <option>Ms</option>
                    <option>Mrs</option>
                    <option>Mr.</option>
                    <option>Prof.</option>
                    <option>Dr.</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="firstname" class="col-sm-3 control-label">First Name</label>
            <div class="col-sm-9">
                <div>
                    <input type="text" id="firstname" name="firstname" placeholder="First Name" class="form-control">
                </div>
                <div class="alert alert-danger" id="danger_firstname">
                    <strong>Dont't leave this section empty!</strong>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label for="lastname" class="col-sm-3 control-label">Last Name</label>
            <div class="col-sm-9">
                <div>
                    <input type="text" id="lastname" name="lastname" placeholder="Last Name" class="form-control">
                </div>
                <div class="alert alert-danger" id="danger_lastname">
                    <strong>Dont' leave this section empty!</strong>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label for="email" class="col-sm-3 control-label">Email</label>
            <div class="col-sm-9">
                <div>
                    <input type="email" name="email" id="email" placeholder="Email" class="form-control">
                </div>
                <div class="alert alert-danger" id="danger_email">
                    <strong>It's not a valid e-mail address!</strong>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label for="state" class="col-sm-3 control-label">State</label>
            <div class="col-sm-9">
                <select id="state" name="state" class="form-control">
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="postcode" class="col-sm-3 control-label">Postcode</label>
            <div class="col-sm-9">
                <div>
                    <input type="text" id="postcode" name="postcode" placeholder="Postcode" class="form-control">
                </div>
                <!--                     <div class="alert alert-danger" id="danger_firstname"> -->
                <!--                         <strong>Dont't leave this section empty!</strong> -->
            </div>
        </div>
        <div class="form-group">
            <label for="city" class="col-sm-3 control-label">City</label>
            <div class="col-sm-9">
                <div>
                    <input type="text" id="city" name="city" placeholder="city" class="form-control">
                </div>
                <!--                     <div class="alert alert-danger" id="danger_firstname"> -->
                <!--                         <strong>Dont't leave this section empty!</strong> -->
            </div>
        </div>
        <div class="form-group">
            <label for="street" class="col-sm-3 control-label">Street</label>
            <div class="col-sm-9">
                <div>
                    <input type="text" id="street" name="street" placeholder="Street" class="form-control">
                </div>
                <!--                     <div class="alert alert-danger" id="danger_firstname"> -->
                <!--                         <strong>Dont't leave this section empty!</strong> -->
            </div>
        </div>
        <div class="form-group">
            <label for="phone" class="col-sm-3 control-label">Phone</label>
            <div class="col-sm-9">
                <div>
                    <input type="text" id="phone" name="phone" placeholder="Phone" class="form-control">
                </div>
                <!--                     <div class="alert alert-danger" id="danger_firstname"> -->
                <!--                         <strong>Dont't leave this section empty!</strong> -->
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-3 control-label">Password</label>
            <div class="col-sm-9">
                <div>
                    <input type="password" name="password" id="password" placeholder="Password" class="form-control">
                </div>
                <div class="alert alert-danger" id="danger_password">
                    <strong>Dont' leave this section empty!</strong>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label for="confirm" class="col-sm-3 control-label">Confirm</label>
            <div class="col-sm-9">
                <div>
                    <input type="password" id="confirm" placeholder="Confirm Password" class="form-control">
                </div>
                <div class="alert alert-danger" id="danger_confirm">
                    <strong>Confirmation failure</strong>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label for="date" class="col-sm-3 control-label">Birth Date</label>
            <div class='col-sm-9'>
                <div>
                    <input type='text' name="birthdate" class="form-control" placeholder="Birth date" id='date'/>
                </div>
                <div class="alert alert-danger" id="danger_date">
                    <strong>It's not a valid date</strong>
                </div>
            </div>
        </div>
        <!-- /.form-group -->
        <div class="form-group">
            <label class="control-label col-sm-3">Gender</label>
            <div class="col-sm-6">
                <div class="row">
                    <div class="col-sm-4">
                        <label class="radio-inline"> <input type="radio" id="femaleRadio" name="gender" value="Female">Female
                        </label>
                    </div>
                    <div class="col-sm-4">
                        <label class="radio-inline"> <input type="radio" id="maleRadio" name="gender" value="Male">Male
                        </label>
                    </div>
                </div>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-12">
                <button type="submit" class="btn btn-primary btn-block" id="btn_register">Register</button>
            </div>
        </div>
    </form>
</div>


</body>
</html>