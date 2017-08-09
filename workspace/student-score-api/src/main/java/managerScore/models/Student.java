package managerScore.models;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String phone;
    private String email;
    private String native_place;
    private String id_Card;

    public Student() {
    }

    public Student(String name, String phone, String email, String native_place,
                   String ID_Card) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.native_place = native_place;
        this.id_Card = ID_Card;
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


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }
}
