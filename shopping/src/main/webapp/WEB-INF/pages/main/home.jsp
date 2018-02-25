<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include/taglib.jsp"%>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>home</title>
	<meta name='keywords' content='关键词,关键词' />
	<meta name='description' content='网站描述' />
	<%@ include file="/WEB-INF/pages/include/head.jsp"%>
</head>
<body>
	<div class="page-content clearfix">
		<div class="alert alert-block alert-success">
			<button type="button" class="close" data-dismiss="alert">
				<i class="icon-remove"></i>
			</button>
			<i class="icon-ok green"></i>欢迎使用<strong class="green">后台管理系统<small>(v1.2)</small></strong>,你本次登陆时间为2016年7月12日13时34分，登陆IP:192.168.1.110.
		</div>
		<div class="state-overview clearfix">
			<div class="col-lg-3 col-sm-6">
				<section class="panel">
					<div class="symbol terques">
						<i class="icon-user"></i>
					</div>
					<div class="value">
						<h1>34522</h1>
						<p>商城用户</p>
					</div>
				</section>
			</div>
			<div class="col-lg-3 col-sm-6">
				<section class="panel">
					<div class="symbol red">
						<i class="icon-tags"></i>
					</div>
					<div class="value">
						<h1>140</h1>
						<p>交易笔数</p>
					</div>
				</section>
			</div>
			<div class="col-lg-3 col-sm-6">
				<section class="panel">
					<div class="symbol yellow">
						<i class="icon-shopping-cart"></i>
					</div>
					<div class="value">
						<h1>345</h1>
						<p>商城订单</p>
					</div>
				</section>
			</div>
			<div class="col-lg-3 col-sm-6">
				<section class="panel">
					<div class="symbol blue">
						<i class="icon-bar-chart"></i>
					</div>
					<div class="value">
						<h1>￥34,500</h1>
						<p>交易金额</p>
					</div>
				</section>
			</div>
		</div>
	</div>
</body>
</html>
