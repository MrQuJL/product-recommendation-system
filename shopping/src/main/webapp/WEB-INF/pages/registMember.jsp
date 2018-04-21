<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include/taglib.jsp"%>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>会员注册</title>
	<link href="${ctxJsAndCss}/css/common.css" rel="stylesheet" type="text/css" />
	<link href="${ctxJsAndCss}/css/register.css" rel="stylesheet" type="text/css" />
	<script src="${ctxJsAndCss}/js/jquery-1.8.3.min.js" type="text/javascript"></script>
	<script src="${ctxJsAndCss}/js/jquery.validate.min.js" type="text/javascript"></script>
	<script src="${ctxJsAndCss}/js/messages_zh.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(function() {
			$("#registerform").validate({
				submitHandler : function(form) {
					form.submit();
				}
			});
		});
		   
		function checkUserName() {
			$.ajax({
				type : "post",
				url : "${ctx}/checkUser/" + $("#userName").val(),
				dataType : "json",
				success : function(data) {
					if (data.isExists == "true") { // 用户名已经存在
						document.getElementById("span1").innerHTML = "<font color='red'>用户名已经存在</font>";
						$("#username").val("");
                        $("#username").focus();
                        $(".submit").unbind("click", function(event) {
        
                        });
					} else { // 用户名不存在
						document.getElementById("span1").innerHTML = "<font color='green'>可以使用该用户名</font>";
					}
				}
			});
		}
	</script>
</head>
<body>
	<div class="container header">
		<!-- 包含进去首页头部的文件 -->
		<%@ include file="/WEB-INF/pages/front/main/menu.jsp"%>
	</div>
	<div class="container register">
		<div class="span24">
			<div class="wrap">
				<div class="main clearfix">
					<div class="title">
						<strong>会员注册</strong>USER REGISTER
					</div>
					<form id="registerform" action="${ctx}/registMember" method="post">
						<table>
							<tbody>
								<tr>
									<th><span class="requiredField">*</span>用户名:</th>
									<td><input type="text" id="userName" name="loginName"
										class="text" required minlength="3" maxlength="20"
										onblur="checkUserName()" /> <span id="span1"
										style="padding-left: 10px;"></span></td>
								</tr>
								<tr>
									<th><span class="requiredField">*</span>密&nbsp;&nbsp;码:</th>
									<td><input type="password" name="password" class="text"
										required minlength="3" maxlength="20" /></td>
								</tr>
								<tr>
									<th><span class="requiredField">*</span>确认密码:</th>
									<td><input type="password" name="rePassword" class="text"
										required minlength="3" maxlength="20" /></td>
								</tr>
								<tr>
									<th>E-mail:</th>
									<td><input type="text" name="email" class="text" /></td>
								</tr>
								<tr>
									<th>姓名:</th>
									<td><input type="text" name="memberName" class="text" required />
									</td>
								</tr>
								<tr>
									<th>性别:</th>
									<td>
										<input type="radio" name="sex" value="男"  required />男
										<input type="radio" name="sex" value="女" required />女
									</td>
								</tr>
								<tr>
									<th>年龄:</th>
									<td><input type="number" name="age" class="text" required />
									</td>
								</tr>
								<tr>
									<th><span class="requiredField">*</span>电话:</th>
									<td><input type="text" name="mobile" class="text" required />
									</td>
								</tr>
								<tr>
									<th><span class="requiredField">*</span>地址:</th>
									<td><input type="text" name="address" class="text" required />
									</td>
								</tr>
								<tr>
									<th>&nbsp;</th>
									<td><input type="submit" class="submit" value="确认注册" /></td>
								</tr>
							</tbody>
						</table>

					</form>
				</div>
			</div>
		</div>
	</div>

	<div class="container footer">
		<div class="span24">
			<div class="copyright">曲健磊 Copyright © 2018-2018 版权所有</div>
		</div>
	</div>

	<div id="_my97DP"
		style="position: absolute; top: -1970px; left: -1970px;"></div>

</body>
</html>
