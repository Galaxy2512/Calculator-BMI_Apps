package solution_z_1_1.panels;

import solution_z_1_1.service.FormEvent;
import solution_z_1_1.service.calculations.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class InputPanel extends JPanel {

    private JLabel firstLabel;
    public JTextField firstNumberField;
    private JLabel secondLabel;
    private JTextField secondNumberField;
    private JList<String> operationJList;
    private JLabel label;
    private JButton calculateButton;
    private DataPanel formListener;

    private TextArea resultTextArea;

    JScrollPane scrollPane; // Deklaracija, bez inicijalizacije

    public InputPanel(DataPanel dataPanel) {
        setLayout(null); // Postavljanje null layouta
        initComponents(); // Inicijalizacija komponenti
        layoutComponents(); // Postavljanje rasporeda komponenata

        this.formListener = dataPanel;
    }

    public void initComponents() {
        firstLabel = new JLabel("First Num:");
        firstNumberField = new JTextField(6);
        secondLabel = new JLabel("Second Num:");
        secondNumberField = new JTextField(6);
        operationJList = new JList<>(new String[]{"Addition", "Subtraction", "Multiplication", "Division", "Power"});
        label = new JLabel("Calculation:");
        calculateButton = new JButton("Calculate");
        resultTextArea = new TextArea();

        // Inicijalizacija JScrollPane za JList
        scrollPane = new JScrollPane(operationJList);
    }

    public void layoutComponents() {
        // Prvi label
        firstLabel.setBounds(10, 50, 80, 25);
        add(firstLabel);

        // Prvi text field
        firstNumberField.setBounds(85, 50, 60, 25);
        add(firstNumberField);

        // Drugi label
        secondLabel.setBounds(5, 80, 80, 25);
        add(secondLabel);

        // Drugi text field
        secondNumberField.setBounds(85, 80, 60, 25);
        add(secondNumberField);

        // Lista operacija s JScrollPane
        scrollPane.setBounds(170, 50, 100, 100);
        add(scrollPane);

        // Labela za operaciju
        label.setBounds(20, 0, 100, 25);
        add(label);

        // Dugme za izračunavanje
        calculateButton.setBounds(300, 80, 100, 25);
        add(calculateButton);

        // TextArea rezultata
        resultTextArea.setBounds(300, 50, 80, 20);
        add(resultTextArea);
    }

    public void activateFrame() {
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ovdje dodajte provjeru praznih polja za unos
                if (firstNumberField.getText().trim().isEmpty() || secondNumberField.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter values for both numbers.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                } else if (Double.parseDouble(firstNumberField.getText()) < 0) {
                    JOptionPane.showMessageDialog(null, "Please enter a positive value for the second number.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    double firstNumber = Double.parseDouble(firstNumberField.getText());
                    double secondNumber = Double.parseDouble(secondNumberField.getText());
                    String operation = operationJList.getSelectedValue();

                    double result = 0;

                    switch (operation) {
                        case "Addition":
                            AdditionCalculation additionCalculation = new AdditionCalculation();
                            result = additionCalculation.calculate(firstNumber, secondNumber);
                            break;
                        case "Subtraction":
                            SubtractionCalculation subtractionCalculation = new SubtractionCalculation();
                            result = subtractionCalculation.calculate(firstNumber, secondNumber);

                            break;
                        case "Multiplication":
                            MultiplicationCalculation multiplicationCalculation = new MultiplicationCalculation();
                            result = multiplicationCalculation.calculate(firstNumber, secondNumber);
                            break;
                        case "Power":
                            PowerToCalculation powerToCalculation = new PowerToCalculation();
                            result = powerToCalculation.calculate(firstNumber, secondNumber);

                            break;
                        case "Division":
                            if (secondNumber != 0) {
                                DivisionCalculation divisionCalculation = new DivisionCalculation();
                                result = divisionCalculation.calculate(firstNumber, secondNumber);
                            } else {
                                JOptionPane.showMessageDialog(null, "Cannot divide by zero!", "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            break;
                    }

                    BigDecimal formattedResult = new BigDecimal(result)
                            .setScale(3, RoundingMode.HALF_UP)
                            .stripTrailingZeros();
                    FormEvent event = new FormEvent(this, firstNumber, secondNumber, operation, formattedResult);
                    if (formListener != null) {
                        formListener.calculateSubmitted(event);
                        resultTextArea.setText(formattedResult.toPlainString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Please add number.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid numeric values.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
}

}
