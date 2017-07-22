"use strict";
const {Person, Student, Worker, Teacher, Obj} = require('../../main/practice_8');

describe("O8入门", function () {
    it("覆盖同时复用父类的方法", function () {
        const obj = new Obj(2);
        const student = new Student('Tom', 21, obj);
        const result1 = `My name is Tom. I am 21 years old. I am a Student. I am at Class 2.`;

        const teacher1 = new Teacher('Tom', 21, 2);
        const result2 = `My name is Tom. I am 21 years old. I am a Teacher. I teach Class 2.`;

        const teacher2 = new Teacher('Tom', 21);
        const result3 = `My name is Tom. I am 21 years old. I am a Teacher. I am No class.`;

        expect(student.introduce()).toEqual(result1);
        expect(teacher1.introduce()).toEqual(result2);
        expect(teacher2.introduce()).toEqual(result3);
    });

    it('通过类获取class信息', function () {
        const obj = new Obj(2);
        const student = new Student('Jerry', 21, obj);

        const teacher1 = new Teacher('Tom', 21, 2);

        const teacher2 = new Teacher('Tom', 21);

        const result4 = `My name is Tom. I am 21 years old. I am a Teacher. I teach Jerry.`;
        const result5 = `My name is Tom. I am 21 years old. I am a Teacher. I don't teach Jerry.`;

        expect(teacher1.introduceWith(student)).toEqual(result4);
        expect(teacher2.introduceWith(student)).toEqual(result5);
    });
});