package managerScore;

import managerScore.controller.ManagerScore;

import java.util.Scanner;

public class App {
    private ManagerScore managerScore = new ManagerScore();

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Constant.menuString);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            String result = managerScore.print_student_score_ms(input);
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        new App().run();
    }
}
