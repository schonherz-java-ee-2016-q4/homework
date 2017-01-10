<%--
  Created by IntelliJ IDEA.
  User: Geri
  Date: 2017. 01. 05.
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="genericpage" tagdir="/WEB-INF/tags"%>

<genericpage:genericpage>

    <jsp:attribute name="myTitle">
    New post
    </jsp:attribute>

    <jsp:attribute name="myPageTitle">
        <div class="blog-header">
            <h1 class="blog-title">Creating a new post!</h1>
            <p class="lead blog-description">Fill the form below to create a new post!</p>
        </div>
    </jsp:attribute>

    <jsp:attribute name="myBody">
       	<div class="alert alert-info">
            <strong>Info!</strong> You can create a post using the form!
        </div>

		<div class="well">
            <h3 class="text-center">Creating a post</h3>
            <hr>
            <form id="createpost" action="/posts/new" method="post">
                <div class="form-group">
                    <label for="title">Title:</label>
                    <input type="text" class="form-control" id="title" name="title"
                           placeholder="The title of the post..." required>
                </div>
                <div class="form-group">
                    <label for="content">Content:</label>
                    <textarea class="form-control" rows="10" id="content" name="content" placeholder="Content of the post..." required></textarea>
                </div>
                <input class="btn btn-info" type="submit" value="Create a post!">
            </form>
        </div>
    </jsp:attribute>
    <jsp:attribute name="myFooter">
    </jsp:attribute>
    <jsp:attribute name="myScripts">
    </jsp:attribute>

</genericpage:genericpage>


