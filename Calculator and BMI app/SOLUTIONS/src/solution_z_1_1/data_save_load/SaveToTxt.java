package solution_z_1_1.data_save_load;

import java.io.IOException;
import java.io.PrintWriter;

public class SaveToTxt implements SaveStrategy {

    @Override
    public void save(String data, String fileName) {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            writer.println(data);
            System.out.println("Saved data to text file: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}