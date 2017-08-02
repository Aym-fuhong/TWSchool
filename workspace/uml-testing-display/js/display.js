$(function () {
    //    function CreateTable(array, cellCount) {
//        var table = $("<table border=\"1\">");
//        table.appendTo($("#createtable"));
//        for (var i = 0; i < array.length; i++) {
//            var tr = $("<tr></tr>");
//            tr.appendTo(table);
//            for (var j = 0; j < cellCount; j++) {
//                var td = $("<td>" + i * j + "</td>");
//                td.appendTo(tr);
//            }
//        }
//        trend.appendTo(table);
//        $("#createtable").append("</table>");
//    }
    $(".createTable").text(localStorage.getItem('dataArray'));
//    let dataArrayString = localStorage.getItem('dataArray');
//    let dataArray = JSON.parse(dataArrayString);
});
