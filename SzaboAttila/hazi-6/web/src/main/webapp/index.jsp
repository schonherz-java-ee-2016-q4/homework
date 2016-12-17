<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="template" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<template:template>

	<jsp:attribute name="title">
    Blog
    </jsp:attribute>

	<jsp:attribute name="customHead">
    </jsp:attribute>

	<jsp:attribute name="customBody">
		<div class="blog-header">
			<h1 class="blog-title">Blog</h1>
			<p class="lead blog-description">Log in and select a post!</p>
		</div>

		<div class="row">

            <div class="table-responsive">
			  <table class="table">
			    <thead>
			      <tr>
			        <th>Title</th>
			        <th>Posted</th>
			        <th>Creator</th>
			        <th>Tags</th>
			      </tr>
			    </thead>
			    <tbody id="res_table">
			    </tbody>
			  </table>
			  </div>

		</div>
		<!-- /.row -->
	</jsp:attribute>
	<jsp:attribute name="customFooter">
	</jsp:attribute>
	<jsp:attribute name="customScripts">
	    <script src="<c:url value="/resources/js/index.js"/>"></script>
    </jsp:attribute>

</template:template>

