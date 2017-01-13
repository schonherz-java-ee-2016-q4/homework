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
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <title>BlogApp</title>

    <!-- Latest compiled and minified CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/resources/css/offcanvas.css" rel="stylesheet">

    
  </head>

  <body>
    <jsp:include page="/WEB-INF/resources/content/navbar.jsp"/>
    
    <div id=result>
    	<h3><c:forEach items="${users}" var="user">
    		<div class="col-xs-12 col-sm-4 col-lg-3">
    			<div class="panel panel-default">
        			<div align="center"><img class="img-circle" src="${user.picture}" width="140" height="140"></div>
        			<div class="panel-heading" align="center">${user.username}</div>
        				<ul class="list-group">
            				<li class="list-group-item" align="center">${user.email}</li>
            				<li class="list-group-item" align="center">${user.registration_date}</li>
            				<li class="list-group-item" align="center">${user.birth_date}</li>
        				</ul>
    			</div>
			</div>
		</c:forEach></h3>
    
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <!-- Latest compiled and minified JavaScript -->
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

    <script src="${pageContext.request.contextPath}/resources/js/offcanvas.js"></script>
  </body>
</html>
