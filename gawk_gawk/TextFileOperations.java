import java.io.*;
import java.util.*;

public class TextFileOperations {
    public static void main(String[] args) {
        String filename = "my_text_file.txt";
        
        writeDataToFile(filename, List.of("This is the first line.",
                "This is the second line.",
                "And this is the third line."));
        
        List<String> lines = readDataFromFile(filename);
        if (lines != null) {
            System.out.println("\nContents of the file:");
            for (String line : lines) {
                System.out.println(line);
            }
        }

        appendDataToFile(filename, List.of("This line is appended.",
                "Another appended line."));

        List<String> updatedLines = readDataFromFile(filename);
        if (updatedLines != null) {
            System.out.println("\nContents of the file after appending:");
            for (String line : updatedLines) {
                System.out.println(line);
            }
        }
        System.out.println("File path: " + new File(filename).getAbsolutePath());
    }

    public static void writeDataToFile(String filename, List<String> data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String line : data) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Data successfully written to: " + filename);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public static List<String> readDataFromFile(String filename) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            return lines;
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
            return null;
        }
    }

    public static void appendDataToFile(String filename, List<String> data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            for (String line : data) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Data successfully appended to: " + filename);
        } catch (IOException e) {
            System.err.println("Error appending to file: " + e.getMessage());
        }
    }
}
