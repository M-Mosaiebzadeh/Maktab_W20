<%@ page import="ir.maktab.busTerminal.entities.Ticket" %><%--
  Created by IntelliJ IDEA.
  User: Soheil
  Date: 1/27/2021
  Time: 5:40 PM
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
Ticket ticket = (Ticket) request.getAttribute("ticket");

%>
<table class="table table-striped">
    <tr>
        <td>
            Ticket ID
        </td>
        <td>
            Full Name
        </td>
        <td>
            Gender
        </td>
        <td>
            Origin
        </td>
        <td>
            Destination
        </td>
        <td>
            Date
        </td>
        <td>
            Time
        </td>
        <td>
            Travel ID
        </td>
    </tr>
    <tr>
        <td>
            <%= ticket.getId()%>
        </td>
        <td>
            <%= ticket.getName()%>
        </td>
        <td>
            <%= ticket.getGender()%>
        </td>
        <td>
            <%= ticket.getTravel().getOrigin()%>
        </td>
        <td>
            <%= ticket.getTravel().getDestination()%>
        </td>
        <td>
            <%= ticket.getTravel().getDate()%>
        </td>
        <td>
            <%= ticket.getTravel().getTime()%>
        </td>
        <td>
            <%= ticket.getTravel().getId()%>
        </td>
        <td>
            <form action="cancelTicket" method="get">
                <input type="hidden" name="cancel" value="<%= ticket.getId()%>">
                <input type="submit" name="submit" value="Cancel Ticket">
            </form>
        </td>
    </tr>

</table>
<br>
<h4><a href="showUserTicket">Back to My Ticket</a></h4>
</body>
</html>
