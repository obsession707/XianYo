var count;
var xmlhttpRequest;

function Delete(button) {
    count = button.id;
    var feedbackID = document.getElementsByName("feedbackid").item(count-1);
    xmlhttpRequest = new XMLHttpRequest();
    xmlhttpRequest.open("post", "delete.feedback", true);
    xmlhttpRequest.onreadystatechange = DeleteResult;
    xmlhttpRequest.send(feedbackID.value);
}
function DeleteResult() {
    // if (xmlhttpRequest.readyState == 4 && xmlhttpRequest.status == 200){
    //     alert(xmlhttpRequest.responseText);
    // }
    //alert(xmlhttpRequest.responseText);
}


//删除之后的效果
$(document).ready(function () {
    $(".delete").click(function () {
        $(".feedback"+count).slideToggle();
    })
})