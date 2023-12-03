import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
class DataManagement {
    private static final String file = "C:\\Users\\Tosha\\IdeaProjects\\llab9\\Lab10\\src\\Names";
    public void readData() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter your first and last name:");
            String fullName = scanner.nextLine();
            writeDataToFile(fullName);
        }
    }

    public void writeDataToFile(String fullName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(fullName);
            writer.newLine();
            System.out.println("Data has been written to the file.");
        }
        catch (IOException e){
            System.out.println("Io exception");
        }
    }

    public void readDataFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            System.out.println("Data read from the file:");

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Io exception");
        }
    }
}

public class Task5 {
    public static void main(String[] args) {
        DataManagement dataManagement = new DataManagement();
        dataManagement.readData();
        dataManagement.readDataFromFile();
    }
}