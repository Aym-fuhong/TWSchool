package managerScore.models;


import javax.persistence.*;


public class ReportItem {

    private String id;
    private Student student;
    private int averageScore;
    private int totalScore;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
