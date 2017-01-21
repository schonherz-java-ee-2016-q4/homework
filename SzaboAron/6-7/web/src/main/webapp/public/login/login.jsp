<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="masterLayout" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<masterLayout:mastrerLayout>

    <jsp:attribute name="customTitle">
        Login
    </jsp:attribute>

    <jsp:attribute name="customHeader">
        <div class="col-sm-4"></div>
        <div class="col-sm-6">
            <h2 class="form-signin-heading">Please sign in</h2>
        </div>
    </jsp:attribute>

    <jsp:attribute name="customBody">
        <div class="col-sm-4"></div>
        <form name='loginForm' class="form-signin col-sm-4" action="<c:url value="/login" ></c:url>" method="POST">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" class="form-control"/>

            <c:if test="${not empty error}">
                <div class="alert alert-danger" role="alert">
                    <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span> There was an error!
                </div>

            </c:if>

            <c:if test="${not empty logout}">
                <div class="alert alert-info" role="alert">
                    <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span> You've successfully
                    logged out!
                </div>

            </c:if>
            <label for="username" class="sr-only">Username</label>
            <input type="text" name="username" id="username" class="form-control" placeholder="Email address" required
                   autofocus>
            <label for="password" class="sr-only">Password</label>
            <input type="password" name="password" id="password" class="form-control" placeholder="Password" required>
            <div class="checkbox">
                <label> <input type="checkbox" value="remember-me"> Remember me
                </label>
            </div>
            <input class="btn btn-lg btn-primary btn-block" type="submit" name="submit" value="submit"></input>
        </form>
    </jsp:attribute>

    <jsp:attribute name="customFooter">
    </jsp:attribute>

    <jsp:attribute name="customScripts">
    </jsp:attribute>

</masterLayout:mastrerLayout>
