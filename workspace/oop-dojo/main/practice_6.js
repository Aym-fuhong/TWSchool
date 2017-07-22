class Person {
    constructor(name, age) {
        this.name = name;
        this.age = age;
    }
    introduce() {
        return `My name is ${this.name}. I am ${this.age} years old.`;
    }
}

class Student extends Person {
    constructor(name, age, class1) {
        super(name, age);
        this.class1 = class1;
    }
    introduce() {
        return `${super.introduce()} I am a Student. I am at Class ${this.class1}.`;

    }
}

class Worker extends Person {
    constructor(name, age) {
        super(name, age);
    }
    introduce() {
        return `${super.introduce()} I am a Worker. I have a job.`

    }
}

module.exports = {Person, Student, Worker};