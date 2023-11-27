package solution_z_1_2.data_save_load_bmi;

import solution_z_1_2.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LoadSaveBin implements LoadSaveStrategy{
    @Override
    public <E> StringBuffer load(String path, ArrayList<E> list) {
        list.clear();
        StringBuffer sb = new StringBuffer();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(path)))){
            while (true){
                E element = (E) ois.readObject();
                list.add(element);
                sb.append(element + "\n");

            }
        } catch (EOFException e){
            // end of file reached
        } catch (Exception e){
            e.printStackTrace();
        }
        return sb;


    }

    @Override
    public <E> void save(String path, ArrayList<E> list) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(path), true))){
            for (E element : list){
                oos.writeObject(element);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
