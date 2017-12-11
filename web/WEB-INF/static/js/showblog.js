var count;
var xmlhttpRequest;
var isPraise=0;

function praise(button) {
        isPraise = button.id % 2 == 0;
        count = (isPraise == 1) ? button.id / 2 : (button.id - 1) / 2;
        xmlhttpRequest = new XMLHttpRequest();
        var microblogID = document.getElementsByName("microblogid").item(count - 1);
        if (isPraise == 1) {
            xmlhttpRequest.open("post", "praise.blog", true);
        }else {
            xmlhttpRequest.open("post", "cancelPraise.blog", true);
        }
        xmlhttpRequest.onreadystatechange = PraiseResult;
        xmlhttpRequest.send(microblogID.value);
    }
function PraiseResult() {
    //var button = document.getElementById(count);
    var a = xmlhttpRequest.responseText;
    document.getElementsByName("praiseTime").item(count - 1).innerHTML
        = "<div>" + "praise time: " + a + "</div>";
    if (isPraise == 1) {
        document.getElementById(count * 2).style.display = "none";
        document.getElementById(count * 2 + 1).style.display = "";
    } else {
        document.getElementById(count * 2 + 1).style.display = "none";
        document.getElementById(count * 2).style.display = "";
    }
}
function complaint(){
    var xhr = new XMLHttpRequest();
    xhr.onload = function () {
        if (xhr.status==200){
            document.getElementById('complaint').innerHTML=xhr.responseText;
        }
        xhr.open('post','complaint.blog',true);
        xhr.send(document.getElementById('blogid').value);
    }
}
function collect(){
    var xhr = new XMLHttpRequest();
    xhr.onload = function () {
        if (xhr.status==200){
            document.getElementById('collect').innerHTML=xhr.responseText;
        }
        xhr.open('post','collect.blog',true);
        xhr.send(document.getElementById('blogid').value);
    }
}
