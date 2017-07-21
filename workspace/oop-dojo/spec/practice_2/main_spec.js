"use strict";
const Person = require('../../main/practice_2');
describe("O2入门", function(){
    it("写一个类-2", function(){
        const person = new Person('Tom', 21);
        let result = 'My name is Tom. I am 21 years old. ';
        expect(person.introduce()).toEqual(result);
    });
});