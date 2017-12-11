var rFilter = /^(?:image\/bmp|image\/cis\-cod|image\/gif|image\/ief|image\/jpeg|image\/jpeg|image\/jpeg|image\/pipeg|image\/png|image\/svg\+xml|image\/tiff|image\/x\-cmu\-raster|image\/x\-cmx|image\/x\-icon|image\/x\-portable\-anymap|image\/x\-portable\-bitmap|image\/x\-portable\-graymap|image\/x\-portable\-pixmap|image\/x\-rgb|image\/x\-xbitmap|image\/x\-xpixmap|image\/x\-xwindowdump)$/i;

function loadImageFile(event) {
    var file;
    var reader = new Array();
    var iterator;
    for (var i = 0; i < event.target.files.length; i++) {
        file = event.target.files[i];
        if (!rFilter.test(file.type)) {
            alert("file" + i + " :must be a valid image file!");
            return;
        }if(file!=null){
            alert(file.name);
            reader[i] = new FileReader();
            reader[i].readAsDataURL(file);
            reader[i].onload = function (event) {
                document.getElementById("images" + i).src = event.target.result;
            }
        }
        // //回收
        // file = null;
        // reader[i] = null;
    }
}
//删除图片的函数$
// $(document).ready(function () {
//     $("div").delegate("image","click",function () {
//         if (this.src == null){
//             alert("请插入图片！");
//         }else {
//             this.src = null;
//         }
//     })
// })
//显示九宫格$
// $(document).ready(function () {
//     $(".showImage").click(function () {
//         $(".wrap").slideToggle();
//     })
// })


