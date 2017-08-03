function addStudent(student) {
    const list = JSON.parse(localStorage.getItem("studentsInfo")) || [];
    let studentId = list.length + 1;
    student.push({name: "studentId", value: studentId});
    list.push(student);
    localStorage.setItem("studentsInfo", JSON.stringify(list));
}

$(function () {
    $("#form").validate({
        rules: {
            user_name: "required",
            province: "required",
            city: "required",
            phone: "required",
            native_place: "required",
            email: {
                required: true,
                email: true
            },
            ID_Card: {
                required: true,
                minlength: 5

            }
        },
        messages: {
            user_name: "请输入姓名",
            phone: "手机号不能为空",
            native_place: "籍贯不能为空",
            email: {
                required: "邮箱不能为空",
                email: "邮箱格式错误"
            },
            ID_Card: {
                required: "身份证号不能为空",
                minlength: "身份证号长度不能小于5"
            }
        },
        submitHandler: function (form) {
            event.preventDefault();
            let dataArray = $('#form').serializeArray();
            addStudent(dataArray);
            alert("学生添加成功！");
            $("#form")[0].reset();

        }
    });
});
