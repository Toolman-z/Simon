<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import ="java.util.List"%>
<%@ page import =" com.zyx.Model.Reservemeeting"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page import =" com.zyx.Model.Employee"%>
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
         $(document).ready(function(){
        	 testyou()
         });
      var a=false;
         function testyou(){         	 
        	 var meetingid=${meetingid.meetingid};
        	 var reserveuserid=${user.employeeid};
        	 $.ajax({
        		 url:"/zyx/detail",
        	     type:"POST",
        	     data:{ 
        	    	 reserveuserid:reserveuserid,
        	    	 meetingid:meetingid
        	     },
        	     dataType:"text",
        	     success:function(data){
        	    	 if(data == "true"){       	    		
        	    		a= true;       	    		        	    		
        	    	 }else{
        	    		a= false;
        	    	 }
        	     }
        	 });        	
         }
         function changemeet(){        	
        	 changemeeting();
         }
         function changemeeting(){        	      	
        	 if(a){      	 
        	 var change;
         	change=prompt("关闭会议原因");//取到文本框输入的值  
         	if(change == null){
         		
         	}else{
         	var meetingid=${meetingid.meetingid};
       	    var reserveuserid=${user.employeeid};
         	$.ajax({
         		url:"/zyx/detail",
         		type:"GET",
         		data:{
         			change:change,
         			meetingid:meetingid,
         			reserveuserid:reserveuserid
         		},
         		dataType:"text",
         		success:function(data){
         			if(data == "true"){
         				alert("关闭成功");
         			}else{
         				alert("关闭失败");
         			}
         		}
         	});
         	}
        	 }else{
        		 alert("您没有权限，只有预定者拥有权限");
        	 }
        	 
         }
         </script>
        <style type="text/css">
            #divfrom{
                float:left;
                width:200px;
            }
            #divto{
                float:left;
                width:200px;
            }
            #divoperator{
                float:left;
                width:50px;
                padding:60px 5px;
            }
            #divoperator input[type="button"]{
                margin:10px 0;
            }
            #selDepartments{
                display:block;
                width:100%;
            }
            #selEmployees{
                display:block;
                width:100%;
                height:200px;
            }
            #selSelectedEmployees{
                display:block;
                width:100%;
                height:225px;
            }
        </style>
        <script type="application/javascript">
                        
        </script>
    </head>
    <body onload="body_load()">
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
                    会议预定 > 修改会议预定
                </div>
                
                    <fieldset>
                        <legend>会议信息</legend>
                 <%
                Object obj= request.getAttribute("reservemeetinglist");
                List<Reservemeeting> meetingroomlist = new ArrayList<Reservemeeting>();
                if(obj != null){
                	meetingroomlist = (List<Reservemeeting>)obj;
                }
                %>
                        <table class="formtable">
                            <tr>
                                <td>会议名称：</td>
                                <td>
                                <%  for(Reservemeeting reservemeeting : meetingroomlist){                                    	
                                    	out.write("<span id='meetingname'>"+reservemeeting.getMeetingname()+"</span>"); }
                                %>
                                    </td>                               
                            </tr>
                            <tr>
                                <td>预计参加人数：</td>
                                <td>
                                 <%  for(Reservemeeting reservemeeting : meetingroomlist){                                    	
                                    	out.write("<span id='meetingcapacity'>"+reservemeeting.getMeetingpersonnum()+"</span>"); }
                                %>
                                </td>
                            </tr>
                            <tr>
                                <td>预计开始时间：</td>
                                <td>
                                 <%  for(Reservemeeting reservemeeting : meetingroomlist){                                    	
                                    	out.write("<span id='meetingstarttime'>"+reservemeeting.getMeetingstarttime()+"</span>"); }
                                %>
                                </td>
                            </tr>
                            <tr>
                                <td>预计结束时间：</td>
                                <td>
                                 <%  for(Reservemeeting reservemeeting : meetingroomlist){                                    	
                                    	out.write("<span id='meetingendtime'>"+reservemeeting.getMeetingendtime()+"</span>"); }
                                %>
                                </td>
                            </tr>
                            <tr>
                                <td>会议说明：</td>
                                <td>                              
                                      <%  for(Reservemeeting reservemeeting : meetingroomlist){                                    	
                                    	out.write("<textarea id='meetingremark' rows='5' readonly>"+reservemeeting.getMeetingremark()+"</textarea>"); }
                                %>
                                </td>
                            </tr>
                            <tr>
                                <td>参会人员：</td>
                                <td>
                                    <table class="listtable">
                                    <thead>
                                        <tr class="listheader">
                                            <th>姓名</th>
                                            <th>联系电话</th>
                                            <td>电子邮件</td>
                                        </tr>
                                        </thead>
                <%
                Object objc= request.getAttribute("employeelist");
                List<Employee> employeelist = new ArrayList<Employee>();
                if(objc != null){
                	employeelist = (List<Employee>)objc;
                }
                %>
                                        <tbody>
                                        
                                         <%  
                                        for(Employee reservemeeting : employeelist){ 
                                        out.write("<tr>");
                                    	out.write("<td>"+reservemeeting.getRealname()+"</td><td>"+reservemeeting.getPhone()+"</td><td>"+reservemeeting.getEmail()+"</td>"); 
                                        out.write("</tr>");
                                        }
                                         %>
                                        
                                        </tbody>
                                    </table>
                                </td>
                            </tr>
                            <tr>
                                <td class="command" colspan="2">
                                    <input type="button" class="clickbutton" value="返回" onclick="window.history.back();"/>
                                    <input type="button" class="clickbutton" value="关闭会议" onclick="changemeet()"/>
                                </td>
                            </tr>
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