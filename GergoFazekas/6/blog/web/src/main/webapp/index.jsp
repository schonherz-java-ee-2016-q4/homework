<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="genericpage" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<genericpage:genericpage>

    <jsp:attribute name="title">
    Blog
    </jsp:attribute>

    <jsp:attribute name="customPageTitle">
        <div class="blog-header">
            <h1 class="blog-title">Welcome!</h1>
            <p class="lead blog-description">This is a simple blog app!</p>
        </div>
    </jsp:attribute>

    <jsp:attribute name="customBody">
       <div class="col-sm-8 blog-main">
                <div class="row" id="result"></div>
                <nav>
                    <ul class="pager">
                        <li><a href="#">Previous</a></li>
                        <li><a href="#">Next</a></li>
                    </ul>
                </nav>
            </div>
            <!-- /.blog-main -->

            <div class="col-sm-3 col-sm-offset-1 blog-sidebar">
                <div class="sidebar-module sidebar-module-inset">
                    <h4>About</h4>
                    <p>
                        Etiam porta <em>sem malesuada magna</em> mollis euismod. Cras
                        mattis consectetur purus sit amet fermentum. Aenean lacinia
                        bibendum nulla sed consectetur.
                    </p>
                </div>
                <div class="sidebar-module">
                    <h4>Archives</h4>
                    <ol class="list-unstyled">
                        <li><a href="#">March 2014</a></li>
                        <li><a href="#">February 2014</a></li>
                        <li><a href="#">January 2014</a></li>
                        <li><a href="#">December 2013</a></li>
                        <li><a href="#">November 2013</a></li>
                        <li><a href="#">October 2013</a></li>
                        <li><a href="#">September 2013</a></li>
                        <li><a href="#">August 2013</a></li>
                        <li><a href="#">July 2013</a></li>
                        <li><a href="#">June 2013</a></li>
                        <li><a href="#">May 2013</a></li>
                        <li><a href="#">April 2013</a></li>
                    </ol>
                </div>
                <div class="sidebar-module">
                    <h4>Elsewhere</h4>
                    <ol class="list-unstyled">
                        <li><a href="#">GitHub</a></li>
                        <li><a href="#">Twitter</a></li>
                        <li><a href="#">Facebook</a></li>
                    </ol>
                </div>
            </div>
            <!-- /.blog-sidebar -->
    </jsp:attribute>
    <jsp:attribute name="customFooter">
    </jsp:attribute>
    <jsp:attribute name="customScripts">
        <script src="<c:url value="/resources/js/post.js"/>"></script>
    </jsp:attribute>

</genericpage:genericpage>