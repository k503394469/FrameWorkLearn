<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>home</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/para8" method="post">
    <input type="text" name="userList[0].name"><br>
    <input type="text" name="userList[0].age"><br>
    <input type="text" name="userList[1].name"><br>
    <input type="text" name="userList[1].age"><br>
    <input type="submit" value="sub">
</form>
</body>
</html>
