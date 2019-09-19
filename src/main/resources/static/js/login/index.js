$(function () {

    // 获取验证码
    $.ajax({
        url:"/comm/getKey",
        type:"get",
        dataType:"text",
        success:function (data) {
            $(".code-key").text(data);
        }
    });
    $(".code-key").click(function () {
        $.ajax({
            url:"/comm/getKey",
            type:"get",
            dataType:"text",
            success:function (data) {
                $(".code-key").text(data);
            }
        });
    });

    // 获取用户信息
    function getInfo () {
        var username = $("#username").val();
        var userpass = $("#password").val();
        var data = {"username":username, "userpass":userpass};
        return data;
    }

    // 提交数据
    function submitData () {
        var code = $("#key").val();
        var key = $(".code-key").text();
        var s = key.toLowerCase();
        var admin = getInfo();
        if (code === s) {
            $.ajax({
                url:"/login/admin",
                type:"post",
                contentType:"application/json;charset=utf-8",
                data:JSON.stringify(admin),
                dataType:"text",
                success:function (data) {
                    if ("true" === data) {
                        window.location.href = "/scoreCore.html";
                    }
                }
            });
        } else {
            alert ("验证码不正确！！！");
        }
    }

    // 获取键盘
    $(document).keypress(function (e) {
        if (e.keyCode == 13) {
            submitData ();
        }
    });

    // 登录信息
    $(".login-bottom").click(function () {
        submitData ();
    });

});