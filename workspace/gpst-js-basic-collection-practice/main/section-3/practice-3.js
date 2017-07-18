'use strict';

module.exports = function createUpdatedCollection(collectionA, objectB) {
  let result = getObjOfArray(collectionA);
    for(let i =0; i< result.length; i++){
        if(isExist(result[i].key , objectB.value)){
            if(result[i].count >= 3 ) {
                result[i].count -= Math.floor(result[i].count / 3 );
            }
        }

    }
    return result;
};

function getObjOfArray(collection){
  let result = [];
  for(let i = 0; i< collection.length; i++){
      if(findOne(collection[i], result)){
        let obj = findOne(collection[i], result);
        obj.count++;
      } else {
        result.push({"key": collection[i], "count": 1});
      }
  }
return result;
};

function findOne(element, collection) {
    for(let j =0; j< collection.length; j++){
        if(element === collection[j].key){
            return collection[j];
        }
    }
};

function isExist(element, collection){
    for(let i = 0; i< collection.length;i++){
        if(element === collection[i]) {
            return true;
        }
    }
    return false;
}
