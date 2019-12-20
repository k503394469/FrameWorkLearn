<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.0.js"></script>
    <script>
        var userList=new Array();
        userList.push({name:'张三',age:12});
        userList.push({name:'lisi',age:22});
        <%--$.post("${pageContext.request.contextPath}/user/para9",{userList:JSON.stringify(userList)},function (userList) {--%>
        <%--    $("body").append(userList)--%>
        <%--},"json");--%>
        $.ajax({
            type:"POST",
            url:"${pageContext.request.contextPath}/user/para9",
            data:JSON.stringify(userList),
            contentType:"application/json;charset=utf-8",
            success:function (data) {
                for (let i = 0; i < data.length; i++) {
                    $("body").append(data[i].name);
                    $("body").append(data[i].age);
                }
            }
        })
    </script>
</head>
<body>

</body>
</html>
