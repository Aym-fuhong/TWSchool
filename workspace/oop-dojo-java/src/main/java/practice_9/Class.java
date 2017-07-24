package practice_9;

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

    public void assignLeader(Student student) {
        if (this.getLeader() == null) {
            this.setLeader(student);
        }
    }
}
