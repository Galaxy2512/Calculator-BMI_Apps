package solution_z_1_2;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ProgressPanel extends JPanel implements BMIObserver {
    private JProgressBar progressBar;

    private JPanel panel;

    public ProgressPanel() {

        panel = new JPanel();

        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        progressBar.setMaximum(5);



        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Progress"));
        add(panel);
        panel.setLayout(new GridBagLayout());
        panel.add(progressBar);
    }


    @Override
    public <E> void updateData(ArrayList<E> elements) {
        progressBar.setValue(elements.size());
    }


    public void clearProgress() {
        progressBar.setValue(0);
}



}

