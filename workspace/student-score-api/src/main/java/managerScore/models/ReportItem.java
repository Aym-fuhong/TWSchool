package managerScore.models;


public class ReportItem {
    private Student student;
    private int averageScore;
    private int totalScore;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(int averageScore) {
        this.averageScore = averageScore;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public ReportItem() {
    }

    public ReportItem(Student student, int averageScore, int totalScore) {
        this.student = student;
        this.averageScore = averageScore;
        this.totalScore = totalScore;
    }
}
