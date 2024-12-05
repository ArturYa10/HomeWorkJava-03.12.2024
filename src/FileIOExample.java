import java.io.*;

public class FileIOExample {
    public static void main(String[] args) {
        String text = "This is my first experience when I work with IO API. I can do everything!";
        String filePath = "example.txt";

        // Запись текста в файл
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Чтение текста из файла
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
