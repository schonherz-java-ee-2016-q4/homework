<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="template" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<template:template>

    <jsp:attribute name="title">
    Success
    </jsp:attribute>

    <jsp:attribute name="customHead">
    <link href="<c:url value="/resources/css/my.css"/>" rel="stylesheet">
    </jsp:attribute>

    <jsp:attribute name="customBody">
	    <div class="jumbotron">
			<h1>Registration successful</h1>
			<p>Now you can log in anytime you like!</p>
			<p><a class="btn btn-primary btn-lg" href="<c:url value="/public/login.jsp"/>">Login</a></p>
	    </div>
    </jsp:attribute>
    
    <jsp:attribute name="customFooter">
    </jsp:attribute>
    
    <jsp:attribute name="customScripts">
    </jsp:attribute>

</template:template>
        