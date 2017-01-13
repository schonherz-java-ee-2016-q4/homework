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
    
    <div class="container">
        <div class="row centered-form">
        <div class="col-xs-12 col-sm-8 col-md-8 col-sm-offset-2 col-md-offset-2">
            <div class="panel panel-default">
                <div class="panel-heading">
                        <h3 class="panel-title">Registration form</h3>
                        </div>
                        <div class="panel-body">
                        <form role="form" method="post" action="${pageContext.request.contextPath}/registration">    
                       
                            <div class="row">
                                <div align="center"><label>Username and passwords</label>
                                </div>
                            </div>
                            
                            <div class="row">
                                <div class="col-xs-12 col-sm-12 col-md-12">
                                    <div class="form-group">
                                        <input type="text" name="username" id="username" class="form-control input-sm" placeholder="Username" required="required">
                                    </div>
                                </div>
                            </div>
                                <div class="row">
                                	<div class="col-xs-12 col-sm-12 col-md-12">
                                    	<div class="form-group">
                                        	<input type="password" name="password1" id="password1" class="form-control input-sm" placeholder="password" required="required">
                                    	</div>
                                	</div>
                                </div>
                                <div class="row">
                                	<div class="col-xs-12 col-sm-12 col-md-12">
                                    	<div class="form-group">
                                        	<input type="password" name="password2" id="password2" class="form-control input-sm" placeholder="password again" required="required" onChange="PasswordMatch();">
                                    	</div>
                                	</div>
                                </div>
               
                            
                            
                            
                            <div class="alert alert-danger hidden" role="alert" id="password_error">
                                <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                                <span class="sr-only">Error:</span>
                                Passwords do not match!
                            </div>
                            
                            <div class="row">
                                <div align="center"><label>Contact</label>
                                </div>
                            </div>
                            
                            <div class="row">
                                <div class="col-xs-12 col-sm-12 col-md-12">
                                    <div class="form-group">
                                        <input type="email" name="email" id="email" class="form-control input-sm" placeholder="Email" required="required">
                                    </div>
                                </div>
                            </div> 
                              <div class="row">
                                <div align="center"><label>Date of birth</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-12 col-sm-12 col-md-12">
                                    <div class="form-group">
                                        <input type="date" name="dob" id="dob" class="form-control input-sm" placeholder="Date of Birth" required="required">
                                    </div>
                                </div>
                                
                            </div>
                            <div class="row">
                                <div align="center"><label>Pictures</label>
                                </div>
                            </div>
                            
                            <div class="row">
                                <div class="col-xs-12 col-sm-12 col-md-12">
                                    <div class="form-group">
                                        <input type="url" name="pic_thumbnail" id="pic_thumbnail" class="form-control input-sm" placeholder="Thumbnail Picture url" required="required">
                                    </div>
                                </div>
                            </div>
                            <input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
                                     
                        
               
                            <input type="submit" id="submit" value="Register" class="btn btn-info btn-block">
                        
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
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

    <script src="${pageContext.request.contextPath}/resources/js/offcanvas.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/register.js"></script>
  </body>
</html>
