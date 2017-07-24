package practice_3;

/**
 * Created by Hong on 24/07/2017.
 */
public class Student extends Person{
    private int klass;

    public Student(String name, int age, int klass) {
        super(name, age);
        this.klass = klass;
    }

    public String introduce() {
        String result = super.introduce() + " I am a Student. I am at Class " + this.klass + ".";
        return  result;
    }
}
