package solution_z_1_1;

import solution_z_1_1.panels.MainFrame;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> { // this is used to make sure that the GUI is created on the Event Dispatch Thread
            JFrame frame = new MainFrame("Calculator App");
            frame.setResizable(false);
            frame.setSize(450, 500);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.setVisible(true); // make the frame visible (always do this last)
        });
    }
}