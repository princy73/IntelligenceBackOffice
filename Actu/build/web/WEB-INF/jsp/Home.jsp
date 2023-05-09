<%-- 
    Document   : Home
    Created on : 27 janv. 2023, 16:50:53
    Author     : ASUS
--%>
<% String str=request.getAttribute("test").toString();
    out.print(str);
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Home</h1>
        <a href="Actu/Login">Back</a>
    </body>
</html>
