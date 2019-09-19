$(function () {

    $('#dg').datagrid({
        url: "/student/infoList",
        method: "get",
        fit: true,
        rownumbers: true,
        singleSelect: true,
        pagination: true,
        title: "学生信息数据",
        columns: [[
            {field: 'stuNum', width: 100, align: 'center', title: "学号"},
            {field: 'stuName', width: 80, align: 'center', title: "姓名"},
            {field: 'stuSex', width: 80, align: 'center', title: "性别"},
            {
                field: 'stuBirthday', width: 140, align: 'center', title: "生日",
                formatter: function (value) {
                    var date = new Date(value);
                    var year = date.getFullYear();
                    var month = date.getMonth() + 1;
                    var day = date.getDate();
                    return year + "-" + getNum(month) + "-" + getNum(day);
                }
            },
            {field: 'stuQQ', width: 110, align: 'center', title: "QQ"},
            {field: 'stuMobile', width: 130, align: 'center', title: "电话"},
            {
                field: 'stuCreateTime', width: 140, align: 'center', title: "入学日期",
                formatter: function (value) {
                    var date = new Date(value);
                    var year = date.getFullYear();
                    var month = date.getMonth() + 1;
                    var day = date.getDate();
                    return year + "-" + getNum(month) + "-" + getNum(day);
                }
            },
            {field: 'stuGrade', width: 80, align: 'center', title: "班级"},
            {field: 'stuSubject', width: 140, align: 'center', title: "专业"},
            {
                field: '_operate', width: 320, align: 'center', title: "操作",
                formatter: function (value, row, index) {
                    console.log(row.stuNum);
                    var str = '<a href="javascript:void(0);" class="update_btn" onClick = "editStudent(' + row.stuNum + ')"'+
                        ' >修改</a>'+
                        '&nbsp;&nbsp;&nbsp;&nbsp;'+
                        '<a href="javascript:void(0);" class="delete_btn" onclick = "deleteStudent(' + row.stuNum + ')"'+
                        ' >删除</a>'+
                        '&nbsp;&nbsp;&nbsp;&nbsp;'+
                        '<a href="javascript:void(0);" class="detail_btn" onclick = "detailStudent(' + row.stuNum + ')"'+
                        '>查看</a>';
                    return str;
                }
            }
        ]],
        onLoadSuccess: function(data) {
            $(".update_btn").linkbutton({
                text:"编辑",
                plain:true,
                iconCls:"icon-edit"
            });
            $(".delete_btn").linkbutton({
                text:"删除",
                plain:true,
                iconCls:"icon-remove"
            });
            $(".detail_btn").linkbutton({
                text:"查看",
                plain:true,
                iconCls:"icon-search"
            });
        },
        toolbar: [{
            iconCls: 'icon-add',
            text: "新增",
            handler: function () {
                $("#w").window('open');
            }
        }, {
            text: "学号：<input id='searchNum' class='easyui-textbox' style='height:20px;width:100px;' />"
        }, {
            text: "姓名：<input id='searchName' class='easyui-textbox' style='height:20px; width: 100px;' />"
        }, {
            text: "电话：<input id='searchMobile' class='easyui-textbox' style='height:20px; width: 100px;' />"
        }, {
            text: "QQ：<input id='searchQQ' class='easyui-textbox' style='height:20px; width: 100px;' />"
        }, {
            text: "班级：<input id='searchGrade' class='easyui-textbox' style='height: 20px; width: 100px;' />"
        }, {
            text: "专业：<input id='searchSubject' class='easyui-textbox' style='height: 20px; width: 100px;' />"
        }, {
            iconCls: 'icon-search',
            text: "查询",
            handler: function () {
                var searchNum = $("#searchNum").textbox("getValue");
                var searchName = $("#searchName").textbox("getValue");
                var searchMobile = $("#searchMobile").textbox("getValue");
                var searchQQ = $("#searchQQ").textbox("getValue");
                var searchGrade = $("#searchGrade").textbox("getValue");
                var searchSubject = $("#searchSubject").textbox("getValue");
                var data = {
                    "searchNum": searchNum, "searchName": searchName,
                    "searchMobile": searchMobile, "searchQQ": searchQQ,
                    "searchGrade": searchGrade, "searchSubject": searchSubject
                };
                $("#stuListWin").window("open");
                $("#stuList").datagrid({
                    loader: function (stuInfo, success, error) {
                        var stuInfo = JSON.stringify(data);
                        console.log(stuInfo);
                        $.ajax({
                            url: "/student/queryByColumn",
                            type: "post",
                            dataType: "json",
                            data: stuInfo,
                            contentType: "json/application;charset=utf-8",
                            success: function (data) {
                                console.log(data);
                                success(data);
                            }
                        });
                    },
                    fit: true,
                    rownumbers: true,
                    singleSelect: true,
                    pagination: true,
                    columns: [[
                        {field: 'stuNum', width: 100, align: 'center', title: "学号"},
                        {field: 'stuName', width: 80, align: 'center', title: "姓名"},
                        {field: 'stuSex', width: 80, align: 'center', title: "性别"},
                        {
                            field: 'stuBirthday', width: 140, align: 'center', title: "生日",
                            formatter: function (value) {
                                var date = new Date(value);
                                var year = date.getFullYear();
                                var month = date.getMonth() + 1;
                                var day = date.getDate();
                                return year + "-" + getNum(month) + "-" + getNum(day);
                            }
                        },
                        {field: 'stuQQ', width: 110, align: 'center', title: "QQ"},
                        {field: 'stuMobile', width: 130, align: 'center', title: "电话"},
                        {
                            field: 'stuCreateTime', width: 140, align: 'center', title: "入学日期",
                            formatter: function (value) {
                                var date = new Date(value);
                                var year = date.getFullYear();
                                var month = date.getMonth() + 1;
                                var day = date.getDate();
                                return year + "-" + getNum(month) + "-" + getNum(day);
                            }
                        },
                        {field: 'stuGrade', width: 80, align: 'center', title: "班级"},
                        {field: 'stuSubject', width: 140, align: 'center', title: "专业"}
                    ]]
                });
            }
        }, {
            iconCls: 'icon-remove',
            text: "清空",
            handler: function () {
                $("#searchNum").textbox("setValue", "");
                $("#searchName").textbox("setValue", "");
                $("#searchMobile").textbox("setValue", "");
                $("#searchQQ").textbox("setValue", "");
                $("#searchGrade").textbox("setValue", "");
                $("#searchSubject").textbox("setValue", "");
            }
        }]
    });

    $("#stuSubject").combobox({
        onChange: function () {
            var stuSubject = $("#stuSubject").combobox("getValue");
            var $grade = $("#stuGrade");
            setGrade(stuSubject, $grade);
        }
    });

    // 修改信息
    $("#stuSubjectUpdate").combobox({
        onChange: function () {
            var stuSubjectUpdate = $("#stuSubjectUpdate").combobox("getValue");
            var $stuGradeUpdate = $("#stuGradeUpdate");
            setGrade(stuSubjectUpdate, $stuGradeUpdate);
        }
    });

    // 班级和与专业
    function setGrade(stuSubject, $grade) {
        switch (stuSubject) {
            case "电子信息工程":
                $grade.textbox("setValue", "1班");
                break;
            case "物联网工程":
                $grade.textbox("setValue", "2班");
                break;
            case "计算机科学与技术":
                $grade.textbox("setValue", "3班");
                break;
            case "通信工程":
                $grade.textbox("setValue", "4班");
                break;
            case "网络工程":
                $grade.textbox("setValue", "5班");
                break;
            default:
                $grade.textbox("setValue", "");
                break;
        }
    }

    // 格式化数据
    function getNum(value) {
        if (value >= 10) {
            return value;
        } else {
            return "0" + value;
        }
    }

    // 获取新增数据
    function getData() {
        var stuNum = $("#stuNum").textbox("getValue");
        var stuName = $("#stuName").textbox("getValue");
        var stuSex = $("input[type=radio]:checked").val();
        var stuBirthday = $("#stuBirthday").textbox("getValue");
        var stuQQ = $("#stuQQ").textbox("getValue");
        var stuMobile = $("#stuMobile").textbox("getValue");
        var stuCreateTime = $("#stuCreateTime").textbox("getValue");
        var stuSubject = $("#stuSubject").combobox("getValue");
        var stuGrade = $("#stuGrade").textbox("getValue");

        return {
            "stuNum": stuNum,
            "stuName": stuName,
            "stuSex": stuSex,
            "stuBirthday": stuBirthday,
            "stuQQ": stuQQ,
            "stuMobile": stuMobile,
            "stuCreateTime": stuCreateTime,
            "stuGrade": stuGrade,
            "stuSubject": stuSubject
        };
    }

    // 提交数据
    $("#submit").click(function () {
        var data = getData();
        var student = JSON.stringify(data);
        console.log(student);
        $.ajax({
            url: "/student/addStudent",
            type: "post",
            data: student,
            contentType: "json/application;charset=utf-8",
            dataType: 'json',
            success: function (data) {
                console.log(data.code);
                if (data.code === 1) {
                    $.messager.alert("标题", "新增成功！", "info");
                } else {
                    $.messager.alert("标题", "新增失败！", "error");
                }
            }
        });
    });

    // 关闭新增框
    $("#cancel").click(function () {

        $("#stuNum").textbox("setValue", "");
        $("#stuName").textbox("setValue", "");
        $("#stuBirthday").textbox("setValue", "");
        $("#stuQQ").textbox("setValue", "");
        $("#stuMobile").textbox("setValue", "");
        $("#stuCreateTime").textbox("setValue", "");
        $("#stuSubject").combobox("setValue", "");
        $("#stuGrade").textbox("setValue", "");

        $("#w").window("close");
    });

    // 关闭信息框
    $("#ok").click(function () {
        $("#stuListWin").window("close");
    });

    // 关闭修改信息框
    $("#cancelUpdate").click(function () {
        $("#updateWindow").window("close");
    });

    // 获取修改的信息数据
    function getUpdateData() {
        var stuNum = $("#stuNumUpdate").textbox("getValue");
        var stuName = $("#stuNameUpdate").textbox("getValue");
        var stuSex = $("input[type=radio]:checked").val();
        var stuBirthday = $("#stuBirthdayUpdate").textbox("getValue");
        var stuQQ = $("#stuQQUpdate").textbox("getValue");
        var stuMobile = $("#stuMobileUpdate").textbox("getValue");
        var stuCreateTime = $("#stuCreateTimeUpdate").textbox("getValue");
        var stuSubject = $("#stuSubjectUpdate").textbox("getValue");
        var stuGrade = $("#stuGradeUpdate").textbox("getValue");

        var data = {
            "stuNum": stuNum, "stuName": stuName, "stuSex": stuSex,
            "stuBirthday": stuBirthday, "stuQQ": stuQQ, "stuMobile": stuMobile,
            "stuCreateTime": stuCreateTime, "stuSubject": stuSubject, "stuGrade": stuGrade
        };

        return data;
    }

    // 提交修改的信息
    $("#submitUpdate").click(function () {
        var updateData = getUpdateData();
        var data = JSON.stringify(updateData);
        console.log(data);
        $.ajax({
            url: "/student/updateStudent",
            type: "post",
            data: data,
            contentType: "application/json;charset=utf-8",
            dataType: "json",
            success: function (data) {
                if (data.code === 1) {
                    $.messager.alert("标题", "修改成功！！！", "info");
                } else {
                    $.messager.alert("标题", "修改失败！！！", "error");
                }
            }
        });
    });

});

// 修改方法
function commData(paramData, flag) {
    var url = "/student/info";
    if("update" === flag) {
        $.ajax({
            url: url,
            type: "post",
            contentType: "application/json;charset=utf-8",
            data: paramData,
            dataType: "json",
            success: roleBackUpdate
        });
    }
    if("detail" === flag) {
        $.ajax({
            url: url,
            type: "post",
            contentType: "application/json;charset=utf-8",
            data: paramData,
            dataType: "json",
            success: roleBackDetail
        });
    }
}

// 展示修改数据
function roleBackUpdate(data) {
    var stu = data.student;
    console.log(stu);
    $("#stuNumUpdate").textbox("setValue", stu.stuNum);
    $("#stuNameUpdate").textbox("setValue", stu.stuName);
    if ("男" === stu.stuSex) {
        $("input[name='fruitUpdate'][value='男']").prop("checked", true);
    }
    if ("女" === stu.stuSex) {
        $("input[name='fruitUpdate'][value='女']").prop("checked", true);
    }
    $("#stuBirthdayUpdate").textbox("setValue", formatDate(stu.stuBirthday));
    $("#stuQQUpdate").textbox("setValue", stu.stuQQ);
    $("#stuMobileUpdate").textbox("setValue", stu.stuMobile);
    $("#stuCreateTimeUpdate").textbox("setValue", formatDate(stu.stuCreateTime));
    $("#stuSubjectUpdate").textbox("setValue", stu.stuSubject);
    $("#stuGradeUpdate").textbox("setValue", stu.stuGrade);
}

// 格式化日期
function formatDate(param) {
    var num = 1;
    var date = new Date(param);
    var year = date.getFullYear();
    var month = date.getMonth() + num;
    var day = date.getDate();
    return year + "-" + formatNum(month) + "-" + formatNum(day);
}

// 格式化数字
function formatNum(param) {
    if (param < 10) {
        return "0" + param;
    }
    return param;
}

// 修改信息
function editStudent(paramData) {
    $("#updateWindow").window("open");
    var data = {"stuNum": paramData};
    var param = JSON.stringify(data);
    commData(param, "update");
}

// 删除学生信息
function deleteStudent(param) {
    $.messager.confirm("标题", "确定要删除该条信息！", function (r) {
        var data = {"stuNum": param};
        if (r) {
            $.ajax({
                url: "/student/deleteStu",
                type: "post",
                data: JSON.stringify(data),
                contentType: "json/application;charset=utf-8",
                dataType: "json",
                success: function (data) {
                    if (data.code === 1) {
                        $.messager.alert("标题", "删除成功！", "info");
                    } else {
                        $.messager.alert("标题", "删除失败！", "error");
                    }
                }
            });
        }
    });
}

// 展示查看数据
function roleBackDetail(data) {
    var stu = data.student;
    console.log(stu);
    $("#stuNumDetail").textbox("setValue", stu.stuNum);
    $("#stuNameDetail").textbox("setValue", stu.stuName);
    if ("男" === stu.stuSex) {
        $("input[name='fruitDetail'][value='男']").prop("checked", true);
    }
    if ("女" === stu.stuSex) {
        $("input[name='fruitDetail'][value='女']").prop("checked", true);
    }
    $("#stuBirthdayDetail").textbox("setValue", formatDate(stu.stuBirthday));
    $("#stuQQDetail").textbox("setValue", stu.stuQQ);
    $("#stuMobileDetail").textbox("setValue", stu.stuMobile);
    $("#stuCreateTimeDetail").textbox("setValue", formatDate(stu.stuCreateTime));
    $("#stuSubjectDetail").textbox("setValue", stu.stuSubject);
    $("#stuGradeDetail").textbox("setValue", stu.stuGrade);
}

// 查看
function detailStudent(paramData) {
    $("#DetailWindow").window("open");
    var data = {"stuNum": paramData};
    var param = JSON.stringify(data);
    commData(param, "detail");
}