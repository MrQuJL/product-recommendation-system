<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include/taglib.jsp"%>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>管理员列表</title>
	<link href="${ctxJsAndCss}/assets/css/bootstrap.min.css" rel="stylesheet" />
	<link href="${ctxJsAndCss}/css/style.css" rel="stylesheet" />
	<link href="${ctxJsAndCss}/assets/css/codemirror.css" rel="stylesheet">
	<link href="${ctxJsAndCss}/assets/css/ace.min.css" rel="stylesheet" />
	<link href="${ctxJsAndCss}/assets/css/font-awesome.min.css" rel="stylesheet" />
	<!--[if IE 7]>
	  <link href="${ctxJsAndCss}/assets/css/font-awesome-ie7.min.css" rel="stylesheet" />
	<![endif]-->
	<!--[if lte IE 8]>
	  <link href="${ctxJsAndCss}/assets/css/ace-ie.min.css" rel="stylesheet" />
	<![endif]-->
	<script src="${ctxJsAndCss}/assets/js/jquery.min.js"></script>
	<!-- <![endif]-->
	<!--[if IE]>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<![endif]-->
	<!--[if !IE]> -->
	<script type="text/javascript">
	window.jQuery || document.write("<script src='${ctxJsAndCss}/assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
	</script>
	<!-- <![endif]-->
	<!--[if IE]>
	<script type="text/javascript">
	window.jQuery || document.write("<script src='${ctxJsAndCss}/assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
	</script>
	<![endif]-->
	<script type="text/javascript">
	if("ontouchend" in document) document.write("<script src='${ctxJsAndCss}/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
	</script>
	<script src="${ctxJsAndCss}/assets/js/bootstrap.min.js"></script>
	<script src="${ctxJsAndCss}/assets/js/typeahead-bs2.min.js"></script>
	<!-- page specific plugin scripts -->
	<script src="${ctxJsAndCss}/assets/js/jquery.dataTables.min.js"></script>
	<script src="${ctxJsAndCss}/assets/js/jquery.dataTables.bootstrap.js"></script>
	<script src="${ctxJsAndCss}/js/H-ui.js"></script>
	<script src="${ctxJsAndCss}/js/H-ui.admin.js"></script>
	<script src="${ctxJsAndCss}/assets/layer/layer.js"></script>
	<script src="${ctxJsAndCss}/assets/laydate/laydate.js"></script>
	<script src="${ctxJsAndCss}/js/date.js"></script>
</head>
<body>
	<div class="page-content clearfix">
		<div id="Member_Ratings">
			<div class="d_Confirm_Order_style">
				<div class="search_style">
					<div class="title_names">搜索查询</div>
					<ul class="search_content clearfix">
						<li><label class="l_f">管理员名称</label><input id="username" name="username" type="text"
							class="text_add" placeholder="输入管理员名称" style="width: 400px" /></li>
						<li><label class="l_f">添加时间</label><input
							class="inline laydate-icon" id="start" name="date" style="margin-left: 10px;"></li>
						<li style="width: 90px;">
							<button type="button" class="btn_search" onclick="adminMgr.listAdmin();">
								<i class="icon-search"></i>查询
							</button>
						</li>
					</ul>
				</div>
				<!---->
				<div class="border clearfix">
					<span class="l_f"> <a href="javascript:ovid()"
						id="member_add" class="btn btn-warning"><i class="icon-plus"></i>添加管理员</a>
						<a href="javascript:ovid()" class="btn btn-danger"><i
							class="icon-trash"></i>批量删除</a>
					</span> <span class="r_f">共：<b>2345</b>条
					</span>
				</div>
				<!---->
				<div class="table_menu_list">
					<table class="table table-striped table-bordered table-hover" id="sample-table">
						<thead>
							<tr>
								<th width="25"><label><input type="checkbox"
										class="ace"><span class="lbl"></span></label></th>
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
				</div>
			</div>
		</div>
	</div>
	<!--添加管理员图层-->
	<div class="add_menber" id="add_menber_style" style="display: none">

		<ul class=" page-content">
			<li><label class="label_name">用&nbsp;&nbsp;户 &nbsp;名：</label><span
				class="add_name"><input value="" name="管理员名" type="text"
					class="text_add" /></span>
			<div class="prompt r_f"></div></li>
			<li><label class="label_name">真实姓名：</label><span
				class="add_name"><input name="真实姓名" type="text"
					class="text_add" /></span>
			<div class="prompt r_f"></div></li>
			<li><label class="label_name">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</label><span
				class="add_name"> <label><input
						name="form-field-radio" type="radio" checked="checked" class="ace"><span
						class="lbl">男</span></label>&nbsp;&nbsp;&nbsp; <label><input
						name="form-field-radio" type="radio" class="ace"><span
						class="lbl">女</span></label>&nbsp;&nbsp;&nbsp;
			</span>
				<div class="prompt r_f"></div></li>
			<li><label class="label_name">年龄：</label><span
				class="add_name"><input name="年龄" type="text"
					class="text_add" /></span>
			<div class="prompt r_f"></div></li>
			<li><label class="label_name">移动电话：</label><span
				class="add_name"><input name="移动电话" type="text"
					class="text_add" /></span>
			<div class="prompt r_f"></div></li>
			<li><label class="label_name">电子邮箱：</label><span
				class="add_name"><input name="电子邮箱" type="text"
					class="text_add" /></span>
			<div class="prompt r_f"></div></li>
			<li class="adderss"><label class="label_name">家庭住址：</label><span
				class="add_name"><input name="家庭住址" type="text"
					class="text_add" style="width: 350px" /></span>
			<div class="prompt r_f"></div></li>
		</ul>
	</div>
<script>
	jQuery(function($) {
		/* var oTable1 = $('#sample-table').dataTable( {
			"aaSorting": [[ 1, "desc" ]],//默认第几个排序
			"bStateSave": true,//状态保存
			"aoColumnDefs": [
		 	//{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  	{"orderable":false,"aTargets":[0,8,9]}// 制定列不参与排序
			]
		}); */
		
		$('table th input:checkbox').on('click' , function(){
			var that = this;
			$(this).closest('table').find('tr > td:first-child input:checkbox')
			.each(function(){
				this.checked = that.checked;
				$(this).closest('tr').toggleClass('selected');
			});
		});
	
		/* $('[data-rel="tooltip"]').tooltip({placement: tooltip_placement});
		function tooltip_placement(context, source) {
			var $source = $(source);
			var $parent = $source.closest('table')
			var off1 = $parent.offset();
			var w1 = $parent.width();
	
			var off2 = $source.offset();
			var w2 = $source.width();
	
			if( parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2) ) return 'right';
			return 'left';
		} */
	})
	/*管理员-添加*/
	$('#member_add').on('click', function(){
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
	     		$(".add_menber input[type$='text']").each(function(n){
		        	if($(this).val()=="") {
						layer.alert(str+=""+$(this).attr("name")+"不能为空！\r\n",
							{title: '提示框', icon:0,}
						);
			    		num++;
	            		return false;            
	          		}
				});
				if(num>0) {
					return false;
				} else {
					layer.alert('添加成功！',{title: '提示框', icon:1,});
					layer.close(index);	
				}
			}
	    });
	});
	
	/*管理员-编辑*/
	function member_edit(id){
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
		   		$(".add_menber input[type$='text']").each(function(n){
		        	if($(this).val()==""){
			   			layer.alert(str+=""+$(this).attr("name")+"不能为空！\r\n",
			   				{title: '提示框',icon:0,}); 
		    			num++;
		          		return false;            
		        	} 
		 		});
		   		
			  	if(num>0){
			  		return false;
			  	} else {
					layer.alert('添加成功！',
						{title: '提示框',icon:1,}
					);
				   	layer.close(index);
			  	}
			}
	    });
	}
	/*管理员-删除*/
	function member_del(obj,id){
		layer.confirm('确认要删除吗？',function(index){
			$(obj).parents("tr").remove();
			layer.msg('已删除!',{icon:1,time:1000});
		});
	}
	laydate({
	    elem: '#start',
	    event: 'focus'
	});
</script>
<script type="text/javascript">
	var adminMgr = {
		listAdmin : function() {
			var username = $("#username").val();
			var date = $("#start").val();
			$.ajax({
				type : "post",
				url : "${ctx}/sysmgr/admin/listAdmin",
				data : {"username" : username, "date" : date},
				dataType : "json",
				success : function(data) {
					var htmlTable = "";
					if (data.length != 0) {
						for (var i = 0; i < data.length; i++) {
							htmlTable = htmlTable + "<tr>";
							
							htmlTable = htmlTable + "<td><label><input type='checkbox' class='ace'><span class='lbl'></span></label></td>";
							
							htmlTable = htmlTable + "<td>" + data[i].id + "</td>";
							
							htmlTable = htmlTable + "<td>" + data[i].username + "</td>";
							
							htmlTable = htmlTable + "<td>" + data[i].sex + "</td>";
							
							htmlTable = htmlTable + "<td>" + data[i].mobile + "</td>";
							
							htmlTable = htmlTable + "<td>" + data[i].email + "</td>";
							
							htmlTable = htmlTable + "<td class=\"text-l\">" + data[i].address + "</td>";
							
							htmlTable = htmlTable + "<td>" +  timestampToTime(data[i].gmtCreate) + "</td>";
							
							htmlTable = htmlTable + 
							"<td class=\"td-manage\"> <a title=\"编辑\""+
							"							onclick=\"member_edit(\'550\')\" href=\"javascript:;\""+
							"							class=\"btn btn-xs btn-info\"><i"+
							"								class=\"icon-edit bigger-120\"></i></a> <a title=\"删除\""+
							"							href=\"javascript:;\" onclick=\"member_del(this,\'1\')\""+
							"							class=\"btn btn-xs btn-warning\"><i"+
							"								class=\"icon-trash  bigger-120\"></i></a></td>";
							
							htmlTable = htmlTable + "</tr>";
						}
					} else {
						htmlTable = "没有查询到记录";
					}
					$("#sample-table").find("tbody").html(htmlTable);
				}
			});
		}
	}
</script>
</body>
</html>