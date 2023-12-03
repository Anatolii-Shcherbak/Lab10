import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class task4 {
    public static void main(String[] args) {
        String Source = "C:\\Users\\Tosha\\IdeaProjects\\llab9\\Lab10\\src\\studentsEN.txt",
                CopySource = "C:\\Users\\Tosha\\IdeaProjects\\llab9\\Lab10\\src\\copy";

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(Source));
            FileWriter fw = new FileWriter(CopySource)) {
            String line;
            while ((line = bufferedReader.readLine()) != null){
                String[] words = line.split("\\s");
                String surname = words[0].trim();
                String name = words[1].trim();
                String score = words[2].trim();
                if(score.equals("5")){
                    fw.write(surname + "\s" + name + "\s" + score + "\n");
                }
            }
        } catch (IOException e)
        {
            System.out.println("Eror Io");
        }
    }
}
