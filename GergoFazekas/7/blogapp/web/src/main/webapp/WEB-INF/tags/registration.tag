<%@tag description="Simple page generator" pageEncoding="utf-8" %>
<%@ taglib prefix="genericpage" tagdir="/WEB-INF/tags"%>
<%@ attribute name="myRegistrationForm" fragment="true" %>

<genericpage:genericpage>
    <jsp:attribute name="myTitle">
    Registration
    </jsp:attribute>

    <jsp:attribute name="myPageTitle">
        <div class="blog-header">
            <h1 class="blog-title">Registration!</h1>
            <p class="lead blog-description">Fill the form below to register!</p>
        </div>
    </jsp:attribute>

    <jsp:attribute name="myBody">
        <div class="alert alert-info">
            <strong>Info!</strong> To complete the registration fill all of the
            fields below with valid data, and click on the Submit button! :)
        </div>
        <jsp:invoke fragment="myRegistrationForm" />
    </jsp:attribute>
    <jsp:attribute name="myFooter">
    </jsp:attribute>
    <jsp:attribute name="myScripts">
        <script src="/resources/js/regvalidation.js"></script>
    </jsp:attribute>
</genericpage:genericpage>