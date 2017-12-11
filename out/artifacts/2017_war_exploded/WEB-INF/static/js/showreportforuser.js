var count;
var xmlhttpRequest;

function Delete(button) {
    count = button.id;
    var reportID = document.getElementsByName("reportid").item(count-1);
    xmlhttpRequest = new XMLHttpRequest();
    xmlhttpRequest.open("post", "delete.report", true);
    xmlhttpRequest.onreadystatechange = DeleteResult;
    xmlhttpRequest.send(reportID.value);
}
function DeleteResult() {
    //这样效果会没了
    // if (xmlhttpRequest.readyState == 4 && xmlhttpRequest.status == 200){
    //     alert(xmlhttpRequest.responseText);
    // }
    //alert(xmlhttpRequest.responseText);
}
//删除之后的效果
$(document).ready(function () {
    $(".delete").click(function () {
        $(".report"+count).slideToggle();
    })
})