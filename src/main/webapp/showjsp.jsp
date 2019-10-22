<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="cn.boss.dao.BaseDao" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Tomcat连接池测试,获取数据源 <br>
<%
    BaseDao.getConn();
    out.println("<span style='color:red;'>JNDI测试成功<span>");
%>

<input type="text" name="index">
<span></span>
<script src="https://ajax.aspnetcdn.com/ajax/jquery/jquery-1.9.0.min.js"></script>
<script>
    $(function(){
        $(":input").blur(function(){
            $.ajax({
                url:"EmployeeServlet?index=" + $(":input").val(),
                type:"get",
                success:function(data){
                    alert(data);
                    // $(":input").next().text(JSON.parse(data).info);
                }
            });
        });
    });
</script>
</body>
</html>
