<%--
  Created by IntelliJ IDEA.
  User: Geri
  Date: 2017. 01. 04.
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="genericpage" tagdir="/WEB-INF/tags" %>

<genericpage:registration>
    <jsp:attribute name="myRegistrationForm">
        <form name="regForm" method="post" onsubmit="return(validate());" action="/users/new">
            <div class="well">
                <h3 class="text-center">Basic info</h3>
                <div class="row">
                    <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group">
                            <label>First Name</label>
                            <input type="text" name="firstname" id="firstname" class="form-control input-sm"
                                   placeholder="First Name">
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group">
                            <label>Last Name</label>
                            <input type="text" name="lastname" id="lastname" class="form-control input-sm"
                                   placeholder="Last Name">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group">
                            <label>Gender</label><br>
                            <label class="radio-inline">
                                <input type="radio" name="gender" value="female" checked>Female
                            </label>
                            <label class="radio-inline"> <input type="radio" name="gender" value="male">Male
                            </label>
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group">
                            <label>Date of birth</label>
                            <input type="text" name="dob" id="dob" class="form-control input-sm"
                                   placeholder="Date of birth">
                        </div>
                    </div>
                </div>
                <div class="alert alert-danger" id="alertbasic"></div>
            </div>
            <div class="well">
                <h3 class="text-center">Location info</h3>
                <div class="row">
                    <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group">
                            <label>State</label>
                            <input type="text" name="state" id="state"
                                   class="form-control input-sm" placeholder="State" >
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group">
                            <label>Postcode</label>
                            <input type="text" name="postcode" id="postcode" class="form-control input-sm"
                                   placeholder="Postcode" >
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group">
                            <label>City</label>
                            <input type="text" name="city" id="city"
                                   class="form-control input-sm" placeholder="City" >
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group">
                            <label>Street</label>
                            <input type="text" name="street" id="street"
                                   class="form-control input-sm" placeholder="Street" >
                        </div>
                    </div>
                </div>
                <div class="alert alert-danger" id="alertlocation"></div>
            </div>
            <div class="well">
                <h3 class="text-center">Login info</h3>
                <div class="row">
                    <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group">
                            <label>E-mail</label>
                            <input type="text" name="email" id="email"
                                   class="form-control input-sm" placeholder="E-mail" >
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group">
                            <label>Username</label>
                            <input type="text" name="username" id="username" class="form-control input-sm"
                                   placeholder="Username" >
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group">
                            <label>Password</label>
                            <input type="password" name="password1" id="password1" class="form-control input-sm"
                                   placeholder="Password" >
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group">
                            <label>Password again</label>
                            <input type="password" name="password2" id="password2" class="form-control input-sm"
                                   placeholder="Password again" >
                        </div>
                    </div>
                </div>
                <div class="alert alert-danger" id="alertlogin"></div>
            </div>
            <div class="well">
                <h3 class="text-center">Picture info</h3>
                <div class="row">
                    <div class="col-xs-12 col-md-4">
                        <div class="form-group">
                            <label>Large picture URL</label>
                            <input type="text" name="large" id="large" class="form-control input-sm" placeholder="Large URL"
                                   >
                        </div>
                    </div>
                    <div class="col-xs-12 col-md-4">
                        <div class="form-group">
                            <label>Medium picture URL</label>
                            <input type="text" name="medium" id="medium" class="form-control input-sm"
                                   placeholder="Medium URL" >
                        </div>
                    </div>
                    <div class="col-xs-12 col-md-4">
                        <div class="form-group">
                            <label>Thumbnail picture URL</label>
                            <input type="text" name="thumbnail" id="thumbnail" class="form-control input-sm"
                                   placeholder="Thumbnail URL">
                        </div>
                    </div>
                </div>
                <div class="alert alert-danger" id="alertpicture"></div>
            </div>
            <!--            <button class="btn btn-lg btn-success pull-right" type="submit" id="btn_submit">Submit!</button> -->
            <input type="submit" value="Submit" class="btn btn-lg btn-success pull-right">
        </form>
    </jsp:attribute>
</genericpage:registration>