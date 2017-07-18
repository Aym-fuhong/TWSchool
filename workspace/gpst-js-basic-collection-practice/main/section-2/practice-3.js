'use strict';

module.exports = function countSameElements(collection) {
    let result = [];
    for (let i =0 ; i < collection.length; i++) {
        let obj = findOne(collection[i], result);
        if (obj) {
            obj.summary++;
        } else if (isSymbol(collection[i])) {
            let symbolStr = isSymbol(collection[i]);
            let obj = findOne(symbolStr.name, result);
            if (obj) {
                obj.summary += symbolStr.summary;
            } else {
                result.push({name: symbolStr.name, summary: symbolStr.summary});
            }
        }
        else {
            result.push({name: collection[i], summary: 1});
        }
    }
    return result;
};

function findOne(element, collection) {
    for(let j =0; j< collection.length; j++){
        if(element === collection[j].name){
            return collection[j];
        }
    }
}
function isSymbol(element){
    let result = {};
    if(element.includes('-')){
        result.name = element.split('-')[0];
        result.summary = parseInt(element.split('-')[1]);
    } else if(element.includes(':')){
        result.name = element.split(':')[0];
        result.summary = parseInt(element.split(':')[1]);
    } else if(element.includes('[')){
        result.name = element.split('[')[0];
        result.summary = parseInt(element.split('[')[1].split(']')[0]);
    } else {
        return null;
    }
    return result;
}