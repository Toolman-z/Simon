<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
<meta http-equiv="content-type" content="text/html" charset="utf-8">
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="styles/common.css"/>
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
        $(document).ready(function(){
        	query();
        });
        function query(){        	
       	 $("#selEmployees").empty();
       	 var reserveuserid=${user.employeeid}; //取到当前登录账号的id      	 
       	 $.ajax({
       		 url:"/zyx/person",//链接到personServlet
       		 type:"POST",
       		 data:{
       			 reserveuserid:reserveuserid
       		 },
       		 dataType:"json",
       		 success:function(data){ 
       			
       			 /*console(data);*/
       			 var obj='';       			 
       			 for(var i=0;i<data.length;i++){
       				 
      				   var option=data[i];  				   
      				   obj +="<tr>"+
      				   			"<td>"+option.meetingname+"</td>"+
      				   			"<td>"+option.roomname+"</td>"+
      				   			"<td>"+option.meetingstarttime+"</td>"+
      				   			"<td>"+option.meetingendtime+"</td>"+
      				   		    "<td>"+option.reservetime+"</td>"+
      				   			"<td><input type='button' value='修改会议状态' onclick='find("+option.meetingid+","+option.roomid+")'></td>"+
      				   		"</tr>";
      				  };
      				  $("#selEmployees").append(obj);
       		 }
       	 });
       	 
        }  
        function find(meetingid,roomid){
            
       	 window.location.href="/zyx/rep?meetingid="+meetingid+"&roomid="+roomid+"";
        }
        
        </script>
        
        <style type="text/css">
            
        </style>
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
                    个人中心 > 我的预定
                </div>
                <table class="listtable">
                    <caption>我预定的会议：</caption>
                    <thead>
                    <tr class="listheader">
                        <th>会议名称</th>
                        <th>会议室名称</th>
                        <th>会议开始时间</th>
                        <th>会议结束时间</th>
                        <th>会议预定时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody id='selEmployees'>
                    
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