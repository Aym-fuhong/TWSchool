'use strict';

let AllItems = Item.all();
let Promotions = Promotion.all();

function printReceipt(collection) {
  let formattedTags = formatTags(collection);
  let cartItems = getCartItems(formattedTags, AllItems);
  let receiptObj = calculatePrice(cartItems);
  let result = getReceiptStr(receiptObj, currentDate);
  return result;
}

function formatTags(collection) {
  let splitedTags = splitTags(collection);
  let formattedTags = getItemsCount(splitedTags);
  return formattedTags;
}

function calculatePrice(cartItems) {
  let itemsPromotionType = getItemsPromotionType(cartItems, Promotions);
  let itemsPrice = getItemsPrice(itemsPromotionType);
  let receiptObj = getReceiptObj(itemsPrice);
  return receiptObj;

}

function splitTags(collection) {
  return collection.map((item) => {
    if (item.includes('-')) {
      let element = item.split('-');
      return {barcode: element[0], count: parseFloat(element[1])};
    } else {
      return {barcode: item, count: 1};
    }
  });
}

function getItemsCount(splitedTags) {
  let formattedTags = [];
  splitedTags.forEach(item => {
    if (findItem(item.barcode, formattedTags)) {
      let element = findItem(item.barcode, formattedTags);
      element.count += item.count;
    } else {
      formattedTags.push({barcode: item.barcode, count: item.count});
    }
  });
  return formattedTags;
}


function getCartItems(formattedTags, items) {
  return formattedTags.map(item => {
    if (findItem(item.barcode, items)) {
      let element = findItem(item.barcode, items);
      item.name = element.name;
      item.unit = element.unit;
      item.price = element.price;
    }
    return item;
  });
}

function getItemsPromotionType(cartItems, promotion) {
  return cartItems.map(item => {
      promotion.forEach(element => {
        if (isPromotionItem(item.barcode, element.barcodes)) {
          item.type = element.type;
        }
      });
      return item;
    }
  );
}

function getItemsPrice(itemsPromotionType) {
  return itemsPromotionType.map(item => {
    if (item.type) {
      if (item.count >= 3) {
        item.itemPrice = parseFloat(item.price * (item.count - 1));
      }
    } else {
      item.itemPrice = parseFloat(item.price * item.count);
    }
    return item;
  });

}

function getReceiptObj(itemsPrice) {
  let receiptObj = {};
  let totalPrice = 0;
  let savedPrice = 0;
  itemsPrice.forEach(item => {
    totalPrice += item.itemPrice;
    savedPrice += item.count * item.price - item.itemPrice;
  });
  receiptObj.items = itemsPrice;
  receiptObj.totalPrice = parseFloat(totalPrice);
  receiptObj.savedPrice = parseFloat(savedPrice);
  return receiptObj;
}

function getReceiptStr(receiptObj) {
  let formattedCurrentDate = getCurrentDate();
  let line = `***<没钱赚商店>收据***\n`;
  line += formattedCurrentDate;
  line += `----------------------\n`;
  for (let i = 0; i < receiptObj.items.length; i++) {
    let item = receiptObj.items[i];
    line += `名称：${item.name}，数量：${item.count}${item.unit}，单价：${item.price.toFixed(2)}(元)，小计：${item.itemPrice.toFixed(2)}(元)\n`
  }
  line += `----------------------\n`;
  line += `总计：${receiptObj.totalPrice.toFixed(2)}(元)
节省：${receiptObj.savedPrice.toFixed(2)}(元)
**********************`;
  return line;
}
function getCurrentDate() {
  const dateDigitToString = num => (num < 10 ? `0${num}` : num);
  const currentDate = new Date(),
    year = dateDigitToString(currentDate.getFullYear()),
    month = dateDigitToString(currentDate.getMonth() + 1),
    date = dateDigitToString(currentDate.getDate()),
    hour = dateDigitToString(currentDate.getHours()),
    minute = dateDigitToString(currentDate.getMinutes()),
    second = dateDigitToString(currentDate.getSeconds()),
    formattedDateString = `打印时间：${year}年${month}月${date}日 ${hour}:${minute}:${second}\n`;
  return formattedDateString;
}

function isPromotionItem(element, collection) {
  return collection.find(item => element === item);
}
function findItem(element, collection) {
  return collection.find(item => element === item.barcode);
}




