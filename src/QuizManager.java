import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizManager {
    private final Scanner scanner = new Scanner(System.in);
    private List<Quiz> quizHistory;

    public QuizManager() {
        this.quizHistory = new ArrayList<>();
    }

    public void quizStarter() {
            System.out.println("Choose a quiz topic:");
            System.out.println("1. Physics");
            System.out.println("2. Geography");
            System.out.println("3. Math");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    difficulty("physics");
                    break;
                case "2":
                    difficulty("geography");
                    break;
                case "3":
                    difficulty("math");
                    break;
                default:
                    System.out.println("Invalid input");

            }
    }

    public void difficulty(String topic) {
        System.out.println("Choose difficulty level:");
        System.out.println("1. Easy");
        System.out.println("2. Medium");
        System.out.println("3. Hard");
        String choice1 = scanner.nextLine();
        switch (choice1) {
            case "1":
                startQuiz(topic, "easy");
                break;
            case "2":
                startQuiz(topic, "medium");
                break;
            case "3":
                startQuiz(topic, "hard");
                break;
            default:
                System.out.println("Invalid input");
        }
    }

    private void startQuiz(String topic, String difficulty) {

        int score = 0;
        String filePath = "C:\\Users\\ZenBook\\IdeaProjects\\online-quiz-application\\src\\" + topic.toLowerCase() + "_" + difficulty.toLowerCase() + "_questions.txt";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] options = line.split(",");
                String question = options[0];
                System.out.println(question);
                for (int i = 1; i < options.length - 1; i++) {
                    System.out.println(i + ". " + options[i]);
                }
                System.out.print("Your answer: ");
                int userAnswer = scanner.nextInt();
                if (userAnswer == Integer.parseInt(options[options.length - 1])) {
                    System.out.println("Correct! ");
                    score++;
                } else {
                    System.out.println("Incorrect. The correct answer is: " + options[options.length - 1]);
                }
            }
        }
         catch (IOException e) {
            e.printStackTrace();
        }
        quizHistory(topic,difficulty,score);
        System.out.println("Quiz completed. Your score: " + score +" \uD83D\uDE0E");
    }
    public void quizHistory(String topic, String difficulty, int score){
        Quiz quiz = new Quiz(topic, difficulty, score);
        quizHistory.add(quiz);
    }
    public List<Quiz> getQuizHistory() {
        return quizHistory;
    }
}



