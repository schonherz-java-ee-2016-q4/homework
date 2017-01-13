<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<nav class="navbar navbar-fixed-top navbar-inverse col-sm-12">
        <div class="container-fluid">
            
            <div class="navbar-header col-xs-6 col-sm-6 col-md-6">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">Blog</a>
            </div>
        
        <ul class="nav navbar-nav pull-right">
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#"><span  style="color:#B40404" class="glyphicon glyphicon-align-left" aria-hidden="true"></span>
                   
                </a>
                <ul class="dropdown-menu pull-right col-xs-6 col-sm-6 col-md-6">
                    <li><a href="${pageContext.request.contextPath}/secured/users.jsp">Users</a></li>
                    <li><a href="${pageContext.request.contextPath}/secured/post.jsp">Post</a></li>
                   <li><c:if test="${sessionScope.user ==null}">
                    <a class="blog-nav-item" href="${pageContext.request.contextPath}/login.jsp">Login</a>
                </c:if>
                <c:if test="${sessionScope.user !=null}">
                    <a class="blog-nav-item" href="<c:url value="/Logout"/>">Logout(${sessionScope.user})</a>
                </c:if></li>
                </ul>
            </li>

        
        </ul>
        
        </div>
    </nav><!-- /.navbar -->    