<%@ page import="java.util.List" %>
<%@ page import="ir.maktab.employeeServlet.entities.Employee" %><%--
  Created by IntelliJ IDEA.
  User: Soheil
  Date: 1/26/2021
  Time: 11:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ٍShow Employee</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<%--    <table class="table table-striped">--%>
<div class="container">
    <table class="table table-hover">
        <tr>
            <th>
                Firstname
            </th>
            <th>
                Lastname
            </th>
            <th>
                Email
            </th>
            <th>
                Detail
            </th>

        </tr>
        <%
            List<Employee> employeeList = (List<Employee>) request.getAttribute("list");
        %>
        <%
            for (Employee employee:employeeList) {

        %>
        <tr>
            <td>
                <%= employee.getFirstname()%>
            </td>
            <td>
                <%= employee.getLastname()%>
            </td>
            <td>
                <%= employee.getEmail()%>
            </td>
            <td>
                <form action="EmployeeDetails.jsp" method="get">
                    <input type="hidden" name="employeeId" value="<%=employee.getId()%>">
                    <input type="submit" name="submit" value="Detail">
                </form>
            </td>
        </tr>

        <%

            }
        %>

    </table>
</div>
<br>

<%--<div class="container">--%>
<%--    <form action="index.html">--%>
<%--        <button type="submit" class="btn btn-primary">Back to Home </button>--%>
<%--        <button type="submit" formaction="save.html" class="btn btn-success">Back to Save Employee </button>--%>
<%--    </form>--%>
<%--</div>--%>

<div class="container">
    <form action="index.html">
        <button type="submit" class="btn btn-default">Back to Home </button>
        <button type="submit" formaction="save.html" class="btn btn-default">Back to Save Employee </button>
    </form>
</div>

<%--<div class="col-sm-offset-2 col-sm-10">--%>
<%--    <button type="submit" formaction="save.html" class="btn btn-default">Back to Home </button>--%>
<%--</div>--%>
</body>
</html>
