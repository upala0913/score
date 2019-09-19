$(function () {

    // 注销
    $(".logout").click(function () {
        $.ajax({
            url:"/login/out",
            type:"post",
            dataType:"text",
            success:function (data) {
                if ("true" === data) {
                    window.location.href = "/upala/scoreIndex.html";
                }
            }
        });
    });

    // 菜单
    $("#sysTree").tree({
        url:"/score/menu",
        method:"get",
        animate:"true",
        onClick:function(node) {
            if (node.hasOwnProperty("attributes")) {
                var parse = JSON.parse(node.attributes);
                var $this = $("#dataTabs");
                if ($this.tabs("exists", node.text)) { // 如果存在，则选中该tabs，否则新增tabs
                    $this.tabs("select", node.text);
                } else {
                    if (node.attributes) {
                        $this.tabs("add", {
                            title: node.text,
                            closable: true,
                            href: parse.url
                        });
                    }
                }
            } else {
                $.messager.alert("title", "该节点不能点击！", "warning");
            }
        }
    });

});