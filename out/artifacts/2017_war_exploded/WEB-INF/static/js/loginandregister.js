


//AjaxAjaxAjaxAjaxAjaxAjaxAjaxAjaxAjaxAjaxAjaxAjaxAjaxAjaxAjaxAjaxAjaxAjaxAjaxAjax
var xmlhttp;
//login ajax
function password() {
    var result = document.getElementById("submit").value;
    createXMLHttpRequest();
    xmlhttp.open("get","/user.login",true);
    xmlhttp.onreadystatechange = checkloginpsw;
    xmlhttp.send();
}
function checkloginpsw() {
    if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
        document.getElementById("loginmessage").innerHTML
            = "<font color='#5f9ea0'>" + xmlhttp.responseText + "</font>";
}
//register  ajax
function checkname() {
    var name = document.getElementById("regname").value;
    createXMLHttpRequest();
    xmlhttp.open("post", "checkusername.register", true);   //设置访问的页面
    xmlhttp.onreadystatechange = checknameResult;
    xmlhttp.send(name); //执行访问
}

function checknameResult() {
    if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
        document.getElementById("checkname").innerHTML
            = "<font color='#5f9ea0'>" + xmlhttp.responseText + "</font>";
}

function checkmail() {
    var mail = document.getElementById("mail").value;
    var regMail = /^([a-z0-9A-Z]+[-|\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\.)+[a-zA-Z]{2,}$/;
    if (!regMail.test(mail))
        document.getElementById("mailya").innerHTML = "<font color='red'> 你的邮箱格式不对 </font>";
    else
        document.getElementById("mailya").innerHTML = "<font color='green'> 邮箱格式正确 </font>";
    createXMLHttpRequest();
    xmlhttp.open("post", "checkmail.register", true);   //设置访问的页面
    xmlhttp.onreadystatechange = checkmailResult;
    xmlhttp.send(mail); //执行访问
}

function checkmailResult() {
    if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
        document.getElementById("checkmail").innerHTML = "<font color='#5f9ea0'>" + xmlhttp.responseText + "</font>";
}

function checkphonenumber() {
    var phonenumber = document.getElementById("phonenumber").value;
    var regPhonenumber = /^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\D])|(18[0,5-9]))\d{8}$/;
    if (!regPhonenumber.test(phonenumber))
        document.getElementById("phonenumberya").innerHTML = "<font color='red'> 你的手机号码格式不对 </font>";
    else
        document.getElementById("phonenumberya").innerHTML = "<font color='green'> 手机号码格式正确 </font>";
    createXMLHttpRequest();
    xmlhttp.open("post", "checkphonenumber.register", true);   //设置访问的页面
    xmlhttp.onreadystatechange = checkphonenumberResult;
    xmlhttp.send(phonenumber); //执行访问
}

function checkphonenumberResult() {
    if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
        document.getElementById("checkphonenumber").innerHTML = "<font color='#5f9ea0'>" + xmlhttp.responseText + "</font>";
}

function checkpassword() {
    var password = document.getElementById("thepassword").value;
    var password2 = document.getElementById("secondpassword").value;
    if (password2 != password) {
        document.getElementById("checkpassword").innerHTML = "<font color='red'> 两次密码不匹配 </font>";
    } else {
        document.getElementById("checkpassword").innerHTML = "<font color='green'> 两次密码一致 </font>";
    }
}

function createXMLHttpRequest() {
    //表示当前浏览器不是ie,如ns,firefox  
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
}  