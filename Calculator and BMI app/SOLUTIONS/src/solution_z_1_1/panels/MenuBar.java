package solution_z_1_1.panels;


import solution_z_1_1.data_save_load.LoadBin;
import solution_z_1_1.data_save_load.LoadTxt;
import solution_z_1_1.data_save_load.SaveToBin;
import solution_z_1_1.data_save_load.SaveToTxt;

import javax.swing.*;
import java.io.File;

public class MenuBar extends JMenuBar {

    private SaveToBin saveToBin;
    private SaveToTxt saveToTxt;
    private LoadBin loadBin;
    private LoadTxt loadTxt;

    JFileChooser fileChooser = new JFileChooser();

    public MenuBar(MainFrame mainFrame) {
        JMenu fileMenu = new JMenu("File");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem loadItem = new JMenuItem("Load");
        JMenuItem exitItem = new JMenuItem("Exit");

        fileMenu.add(saveItem);
        fileMenu.add(loadItem);
        fileMenu.add(exitItem);

        add(fileMenu);

        saveItem.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showSaveDialog(mainFrame);

            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();

                // Save to file
                if (selectedFile.getName().endsWith(".txt")) {
                    saveToTxt = new SaveToTxt();
                    saveToTxt.save(mainFrame.getDataPanel().getData(), selectedFile.getAbsolutePath());
                } else if (selectedFile.getName().endsWith(".bin")) {
                    saveToBin = new SaveToBin();
                    saveToBin.save(mainFrame.getDataPanel().getData(), selectedFile.getAbsolutePath());
                } else {
                    JOptionPane.showMessageDialog(mainFrame, "Invalid file extension!");
                }

                if (selectedFile.getName().endsWith(".txt")) {
                    saveToTxt = new SaveToTxt();
                    saveToTxt.save(mainFrame.getDataPanel().getData(), selectedFile.getAbsolutePath());
                } else if (selectedFile.getName().endsWith(".bin")) {
                    saveToBin = new SaveToBin();
                    saveToBin.save(mainFrame.getDataPanel().getData(), selectedFile.getAbsolutePath());
                } else {
                    JOptionPane.showMessageDialog(mainFrame, "Invalid file extension!");
                }

                exitItem.addActionListener(event -> {
                    int option = JOptionPane.showConfirmDialog(mainFrame, "Do you really want to exit?");
                    if (option == JOptionPane.YES_OPTION) {
                        System.exit(0);
                    }
                });


            }
        });

        loadItem.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(mainFrame);

            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();

                // Load from file
                if (selectedFile.getName().endsWith(".txt")) {
                    loadTxt = new LoadTxt();
                    mainFrame.getDataPanel().setData(loadTxt.load(selectedFile.getAbsolutePath()));
                } else if (selectedFile.getName().endsWith(".bin")) {
                    loadBin = new LoadBin();
                    mainFrame.getDataPanel().setData(loadBin.load(selectedFile.getAbsolutePath()));
                } else {
                    JOptionPane.showMessageDialog(mainFrame, "Invalid file extension!");
                }
            }
        });






    }
}

