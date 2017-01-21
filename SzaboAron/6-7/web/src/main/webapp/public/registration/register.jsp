<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="masterLayout" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<masterLayout:mastrerLayout>

    <jsp:attribute name="customTitle">
        Registration
    </jsp:attribute>

    <jsp:attribute name="customHeader">
        <div class="col-sm-4"></div>
        <div class="col-sm-6">
            <h2 class="form-signin-heading">Registration form</h2>
        </div>
    </jsp:attribute>

    <jsp:attribute name="customBody">
        <div class="col-sm-3"></div>
        <div class="col-sm-6">
        <c:if test="${requestScope.error != null}">
            <div class="alert alert-danger" role="alert">
                <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"/>
                    ${requestScope.error}
            </div>
        </c:if>
            <form class="form-horizontal" role="form" action="<c:url value="/register" />" method="post">
                <div class="form-group">
                    <label for="username" class="col-sm-3 control-label">Username</label>
                    <div class="col-sm-9">
                        <div>
                            <input type="text" id="username" name="username" placeholder="Username"
                                   class="form-control">
                        </div>
                        <div class="alert alert-danger" id="danger_username">
                            <strong>Dont't leave this section empty!</strong>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="title" class="col-sm-3 control-label">Title</label>
                    <div class="col-sm-9">
                        <select id="title" name="title" class="form-control">
                            <option>Ms</option>
                            <option>Mrs</option>
                            <option>Mr.</option>
                            <option>Prof.</option>
                            <option>Dr.</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="firstname" class="col-sm-3 control-label">First Name</label>
                    <div class="col-sm-9">
                        <div>
                            <input type="text" id="firstname" name="firstname" placeholder="First Name"
                                   class="form-control">
                        </div>
                        <div class="alert alert-danger" id="danger_firstname">
                            <strong>Dont't leave this section empty!</strong>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="lastname" class="col-sm-3 control-label">Last Name</label>
                    <div class="col-sm-9">
                        <div>
                            <input type="text" id="lastname" name="lastname" placeholder="Last Name"
                                   class="form-control">
                        </div>
                        <div class="alert alert-danger" id="danger_lastname">
                            <strong>Dont' leave this section empty!</strong>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="email" class="col-sm-3 control-label">Email</label>
                    <div class="col-sm-9">
                        <div>
                            <input type="email" name="email" id="email" placeholder="Email" class="form-control">
                        </div>
                        <div class="alert alert-danger" id="danger_email">
                            <strong>It's not a valid e-mail address!</strong>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="state" class="col-sm-3 control-label">State</label>
                    <div class="col-sm-9">
                        <select id="state" name="state" class="form-control">
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="postcode" class="col-sm-3 control-label">Postcode</label>
                    <div class="col-sm-9">
                        <div>
                            <input type="text" id="postcode" name="postcode" placeholder="Postcode"
                                   class="form-control">
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="city" class="col-sm-3 control-label">City</label>
                    <div class="col-sm-9">
                        <div>
                            <input type="text" id="city" name="city" placeholder="city" class="form-control">
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="street" class="col-sm-3 control-label">Street</label>
                    <div class="col-sm-9">
                        <div>
                            <input type="text" id="street" name="street" placeholder="Street" class="form-control">
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="phone" class="col-sm-3 control-label">Phone</label>
                    <div class="col-sm-9">
                        <div>
                            <input type="text" id="phone" name="phone" placeholder="Phone" class="form-control">
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-3 control-label">Password</label>
                    <div class="col-sm-9">
                        <div>
                            <input type="password" name="password" id="password" placeholder="Password"
                                   class="form-control">
                        </div>
                        <div class="alert alert-danger" id="danger_password">
                            <strong>Dont' leave this section empty!</strong>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="confirm" class="col-sm-3 control-label">Confirm</label>
                    <div class="col-sm-9">
                        <div>
                            <input type="password" id="confirm" placeholder="Confirm Password" class="form-control">
                        </div>
                        <div class="alert alert-danger" id="danger_confirm">
                            <strong>Confirmation failure</strong>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="date" class="col-sm-3 control-label">Birth Date</label>
                    <div class='col-sm-9'>
                        <div>
                            <input type='text' name="birthdate" class="form-control" placeholder="Birth date"
                                   id='date'/>
                        </div>
                        <div class="alert alert-danger" id="danger_date">
                            <strong>It's not a valid date</strong>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-3">Gender</label>
                    <div class="col-sm-6">
                        <div class="row">
                            <div class="col-sm-4">
                                <label class="radio-inline"> <input type="radio" id="femaleRadio" name="gender"
                                                                    value="Female">Female
                                </label>
                            </div>
                            <div class="col-sm-4">
                                <label class="radio-inline"> <input type="radio" id="maleRadio" name="gender"
                                                                    value="Male">Male
                                </label>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-12">
                        <button type="submit" class="btn btn-primary btn-block" id="btn_register">Register</button>
                    </div>
                </div>
            </form>
        </div>

    </jsp:attribute>

    <jsp:attribute name="customFooter">
    </jsp:attribute>

    <jsp:attribute name="customScripts">
        <script src="<c:url value="/resources/js/register.js"/>"></script>
        <script src="<c:url value="https://code.jquery.com/ui/1.12.1/jquery-ui.js"/>"></script>
    </jsp:attribute>

</masterLayout:mastrerLayout>