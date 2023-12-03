import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Task6 {

     static final String BANK_DATA_URL = "https://ewib.nbp.pl/plewibnra?dokNazwa=plewibnra.txt";
     static final int ARRAY_SIZE = 1000000;

    public static void main(String[] args) {
        try {
            String userInput = promptUserForDigits();
            String[] bankData = loadBankData();
            String abbreviatedBankNumber = userInput.substring(0, 3);
            String bankName = getBankName(bankData, abbreviatedBankNumber);

            if (bankName != null) {
                System.out.println("You have an account in the bank: " + bankName);
            } else {
                System.out.println("No information available for the provided bank number.");
            }

        } catch (IOException e) {
            System.out.println("Io eror");
        }
    }

     static String promptUserForDigits() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the first three digits of your bank account:");
        return reader.readLine().trim();
    }

     static String[] loadBankData() throws IOException {
        String[] bankData = new String[ARRAY_SIZE];

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(BANK_DATA_URL).openStream()))) {
            String line;

            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+", 2);
                if (parts.length == 2) {
                    int index = Integer.parseInt(parts[0]);
                    bankData[index] = parts[1];
                }
            }
        }
        return bankData;
    }

     static String getBankName(String[] bankData, String abbreviatedBankNumber) {
        try {
            int index = Integer.parseInt(abbreviatedBankNumber);
            return bankData[index];
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            return null;
        }
    }
}