<%--
  Created by IntelliJ IDEA.
  User: Soheil
  Date: 1/27/2021
  Time: 11:24 AM
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
    String travelId = request.getParameter("travelId");
    HttpSession session1 = request.getSession(false);
    session1.setAttribute("myTravel",session1.getAttribute("myTravel"+travelId));

%>

<div class="container">

    <form class="form-horizontal" action="finalConfirm" method="post">
        <div class="form-group">
            <label class="control-label col-sm-2" for="name">Full name:</label>
            <div class="col-sm-10">
                <input type="text" name="name" class="form-control" id="name">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="female">Female:</label>
            <div class="col-sm-10">
                <input type="radio" id="female" name="gender" >
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="male">Male:</label>
            <div class="col-sm-10">
                <input type="radio" id="male" name="gender">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" name="submit" class="btn btn-default" style="background-color: #e7e7e7">Confirm</button>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" name="submit" formaction="searchTicket.jsp" class="btn btn-default" style="background-color: #e7e7e7">Back to Search Ticket</button>
            </div>
        </div>
    </form>
</div>

</body>
</html>
