package practice_3;

/**
 * Created by Hong on 24/07/2017.
 */
public class Person {

    private int age;
    private String name;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String introduce() {
        String result = "My name is " + this.name + ". I am " + this.age + " years old.";
        return result;
    }
}
