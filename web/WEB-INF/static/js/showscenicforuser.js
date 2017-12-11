var count;
var xmlhttpRequest;

function Delete(button) {
    count = button.id;
    var scenicID = document.getElementsByName("scenicid").item(count-1);
    xmlhttpRequest = new XMLHttpRequest();
    xmlhttpRequest.open("post", "delete.scenic", true);
    xmlhttpRequest.onreadystatechange = DeleteResult;
    xmlhttpRequest.send(scenicID.value);
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
        $(".scenic"+count).slideToggle();
    })
})