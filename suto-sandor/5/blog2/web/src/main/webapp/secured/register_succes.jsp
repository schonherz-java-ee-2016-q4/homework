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

        <div class="blog-header">
            <h1 class="blog-title" align="center">Registration successful.</h1>
            <h3 align="center">Create your own posts now!</h3>
        </div>
        
    </jsp:attribute>
    
    <jsp:attribute name="customFooter">
    </jsp:attribute>
    
    <jsp:attribute name="customScripts">
    </jsp:attribute>

</template:template>
        