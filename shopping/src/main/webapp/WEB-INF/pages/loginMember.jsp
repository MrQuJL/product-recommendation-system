<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include/taglib.jsp"%>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>会员登录</title>
	<script type="text/javascript" src="${ctxJsAndCss}/js/jquery-1.8.3.min.js"></script>
	<link href="${ctxJsAndCss}/css/common.css" rel="stylesheet" type="text/css" />
	<link href="${ctxJsAndCss}/css/login.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${ctxJsAndCss}/js/jquery.validate.min.js"></script>
	<script type="text/javascript" src="${ctxJsAndCss}/js/messages_zh.js"></script>
	<script type="text/javascript">
		$(function() {
			$("#loginForm").validate({
				submitHandler : function(form) {
					form.submit();
				}
			});
		});
	</script>
</head>
<body>
	<div class="container header">
        <!-- 包含进去首页头部的文件 -->
        <%@ include file="/WEB-INF/pages/front/main/menu.jsp"%>
    </div>
	<div class="container login">
		<div class="span12 last">
			<div class="wrap">
				<div class="main">
					<div class="title">
						<strong>会员登录</strong>USER LOGIN
					</div>
					<form id="loginForm"
						action="${pageContext.request.contextPath}/login" method="post">
						<table>
							<tbody>
								<tr>
									<th>用户名:</th>
									<td><input type="text" name="userName" class="text"
										required minlength="3" maxlength="20" /> <c:if
											test="${noUser != null }">
											<font color="red">没有此用户</font>
										</c:if></td>
								</tr>
								<tr>
									<th>密&nbsp;&nbsp;码:</th>
									<td><input type="password" name="password" class="text"
										required minlength="3" maxlength="20" /> <c:if
											test="${noPassword != null}">
											<font color="red">密码错误</font>
										</c:if></td>
								</tr>
								<tr>
									<th>验证码:</th>
									<td><span class="fieldSet"> <input type="text"
											id="captcha" name="checkcode" class="text captcha"
											maxlength="4" /> <img id="captchaImage" class="captchaImage"
											src="${pageContext.request.contextPath}/getCheckCodeImage"
											title="点击更换验证码" />

									</span> <c:if test="${errorCheckCode !=null}">
											<font color="red">验证码出错</font>
										</c:if></td>
								</tr>
								<tr>
									<th>&nbsp;</th>
									<td><label> <input type="checkbox"
											id="isRememberUsername" name="isRememberUsername"
											value="true" />记住用户名
									</label> <label> &nbsp;&nbsp;<a>找回密码</a>
									</label></td>
								</tr>
								<tr>
									<th>&nbsp;<font color="red">${registerok }</font></th>
									<td><input type="submit" class="submit" value="登 录" /></td>
								</tr>
								<tr class="register">
									<th>&nbsp;</th>
									<td>
										<dl>
											<dt>
												<a href="${pageContext.request.contextPath }/userRegister">还没有注册账号？立即注册</a>
											</dt>
										</dl>
									</td>
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
</body>
</html>