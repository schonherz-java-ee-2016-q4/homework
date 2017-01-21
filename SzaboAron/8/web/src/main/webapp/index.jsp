<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="masterLayout" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<masterLayout:mastrerLayout>

    <jsp:attribute name="customTitle">
        Blog
    </jsp:attribute>


    <jsp:attribute name="customHeader">
        <div class="blog-header">
            <h1 class="blog-title">JavaEE Homework Blog</h1>
            <p class="lead blog-description">This is my homework project</p>
        </div>
    </jsp:attribute>

    <jsp:attribute name="customBody">
        <c:if test="${pageContext.request.userPrincipal !=null}">
            <div class="panel panel-primary">
                <div class="panel-heading mypanel " id="filter_heading" onclick="on_header_clocked()">
                    <h3>New Post</h3>

                </div>
                <div class="panel-body" id="new_post_form">
                    <form class="form-horizontal" accept-charset="UTF-8" id="create_post" action="/create"
                          method="post">
                        <div class="form-group">
                            <label for="title" class="col-sm-3 control-label">Title</label>
                            <div class="col-sm-9">
                                <div>
                                    <input type="text" name="title" id="title" placeholder="Title"
                                           class="form-control">
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="body" class="col-sm-3 control-label">Post</label>
                            <div class="col-sm-9">
                                <div class="">
                                    <textarea class="form-control noresize" id="body" name="body"></textarea>
                                </div>
                            </div>
                        </div>
                        <button class="btn btn-default" type="submit" id="submit_post">Submit</button>
                    </form>
                </div>
            </div>
        </c:if>
            <div class="col-sm-8 blog-main" id="posts"></div>
    </jsp:attribute>

    <jsp:attribute name="customFooter">
    </jsp:attribute>
    <jsp:attribute name="customScripts">
        <script src="/resources/js/blogpost.js"></script>
    </jsp:attribute>
</masterLayout:mastrerLayout>