<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
<meta http-equiv="content-type" content="text/html" charset="gb2312">
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="styles/common.css"/>
        <script type="text/javascript" src="laydate/laydate.js"></script>
        <script type="text/javascript" src="JS/jquery-3.0.0.js"></script>
        <script type="text/javascript">      
        	  //执行一个laydate实例
        	  laydate.render({
        		  elem: '.layui-input'        		 
        		,type: 'datetime'
        		}); 
       
        $(document).ready(function(){//预读函数
        	 // 给input  date设置默认值
        	//var now = new Date();
        	//格式化日，如果小于9，前面补0
        	//var day = ("0" + now.getDate()).slice(-2);
        	//格式化月，如果小于9，前面补0
        	//var month = ("0" + (now.getMonth() + 1)).slice(-2);
        	//声明当前小时，24小时制
        	//var hour=now.getHour();
        	//alert(hour);
        	//声明当前分钟
        	//var min=now.getMinute();
        	//声明当前秒数
        	//var sec=now.getSecond();
        	//拼装完整日期格式
        	//var today = now.getFullYear()+"-"+(month)+"-"+(day)+""+(hour)+":"+(min)+":"+(sec)+"";
        	//完成赋值       	
        	//$('#startdate').val(today);
        	//$('#enddate').val(today);        	
        	 $("#selDepartments").empty(option); 
         	$.ajax({
         		url:"/zyx/bookmeeting",
         		type:"GET",
         		data:{
         			id:1
         		},
         		dataType:"json",
         		success:function(data){
         			for(var i=0;i<=data.length;i++){
       				   var option='';
       				   option +="<option value='"+data[i].departmentid+"'>"+data[i].departmentname+"</option>";
       				  $("#selDepartments").append(option); 
         			}
         		}
         	});
        	
        });
        function fmeeting(){//查询所有会议室  
        	if(checktime()){        	
        	//循环数据前先删除option的所有行
        	$("#option").empty();
        	$.ajax({
        		url:"/zyx/bookmeeting",
        		type:"POST",
        		data:{
        			startdate:$("#startdate").val(),
        			enddate:$("#enddate").val()
        		},
        		dataType:"json",
        		success:function(data){
        			for(var i=0;i<=data.length;i++){
     				   var option='';
     				   option +="<option value='"+data[i].roomid+"'>"+data[i].roomname+"</option>";
     				  $("#option").append(option);    				 
     			   }; 
        		}
        		
        	});
        	}else{
        		
        	}      	
        }
        function reserve(){
        	        		        	
        	if(checkall() && checkmore()){        	        	
        	//预定会议         
        	//取参会人员的id写进数组里，给ajax备用
        	var employeeid =[];
        	//遍历option的值
        	$("#selSelectedEmployees option").each(function(){
        		//获取每个option的值
        		var option_id = $(this).val();        		
        		//把遍历的值写进数组
        		employeeid.push(option_id);
        	})        
        	var roomid=$("#option").find("option:selected").val();
        	var reserveuserid=${user.employeeid}; //取到当前登录账号的id         	
        	$.ajax({
        		url:"/zyx/reserve",
        		type:"POST",
        		data:{
        			reserveuserid:reserveuserid,//取到当前登录账号的id   
        			employeeid:employeeid,//取到参会人员数组
        			meetingname:$("#meetingname").val(),//取到输入的会议名称
        			personnumber:$("#numofattendents").val(),//取到预计参加人数
        			startdate:$("#startdate").val(),//取到开始时间
        			enddate:$("#enddate").val(),//取到结束时间
        			roomid:roomid,//取到选择的会议室roomid
        			remark:$("#description").val()//取到会议说明
        		},
        		dataType:"text",
        		success:function(data){
        			if(data=="true"){
        				alert("预定成功");
        			}else{
        				alert("预定失败");
        			}
        		}
        	});
        	}else{
        	}	
        	        	       	
        }
       function department(){      	  
    	   $("#selEmployees").empty();
    	   $.ajax({
    		   url:"/zyx/try",
    		   type:"POST",
    		   data:{
    			   departmentid:$("#selDepartments").val()
    		   },
    		   dataType:"json",
    		   success:function(data){
    			   
    			   for(var i=0;i<=data.length;i++){
     				   var option='';
     				   option +="<option value='"+data[i].employeeid+"'>"+data[i].realname+"</option>";
     				  $("#selEmployees").append(option);    				 
     			   }; 
    		   }
    	   });
       }
       function right(){
    	   var select =document.getElementById("selSelectedEmployees");
    	   var a=$("#selEmployees").find("option:selected").val();
    	   var t=$("#selEmployees").find("option:selected").text(); 
    	   var js=jsselect(select,a);
    	  if(js){
    		  
    	  }else{
    	   var option='';
				   option +="<option value='"+a+"'>"+t+"</option>";
				  $("#selSelectedEmployees").append(option);
    	  }
       }
       function jsselect(select,a){
    	   var result = false ;  
           for ( var i=0;i<select.length;i++)   
           {   
               if (select[i].value == a)   
               {   
                   result = true ;   
                   break ;   
               }   
           }        
           return result;    
       }
       function remove(){
    	   var a=$("#selSelectedEmployees").find("option:selected").val();
    	   $("#selSelectedEmployees option[value='"+a+"']").remove();
       }
       function checkall(){
    	var meetingname=$("#meetingname").val();
    	var numofattendents=$("#numofattendents").val();
    	var startdate=$("#startdate").val();
    	var enddate=$("#enddate").val();
    	var	description=$("#description").val();    	
    	var numtest=/^[0-9]*$/;//正则判断是否是数字  	
    	if(meetingname == ""){
    		alert("请填写会议名称");
    		return false;
    	}else if(numofattendents == ""){
    		alert("请填写预计参加人数");
    		return false;
    	}else if(startdate == ""){
    		alert("请填写开始时间");
    		return false;
    	}else if(enddate == ""){
    		alert("请填写结束时间");
    		return false;
    	}else if(description == ""){
    		alert("请填写会议说明");
    		return false;
    	}else{
    		if(numtest.test(numofattendents)){
    			return true;
    		}else{
    			alert("预计参加人数请填写数字,例如“30”");
    		}
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
       function checktime(){
    	  var starttime= $("#startdate").val();
    	  var endtime= $("#enddate").val();
    	   if(starttime == "" || endtime == ""){
    		   alert("请填写预定时间");
    		   return false;
    	   }else{
    		   return true;
    	   }
       }
       function checkmore(){
    	   var d = new Date();
    	   d=d.getFullYear()+"-" + (d.getMonth()+1) + "-" + d.getDate() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
    	   var starttime=$("#startdate").val();
    	   var endtime=$("#enddate").val();
    	   if(starttime > endtime){
    		   alert("开始时间大于结束时间，请重新填写");
    		   return false;
    	   }else if(starttime < d){
    		   alert("预定时间小于当前日期");
    	   } else{
    		   return true;
    	   }
       }
       function tex(){
    	   var d = new Date();
    	   d=d.getFullYear()+"-" + (d.getMonth()+1) + "-" + d.getDate() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
    	   alert(d);
       }
        </script>
        <style type="text/css">
            #divfrom{
                float:left;
                width:150px;
            }
            #divto{
                float:left;
                width:150px;
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
                    会议预定 > 预定会议
                </div>
               <%
		Date d = new Date();

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String now = df.format(d);

	            %>	
                    <fieldset>
                   
                        <legend>会议信息</legend>
                        <table class="formtable">
                            <tr>
                                <td>会议名称：</td>
                                <td>
                                    <input type="text" id="meetingname" maxlength="20"/>
                                </td>
                            </tr>
                            <tr>
                                <td>预计参加人数：</td>
                                <td>
                                    <input type="text" id="numofattendents" />
                                </td>
                            </tr>
                            <tr>
                                <td>预计开始时间：</td>
                                <td>
                                <input type="text" id="startdate" class="layui-input">                                                                    
                                </td>
                            </tr>
                            <tr>
                                <td>预计结束时间：</td>
                                <td>
                                   <input type="text" id="enddate" class="layui-input">
                                   
                                </td>
                            </tr>
							 <tr>
                                <td>会议室：</td>
                                <td>
                                    <select id="option">									
									</select><input type="button" value="查询可用会议室" onclick="fmeeting()"/><font  color="red">注意：这个会议室一定是这段时是没有人占用才显示出来</font>
                                   
                                </td>
                            </tr>
                            <tr>
                                <td>会议说明：</td>
                                <td>
                                    <textarea id="description" rows="5"></textarea>
                                </td>
                            </tr>
                            <tr>
                                <td>选择参会人员：</td>
                                <td>
                                    <div id="divfrom">
                                        <select id="selDepartments" onblur="department()">
                                        </select>
                                        <select id="selEmployees" multiple="true">
                                        </select>
                                    </div>
                                    <div id="divoperator">
                                        <input type="button" class="clickbutton" value="&gt;" onclick="right()"/>
                                        <input type="button" class="clickbutton" value="&lt;" onclick="remove()"/>
                                    </div>
                                    <div id="divto">
                                        <select id="selSelectedEmployees" multiple="true">
                                        </select>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="command" colspan="2">
                                    <input type="button" class="clickbutton" value="预定会议" onclick="reserve()"/>
                                    
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