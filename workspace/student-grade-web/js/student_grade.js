
$(function () {
    $.urlParam = function(name){
        var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
        return results[1] || 0;
    };
    let studentId = $.urlParam('studentId');
    alert(studentId);
    $("#form").validate({
        rules: {
            id: "required",
            math: "required",
            language: "required",
            english: "required",
            program: "required",
        },
        messages: {
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
            let studentGrade = {};
            dataArray.map(item => {
                studentGrade[item.name] = item.value;
            });
            $.ajax({
                type: 'POST',
                url: "http://localhost:8080/students/" + studentId + "/grades",
                data: JSON.stringify(studentGrade),
                dataType: "json",
                contentType: "application/json;charset=utf-8",
                success: function () {
                    alert("学生成績添加成功！");
                }
            });

            $("#form")[0].reset();

        }
    });
});
