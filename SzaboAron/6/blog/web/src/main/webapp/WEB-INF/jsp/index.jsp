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
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Blog Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">


    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/blog.css"/>" rel="stylesheet">


</head>

<body>

<div class="blog-masthead">
    <div class="container">
        <nav class="blog-nav">
            <a class="blog-nav-item active" href="<c:url value="/"/>">Home</a> <a
                class="blog-nav-item" href="<c:url value="/registration/"/>">Register</a>
            <c:if test="${sessionScope.user ==null}">
                <a class="blog-nav-item" href="<c:url value="/login/"/>">Login</a>
            </c:if>
            <c:if test="${sessionScope.user !=null}">
                <a class="blog-nav-item" href="<c:url value="/logout/"/>">Logout</a>
            </c:if>
            <a class="blog-nav-item" href="<c:url value="/users/"/>">Users</a>
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

    <div class="blog-header">
        <h1 class="blog-title">JavaEE Homework Blog</h1>
        <p class="lead blog-description">This is my homework project</p>
    </div>

    <div class="row">
        <c:if test="${sessionScope.user !=null}">
            <div class="panel panel-primary">
                <div class="panel-heading mypanel " id="filter_heading" onclick="on_header_clocked()">
                    <h3>New Post</h3>

                </div>
                <div class="panel-body" id="new_post_form">
                    <form class="form-horizontal" action="/create" method="post" accept-charset="UTF-8">
                        <div class="form-group">
                            <label for="title" class="col-sm-3 control-label">Title</label>
                            <div class="col-sm-9">
                                <div>
                                    <input type="text" name="title" id="title" placeholder="Title" class="form-control">
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="body" class="col-sm-3 control-label">Post</label>
                            <div class="col-sm-9">
                                <div class="">
                                    <textarea class="form-control noresize" id="body" name="body"></textarea>
                                </div>
                            </div>
                        </div>
                        <button class="btn btn-default" type="submit" id="submit_post">Submit</button>
                    </form>
                </div>
            </div>
        </c:if>
        <div class="col-sm-8 blog-main" id="posts"></div>
        <!-- /.blog-main -->


    </div>
    <!-- /.row -->

</div>
<!-- /.container -->

<footer class="blog-footer">
    <p>
        Blog template built for <a href="http://getbootstrap.com">Bootstrap</a> by <a href="https://twitter.com/mdo">@mdo</a>.
    </p>
    <p>
        <a href="#">Back to top</a>
    </p>
</footer>


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
    window.jQuery
    || document
        .write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')
</script>
<script src="../../resources/js/bootstrap.min.js"></script>
<script src="<c:url value="/resources/js/blogpost.js"/>"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
</body>
</html>
