import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PrizeToyLogger {

    public static void logPrizeToy(Toy prizeToy) {
        String fileName = "prizeToys.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write("Prize Toy ID: " + prizeToy.getId() + ", Name: " + prizeToy.getName() + "\n");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
