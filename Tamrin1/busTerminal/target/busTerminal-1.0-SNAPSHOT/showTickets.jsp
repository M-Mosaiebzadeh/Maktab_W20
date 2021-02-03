<%@ page import="java.util.List" %>
<%@ page import="javax.sound.midi.Track" %>
<%@ page import="ir.maktab.busTerminal.entities.Travel" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Soheil
  Date: 1/27/2021
  Time: 10:33 AM
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
    String date = request.getParameter("date");
    String origin = request.getParameter("origin");
    String destination = request.getParameter("destination");

%>

<h5><% writer.println("Route:  " + origin + " - " + destination); %></h5>

<h5><% writer.println("Date of Departure: " + date); %></h5><br><br><br>

<table class="table table-dark">
    <tr>
        <th>
            Choose
        </th>
        <th>
            Departure Time
        </th>
        <th>
            Travel ID
        </th>
    </tr>

    <%
        List<Travel> travelList = (List<Travel>) request.getAttribute("travelList");
    %>

    <%
        for (Travel travel : travelList) {

    %>
    <tr>
        <td>
            <form action="completeBuy.jsp" method="get">
                <%

                    HttpSession session1 = request.getSession();
                    session1.setAttribute("myTravel" + travel.getId(), travel);
                %>
                <input type="hidden" name="travelId" value="<%=travel.getId()%>">
                <input type="submit" name="submit" value="Buy">
            </form>
        </td>
        <td>
            <%= travel.getTime()%>
        </td>
        <td>
            <%= travel.getId()%>
        </td>
    </tr>

    <%

        }
    %>
</table>
<br>
<form class="form-horizontal" action="searchTicket.jsp">
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default"
                    style="background-color: #e7e7e7">Back to Buy Ticket
            </button>
        </div>
    </div>
</form>
<%--    <a href="searchTicket.jsp"> Back to Buy Ticket</a>--%>
</body>
</html>
