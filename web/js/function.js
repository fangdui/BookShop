function change(img) {
    img.src="getCode?"+new Date().getTime();
}

var flag = true; //标志位

function FocusItem(obj) {
    if($(obj).attr('name')=='veryCode'){
        $(obj).next().next().html('').removeClass('error');

    }else {
        $(obj).next('span').html('').removeClass('error');

    }
}

function CheckItem(obj) {
    var msgBox = $(obj).next('span');
    switch ($(obj).attr('name')) {
        case "userName":
            if(obj.value==""){
                msgBox.html('用户名不能为空');
                msgBox.addClass('error');
                flag = false;
            }else {
                var url="usernamecheck?name="+encodeURI($(obj).val())+"&"+new Date().getTime();
                //"false" "true"
                $.get(url,function (data) {
                    if(data=="false"){
                        msgBox.html("用户名已存在");
                        msgBox.addClass('error');
                        flag = false;
                    }else {
                        msgBox.html().removeClass('error');
                        flag = true;
                    }
                });
            }
            break;
        case "passWord":
            if(obj.value=="") {
                msgBox.html('密码不能为空');
                msgBox.addClass('error');
                flag = false;
            }else {
                flag = true;
            }
            break;
        case "rePassWord":
            if(obj.value==""){
                msgBox.html('确认密码不能为空');
                msgBox.addClass('error');
                flag = false;
            }else if ($(obj).val()!=$('input[name="passWord"]').val()){
                msgBox.html('两次输入的密码不一致');
                msgBox.addClass('error');
                flag = false;
            }else {
                flag = true;
            }
            break;
        case "veryCode":
            var numshow = $(obj).next().next();
            if(obj.value==""){
                numshow.html('验证码不能为空');
                numshow.addClass('error');
                flag = false;
            }else {
                var url = "checkusernum?num="+encodeURI($(obj).val())+"&"+new Date().getTime();
                $.get(url,function (numdata) {
                    if(numdata=='false'){
                        numshow.html('验证码不正确');
                        numshow.addClass('error');
                        flag = false;
                    }else {
                        numshow.html().removeClass('error');
                        flag = true;
                    }
                });
            }
            break;
    }
}

function checkForm(frm) {
    var els = frm.getElementsByTagName('input');
    //onblur这个属性需要验证
    for(var i=0;i<els.length;i++){
        if(els[i]!=null){
            if(els[i].getAttribute("onblur")){
                CheckItem(els[i]);
            }
        }
    }
    return flag;
}