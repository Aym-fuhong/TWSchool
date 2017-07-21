"use strict";
const {Person, Student, Worker} = require('../../main/practice_5');
describe("O5门", function(){
    it("覆盖同时复用父类的方法", function(){
        const person = new Person('Tom', 21);
        console.log(person.basic_introduce(),'123456789--------');

        const result1 = `My name is Tom. I am 21 years old.`;
        expect(person.introduce()).toEqual(result1);
    });

    it("覆盖同时复用父类的方法", function(){
        const student = new Student('Tom', 21, 2);
        console.log(student.basic_introduce(),'55555555--------');
        const result2 = `My name is Tom. I am 21 years old. I am a Student. I am at Class 2.`;
        expect(student.introduce()).toEqual(result2);
    });
    it("覆盖同时复用父类的方法", function(){
        const worker = new Worker('Tom', 21);
        const result3 = `My name is Tom. I am 21 years old. I am a Worker. I have a job.`;
        expect(worker.introduce()).toEqual(result3);
    });
});