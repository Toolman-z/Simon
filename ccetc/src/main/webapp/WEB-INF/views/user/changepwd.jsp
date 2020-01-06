<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>修改密码</title>
<jsp:include page="../inc.jsp"></jsp:include>
<script>

</script>
</head>
<body>
<div align="center" style="border:solid;width:400px;height:200px;left:470px;position: absolute;border-radius:6px;top:180px;background-color:rgba(170,170,160,0.6);">
<ul style="list-style-type:none;left:15px;position: absolute;">
<li >新 密 码：<input class="easyui-textbox"  style="width:150px;" id="pwd"> </li><br>

<li >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a id="btn" href="#" class="easyui-linkbutton" >修改</a>  &nbsp;&nbsp;&nbsp; <a id="btn" href="#" class="easyui-linkbutton" >重置</a></li><br>
</ul>
 
</div>
</body>
</html>