const studentsInfo = JSON.parse(localStorage.getItem("studentsInfo"));

function search() {
    let studentId = $("#id").val();
    $("#tbody").remove();
    studentsInfo.map(item => {
        let tr = "<tr>";
        if (item[5].value === parseInt(studentId)) {
            tr += "<td>" + item[5].value + "</td>";
            tr += "<td>" + item[0].value + "</td>";
            tr += "<td>" + item[1].value + "</td>";
            tr += "<td>" + item[2].value + "</td>";
            tr += "<td>" + item[3].value + "</td>";
            tr += "<td>" + item[4].value + "</td>";
        }
        tr += "</tr>";
        $("#table").append(tr);
    })
}

$(function () {
    studentsInfo.map(item => {
        let tr = "<tr>";
        tr += "<td>" + item[5].value + "</td>";
        tr += "<td>" + item[0].value + "</td>";
        tr += "<td>" + item[1].value + "</td>";
        tr += "<td>" + item[2].value + "</td>";
        tr += "<td>" + item[3].value + "</td>";
        tr += "<td>" + item[4].value + "</td>";
        tr += "</tr>";
        $("#table").append(tr);
    })

});
