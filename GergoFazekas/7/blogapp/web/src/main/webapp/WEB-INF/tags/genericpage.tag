<%@tag description="Simple page generator" pageEncoding="utf-8" %>
<%@ attribute name="myTitle" fragment="true" %>
<%@ attribute name="myHeader" fragment="true" %>
<%@ attribute name="myBody" fragment="true" %>
<%@ attribute name="myFooter" fragment="true" %>
<%@ attribute name="myScripts" fragment="true" %>
<%@ attribute name="myPageTitle" fragment="true" %>

<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="/resources/css/bootstrap-theme.css" rel="stylesheet"/>
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="/resources/css/blog.css" rel="stylesheet"/>
    <title>
        <jsp:invoke fragment="myTitle"/>
    </title>

</head>
<body>
<div class="blog-masthead">
    <div class="container">
        <nav class="blog-nav">
            <a class="blog-nav-item active" href="<c:url value="/index.jsp"/>">Home</a>

            <c:if test="${pageContext.request.userPrincipal == null}">
                <a class="blog-nav-item" href="<c:url value="/public/login.jsp"/>">Login</a>
            </c:if>
            <c:if test="${pageContext.request.userPrincipal == null}">
                <a class="blog-nav-item"
                   href="<c:url value="/public/registration.jsp"/>">Registration</a>
            </c:if>
            <c:if test="${pageContext.request.userPrincipal != null}">
                <a class="blog-nav-item" href="<c:url value="/logout"/>">Logout</a>
            </c:if>
            <c:if test="${pageContext.request.userPrincipal != null}">
                <a class="blog-nav-item"
                   href="<c:url value="/secured/users"/>">Users</a> <a
                    class="blog-nav-item"
                    href="<c:url value="/admin/newpost.jsp"/>">Create Post</a>
            </c:if>
        </nav>
    </div>
</div>
<div class="container">
    <jsp:invoke fragment="myPageTitle"/>
    <div class="row">
        <jsp:invoke fragment="myBody"/>
    </div>
</div>
<footer class="blog-footer">
    <p>
        Blog template built for <a href="http://getbootstrap.com">Bootstrap</a>
        by <a href="https://twitter.com/mdo">@mdo</a>.
    </p>
    <p>
        <a href="#">Back to top</a>
    </p>
</footer>
<jsp:invoke fragment="myFooter"/>

<script
        src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
    window.jQuery
    || document
        .write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')
</script>
<script src="/resources/js/bootstrap.min.js"></script>
<jsp:invoke fragment="myScripts"/>
</body>
</html>
