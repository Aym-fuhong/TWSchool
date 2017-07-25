package practice_10;

/**
 * Created by Hong on 24/07/2017.
 */
public class Class {
    private int number;
    private Student leader;

    public Student getLeader() {
        return leader;
    }

    public void setLeader(Student leader) {
        this.leader = leader;
    }


    public int getNumber() {
        return number;
    }

    public Class(int number) {
        this.number = number;
    }

    public String assignLeader(Student student) {
        String result = "";
        if (student.getklass().getNumber() == this.getNumber()) {
            if (this.getLeader() == null) {
                this.setLeader(student);
            }
        } else {
            result = "It is not one of us.";
        }
        return result;
    }

    public void appendMember(Student student) {
        if (student.getklass().getNumber() != this.getNumber()) {
            student.setKlass(this);
        }
    }
}
