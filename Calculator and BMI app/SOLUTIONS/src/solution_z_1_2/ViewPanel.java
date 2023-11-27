package solution_z_1_2;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

//ovaj panel sluzi za prikazivanje podataka o BMI u textArea
public class ViewPanel extends JPanel  implements BMIObserver{

    private JTextArea txtArea;
    private JScrollPane scrollPane;

    public ViewPanel(){
        initComps();
        layoutComps();
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);
    }

    private void initComps(){
        txtArea = new JTextArea();
        txtArea.setEditable(false);
        txtArea.setLineWrap(true);
        txtArea.setWrapStyleWord(true);
        scrollPane = new JScrollPane(txtArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    }

    private void layoutComps(){
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
    }

    public void appendText(String text){
        txtArea.append(text);
    }

    public void clearText(){
        txtArea.setText(null);

    }


    @Override
    public <E> void updateData(ArrayList<E> elements) {
        clearText();
        for (E element : elements) {
            appendText(element.toString());
        }

    }


}
