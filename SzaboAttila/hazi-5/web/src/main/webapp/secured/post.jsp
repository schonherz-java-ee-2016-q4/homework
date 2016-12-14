<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="template" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<template:template>

    <jsp:attribute name="title">
    Create Post
    </jsp:attribute>

    <jsp:attribute name="customHead">
    <link href="<c:url value="/resources/css/my.css"/>" rel="stylesheet">
    </jsp:attribute>

    <jsp:attribute name="customBody">

        <div class="blog-header">
            <h2 class="blog-post-title" id="post_title"></h2>
            <p class="blog-post-meta">
                <span id="post_date"></span> by <a href="#" id="post_name"  onclick="showModal();"
                data-toggle="modal" data-target="#myModal"></a>
            </p>
        </div>

        <div class="blog-post" id="post_content" style="white-space:pre-wrap;"></div>
        
        <p class="blog-post-meta">
            Tags: <span id="post_tags"></span>
        </p>

    </jsp:attribute>
    
    <jsp:attribute name="customFooter">
    <div id="myModal" class="modal fade" role="dialog"></div>
    </jsp:attribute>
    
    <jsp:attribute name="customScripts">
    <script src="<c:url value="/resources/js/blogReader.js"/>"></script>
    </jsp:attribute>

</template:template>