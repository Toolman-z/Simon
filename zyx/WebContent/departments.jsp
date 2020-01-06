<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import ="java.util.List"%>
<%@ page import =" com.zyx.Model.Department"%>
<%@ page import ="java.util.ArrayList"%>
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
        function checktext(){
        	var a=$("#departmentname").val();
        	if(a==""){
        		return false;
        	}else{
        		return true;
        	}
        }
        function add(){
        	if(checktext()){       	
        	$.ajax({
        		url:"/zyx/add",
        		type:"POST",//post提交方式
        		data:{
        			departmentname:$("#departmentname").val()//取到文本框中的值
        		},
        		dataType:"text",//返回数据类型
        		success : function(data){
       			 //回调函数
      			  if(data == "true"){
      				select(); //执行查询函数，更新表格
      				  alert("添加成功");
      			  }else{
      				  alert("添加失败");
      			  }
      		 }
        	}); 
        	 }else{
             	alert("请填写部门名称");
             }
        	
        }
        function change(a){
        	var change;
        	change=prompt("将此部门名称更改为");//取到文本框输入的值
        	
        	if(change != null){       	
        	$.ajax({
        		 url: "/zyx/change",
        		 type :"POST",
        		 data:{
        			 id:a,
        			 name:change
        		 },
        		 dataType:"text",
        		 success : function(data){        			 
       			  if(data == "true"){ 
       				alert("更改成功"); 
       				select(); //执行查询函数，更新表格       				
       			  }else{
       				alert("更改失败");
       			  }
       		 }
        	});
        	}else{
        		
        	}        	       	
        }
        function delt(b){
        	var re=confirm("你确定要删除吗");
        	if(re == true){
        	$.ajax({
        		url:"/zyx/change",
        		type:"GET",
        		data:{
        			id:b       			
        		},
        		dataType:"text",
        		success:function(data){
        			if(data=="true"){
        				alert("删除成功");
        				select(); //执行查询函数，更新表格   
        			}else{
        				alert("删除失败");
        			}
        		}
        	});
        	}else{
        		
        	}        	       	
        }
        function select(){        	
        	var x= document.getElementById("select");
        	x.submit();
        }
        $(function(){ 
        	function number(){ 
        	for(var i=0;i< $(".numberClass").length;i++){ 
        	$(".numberClass").get(i).innerHTML = i+1; 
        	} 
        	} 
        	number(); 
        	});//实现表格序号自增
        </script>
    </head>
    <body>
    <form action="add" method="get" id="select"></form>
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
                    人员管理 > 部门管理
                </div>
                
                    <fieldset>
                        <legend>添加部门</legend>
                        部门名称:
                        <input type="text" id="departmentname" maxlength="20"/>
                        <input type="button" class="clickbutton" value="添加" onclick="add()"/>
                         
                    </fieldset>
                 <%
                Object obj= request.getAttribute("departmentlist");
                List<Department> departmentlist = new ArrayList<Department>();
                if(obj != null){
                	departmentlist = (List<Department>)obj;
                }
                %>
                <table class="listtable">
                    <caption>所有部门:</caption>                  
                    <thead>
                    <tr class="listheader">
                        <th>序号</th>
                        <th>部门名称</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                     <%
                     int num=1; 
                    for(Department department : departmentlist){
                    	out.write("<tr>");
                    	out.write("<td><span class='numberClass'></span></td><td id='td"+num+"'>"+department.getDepartmentname()+"</td><td><input type='button' onclick='change("+department.getDepartmentid()+")' value='编辑'><input type='button' onclick='delt("+department.getDepartmentid()+")' value='删除' ></td>");                   	
                    	out.write("</tr>");
                    	num++;
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