<%@tag description="blog master" pageEncoding="utf-8" %>
<%@ attribute name="customTitle" fragment="true" %>
<%@ attribute name="customHeader" fragment="true" %>
<%@ attribute name="customBody" fragment="true" %>
<%@ attribute name="customFooter" fragment="true" %>
<%@ attribute name="customScripts" fragment="true" %>

<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>
        <jsp:invoke fragment="customTitle"/>
    </title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/blog.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/my.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/register.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/signin.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap-theme.css"/>">
    <link href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css" rel="stylesheet">
</head>

<body>

<div class="blog-masthead">
    <div class="container">
        <nav class="blog-nav">
            <a class="blog-nav-item" href="<c:url value="/"/>">Home</a> <a
                class="blog-nav-item" href="<c:url value="/public/registration/register.jsp"/>">Register</a>
            <c:if test="${pageContext.request.userPrincipal ==null}">
                <a class="blog-nav-item" href="<c:url value="/public/login/login.jsp"/>">Login</a>
            </c:if>
            <c:if test="${pageContext.request.userPrincipal !=null}">
                <a class="blog-nav-item" href="<c:url value="/logout"/>">Logout</a>
            </c:if>
            <a class="blog-nav-item" href="<c:url value="/secured/secured.jsp"/>">Users</a>
            <sec:authorize access="hasRole('ADMIN')">
                <a class="blog-nav-item" href="<c:url value="/admin/admin.jsp"/>">Admin</a>
            </sec:authorize>
            <c:if test="${pageContext.request.userPrincipal !=null}">
                <div class=" dropdown pull-right">
                    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">
                        <c:out value="${pageContext.request.userPrincipal.name}"></c:out>
                        <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                    </ul>
                </div>
            </c:if>
        </nav>
    </div>
</div>

<div class="container">
    <jsp:invoke fragment="customHeader"/>
    <div class="row">
        <jsp:invoke fragment="customBody"/>
    </div>
</div>

<jsp:invoke fragment="customFooter"/>

<footer class="blog-footer">
    <p>
        Blog template built for <a href="http://getbootstrap.com">Bootstrap</a> by <a
            href="https://twitter.com/mdo">@mdo</a>.
    </p>
    <p>
        <a href="#">Back to top</a>
    </p>
</footer>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
    window.jQuery
    || document
        .write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')
</script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>
<jsp:invoke fragment="customScripts"/>
</body>
</html>