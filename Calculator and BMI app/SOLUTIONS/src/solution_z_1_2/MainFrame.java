package solution_z_1_2;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

//zasto prikazuje rezultat dva puta? zato sto je u notifyObservers() metodi pozvana metoda updateData() za svakog observera

public class MainFrame extends JFrame  implements BMIObserverable{

    private ViewPanel viewPanel;
    private FormPanel formPanel;

    private ToolBar toolBar;

    private final JFileChooser fileChooser = new JFileChooser();

    private static final String DIR = "DATA";

    private ArrayList<Person> persons = new ArrayList<>();

    private ArrayList<BMIObserver> observers = new ArrayList<>();

    private ProgressPanel progressPanel = new ProgressPanel();

    private TablePanel tablePanel;



    public MainFrame(){
        super("BMI APP");



        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 500);
        setResizable(false);
        initComps();
        layoutComps();
        activateFrame();

        setLocationRelativeTo(null);
        setVisible(true);


    }

    private void initComps(){
        viewPanel = new ViewPanel();
        formPanel = new FormPanel();
        toolBar = new ToolBar();
        persons = new ArrayList<>();
        fileChooser.setCurrentDirectory(new File(DIR));
        FileNameExtensionFilter filter1 = new FileNameExtensionFilter(
                "TXT files", "txt");
        FileNameExtensionFilter filter2 = new FileNameExtensionFilter(
                "BIN files", "bin");
        fileChooser.setFileFilter(filter1);
        fileChooser.addChoosableFileFilter(filter2);
        alignSaveWithExtensions();
        progressPanel = new ProgressPanel();
        tablePanel = new TablePanel();

    }

    private void layoutComps(){
        setLayout(new BorderLayout());
        add(viewPanel, BorderLayout.WEST);
        add(formPanel, BorderLayout.SOUTH);
        add(toolBar, BorderLayout.NORTH);
        add(progressPanel, BorderLayout.EAST);
        add(tablePanel, BorderLayout.CENTER);
    }

    private void alignSaveWithExtensions(){
            fileChooser.addActionListener(ae -> {
                if (ae.getActionCommand().equals(JFileChooser.APPROVE_SELECTION)){
                    String path = fileChooser.getSelectedFile().getPath();
                    if (fileChooser.getFileFilter().getDescription().equals("TXT files")){
                        if (!path.endsWith(".txt")){
                            path += ".txt";
                        }
                    } else if (fileChooser.getFileFilter().getDescription().equals("BIN files")){
                        if (!path.endsWith(".bin")){
                            path += ".bin";
                        }
                    }
                    fileChooser.setSelectedFile(new File(path));
                }
            });

    }


    private boolean dirExists(String path){

        return new File(path).exists();
    }



    private void activateFrame(){

        addObserver(progressPanel);
        addObserver(tablePanel);
        addObserver(viewPanel);
        formPanel.setFormPanelListener(new FormPanelListener() {
            @Override
            public void formEventOccurred(FormEvent fe) {
                if (persons.size() <5){
                    persons.add(fe.getPerson());
                    notifyObservers();


                } else {
                    JOptionPane.showMessageDialog(null, "Maksimalan broj osoba je 5!", "Greška", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        toolBar.setToolBarListener(new ToolBarListener() {
            @Override
            public void clearEventOccurred() {
                viewPanel.clearText();
                tablePanel.clearTable();
                progressPanel.clearProgress();
                persons.clear();
            }

            @Override
            public void saveEventOccurred() {
                int value = fileChooser.showSaveDialog(null); //potrebno napraviti klase za save i load

                if (value == JFileChooser.APPROVE_OPTION) {
                    String path = fileChooser.getSelectedFile().getPath();
                    if (ReadWriteClass.fileExtension(path).equals("bin")) {
                        // append Person object to the file
                        ReadWriteClass.writeToBinFile(path, persons);
                    } else {
                        // append toString representation of the Person object to the file
                        ReadWriteClass.writeToTextFile(path, persons);
                    }
                }
            }


            @Override
            public void loadEventOccurred() { //potrebno napraviti klase za save i load

                viewPanel.clearText();
                persons.clear();
                StringBuffer sb = null;
                int value = fileChooser.showOpenDialog(null);
                if (value == JFileChooser.APPROVE_OPTION){
                    String path = fileChooser.getSelectedFile().getPath();
                    // read from file and then append to the viewPanel
                    if (ReadWriteClass.fileExtension(path).equals("bin"))
                        sb = ReadWriteClass.readFromBinFile(path, persons);
                    else {
                        sb = ReadWriteClass.readFromTextFile(path, persons);
                    }
                    viewPanel.appendText(sb.toString());
                    System.out.println(persons);
                }

            }

            @Override
            public void exitEventOccurred() {
                int value = JOptionPane.showConfirmDialog(null, "Hvala na koristenju aplikacije!", "Izlaz", JOptionPane.CANCEL_OPTION);
                if (value == JOptionPane.OK_OPTION){
                    System.exit(0);
                }
            }
        });

    }




    @Override
    public void addObserver(BMIObserver observer) {

            observers.add(observer);
   }

    @Override
    public void removeObserver(BMIObserver observer) {
        if (observers.contains(observer))
            observers.remove(observer);


    }

    @Override
    public void notifyObservers() {

        for (BMIObserver observer : observers) {
            observer.updateData(persons);
        }

    }


}
