package solution_z_1_2;

public interface BMIObserverable {

    void addObserver(BMIObserver observer);
    void removeObserver(BMIObserver observer);
    void notifyObservers();
}
