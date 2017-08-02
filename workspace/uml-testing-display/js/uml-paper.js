$(function () {
    $(":submit[id=tijiao]").click(function (check) {
        let email = $(":text[id=email]").val();
        let card = $(":text[id=card]").val();
        if (card === "") {
            alert("文本框输入为空！");
            $(":text[id=card]").focus();
        } else if(email === ""){
            alert("文本框输入为空！");
            $(":text[id=email]").focus();
        }else if (card.match("/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/") === false) {
            alert("格式错误！");
            $(":text[id=card]").focus();
        } else {
            let dataArray = $('form').serializeArray();
            // let newDataArray = [];
            // $.forEach(dataArray, function (index, element) {
            //     if (findOne(element.name, newDataArray)) {
            //         let item = findOne(element.name, newDataArray);
            //         item.value += element.value
            //     } else {
            //         newDataArray.add(element);
            //     }
            // });
            localStorage.setItem("dataArray", JSON.stringify(dataArray));
            location.href = 'display.html';
        }
        return false;
    });
});
function findOne(element, collection) {
    return collection.find(item => item.name = element);
}