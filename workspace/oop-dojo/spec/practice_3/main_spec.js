"use strict";
const Student = require('../../main/practice_3');
describe("OO入门", function(){
    it("覆盖父类的方法-1", function(){
    const student = new Student('Tom', 21, 2);
    const result = `I am a Student. I am at Class 2.`;
    expect(student.introduce()).toEqual(result);
    });
});