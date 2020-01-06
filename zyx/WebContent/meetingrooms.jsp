<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import ="java.util.List"%>
<%@ page import =" com.zyx.Model.Meetingroom"%>
<%@ page import ="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
<meta http-equiv="content-type" content="text/html" charset="gb2312">
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="styles/common.css"/>
         <script type="text/javascript" src="JS/jquery-3.0.0.js"></script>
        <script type="text/javascript" >
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
       function op(id){    	 
    		 window.location.href="/zyx/try?roomid="+id+"";    		    	   
        	/*$.ajax({
        		url:"/zyx/roomchange",//连接到MeetingchangeServlet
        		type:"GET",
        		data:{
        			roomid:id
        		},
        		dataType:"text",
        		success:function(data){
        			if(data=="true"){        				
        			location.href="/zyx/roomchange?id="+id+"";
        			}else{
        				alert("查询失败");
        			}
        		}
        	});*/        	   	
        } 
        
        function chaxun(){
        	var x= document.getElementById("chaxun");
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
                    会议预定 > 查看会议室
                </div>
                <%
                Object obj= request.getAttribute("meetingroomlist");
                List<Meetingroom> meetingroomlist = new ArrayList<Meetingroom>();
                if(obj != null){
                	meetingroomlist = (List<Meetingroom>)obj;
                }
                %>
                <table class="listtable">
                    <caption>所有会议室:</caption> 
                    <form action="imge" method="get"> <!-- 连接到MeetingroomServlet -->
                    <input type="submit" value="查询所有会议室" >  
                   </form>
                    <thead>
                    <tr class="listheader">
                        <th>门牌编号</th>
                        <th>会议室名称</th>
                        <th>容纳人数</th>
                        <th>当前状态</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                    for(Meetingroom meetingroom : meetingroomlist){
                    	if(meetingroom.getStatus()==0){
                    	out.write("<tr>");
                    	out.write("<td>"+meetingroom.getRoomnum()+"</td>");                   	
                    	out.write("<td>"+meetingroom.getRoomname()+"</td>");
                    	out.write("<td>"+meetingroom.getCapacity()+"</td>");
                    	out.write("<td>关闭</td>");
                    	out.write("<td><input type='button' onclick='op("+meetingroom.getRoomid()+")' value='查看详情'/></td>");                    	
                    	out.write("</tr>");}else if(meetingroom.getStatus()==1){
                    		out.write("<tr>");
                        	out.write("<td>"+meetingroom.getRoomnum()+"</td>");                   	
                        	out.write("<td>"+meetingroom.getRoomname()+"</td>");
                        	out.write("<td>"+meetingroom.getCapacity()+"</td>");
                        	out.write("<td>启用</td>");
                        	out.write("<td><input type='button' onclick='op("+meetingroom.getRoomid()+")' value='查看详情'/></td>");                    	
                        	out.write("</tr>");
                    	}
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