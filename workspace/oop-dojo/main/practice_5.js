class Person {
    constructor(name, age) {
        this.name = name;
        this.age = age;
    }

    introduce() {
        return this.basic_introduce();
    }
    basic_introduce() {
        return `My name is ${this.name}. I am ${this.age} years old.`;
    }
}

class Worker extends Person{
    constructor(name, age){
        super(name, age);
    }
    introduce(){
        return `${this.basic_introduce()} I am a Worker. I have a job.`;
    }
}
class Student extends Person {
    constructor(name, age, class1) {
        super(name, age);
        this.class1 = class1;
    }
    introduce() {
        return `${this.basic_introduce()} I am a Student. I am at Class ${this.class1}.`;
    }
}

module.exports = {Person, Student, Worker};