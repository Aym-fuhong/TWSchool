function search() {
    let studentId = $("#id").val();
    $("#tbody").remove();
    studentsInfo.map(item => {
        let tr = "<tr>";
        if (item.id === parseInt(studentId)) {
            tr += "<td>" + item.id + "</td>";
            tr += "<td>" + item.name + "</td>";
            tr += "<td>" + item.email + "</td>";
            tr += "<td>" + item.id_Card + "</td>";
            tr += "<td>" + item.phone + "</td>";
            tr += "<td>" + item.native_place + "</td>";
        }
        tr += "</tr>";
        $("#table").append(tr);
    })
}

$(function () {
    $.ajax({
        type: 'GET',
        url: "http://localhost:8080/students",
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        success: function (data) {
            const studentInfo = data;
            console.log(studentInfo);
            studentInfo.map(item => {
                let tr = "<tr>";
                tr += "<td>" + item.id + "</td>";
                tr += "<td>" + item.name + "</td>";
                tr += "<td>" + item.email + "</td>";
                tr += "<td>" + item.id_Card + "</td>";
                tr += "<td>" + item.phone + "</td>";
                tr += "<td>" + item.native_place + "</td>";
                tr += "</tr>";
                $("#table").append(tr);
            })
        }
    });


});
