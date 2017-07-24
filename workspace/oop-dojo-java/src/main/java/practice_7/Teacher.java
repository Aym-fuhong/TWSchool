package practice_7;

/**
 * Created by Hong on 24/07/2017.
 */
public class Teacher extends Person{
    private int klass;

    public Teacher(String name, int age, int klass) {
        super(name, age);
        this.klass = klass;
    }

    public Teacher(String name, int age) {
        super(name, age);
    }

    public String introduce() {
        String result = super.introduce();
        if(this.klass == 0) {
            result += " I am a Teacher. I teach No Class.";
        } else {
            result +=  " I am a Teacher. I teach Class " + this.klass + ".";
        }

        return result;
    }
}
