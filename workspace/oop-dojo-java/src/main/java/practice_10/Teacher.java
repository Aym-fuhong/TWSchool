package practice_10;

public class Teacher extends Person {
    private int klass;
    private int id;

    public int getKlass() {
        return klass;
    }

    public Teacher(int id, String name, int age, int klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public String introduce() {
        String result = super.introduce();
        if (this.getKlass() == 0) {
            result += " I am a Teacher. I teach No Class.";
        } else {
            result += " I am a Teacher. I teach Class " + this.getKlass() + ".";
        }
        return result;
    }
}
