package ms;

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
}
