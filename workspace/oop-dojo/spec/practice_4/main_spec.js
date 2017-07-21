"use strict";
const Worker = require('../../main/practice_4');
describe("OO入门", function(){
    it("覆盖父类的方法-2", function(){
     const worker = new Worker();
     let workResult = 'I am a Worker. I have a job.';
     expect(worker.introduce()).toEqual(workResult);
    });
});