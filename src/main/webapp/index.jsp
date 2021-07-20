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
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        $(function (){
            $("button").click(function(){
               // alert("buton click")
                $.ajax({
                   // url:"test/returnvoid-ajax.do",
                   // url:"test/returnobject-ajax.do",
                   // url:"test/returnobjarray.do",
                    url:"test/returnstring.do",
                    data:{
                        name:"lisi",
                        age:23
                    },
                    type:"post",
                   // dataType:"json",
                    dataType:"text",
                    success:function(resp){
                        //alert(resp);

                        //$.each(resp, function (i, obj){
                        //   alert(obj.name+" "+obj.age)
                       // })

                        alert("resp:"+resp);
                    }
                })
            })
        })
    </script>
</head>
<body>
<h3>入门程序</h3>
<a href="${pageContext.request.contextPath}/test/some.do">测试doSome</a>
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


<h3>参数提交测试</h3>
<form action="test/parmters.do" method="post">
    姓名：<input type="text" name="name"> <br>
    年龄：<input type="text" name="age"> <br>

    <input type="submit" value="提交参数">
</form>


<h3>参数提交测试</h3>
<form action="test/parmters.do" method="post">
    姓名：<input type="text" name="name"> <br>
    年龄：<input type="text" name="age"> <br>

    <input type="submit" value="提交参数">
</form>

<h3>不匹配参数提交测试</h3>
<form action="test/mispatchparmters.do" method="post">
    姓名：<input type="text" name="rname"> <br>
    年龄：<input type="text" name="rage"> <br>

    <input type="submit" value="提交参数">
</form>

<h3>对象接收参数设置</h3>
<form action="test/receiveobject.do" method="post">
    姓名：<input type="text" name="name"> <br>
    年龄：<input type="text" name="age"> <br>

    <input type="submit" value="提交参数">
</form>

<h3>处理器方法返回String</h3>
<form action="test/returnstring.do" method="post">
    姓名：<input type="text" name="name"> <br>
    年龄：<input type="text" name="age"> <br>

    <input type="submit" value="提交参数">
</form>

<br/>

<button id="btn">发起ajax请求</button>

<img src="static/images/p3.jpeg" alt="这是一个静态资源">

</body>
</html>
