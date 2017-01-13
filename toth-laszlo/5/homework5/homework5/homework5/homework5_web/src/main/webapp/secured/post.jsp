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
    <title>Off Canvas Template for Bootstrap</title>

    <!-- Latest compiled and minified CSS -->
    <link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" rel="stylesheet">

    

    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath()%>/resources/css/offcanvas.css" rel="stylesheet">

    
  </head>
  
  <nav class="navbar navbar-fixed-top navbar-inverse col-sm-12">
        <div class="container-fluid">
            
            <div class="navbar-header">
                <a class="navbar-brand" href="<%=request.getContextPath()%>/index.jsp">Blog</a>
            </div>
        
        <ul class="nav navbar-nav pull-right">
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">Menu
                    <span class="caret"></span>
                </a>
                <ul class="dropdown-menu pull-right">
                    <li><a href="<%=request.getContextPath()%>/secured/users.jsp">Users</a></li>
                   <li><%
                   if (session.getAttribute("user")==null)
                       out.print("<a href="+request.getServletContext().getContextPath()+"/login.jsp>Login</a>");
                       else  out.print("<a href="+request.getServletContext().getContextPath()+"/Logout>Logout("+session.getAttribute("user")+")</a>");%>
                    </a></li>
                </ul>
            </li>

        
        </ul>
        
        </div>
    </nav><!-- /.navbar -->

  <body>
    <div id="navbar">
    </div>
    
    <div class="container">
        <div class="row centered-form">
        <div class="col-xs-12 col-sm-8 col-md-8 col-sm-offset-2 col-md-offset-2">
            <div class="panel panel-default">
                <div class="panel-heading">
                        <h3 class="panel-title">Post</h3>
                        </div>
                        <div class="panel-body">
                        <form  method="post" action="Post" name="postform" id="postform">
                      
                            <div class="form-group">
                                <label for="header">Header:</label>
                                <input type="text" name="header" id="header" class="form-control input-sm"  required="required">
                            </div>
                            
                            <div class="form-group">
                                <label for="comment">Post:</label>
                                <textarea class="form-control" rows="5" name="text" id="text"></textarea>
                            </div>    
                            
                            <div class="form-group">
                                <label for="tags">tag:</label>
                                <input type="text" name="tags" id="tags" class="form-control input-sm"  required="required">
                            </div>
               
                            <input type="submit" id="post" value="Post" class="btn btn-info btn-block">
                        
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div> 
    

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <!-- Latest compiled and minified JavaScript -->
<script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>

    <script src="<%=request.getContextPath()%>/resources/js/offcanvas.js"></script>
  </body>
</html>
