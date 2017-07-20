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
      if(item.count >= 3){
        item.itemPrice = parseFloat(item.price * (item.count - 1));
      }
    } else {
      item.itemPrice = parseFloat(item.price * item.count);
    }
    return item;
  });

}

function getReceiptObj(itemsPrice){
  let receiptObj = {};
  let totalPrice = 0;
  let savedPrice = 0;
  itemsPrice.forEach(item => {
    totalPrice += item.itemPrice;
    savedPrice += item.count*item.price - item.itemPrice;
  });
  receiptObj.items = itemsPrice;
  receiptObj.totalPrice = parseFloat(totalPrice);
  receiptObj.savedPrice = parseFloat(savedPrice);
  return receiptObj;
}

function getCurrentDate() {
  return '';
}

function isPromotionItem(element, collection) {
  return collection.find(item => element === item);
}
function findItem(element, collection) {
  return collection.find(item => element === item.barcode);
}




