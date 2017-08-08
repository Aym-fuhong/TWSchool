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
            math: "required",
            language: "required",
            english: "required",
            program: "required"
        },
        messages: {
            user_name: "请输入姓名",
            math: {
                required: "数学成绩不能为空",
            },
            language: {
                required: "语文成绩不能为空",
            },
            english: {
                required: "英语成绩不能为空",
            },
            program: {
                required: "编程成绩不能为空",
            },

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
