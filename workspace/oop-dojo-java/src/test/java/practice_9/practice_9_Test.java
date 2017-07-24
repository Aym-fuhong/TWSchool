package practice_9;

import org.junit.Test;
import practice_9.Class;
import practice_9.Person;
import practice_9.Student;
import practice_9.Teacher;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class practice_9_Test {
    @Test
    public void introduceTest() {
        Person tom = new Person(1, "Tom", 21);
        assertThat(tom.introduce(), is("My name is Tom. I am 21 years old."));
    }

    @Test
    public void studentIntroduceTest() {
        Class class1 = new Class(2);
        Student tom = new Student(2, "Tom", 21, class1);
        assertThat(tom.introduce(), is("My name is Tom. I am 21 years old. I am a Student. I am at Class 2."));
    }

    @Test
    public void studentIntroduce2Test() {
        Class class1 = new Class(2);
        Student tom = new Student(2, "Tom", 21, class1);
        class1.assignLeader(tom);
        assertThat(tom.introduce(), is("My name is Tom. I am 21 years old. I am a Student. I am Leader of Class 2."));
    }

    @Test
    public void teacherIntroduceTest() {
        Teacher tom = new Teacher(3, "Tom", 21, 2);
        assertThat(tom.introduce(), is("My name is Tom. I am 21 years old. I am a Teacher. I teach Class 2."));
    }

    @Test

    public void teacherIntroduce2Test() {
        Teacher tom = new Teacher(3,"Tom", 21);
        assertThat(tom.introduce(), is("My name is Tom. I am 21 years old. I am a Teacher. I teach No Class."));
    }

}
