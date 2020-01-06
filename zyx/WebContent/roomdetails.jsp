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
      function change(id){ 
    	  if(checkall()){    	  
    	  $.ajax({
    		  url:"/zyx/roomchange",//连接到MeetingroomchangeServlet
    		  type:"POST",
    		  data:{
    			  roomid:id,
    			  roomnum:$("#roomnum").val(),
    			  roomname:$("#roomname").val(),
    			  capacity:$("#capacity").val(),
    			  status:$("input[name='status']:checked").val(),
    			  remark:$("#remark").val()
    		  },
    		  dataType:"text",
    		  success: function(data){
    			  if(data=="true"){
    				  alert("修改成功");
    				  window.location.href="meetingrooms.jsp";
    			  }else{
    				  alert("修改失败");
    			  }
    			  
    		  }
    	  });
    	  }else{
    		  alert("请完整填写信息");
    	  }
      }
         
         function checkall(){
        	 var roomnum=$("#roomnum").val();
        	 var roomname=$("#roomname").val();
        	 var capacity=$("#capacity").val();
        	 var remark=$("#remark").val();
        	 if(roomnum == "" || roomname == "" || capacity == "" || remark == ""){
        		 return false;
        	 }else{
        		 return true;
        	 }
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
                    会议预定 > 修改会议室信息
                </div>
                
                    <fieldset>
                        <legend>会议室信息</legend>
                <%
                Object obj= request.getAttribute("meetingroomlist");
                List<Meetingroom> meetingroomlist = new ArrayList<Meetingroom>();
                if(obj != null){
                	meetingroomlist = (List<Meetingroom>)obj;
                }
                %>
                        <table class="formtable">
                        <tbody>
                            <tr>
                                <td>门牌号:</td>
                                <td>
                                    <%  for(Meetingroom meetingroom : meetingroomlist){                                    	
                                    	out.write("<input type='text' value='"+meetingroom.getRoomnum()+"' maxlength='10' id='roomnum'/>"); }
                                    %>                                   	                                    
                                </td>
                            </tr>
                            <tr>
                                <td>会议室名称:</td>
                                <td>
                                     <%  for(Meetingroom meetingroom : meetingroomlist){
                                    	out.write("<input type='text' value='"+meetingroom.getRoomname()+"' id='roomname'/>"); }
                                    %>
                                </td>
                            </tr>
                            <tr>
                                <td>最多容纳人数：</td>
                                <td>
                                    <%  for(Meetingroom meetingroom : meetingroomlist){
                                    	out.write("<input type='text' value='"+meetingroom.getCapacity()+"' id='capacity'/>"); }
                                    %>
                                </td>
                            </tr>
                            <tr>
                                <td>当前状态：</td>
                               
                                 <%  for(Meetingroom meetingroom : meetingroomlist){
                                	 if(meetingroom.getStatus()==1){
                                		 out.write("<td>");
                                    	out.write("<input type='radio' checked='checked' value='1' id='status' class='status' name='status'/><label for='status'>启用</label>");
                                    	out.write("<input type='radio'  value='0' id='status' class='status' name='status'/><label for='status'>停用</label>");
                                    	out.write("<input type='radio'  value='-1' id='status' class='status' name='status'/><label for='status'>删除</label>");
                                    	out.write("</td>");
                                	 }else if(meetingroom.getStatus()==0){
                                		 out.write("<td>");
                                		 out.write("<input type='radio'  value='1' id='status' class='status' name='status'/><label for='status'>启用</label>");
                                     	out.write("<input type='radio' checked='checked' value='0' id='status' class='status' name='status'/><label for='status'>停用</label>");
                                     	out.write("<input type='radio'  value='-1' id='status' class='status' name='status'/><label for='status'>删除</label>");
                                     	out.write("</td>");
                                	 }else if(meetingroom.getStatus()==-1){
                                		 out.write("<td>");
                                		 out.write("<input type='radio'  value='1' id='status' class='status' name='status'/><label for='status'>启用</label>");
                                     	out.write("<input type='radio'  value='0' id='status' class='status' name='status'/><label for='status'>停用</label>");
                                     	out.write("<input type='radio'  value='-1' id='status' class='status' name='status' checked='checked'/><label for='status'>已删除</label>");
                                     	out.write("</td>");
                                	 }
                                    	}
                                 %>                                                                  
                            </tr>
                            <tr>
                                <td>备注：</td>
                                <td>
                                 <%  for(Meetingroom meetingroom : meetingroomlist){
                                    	out.write("<textarea id='remark'>"+meetingroom.getRemark()+"</textarea>"); }
                                  %>
                                    
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" class="command">
                                <%
                                for(Meetingroom meetingroom : meetingroomlist){
                                	out.write("<input type='button' value='确认修改'onclick='change("+meetingroom.getRoomid()+")'>");
                                	out.write("<input type='button' value='返回' onclick='window.history.back()'>");
                                }
                                
                                %>
                                    
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </fieldset>
               
            </div>
        </div>
        <div class="page-footer">
            <hr/>
            更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a>
            <img src="images/footer.png" alt="CoolMeeting"/>
        </div>
    </body>
</html>