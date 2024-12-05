import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class ExceptionLogger {
    public static void main(String[] args) {
        try {
            simulateException();
        } catch (Exception e) {
            logException(e);
        }

        try {
            anotherException();
        } catch (Exception e) {
            logException(e);
        }
    }

    public static void simulateException() throws Exception {
//        System.out.println("simulateException called");
        throw new Exception("Simulated exception occurred");

    }

    public static void anotherException() throws Exception {
//        System.out.println("anotherException called");
        throw new IllegalArgumentException("Another simulated exception");

    }

    public static void logException(Exception e) {
        String logFilePath = "C:\\Users\\Tel-ran.de\\IdeaProjects\\HomeWorkJava-03.12.2024\\resourses\\errors.log";
        try (PrintWriter writer = new PrintWriter(new FileWriter(logFilePath, true))) {
            writer.println("Exception occurred at: " + LocalDateTime.now());
            writer.println("Exception message: " + e.getMessage());
            writer.println("Stack trace:");
            e.printStackTrace(writer);
            writer.println("--------------------------------------------------");
            System.out.println("Exception logged to file: " + logFilePath);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
