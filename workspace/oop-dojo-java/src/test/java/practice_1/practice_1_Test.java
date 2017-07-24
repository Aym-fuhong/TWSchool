package practice_1;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class practice_1_Test {

    @Test
    public void introduceTest() {
        Person tom = new Person("Tom", 21);
        assertThat(tom.introduce(), is("My name is Tom. I am 21 years old."));
    }

    @Test
    public void introduceUpdateNameTest() {
        Person tom = new Person("Tom", 21);
        tom.setName("Tom Wu");
        assertThat(tom.introduce(), is("My name is Tom Wu. I am 21 years old."));
    }

    @Test
    public void ToStringTest() {
        Person tom = new Person("Tom", 21);
        tom.setName("Tom Wu");
        assertThat(tom.toString(), is("My name is Tom Wu. I am 21 years old."));
    }
}
