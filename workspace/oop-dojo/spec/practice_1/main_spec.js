"use strict";
let Person = require('../../main/practice_1');
describe("O1入门", function(){
    it("写一个类-1", function(){
        const person = new Person('Tom', 21);
        let result = 'My name is Tom. I am 21 years old. ';
        expect(person.introduce()).toEqual(result);
    });
});