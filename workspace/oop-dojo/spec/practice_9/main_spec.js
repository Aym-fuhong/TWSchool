"use strict";
const {Student, Teacher, Class} = require('../../main/practice_9');

describe("O9入门", function () {
    it("对象之间的交互-3", function () {
        const obj1 = new Class(2);
        const student1 = new Student(1, 'Tom', 21, obj1);
        const result1 = `My name is Tom. I am 21 years old. I am a Student. I am at Class 2.`;
        expect(student1.introduce()).toEqual(result1);

        obj1.assignLeader(student1);
        const result2 = `My name is Tom. I am 21 years old. I am a Student. I am Leader of Class 2.`;
        expect(student1.introduce()).toEqual(result2);

        const teacher1 = new Teacher(3, 'Tom', 21, 2);
        const result3 = `My name is Tom. I am 21 years old. I am a Teacher. I teach Class 2.`;

        const teacher2 = new Teacher(4, 'Tom', 21);
        const result4 = `My name is Tom. I am 21 years old. I am a Teacher. I am No class.`;

        expect(teacher1.introduce()).toEqual(result3);
        expect(teacher2.introduce()).toEqual(result4);
    });
});