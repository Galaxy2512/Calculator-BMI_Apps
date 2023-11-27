package solution_z_1_2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

// Ovaj panel služi za prikazivanje podataka u tabeli

public class TablePanel extends JPanel implements BMIObserver {
    private JTable table;
    private DefaultTableModel tableModel;

    public TablePanel() {
        initializeComponents();
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);
    }

    private void initializeComponents() {
        setLayout(new BorderLayout());

        tableModel = new DefaultTableModel();

        tableModel.addColumn("Height");
        tableModel.addColumn("Weight");
        tableModel.addColumn("Category");
        tableModel.addColumn("BMI");

        table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void addRow(String height, String weight, String category, String bmi) {
        String[] rowData = {height, weight, category, bmi};
        tableModel.addRow(rowData);
    }

    public void clearTable() {
        tableModel.setRowCount(0);
    }


    @Override
    public <E> void updateData(ArrayList<E> elements) {
        clearTable();
        for (E element : elements) {
            Person person = (Person) element;
            addRow(String.valueOf(person.getHeight()), String.valueOf(person.getWeight()), person.getCategory(), String.valueOf(person.getBmi()));
  }
}

}
