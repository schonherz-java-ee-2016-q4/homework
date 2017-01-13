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
    <link href="${pageContext.request.contextPath}/resources/css/signin.css" rel="stylesheet">

    
  </head>

  <body>
    <jsp:include page="/WEB-INF/resources/content/navbar.jsp"/>
    
    <div class="container">
      <form class="form-signin" action="login" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <c:if test="${param.error != null}"><div class="alert alert-danger" role="alert">Invalid username or password!</div></c:if>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input  name="user" id="user" class="form-control" placeholder="Username" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password"  name="password" id="password" class="form-control" placeholder="Password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      	  <input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
      </form>
    <div align="center">
        <a href="${pageContext.request.contextPath}/register">Register</a>
    </div>
    </div> <!-- /container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <!-- Latest compiled and minified JavaScript -->
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

  </body>
</html>
