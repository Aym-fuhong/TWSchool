package managerScore.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Student {
    private String id;
    private String name;
    private String phone;
    private String email;
    private String native_place;
    private String id_Card;
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
        this.id_Card = ID_Card;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNative_place() {
        return native_place;
    }

    public void setNative_place(String native_place) {
        this.native_place = native_place;
    }

    public String getID_Card() {
        return id_Card;
    }

    public void setID_Card(String ID_Card) {
        this.id_Card = ID_Card;
    }

    public void setMath(String math) {
        this.math = math;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public void setProgram(String program) {
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
