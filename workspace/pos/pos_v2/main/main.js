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
    if(item.includes('-')){
      let element = item.split('-');
      return {barcode: element[0], count: parseFloat(element[1])};
    } else {
      return {barcode: item, count: 1};
    }});
}

function getCurrentDate() {
  return '';
}
function getCartItems(collection, items) {

}




