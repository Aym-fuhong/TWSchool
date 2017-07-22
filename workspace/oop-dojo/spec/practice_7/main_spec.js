"use strict";
const {Person, Student, Worker, Teacher} = require('../../main/practice_7');

describe("O7入门", function () {
    it("覆盖同时复用父类的方法", function () {
        const student = new Student('Tom', 21, 2);
        const result1 = `My name is Tom. I am 21 years old. I am a Student. I am at Class 2.`;

        const teacher1 = new Teacher('Tom', 21, 2);
        const result2 = `My name is Tom. I am 21 years old. I am a Teacher. I teach Class 2.`;

        const teacher2 = new Teacher('Tom', 21);
        const result3 = `My name is Tom. I am 21 years old. I am a Teacher. I am No class.`;

        expect(student.introduce()).toEqual(result1);
        expect(teacher1.introduce()).toEqual(result2);
        expect(teacher2.introduce()).toEqual(result3);
    });
});