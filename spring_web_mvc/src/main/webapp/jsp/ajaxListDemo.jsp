<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.0.js"></script>
    <script>
        var userList=new Array();
        userList.push({name:'zhangsan',age:12});
        userList.push({name:'lisi',age:22});
        $.get("${pageContext.request.contextPath}/user/para9",JSON.stringify(userList),function (userList) {
            $("body").html(userList);
        },"json");
    </script>
</head>
<body>

</body>
</html>
