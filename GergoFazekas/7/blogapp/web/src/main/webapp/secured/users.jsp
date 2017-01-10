<%--
  Created by IntelliJ IDEA.
  User: Geri
  Date: 2017. 01. 05.
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="genericpage" tagdir="/WEB-INF/tags"%>

<genericpage:genericpage>

    <jsp:attribute name="myTitle">
    Users
    </jsp:attribute>

    <jsp:attribute name="myPageTitle">
        <div class="blog-header">
            <h1 class="blog-title">Users!</h1>
            <p class="lead blog-description">Below you can find the user list!</p>
        </div>
    </jsp:attribute>

    <jsp:attribute name="myBody">
        <c:forEach var="user" items="${users}">
            <div class="col-xs-12 col-sm-6 col-md-4 well">
                <img class="img-circle" src="${user.mediumPicture}">
                <h3>${user.firstName} ${user.lastName}</h3>
                <p>
                    <span class="glyphicon glyphicon-user"></span>: ${user.username}
                </p>
                <p>
                    <span class="glyphicon glyphicon-earphone"></span>: ${user.phone}
                </p>
                <p>
                    <span class="glyphicon glyphicon-envelope"></span>: ${user.email}
                </p>
                <p>
                    <span class="glyphicon glyphicon-eye-open"></span>: ${user.gender}
                </p>
                <p>
                    <span class="glyphicon glyphicon-share"></span>: ${user.active ? "active" : "inactive"}
                </p>
                <p>
                    <span class="glyphicon glyphicon-wrench"></span>: ${user.role}
                </p>
                <p>
                    <form action="<c:url value="/admin/users/changeStatus"/>" method="get">
                        <input class="btn btn-danger" type="submit" name="id" value="${user.id}"/>
                    </form>
                </p>
            </div>
        </c:forEach>
    </jsp:attribute>
    <jsp:attribute name="myFooter">
    </jsp:attribute>
    <jsp:attribute name="myScripts">
    </jsp:attribute>

</genericpage:genericpage>


