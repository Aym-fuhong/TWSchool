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
        if (this.class1.leader) {
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
        if (student.class1.number === this.number) {
            this.leader = 'Leader';
        } else {
            return `It is not one of us.`;
        }
    }

    appendMember(student) {
        student.class1.number = this.number;
    }

    isIn(student) {
        let isExist = false;
        const element = this.number.find(item => student.class1.number === item);
        if (element) {
            isExist = true;
        }
        return isExist;
    }
}


class Teacher extends Person {
    constructor(id, name, age, classes) {
        super(id, name, age);
        this.classes = classes;
    }

    introduce() {
        if (this.classes) {
            return `${super.introduce()} I am a Teacher. I teach Class ${this.classes[0]}, ${this.classes[1]}.`
        } else {
            return `${super.introduce()} I am a Teacher. I am No class.`
        }
    }

    isTeaching(student) {
        let isTeaching = false;
        const classes = new Class(this.classes);
        if (classes.isIn(student)) {
            isTeaching = true;
        }
        return isTeaching;
    }

    introduceWith(student) {
        const classes = new Class(this.classes);
        if (classes.isIn(student)) {
            if (student.class1.leader) {
                return `I am ${this.name}. I know ${student.name} become Leader of Class ${student.class1.number}.`;
            } else {
                return `I am ${this.name}. I know ${student.name} has joined Class ${student.class1.number}.`;
            }

        } else {
            return `${super.introduce()} I am a Teacher. I don't teach ${student.name}.`;
        }
    }
}

module.exports = {Student, Teacher, Class};