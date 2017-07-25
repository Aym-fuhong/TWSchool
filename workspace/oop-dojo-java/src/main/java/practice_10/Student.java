package practice_10;

/**
 * Created by Hong on 24/07/2017.
 */
public class Student extends Person {
    private int id;
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

    public void setKlass(Class klass) {
        this.klass = klass;
    }

    public Student(int id, String name, int age, Class klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public String introduce() {
        String result = super.introduce();
        if(this.equals(this.getklass().getLeader())) {
            result += " I am a Student. I am Leader of Class " + this.getklass().getNumber()+ ".";
        } else {
            result += " I am a Student. I am at Class " + this.klass.getNumber() + ".";
        }
        return result;
    }


}
