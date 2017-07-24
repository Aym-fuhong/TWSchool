package practice_1;

/**
 * Created by Hong on 24/07/2017.
 */
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String introduce() {
        String result = "My name is " + this.name + ". I am " + this.age + " years old.";
        return result;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.introduce();
    }
}
