<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="masterLayout" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<masterLayout:mastrerLayout>

    <jsp:attribute name="customTitle">
        ${postModel.title}
    </jsp:attribute>

    <jsp:attribute name="customHeader">
    </jsp:attribute>

    <jsp:attribute name="customBody">
       <div class="panel panel-default">
           <div class="panel-heading"><h2 class="blog-post-title">${postModel.title}</h2></div>
           <div class="panel-body blog-post">${postModel.body}</div>
           <div class="panel-footer"><p class="blog-post-meta">${postModel.date} ${postModel.username}</p></div>
       </div>
    </jsp:attribute>

    <jsp:attribute name="customFooter">
    </jsp:attribute>

    <jsp:attribute name="customScripts">
    </jsp:attribute>

</masterLayout:mastrerLayout>