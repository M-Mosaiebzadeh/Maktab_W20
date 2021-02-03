<%--
  Created by IntelliJ IDEA.
  User: Soheil
  Date: 1/26/2021
  Time: 6:18 PM
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

<div class="container">

    <form class="form-horizontal" action="searchTicket" method="get">
        <div class="form-group">
            <label class="control-label col-sm-2" for="origin">Choose a origin:</label>
            <div class="col-sm-10">
                <select name="origin" id="origin" class="form-control">
                    <option value="TEHRAN">TEHRAN</option>
                    <option value="MAZANDARAN">MAZANDARAN</option>
                    <option value="ESFEHAN">ESFEHAN</option>
                    <option value="MARKAZI">MARKAZI</option>
                    <option value="QOM">QOM</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="destination">Choose a destination:</label>
            <div class="col-sm-10">
                <select name="destination" id="destination" class="form-control">
                    <option value="TEHRAN">TEHRAN</option>
                    <option value="MAZANDARAN">MAZANDARAN</option>
                    <option value="ESFEHAN">ESFEHAN</option>
                    <option value="MARKAZI">MARKAZI</option>
                    <option value="QOM">QOM</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="date">Date:</label>
            <div class="col-sm-10">
                <input type="date" name="date" class="form-control" id="date">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" name="submit" class="btn btn-default" style="background-color: #e7e7e7">Search Ticket</button>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" name="submit" formaction="userPage.jsp" class="btn btn-default" style="background-color: #e7e7e7">Back to Home</button>
            </div>
        </div>
    </form>
</div>

</body>
</html>