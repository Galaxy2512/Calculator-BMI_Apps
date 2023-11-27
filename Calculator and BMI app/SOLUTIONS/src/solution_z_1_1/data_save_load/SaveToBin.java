package solution_z_1_1.data_save_load;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveToBin implements SaveStrategy {

    @Override
    public void save(String data, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(data);
            System.out.println("Saved data to binary file: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
