import javax.sound.sampled.Line;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                users.add(new User(parts[0], Integer.parseInt(parts[1])));
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("user.json"))) {
            writer.write("[");
            boolean first = true;
            for (User user : users) {
                if (!first) {
                    writer.write(",");
                }
                writer.write("{\n    \"name\": \"" + user.getName() + "\",\n    \"age\":" + user.getAge() + "\n}");
                first = false;
            }
            writer.write("]");
        }
    }
}