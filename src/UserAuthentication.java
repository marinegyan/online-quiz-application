import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserAuthentication {
    private Map<String, String> userRegister;
    private final Scanner scanner = new Scanner(System.in);
    private final QuizManager quizManager = new QuizManager();

    public UserAuthentication() {
        this.userRegister = new HashMap<>();
    }

    public void registration() {
        System.out.println("Please enter your unique username \uD83D\uDC4D");
        String username = scanner.nextLine();
        if (userRegister.containsKey(username)) {
            System.out.println("Username is already taken. Please choose another one. \uD83D\uDC4D");
            startText();
            return;
        }
        System.out.println("Please enter your password ");
        String password = scanner.nextLine();
        userRegister.put(username, password);
        System.out.println("Hello " + username + ", you have been registered successfully " + "\uD83D\uDC4D");
    }

    public void login() {
        System.out.println("Please enter your unique username");
        String username = scanner.nextLine();
        if (userRegister.containsKey(username)) {
            System.out.println("\uD83D\uDC4D");
        } else {
            System.out.println("\uD83D\uDC4E");
            System.out.println("Start again");
            startText();
            return;
        }
        System.out.println("Please enter your password");
        String password = scanner.nextLine();
        if (userRegister.containsValue(password)) {
            System.out.println("\uD83D\uDC4D");
        } else {
            System.out.println("\uD83D\uDC4E");
            System.out.println("Start again");
        }
    }

    public void start() {
        startText();
        while (true) {
            System.out.println("Please choose an option:");
            System.out.println("1. Start a quiz");
            System.out.println("2. Show your quiz history");
            System.out.println("3. Log out from your account");
            int input = scanner.nextInt();
            scanner.nextLine();
            switch (input) {
                case 1:
                    quizManager.quizStarter();
                    break;
                case 2:
                    quizHistory();
                    break;
                case 3:
                    startText();
                    break;
                default:
                    System.out.println("Invalid input");
                    startText();
            }
        }
    }

    public void startText() {
        System.out.println("Welcome:");
        System.out.println("To continue, please log in to your account or register for a new one.");
        System.out.println("For login, enter 1");
        System.out.println("For registration, enter 2");
        int option = scanner.nextInt();
        scanner.nextLine();
        if (option == 1) {
            login();
        } else if (option == 2) {
            registration();
        } else {
            System.out.println("Invalid input");
            startText();
        }
    }
    public void quizHistory() {
        System.out.println("Quiz History:");

        if (quizManager.getQuizHistory().isEmpty()) {
            System.out.println("No quiz history available.");
        } else {
            for (Quiz quiz : quizManager.getQuizHistory()) {
                System.out.println("Topic: " + quiz.getTopic());
                System.out.println("Difficulty: " + quiz.getDifficulty());
                System.out.println("Score: " + quiz.getScore());
                System.out.println("--------------------------");
            }
        }
    }
}




