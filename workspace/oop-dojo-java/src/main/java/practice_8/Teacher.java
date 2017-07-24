package practice_8;

public class Teacher extends Person {
    private int klass;

    public int getKlass() {
        return klass;
    }

    public Teacher(String name, int age, int klass) {
        super(name, age);
        this.klass = klass;
    }

    public Teacher(String name, int age) {
        super(name, age);
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

    public String introduceWith(Student student) {
        String result = super.introduce();
        if (student.getklass().getNumber() == this.getKlass()) {
            System.out.println("======00=====");
            System.out.println(student.getName() );
            result += " I am a Teacher. I teach " + student.getName() + ".";
            System.out.println(result);
        } else {
            result += " I am a Teacher. I don't teach " + student.getName() + ".";
        }
        return result;
    }
}
