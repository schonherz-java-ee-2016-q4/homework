<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Starter Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">


<!-- Custom styles for this template -->
<link href="<c:url value="/resources/css/blog.css"/>" rel="stylesheet">


<!-- Custom styles for this template -->
<link href="<c:url value="/resources/css/my.css"/>" rel="stylesheet">



<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<div class="blog-masthead" style="background-color:#111111">
		<div class="container">
			<nav class="blog-nav">
				<a class="blog-nav-item " href="<c:url value="/index.jsp"/>">Home</a>
				<c:if test="${sessionScope.user ==null}">
					<a class="blog-nav-item" href="<c:url value="/public/login.jsp"/>">Login</a>
				</c:if>
				<c:if test="${sessionScope.user !=null}">
					<a class="blog-nav-item" href="<c:url value="/Logout"/>">Logout</a>
				</c:if>
				<a class="blog-nav-item active"
					href="<c:url value="/secured/secured.jsp"/>">Users</a>

			</nav>
		</div>
	</div>
    <div class="container">
        <form class="form-horizontal">
        <div class="row">
            <div class="form-group">
                <label for="user_title" class="col-sm-2 control-label">Gender</label>
                
                <div class="col-sm-3 row">
                    <div class="radio col-sm-4">
                        <label> <input type="radio" name="gender" id="gender_male"
                            value="gender_male">male
                        </label>
                    </div>
                    <div class="radio col-sm-4">
                        <label> <input type="radio" name="gender" id="gender_female"
                            value="gender_female">female
                        </label>
                    </div>
                    <div class="radio col-sm-4">
                        <label> <input type="radio" name="gender"
                            id="gender_all" value="gender_all" checked>all
                        </label>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="number">Age:</label>
                        <div class="col-sm-5">
                    <input type="number" class="form-control" id="user_age1"
                        placeholder="from...">
                </div>
                <div class="col-sm-5">
                    <input type="number" class="form-control" id="user_age2"
                        placeholder="to...">
                </div>
            </div>
        
            <div class="form-group">
                <label for="user_title" class="col-sm-2 control-label">Name</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="user_firstName"
                        placeholder="First Name">
                </div>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="user_lastName"
                        placeholder="Last Name">
                </div>
            </div>

            <div class="form-group">
                <label for="user_email" class="col-sm-2 control-label">Email</label>
                <div class="col-sm-10">
                    <input type="email" class="form-control" id="user_email"
                        placeholder="example@example.com">
                </div>
            </div>

            <div class="form-group">
                <label for="user_postcode" class="col-sm-2 control-label">City</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="user_city"
                        placeholder="City">
                </div>
            </div>

            <div class="form-group">

                <div class="col-sm-offset-5 btn-group" role="group" aria-label="...">
                    <button type="button" class="btn btn-primary" id="button_search">Search</button>
                    <button type="button" class="btn btn-default" id="button_clear">Clear</button>
                </div>
            </div>

        </form>

        <div class="row" id="result"></div>
    </div>
    
	<div class="container">
		<div class="row" id="result"></div>
	</div>
	<!-- /.container -->
	<div id="myModal" class="modal fade" role="dialog"></div>


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/resources/js/user.js"/>"></script>
</body>
</html>
