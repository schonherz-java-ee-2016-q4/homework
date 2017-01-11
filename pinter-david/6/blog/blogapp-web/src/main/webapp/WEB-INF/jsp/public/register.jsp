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


        <title>Signin Template for Bootstrap</title>

        <!-- Bootstrap core CSS -->
        <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">


        <!-- Custom styles for this template -->
        <link href="<c:url value="/resources/css/signin.css"/>" rel="stylesheet">

        <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
        <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
              <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
              <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
            <![endif]-->
    </head>

    <body>

        <div class="container">
            <div class="row">
                <h2>Blog App registration</h2> 

                <form class="form-horizontal" action="<c:url value="/Register" ></c:url>" method="post">
                    <fieldset>

                        <!-- Form segment name -->
                        <legend>Basic information</legend>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label">Gender</label>  
                            <div class="col-md-4">
                                <div class="radio-inline">
                                    <label><input type="radio" name="gender" required="">Male</label>
                                </div>
                                <div class="radio-inline">
                                    <label><input type="radio" name="gender" required="">Female</label>
                                </div>  
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="titleInput">Title</label>  
                            <div class="col-md-4">
                                <input id="titleInput" name="title" placeholder="Insert your Title" class="form-control input-md" type="text">
                                <span class="help-block">Ex.: Mr, Mrs, Miss </span>  
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="firstNameInput">First Name</label>  
                            <div class="col-md-4">
                                <input id="firstNameInput" name="firstName" placeholder="Insert your First Name" class="form-control input-md" required="" type="text">
                                <span class="help-block"> </span>  
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="lastNameInput">Last Name</label>  
                            <div class="col-md-4">
                                <input id="lastNameInput" name="lastName" placeholder="Insert your Last Name" class="form-control input-md" required="" type="text">
                                <span class="help-block"> </span>  
                            </div>
                        </div>

                        <!-- Date input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="dobInput">Date of birth</label>  
                            <div class="col-md-4">
                                <input id="dobInput" name="dateOfBirth" class="form-control input-md" required="" type="date">
                                <span class="help-block"> </span>  
                            </div>
                        </div>

                    </fieldset>
                    <fieldset>

                        <!-- Form segment name -->
                        <legend>Contact information</legend>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="nationalityInput">Nationality</label>  
                            <div class="col-md-4">
                                <input id="nationalityInput" name="nationality" placeholder="Insert your Nationality" class="form-control input-md" required="" type="text">
                                <span class="help-block"> </span>  
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="cityInput">City</label>  
                            <div class="col-md-4">
                                <input id="cityInput" name="city" placeholder="Insert your City" class="form-control input-md" required="" type="text">
                                <span class="help-block"> </span>  
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="streetInput">Street</label>  
                            <div class="col-md-4">
                                <input id="streetInput" name="street" placeholder="Insert your Street" class="form-control input-md" required="" type="text">
                                <span class="help-block"> </span>  
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="stateInput">State</label>  
                            <div class="col-md-4">
                                <input id="stateInput" name="state" placeholder="Insert your State" class="form-control input-md" required="" type="text">
                                <span class="help-block"> </span>  
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="postCodeInput">Post code</label>  
                            <div class="col-md-4">
                                <input id="postCodeInput" name="postCode" placeholder="Insert your post code" class="form-control input-md" required="" type="text">
                                <span class="help-block"> </span>  
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="emailInput">Email</label>  
                            <div class="col-md-4">
                                <input id="emailInput" name="email" placeholder="Insert your Email" class="form-control input-md" required="" type="text">
                                <span class="help-block"> </span>  
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="homePhoneInput">Home phone</label>  
                            <div class="col-md-4">
                                <input id="homePhoneInput" name="homePhone" placeholder="Insert your home phone" class="form-control input-md" required="" type="text">
                                <span class="help-block"> </span>  
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="cellPhoneInput">Cell phone</label>  
                            <div class="col-md-4">
                                <input id="cellPhoneInput" name="cellPhone" placeholder="Insert your cell phone" class="form-control input-md" required="" type="text">
                                <span class="help-block"> </span>  
                            </div>
                        </div>
                    </fieldset>
                    <fieldset>
                        <!-- Form segment name -->
                        <legend>Account information</legend>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="usernameInput">Username</label>  
                            <div class="col-md-4">
                                <input id="usernameInput" name="username" placeholder="Insert your Username" class="form-control input-md" required="" type="text">
                                <span class="help-block"> </span>  
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="passwordInput">Password</label>  
                            <div class="col-md-4">
                                <input id="passwordInput" name="password" placeholder="Insert your Password" class="form-control input-md" required="" type="password">
                                <span class="help-block"> </span>  
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="confirmPasswordInput">Confirm Password</label>  
                            <div class="col-md-4">
                                <input id="confirmPasswordInput" name="confirmPassword" placeholder="Confirm your Password" class="form-control input-md" required="" type="password">
                                <span class="help-block"> </span>  
                            </div>
                        </div>

                        <!-- Button -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="registerButton"> </label>
                            <div class="col-md-4">
                                <button id="registerButton" name="submitRegistration" type="submit" class="btn btn-primary">Submit</button>
                            </div>
                        </div>

                    </fieldset>
                </form>

            </div>
        </div>
        <!-- container end-->



    </body>
</html>
