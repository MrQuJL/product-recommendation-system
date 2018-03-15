<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include/taglib.jsp"%>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>个人信息管理</title>
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<!-- css样式 -->
	<link href="${ctxJsAndCss}/font/css/font-awesome.min.css" rel="stylesheet" />
	<link href="${ctxJsAndCss}/assets/css/bootstrap.min.css" rel="stylesheet" />
	<link href="${ctxJsAndCss}/assets/css/codemirror.css" rel="stylesheet">
	<link href="${ctxJsAndCss}/assets/css/ace.min.css" rel="stylesheet" />
	<link href="${ctxJsAndCss}/css/style.css" rel="stylesheet" />
	<!-- js脚本 -->
	<script src="${ctxJsAndCss}/js/date.js"></script>
	<script src="${ctxJsAndCss}/js/jquery-1.9.1.min.js"></script>
	<script src="${ctxJsAndCss}/assets/layer/layer.js"></script>
	<script src="${ctxJsAndCss}/assets/laydate/laydate.js"></script>
	<script src="${ctxJsAndCss}/assets/js/bootstrap.min.js"></script>
	<script src="${ctxJsAndCss}/assets/js/typeahead-bs2.min.js"></script>
	<script src="${ctxJsAndCss}/assets/js/jquery.dataTables.min.js"></script>
	<script src="${ctxJsAndCss}/assets/js/jquery.dataTables.bootstrap.js"></script>
</head>
<body>
	<div class="clearfix">
		<div class="admin_info_style">
			<div class="admin_modify_style" id="Personal">
				<div class="type_title">管理员信息</div>
				<div class="xinxi">
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1">用户名： </label>
						<div class="col-sm-9">
							<input type="text" name="用户名" id="adminName" value="${admin.adminName}"
								class="col-xs-7 text_info" disabled="disabled">
							&nbsp;&nbsp;&nbsp;<a href="javascript:ovid()"
								onclick="change_Password()" class="btn btn-warning btn-xs">修改密码</a>
						</div>

					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1">性别： </label>
						<div class="col-sm-9">
							<span class="sex" id="sex">${admin.sex}</span>
							<div class="add_sex">
								<label>
									<input name="form-field-radio" id="man" value="男" type="radio" checked="checked" class="ace">
									<span class="lbl">男</span>
								</label>&nbsp;&nbsp;
								<label>
									<input name="form-field-radio" id="women" value="女" type="radio" class="ace">
									<span class="lbl">女</span>
								</label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1">年龄： </label>
						<div class="col-sm-9">
							<input type="text" name="年龄" id="age" value="${admin.age}"
								class="col-xs-7 text_info" disabled="disabled">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1">移动电话： </label>
						<div class="col-sm-9">
							<input type="text" name="移动电话" id="mobile"
								value="${admin.mobile}" class="col-xs-7 text_info"
								disabled="disabled">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1">电子邮箱： </label>
						<div class="col-sm-9">
							<input type="text" name="电子邮箱" id="email"
								value="${admin.email}" class="col-xs-7 text_info"
								disabled="disabled">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1">注册时间： </label>
						<div class="col-sm-9">
							<span id="regDate"></span>
						</div>
					</div>
					<div class="Button_operation clearfix">
						<button onclick="modify();" class="btn btn-danger radius"
							type="submit">修改信息</button>
						<button onclick="save_info();" class="btn btn-success radius"
							type="button">保存修改</button>
					</div>
				</div>
			</div>
			<div class="recording_style">
				<div class="type_title">管理员登陆记录</div>
				<div class="recording_list">
					<table
						class="table table-border table-bordered table-bg table-hover table-sort"
						id="sample-table">
						<thead>
							<tr class="text-c">
								<th width="25"><label><input type="checkbox"
										class="ace"><span class="lbl"></span></label></th>
								<th width="80">ID</th>
								<th width="100">类型</th>
								<th>内容</th>
								<th width="17%">登陆地点</th>
								<th width="10%">用户名</th>
								<th width="120">客户端IP</th>
								<th width="150">时间</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><label><input type="checkbox" class="ace"><span
										class="lbl"></span></label></td>
								<td>15686</td>
								<td>1</td>
								<td>登录成功!</td>
								<td>江苏南京</td>
								<td>admin</td>
								<td>61.233.7.80</td>
								<td>2014-6-11 11:11:42</td>
							</tr>
							<tr>
								<td><label><input type="checkbox" class="ace"><span
										class="lbl"></span></label></td>
								<td>15686</td>
								<td>1</td>
								<td>登录成功!</td>
								<td>江苏南京</td>
								<td>admin</td>
								<td>61.233.7.80</td>
								<td>2014-6-11 11:11:42</td>
							</tr>
							<tr>
								<td><label><input type="checkbox" class="ace"><span
										class="lbl"></span></label></td>
								<td>15686</td>
								<td>1</td>
								<td>登录成功!</td>
								<td>江苏南京</td>
								<td>admin</td>
								<td>61.233.7.80</td>
								<td>2014-6-11 11:11:42</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!--修改密码样式-->
	<div class="change_Pass_style" id="change_Pass">
		<ul class="xg_style">
			<li>
				<label class="label_name">原&nbsp;&nbsp;密&nbsp;码</label>
				<input name="原密码" type="password" class="" id="oldPsd">
			</li>
			<li>
				<label class="label_name">新&nbsp;&nbsp;密&nbsp;码</label>
				<input name="新密码" type="password" class="" id="newPsd">
			</li>
			<li>
				<label class="label_name">确认密码</label>
				<input name="再次确认密码" type="password" class="" id="confirmPsd">
			</li>
		</ul>
		<!-- <div class="center"> <button class="btn btn-primary" type="button" id="submit">确认修改</button></div>-->
	</div>
<script>
	//按钮点击事件
	function modify() {
		$('.text_info').attr("disabled", false);
		$('.text_info').addClass("add");
		$('#Personal').find('.xinxi').addClass("hover");
		$('#Personal').find('.btn-success').css({
			'display' : 'block'
		});
		var sex = $("#sex").text();
		if (sex == "男") {
			$("#man").prop("checked","checked");
			$("#women").removeProp("checked");
		} else {
			$("#women").prop("checked","checked");
			$("#man").removeProp("checked");
		}
	};
	function save_info() {
		var num = 0;
		var str = "";
		$(".xinxi input[type$='text']").each(function(n) {
			if ($(this).val() == "") {

				layer.alert(str += "" + $(this).attr("name") + "不能为空！\r\n", {
					title : '提示框',
					icon : 0,
				});
				num++;
				return false;
			}
		});
		if (num > 0) {
			return false;
		} else {
			// 1.获取表单数据,封装成js对象并用JSON.stringify()转化成JSON字符串
			var id = ${admin.id};
			var adminName = $("#adminName").val();
			var sex = $("input[type='radio']:checked").val();
			var age = $("#age").val();
			var mobile = $("#mobile").val();
			var email = $("#email").val();
			var jsonObj = {
				"id" : id,
				"adminName" : adminName,
				"sex" : sex,
				"age" : age,
				"mobile" : mobile,
				"email" : email
			}
			jsonObj = JSON.stringify(jsonObj);
			// 2.发送ajax请求
			$.ajax({
				type : "post",
				contentType : "application/json;charset=utf-8",
				url : "${ctx}/sysmgr/admin/updateAdmin",
				data : jsonObj,
				dataType : "json",
				success : function(data) {
					if (data.message == "修改管理员信息成功") {
						alert("修改管理员信息成功！");
						window.parent.location.reload();
					} else {
						alert("修改管理员信息失败！");
					}
				}
			});
			$('#Personal').find('.xinxi').removeClass("hover");
			$('#Personal').find('.text_info').removeClass("add").attr(
					"disabled", true);
			$('#Personal').find('.btn-success').css({
				'display' : 'none'
			});
			layer.close(index);
		}
	};
	//初始化宽度、高度    
	$(".admin_modify_style").height($(window).height());
	$(".recording_style").width($(window).width() - 400);
	//当文档窗口发生改变时 触发  
	$(window).resize(function() {
		$(".admin_modify_style").height($(window).height());
		$(".recording_style").width($(window).width() - 400);
	});
	//修改密码
	function change_Password() {
		layer.open({
			type : 1,
			title : '修改密码',
			area : [ '300px', '300px' ],
			shadeClose : true,
			content : $('#change_Pass'),
			btn : [ '确认修改' ],
			yes : function(index, layero) {
				if ($("#password").val() == "") {
					layer.alert('原密码不能为空!', {
						title : '提示框',
						icon : 0,

					});
					return false;
				}
				if ($("#Nes_pas").val() == "") {
					layer.alert('新密码不能为空!', {
						title : '提示框',
						icon : 0,

					});
					return false;
				}

				if ($("#c_mew_pas").val() == "") {
					layer.alert('确认新密码不能为空!', {
						title : '提示框',
						icon : 0,

					});
					return false;
				}
				if (!$("#c_mew_pas").val
						|| $("#c_mew_pas").val() != $("#Nes_pas").val()) {
					layer.alert('密码不一致!', {
						title : '提示框',
						icon : 0,

					});
					return false;
				} else {
					// 1. 获取三个密码框中的数据
					var oldPsd = $("#oldPsd").val();
					var newPsd = $("#newPsd").val();
					var confirmPsd = $("#confirmPsd").val();
					// 2. ajax异步提交
					$.ajax({
						type : "post",
						url : "${ctx}/sysmgr/admin/updatePassword",
						data : {"oldPsd" : oldPsd, "newPsd" : newPsd, "confirmPsd" : confirmPsd},
						dataType : "json",
						success : function(data) {
							if (data.message == "修改管理员密码成功") {
								layer.alert('修改管理员密码成功！', {
									title : '提示框',
									icon : 1,
								});
								layer.close(index);
							} else {
								layer.alert('修改管理员密码失败！', {
									title : '提示框',
									icon : 0,
								});
								layer.close(index);
							}
						}
					});
				}
			}
		});
	}
</script>
<script>
	jQuery(function($) {
		var oTable1 = $('#sample-table').dataTable({
			"aaSorting" : [ [ 1, "desc" ] ],//默认第几个排序
			"bStateSave" : true,//状态保存
			"aoColumnDefs" : [
			//{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
			{
				"orderable" : false,
				"aTargets" : [ 0, 2, 3, 4, 5, 6 ]
			} // 制定列不参与排序
			]
		});

		$('table th input:checkbox').on(
				'click',
				function() {
					var that = this;
					$(this).closest('table').find(
							'tr > td:first-child input:checkbox').each(
							function() {
								this.checked = that.checked;
								$(this).closest('tr').toggleClass('selected');
							});

				});
	});
</script>
<script>
	$(function() {
		// 显示用户的注册时间
		var regDate = ${admin.gmtCreate.getTime()};
		$("#regDate").html(timestampToTime(regDate));
	});
</script>
</body>
</html>