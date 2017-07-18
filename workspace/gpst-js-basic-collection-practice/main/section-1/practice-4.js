'use strict';

module.exports = function collectSameElements(collectionA, objectB) {
    let result =[];
    for(let j =0; j< collectionA.length; j++){
        if(compare(collectionA[j].key, objectB.value)){
            result.push(collectionA[j].key);
        }
    }
    return result;
};

function compare(element, collection) {
    for(let i = 0; i< collection.length;i++){
        if(element === collection[i]) {
            return true;
        }
    }
    return false;
};