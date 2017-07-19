'use strict';

function findOne(element, collection) {
  for (let i = 0; i < collection.length; i++) {
    if (element === collection[i].barcode) {
      return collection[i];
    }
  }
}

function splitCollection(collection) {
  let splitedCollection = [];
  for (let i = 0; i < collection.length; i++) {
    if (collection[i].includes('-')) {
      let array = collection[i].split('-');
      splitedCollection.push({barcode: array[0], count: parseFloat(array[1])});
    } else {
      splitedCollection.push({barcode: collection[i], count: 1});
    }
  }
  return splitedCollection;
}

function getItemCount(splitedCollection) {
  let formattedCollection = [];
  for (let i = 0; i < splitedCollection.length; i++) {
    if (findOne(splitedCollection[i].barcode, formattedCollection)) {
      let item = findOne(splitedCollection[i].barcode, formattedCollection);
      item.count += splitedCollection[i].count;
    } else {
      formattedCollection.push({barcode: splitedCollection[i].barcode, count: splitedCollection[i].count});
    }
  }
  return formattedCollection;
}

function getItemsInfo(formattedCollection) {
  let AllItems = loadAllItems();
  for (let i = 0; i < formattedCollection.length; i++) {
    if (findOne(formattedCollection[i].barcode, AllItems)) {
      let Item = findOne(formattedCollection[i].barcode, AllItems);
      formattedCollection[i].name = Item.name;
      formattedCollection[i].price = Item.price;
      formattedCollection[i].unit = Item.unit;
    }
  }
  return formattedCollection;
}

function isExist(element, collection) {
  let isExist = false;
  for (let i = 0; i < collection.length; i++) {
    if (element === collection[i]) {
      isExist = true;
    }
  }
  return isExist;
}

function addTypeOfPromotionItem(collection) {
  let promotions = loadPromotions();
  for (let i = 0; i < collection.length; i++) {
    for (let j = 0; j < promotions.length; j++) {
      if (isExist(collection[i].barcode, promotions[j].barcodes)) {
        collection[i].type = promotions[j].type
      }
    }
  }
  return collection;
}

function getItemPrice(collection) {
  for (let i = 0; i < collection.length; i++) {
    let itemPrice = collection[i].price * collection[i].count;
    if (collection[i].type === 'BUY_TWO_GET_ONE_FREE') {
      itemPrice = collection[i].count >= 3 ? itemPrice - collection[i].price : itemPrice
    }
    collection[i].itemPrice = parseFloat(itemPrice.toFixed(2));
  }
  return collection;
}

function getTotalPrice(collection) {
  let result = {};
  let totalPrice = 0;
  let sumPrice = 0;
  for (let i = 0; i < collection.length; i++) {
    totalPrice += collection[i].itemPrice;
    sumPrice += collection[i].price * collection[i].count;
  }
  result.items = collection;
  result.totalPrice = parseFloat(totalPrice.toFixed(2));
  result.savedPrice = parseFloat(sumPrice - totalPrice.toFixed(2));
  return result;
}

function getReceiptString(object) {
  let line = `***<没钱赚商店>收据***\n`;
  for (let i = 0; i < object.items.length; i++) {
    let item = object.items[i];
    line += `名称：${item.name}，数量：${item.count}${item.unit}，单价：${item.price.toFixed(2)}(元)，小计：${item.itemPrice.toFixed(2)}(元)\n`
  }
  line += `----------------------\n`;
  line += `总计：${object.totalPrice.toFixed(2)}(元)
节省：${object.savedPrice.toFixed(2)}(元)
**********************`;
  return line ;
}
function printReceipt(collection) {
  let splitCollection = splitCollection(collection);
  console.log(splitCollection,'splitcollection------');
  let formattedCollection = getItemCount(splitCollection);
  let itemsInfo = getItemsInfo(formattedCollection);
  let itemTypeOfPromotionitems = addTypeOfPromotionItem(itemsInfo);
  let itemPriceOfitems = getItemPrice(itemTypeOfPromotionitems);
  let totalPticeofItems = getTotalPrice(itemPriceOfitems);
  let result = getReceiptString(totalPticeofItems);
  return result;
}


