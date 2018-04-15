<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include/taglib.jsp"%>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>网站后台管理系统</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<!-- css样式 -->
	<link href="${ctxJsAndCss}/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="${ctxJsAndCss}/assets/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
	<link href="${ctxJsAndCss}/assets/css/ace.min.css" rel="stylesheet" type="text/css" />
	<link href="${ctxJsAndCss}/assets/css/ace-rtl.min.css" rel="stylesheet" type="text/css" />
	<link href="${ctxJsAndCss}/assets/css/ace-skins.min.css" rel="stylesheet" type="text/css" />
    <link href="${ctxJsAndCss}/css/style.css" rel="stylesheet" type="text/css" />
	<!-- js脚本 -->
	<script src="${ctxJsAndCss}/assets/js/ace-extra.min.js"></script>
	<script src="${ctxJsAndCss}/js/jquery-1.9.1.min.js"></script>        
	<script src="${ctxJsAndCss}/assets/js/bootstrap.min.js"></script>
	<script src="${ctxJsAndCss}/assets/js/typeahead-bs2.min.js"></script>
	<script src="${ctxJsAndCss}/assets/js/ace-elements.min.js"></script>
	<script src="${ctxJsAndCss}/assets/js/ace.min.js"></script>
    <script src="${ctxJsAndCss}/assets/layer/layer.js"></script>
	<script src="${ctxJsAndCss}/assets/laydate/laydate.js"></script>
	
	<script type="text/javascript">
		$(function() {
			var cid = $('#nav_list> li>.submenu');
			cid.each(function(i) {
				$(this).attr('id', "Sort_link_" + i);
			});
		});
		jQuery(document).ready(function() {
			$.each($(".submenu"), function() {
				var $aobjs = $(this).children("li");
				var rowCount = $aobjs.size();
				var divHeigth = $(this).height();
				$aobjs.height(divHeigth / rowCount);
			});
			//初始化宽度、高度    
			$("#main-container").height($(window).height() - 76);
			$("#iframe").height($(window).height() - 140);
		
			$(".sidebar").height($(window).height() - 99);
			var thisHeight = $("#nav_list").height(
					$(window).outerHeight() - 173);
			$(".submenu").height();
			$("#nav_list").children(".submenu").css("height", thisHeight);
		
			//当文档窗口发生改变时 触发  
			$(window).resize(function() {
				$("#main-container").height(
						$(window).height() - 76);
				$("#iframe").height(
						$(window).height() - 140);
				$(".sidebar").height(
						$(window).height() - 99);
				var thisHeight = $("#nav_list").height(
						$(window).outerHeight() - 173);
				$(".submenu").height();
				$("#nav_list").children(".submenu").css(
						"height", thisHeight);
			});
			$(".iframeurl").click(function() {
				var cid = $(this).attr("name");
				var cname = $(this).attr("title");
				$("#iframe").attr("src", cid).ready();
				$("#Bcrumbs").attr("href", cid).ready();
				$(".Current_page a").attr('href', cid).ready();
				$(".Current_page").attr('name', cid);
				$(".Current_page").html(cname)
					.css({"color" : "#333333", "cursor" : "default"}).ready();
				$("#parentIframe")
					.html('<span class="parentIframe iframeurl"> </span>')
					.css("display", "none")
					.ready();
				$("#parentIfour").html('').css("display", "none").ready();
			});
		});

		/*********************点击事件*********************/
		$(document).ready(function() {
			$('#nav_list').find('li.home').click(function() {
				$('#nav_list').find('li.home').removeClass('active');
				$(this).addClass('active');
			});
			//时间设置
			function currentTime() {
				var d = new Date(), str = '';
				str += d.getFullYear() + '年';
				str += d.getMonth() + 1 + '月';
				str += d.getDate() + '日';
				str += d.getHours() + '时';
				str += d.getMinutes() + '分';
				str += d.getSeconds() + '秒';
				return str;
			}
			$('#time').html(currentTime);
			setInterval(function() {
				$('#time').html(currentTime);
			}, 1000);
			//修改密码-start
			$('.change_Password').on('click',function() {
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
								|| $("#c_mew_pas").val() != $(
										"#Nes_pas").val()) {
							layer.alert('密码不一致!', {
								title : '提示框',
								icon : 0,
	
							});
							return false;
						} else {
							layer.alert('修改成功！', {
								title : '提示框',
								icon : 1,
							});
							layer.close(index);
						}
					}
				});
			});
			//修改密码-end
			$('#Exit_system').on('click', function() {
				layer.confirm('是否确定退出系统？', {
					btn : [ '是', '否' ],//按钮
					icon : 2,
				}, function() {
					location.href = "${ctx}/logoutAdmin";
				});
			});
		})
	</script>
</head>
<body>
	<div class="navbar navbar-default" id="navbar">
		<script type="text/javascript">
			try {
				ace.settings.check('navbar', 'fixed')
			} catch (e) {
			}
		</script>
		<div class="navbar-container" id="navbar-container">
			<div class="navbar-header pull-left">
				<a href="${ctx}/admin/main" class="navbar-brand">
					<small>
						<img src="${ctxJsAndCss}/images/logo.png">
					</small>
				</a>
			</div>
			<div class="navbar-header pull-right" role="navigation">
				<ul class="nav ace-nav">
					<li class="light-blue">
						<a data-toggle="dropdown" href="#" class="dropdown-toggle">
							<span class="time">
								<em id="time"></em>
							</span>
							<span class="user-info">
								<small>欢迎光临</small>
								<span id="login-hint">${admin.adminName}</span>
								<span id="login-sex">
									<c:choose>
										<c:when test="${admin.sex eq '男'}">先生</c:when>
										<c:otherwise>女士</c:otherwise>
									</c:choose>
								</span>
							</span> 
							<i class="icon-caret-down"></i>
						</a>
						<ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
							<li>
								<a href="#"><i class="icon-cog"></i>设置</a>
							</li>
							<li>
								<a href="#"><i class="icon-user"></i>个人资料</a>
							</li>
							<li class="divider"></li>
							<li>
								<a href="#" id="Exit_system"><i class="icon-off"></i>退出</a>
							</li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<!-- 页面主体 -->
	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>
		<div class="main-container-inner">
			<a class="menu-toggler" id="menu-toggler" href="#">
				<span class="menu-text"></span>
			</a>
			<div class="sidebar" id="sidebar">
				<script type="text/javascript">
					try {
						ace.settings.check('sidebar', 'fixed')
					} catch (e) {
					}
				</script>
				<div class="sidebar-shortcuts" id="sidebar-shortcuts">
					<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
						网站后台管理系统
					</div>
					<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
						<span class="btn btn-success"></span>
						<span class="btn btn-info"></span>
						<span class="btn btn-warning"></span>
						<span class="btn btn-danger"></span>
					</div>
				</div>
				<!-- 手风琴菜单 -->
				<ul class="nav nav-list" id="nav_list">
					<li class="home">
						<a href="javascript:void(0)" name="${ctx}/sysmgr/home" class="iframeurl" title="">
							<i class="icon-dashboard"></i>
							<span class="menu-text"> 系统首页 </span>
						</a>
					</li>
					<li><a href="#" class="dropdown-toggle"><i
							class="icon-user"></i><span class="menu-text"> 会员管理 </span><b
							class="arrow icon-angle-down"></b></a>
						<ul class="submenu">
							<li class="home"><a href="javascript:void(0)"
								name="${ctx}/sysmgr/member/gotoMemberList" title="会员列表" class="iframeurl"><i
									class="icon-double-angle-right"></i>会员列表</a></li>
						</ul></li>
					<li><a href="#" class="dropdown-toggle"><i
							class="icon-edit"></i><span class="menu-text"> 类目管理 </span><b
							class="arrow icon-angle-down"></b></a>
						<ul class="submenu">
							<li class="home">
								<a href="${ctx}/sysmgr/category/category1/gotoCategory1List" target="iframe"
									name="" title="一级类目管理" class="iframeurl">
									<i class="icon-double-angle-right"></i>一级类目管理
								</a>
							</li>
							<li class="home">
								<a href="${ctx}/sysmgr/category/category2/gotoCategory2List" target="iframe"
									name="" title="二级类目管理" class="iframeurl">
									<i class="icon-double-angle-right"></i>二级类目管理
								</a>
							</li>
						</ul></li>
					<li>
						<a href="#" class="dropdown-toggle">
							<i class="icon-desktop"></i>
							<span class="menu-text"> 商品管理 </span>
							<b class="arrow icon-angle-down"></b>
						</a>
						<ul class="submenu">
							<li class="home">
								<a href="${ctx}/sysmgr/product/gotoProductList" name="" target="iframe" title="产品列表" class="iframeurl">
									<i class="icon-double-angle-right"></i>产品列表
								</a>
							</li>
							<li class="home">
								<a href="${ctx}/sysmgr/product/gotoProductEdit/-1" name="" target="iframe" title="添加商品" class="iframeurl">
									<i class="icon-double-angle-right"></i>添加商品
								</a>
							</li>
						</ul>
					</li>
					<li><a href="#" class="dropdown-toggle"><i
							class="icon-list"></i><span class="menu-text"> 订单管理 </span><b
							class="arrow icon-angle-down"></b></a>
						<ul class="submenu">
							<li class="home"><a href="javascript:void(0)"
								name="transaction.html" title="交易信息" class="iframeurl"><i
									class="icon-double-angle-right"></i>交易信息</a></li>
							<li class="home"><a href="javascript:void(0)"
								name="Orderform.html" title="订单管理" class="iframeurl"><i
									class="icon-double-angle-right"></i>订单管理</a></li>
							<li class="home"><a href="javascript:void(0)"
								name="Amounts.html" title="交易金额" class="iframeurl"><i
									class="icon-double-angle-right"></i>交易金额</a></li>
							<li class="home"><a href="javascript:void(0)"
								name="Order_handling.html" title="订单处理" class="iframeurl"><i
									class="icon-double-angle-right"></i>订单处理</a></li>
							<li class="home"><a href="javascript:void(0)"
								name="Cover_management.html" title="支付管理" class="iframeurl"><i
									class="icon-double-angle-right"></i>支付管理</a></li>
						</ul></li>
					<li><a href="#" class="dropdown-toggle"><i
							class="icon-cogs"></i><span class="menu-text"> 系统管理 </span><b
							class="arrow icon-angle-down"></b></a>
						<ul class="submenu">
							<li class="home"><a href="javascript:void(0)"
								name="Systems.html" title="系统设置" class="iframeurl"><i
									class="icon-double-angle-right"></i>系统设置</a></li>
							<li class="home"><a href="javascript:void(0)"
								name="菜单管理.html" title="栏目管理" class="iframeurl"><i
									class="icon-double-angle-right"></i>栏目管理</a></li>

							<li class="home"><a href="javascript:void(0)"
								name="用户管理.html" title="系统日志" class="iframeurl"><i
									class="icon-double-angle-right"></i>系统日志</a></li>
						</ul></li>
					<li><a href="#" class="dropdown-toggle"><i class="icon-group"></i><span class="menu-text"> 管理员管理 </span><b class="arrow icon-angle-down"></b></a>
							<ul class="submenu">
                                <li class="home">
                                	<a href="${ctx}/sysmgr/admin/gotoAdminList" target="iframe" name="" title="管理员列表" class=""><i class="icon-double-angle-right"></i>管理员列表</a>
                                </li>
								<li class="home">
									<a href="${ctx}/sysmgr/admin/gotoAdminInfo" target="iframe" name="" title="个人信息" class=""><i class="icon-double-angle-right"></i>个人信息</a>
								</li>
							</ul>
						</li>
				</ul>
				<div class="sidebar-collapse" id="sidebar-collapse">
					<i class="icon-double-angle-left"
						data-icon1="icon-double-angle-left"
						data-icon2="icon-double-angle-right"></i>
				</div>
				<script type="text/javascript">
					try {
						ace.settings.check('sidebar', 'collapsed')
					} catch (e) {
					}
				</script>
			</div>
			<div class="main-content">
				<script type="text/javascript">
					try {
						ace.settings.check('breadcrumbs', 'fixed')
					} catch (e) {
					}
				</script>
				<div class="breadcrumbs" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="icon-home home-icon"></i> <a href="${ctx}/sysmgr/home" target="iframe">首页</a>
						</li>
						<li class="active"><span class="Current_page iframeurl"></span></li>
						<li class="active" id="parentIframe"><span
							class="parentIframe iframeurl"></span></li>
						<li class="active" id="parentIfour"><span
							class="parentIfour iframeurl"></span></li>
					</ul>
				</div>

				<iframe id="iframe"
					style="border: 0; width: 100%; background-color: #FFF;"
					name="iframe" frameborder="0" src="${ctx}/sysmgr/home"> </iframe>
			</div>

			<div class="ace-settings-container" id="ace-settings-container">
				<div class="btn btn-app btn-xs btn-warning ace-settings-btn"
					id="ace-settings-btn">
					<i class="icon-cog bigger-150"></i>
				</div>

				<div class="ace-settings-box" id="ace-settings-box">
					<div>
						<div class="pull-left">
							<select id="skin-colorpicker" class="hide">
								<option data-skin="default" value="#438EB9">#438EB9</option>
								<option data-skin="skin-1" value="#222A2D">#222A2D</option>
								<option data-skin="skin-2" value="#C6487E">#C6487E</option>
								<option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
							</select>
						</div>
						<span>&nbsp; 选择皮肤</span>
					</div>

					<div>
						<input type="checkbox" class="ace ace-checkbox-2"
							id="ace-settings-sidebar" /> <label class="lbl"
							for="ace-settings-sidebar"> 固定滑动条</label>
					</div>

					<div>
						<input type="checkbox" class="ace ace-checkbox-2"
							id="ace-settings-rtl" /> <label class="lbl"
							for="ace-settings-rtl">切换到左边</label>
					</div>

					<div>
						<input type="checkbox" class="ace ace-checkbox-2"
							id="ace-settings-add-container" /> <label class="lbl"
							for="ace-settings-add-container"> 切换窄屏 <b></b>
						</label>
					</div>
				</div>
			</div>
		</div>

	</div>
	<!--底部样式-->
	<div class="footer_style" id="footerstyle">
		<p>Copyright 版权所有 2018 - 2018 Powered by 曲健磊</p>
	</div>
	<!--修改密码样式-->
	<div class="change_Pass_style" id="change_Pass">
		<ul class="xg_style">
			<li><label class="label_name">原&nbsp;&nbsp;密&nbsp;码</label><input
				name="原密码" type="password" class="" id="password"></li>
			<li><label class="label_name">新&nbsp;&nbsp;密&nbsp;码</label><input
				name="新密码" type="password" class="" id="Nes_pas"></li>
			<li><label class="label_name">确认密码</label><input name="再次确认密码"
				type="password" class="" id="c_mew_pas"></li>
		</ul>
	</div>
</body>
</html>
