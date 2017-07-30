package practice_11;

import java.util.ArrayList;

public class Teacher extends Person {
    private ArrayList klasses = new ArrayList();
    private int id;

    public ArrayList getKlasses() {
        return klasses;
    }

    public Teacher(int id, String name, int age, ArrayList klasses) {
        super(id, name, age);
        this.klasses = klasses;
    }

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public String introduce() {
        String result = super.introduce();
        ArrayList<Class> classList = this.getKlasses();
        if (0 == classList.size()) {
            result += " I am a Teacher. I teach No Class.";
        } else {
            result += " I am a Teacher. I teach Class ";
            for (int i = 0; i < classList.size(); i++) {
                if (i == classList.size() - 1) {
                    result += classList.get(i).getNumber() + ".";
                } else {
                    result += classList.get(i).getNumber() + ",";
                }
            }
        }
        return result;
    }
}
