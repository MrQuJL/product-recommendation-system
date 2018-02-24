/***
 * 漫画Jquery时间插件
 * 编写时间：2012年7月14号
 * version:manhuaDate.1.0.js
***/
$(function() {
	$.fn.manhuaDate = function(options) {
		var defaults = {
			Event : "click",		//插件绑定的响应事件
			Left : 0,				//弹出时间停靠的左边位置
			Top : 22,				//弹出时间停靠的上边位置
			fuhao : "-",			//日期之间的连接符号
			isTime : false,			//是否开启时间值默认为false
			beginY : 1949,			//年份的开始默认为1949
			endY : 2049				//年份的结束默认为2049
		};
		var options = $.extend(defaults,options);		
		var stc;
		if($("#calender").length<=0){
			$("body").prepend("<div class='calender'><div class='calenderContent'><div class='calenderTable'><div class='getyear'><a class='preMonth' id='preMonth'>上一月</a><select id='year'></select><select id='month'></select><a class='nextMonth' id='nextMonth'>下一月</a></div><div class='tablebg'><table id='calender' class='calendertb' cellpadding='0' cellspacing='1'><tr bgcolor='#D6D6D6'><th class='weekend'>日</th><th>一</th><th>二</th><th>三</th><th>四</th><th>五</th><th class='weekend noborder'>六</th></tr><tr><td class='weekend2'></td><td></td><td></td><td></td><td></td><td></td><td class='weekend2 noborder'></td></tr><tr><td class='weekend2'></td><td></td><td></td><td></td><td></td><td></td><td class='weekend2 noborder'></td></tr><tr><td class='weekend2'></td><td></td><td></td><td></td><td></td><td></td><td class='weekend2 noborder'></td></tr><tr><td class='weekend2'></td><td></td><td></td><td></td><td></td><td></td><td class='weekend2 noborder'></td></tr><tr><td class='weekend2'></td><td></td><td></td><td></td><td></td><td></td><td class='weekend2'></td></tr><tr><td class='weekend2'></td><td></td><td></td><td></td><td></td><td></td><td class='weekend2'></td></tr></table></div></div></div></div>");	
		}
		var $mhInput = $(this);
		var isToday = true;//是否为今天默认为是	
		var date = new Date();//获得时间对象
		var nowYear = date.getFullYear();//获得当前年份
		var nowMonth = date.getMonth() + 1;//获得当前月份
		var today = date.getDate();//获得当前天数
		var nowWeek = new Date(nowYear, nowMonth - 1, 1).getDay();//获得当前星期
		var nowLastday = getMonthNum(nowMonth, nowYear);//获得最后一天
		//年、月下拉框的初始化
		for(var i=options.beginY; i<=options.endY; i++){
			$("<option value='"+i+"'>"+i+"年</option>").appendTo($("#year"));
		}
		for(var i=1; i<=12; i++){
			$("<option value='"+i+"'>"+i+"月</option>").appendTo($("#month"));
		}		
		ManhuaDate(nowYear, nowMonth, nowWeek, nowLastday);//初始化为当前日期		
		//上一月绑定点击事件
		$("#preMonth").click(function() {
			isToday = false;
			var year = parseInt($("#year").val());
			var month = parseInt($("#month").val());		
			month = month - 1;
			if (month < 1) {
				month = 12;
				year = year - 1;
			}
			if(nowYear==year && nowMonth==month){
				isToday = true;
			}
			var week = new Date(year, month - 1, 1).getDay();
			var lastday = getMonthNum(month, year);
			ManhuaDate(year, month, week, lastday);
		});		
		//年下拉框的改变事件
		$("#year").change(function() {	
			isToday = false;				   
			var year = parseInt($(this).val());		
			var month = parseInt($("#month").val());	
			if(nowYear==year && nowMonth==month){
				isToday = true;
			}
			var week = new Date(year, month - 1, 1).getDay();
			var lastday = getMonthNum(month, year);
			ManhuaDate(year, month, week, lastday);
		});		
		//月下拉框的改变事件
		$("#month").change(function() {
			isToday = false;
			var year = parseInt($("#year").val());		
			var month = parseInt($(this).val());	
			if(nowYear==year && nowMonth==month){
				isToday = true;
			}
			var week = new Date(year, month - 1, 1).getDay();
			var lastday = getMonthNum(month, year);
			ManhuaDate(year, month, week, lastday);
		});		
		//下一个月的点击事件
		 $("#nextMonth").click(function() {
			isToday = false;
			var year = parseInt($("#year").val());
			var month = parseInt($("#month").val());
		
			month = parseInt(month) + 1;
			if (parseInt(month) > 12) {
				month = 1;
				year = parseInt(year) + 1;
			}
			if(nowYear==year && nowMonth==month){
				isToday = true;
			}
			var week = new Date(year, month - 1, 1).getDay();
			var lastday = getMonthNum(month, year);
			ManhuaDate(year, month, week, lastday);
		});
		 
		 //初始化日历
		 function ManhuaDate(year, month, week, lastday) {
			$("#year").val(year);
			$("#month").val(month)
			var table = document.getElementById("calender");
			var n = 1;
			for (var j = 0; j < week; j++) {
				table.rows[1].cells[j].innerHTML = "&nbsp;"
			}
			for (var j = week; j < 7; j++) {
				if (n == today && isToday) {				
					table.rows[1].cells[j].className="tdtoday";				
				}else {
					table.rows[1].cells[j].className="";
				}
				table.rows[1].cells[j].innerHTML = n;
				n++;
			}
			for (var i = 2; i < 7; i++) {
				for (j = 0; j < 7; j++) {
					if (n > lastday) {
						table.rows[i].cells[j].innerHTML = "&nbsp"
					}
					 else {
						if (n == today && isToday) {						
							table.rows[i].cells[j].className="tdtoday";						
						}else {
							table.rows[i].cells[j].className="";
						}
						table.rows[i].cells[j].innerHTML = n;
						n++;
					}
				}
			}
		}
		//获得月份的天数
		function getMonthNum(month, year) {
			month = month - 1;
			var LeapYear = ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) ? true: false;
			var monthNum;
			switch (parseInt(month)) {
			case 0:
			case 2:
			case 4:
			case 6:
			case 7:
			case 9:
			case 11:
				monthNum = 31;
				break;
			case 3:
			case 5:
			case 8:
			case 10:
				monthNum = 30;
				break;
			case 1:
				monthNum = LeapYear ? 29: 28;
			}
			return monthNum;
		}		
		//每一列的悬挂事件改变当前样式
		$("#calender td:not(.tdtoday)").hover(function() {
			$(this).addClass("hover")
		},function() {
			$(this).removeClass("hover");
		});		
		//点击时间列表事件
		$("#calender td").die().live("click",function() {	
			var dv = $(this).html();
			if (dv != "&nbsp;"){
				 var str = "";
				 if (options.isTime){			
					var nd = new Date();
					str = $("#year").val() + options.fuhao + $("#month").val() + options.fuhao + dv + " "+ nd.getHours()+":"+nd.getMinutes()+":"+nd.getSeconds();
				 }else{
					str = $("#year").val() + options.fuhao + $("#month").val() + options.fuhao + dv;
				}				 
				$("input.dateVisited").val(str);
				$("input.dateVisited").removeClass('dateVisited')
				$(".calender").hide();
			}
		});
		//文本框绑定事件
		$mhInput.live(options.Event,function(e){											
			$(this).addClass("dateVisited");
			if(stc){
				clearTimeout(stc);//清除定时器
			}
			var iof = $(this).offset();
			$(".calender").css({ "left" : iof.left+options.Left,"top" : iof.top+options.Top });
			$(".calender").show();	
		});		
		//当鼠标离开控件上面的时候延迟3秒关闭
		$(".calender").live("mouseleave",function(){ 
			stc = setTimeout(function (){			
				$(".calender").hide();
				clearTimeout(stc);
			},3000);	
		});
		//当鼠标移到控件上面的时候显示
		$(".calender").live("mousemove",function(){     
			if(stc){
				clearTimeout(stc);//清除定时器
			}
			$(this).show();
		});	
		//点击年选择下拉框的时候清除定时器阻止控件层关闭
		$("#year").die().live("click",function(){     
			if(stc){
				clearTimeout(stc);//清除定时器
			}			
		});	
		//点击月选择下拉框的时候清除定时器阻止控件层关闭
		$("#month").die().live("click",function(){     
			if(stc){
				clearTimeout(stc);//清除定时器
			}			
		});	
	};
});