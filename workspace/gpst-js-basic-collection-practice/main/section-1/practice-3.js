'use strict';

module.exports = function collectSameElements(collectionA, objectB) {
  let result =[];
  for(let j =0; j< collectionA.length; j++){
    if(isExist(collectionA[j], objectB.value)){
      result.push(collectionA[j]);
    }
  }
  return result;
};

function isExist(element, collection) {
  for(let i = 0; i< collection.length;i++){
    if(element === collection[i]) {
        return true;
    }
  }
  return false;
};
