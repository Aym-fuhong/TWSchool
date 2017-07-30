package practice_11;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class practice_11_Test {
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
        ArrayList<Class> list = new ArrayList<>();
        list.add(new Class(2));
        Teacher tom = new Teacher(3, "Tom", 21, list);
        assertThat(tom.introduce(), is("My name is Tom. I am 21 years old. I am a Teacher. I teach Class 2."));
    }

    @Test
    public void teacherIntroduce2Test() {
        Teacher tom = new Teacher(3,"Tom", 21);
        assertThat(tom.introduce(), is("My name is Tom. I am 21 years old. I am a Teacher. I teach No Class."));
    }

    @Test
    public void studentIntroduce3Test() {
        Class class1 = new Class(2);
        Student tom = new Student(3,"Tom", 21, class1);
        class1.assignLeader(tom);
        assertThat(tom.introduce(), is("My name is Tom. I am 21 years old. I am a Student. I am Leader of Class 2."));
    }
    @Test
    public void studentIntroduce4Test() {
        Class class1 = new Class(2);
        Class class2 = new Class(1);
        Student tom = new Student(3,"Tom", 21, class2);
        assertThat(class1.assignLeader(tom), is("It is not one of us."));
    }

}
