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
            return `${super.introduce()} I am a Teacher. I teach ${student.name}.`;

        } else {
            return `${super.introduce()} I am a Teacher. I don't teach ${student.name}.`;
        }
    }
}


class Class {
    constructor(number) {
        this.number = number;
    }
}

module.exports = {Person, Student, Teacher, Class};