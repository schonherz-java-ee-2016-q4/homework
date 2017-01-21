<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="masterLayout" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<masterLayout:mastrerLayout>

    <jsp:attribute name="customTitle">
        Users
    </jsp:attribute>

    <jsp:attribute name="customHeader">

        <div class="my-box">
            <h1>Registered users</h1>
        </div>

        <div class="panel panel-primary">
            <div class="panel-heading my-box " id="filter_heading" onclick="on_header_clocked()">
                <h2>filter</h2>

            </div>
            <div class="panel-body" id="filter_body">
                <form class="form-horizontal" id="filter_form" action="" method="get">
                    <div class="form-group">
                        <label for="age" class="col-sm-3 control-label">Age:</label>
                        <div class="col-sm-9">
                            <div>
                                <input type="text" name="age" id="age" placeholder="Age" class="form-control">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email" class="col-sm-3 control-label">E-mail:</label>
                        <div class="col-sm-9">
                            <div>
                                <input type="text" name="email" id="email" placeholder="E-mail" class="form-control">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="city" class="col-sm-3 control-label">City:</label>
                        <div class="col-sm-9">
                            <div>
                                <input type="text" name="city" id="city" placeholder="city" class="form-control">
                            </div>
                        </div>
                    </div>
                    <button class="btn btn-default" type="submit" id="get_user">Filter</button>
                </form>
            </div>
        </div>
    </jsp:attribute>

    <jsp:attribute name="customBody">
        <div id="result"></div>
    </jsp:attribute>

    <jsp:attribute name="customFooter">
        <div class="loader col-sm-offset-6"></div>
        <div id="myModal" class="modal fade" role="dialog"></div>
    </jsp:attribute>

    <jsp:attribute name="customScripts">
        <script src="<c:url value="/resources/js/user.js"/>"></script>
    </jsp:attribute>

</masterLayout:mastrerLayout>
