<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include/taglib.jsp"%>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>管理员列表</title>
	<link href="${ctxJsAndCss}/assets/css/bootstrap.min.css" rel="stylesheet" />
	<link href="${ctxJsAndCss}/assets/css/codemirror.css" rel="stylesheet">
	<link href="${ctxJsAndCss}/assets/css/ace.min.css" rel="stylesheet" />
	<link href="${ctxJsAndCss}/assets/css/font-awesome.min.css" rel="stylesheet" />
	<link href="${ctxJsAndCss}/css/style.css" rel="stylesheet" />
	
	<script src="${ctxJsAndCss}/assets/js/jquery.min.js"></script>
	<script src="${ctxJsAndCss}/assets/js/bootstrap.min.js"></script>
	<script src="${ctxJsAndCss}/assets/js/typeahead-bs2.min.js"></script>
	<script src="${ctxJsAndCss}/assets/js/jquery.dataTables.min.js"></script>
	<script src="${ctxJsAndCss}/assets/js/jquery.dataTables.bootstrap.js"></script>
	<script src="${ctxJsAndCss}/assets/layer/layer.js"></script>
	<script src="${ctxJsAndCss}/assets/laydate/laydate.js"></script>
	<script src="${ctxJsAndCss}/js/date.js"></script>
	<script type="text/javascript">
		var adminMgr = {
			// 查询管理员列表
			listAdmin : function(pageNo, pageSize) {
				var queryAdminName = $("#queryAdminName").val();
				$.ajax({
					type : "post",
					url : "${ctx}/sysmgr/admin/listAdmin",
					data : {"adminName" : queryAdminName, "pageNo" : pageNo, "pageSize" : pageSize},
					dataType : "json",
					success : function(data) {
						var htmlTable = "";
						var pageBar = data.pageBar;
						var adminNums = data.adminNums;
						data = data.adminList;
						if (data.length != 0) {
							for (var i = 0; i < data.length; i++) {
								htmlTable = htmlTable + "<tr>";
								
								htmlTable = htmlTable + "<td><label><input type='checkbox' value=" + data[i].id + " class='ace'><span class='lbl'></span></label></td>";
								
								htmlTable = htmlTable + "<td>" + data[i].id + "</td>";
								
								htmlTable = htmlTable + "<td>" + data[i].adminName + "</td>";
								
								htmlTable = htmlTable + "<td>" + data[i].sex + "</td>";
								
								htmlTable = htmlTable + "<td>" + data[i].mobile + "</td>";
								
								htmlTable = htmlTable + "<td>" + data[i].email + "</td>";
								
								htmlTable = htmlTable + "<td class=\"text-l\">" + data[i].address + "</td>";
								
								htmlTable = htmlTable + "<td>" +  timestampToTime(data[i].gmtCreate) + "</td>";
								
								htmlTable = htmlTable + 
								"<td class=\"td-manage\"> <a title=\"编辑\""+
								"							onclick=\"member_edit(" + data[i].id + ")\" href=\"javascript:;\""+
								"							class=\"btn btn-xs btn-info\"><i"+
								"								class=\"icon-edit bigger-120\"></i></a> <a title=\"删除\""+
								"							href=\"javascript:;\" onclick=\"member_del(this," + data[i].id + ")\""+
								"							class=\"btn btn-xs btn-warning\"><i"+
								"								class=\"icon-trash  bigger-120\"></i></a></td>";
								
								htmlTable = htmlTable + "</tr>";
							}
						} else {
							htmlTable = "<tr><td colspan=" + 9 + ">没有查询到记录</td></tr>";
						}
						// 查询出来的管理员列表
						$("#sample-table").find("tbody").html(htmlTable);
						// 查询出的分页条
						$("#pageBar").html(pageBar);
						// 查询出的总记录数
						$("#adminNums").html(adminNums);
					}
				});
			},
			// 批量删除管理员
			removeAdminBatch : function() {
				// 获取tbody里面所有被选中的checkbox
				var checkedBoxs = $("#sample-table")
					.find("tbody")
					.find("input[type='checkbox']:checked");
				// 创建数组保存已选中的checkbox的value（id）值
				if (checkedBoxs.length == 0) {
					layer.msg("请先选中要删除的管理员!",{icon:0,time:1000});
					return false;
				}
				var adminIds = new Array();
				$.each(checkedBoxs, function() {
					adminIds.push($(this).val());
				});
				adminIds = JSON.stringify(adminIds);
				layer.confirm('确认要删除这些管理员吗？',function(index){
					// 发送ajax请求删除选中的管理员
					$.ajax({
						type : "post",
						contentType : "application/json;charset=UTF-8",
						url : "${ctx}/sysmgr/admin/removeAdminBatch",
						data : adminIds,
						dataType : "json",
						success : function(data) {
							if (data.message == "删除管理员成功") {
								layer.msg(data.message,{icon:1,time:1000});
								// 2.成功时重新触发一次查询操作
								adminMgr.listAdmin(1, 5);
							} else {
								// 3.失败给出相应的提示信息
								layer.msg(data.message,{icon:0,time:1000});
							}
						}
					});
				});
			}
		}
	</script>
</head>
<body>
	<div class="page-content clearfix">
		<div id="Member_Ratings">
			<div class="d_Confirm_Order_style">
				<div class="search_style">
					<div class="title_names">搜索查询</div>
					<ul class="search_content clearfix">
						<li><label class="l_f">管理员名称</label><input id="queryAdminName" name="queryAdminName" type="text"
							class="text_add" placeholder="输入管理员名称" style="width: 400px" /></li>
						<li style="width: 90px;">
							<button type="button" class="btn_search" onclick="adminMgr.listAdmin(1, 5);">
								<i class="icon-search"></i>查询
							</button>
						</li>
					</ul>
				</div>
				<!---->
				<div class="border clearfix">
					<span class="l_f"> <a href="javascript:ovid()"
						id="member_add" class="btn btn-warning"><i class="icon-plus"></i>添加管理员</a>
						<a href="javascript:adminMgr.removeAdminBatch();" class="btn btn-danger"><i
							class="icon-trash"></i>批量删除</a>
					</span> <span class="r_f">共：<b id="adminNums">0</b>条
					</span>
				</div>
				<!--  -->
				<div class="table_menu_list">
					<table class="table table-striped table-bordered table-hover" id="sample-table">
						<thead>
							<tr>
								<th width="25">
									<label>
										<input type="checkbox" class="ace">
										<span class="lbl"></span>
									</label>
								</th>
								<th width="80">ID</th>
								<th width="100">管理员名</th>
								<th width="80">性别</th>
								<th width="120">手机</th>
								<th width="150">邮箱</th>
								<th width="">地址</th>
								<th width="180">加入时间</th>
								<th width="250">操作</th>
							</tr>
						</thead>
						<tbody>
							
						</tbody>
					</table>
			        <div id="pageBar"></div>
				</div>
			</div>
		</div>
	</div>
	<!--添加管理员图层-->
	<div class="add_menber" id="add_menber_style" style="display: none">
		<form action="#" method="post" id="adminForm">
			<ul class=" page-content">
				<li>
					<label class="label_name">用&nbsp;&nbsp;户 &nbsp;名：</label>
					<span class="add_name">
						<input id="id" name="id" type="hidden">
						<input id="loginName" name="loginName" type="text" class="text_add" />
					</span>
					<div class="prompt r_f"></div>
				</li>
				<li>
					<label class="label_name">真实姓名：</label>
					<span class="add_name">
						<input id="adminName" name="adminName" type="text" class="text_add" />
					</span>
					<div class="prompt r_f"></div>
				</li>
				<li>
					<label class="label_name">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</label>
					<span class="add_name">
						<label>
							<input id="man" name="sex" type="radio" value="男" class="ace">
							<span class="lbl">男</span>
						</label>&nbsp;&nbsp;&nbsp;
						<label>
							<input id="women" name="sex" type="radio" class="ace" value="女">
							<span class="lbl">女</span>
						</label>&nbsp;&nbsp;&nbsp;
					</span>
					<div class="prompt r_f"></div>
				</li>
				<li><label class="label_name">年龄：</label><span
					class="add_name"><input id="age" name="age" type="text"
						class="text_add" /></span>
				<div class="prompt r_f"></div></li>
				<li><label class="label_name">移动电话：</label><span
					class="add_name"><input id="mobile" name="mobile" type="text"
						class="text_add" /></span>
				<div class="prompt r_f"></div></li>
				<li><label class="label_name">电子邮箱：</label><span
					class="add_name"><input id="email" name="email" type="text"
						class="text_add" /></span>
				<div class="prompt r_f"></div></li>
				<li class="adderss"><label class="label_name">家庭住址：</label><span
					class="add_name"><input id="address" name="address" type="text"
						class="text_add" style="width: 350px" /></span>
				<div class="prompt r_f"></div></li>
			</ul>
		</form>
	</div>
<script>
	jQuery(function($) {
		$('table th input:checkbox').on('click' , function(){
			var that = this;
			$(this).closest('table').find('tr > td:first-child input:checkbox')
			.each(function(){
				this.checked = that.checked;
				$(this).closest('tr').toggleClass('selected');
			});
		});
	})
	/*管理员-添加*/
	$('#member_add').on('click', function(){
		// 因为添加和编辑公用一套页面，所以每次添加的时候要清空表单
		$("#id").val("");
		$("#loginName").val("");
		$("#adminName").val("");
		$("#age").val("");
		$("#mobile").val("");
		$("#email").val("");
		$("#address").val("");
		
		$("#man").prop("checked", "checked");
		$("#women").removeProp("checked");
		
		layer.open({
	        type: 1,
	        title: '添加管理员',
			maxmin: true,
			shadeClose: true, //点击遮罩关闭层
	        area : ['800px' , ''],
	        content:$('#add_menber_style'),
			btn:['提交','取消'],
			yes:function(index,layero){
			 	var num=0;
			 	var str="";
			 	// 输入框的name和对应的中文之间的映射关系
			 	var formMapping = {
			 		loginName : "用户名",
			 		adminName : "真实姓名",
			 		gender : "性别",
			 		age : "年龄",
			 		mobile : "手机",
			 		email : "邮箱",
			 		address : "家庭地址"
			 	};
	     		$(".add_menber input[type$='text']").each(function(n){
		        	if($(this).val()=="") {
						layer.alert(str+=""+formMapping[$(this).attr("name")]+"不能为空！\r\n",
							{title: '提示框', icon:0,}
						);
			    		num++;
	            		return false;            
	          		}
				});
				if(num>0) {
					return false;
				} else {
					// 1.序列化表单，组装成一个js对象发往后台（不包含id属性）
					var formObj = $("#adminForm").serializeArray();
					var jsonObj = {};
					$.each(formObj, function(i, item) {
						if (item.name != "id" && item.name != "sex") {
							jsonObj[item.name] = item.value;
						}
					});
					$("#man").attr("value","男");
					$("#women").attr("value","女");
					// 为jsonObj添加sex属性
					jsonObj["sex"] = $("input[type='radio']:checked").val();
					jsonObj = JSON.stringify(jsonObj);
					$.ajax({
						type : "post",
						contentType :"application/json;charset=UTF-8",
						url : "${ctx}/sysmgr/admin/saveAdmin",
						data : jsonObj,
						dataType : "json",
						// 2.接收后台的提示信息
						success : function(data) {
							alert(data.message);
							if (data.message == "新增管理员成功") {
								// 3.若成功则查询一次管理员，失败则继续维持原有页面
								adminMgr.listAdmin(1, 5);
								layer.alert('添加管理员成功！',{title: '提示框', icon:1,});
							} else {
								layer.alert('添加管理员失败，请联系系统管理员！',{title: '提示框', icon:0,});
							}
						}
					});
					layer.close(index);
				}
			}
	    });
	});
	
	/*管理员-编辑*/
	function member_edit(id){
		// 1.清空管理员图层的输入框信息
  		$("#id").val("");
		$("#loginName").val("");
		$("#adminName").val("");
		$("#age").val("");
		$("#mobile").val("");
		$("#email").val("");
		$("#address").val("");
		$("#man").prop("checked", "checked");
		$("#women").removeProp("checked");
  		// 2.根据id去后台查询一次当前id的用户信息并赋值给页面
  		$.ajax({
  			type : "post",
  			url : "${ctx}/sysmgr/admin/getAdminByAdminId",
  			data : {"adminId" : id},
  			dataType : "json",
  			success : function(data) {
  				$("#id").val(data.id);
  				$("#loginName").val(data.loginName);
  				$("#adminName").val(data.adminName);
  				$("#age").val(data.age);
  				$("#mobile").val(data.mobile);
  				$("#email").val(data.email);
  				$("#address").val(data.address);
  				if (data.sex == "男") {
  					$("#man").prop("checked", "checked");
  					$("#women").removeProp("checked");
  				} else {
  					$("#women").prop("checked", "checked");
  					$("#man").removeProp("checked");
  				}
  			}
  		});
		
		layer.open({
		    type: 1,
		    title: '修改管理员信息',
			maxmin: true, 
			shadeClose:false, //点击遮罩关闭层
		    area : ['800px' , ''],
		    content: $('#add_menber_style'),
			btn: ['提交','取消'],
			yes: function(index,layero){
				var num=0;
		 		var str="";
		 		// 输入框的name和对应的中文之间的映射关系
			 	var formMapping = {
			 		loginName : "用户名",
			 		adminName : "真实姓名",
			 		gender : "性别",
			 		age : "年龄",
			 		mobile : "手机",
			 		email : "邮箱",
			 		address : "家庭地址"
			 	};
		   		$(".add_menber input[type$='text']").each(function(n){
		        	if($(this).val()==""){
			   			layer.alert(str+=""+formMapping[$(this).attr("name")]+"不能为空！\r\n",
			   				{title: '提示框',icon:0,});
		    			num++;
		          		return false;
		        	} 
		 		});
		   		// 校验表单
		   		var age = $("#age").val();
		   		var retAge = /^[0-9]{1,3}$/;
		   		if (!retAge.test(age)) {
		   			layer.alert("年龄违法！\r\n",{title: '提示框',icon:0,});
		   			return false;
		   		}
		   		var mobile = $("#mobile").val();
		   		var retMobile = /^[1][0-9]{10}$/;
		   		if (!retMobile.test(mobile)) {
		   			layer.alert("手机号码格式错误！\r\n",{title: '提示框',icon:0,});
		   			return false;
		   		}
		   		
			  	if(num>0){
			  		return false;
			  	} else {
			  		// 3.序列化表单（包含id属性）
			  		var formObj = $("#adminForm").serializeArray();
					var jsonObj = {};
					$.each(formObj, function(i, item) {
						if (item.name != "sex") {
							jsonObj[item.name] = item.value;
						}
					});
					$("#man").attr("value","男");
					$("#women").attr("value","女");
					// 为jsonObj添加sex属性
					jsonObj["sex"] = $("input[type='radio']:checked").val();
					jsonObj = JSON.stringify(jsonObj);
			  		// 发送ajax请求
			  		$.ajax({
			  			type : "post",
			  			contentType : "application/json;charset=UTF-8",
			  			url : "${ctx}/sysmgr/admin/updateAdmin",
			  			data : jsonObj,
			  			dataType : "json",
			  			success : function(data) {
			  				if (data.message == "修改管理员信息成功") {
			  					adminMgr.listAdmin(1, 5);
			  					layer.alert('修改管理员信息成功！',
		  							{title: '提示框',icon:1,}
		  						);
			  				} else {
			  					layer.alert('修改管理员信息失败！',
		  							{title: '提示框',icon:0,}
		  						);
			  				}
			  				layer.close(index);
			  			}
			  		});
			  	}
			}
	    });
	}
	/*管理员-删除*/
	function member_del(obj,id){
		layer.confirm('确认要删除吗？',function(index){
			// 1.发送ajax请求删除该id的管理员
			$.ajax({
				type : "post",
				url : "${ctx}/sysmgr/admin/removeAdmin",
				data : {"adminId" : id},
				dataType : "json",
				success : function(data) {
					if (data.message == "删除管理员成功") {
						layer.msg(data.message,{icon:1,time:1000});
						// 2.成功时重新触发一次查询操作
						adminMgr.listAdmin(1, 5);
					} else {
						// 3.失败给出相应的提示信息
						layer.msg(data.message,{icon:0,time:1000});
					}
				}
			});
		});
	}
	laydate({
	    elem: '#start',
	    event: 'focus'
	});
</script>
</body>
</html>