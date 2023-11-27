package solution_z_1_2.data_save_load_bmi;

import java.util.ArrayList;

public interface LoadSaveStrategy {

    <E> StringBuffer load(String path, ArrayList<E> list);

    <E> void save(String path, ArrayList<E> list);

    static String fileExtension(String path) {

        return path.substring(path.lastIndexOf(".") + 1);
    }




}
