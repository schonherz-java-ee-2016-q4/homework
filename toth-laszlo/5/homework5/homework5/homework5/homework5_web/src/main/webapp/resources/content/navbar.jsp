<nav class="navbar navbar-fixed-top navbar-inverse col-sm-12">
        <div class="container-fluid">
            
            <div class="navbar-header">
                <a class="navbar-brand" href="<c:url value="index.jsp"/>">Blog</a>
            </div>
        
        <ul class="nav navbar-nav pull-right">
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">Menu
                    <span class="caret"></span>
                </a>
                <ul class="dropdown-menu pull-right">
                    <li><a href="<c:url value="secured/users.jsp"/>">Users</a></li>
                    <li><a href="<c:url value="secured/post.jsp"/>">Post</a></li>
                   <li>    <c:if test="${sessionScope.user ==null}">
                    <a class="blog-nav-item" href="<c:url value="login.jsp"/>">Login</a>
                </c:if>
                <c:if test="${sessionScope.user !=null}">
                    <a class="blog-nav-item" href="<c:url value="/Logout"/>">Logout(${sessionScope.user})</a>
                </c:if>
                   </li>
                </ul>
            </li>

        
        </ul>
        
        </div>
    </nav><!-- /.navbar -->    