package practice_8;

/**
 * Created by Hong on 24/07/2017.
 */
public class Student extends Person {
    private Class klass = null;
    private String name;
    private int age;

    public Class getKlass() {
        return klass;
    }
    public String getName() {
        return name;
    }

    public Student(String name, int age, Class klass) {
        super(name, age);
        this.klass = klass;
    }

    public String introduce() {
        String result = super.introduce() + " I am a Student. I am at Class " + this.klass.getNumber() + ".";
        return  result;
    }

    public Class getklass() {
        return klass;
    }

}
