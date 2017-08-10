function search() {
    let studentId = $("#id").val();
    $.ajax({
        type: 'GET',
        url: "http://localhost:8080/students/" + studentId,
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        success: function (data) {
            $("#tbody").remove();
            data.map(item => {
                let tr = "<tr>";
                tr += "<td id='studentId'>" + item.id + "</td>";
                tr += "<td>" + item.name + "</td>";
                tr += "<td>" + item.email + "</td>";
                tr += "<td>" + item.id_Card + "</td>";
                tr += "<td>" + item.phone + "</td>";
                tr += "<td>" + item.native_place + "</td>";
                tr += "<td>" + '<a><input id="addGrade" class="btn btn-primary" value="添加成績"></a>' + "</td>";
                tr += "</tr>";
                $("#table").append(tr);
            })
        }
    });
}

$(function () {
    $.ajax({
        type: 'GET',
        url: "http://localhost:8080/students",
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        success: function (data) {
            data.map(item => {
                let tr = "<tr>";
                tr += "<td id='studentId'>" + item.id + "</td>";
                tr += "<td>" + item.name + "</td>";
                tr += "<td>" + item.email + "</td>";
                tr += "<td>" + item.id_Card + "</td>";
                tr += "<td>" + item.phone + "</td>";
                tr += "<td>" + item.native_place + "</td>";
                tr += "<td>" + '<a href="../html/student_grade.html?studentId='+ item.id +'">' +
                    '<input id="addGrade" class="btn btn-primary" value="添加成績"></a>' + "</td>";
                tr += "</tr>";
                $("#table").append(tr);
            })
        }
    });

});
