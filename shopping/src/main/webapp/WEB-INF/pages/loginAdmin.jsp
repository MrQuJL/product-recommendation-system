<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include/taglib.jsp"%>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>登录-商城后台管理系统</title>
	<meta name='keywords' content='管理' />
	<meta name='description' content='商城后台管理系统' />
	<%@ include file="/WEB-INF/pages/include/head.jsp"%>
</head>
<body class="login-layout">
	<div class="logintop">
		<span>欢迎后台管理界面平台</span>
		<ul>
			<li><a href="#">返回首页</a></li>
			<li><a href="#">帮助</a></li>
			<li><a href="#">关于</a></li>
		</ul>
	</div>
	<div class="loginbody">
		<div class="login-container">
			<div class="center">
				<h1>
					<i class="icon-leaf green"></i>
					<span class="white">商城后台管理系统</span>
				</h1>
				<h4 class="white">Background Management System</h4>
			</div>

			<div class="space-6"></div>

			<div class="position-relative">
				<div id="login-box" class="login-box widget-box no-border visible">
					<div class="widget-body">
						<div class="widget-main">
							<h4 class="header blue lighter bigger">
								<i class="icon-coffee green"></i> 管理员登陆
								<span style="color:red;font-size:16px;">&nbsp;&nbsp;&nbsp;${loginFlag}</span>
							</h4>
							
							<div class="login_icon">
								<img src="${ctxJsAndCss}/images/login.png" />
							</div>

							<form id="loginForm" action="${ctx}/loginAdmin" method="post">
								<fieldset>
									<label class="block clearfix"> 
										<span class="block input-icon input-icon-right">
										<input type="text" name="loginName" class="form-control" placeholder="登录名" name="登录名">
										<i class="icon-user"></i>
										</span>
									</label>
									<label class="block clearfix">
										<span class="block input-icon input-icon-right">
										<input type="password" name="password" class="form-control" placeholder="密码" name="密码">
										<i class="icon-lock"></i>
										</span>
									</label>

									<div class="space"></div>

									<div class="clearfix">
										<button type="submit" class="width-35 pull-right btn btn-sm btn-primary" id="login_btn">
											<i class="icon-key"></i> 登陆
										</button>
									</div>

									<div class="space-4"></div>
								</fieldset>
							</form>

							<div class="social-or-login center">
								<span class="bigger-110">通知</span>
							</div>

							<div class="social-login center">本网站系统不再对IE8以下浏览器支持，请见谅。</div>
						</div>
						<!-- /widget-main -->

						<div class="toolbar clearfix"></div>
					</div>
					<!-- /widget-body -->
				</div>
				<!-- /login-box -->
			</div>
			<!-- /position-relative -->
		</div>
	</div>
	<div class="loginbm">
		版权所有 2018 - 2018 <a href="">曲健磊</a>
	</div>
</body>
</html>
