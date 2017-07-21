class Person {
    constructor(name, age) {
        this.name = name;
        this.age = age;
    }

    introduce() {
        return `My name is ${this.name}. I am ${this.age} years old. `;
    }
}

class Student extends Person {
    constructor(name, age, class1) {
        super(name, age);
        this.class1 = class1;
    }

    intruduce() {
        return `I am a Student. I am at Class ${this.class1}.`;
    }
}

module.exports = Student;