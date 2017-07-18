'use strict';

module.exports = function createUpdatedCollection(collectionA, objectB) {
    for(let i =0; i< collectionA.length; i++){
        if(isExist(collectionA[i].key , objectB.value)){
          if(collectionA[i].count >= 3 ) {
            collectionA[i].count -= Math.floor(collectionA[i].count / 3 );
          }
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

