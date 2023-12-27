import java.util.Scanner;

public class UserInputHandler {

    private Scanner scanner;

    public UserInputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public Object getUserInput(String message, Class<?> type) {
        System.out.print(message);
        String input = scanner.nextLine();

        try {
            if (type == Integer.class) {
                return Integer.parseInt(input);
            } else if (type == Double.class) {
                return Double.parseDouble(input);
            } else if (type == String.class) {
                return input;
            } else {
                throw new IllegalArgumentException("Unsupported data type");
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода: ожидалось число.");
            return null;
        }
    }
}
