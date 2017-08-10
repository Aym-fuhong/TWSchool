$(function () {
    $("#form").validate({
        rules: {
            name: "required",
            phone: "required",
            native_place: "required",
            email: {
                required: true,
                email: true
            },
            id_Card: {
                required: true,
                minlength: 5

            }
        },
        messages: {
            name: "请输入姓名",
            phone: "手机号不能为空",
            native_place: "籍贯不能为空",
            email: {
                required: "邮箱不能为空",
                email: "邮箱格式错误"
            },
            id_Card: {
                required: "身份证号不能为空",
                minlength: "身份证号长度不能小于5"
            }

        },
        submitHandler: function (form) {
            event.preventDefault();
            let dataArray = $('#form').serializeArray();
            let studentObj = {};
            dataArray.map(item => {
                studentObj[item.name] = item.value;
            });
            $.ajax({
                type: 'POST',
                url: "http://localhost:8080/students",
                data: JSON.stringify(studentObj),
                dataType: "json",
                contentType: "application/json;charset=utf-8",
                success: function () {
                    alert("学生添加成功！");
                }
            });

            $("#form")[0].reset();

        }
    });
});
