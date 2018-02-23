 // 首页登录弹出框start
 $(".login").click(function(){
    $(".lglogin").show();
  });
  $(".close").click(function(){
    $(".lglogin").hide();
  });
// 首页登录弹出框end


// 广告弹出框
$(".delban").click(function(){
  $(".banDel").show();
});
$(".close").click(function(){
  $(".banDel").hide();
});
$(".no").click(function(){
  $(".banDel").hide();
});
// 广告弹出框 end


// 广告删除div
// function del(){
//   var input=document.getElementsByName("check[]");
//   for(var i=input.length-1; i>=0;i--){
//    if(input[i].checked==true){
//        //获取td节点
//        var label=input[i].parentNode;
//       //获取tr节点
//       var listnone=label.parentNode;
//       //获取table
//       var list=listnone.parentNode;
//       var lists=list.parentNode;
//       var blists=lists.parentNode;
//       //移除子节点
//       blists.removeChild(lists);
//   }
     
//   }
// }
// 广告删除div end