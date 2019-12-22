<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>upload</title>
</head>
<body>
<%--<form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/user/para15">--%>
<%--    <input type="text" name="name"/><br>--%>
<%--    <input type="file" name="uploadFile"/><br>--%>
<%--    <input type="submit" value="sub">--%>
<%--</form>--%>
<form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/user/para16">
    <input type="text" name="name"/><br>
    <input type="file" name="uploadFiles" multiple="multiple"/><br>
    <input type="submit" value="sub">
</form>
</body>
</html>
