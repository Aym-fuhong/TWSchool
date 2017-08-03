$(function () {
    // $("form").submit(function () {
    //     let dataArray = $('form').serializeArray();
    //     // let newDataArray = [];
    //     // $.forEach(dataArray, function (index, element) {
    //     //     if (findOne(element.name, newDataArray)) {
    //     //         let item = findOne(element.name, newDataArray);
    //     //         item.value += element.value
    //     //     } else {
    //     //         newDataArray.add(element);
    //     //     }
    //     // });
    //
    //     localStorage.setItem("dataArray", JSON.stringify(dataArray));
    //     location.href = 'display.html';
    //     // }
    //     event.preventDefault();
    //     // return false;
    // });

    $("#form-paper").validate({
        rules: {
            class: "required",
            student_number: "required",
            name: "required",
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
            class: "请输入班级",
            student_number: "学号不能为空",
            name: "姓名不能为空",
            email: {
                required: "邮箱不能为空",
                email: "邮箱格式错误"
            },
            ID_Card: {
                required: "身份证号不能为空",
                minlength: "身份证号长度不能小于5"
            }
        },
        submitHandler:function(form){
            form.event.preventDefault();
            let dataArray = $('form').serializeArray();
            localStorage.setItem("dataArray", JSON.stringify(dataArray));
                location.href = 'display.html';
        }
        // showErrors: function (errorMap, errorList) {
        //     $("#error").html("Your form contains " + this.numberOfInvalids() + " errors,see details below.");
        //     this.defaultShowErrors();
        // },
    });
});
function findOne(element, collection) {
    return collection.find(item => item.name = element);
}