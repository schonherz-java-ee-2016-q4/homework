<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="masterLayout" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<masterLayout:mastrerLayout>

    <jsp:attribute name="customTitle">
        Users
    </jsp:attribute>

    <jsp:attribute name="customHeader">

        <div class="my-box">
            <h1>Manage users</h1>
        </div>
    </jsp:attribute>

    <jsp:attribute name="customBody">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Username</th>
                <th>Email</th>
                <th>Enabled</th>
            </tr>
            </thead>
            <tbody id="result"></tbody>
        </table>
    </jsp:attribute>

    <jsp:attribute name="customFooter">
        <div class="loader col-sm-offset-6"></div>
        <div id="myModal" class="modal fade" role="dialog"></div>
    </jsp:attribute>

    <jsp:attribute name="customScripts">
        <script src="<c:url value="/resources/js/admin.js"/>"></script>
    </jsp:attribute>

</masterLayout:mastrerLayout>
