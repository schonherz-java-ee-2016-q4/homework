<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="genericpage" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<genericpage:genericpage>

	<jsp:attribute name="title">
    Registration
    </jsp:attribute>

	<jsp:attribute name="customPageTitle">
        <div class="blog-header">
            <h1 class="blog-title">Registration</h1>
<!--             <p class="lead blog-description"></p> -->
        </div>
    </jsp:attribute>

	<jsp:attribute name="customBody">
            <div class="alert alert-info">
            <strong>Info!</strong> To complete the registration fill all of the
            fields below with valid data, and click on the Submit button! :)
        </div>
        <form id="registration" method="post" action="/Blog/Register">
            <div class="wellregister">
                <h3 class="text-center">Basic info</h3>
                <div class="row">
                    <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group">
                            <label>First Name</label> <input type="text"
								name="firstname" id="firstname" class="form-control input-sm"
								placeholder="First Name" required>
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group">
                            <label>Last Name</label> <input type="text"
								name="lastname" id="lastname" class="form-control input-sm"
								placeholder="Last Name" required>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group">
                            <label>Gender</label><br>
                            <label class="radio-inline"> <input
								type="radio" name="gender" value="female" checked>Female
                            </label> <label class="radio-inline"> <input
								type="radio" name="gender" value="male">Male
                            </label>
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group">
                            <label>Date of birth</label> <input
								type="text" name="dob" id="dob" class="form-control input-sm"
								placeholder="Date of birth" required>
                        </div>
                    </div>
                </div>
                <div class="alert alert-danger" id="alertbasic"></div>
            </div>
            <div class="wellregister">
                <h3 class="text-center">Location info</h3>
                <div class="row">
                    <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group">
                            <label>State</label> <input type="text"
								name="state" id="state" class="form-control input-sm"
								placeholder="State" required>
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group">
                            <label>Postcode</label> <input type="text"
								name="postcode" id="postcode" class="form-control input-sm"
								placeholder="Postcode" required>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group">
                            <label>City</label> <input type="text"
								name="city" id="city" class="form-control input-sm"
								placeholder="City" required>
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group">
                            <label>Street</label> <input type="text"
								name="street" id="dob" class="form-control input-sm"
								placeholder="Street" required>
                        </div>
                    </div>
                </div>
                <div class="alert alert-danger" id="alertlocation"></div>
            </div>
            <div class="wellregister">
                <h3 class="text-center">Login info</h3>
                <div class="row">
                    <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group">
                            <label>E-mail</label> <input type="text"
								name="email" id="email" class="form-control input-sm"
								placeholder="E-mail" required>
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group">
                            <label>Username</label> <input type="text"
								name="username" id="username" class="form-control input-sm"
								placeholder="Username" required>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group">
                            <label>Password</label> <input
								type="password" name="password1" id="password1"
								class="form-control input-sm" placeholder="Password" required>
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group">
                            <label>Password again</label> <input
								type="password" name="password2" id="password2"
								class="form-control input-sm" placeholder="Password again"
								required>
                        </div>
                    </div>
                </div>
                <div class="alert alert-danger" id="alertlogin"></div>
            </div>
            <div class="wellregister">
                <h3 class="text-center">Picture info</h3>
                <div class="row">
                    <div class="col-xs-12 col-md-4">
                        <div class="form-group">
                            <label>Large picture URL</label> <input
								type="text" name="large" id="large"
								class="form-control input-sm" placeholder="Large URL" required>
                        </div>
                    </div>
                    <div class="col-xs-12 col-md-4">
                        <div class="form-group">
                            <label>Medium picture URL</label> <input
								type="text" name="medium" id="medium"
								class="form-control input-sm" placeholder="Medium URL" required>
                        </div>
                    </div>
                    <div class="col-xs-12 col-md-4">
                        <div class="form-group">
                            <label>Thumbnail picture URL</label> <input
								type="text" name="thumbnail" id="thumbnail"
								class="form-control input-sm" placeholder="Thumbnail URL">
                        </div>
                    </div>
                </div>
                <div class="alert alert-danger" id="alertpicture"></div>
            </div>
            <!--            <button class="btn btn-lg btn-success pull-right" type="submit" id="btn_submit">Submit!</button> -->
            <input type="submit" value="Submit"
				class="btn btn-lg btn-success pull-right">
        </form>
    </jsp:attribute>
	<jsp:attribute name="customFooter">
    </jsp:attribute>
	<jsp:attribute name="customScripts">
        <script src="<c:url value="/resources/js/register.js"/>"></script>
    </jsp:attribute>

</genericpage:genericpage>