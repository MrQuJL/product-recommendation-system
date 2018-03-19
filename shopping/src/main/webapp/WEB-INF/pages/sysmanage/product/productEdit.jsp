<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include/taglib.jsp"%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<title>新增图片</title>
	<!-- css样式 -->
	<link href="${ctxJsAndCss}/assets/css/bootstrap.min.css" rel="stylesheet" />
	<link href="http://cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
	<link href="${ctxJsAndCss}/css/default.css" rel="stylesheet" />
	<link href="${ctxJsAndCss}/css/style.css" rel="stylesheet" />
	<link href="${ctxJsAndCss}/assets/css/codemirror.css" rel="stylesheet">
	<link href="${ctxJsAndCss}/assets/css/ace.min.css" rel="stylesheet" />
	<link href="${ctxJsAndCss}/Widget/zTree/css/zTreeStyle/zTreeStyle.css" rel="stylesheet" />
	<link href="${ctxJsAndCss}/assets/css/font-awesome.min.css" rel="stylesheet" />
	<link href="${ctxJsAndCss}/Widget/icheck/icheck.css" rel="stylesheet" type="text/css" />
	<link href="${ctxJsAndCss}/Widget/webuploader/0.1.5/webuploader.css" rel="stylesheet" type="text/css" />
	<link href="${ctxJsAndCss}/css/select2.min.css" rel="stylesheet" />
	<link href="${ctxJsAndCss}/css/fileinput.min.css" rel="stylesheet" />
	<!-- js脚本 -->
	<script src="${ctxJsAndCss}/js/jquery-1.9.1.min.js"></script>
	<script src="http://cdn.bootcss.com/jquery/1.11.0/jquery.min.js" type="text/javascript"></script>
	<script src="${ctxJsAndCss}/js/fileinput.min.js"></script>
	<script src="${ctxJsAndCss}/js/zh.js"></script>
	<script src="${ctxJsAndCss}/js/select2.min.js"></script>
	<script src="${ctxJsAndCss}/assets/js/bootstrap.min.js"></script>
	<script src="http://cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src="${ctxJsAndCss}/assets/js/typeahead-bs2.min.js"></script>
	<script src="${ctxJsAndCss}/assets/layer/layer.js"></script>
	<script src="${ctxJsAndCss}/assets/laydate/laydate.js"></script>
	<script src="${ctxJsAndCss}/Widget/icheck/jquery.icheck.min.js"></script>
	<script src="${ctxJsAndCss}/Widget/Validform/5.3.2/Validform.min.js"></script>
	<script src="${ctxJsAndCss}/js/lrtk.js"></script>
	<script src="${ctxJsAndCss}/js/jquery.form.js"></script>
</head>
<body>
	<div class="clearfix" id="add_picture">
		<div class="page_style">
			<div class="type_title" style="font-size:14px;margin-left:24px;margin-top:10px;">添加商品</div>
			<form action="${ctx}/sysmgr/product/saveProduct" method="post" 
				class="form form-horizontal" id="form-product-add" enctype="multipart/form-data">
				<div class=" clearfix cl">
					<label class="form-label col-6">商品名称：</label>
					<div class="formControls col-6">
						<input type="hidden" value="${product.productId}" name="productId" id="productId">
						<input type="text" class="input-text" value="${product.productName}" placeholder=""
							id="productName" name="productName">
					</div>
				</div>
				<div class="clearfix cl">
					<label class="form-label col-6">二级类目：</label>
					<div class="formControls col-6">
						<select id="category2Id" name="category2Id" class="text_add" 
							style="width:168px;margin-left:0;" value="${product.category2Id}">
					        <c:forEach items="${category2List}" var="category2">
					        	<option value="${category2.category2Id}">${category2.category2Name}</option>
					        </c:forEach>
					    </select>
					</div>
				</div>
				<div class="clearfix cl">
					<label class="form-label col-6">购买价格：</label>
					<div class="formControls col-6">
						<input type="text" class="input-text" value="${product.purchasePrice}" placeholder=""
							id="purchasePrice" name="purchasePrice">
					</div>
				</div>
				<div class=" clearfix cl">
					<label class="form-label col-6">销售价格：</label>
					<div class="formControls col-6">
						<input type="text" class="input-text" value="${product.salePrice}" placeholder=""
							id="salePrice" name="salePrice">
					</div>
				</div>
				<div class=" clearfix cl">
					<label class="form-label col-6">商品库存：</label>
					<div class="formControls col-6">
						<input type="text" class="input-text" value="${product.inventory}" placeholder=""
							id="inventory" name="inventory">
					</div>
				</div>
				<div class="clearfix cl">
					<label class="form-label col-6">商品状态：</label>
					<div class="formControls col-6">
						<span class="add_content"> &nbsp;&nbsp;
							<label>
								<input id="show" name="showFlag" type="radio" 
								<c:choose>
									<c:when test="${product.showFlag == 1}">checked="checked"</c:when>
									<c:otherwise></c:otherwise>
								</c:choose>
									class="ace" value="1">
								<span class="lbl">上架</span>
							</label>&nbsp;&nbsp;&nbsp;
							<label>
								<input id="hide" name="showFlag" type="radio" 
								<c:choose>
									<c:when test="${product.showFlag == 0}">checked="checked"</c:when>
									<c:otherwise></c:otherwise>
								</c:choose>
								class="ace" value="0">
								<span class="lbl">下架</span>
							</label>
						</span>
					</div>
				</div>
				
				<div class="clearfix cl">
					<label class="form-label col-2">商品描述：</label>
					<div class="formControls col-10">
						<textarea name="description" cols="" rows="" class="textarea"
							placeholder="说点什么...最少输入10个字符" datatype="*10-100"
							dragonfly="true" nullmsg="备注不能为空！"
							onKeyUp="textarealength(this,200)">${product.description}</textarea>
						<p class="textarea-numberbar">
							<em class="textarea-length">0</em>/200
						</p>
					</div>
				</div>
				<div class="clearfix cl">
					<input type="hidden" name="imgSrc" value="${product.imgSrc}">
					<label class="form-label col-2">原图片：</label>
					<img src="${product.imgSrc}" />
				</div>
				<div class="clearfix cl">
					<label class="form-label col-2">新图片上传：</label>
					<div class="formControls col-10">
						<input id="imgSrc" type="file" name="uploadFile"/>
					</div>
				</div>
				<div class="clearfix cl">
					<div class="Button_operation">
						<button onClick=""
							class="btn btn-primary radius" type="submit">
							<i class="icon-save "></i>保存
						</button>
						<button onClick="layer_close();" class="btn btn-default radius"
							type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<script>
		$(function() {
			$("#add_picture").fix({
				float : 'left',
				skin : 'green',
				durationTime : false,
				stylewidth : '220',
				spacingw : 0,
				spacingh : 260,
			});
		});
		$(document).ready(function() {
			//初始化宽度、高度
			$(".widget-box").height($(window).height());
			$(".page_right_style").height($(window).height());
			//当文档窗口发生改变时 触发  
			$(window).resize(function() {

				$(".widget-box").height($(window).height());
				$(".page_right_style").height($(window).height());
				$(".page_right_style").width($(window).width() - 220);
			});
		});
		var code;

		function showCode(str) {
			if (!code)
				code = $("#code");
			code.empty();
			code.append("<li>" + str + "</li>");
		}
	</script>
	
	<script type="text/javascript">
		$("#category2Id").select2();
		//$("#imgUpload").fileinput();
		$("#imgSrc").fileinput({'showUpload':false, 'previewFileType':'any'});
	</script>
</body>
</html>