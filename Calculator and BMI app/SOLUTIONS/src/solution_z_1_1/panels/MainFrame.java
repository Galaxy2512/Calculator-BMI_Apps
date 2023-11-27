package solution_z_1_1.panels;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class MainFrame extends JFrame {
    private InputPanel inputPanel;
    private DataPanel dataPanel;
    private MenuBar menuBar;



    public MainFrame(String title) {
        super(title);
        // Create input and data panels
        this.dataPanel = new DataPanel();
        this.inputPanel = new InputPanel(dataPanel);
        this.menuBar = new MenuBar(this); // Proslijedite referencu na trenutni MainFrame

        // Set layout for the main frame
        setLayout(new GridLayout(2, 2)); // 2 rows, 1 column

        // Add panels to the main frame
        add(dataPanel);
        add(inputPanel);


        // Add the menu bar to the main frame
        setJMenuBar(menuBar);

        // Activate the frame
        inputPanel.activateFrame();

        // Postavite veličinu, vidljivost i zatvaranje
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


    }

    public DataPanel getDataPanel() {
        return dataPanel;
    }



}
