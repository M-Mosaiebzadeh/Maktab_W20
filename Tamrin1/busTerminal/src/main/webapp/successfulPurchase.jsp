<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Soheil
  Date: 1/27/2021
  Time: 12:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<%
    PrintWriter writer = response.getWriter();
    String gender = request.getParameter("gender");
    String fullName = request.getParameter("name");
    Integer ticketId = (Integer) request.getAttribute("ticketId");
    String callGender;
    if (gender.equals("male")){
        callGender = "Mr";
    }
    else {
        callGender = "Ms";
    }

%>
    <h3><% writer.println(callGender + " " + fullName + " Your ticket purchase was successful");
        writer.println("   Ticket ID is : " + ticketId);
    %></h3>

<% request.getRequestDispatcher("userPage.jsp").include(request,response);%>


</body>
</html>
