<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include/taglib.jsp"%>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>一级分类管理</title>
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<!-- css样式 -->
	<link href="${ctxJsAndCss}/assets/css/bootstrap.min.css" rel="stylesheet" />
	<link rel="stylesheet" href="${ctxJsAndCss}/css/style.css" />
	<link href="${ctxJsAndCss}/assets/css/codemirror.css" rel="stylesheet">
	<link rel="stylesheet" href="${ctxJsAndCss}/assets/css/ace.min.css" />
	<link rel="stylesheet" href="${ctxJsAndCss}/font/css/font-awesome.min.css" />
	<!--[if lte IE 8]>
		<link rel="stylesheet" href="${ctxJsAndCss}/assets/css/ace-ie.min.css" />
	<![endif]-->
	<script src="${ctxJsAndCss}/js/jquery-1.9.1.min.js"></script>
	<script src="${ctxJsAndCss}/assets/js/typeahead-bs2.min.js"></script>
	<script src="${ctxJsAndCss}/js/lrtk.js"></script>
	<script src="${ctxJsAndCss}/assets/js/jquery.dataTables.min.js"></script>
	<script src="${ctxJsAndCss}/assets/js/jquery.dataTables.bootstrap.js"></script>
	<script src="${ctxJsAndCss}/assets/layer/layer.js"></script>
	<script src="${ctxJsAndCss}/js/date.js"></script>
	<script type="text/javascript">
		var category1Mgr = {
			isChecked : false,
			// 选中或取消选中所有一级类目
			toggleCheck : function() {
				// 获取所有的checkbox
				var boxes = $("#sample-table tbody").find("input[type='checkbox']");
				// 获取所有的checkbox的数量
				var allCheckBoxNums = boxes.length;
				// 先获取选中的checkbox的个数
				var checkedNums = $("#sample-table tbody")
					.find("input[type='checkbox']:checked").length;
				
				// true表示还未选中,false表示已经选中
				var toggleCheckBox = $("#toggleCheckBox").prop("checked");
				
				// 未选中
				if (toggleCheckBox) {
					// 只有全部被选中的情况才把所有的checkbox都取消选中，只要有一个checkbox没有被选中，就全部选中
					if (allCheckBoxNums != checkedNums) {
						//alert("将全部选中checkbox");
						$.each(boxes,function(){
							$(this).prop("checked","checked");
						});
					}
				} else { // 选中
					//alert("将会取消所有checkbox的选中");
					$.each(boxes,function(){
						$(this).removeProp("checked");
					});
				}
			},
			// 查询一级类目列表
			listCategory1 : function(pageNo, pageSize) {
				var category1Name = $("#category1Name").val();
				$.ajax({
					type : "post",
					url : "${ctx}/sysmgr/category/category1/listCategory1",
					data : {"category1Name" : category1Name, "pageNo" : pageNo, "pageSize" : pageSize},
					dataType : "json",
					success : function(data) {
						// 获取分页条
						var pageBar = data.pageBar;
						// 获取一级类目列表
						var category1List = data.category1List;
						// 获取一级类目的总记录数
						var listSize = data.listSize;
						
						var htmlTable = "";
						if (category1List.length > 0) {
							for (var i = 0; i < category1List.length; i++) {
								// 标签的样式
								var labelText = "";
								// td标签中显示的文字
								var tdText = "";
								// 按钮样式
								var btnStyle = "";
								// 点击事件是开启还是关闭
								var btnEvent = "";
								// 鼠标悬停时的文字
								var hoverTitle = "";
								// 
								var checkOrClose = "";
								
								if (category1List[i].showFlag == "1") { // 显示
									labelText = "label-success";
									tdText = "显示";
									btnStyle = "btn-success";
									btnEvent = "member_stop(this,\'10001\')";
									hoverTitle = "关闭";
									checkOrClose = "fa-check";
								} else { // 已关闭
									labelText = "label-default";
									tdText = "已关闭";
									btnEvent = "member_start(this,\'10001\')";
									hoverTitle = "显示";
									checkOrClose = "fa-close";
								}
								htmlTable =
									htmlTable + "<tr>"+
									"				<td><label><input type=\"checkbox\" class=\"ace\"><span"+
									"						class=\"lbl\"></span></label></td>"+
									"				<td>" + category1List[i].category1Id + "</td>"+
									"				<td>" + category1List[i].category1Name + "</td>"+
									"				<td>" + category1List[i].category1Record + "</td>"+
									"				<td>" + timestampToTime(category1List[i].gmtCreate) + "</td>"+
									"				<td class=\"td-status\"><span"+
									"					class=\"label " + labelText + " radius\">" + tdText + "</span></td>"+
									"				<td class=\"td-manage\">"+
									"					<a onClick=\" " + btnEvent + " \""+
									"						href=\"javascript:;\" title=\"  "+ hoverTitle +"  \" class=\"btn btn-xs " + btnStyle + "\">"+
									"						<i class=\"fa " + checkOrClose + " bigger-120\"></i>"+
									"					</a>"+
									"					<a title=\"编辑\" onclick=\"member_edit(\'编辑\',\'member-add.html\',\'4\',\'\',\'510\')\""+
									"						href=\"javascript:;\" class=\"btn btn-xs btn-info\">"+
									"						<i class=\"fa fa-edit bigger-120\"></i>"+
									"					</a>"+
									"					<a title=\"删除\" href=\"javascript:;\" onclick=\"member_del(this,\'1\')\""+
									"						class=\"btn btn-xs btn-warning\">"+
									"						<i class=\"fa fa-trash  bigger-120\"></i>"+
									"					</a>"+
									"				</td>"+
									"			</tr>";
							}
						} else {
							htmlTable = "<tr><td>没有查询到类目记录</td></tr>";
						}
						$("#sample-table tbody").html(htmlTable);
						$("#totalPage").html(listSize);
						$("#pageBar").html(pageBar);
					}
				});
			}
		}
	</script>
</head>
<body>
	<div class="page-content clearfix">
		<div class="search_style">
			<div class="title_names">搜索查询</div>
			<ul class="search_content clearfix">
				<li><label class="l_f">一级类目名称</label><input id="category1Name" name="category1Name" type="text"
					class="text_add" placeholder="输入一级类目名称" style="width: 400px" /></li>
				<li style="width: 90px;">
					<button type="button" class="btn_search" onclick="category1Mgr.listCategory1(1, 5);">
						<i class="icon-search"></i>查询
					</button>
				</li>
			</ul>
		</div>
		<div class="sort_style">
			<div class="border clearfix">
				<span class="l_f"> <a href="javascript:ovid()" id="sort_add"
					class="btn btn-warning"><i class="fa fa-plus"></i> 添加分类</a> <a
					href="javascript:ovid()" class="btn btn-danger"><i
						class="fa fa-trash"></i> 批量删除</a>
				</span> <span class="r_f">共：<b id="totalPage"></b>类
				</span>
			</div>
			<div class="sort_list">
				<table class="table table-striped table-bordered table-hover"
					id="sample-table">
					<thead>
						<tr>
							<th width="25px">
								<label>
									<input id="toggleCheckBox" type="checkbox" class="ace" onclick="category1Mgr.toggleCheck();">
									<span class="lbl"></span>
								</label>
							</th>
							<th width="50px">ID</th>
							<th width="100px">一级类目名称</th>
							<th width="350px">描述</th>
							<th width="180px">创建时间</th>
							<th width="70px">状态</th>
							<th width="250px">操作</th>
						</tr>
					</thead>
					<tbody>
						
					</tbody>
				</table>
				<div id="pageBar">
					<!-- 分页条的位置 -->
				</div>
			</div>
		</div>
	</div>
	<!--添加分类-->
	<div class="sort_style_add margin" id="sort_style_add"
		style="display: none">
		<div class="">
			<ul>
				<li><label class="label_name">分类名称</label>
				<div class="col-sm-9">
						<input name="分类名称" type="text" id="form-field-1" placeholder=""
							class="col-xs-10 col-sm-5">
					</div></li>
				<li><label class="label_name">分类说明</label>
				<div class="col-sm-9">
						<textarea name="分类说明" class="form-control" id="form-field-8"
							placeholder="" onkeyup="checkLength(this);"></textarea>
						<span class="wordage">剩余字数：<span id="sy"
							style="color: Red;">200</span>字
						</span>
					</div></li>
				<li><label class="label_name">分类状态</label> <span
					class="add_content"> &nbsp;&nbsp;<label><input
							name="form-field-radio1" type="radio" checked="checked"
							class="ace"><span class="lbl">显示</span></label>&nbsp;&nbsp;&nbsp;
						<label><input name="form-field-radio1" type="radio"
							class="ace"><span class="lbl">隐藏</span></label></span></li>
			</ul>
		</div>
	</div>
<script type="text/javascript">
	$('#sort_add').on(
			'click',
			function() {
				layer.open({
					type : 1,
					title : '添加分类',
					maxmin : true,
					shadeClose : false, //点击遮罩关闭层
					area : [ '750px', '' ],
					content : $('#sort_style_add'),
					btn : [ '提交', '取消' ],
					yes : function(index, layero) {
						var num = 0;
						var str = "";
						$(".sort_style_add input[type$='text']").each(
								function(n) {
									if ($(this).val() == "") {

										layer.alert(str += ""
												+ $(this).attr("name")
												+ "不能为空！\r\n", {
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
							layer.alert('添加成功！', {
								title : '提示框',
								icon : 1,
							});
							layer.close(index);
						}
					}
				});
			})

	function checkLength(which) {
		var maxChars = 200; //
		if (which.value.length > maxChars) {
			layer.open({
				icon : 2,
				title : '提示框',
				content : '您出入的字数超多限制!',
			});
			// 超过限制的字数了就将 文本框中的内容按规定的字数 截取
			which.value = which.value.substring(0, maxChars);
			return false;
		} else {
			var curr = maxChars - which.value.length; //250 减去 当前输入的
			document.getElementById("sy").innerHTML = curr.toString();
			return true;
		}
	};
	/*广告图片-停用*/
	function member_stop(obj, id) {
		layer.confirm(
			'确认要关闭吗？',
			{
				icon : 0,
			},
			function(index) {
				$(obj)
						.parents("tr")
						.find(".td-manage")
						.prepend(
								'<a style="text-decoration:none" class="btn btn-xs " onClick="member_start(this,id)" href="javascript:;" title="显示"><i class="fa fa-close bigger-120"></i></a>');
				$(obj)
						.parents("tr")
						.find(".td-status")
						.html(
								'<span class="label label-defaunt radius">已关闭</span>');
				$(obj).remove();
				layer.msg('关闭!', {
					icon : 5,
					time : 1000
				});
			});
	}
	/*广告图片-启用*/
	function member_start(obj, id) {
		layer
			.confirm(
					'确认要显示吗？',
					{
						icon : 0,
					},
					function(index) {
						$(obj)
								.parents("tr")
								.find(".td-manage")
								.prepend(
										'<a style="text-decoration:none" class="btn btn-xs btn-success" onClick="member_stop(this,id)" href="javascript:;" title="关闭"><i class="fa fa-check  bigger-120"></i></a>');
						$(obj)
								.parents("tr")
								.find(".td-status")
								.html(
										'<span class="label label-success radius">显示</span>');
						$(obj).remove();
						layer.msg('显示!', {
							icon : 6,
							time : 1000
						});
					});
	}
	/*广告图片-删除*/
	function member_del(obj, id) {
		layer.confirm('确认要删除吗？', {
			icon : 0,
		}, function(index) {
			$(obj).parents("tr").remove();
			layer.msg('已删除!', {
				icon : 1,
				time : 1000
			});
		});
	}
	//面包屑返回值
	var index = parent.layer.getFrameIndex(window.name);
	parent.layer.iframeAuto(index);
	$('.Order_form ,.ads_link').on('click', function() {
		var cname = $(this).attr("title");
		var cnames = parent.$('.Current_page').html();
		var herf = parent.$("#iframe").attr("src");
		parent.$('#parentIframe span').html(cname);
		parent.$('#parentIframe').css("display", "inline-block");
		parent.$('.Current_page').attr("name", herf).css({
			"color" : "#4c8fbd",
			"cursor" : "pointer"
		});
		//parent.$('.Current_page').html("<a href='javascript:void(0)' name="+herf+">" + cnames + "</a>");
		parent.layer.close(index);

	});
	function AdlistOrders(id) {
		window.location.href = "Ads_list.html?=" + id;
	};
</script>
</body>
</html>