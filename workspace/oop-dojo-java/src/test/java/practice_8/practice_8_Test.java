package practice_8;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Hong on 24/07/2017.
 */
public class practice_8_Test {
    @Test
    public void introduceTest() {
        Person tom = new Person("Tom", 21);
        assertThat(tom.introduce(), is("My name is Tom. I am 21 years old."));
    }

    @Test
    public void studentIntroduceTest() {
        Class class1 = new Class(2);
        Student tom = new Student("Tom", 21, class1);
        assertThat(tom.introduce(), is("My name is Tom. I am 21 years old. I am a Student. I am at Class 2."));
    }

    @Test
    public void teacherIntroduceTest() {
        Teacher tom = new Teacher("Tom", 21, 2);
        assertThat(tom.introduce(), is("My name is Tom. I am 21 years old. I am a Teacher. I teach Class 2."));
    }

    @Test

    public void teacherIntroduce2Test() {
        Teacher tom = new Teacher("Tom", 21);
        assertThat(tom.introduce(), is("My name is Tom. I am 21 years old. I am a Teacher. I teach No Class."));
    }

    @Test
    public void introduceWithTest() {
        Class class1 = new Class(2);
        Teacher tom = new Teacher("Tom", 21, 2);
        Student student = new Student("Jerry", 1, class1);
        assertThat(tom.introduceWith(student),
                is("My name is Tom. I am 21 years old. I am a Teacher. I teach Jerry."));
    }

    @Test
    public void introduceWith2Test() {
        Teacher tom = new Teacher("Tom", 21, 2);
        Class class2 = new Class(3);
        Student student = new Student("Jerry", 1, class2);
        assertThat(tom.introduceWith(student),
                is("My name is Tom. I am 21 years old. I am a Teacher. I don't teach Jerry."));

    }
}
