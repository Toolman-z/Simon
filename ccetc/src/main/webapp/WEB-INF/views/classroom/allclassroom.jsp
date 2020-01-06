<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>所有班级</title>
<jsp:include page="../inc.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/echarts.min.js"></script>
<script>

function add() {
	window.location.href = "${pageContext.request.contextPath}/classroom/roomaddjump.action?row=10&page=1";
}
function edit(){
	var rows = $('#dg').datagrid('getChecked');
	if (rows.length > 1) {
		$.messager.alert('消息', '只能修改一笔数据！', 'info');
	} else if (rows.length == 0) {
		$.messager.alert('消息', '请选择一笔数据！', 'info');
	} else {
		window.location.href = "${pageContext.request.contextPath}/classroom/classroomEditjump.action?row=10&page=1&classroomid=" + rows[0].classroomid;
	}
}
function see(){
	var rows = $('#dg').datagrid('getChecked');
	var id =rows[0].technologyid;

	 if (rows.length > 1) {
			$.messager.alert('消息', '只能查看一笔数据！', 'info');
		} else if (rows.length == 0) {
			$.messager.alert('消息', '请选择一笔数据！', 'info');
		} else {
			$("#dd").panel('open');
			five();
			six();
		}
	
}
function five(){
	var rows = $('#dg').datagrid('getChecked');
	var id =rows[0].technologyid;
	 $("#delt").empty();
	$.ajax({
		url:"${pageContext.request.contextPath}/course/five.action",
		type:"POST",
		data:{
			clazzid:id
		},
		dataType:"json",
		success:function(data){			
			 var obj='';       			 
			 for(var i=0;i<data.length;i++){     				 
				   var option=data[i];  				   
				   obj +="<tr><td> "+option.daysum+" </td><td> "+option.content+" </td></tr>";
				  };				 
				  $("#delt").append(obj);
		}
	});
} 
function six(){
	var myChart = echarts.init(document.getElementById('main'));
	// 显示标题，图例和空的坐标轴
	myChart.setOption({
	    title: {
	        text: '课程表'
	    },
	    tooltip: {},
	    legend: {
	        data:['销量']
	    },
	    xAxis: {
	        data: []
	    },
	    yAxis: {},
	    series: [{
	        name: '销量',
	        type: 'bar',
	        data: []
	    }]
	});
	var rows = $('#dg').datagrid('getChecked');
	var id =rows[0].technologyid;
	 var names=[];    //类别数组（实际用来盛放X轴坐标值）
     var nums=[];    //销量数组（实际用来盛放Y坐标值）
	$.ajax({
		url:"${pageContext.request.contextPath}/course/five.action",
		type:"POST",
		data:{
			clazzid:id
		},
		dataType:"json",
		success:function(data){			
			 var obj='';       			 
			 for(var i=0;i<data.length;i++){     				 
				   var option=data[i];  				   
				   obj +="<tr><td> "+option.daysum+" </td><td> "+option.content+" </td></tr>";
				  };	
				  
				  
				  
				  //请求成功时执行该函数内容，result即为服务器返回的json对象
	                
	                     for(var i=0;i<data.length;i++){       
	                           names.push(data[i].content);    //挨个取出类别并填入类别数组
	                         }
	                        for(var i=0;i<data.length;i++){       
	                          //  nums.push(result[i].productionArrangement.number);    //挨个取出销量并填入销量数组daliy
	                          nums.push(data[i].daysum);
	                          }
	                        myChart.hideLoading();    //隐藏加载动画
	                        myChart.setOption({        //加载数据图表
	                            xAxis: {
	                                data: names
	                            },
	                            series: [{
	                                // 根据名字对应到相应的系列
	                                name: '数量',
	                                data: nums
	                            }]
	                        });
	                        
	                 
	            },
	             error : function(errorMsg) {
	                 //请求失败时执行该函数
	             alert("图表请求数据失败!");
	             myChart.hideLoading();
				  
				
		}
	});
}
function cancel(){

	$("#dd").panel('close');
}
</script>
</head>
<body class="easyui-layout">
<div id="dd" class="easyui-dialog" title="课程表" style="width:700px;height:560px;" data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">   
    <table>
<thead>
<tr>
<th style="width:100px;">天数</th>
<th style="width:100px;">课程内容</th>
</tr>
</thead>
<tbody id="delt">
</tbody>
</table>
 <div id="main" style="width: 600px;height:400px;"></div>
</div>
<div data-options="region:'north',title:'操作'  " style="height: 68px;">
<div style="float:right;margin-top: 5px; margin-right: 10px;">
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="see()">查看课表</a>
			 			
		</div>
</div>
<div data-options="region:'center',title:'数据列表'" style="padding: 5px;">
<table id="dg" class="easyui-datagrid" data-options="fitColumns:true,fit:true,checkOnSelect:true,idField:'userid'">
<thead>
<tr>
<th data-options="field:'checkbox',width:30,checkbox:true"></th>
<th data-options="field:'classroomid',hidden:true,width:300">教室id</th>
<th data-options="field:'technologyid',hidden:true,width:300">技术id</th>
<th data-options="field:'classroomname',width:300">技术方向</th>
<th data-options="field:'areaname',width:300">所属区域</th>
<th data-options="field:'contain',width:300">容纳人数</th>
<th data-options="field:'startdate',width:300">开始时间</th>
<th data-options="field:'endtdate',width:300">结束时间</th>
<th data-options="field:'teacher',width:300">讲师</th>
<th data-options="field:'assistant',width:300">助教</th>
<th data-options="field:'clazzmaster',width:300">班主任</th>
</tr>
</thead>
<tbody>
<c:forEach items="${classroomList}" var="re">
<tr>
<td></td>
<td>${re.clazzid}</td>
<td>${re.technologyid}</td>
<td>${re.technologyname.technologyname}</td>
<td>${re.areaname.areaname}</td>
<td>${re.count}</td>
<td><c:set var="now" value="${re.startdate }" />
			<fmt:formatDate pattern="yyyy-MM-dd" 
            value="${now}" /></td>
<td><c:set var="noww" value="${re.enddate }" />
			<fmt:formatDate pattern="yyyy-MM-dd" 
            value="${noww}" /></td>
<td>${re.teacher}</td>
<td>${re.assistant}</td>
<td>${re.clazzmaster}</td>
</tr>
 </c:forEach >
</tbody>
</table>
</div>
</body>
</html>