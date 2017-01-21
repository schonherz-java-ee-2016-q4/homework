<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="masterLayout" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<masterLayout:mastrerLayout>

    <jsp:attribute name="customTitle">
        Access Denied
    </jsp:attribute>

    <jsp:attribute name="customHeader">
    </jsp:attribute>

    <jsp:attribute name="customBody">
        <div class="panel panel-danger">
            <div class="panel-heading">
                <strong>Acces denied</strong>
            </div>
            <div class="panel-body">You can't see this content</div>
        </div>
    </jsp:attribute>

    <jsp:attribute name="customFooter">
    </jsp:attribute>

    <jsp:attribute name="customScripts">
    </jsp:attribute>

</masterLayout:mastrerLayout>