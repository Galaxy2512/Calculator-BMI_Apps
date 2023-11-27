package solution_z_1_2.data_save_load_bmi;

import solution_z_1_2.Person;

import java.io.*;
import java.util.ArrayList;

public class LoadSaveTxt implements LoadSaveStrategy {
    @Override
    public <E> StringBuffer load(String path, ArrayList<E> list) {
        list.clear();
        StringBuffer sb = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(new File(path)))) {
            String line;
            while ((line = br.readLine()) != null) { //
                sb.append(line).append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb;
    }

    @Override
    public <E> void save(String path, ArrayList<E> list) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path), true))) {
            for (E element : list) {
                bw.write(element.toString()); // Koristite toString metodu objekta
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
