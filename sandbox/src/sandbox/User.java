package sandbox;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

public abstract class User {
    public String name;
    public String email;
    public String id;
    public String type;
    protected String pw;
    protected boolean vertification;
    //Generate random ID()
    protected static String generateRandomID() {
        // Generate a random UUID
        UUID uuid = UUID.randomUUID();
        // Convert UUID to string, remove hyphens, and get the first 6 characters
        return uuid.toString().replaceAll("-", "").substring(0, 6);
    }

    //write on the CSV
    //===============================
 
    public void writeUserCsv(String name, String email, String password, String id) {
        String csvFilePath = "/Users/fouadshalaby/Desktop/user.csv"; // Path to your CSV file
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
            String lastLine = null;
            String line;
            while ((line = reader.readLine()) != null) {
                lastLine = line; // Keep track of the last line in the CSV
            }
           

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath, true))) {
                // Append user data to the CSV file
                writer.newLine();
                writer.write(String.format("%s,%s,%s,%s", name, id, email, password)); // Assuming ID is the second column
                System.out.println("User data has been written to the CSV file.");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}
