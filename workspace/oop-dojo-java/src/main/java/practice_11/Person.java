package practice_11;

public class Person {
    private int id;
    private int age;
    private String name;

    public Person(int id, String name, int age) {
        this.id =id;
        this.name = name;
        this.age = age;
    }

    public String introduce() {
        String result = "My name is " + this.name + ". I am " + this.age + " years old.";
        return result;
    }
}
