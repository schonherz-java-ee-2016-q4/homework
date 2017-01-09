<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="template" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<template:template>

    <jsp:attribute name="title">
    Sign in
    </jsp:attribute>

    <jsp:attribute name="customHead">
    <link href="<c:url value="/resources/css/signin.css"/>" rel="stylesheet">
    </jsp:attribute>

    <jsp:attribute name="customBody">
        <div class="row">
            <div class="col-sm-6 col-sm-offset-3">
                <c:if test="${param.error}">
                    <div class="alert alert-danger" role="alert">
                        <span class="glyphicon glyphicon-exclamation-sign"
                            aria-hidden="true"></span> Invalid username or password!
                    </div>
                </c:if>
            </div>
        </div>
        <div class="row">
            <form class="form-signin" action="<c:url value="/login" ></c:url>"
                method="post">
                <h2 class="form-signin-heading">Please sign in</h2>
                <label for="inputEmail" class="sr-only">Username</label>
                <input
                    type="text" name="j_username" id="inputEmail" class="form-control"
                    placeholder="Username" required autofocus>
                <label for="inputPassword" class="sr-only">Password</label>
                <input
                    type="password" name="j_password" id="inputPassword"
                    class="form-control" placeholder="Password" required>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
            </form>
        </div>
    </jsp:attribute>
    
    <jsp:attribute name="customFooter">
    </jsp:attribute>
    
    <jsp:attribute name="customScripts">
    <script>
        $('#nav_login').addClass('active');
    </script>
    </jsp:attribute>

</template:template>
        
