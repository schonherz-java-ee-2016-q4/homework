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
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/resources/css/offcanvas.css" rel="stylesheet">

    
  </head>

  <body>
    <jsp:include page="/resources/content/navbar.jsp"/>
    
    <div class="container">
        <div class="row centered-form">
        <div class="col-xs-12 col-sm-8 col-md-8 col-sm-offset-2 col-md-offset-2">
            <div class="panel panel-default">
                <div class="panel-heading">
                        <h3 class="panel-title">Registration form</h3>
                        </div>
                        <div class="panel-body">
                        <form role="form">
                            <div class="row">
                                <div align="center"><label>Gender and Names</label>
                                </div>
                            </div>
                        
                            <div class="row">
                                <div class="col-xs-2 col-sm-2 col-md-2">
                                    <div class="form-group">
                                        <input type="text" name="gender" id="gender" class="form-control input-sm" placeholder="Gender" required="required">
                                    </div>
                                </div>
                                
                                <div class="col-xs-2 col-sm-2 col-md-2">
                                    <div class="form-group">
                                        <input type="text" name="title" id="title" class="form-control input-sm" placeholder="Title" required="required">
                                    </div>
                                </div>
                            
                                <div class="col-xs-4 col-sm-4 col-md-4">
                                    <div class="form-group">
                                        <input type="text" name="first_name" id="first_name" class="form-control input-sm" placeholder="First Name" required="required">
                                    </div>
                                </div>
                                <div class="col-xs-4 col-sm-4 col-md-4">
                                    <div class="form-group">
                                        <input type="text" name="last_name" id="last_name" class="form-control input-sm" placeholder="Last Name" required="required">
                                    </div>
                                </div>
                                
                                
                            </div>    
                           
                            <div class="row">
                                <div align="center"><label>Username and passwords</label>
                                </div>
                            </div>
                            
                            <div class="row">
                                <div class="col-xs-4 col-sm-4 col-md-4">
                                    <div class="form-group">
                                        <input type="text" name="username" id="username" class="form-control input-sm" placeholder="Username" required="required">
                                    </div>
                                </div>
                                <div class="col-xs-4 col-sm-4 col-md-4">
                                    <div class="form-group">
                                        <input type="password" name="password1" id="password1" class="form-control input-sm" placeholder="password" required="required">
                                    </div>
                                </div>
                                <div class="col-xs-4 col-sm-4 col-md-4">
                                    <div class="form-group">
                                        <input type="password" name="password2" id="password2" class="form-control input-sm" placeholder="password again" required="required" onChange="PasswordMatch();">
                                    </div>
                                </div>
                                
                            </div>
                            
                            
                            <div class="row">
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        <input type="text" name="salt" id="salt" class="form-control input-sm" placeholder="Salt" required="required">
                                    </div>
                                </div>
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        <input type="text" name="md5" id="md5" class="form-control input-sm" placeholder="md5" required="required">
                                    </div>
                                </div>
                            </div>
                            
                            <div class="row">
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        <input type="text" name="sha1" id="sha1" class="form-control input-sm" placeholder="sha1" required="required">
                                    </div>
                                </div>
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        <input type="text" name="sha256" id="sha256" class="form-control input-sm" placeholder="sha256" required="required">
                                    </div>
                                </div>
                            </div>
                            
                            <div class="alert alert-danger hidden" role="alert" id="password_error">
                                <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                                <span class="sr-only">Error:</span>
                                Passwords do not match!
                            </div>
                            
                            <div class="row">
                                <div align="center"><label>Contacts</label>
                                </div>
                            </div>
                            
                            <div class="row">
                                <div class="col-xs-4 col-sm-4 col-md-4">
                                    <div class="form-group">
                                        <input type="email" name="email" id="email" class="form-control input-sm" placeholder="Email" required="required">
                                    </div>
                                </div>
                                
                                <div class="col-xs-4 col-sm-4 col-md-4">
                                    <div class="form-group">
                                        <input type="number" name="phone" id="phone" class="form-control input-sm" placeholder="Phone" required="required">
                                    </div>
                                </div>
                                
                                <div class="col-xs-4 col-sm-4 col-md-4">
                                    <div class="form-group">
                                        <input type="number" name="cell" id="cell" class="form-control input-sm" placeholder="Cell" required="required">
                                    </div>
                                </div>
                                
                            </div>            
                            
                            <div class="row">
                                <div align="center"><label>Location</label>
                                </div>
                            </div>
                            
                            <div class="row">
                                <div class="col-xs-4 col-sm-4 col-md-4">
                                    <div class="form-group">
                                        <input type="text" name="nat" id="nat" class="form-control input-sm" placeholder="Nationality" required="required">
                                    </div>
                                </div>
                                
                                <div class="col-xs-4 col-sm-4 col-md-4">
                                    <div class="form-group">
                                        <input type="text" name="state" id="state" class="form-control input-sm" placeholder="State" required="required">
                                    </div>
                                </div>
                                
                                
                                <div class="col-xs-4 col-sm-4 col-md-4">
                                    <div class="form-group">
                                        <input type="text" name="postcode" id="postcode" class="form-control input-sm" placeholder="Postcode" required="required">
                                    </div>
                                </div>
                            </div>
                            
                            <div class="row">
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        <input type="text" name="city" id="city" class="form-control input-sm" placeholder="City" required="required">
                                    </div>
                                </div>
                                
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        <input type="text" name="street" id="street" class="form-control input-sm" placeholder="Street" required="required">
                                    </div>
                                </div>
                            
                                
                            </div>
                            
                            <div class="row">
                                <div align="center"><label>ID</label>
                                </div>
                            </div>  
                          
                            
                            <div class="row">
                                <div class="col-xs-4 col-sm-4 col-md-4">
                                    <div class="form-group">
                                        <input type="text" name="id_name" id="id_name" class="form-control input-sm" placeholder="ID Name" required="required">
                                    </div>
                                </div>
                                <div class="col-xs-4 col-sm-4 col-md-4">
                                    <div class="form-group">
                                        <input type="text" name="id_value" id="id_value" class="form-control input-sm" placeholder="ID Value" required="required">
                                    </div>
                                </div>
                                
                                <div class="col-xs-4 col-sm-4 col-md-4">
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
                                        <input type="url" name="pic_large" id="pic_large" class="form-control input-sm" placeholder="Large Picture url" required="required">
                                    </div>
                                </div>
                            </div>
                            
                            <div class="row">
                                <div class="col-xs-12 col-sm-12 col-md-12">
                                    <div class="form-group">
                                        <input type="url" name="pic_medium" id="pic_medium" class="form-control input-sm" placeholder="Medium Picture url" required="required">
                                    </div>
                                </div>
                            </div>
                            
                            <div class="row">
                                <div class="col-xs-12 col-sm-12 col-md-12">
                                    <div class="form-group">
                                        <input type="url" name="pic_thumbnail" id="pic_thumbnail" class="form-control input-sm" placeholder="Thumbnail Picture url" required="required">
                                    </div>
                                </div>
                            </div>
                            
                                     
                        
               
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
  </body>
</html>
