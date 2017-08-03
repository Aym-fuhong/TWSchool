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
    const reportObj = JSON.parse(localStorage.getItem("reportObj"));
    reportObj.studentInfo.map(item => {
        let tr = "<tr>";
        tr += "<td>" + item.name + "</td>";
        tr += "<td>" + item.language + "</td>";
        tr += "<td>" + item.math + "</td>";
        tr += "<td>" + item.English + "</td>";
        tr += "<td>" + item.program + "</td>";
        tr += "</tr>";
        $("#table").append(tr);
    });
    $("#average").val(reportObj.classOverage);
    $("#middle").val(reportObj.classMiddle);
});
