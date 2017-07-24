package practice_6;

/**
 * Created by Hong on 24/07/2017.
 */
public class Worker extends Person {
    public Worker(String name, int age) {
        super(name, age);
    }

    public String introduce(){
        String result = super.introduce() + " I am a Worker. I have a job.";
        return result;
    }
}
