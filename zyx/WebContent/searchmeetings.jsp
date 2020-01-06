<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
<meta http-equiv="content-type" content="text/html" charset="gb2312">
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="styles/common.css"/>
         <script type="text/javascript" src="JS/jquery-3.0.0.js"></script>
          <script type="text/javascript" src="laydate/laydate.js"></script>
         <script type="text/javascript">
   	  //执行一个laydate实例
   	  laydate.render({
   		  elem: '.layui-input'        		 
   		,type: 'datetime'
   		}); 
         function query(){

        	 if(check()){//判断查询条件是否触发查询
        	//循环数据前先删除table的所有行
         	var tb = document.getElementById('query');
         	    var rowNum=tb.rows.length;
         	    for (i=0;i<rowNum;i++)
         	    {
         	        tb.deleteRow(i);
         	        rowNum=rowNum-1;
         	        i=i-1;
         	    }    	
        	 $.ajax({
        		 url:"/zyx/reserve",
        		 type:"GET",
        		 data:{
        			 page:1,
        			 meetingname:$("#meetingname").val(),//取得填写的会议名称
        			 roomname:$("#roomname").val(),//取得填写的会议室名称
        			 reservername:$("#reservername").val(),//取得填写的预定着姓名
        			 reservefromdate:$("#reservefromdate").val(),//取得预定时间段开始时间
        			 reservetodate:$("#reservetodate").val(),//取得预定时间段结束时间
        			 meetingfromdate:$("#meetingfromdate").val(),//取得会议开始时间
        			 meetingtodate:$("#meetingtodate").val()//取得会议结束时间
        		 },
        		 dataType:"json",
        		 success:function(data){
        			 for(var i=0;i<data.length-1;i++){
      				   var tbBody='';
      				   tbBody +="<tr><td>"+data[i].meetingname+"</td><td>"+data[i].roomname+"</td><td>"+data[i].meetingstarttime+"</td><td>"+data[i].meetingendtime+"</td><td>"+data[i].reservetime+"</td><td>"+data[i].username+"</td><td><input type='button' value='查看详情' onclick='find("+data[i].meetingid+","+data[i].roomid+")'></td></tr>";
      				  $("#query").append(tbBody);    				 
      			   }; 
      			   for (var j = 0; j<data.length; j++){	    				
  	    				var a = data[j];
  	    				if(a == data[data.length-1]){
  	    					var page = a.page;
  		    				var totalCount = a.totalCount;
  		    				var totalpage = a.totalpage;
  	    				}else{
  	    					continue;
  	    				}		    				
  	    			};
  	    			$("#page").text(page);			
	    			$("#totalCount").text(totalCount);
	    			$("#totalpage").text(totalpage);
        		 }
        	 });
        	 
        	 }else{
        		 alert("请准确填写查询时间");
        		 $(".idea").text(" **请选择时间** ");
        	 }
        	 
         }
         function up(){
        	 var test=$("#page").text();
         	if(test == 1){
         	}else{
        	 $("#page").text($("#page").text()-1);
         	//循环数据前先删除table的所有行
          	var tb = document.getElementById('query');
          	    var rowNum=tb.rows.length;
          	    for (i=0;i<rowNum;i++)
          	    {
          	        tb.deleteRow(i);
          	        rowNum=rowNum-1;
          	        i=i-1;
          	    }    	
         	 $.ajax({
         		 url:"/zyx/reserve",
         		 type:"GET",
         		 data:{
         			 page:$("#page").text(),
         			 meetingname:$("#meetingname").val(),//取得填写的会议名称
         			 roomname:$("#roomname").val(),//取得填写的会议室名称
         			 reservername:$("#reservername").val(),//取得填写的预定着姓名
         			 reservefromdate:$("#reservefromdate").val(),//取得预定时间段开始时间
         			 reservetodate:$("#reservetodate").val(),//取得预定时间段结束时间
         			 meetingfromdate:$("#meetingfromdate").val(),//取得会议开始时间
         			 meetingtodate:$("#meetingtodate").val()//取得会议结束时间
         		 },
         		 dataType:"json",
         		 success:function(data){
         			 for(var i=0;i<data.length-1;i++){
       				   var tbBody='';
       				   tbBody +="<tr><td>"+data[i].meetingname+"</td><td>"+data[i].roomname+"</td><td>"+data[i].meetingstarttime+"</td><td>"+data[i].meetingendtime+"</td><td>"+data[i].reservetime+"</td><td>"+data[i].username+"</td><td><input type='button' value='查看详情' onclick='find("+data[i].meetingid+","+data[i].roomid+")'></td></tr>";
       				  $("#query").append(tbBody);    				 
       			   }; 
       			   for (var j = 0; j<data.length; j++){	    				
   	    				var a = data[j];
   	    				if(a == data[data.length-1]){
   	    					var page = a.page;
   		    				var totalCount = a.totalCount;
   		    				var totalpage = a.totalpage;
   	    				}else{
   	    					continue;
   	    				}		    				
   	    			};
   	    			$("#page").text(page);			
 	    			$("#totalCount").text(totalCount);
 	    			$("#totalpage").text(totalpage);
         		 }
         	 });
         	}
         }
         function down(){
        	 var test=$("#totalpage").text();
         	var testnow=$("#page").text();
         	if(testnow == test){
         		
         	}else{   
        	 var a=parseInt($("#page").text())+1;
        	 $("#page").text(a);
        	//循环数据前先删除table的所有行
           	var tb = document.getElementById('query');
           	    var rowNum=tb.rows.length;
           	    for (i=0;i<rowNum;i++)
           	    {
           	        tb.deleteRow(i);
           	        rowNum=rowNum-1;
           	        i=i-1;
           	    }    	
          	 $.ajax({
          		 url:"/zyx/reserve",
          		 type:"GET",
          		 data:{
          			 page:$("#page").text(),
          			 meetingname:$("#meetingname").val(),//取得填写的会议名称
          			 roomname:$("#roomname").val(),//取得填写的会议室名称
          			 reservername:$("#reservername").val(),//取得填写的预定着姓名
          			 reservefromdate:$("#reservefromdate").val(),//取得预定时间段开始时间
          			 reservetodate:$("#reservetodate").val(),//取得预定时间段结束时间
          			 meetingfromdate:$("#meetingfromdate").val(),//取得会议开始时间
          			 meetingtodate:$("#meetingtodate").val()//取得会议结束时间
          		 },
          		 dataType:"json",
          		 success:function(data){
          			 for(var i=0;i<data.length-1;i++){
        				   var tbBody='';
        				   tbBody +="<tr><td>"+data[i].meetingname+"</td><td>"+data[i].roomname+"</td><td>"+data[i].meetingstarttime+"</td><td>"+data[i].meetingendtime+"</td><td>"+data[i].reservetime+"</td><td>"+data[i].username+"</td><td><input type='button' value='查看详情' onclick='find("+data[i].meetingid+","+data[i].roomid+")'></td></tr>";
        				  $("#query").append(tbBody);    				 
        			   }; 
        			   for (var j = 0; j<data.length; j++){	    				
    	    				var a = data[j];
    	    				if(a == data[data.length-1]){
    	    					var page = a.page;
    		    				var totalCount = a.totalCount;
    		    				var totalpage = a.totalpage;
    	    				}else{
    	    					continue;
    	    				}		    				
    	    			};
    	    			$("#page").text(page);			
  	    			$("#totalCount").text(totalCount);
  	    			$("#totalpage").text(totalpage);
          		 }
          	 });
         	}
         }
         function check(){
        	 var baa=false
        	 var a=$("#reservefromdate").val();
        	 var b=$("#reservetodate").val();
        	 var c=$("#meetingfromdate").val();
        	 var d=$("#meetingtodate").val();
        	 if(a==""||b==""||c==""||d==""){
        		 
        	 }else{
        		 baa=true;
        	 }
        	 return baa;
         }
         function find(meetingid,roomid){
       
        	window.location.href="/zyx/rep?meetingid="+meetingid+"&roomid="+roomid+"";
         }
         function one(){
        	 var one=1;
         	$("#page").text(one);
         	//循环数据前先删除table的所有行
          	var tb = document.getElementById('query');
          	    var rowNum=tb.rows.length;
          	    for (i=0;i<rowNum;i++)
          	    {
          	        tb.deleteRow(i);
          	        rowNum=rowNum-1;
          	        i=i-1;
          	    }    	
         	 $.ajax({
         		 url:"/zyx/reserve",
         		 type:"GET",
         		 data:{
         			 page:$("#page").text(),
         			 meetingname:$("#meetingname").val(),//取得填写的会议名称
         			 roomname:$("#roomname").val(),//取得填写的会议室名称
         			 reservername:$("#reservername").val(),//取得填写的预定着姓名
         			 reservefromdate:$("#reservefromdate").val(),//取得预定时间段开始时间
         			 reservetodate:$("#reservetodate").val(),//取得预定时间段结束时间
         			 meetingfromdate:$("#meetingfromdate").val(),//取得会议开始时间
         			 meetingtodate:$("#meetingtodate").val()//取得会议结束时间
         		 },
         		 dataType:"json",
         		 success:function(data){
         			 for(var i=0;i<data.length-1;i++){
       				   var tbBody='';
       				   tbBody +="<tr><td>"+data[i].meetingname+"</td><td>"+data[i].roomname+"</td><td>"+data[i].meetingstarttime+"</td><td>"+data[i].meetingendtime+"</td><td>"+data[i].reservetime+"</td><td>"+data[i].username+"</td><td><input type='button' value='查看详情' onclick='find("+data[i].meetingid+","+data[i].roomid+")'></td></tr>";
       				  $("#query").append(tbBody);    				 
       			   }; 
       			   for (var j = 0; j<data.length; j++){	    				
   	    				var a = data[j];
   	    				if(a == data[data.length-1]){
   	    					var page = a.page;
   		    				var totalCount = a.totalCount;
   		    				var totalpage = a.totalpage;
   	    				}else{
   	    					continue;
   	    				}		    				
   	    			};
   	    			$("#page").text(page);			
 	    			$("#totalCount").text(totalCount);
 	    			$("#totalpage").text(totalpage);
         		 }
         	 });
         }
         function lastone(){
        	//循环数据前先删除table的所有行
           	var tb = document.getElementById('query');
           	    var rowNum=tb.rows.length;
           	    for (i=0;i<rowNum;i++)
           	    {
           	        tb.deleteRow(i);
           	        rowNum=rowNum-1;
           	        i=i-1;
           	    }    	
          	 $.ajax({
          		 url:"/zyx/reserve",
          		 type:"GET",
          		 data:{
          			 page:$("#totalpage").text(),
          			 meetingname:$("#meetingname").val(),//取得填写的会议名称
          			 roomname:$("#roomname").val(),//取得填写的会议室名称
          			 reservername:$("#reservername").val(),//取得填写的预定着姓名
          			 reservefromdate:$("#reservefromdate").val(),//取得预定时间段开始时间
          			 reservetodate:$("#reservetodate").val(),//取得预定时间段结束时间
          			 meetingfromdate:$("#meetingfromdate").val(),//取得会议开始时间
          			 meetingtodate:$("#meetingtodate").val()//取得会议结束时间
          		 },
          		 dataType:"json",
          		 success:function(data){
          			 for(var i=0;i<data.length-1;i++){
        				   var tbBody='';
        				   tbBody +="<tr><td>"+data[i].meetingname+"</td><td>"+data[i].roomname+"</td><td>"+data[i].meetingstarttime+"</td><td>"+data[i].meetingendtime+"</td><td>"+data[i].reservetime+"</td><td>"+data[i].username+"</td><td><input type='button' value='查看详情' onclick='find("+data[i].meetingid+","+data[i].roomid+")'></td></tr>";
        				  $("#query").append(tbBody);    				 
        			   }; 
        			   for (var j = 0; j<data.length; j++){	    				
    	    				var a = data[j];
    	    				if(a == data[data.length-1]){
    	    					var page = a.page;
    		    				var totalCount = a.totalCount;
    		    				var totalpage = a.totalpage;
    	    				}else{
    	    					continue;
    	    				}		    				
    	    			};
    	    			$("#page").text(page);			
  	    			$("#totalCount").text(totalCount);
  	    			$("#totalpage").text(totalpage);
          		 }
          	 });
         }
         function testnum(){
         	var left=$("#totalpage").text(); //取test值       	
         	var num=$("#pagenum").val();   	
         	var numtest=/^[0-9]*$/;//正则判断是否是数字  	
         	if(numtest.test(num)){
         		var nums=parseInt(num);
        		var rights=parseInt(left);
         		if(nums <= rights && nums >=1){    			
         			return true;    			
         		}else{
         			alert("请输入最大页数以内的数");
         			return false;
         		}
         	}else{
         		alert("请输入数字");
         		return false;
         	}
         }
         function jump(){
        	 var num=$("#pagenum").val();
        	 if(testnum()){
        		//循环数据前先删除table的所有行
                	var tb = document.getElementById('query');
                	    var rowNum=tb.rows.length;
                	    for (i=0;i<rowNum;i++)
                	    {
                	        tb.deleteRow(i);
                	        rowNum=rowNum-1;
                	        i=i-1;
                	    }    	
               	 $.ajax({
               		 url:"/zyx/reserve",
               		 type:"GET",
               		 data:{
               			 page:num,
               			 meetingname:$("#meetingname").val(),//取得填写的会议名称
               			 roomname:$("#roomname").val(),//取得填写的会议室名称
               			 reservername:$("#reservername").val(),//取得填写的预定着姓名
               			 reservefromdate:$("#reservefromdate").val(),//取得预定时间段开始时间
               			 reservetodate:$("#reservetodate").val(),//取得预定时间段结束时间
               			 meetingfromdate:$("#meetingfromdate").val(),//取得会议开始时间
               			 meetingtodate:$("#meetingtodate").val()//取得会议结束时间
               		 },
               		 dataType:"json",
               		 success:function(data){
               			 for(var i=0;i<data.length-1;i++){
             				   var tbBody='';
             				   tbBody +="<tr><td>"+data[i].meetingname+"</td><td>"+data[i].roomname+"</td><td>"+data[i].meetingstarttime+"</td><td>"+data[i].meetingendtime+"</td><td>"+data[i].reservetime+"</td><td>"+data[i].username+"</td><td><input type='button' value='查看详情' onclick='find("+data[i].meetingid+","+data[i].roomid+")'></td></tr>";
             				  $("#query").append(tbBody);    				 
             			   }; 
             			   for (var j = 0; j<data.length; j++){	    				
         	    				var a = data[j];
         	    				if(a == data[data.length-1]){
         	    					var page = a.page;
         		    				var totalCount = a.totalCount;
         		    				var totalpage = a.totalpage;
         	    				}else{
         	    					continue;
         	    				}		    				
         	    			};
         	    			$("#page").text(page);			
       	    			$("#totalCount").text(totalCount);
       	    			$("#totalpage").text(totalpage);
               		 }
               	 });
        	 }else{
        		 
        	 }
         }
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
                    会议预定 > 搜索会议
                </div>
                
                    <fieldset>
                        <legend>搜索会议</legend>
                        <table class="formtable">
                            <tr>
                                <td>会议名称：</td>
                                <td>
                                    <input type="text" id="meetingname" maxlength="20"/>
                                </td>
                                <td>会议室名称：</td>
                                <td>
                                    <input type="text" id="roomname" maxlength="20"/>
                                </td>
                                <td>预定者姓名：</td>
                                <td>
                                    <input type="text" id="reservername" maxlength="20"/>
                                </td>
                            </tr>
                            <tr>
                                <td>预定日期：</td>
                                <td colspan="5">
                                    从&nbsp;<input type="text" id="reservefromdate" class="layui-input"/>
                                    到&nbsp;<input type="text" id="reservetodate" class="layui-input"/><span class="idea"></span>
                                </td>
                            </tr>
                            <tr>
                                <td>会议日期：</td>
                                <td colspan="5">
                                    从&nbsp;<input type="text" id="meetingfromdate" class="layui-input"/>
                                    到&nbsp;<input type="text" id="meetingtodate" class="layui-input"/><span class="idea"></span>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="6" class="command">
                                    <input type="button" class="clickbutton" value="查询" onclick="query()"/>
                                   
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                
                <div>
                    <h3 style="text-align:center;color:black">查询结果</h3>
                    <div class="pager-header">
                        <div class="header-info">
                            共<span class="info-number" id="totalCount"></span>条结果，
                            分成<span class="info-number" id="totalpage"></span>页显示，
                            当前第<span class="info-number" id="page"></span>页
                        </div>
                        <div class="header-nav">
                            <input type="button" class="clickbutton" value="首页" onclick="one()"/>
                            <input type="button" class="clickbutton" value="上页" onclick="up()"/>
                            <input type="button" class="clickbutton" value="下页" onclick="down()"/>
                            <input type="button" class="clickbutton" value="末页" onclick="lastone()"/>
                            跳到第<input type="text" id="pagenum" class="nav-number"/>页
                            <input type="button" class="clickbutton" value="跳转" onclick="jump()"/>
                        </div>
                    </div>
                </div>
                <table class="listtable">
                <thead>
                    <tr class="listheader">
                        <th>会议名称</th>
                        <th>会议室名称</th>
                        <th>会议开始时间</th>
                        <th>会议结束时间</th>
                        <th>会议预定时间</th>
                        <th>预定者</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody id="query">
                    
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