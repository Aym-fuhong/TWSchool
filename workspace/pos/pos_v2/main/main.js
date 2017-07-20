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

function getReceiptStr(receiptobj) {
  let formattedCurrentDate = getCurrentDate();
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

function getCurrentDate() {
  return '';
}

function getCartItems(collection, items) {

}
function findItem(element, collection) {
  return collection.find(item => element === item.barcode);
}




