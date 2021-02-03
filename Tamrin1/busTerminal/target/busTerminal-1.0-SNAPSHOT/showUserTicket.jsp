<%@ page import="java.util.List" %>
<%@ page import="ir.maktab.busTerminal.entities.Ticket" %><%--
  Created by IntelliJ IDEA.
  User: Soheil
  Date: 1/27/2021
  Time: 3:29 PM
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
<br>
<h2>Buying Ticket List</h2>
<br>
<table  class="table table-striped">
    <tr>
        <td>
            Choose
        </td>
        <td>
            Ticket ID
        </td>
        <td>
            Date
        </td>
    </tr>

    <%
        List<Ticket> tickets = (List<Ticket>) request.getAttribute("tickets");
        for (Ticket ticket:tickets) {

    %>
    <tr>
        <td>
            <a href="fullDetailTicket?action=show&ticket=<%=ticket.getId()%>">Show Detail</a>
        </td>
        <td>
            <%= ticket.getId()%>
        </td>
        <td>
            <%= ticket.getTravel().getDate()%>
        </td>
    </tr>

    <%

        }
    %>
</table>
<br>
<h4><a href="userPage.jsp">Back To Home</a></h4>

</body>
</html>
