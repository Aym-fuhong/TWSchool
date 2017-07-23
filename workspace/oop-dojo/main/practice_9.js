class Person {
    constructor(id, name, age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    introduce() {
        return `My name is ${this.name}. I am ${this.age} years old.`;
    }
}

class Student extends Person {
    constructor(id, name, age, class1) {
        super(id, name, age);
        this.class1 = class1;
    }

    introduce() {
        if(this.class1.leader){
            return `${super.introduce()} I am a Student. I am ${this.class1.leader} of Class ${this.class1.number}.`;
        } else {
            return `${super.introduce()} I am a Student. I am at Class ${this.class1.number}.`;
        }
    }
}

class Class {
    constructor(number) {
        this.number = number;
    }
    assignLeader(student) {
      this.leader = 'Leader';
    }
}


class Teacher extends Person {
    constructor(id, name, age, class2) {
        super(id, name, age);
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

module.exports = {Student, Teacher, Class};