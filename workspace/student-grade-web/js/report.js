let reportObj = {
    studentInfo: [
        {name: "aym", language: 89, math: 99, English: 100, program: 100},
        {name: "jack", language: 89, math: 99, English: 100, program: 100},
        {name: "rose", language: 89, math: 99, English: 100, program: 100},
    ],
    classOverage: 123,
    classMiddle: 234
};
localStorage.setItem("reportObj", JSON.stringify(reportObj));

$(function () {
    $.ajax({
        type: 'GET',
        url: "http://localhost:8080/reports",
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        success: function (data) {
           const reportObj = data;
           console.log(reportObj);
            reportObj.studentList.map(item => {
                let tr = "<tr>";
                tr += "<td>" + item.name + "</td>";
                tr += "<td>" + item.language + "</td>";
                tr += "<td>" + item.math + "</td>";
                tr += "<td>" + item.english + "</td>";
                tr += "<td>" + item.program + "</td>";
                tr += "</tr>";
                $("#table").append(tr);
            });
            $("#average").val(reportObj.averageOfClass);
            $("#middle").val(reportObj.medianOfClass);
        }
    });
});
