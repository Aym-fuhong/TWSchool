'use strict';

function findOne(element, collection) {
  for (let i = 0; i < collection.length; i++) {
    if (element === collection[i].barcode) {
      return collection[i];
    }
  }
};

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

};

function isExist(element, collection){
  let isExist = false;
  for(let i=0; i < collection.length; i++){
    if(element === collection[i]){
      isExist = true;
    }
  }
  return isExist;
}

function addTypeOfPromotionItem(collection) {
  let promotions = loadPromotions();
  for(let i = 0; i < collection.length;i++){
    for(let j=0; j < promotions.length;j++){
      if(isExist(collection[i].barcode ,promotions[j].barcodes)){
         collection[i].type = promotions[j].type
      }
    }
  }
  return collection;
}



function printReceipt(collection) {

};


