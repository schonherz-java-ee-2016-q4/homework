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
            <h2 class="blog-post-title">Create post</h2>
            </div>
    

        <form class="form-horizontal"
                action="<c:url value="/CreatePost" ></c:url>" method="post">
           <div class="form-group">
               <div class="col-sm-2">
                    <label for="post_title" class="control-label">Title</label>
               </div>
               <div class="col-sm-10">
                   <input type="text" class="form-control" id="post_title"
                       placeholder="Give a title to your post!" name="title" required>
               </div>
           </div>
           <div class="form-group">
               <div class="col-sm-2">
	               <label for="post_content" class="control-label">Content</label>
	               <p class="blog-post-meta">
	               You can use Markdown to make your post pretty!
	               <a href="https://markdown-it.github.io/">Here</a> is a link to the syntax.
	               </p>
               </div>
               <div class="col-sm-10">
                   <textarea class="form-control" rows="8" id="comment" id="post_content"
                       placeholder="Write your post here..." name="content" required></textarea>
                   
               </div>
           </div>
           <div class="form-group">
               <div class="col-sm-2">
                    <label for="post_tags" class="control-label">Tags</label>
                    <p class="blog-post-meta">Separate tags with comma!</p>
               </div>
               <div class="col-sm-10">
                   <input type="text" class="form-control" id="post_tags"
                       placeholder="Write tags to your post (separate them with comma)" name="tags" required>
               </div>
           </div>
           
            <button class="btn btn-lg btn-primary btn-block" type="submit" id="post_submit">Submit</button>
        </form>
        
    </jsp:attribute>
    
    <jsp:attribute name="customFooter">
    </jsp:attribute>
    
    <jsp:attribute name="customScripts">
         <script>
        $('#nav_create_post').addClass('active');
        </script>
    </jsp:attribute>

</template:template>
        