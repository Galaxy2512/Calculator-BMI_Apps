package solution_z_1_1.data_save_load;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoadBin implements LoadStrategy {


    @Override
    public String load(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            String loadedData = (String) ois.readObject();
            System.out.println("Loaded data from binary file: " + fileName);
            return loadedData;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
