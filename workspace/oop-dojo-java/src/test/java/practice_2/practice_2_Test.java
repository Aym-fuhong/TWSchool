package practice_2;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Hong on 24/07/2017.
 */
public class practice_2_Test {
    @Test
    public void introduceTest() {
        Person tom = new Person("Tom", 21);
        assertThat(tom.introduce(), is("My name is Tom. I am 21 years old."));
    }

    @Test

    public void studentIntroduceTest() {
        Student tom = new Student("Tom", 21, 2);
        assertThat(tom.introduce(), is("My name is Tom. I am 21 years old. I am a Student. I am at Class 2."));
    }
}
