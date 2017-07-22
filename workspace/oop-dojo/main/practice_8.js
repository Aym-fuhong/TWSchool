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
        return `${super.introduce()} I am a Student. I am at Class ${this.class1.number}.`;
    }
}

class Teacher extends Person {
    constructor(name, age, class2) {
        console.log('234567');
        super(name, age);
        this.class2 = class2;
    }

    introduce() {
        if (this.class2) {
            return `${super.introduce()} I am a Teacher. I teach Class ${this.class2}.`
        } else {
            return `${super.introduce()} I am a Teacher. I am No class.`
        }
    }

    introduceWith(student) {
        if (student.class1.number === this.class2) {
            return `My name is Tom. I am 21 years old. I am a Teacher. I teach Jerry.`;

        } else {
            return `My name is Tom. I am 21 years old. I am a Teacher. I don't teach Jerry.`;
        }
    }
}

class Worker extends Person {
    constructor(name, age) {
        super(name, age);
    }

    introduce() {
        return `${this.introduce()} I am a Worker. I have a job.`
    }
}

class Obj {
    constructor(number) {
        this.number = number;
    }
}

module.exports = {Person, Student, Worker, Teacher, Obj};