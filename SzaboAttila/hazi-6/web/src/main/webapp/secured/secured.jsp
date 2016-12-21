<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="template" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<template:template>

    <jsp:attribute name="title">
    Users
    </jsp:attribute>

    <jsp:attribute name="customHead">
    <link href="<c:url value="/resources/css/my.css"/>" rel="stylesheet">
    </jsp:attribute>

    <jsp:attribute name="customBody">

		<form class="form-horizontal">
			<div class="form-group">
				<label for="user_title" class="col-sm-2 control-label">Gender</label>
				<div class="col-sm-10">
					<div class="radio">
						<label> <input type="radio" name="gender" id="gender_all"
							value="gender_all" checked>all
						</label>
					</div>
					<div class="radio">
						<label> <input type="radio" name="gender" id="gender_male"
							value="gender_male">male
						</label>
					</div>
					<div class="radio">
						<label> <input type="radio" name="gender"
							id="gender_female" value="gender_female">female
						</label>
					</div>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="number">Age:</label>
				<div class="col-sm-10">
					<input type="number" class="form-control" id="user_age"
						placeholder="Age">
				</div>
			</div>

			<div class="form-group">
				<label for="user_title" class="col-sm-2 control-label">Name</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="user_firstName"
						placeholder="First Name">
				</div>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="user_lastName"
						placeholder="Last Name">
				</div>
			</div>

			<div class="form-group">
				<label for="user_email" class="col-sm-2 control-label">Email</label>
				<div class="col-sm-10">
					<input type="email" class="form-control" id="user_email"
						placeholder="example@example.com">
				</div>
			</div>

			<div class="form-group">
				<label for="user_postcode" class="col-sm-2 control-label">City</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="user_city"
						placeholder="City">
				</div>
			</div>

			<div class="form-group">

				<div class="col-sm-offset-2 btn-group" role="group" aria-label="...">
					<button type="button" class="btn btn-primary" id="button_search">Submit</button>
					<button type="button" class="btn btn-default" id="button_reset">Reset</button>
				</div>
			</div>

		</form>

		<div class="row" id="result"></div>
	</jsp:attribute>
    
    <jsp:attribute name="customFooter">
        <div class="loader col-sm-offset-6"></div>
        <div id="myModal" class="modal fade" role="dialog"></div>
    </jsp:attribute>
    
    <jsp:attribute name="customScripts">
        <script src="<c:url value="/resources/js/user.js"/>"></script>
        <script>
          $('#nav_users').addClass('active');
        </script>
    </jsp:attribute>

</template:template>
