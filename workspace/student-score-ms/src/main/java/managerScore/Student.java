package managerScore;

public class Student {
    private String name;
    private String id;
    private String math;
    private String language;
    private String english;
    private String program;

    public Student(String name, String id, String math, String language, String english, String program) {
        this.name = name;
        this.id = id;
        this.math = math;
        this.language = language;
        this.english = english;
        this.program = program;
    }

    public Student(String name) {
        this.name = name;
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
}
