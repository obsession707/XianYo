//
// var xmlhttpRequest;
// //var content = "";
// //content.obj;
//
//
// //辣鸡bootstrap的导航栏显示
// $(function () {
//     $('#myTabDrop1 a[href="#feedbackno"]').tab('show');
//     $('#myTabDrop1 a').click(function (e) {
//         e.preventDefault();
//         $(this).tab('show');
//     })
// })
// //for(obj){
//     //content = obj.value()
// function FeedbackNo() {
//     alert("123456789");
//     $.ajax({
//         type:"GET",
//         url:"feedbackno.query",
//         cache:false,
//         dataType:"json",
//         error:function (data) {
//             alert(data.errorThrown);
//         },
//         success:function (json) {
//             alert("111");
//             var content = json.object;
//             alert(content);
//             alert(json[0].feedbackid);
//         }
//     })
// }