'use strict';

module.exports = function countSameElements(collection) {
    let result = [];
    for(let i =0 ; i < collection.length; i++) {
        let obj = isExist(collection[i], result);
        if(obj){
            obj.count++;
        } else if(collection[i].includes('-')) {
          let combNum = collection[i].split('-');
          result.push({key: combNum[0], count: parseInt(combNum[1])});
        }else {
            result.push({key: collection[i], count: 1});
        }
    }
    return result;
};

function isExist(element, collection) {
    for(let j =0; j< collection.length; j++){
        if(element === collection[j].key){
            return collection[j];
        }
    }
}