<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include/taglib.jsp"%>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>商品管理</title>
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
	<link rel="stylesheet" href="${ctxJsAndCss}/css/select2.min.css" />
	<!--[if lte IE 8]>
		<link rel="stylesheet" href="${ctxJsAndCss}/assets/css/ace-ie.min.css" />
	<![endif]-->
	<script src="${ctxJsAndCss}/js/jquery-1.9.1.min.js"></script>
	<script src="${ctxJsAndCss}/js/select2.min.js"></script>
	<script src="${ctxJsAndCss}/assets/js/typeahead-bs2.min.js"></script>
	<script src="${ctxJsAndCss}/js/lrtk.js"></script>
	<script src="${ctxJsAndCss}/assets/js/jquery.dataTables.min.js"></script>
	<script src="${ctxJsAndCss}/assets/js/jquery.dataTables.bootstrap.js"></script>
	<script src="${ctxJsAndCss}/assets/layer/layer.js"></script>
	<script src="${ctxJsAndCss}/js/date.js"></script>
	<script type="text/javascript">
		var productMgr = {
			isChecked : false,
			// 选中或取消选中所有商品
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
					$.each(boxes,function(){
						$(this).removeProp("checked");
					});
				}
			},
			// 查询商品列表
			listProduct : function(pageNo, pageSize) {
				var productName = $("#queryProductName").val();
				var category1Id = $("#queryCategory1").val();
				var product = {
					"productName" : productName,
					"category1Id" : category1Id
				};
				product = JSON.stringify(product);
				var pageNum = 1;
				var pageSize = 5;
				$.ajax({
					type : "post",
					url : "${ctx}/sysmgr/product/listProduct/" + pageNum + "/" + pageSize,
					data : product,
					dataType : "json",
					contentType : "application/json;charset=utf-8",
					success : function(data) {
						// 获取分页条
						var pageBar = data.pageBar;
						// 获取商品列表
						var productList = data.productList;
						// 获取商品的总记录数
						var listSize = data.listSize;
						
						var htmlTable = "";
						if (productList.length > 0) {
							for (var i = 0; i < productList.length; i++) {
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
								// 开启还是关闭类目
								var checkOrClose = "";
								
								if (productList[i].showFlag == "1") { // 显示
									labelText = "label-success";
									tdText = "显示";
									btnStyle = "btn-success";
									btnEvent = "member_stop(this," + productList[i].productId + ")";
									hoverTitle = "关闭";
									checkOrClose = "fa-check";
								} else { // 已关闭
									labelText = "label-default";
									tdText = "已关闭";
									btnEvent = "member_start(this," + productList[i].productId  + ")";
									hoverTitle = "显示";
									checkOrClose = "fa-close";
								}
								htmlTable =
									htmlTable + "<tr>"+
									"				<td><label><input type=\"checkbox\" class=\"ace\" value=" +productList[i].productId + "><span"+
									"						class=\"lbl\"></span></label></td>"+
									"				<td>" + productList[i].productId + "</td>"+
									"				<td>" + productList[i].productName + "</td>"+
									"				<td>" + productList[i].category1Name + "</td>"+
									"				<td>" + productList[i].category2Name + "</td>"+
									"				<td>" + productList[i].purchasePrice + "</td>"+
									"				<td>" + productList[i].salePrice + "</td>"+
									"				<td>" + timestampToTime(productList[i].gmtCreate) + "</td>"+
									"				<td class=\"td-status\"><span"+
									"					class=\"label " + labelText + " radius\">" + tdText + "</span></td>"+
									"				<td class=\"td-manage\">"+
									"					<a onClick=\" " + btnEvent + " \""+
									"						href=\"javascript:;\" title=\"  "+ hoverTitle +"  \" class=\"btn btn-xs " + btnStyle + "\">"+
									"						<i class=\"fa " + checkOrClose + " bigger-120\"></i>"+
									"					</a>"+
									"					<a title=\"编辑\" onclick=\"productMgr.productEdit(" + productList[i].productId + ")\" "+
									"						href=\"javascript:;\" class=\"btn btn-xs btn-info\">"+
									"						<i class=\"fa fa-edit bigger-120\"></i>"+
									"					</a>"+
									"					<a title=\"删除\" href=\"javascript:;\" onclick=\"member_del(this," + productList[i].productId + ")\""+
									"						class=\"btn btn-xs btn-warning\">"+
									"						<i class=\"fa fa-trash  bigger-120\"></i>"+
									"					</a>"+
									"				</td>"+
									"			</tr>";
							}
						} else {
							htmlTable = "<tr><td colspan=8>没有查询到类目记录</td></tr>";
						}
						$("#sample-table tbody").html(htmlTable);
						$("#totalPage").html(listSize);
						$("#pageBar").html(pageBar);
					}
				});
			},
			// 编辑商品
			productEdit : function (productId) {
				// 1.修改商品的时候先要通过传入的id去后台查询一下当前类目的详细信息，然后赋值到页面
				$.ajax({
					type : "post",
					url : "${ctx}/sysmgr/category/product/getProductById",
					data : {"productId" : productId},
					dataType : "json",
					success : function(data) {
						var product = data.product;
						$("#productId").val(product.productId);
						$("#productName").val(product.productName);
						$("#productRecord").val(product.productRecord);
						$("#category1Id").val(product.category1Id);
						if (product.showFlag == 1) { // 显示
							$("#show").prop("checked","checked");
						} else { // 隐藏
							$("#hide").prop("checked","checked");
						}
					}
				});
				
				layer.open({
					type : 1,
					title : '修改商品',
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
							// 1.序列化商品表单
							var jsonObj = $("#saveProductForm").serializeArray();
							// 2.构造js对象
							var productObj = {};
							$.each(jsonObj,function(i, item){
								productObj[item.name] = item.value;
							});
							// 3.转化成json格式的字符串
							productObj = JSON.stringify(productObj);
							// 4.向后台发送ajax请求
							$.ajax({
								type : "post",
								contentType : "application/json;charset=utf-8;",
								url : "${ctx}/sysmgr/category/product/saveProduct",
								data : productObj,
								dataType : "json",
								success : function(data) {
									if (data.message == "修改商品成功") {
										productMgr.listProduct(1, 5);
										layer.alert('修改商品成功！', {
											title : '提示框',
											icon : 1,
										});
										layer.close(index);
									} else {
										layer.alert('修改商品失败，请联系系统管理员！', {
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
			},
			// 批量删除商品
			removeProductBatch : function() {
				// 1.获取选中的商品
				var checkBoxs = $("#sample-table")
					.find("tbody")
					.find("input[type='checkbox']:checked");
				var productIdArray = new Array();
				$.each(checkBoxs,function(){
					productIdArray.push($(this).val());
				});
				if (productIdArray.length == 0) {
					layer.msg("请先选择要删除的商品！",{icon:0,time:1000});
					return false;
				}
				productIdArray = JSON.stringify(productIdArray);
				layer.confirm('确认要删除这些商品吗？',function(index){
					// 2.发送ajax请求进行批量删除
					$.ajax({
						type : "post",
						contentType : "application/json;charset=UTF-8",
						url : "${ctx}/sysmgr/category/product/removeProductBatch",
						data : productIdArray,
						dataType : "json",
						success : function(data) {
							if (data.message == "批量删除二级分类成功") {
								layer.msg(data.message,{icon:1,time:1000});
								// 3.删除成功重新查询列表
								location.reload();
								productMgr.listProduct(1, 5);
							} else {
								// 4.删除失败给出提示信息
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
		<div class="search_style">
			<div class="title_names">搜索查询</div>
			<ul class="search_content clearfix">
				<li>
					<label class="l_f" style="margin-right:10px;margin-top:2px;">商品名称</label>
					<!-- 此处修改为下拉列表select2 -->	
					<select id="queryProductName" name="productName" class="text_add" 
						style="width:200px;margin-left:0;">
						<option value="all">所有商品</option>
				        <c:forEach items="${productNames}" var="productName">
				        	<option value="${productName}">${productName}</option>
				        </c:forEach>
				    </select>
				</li>
				<li>
					<label class="l_f" style="margin-right:10px;margin-top:2px;">一级类目名称</label>
					<!-- 此处修改为下拉列表select2 -->
					<select id="queryCategory1" name="category1" class="text_add" 
						style="width:200px;margin-left:0;">
						<option value="0">所有一级类目</option>
				        <c:forEach items="${category1List}" var="category1">
				        	<option value="${category1.category1Id}">${category1.category1Name}</option>
				        </c:forEach>
				    </select>
				</li>
				<li style="width: 90px;">
					<button type="button" class="btn_search" onclick="productMgr.listProduct(1, 5);">
						<i class="icon-search"></i>查询
					</button>
				</li>
			</ul>
		</div>
		<div class="sort_style">
			<div class="border clearfix">
				<span class="l_f"> <a href="${ctx}/sysmgr/product/gotoProductEdit" id="sort_add"
					class="btn btn-warning"><i class="fa fa-plus"></i>添加商品</a> <a
					href="javascript:productMgr.removeProductBatch();" class="btn btn-danger"><i
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
									<input id="toggleCheckBox" type="checkbox" class="ace" onclick="productMgr.toggleCheck();">
									<span class="lbl"></span>
								</label>
							</th>
							<th width="50px">商品编号</th>
							<th width="100px">商品名称</th>
							<th width="150px">所属一级类目</th>
							<th width="150px">所属二级类目</th>
							<th width="100px">市场价</th>
							<th width="100px">销售价</th>
							<th width="180px">添加时间</th>
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
	<div class="sort_style_add margin" id="sort_style_add" style="display: none">
		<div class="">
			<form action="#" id="saveProductForm">
				<ul>
					<li>
						<input id="productId" name="productId" type="hidden" value="" >
						<label class="label_name">分类名称</label>
						<div class="col-sm-6">
							<input id="productName" name="productName" type="text" id="form-field-1" placeholder=""
								class="col-xs-9 col-sm-8">
						</div>
					</li>
					<li>
						<label class="label_name">所属一级类目</label>
						<div class="col-sm-8">
							<select id="category1Id" name="category1Id" class="text_add" 
								style="width:200px;margin-left:0;">
						        <c:forEach items="${category1List}" var="category1">
						        	<option value="${category1.category1Id}">${category1.category1Name}</option>
						        </c:forEach>
						    </select>
						</div>
					</li>
					<li>
						<label class="label_name">分类说明</label>
						<div class="col-sm-8">
							<textarea id="productRecord" name="productRecord" class="form-control" id="form-field-8"
								placeholder="" onkeyup="checkLength(this);"></textarea>
							<span class="wordage">剩余字数：
								<span id="sy" style="color: Red;">200</span>字
							</span>
						</div>
					</li>
					<li>
						<label class="label_name">分类状态</label>
						<span class="add_content"> &nbsp;&nbsp;
							<label>
								<input id="show" name="showFlag" type="radio" checked="checked"
									class="ace" value="1">
								<span class="lbl">显示</span>
							</label>&nbsp;&nbsp;&nbsp;
							<label>
								<input id="hide" name="showFlag" type="radio" class="ace" value="0">
								<span class="lbl">隐藏</span>
							</label>
						</span>
					</li>
				</ul>
			</form>
		</div>
	</div>
<script type="text/javascript">
	// 添加商品
	$('#sort_add').on(
			'click',
			function() {
				// 先清空表单中上一次添加类目之后的残留数据
				$("#productId").val("");
				$("#productName").val("");
				$("#productRecord").val("");
				$("#show").prop("checked", "checked");
				layer.open({
					type : 1,
					title : '添加商品',
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
							// 1.序列化商品表单
							var jsonObj = $("#saveProductForm").serializeArray();
							// 2.构造js对象
							var productObj = {};
							$.each(jsonObj,function(i, item){
								productObj[item.name] = item.value;
							});
							// 3.转化成json格式的字符串
							productObj = JSON.stringify(productObj);
							// 4.向后台发送ajax请求
							$.ajax({
								type : "post",
								contentType : "application/json;charset=utf-8;",
								url : "${ctx}/sysmgr/category/product/saveProduct",
								data : productObj,
								dataType : "json",
								success : function(data) {
									if (data.message == "新增二级分类成功") {
										layer.alert('添加二级分类成功！', {
											title : '提示框',
											icon : 1,
										});
										layer.close(index);
										productMgr.listProduct(1, 5);
									} else {
										layer.alert('添加二级分类失败，请联系系统管理员！', {
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
			})

	function checkLength(which) {
		var maxChars = 200; // 备注最大的长度
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
	/*类目-停用*/
	function member_stop(obj, id) {
		layer.confirm(
			'确认要关闭吗？',
			{
				icon : 0,
			},
			function(index) {
				$.ajax({
					type : "post",
					url : "${ctx}/sysmgr/category/product/showOrHideProduct",
					data : {"changeValue" : 0, "productId" : id},
					dataType : "json",
					success : function(data) {
						if (data.message == "success") { // 隐藏该商品成功
							$(obj).parents("tr")
								.find(".td-manage")
								.prepend('<a style="text-decoration:none" class="btn btn-xs " onClick="member_start(this,' + id
									+ ')" href="javascript:;" title="显示"><i class="fa fa-close bigger-120"></i></a>');
							
							$(obj).parents("tr")
								.find(".td-status")
								.html('<span class="label label-defaunt radius">已关闭</span>');
							
							$(obj).remove();
							layer.msg('关闭!', {
								icon : 5,
								time : 1000
							});
							// 重新查询一下
							productMgr.listProduct(1, 5);
						} else { // 隐藏该商品失败
							layer.msg('隐藏该商品失败，请联系系统管理员!', {
								icon : 5,
								time : 1000
							});
						}
					}
				});
			});
	}
	/*类目-启用*/
	function member_start(obj, id) {
		layer
			.confirm(
					'确认要显示吗？',
					{
						icon : 0,
					},
					function(index) {
						$.ajax({
							type : "post",
							url : "${ctx}/sysmgr/category/product/showOrHideProduct",
							data : {"changeValue" : 1, "productId" : id},
							dataType : "json",
							success : function(data) {
								if (data.message == "success") { // 显示该商品成功
									$(obj).parents("tr")
										.find(".td-manage")
										.prepend('<a style="text-decoration:none" class="btn btn-xs btn-success" onClick="member_stop(this,' + id 
											+ ')" href="javascript:;" title="关闭"><i class="fa fa-check  bigger-120"></i></a>');
									$(obj).parents("tr")
										.find(".td-status")
										.html('<span class="label label-success radius">显示</span>');
									$(obj).remove();
									
									layer.msg('显示!', {
										icon : 6,
										time : 1000
									});
									// 重新查询一次查询
									productMgr.listProduct(1, 5);
								} else { // 显示该商品失败
									layer.msg('显示该商品失败，请联系系统管理员!', {
										icon : 6,
										time : 1000
									});
								}
							}
						});
					});
	}
	/*类目-删除*/
	function member_del(obj, id) {
		layer.confirm('确认要删除吗？', {
			icon : 0,
		}, function(index) {
			$.ajax({
				type : "post",
				url : "${ctx}/sysmgr/category/product/removeProduct",
				data : {"productId" : id},
				dataType : "json",
				success : function(data) {
					if (data.message == "删除二级分类成功") {
						layer.msg('删除商品成功!', {
							icon : 1,
							time : 1000
						});
						location.reload();
						productMgr.listProduct(1, 5);
					} else {
						layer.msg('删除商品失败，请联系系统管理员!', {
							icon : 0,
							time : 1000
						});
					}
				}
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
		parent.layer.close(index);

	});
	function AdlistOrders(id) {
		window.location.href = "Ads_list.html?=" + id;
	};
</script>
<script>
    $(document).ready(function() { 
    	$("#queryProductName").select2(); 
    	$("#queryCategory1").select2(); 
    });
</script>
</body>
</html>