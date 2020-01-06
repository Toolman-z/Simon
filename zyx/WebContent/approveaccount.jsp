<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import ="java.util.List"%>
<%@ page import =" com.zyx.Model.Register"%>
<%@ page import ="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
<meta http-equiv="content-type" content="text/html" charset="gb2312">
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="styles/common.css"/>
        <style type="text/css">           
        </style>
         <script type="text/javascript" src="JS/jquery-3.0.0.js"></script>
         <script type="text/javascript">
         $(document).ready(function(){
       	  var you=${user.employeeid};
       	  $.ajax({
       		  url:"/zyx/who",
       		  type:"POST",
       		  data:{
       			  you:you
       		  },
       		  dataType:"json",
       		  success:function(data){
       			  var obj='';       			 
        			 for(var i=0;i<data.length;i++){     				 
       				   var option=data[i];  				   
       				   obj +="<span>"+option.realname+"</span>";
       				  };
       				  $("#who").append(obj);
       		  }
       	  });
         });
         function pass(p){
        	 $.ajax({
        		 url:"passdelt",
        		 type:"POST",
        		 data:{
        			 id:p
        		 },
        		 dataType:"text",
        		 success:function(data){
        			 if(data=="true"){
        				 alert("成功");
        				 select();
        				
        			 }else{
        				 alert("失败");
        			 }
        		 }
        	 });
         }
         function delt(d){
        	 var re=confirm("你确定要删除吗");
        	 if(re == true){
        	 $.ajax({
        		 url:"passdelt",
        		 type:"GET",
        		 data:{
        			 id:d
        		 },
        		 dataType:"text",
        		 success:function(data){
        			 if(data=="true"){
        				 alert("删除成功");
        				 select();
        				
        			 }else{
        				 alert("删除失败");
        			 }
        		 }
        	 });
        	 }else{
        		 
        	 }        	        	 
         }
         function select(){       	
        	 var x= document.getElementById("s");
         	x.submit();
         }
         </script>
    </head>
    <body>
    
        <div class="page-header">
            <div class="header-banner">
                <img src="images/header.png" alt="CoolMeeting"/>
            </div>
            <div class="header-title">
                欢迎访问Cool-Meeting会议管理系统
            </div>
            <div class="header-quicklink">
                欢迎您，<strong id="who"></strong>
                <a href="changepassword.jsp">[修改密码]</a>
            </div>
        </div>
        <div class="page-body">
            <div class="page-sidebar">
                <div class="sidebar-menugroup">
                    <div class="sidebar-grouptitle">个人中心</div>
                    <ul class="sidebar-menu">
                        <li class="sidebar-menuitem"><a href="notifications.jsp">最新通知</a></li>
                        <li class="sidebar-menuitem active"><a href="mybookings.jsp">我的预定</a></li>
                        <li class="sidebar-menuitem"><a href="mymeetings.jsp">我的会议</a></li>
                    </ul>
                </div>
                <div class="sidebar-menugroup">
                    <div class="sidebar-grouptitle">人员管理</div>
                    <ul class="sidebar-menu">
                        <c:if test="${user.role == 0}"><li class="sidebar-menuitem"><a href="departments.jsp">部门管理</a></li></c:if>
                        <li class="sidebar-menuitem"><a href="register.jsp">员工注册</a></li>
                        <c:if test="${user.role == 0}"><li class="sidebar-menuitem"><a href="approveaccount.jsp">注册审批</a></li></c:if>
                        <c:if test="${user.role == 0}"><li class="sidebar-menuitem"><a href="searchemployees.jsp">搜索员工</a></li></c:if>
                    </ul>
                </div>
                <div class="sidebar-menugroup">
                    <div class="sidebar-grouptitle">会议预定</div>
                    <ul class="sidebar-menu">
                        <c:if test="${user.role == 0}"><li class="sidebar-menuitem"><a href="addmeetingroom.jsp">添加会议室</a></li></c:if>
                        <li class="sidebar-menuitem"><a href="meetingrooms.jsp">查看会议室</a></li>
                        <li class="sidebar-menuitem"><a href="bookmeeting.jsp">预定会议</a></li>
                        <li class="sidebar-menuitem"><a href="searchmeetings.jsp">搜索会议</a></li>
                    </ul>
                </div>
            </div>
            <div class="page-content">
                <div class="content-nav">
                    人员管理 > 注册审批
                </div>
                 <%
                Object obj= request.getAttribute("registerlist");
                List<Register> registerlist = new ArrayList<Register>();
                if(obj != null){
                	registerlist = (List<Register>)obj;
                }
                %>
                <form action="find" method="post" id="s">
                <input type="submit" value="查询所有信息" />
                </form>
                <table class="listtable">
                    <caption>所有待审批注册信息：</caption>                                      
                    <tr class="listheader">
                        <th>姓名</th>
                        <th>账号名</th>
                        <th>联系电话</th>
                        <th>电子邮件</th>
                        <th>操作</th>
                    </tr>                                       
                    <tbody>
                     <%                    
                    for(Register register : registerlist){
                    	out.write("<tr>");
                    	out.write("<td>"+register.getRealname()+"</td>"); 
                    	out.write("<td>"+register.getUsername()+"</td>"); 
                    	out.write("<td>"+register.getPhone()+"</td>");
                    	out.write("<td>"+register.getEmail()+"</td>"); 
                    	out.write("<td><input type='button' class='clickbutton' value='通过' onclick='pass("+register.getEmployeeid()+")'><input type='button' class='clickbutton' value='删除' onclick='delt("+register.getEmployeeid()+")'></td>");                     	
                    	out.write("</tr>");                    	
                    }                                                        
                    %>
                    </tbody>                   
                </table>
            </div>
        </div>
        <div class="page-footer">
            <hr/>
            更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a>
            <img src="images/footer.png" alt="CoolMeeting"/>
        </div>
    </body>
</html>