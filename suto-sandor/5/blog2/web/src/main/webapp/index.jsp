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
<link rel="icon" href="../../favicon.ico">

<title>Blog Template for Bootstrap</title>
<!-- ((""    )) -->
<!-- Bootstrap core CSS -->
<link href="<c:url value="resources/css/bootstrap.min.css"/>"
    rel="stylesheet">


<!-- Custom styles for this template -->
<link href="<c:url value="resources/css/blog.css"/>" rel="stylesheet">


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
                <a class="blog-nav-item active" href="<c:url value="/index.jsp"/>">Home</a>

                <c:if test="${sessionScope.user ==null}">
                    <a class="blog-nav-item" href="<c:url value="/public/login.jsp"/>">Login</a>
                    <a class="blog-nav-item" href="<c:url value="/public/register.jsp"/>">Register</a>
                </c:if>
                <c:if test="${sessionScope.user !=null}">
                    <a class="blog-nav-item" href="<c:url value="/Logout"/>">Logout</a>
                </c:if>
                <c:if test="${sessionScope.user !=null}">
                    <a class="blog-nav-item" href="<c:url value="/secured/create_blogpost.jsp"/>">Create Post</a>
                </c:if>
                <a class="blog-nav-item"
                    href="<c:url value="/secured/secured.jsp"/>">Users</a>

            </nav>
        </div>
    </div>

    <div class="container">

        <div class="blog-header">
            <h1 class="blog-title">The Bootstrap Blog</h1>
            <p class="lead blog-description">The official example template of
                creating a blog with Bootstrap.</p>
        </div>

        <div class="row">

            <div class="col-sm-8 blog-main">
                <div id="res_post_heads"></div>
                
                <!-- /.blog-post -->

                <nav>
                    <ul class="pager">
                        <li><a href="#">Previous</a></li>
                        <li><a href="#">Next</a></li>
                    </ul>
                </nav>

            </div>
            <!-- /.blog-main -->

            <div class="col-sm-3 col-sm-offset-1 blog-sidebar">
                <div class="sidebar-module sidebar-module-inset">
                    <h4>About</h4>
                    <p>
                        This is the 5th homework, made by Sandor Suto.
                    </p>
                </div>
                <div class="sidebar-module">
                    <h4>Archives</h4>
                    <ol class="list-unstyled">
                        <li><a href="#">March 2014</a></li>
                        <li><a href="#">February 2014</a></li>
                        <li><a href="#">January 2014</a></li>
                        <li><a href="#">December 2013</a></li>
                        <li><a href="#">November 2013</a></li>
                        <li><a href="#">October 2013</a></li>
                        <li><a href="#">September 2013</a></li>
                        <li><a href="#">August 2013</a></li>
                        <li><a href="#">July 2013</a></li>
                        <li><a href="#">June 2013</a></li>
                        <li><a href="#">May 2013</a></li>
                        <li><a href="#">April 2013</a></li>
                    </ol>
                </div>
                <div class="sidebar-module">
                    <h4>Elsewhere</h4>
                    <ol class="list-unstyled">
                        <li><a href="https://github.com/schonherz-java-ee-2016-q4">GitHub</a></li>
                        <li><a href="https://twitter.com/schonherz">Twitter</a></li>
                        <li><a href="https://www.facebook.com/getbootstrap/?fref=ts">Facebook</a></li>
                    </ol>
                </div>
            </div>
            <!-- /.blog-sidebar -->

        </div>
        <!-- /.row -->

    </div>
    <!-- /.container -->

    <footer class="blog-footer">
        <p>
            Blog template built for <a href="http://getbootstrap.com">Bootstrap</a>
            by <a href="https://twitter.com/mdo">@mdo</a>.
        </p>
        <p>
            <a href="#">Back to top</a>
        </p>
    </footer>


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script
        src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>
        window.jQuery
                || document
                        .write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')
    </script>
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="<c:url value="/resources/js/index.js"/>"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
</body>
</html>
