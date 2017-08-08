
$(function () {
    $.ajax({
        type: 'GET',
        url: "http://localhost:8080/reports",
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        success: function (data) {
           const reportObj = data;
           console.log(reportObj);
            reportObj.reportItem.map(item => {
                let tr = "<tr>";
                tr += "<td>" + item.student.name + "</td>";
                tr += "<td>" + item.student.language + "</td>";
                tr += "<td>" + item.student.math + "</td>";
                tr += "<td>" + item.student.english + "</td>";
                tr += "<td>" + item.student.program + "</td>";
                tr += "<td>" + item.averageScore + "</td>";
                tr += "<td>" + item.totalScore + "</td>";
                tr += "</tr>";
                $("#table").append(tr);
            });
            $("#average").val(reportObj.averageOfClass);
            $("#middle").val(reportObj.medianOfClass);
        }
    });
});
