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
            return `${super.introduce()} I am a Student. I am Leader of Class ${this.class1.number}.`;
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
        if(student.class1.number === this.number){
            this.leader = student.id;
        } else {
            return `It is not one of us.`;
        }
    }

    appendMember(student) {
        student.class1 = this;
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
            return `${super.introduce()} I am a Teacher. I teach ${student.name}.`;

        } else {
            return `${super.introduce()} I am a Teacher. I don't teach ${student.name}.`;
        }
    }
}

module.exports = {Student, Teacher, Class};