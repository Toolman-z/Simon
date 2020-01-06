<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
<meta http-equiv="content-type" content="text/html" charset="gb2312">
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="styles/common.css"/>
        <script type="text/javascript" src="JS/jquery-3.0.0.js"></script>
        <script type="text/javascript">
        $(document).ready(function(){//就绪函数
      	  var you=${user.employeeid};//取到存在session里的id
      	  $.ajax({//判断你是谁，输出你的名字到span中
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
      function add(){ 
    	  if(checkall()){
    	$.ajax({
    		 url: "/zyx/imge",//链接到MeetingroomServlet
    		 type :"POST",
    		 data :{ 
    			 housenumber:$("#roomnumber").val(),//取值门牌号文本框
    			 meetingname:$("#capacity").val(),//取值会议室名称
    			 maxpeople:$("#roomcapacity").val(),//取值最多容纳人数   			
    			 remarks:$("#description").val(), //取备忘录值   
    			 status:$("input[name='status']:checked").val()
    			  },
    		 dataType:"text", //以文本方式返回
    		 success : function(data){
    			 
    			  if(data == "true"){
    				  alert("添加成功");
    			  }else{
    				  alert("添加失败");
    			  }
    		 }
    	 });
    	  }else{
    		  alert("请完整填写信息");
    	  }
    	  
      }  
      function checkall(){
    	  var housenumber=$("#roomnumber").val();
    	  var meetingname=$("#capacity").val();
    	  var maxpeople=$("#roomcapacity").val();
    	  var remarks=$("#description").val();
    	  if(housenumber == "" || meetingname == "" || maxpeople == "" || remarks == ""){
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
                    会议预定 > 添加会议室
                </div>
                
                    <fieldset>
                        <legend>会议室信息</legend>
                        <table class="formtable">
                            <tr>
                                <td>门牌号:</td>
                                <td>
                                    <input id="roomnumber" type="text" placeholder="例如：201" maxlength="10"/>
                                </td>
                            </tr>
                            <tr>
                                <td>会议室名称:</td>
                                <td>
                                    <input id="capacity" type="text" placeholder="例如：第一会议室" maxlength="20"/>
                                </td>
                            </tr>
                            <tr>
                                <td>最多容纳人数：</td>
                                <td>
                                    <input id="roomcapacity" type="text" placeholder="填写一个正整数"/>
                                </td>
                            </tr>
                            <tr>
                                <td>当前状态：</td>
                                <td>
                                    <input type="radio" id="status" name="status" checked="checked" value="1"/><label for="status">启用</label>
                                    <input type="radio" id="status" name="status" value="0"/><label for="status" >停用</label>
                                    <input type="radio" id="status" name="status" value="-1"/><label for="status">删除</label>
                                </td>
                            </tr>
                            <tr>
                                <td>备注：</td>
                                <td>
                                    <textarea id="description" maxlength="200" rows="5" cols="60" placeholder="200字以内的文字描述"></textarea>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" class="command">
                                    <input type="button" value="添加" class="clickbutton" onclick="add()"/>
                                    
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