<%--
  Created by IntelliJ IDEA.
  User: Geri
  Date: 2017. 01. 04.
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="genericpage" tagdir="/WEB-INF/tags"%>

<genericpage:genericpage>

    <jsp:attribute name="myTitle">
    Blog
    </jsp:attribute>

    <jsp:attribute name="myPageTitle">
        <div class="blog-header">
            <h1 class="blog-title">Welcome!</h1>
            <p class="lead blog-description">This is a simple blog app!</p>
        </div>
    </jsp:attribute>

    <jsp:attribute name="myBody">
        <div class="row">
        <c:forEach var="post" items="${posts}">
            <div class="blog-post">
                <h2 class="blog-post-title"><a href="/posts/${post.id}">${post.title}</a></h2>
                <p class="blog-post-meta">
                    published by ${post.authorID}
                </p>
                <p>${post.content}</p>
            </div>
        </c:forEach>
        </div>
       <div class="col-sm-8 blog-main">
           <nav>
               <ul class="pager">
                   <li><a href="#">Previous</a></li>
                   <li><a href="#">Next</a></li>
               </ul>
           </nav>
       </div>
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
    <jsp:attribute name="myFooter">
    </jsp:attribute>
    <jsp:attribute name="myScripts">
    </jsp:attribute>

</genericpage:genericpage>

