<%--
  Created by IntelliJ IDEA.
  User: Geri
  Date: 2017. 01. 04.
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="genericpage" tagdir="/WEB-INF/tags" %>

<genericpage:genericpage>

    <jsp:attribute name="myTitle">
    Sign in
    </jsp:attribute>
    <jsp:attribute name="myHeader">
        <link href="<c:url value="/resources/css/signin.css"/>" rel="stylesheet">
    </jsp:attribute>
    <jsp:attribute name="myPageTitle">
        <div class="blog-header">
            <h1 class="blog-title">Users!</h1>
            <p class="lead blog-description">Below you can find the user list!</p>
        </div>
    </jsp:attribute>

    <jsp:attribute name="myBody">
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
    <jsp:attribute name="myFooter">
    </jsp:attribute>
    <jsp:attribute name="myScripts">
    </jsp:attribute>

</genericpage:genericpage>