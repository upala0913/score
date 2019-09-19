$(function () {

    // 获取教师数据
    $("#teaDataGrid").datagrid({
        url: "/teacher/getTeacher",
        method: "get",
        fit: true,
        rownumbers: true,
        singleSelect: true,
        pagination: true,
        title: "教师信息",
        columns: [[
            {field: 'teaNum', width: 100, align: 'center', title: "工号"},
            {field: 'teaName', width: 80, align: 'center', title: "姓名"},
            {field: 'teaSex', width: 80, align: 'center', title: "性别"},
            {
                field: 'teaBirthday', width: 140, align: 'center', title: "生日",
                formatter: function (value) {
                    var date = new Date(value);
                    var year = date.getFullYear();
                    var month = date.getMonth() + 1;
                    var day = date.getDate();
                    return year + "-" + getNum(month) + "-" + getNum(day);
                }
            },
            {field: 'teaPhone', width: 130, align: 'center', title: "电话"},
            {field: 'teaPosition', width: 130, align: 'center', title: "职位"},
            {
                field: 'teaInDate', width: 140, align: 'center', title: "入职日期",
                formatter: function (value) {
                    var date = new Date(value);
                    var year = date.getFullYear();
                    var month = date.getMonth() + 1;
                    var day = date.getDate();
                    return year + "-" + getNum(month) + "-" + getNum(day);
                }
            },
            {
                field: 'teaCreateDate', width: 140, align: 'center', title: "创建时间",
                formatter: function (value) {
                    var date = new Date(value);
                    var year = date.getFullYear();
                    var month = date.getMonth() + 1;
                    var day = date.getDate();
                    return year + "-" + getNum(month) + "-" + getNum(day);
                }
            },
            {field: 'teaQQ', width: 130, align: 'center', title: "QQ"},
            {
                field: '_operate', width: 320, align: 'center', title: "操作",
                formatter: function (value, row, index) {
                    console.log(row.teaNum);
                    var str = '<a href="javascript:void(0);" class="update_btn" onClick = "editStudent(' + row.teaNum + ')"' +
                        ' >修改</a>' +
                        '&nbsp;&nbsp;&nbsp;&nbsp;' +
                        '<a href="javascript:void(0);" class="delete_btn" onclick = "deleteStudent(' + row.teaNum + ')"' +
                        ' >删除</a>' +
                        '&nbsp;&nbsp;&nbsp;&nbsp;' +
                        '<a href="javascript:void(0);" class="detail_btn" onclick = "detailStudent(' + row.teaNum + ')"' +
                        '>查看</a>';
                    return str;
                }
            }
        ]],
        onLoadSuccess: function (data) {
            $(".update_btn").linkbutton({
                text: "编辑",
                plain: true,
                iconCls: "icon-edit"
            });
            $(".delete_btn").linkbutton({
                text: "删除",
                plain: true,
                iconCls: "icon-remove"
            });
            $(".detail_btn").linkbutton({
                text: "查看",
                plain: true,
                iconCls: "icon-search"
            });
        },
        toolbar: [{
            iconCls: "icon-add",
            text: "新增",
            handler: function () {
                $("#teaAddWin").window("open");
            }
        }, {
            text: "工号：<input id='searchTeaNum' class='easyui-textbox' style='height:20px;width:100px;' />"
        }, {
            text: "姓名：<input id='searchTeaName' class='easyui-textbox' style='height:20px; width: 100px;' />"
        }, {
            text: "电话：<input id='searchTeaMobile' class='easyui-textbox' style='height:20px; width: 100px;' />"
        }, {
            text: "QQ：<input id='searchTeaQQ' class='easyui-textbox' style='height:20px; width: 100px;' />"
        }, {
            text: "职位：<select id='teaPosition' class='easyui-combobox' name='subject' style='width: 100px;" +
                        "height: 20px; text-align: center;' >\n" +
                            "<option>-- 请选择 --</option>\n" +
                            "<option value='教师' >教师</option>\n" +
                            "<option value='班主任' >班主任</option>\n" +
                            "<option value='系主任' >系主任</option>\n" +
                            "<option value='指导员' >指导员</option>\n" +
                            "<option value='副院长' >副院长</option>\n" +
                            "<option value='院长' >院长</option>\n" +
                            "<option value='副书记' >副书记</option>\n" +
                            "<option value='书记' >书记</option>\n" +
                        "</select>"
        }, {
            iconCls: "icon-search",
            text: "查询",
            handler: function () {
                $.messager.alert("查询", "查询", "info");
            }
        }, {
            iconCls: "icon-remove",
            text: "清空",
            handler: function () {
                $.messager.alert("清空", "清空", "warning");
            }
        }]
    });

    // 格式数据
    function getNum(param) {
        if (param < 10) {
            return "0" + param;
        }
        return param;
    }

    // 获取教师信息数据
    function getTeaData() {
        var teaNum = $("#teaNum").textbox("getValue");
        var teaName = $("#teaName").textbox("getValue");
        var teaSex = $("input[name='teaSex']:checked").val();
        var teaBirthday = $("#teaBirthday").textbox("getValue");
        var teaMobile = $("#teaMobile").textbox("getValue");
        var teaPosition = $("#teaPosition").textbox("getValue");
        var teaQQ = $("#teaQQ").textbox("getValue");
        var teaInDate = $("#teaInDate").textbox("getValue");

        return {
            "teaName": teaName,
            "teaNum": teaNum,
            "teaSex": teaSex,
            "teaPhone": teaMobile,
            "teaPosition": teaPosition,
            "teaBirthday": teaBirthday,
            "teaInDate": teaInDate,
            "teaQQ": teaQQ
        };
    }

    // 提交新增数据
    $("#teaSubmit").click(function () {
        var param = JSON.stringify(getTeaData());
        console.log(param);
        $.ajax({
            url: "/teacher/addTeacher",
            type: "post",
            contentType: "application/json;charset=utf8",
            data: param,
            dataType: "json",
            success: function (data) {
                console.log(data.status);
                if (data.status === "true") {
                    $.messager.alert("信息", "添加成功！", "info");
                } else {
                    $.messager.alert("信息", "添加失败！", "error");
                }
            }
        });
    });

    // 关闭新增数据框
    $("#teaCancel").click(function () {
        $("#teaAddWin").window("close");
    });

});

// 编辑教师信息
function editStudent(param) {
    $.messager.alert("信息", param, "info");
}

// 删除教师信息
function deleteStudent(param) {
    $.messager.alert("信息", param, "warning");
}

// 查看教师信息
function detailStudent(param) {
    $.messager.alert("信息", param, "info");
}