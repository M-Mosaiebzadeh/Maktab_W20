<%--
  Created by IntelliJ IDEA.
  User: Soheil
  Date: 1/26/2021
  Time: 9:45 PM
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

<%--<div class="container">--%>
<%--    <center>    --%>
<%--        <h2>--- Sign Up ---</h2><br>--%>
<%--    </center>--%>
<%--    <form class="form-horizontal" action="detail" method="post">--%>
<%--        <div class="form-group">--%>
<%--            <label class="control-label col-sm-2" for="firstname">Firstname:</label>--%>
<%--            <div class="col-sm-10">--%>
<%--                <input type="text" name="firstname" value="<%=employee.getFirstname()%>" class="form-control" id="firstname">--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="form-group">--%>
<%--            <label class="control-label col-sm-2" for="lastname">Lastname:</label>--%>
<%--            <div class="col-sm-10">--%>
<%--                <input type="text" name="lastname" value="<%=employee.getLastname()%>" class="form-control" id="lastname">--%>
<%--            </div>--%>
<%--        </div>--%>
<%--<div class="form-group">--%>
<%--    <label class="control-label col-sm-2" for="email">Email:</label>--%>
<%--    <div class="col-sm-10">--%>
<%--        <input type="email" name="email" value="<%=employee.getEmail()%>" class="form-control" id="email">--%>
<%--    </div>--%>
<%--</div>--%>
<%--<div class="form-group">--%>
<%--    <label class="control-label col-sm-2" for="fatherName">FatherName:</label>--%>
<%--    <div class="col-sm-10">--%>
<%--        <input type="text" name="fatherName" value="<%=employee.getFatherName()%>" class="form-control" id="fatherName">--%>
<%--    </div>--%>
<%--</div>--%>
<%--<div class="form-group">--%>
<%--    <label class="control-label col-sm-2" for="nationalCode">NationalCode:</label>--%>
<%--    <div class="col-sm-10">--%>
<%--        <input type="text" name="nationalCode" value="<%=employee.getNationalCode()%>" class="form-control"--%>
<%--               id="nationalCode">--%>
<%--    </div>--%>
<%--</div>--%>
<%--<div class="form-group">--%>
<%--    <label class="control-label col-sm-2" for="address">Address:</label>--%>
<%--    <div class="col-sm-10">--%>
<%--        <input type="text" name="address" value="<%=employee.getAddress()%>" class="form-control" id="address">--%>
<%--    </div>--%>
<%--</div>--%>
<%--<div class="form-group">--%>
<%--    <div class="col-sm-offset-2 col-sm-10">--%>
<%--        <button type="submit" name="submit" class="btn btn-success">Save Changes</button>--%>
<%--    </div>--%>
<%--</div>--%>
<%--<div class="form-group">--%>
<%--    <div class="col-sm-offset-2 col-sm-10">--%>
<%--        <button type="submit" name="delete" class="btn btn-danger">Delete</button>--%>
<%--    </div>--%>
<%--</div>--%>
<%--<div class="form-group">--%>
<%--    <div class="col-sm-offset-2 col-sm-10">--%>
<%--        <button type="submit" formaction="show" class="btn btn-primary">Back to Employee List</button>--%>
<%--    </div>--%>
<%--</div>--%>

<%--</form>--%>
<%--</div>--%>


<div class="container">
    <center>
        <h2>--- Sign Up ---</h2><br>
    </center>
    <form class="form-horizontal" action="signUp" method="post">
        <div class="form-group">
            <label class="control-label col-sm-2" for="firstname">Firstname:</label>
            <div class="col-sm-10">
                <input type="text" name="firstname" class="form-control" id="firstname">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="lastname">Lastname:</label>
            <div class="col-sm-10">
                <input type="text" name="lastname" class="form-control" id="lastname">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="phoneNumber">PhoneNumber:</label>
            <div class="col-sm-10">
                <input type="text" name="phoneNumber" class="form-control" id="phoneNumber">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="username">Username:</label>
            <div class="col-sm-10">
                <input type="text" name="username" class="form-control" id="username">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="password">Password:</label>
            <div class="col-sm-10">
                <input type="password" name="password" class="form-control" id="password">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" name="submit" class="btn btn-primary">Sign Up</button>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" formaction="login.jsp" class="btn btn-success">Login</button>
            </div>
        </div>
    </form>
</div>

</body>
</html>
