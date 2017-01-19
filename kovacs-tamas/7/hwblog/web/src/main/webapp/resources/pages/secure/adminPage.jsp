<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="../../favicon.ico">

        <title>Administrator</title>

        <!-- Bootstrap core CSS -->
        <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="<c:url value="/resources/css/blog.css"/>" rel="stylesheet">
    </head>

    <body>

        <form method="POST">
            <input type="text" placeholder="username" name="username"/>
            <select name="role">
                <option value="user">User</option>
                <option value="admin">Admin</option>
            </select>
            <select name="action">
                <option value="grant">Grant</option>
                <option value="remove">Remove</option>
            </select>
            <input type="submit" value="Do"/>
        </form>

    </body>
</html>
