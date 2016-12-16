<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    
    <title>Signin Template for Bootstrap</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">


    <link href="resources/css/signin.css" rel="stylesheet">

  </head>

  <body>
<nav class="navbar navbar-fixed-top navbar-inverse col-sm-12">
        <div class="container-fluid">
            
            <div class="navbar-header">
                <a class="navbar-brand" href="<%=request.getContextPath()%>/index.jsp">Blog</a>
            </div>
        
        <ul class="nav navbar-nav pull-right">
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">Menu
                    <span class="caret"></span>
                </a>
                <ul class="dropdown-menu pull-right">
                    <li><a href="<%=request.getContextPath()%>/secured/users.jsp">Users</a></li>
                   <li><%
                   if (session.getAttribute("user")==null)
                       out.print("<a href="+request.getServletContext().getContextPath()+"/login.jsp>Login</a>");
                       else  out.print("<a href="+request.getServletContext().getContextPath()+"/Logout>Logout("+session.getAttribute("user")+")</a>");%>
                    </a></li>
                </ul>
            </li>

        
        </ul>
        
        </div>
    </nav><!-- /.navbar -->  

    <div class="container">

      <form class="form-signin" action="LoginServlet" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input  name="user" id="inputUser" class="form-control" placeholder="Username" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password"  name="pass" id="inputPassword" class="form-control" placeholder="Password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>
    <div align="center">
        <a href="register.jsp" align=>Register</a>
    </div>
    </div> <!-- /container -->
    
    
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
  </body>
</html>
