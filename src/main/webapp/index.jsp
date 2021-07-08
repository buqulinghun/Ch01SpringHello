<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/4
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>入门程序</h3>
<a href="test/some.do">测试doSome</a>
<br/>

<form action="test/other.do" method="post">
    <input type="submit" value="post请求other.do"/>
</form>
<br/>

<a href="test/any.do">GET方式测试any.do</a>
<br/>


<form action="test/any.do" method="post">
    <input type="submit" value="post请求any.do"/>
</form>
<br/>
</body>
</html>
