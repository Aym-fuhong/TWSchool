package managerScore.models;

public class Student {
    private String id;
    private String name;
    private String phone;
    private String email;
    private String native_place;
    private String ID_Card;
    private String math;
    private String language;
    private String english;
    private String program;

    public Student() {
    }

    public Student(String name, String phone, String email, String native_place,
                   String ID_Card, String math, String language, String english, String program) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.native_place = native_place;
        this.ID_Card = ID_Card;
        this.math = math;
        this.language = language;
        this.english = english;
        this.program = program;
    }

    public Student(String name, String math, String language, String english, String program) {
        this.name = name;
        this.math = math;
        this.language = language;
        this.english = english;
        this.program = program;
    }

    public Student(String id, String name, String math, String language, String english, String program) {
        this.name = name;
        this.id = id;
        this.math = math;
        this.language = language;
        this.english = english;
        this.program = program;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMath() {
        return math;
    }

    public String getLanguage() {
        return language;
    }

    public String getEnglish() {
        return english;
    }

    public String getProgram() {
        return program;
    }

    public void setId(String id) {
        this.id = id;
    }
}
