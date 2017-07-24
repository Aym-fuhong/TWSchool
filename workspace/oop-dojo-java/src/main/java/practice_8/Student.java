package practice_8;

public class Student extends Person {
    private String name;
    private int age;
    private Class klass;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class getklass() {
        return klass;
    }

    public Student(String name, int age, Class klass) {
        super(name, age);
        this.klass = klass;
    }

    public String introduce() {
        String result = super.introduce() + " I am a Student. I am at Class " + this.klass.getNumber() + ".";
        return result;
    }


}
