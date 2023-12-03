import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task2 {
    public static void main(String[] args) {
        int bajt;
        String Source = "C:\\Users\\Tosha\\IdeaProjects\\llab9\\Lab10\\src\\file",
                CopySource = "C:\\Users\\Tosha\\IdeaProjects\\llab9\\Lab10\\src\\copyOfFile";

        try (FileInputStream fis = new FileInputStream(Source);
             FileOutputStream fos = new FileOutputStream(CopySource)){
            do {
                bajt = fis.read();
                if ((char) bajt == ' ') bajt = '-';
                if (bajt != -1) fos.write(bajt);
            } while (bajt != -1);
        }
        catch (IOException e)
        {
            System.out.println("Error IO");
        }

    }
}

