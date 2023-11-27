package solution_z_1_1.data_save_load;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoadTxt implements LoadStrategy {

    @Override
    public String load(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            String loadedData = stringBuilder.toString();
            System.out.println("Loaded data from text file: " + fileName);
            return loadedData;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
