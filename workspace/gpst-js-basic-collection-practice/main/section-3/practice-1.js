'use strict';

module.exports = function createUpdatedCollection(collectionA, objectB) {
  for(let i =0; i< collectionA.length; i++){
    if(isExist(collectionA[i].key , objectB.value)){
      collectionA[i].count = collectionA[i].count - 1 ;
    }
  }
  return collectionA;
};

function isExist(element, collection){
        for(let i = 0; i< collection.length;i++){
            if(element === collection[i]) {
                return true;
            }
        }
        return false;
    }