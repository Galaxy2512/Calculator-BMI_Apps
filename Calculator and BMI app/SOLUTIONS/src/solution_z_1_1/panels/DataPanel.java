package solution_z_1_1.panels;

import solution_z_1_1.service.FormEvent;
import solution_z_1_1.service.FormListener;

import javax.swing.*;
import java.awt.*;

public class DataPanel extends JPanel implements FormListener {
    private JScrollPane scrollPane; // dodano za scroll
    private JTextArea textArea;



    public DataPanel() {
        setLayout(new BorderLayout());
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setForeground(Color.BLUE);
        scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // dodano za scroll
        add(scrollPane, BorderLayout.CENTER);

    }

    @Override
    public void calculateSubmitted(FormEvent event) {
        String data = "First Number: " + event.getFirstNumber() +
                ", Second Number: " + event.getSecondNumber() +
                ", Calculation: " + event.getCalculation() +
                ", Result: " + event.getResult() +
                "\n";

        textArea.append(data); //prikazivanje rezultata u textArea u DataPanelu.
        //zasto se rezultat prikazuje 2 puta u DataPanelu?
        //zasto se rezultat ne prikazuje u ResultLowerPanelu?



    }


    public String getData() {

        return textArea.getText();
    }

    public void setData(String loadedData) {

        textArea.setText(loadedData);
    }
}
