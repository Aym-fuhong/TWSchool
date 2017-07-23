"use strict";
const {Student, Teacher, Class} = require('../../main/practice_12');

describe("12入门", function () {
    it("对象之间的交互-6", function () {
        const obj1 = new Class(2);
        const student1 = new Student(1, 'Tom', 21, obj1);
        obj1.appendMember(student1);
        obj1.assignLeader(student1);
        const result1 = `My name is Tom. I am 21 years old. I am a Student. I am Leader of Class 2.`;

        const obj5 = new Class(5);
        const student2 = new Student(2, 'Tom', 21, obj5);
        obj1.appendMember(student2);
        const result2 = `My name is Tom. I am 21 years old. I am a Student. I am at Class 2.`;

        const teacher1 = new Teacher(3, 'Tom', 21, [2, 3]);
        const result3 = `My name is Tom. I am 21 years old. I am a Teacher. I teach Class 2, 3.`;

        const teacher2 = new Teacher(4, 'Tom', 21);
        const result4 = `My name is Tom. I am 21 years old. I am a Teacher. I am No class.`;

        const obj3 = new Class(3);
        const student3 = new Student(5, 'Tom', 21, obj5);
        const result5 = `It is not one of us.`;

        expect(student1.introduce()).toEqual(result1);
        expect(student2.introduce()).toEqual(result2);
        expect(teacher1.introduce()).toEqual(result3);
        expect(teacher2.introduce()).toEqual(result4);
        expect(obj3.assignLeader(student3)).toEqual(result5);
    });

    it('测试学生是否存在于某个老师所交的班级', () => {
        const teacher = new Teacher(1, 'Tom', 21, [2, 3]);

        const class2 = new Class(2);
        const student2 = new Student(2, 'aym', 5, class2);
        const result2 = true;

        const class1 = new Class(1);
        const student1 = new Student(3, 'Jerry', 3, class1);
        const result1 = false;

        expect(teacher.isTeaching(student1)).toEqual(result1);
        expect(teacher.isTeaching(student2)).toEqual(result2);
    });

    it('测试学生加入某个老师的班级后是普通学生', () => {
        const class1 = new Class(2);
        const teacher = new Teacher(1, 'Tom', 21, [2, 3]);

        const class4 = new Class(4);
        const student1 = new Student(2, 'Jerry', 4, class4);
        class1.appendMember(student1);
        const result1 = `I am Tom. I know Jerry has joined Class 2.`;
        expect(teacher.introduceWith(student1)).toEqual(result1);

        const student2 = new Student(2, 'Jerry', 4, class1);
        class1.appendMember(student2);
        class1.assignLeader(student2);
        const result2 = `I am Tom. I know Jerry become Leader of Class 2.`;

        expect(teacher.introduceWith(student2)).toEqual(result2);

    });

});