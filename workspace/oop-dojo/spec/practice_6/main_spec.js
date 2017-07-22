"use strict";
const {Person, Student, Worker} = require('../../main/practice_6');

describe("OO入门", function(){
    it("覆盖同时复用父类的方法", function(){
        const person = new Person('Tom', 21);
        const result1 = `My name is Tom. I am 21 years old.`;

        const worker = new Worker('Tom', 21);
        const result3 = `My name is Tom. I am 21 years old. I am a Worker. I have a job.`;

        const student = new Student('Tom', 21, 2);
        const result2 = `My name is Tom. I am 21 years old. I am a Student. I am at Class 2.`;

        expect(student.introduce()).toEqual(result2);
        expect(worker.introduce()).toEqual(result3);
        expect(person.introduce()).toEqual(result1);
    });
});