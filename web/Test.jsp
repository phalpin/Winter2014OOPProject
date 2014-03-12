<%-- 
    Document   : Test
    Created on : Mar 12, 2014, 2:56:13 PM
    Author     : phalpin
--%>

<%@page import="PizzaShop.Resources.ActionResult"%>
<%@page import="PizzaShop.Services.UserService"%>
<%@page import="PizzaShop.Models.User"%>
<%@page import="PizzaShop.Models.UserType"%>
<%
  
    User u = new User();
    u.setFirstName("TestFirstName");
    u.setMiddleName("TestMiddleName");
    u.setLastName("TestLastName");
    u.setHomeNumber("3396728564");
    u.setMobileNumber("4687325608");
    u.setUsername("");
    u.setPassword("TESTING123");
    u.setSalt("TESTSALT");
    u.setType(UserType.Customer);
    UserService svc = new UserService();
    ActionResult<User> result = svc.Create(u);
    
%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>

    </body>
</html>
