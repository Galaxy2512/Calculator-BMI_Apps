package solution_z_1_1.service;


import java.math.BigDecimal;
import java.util.EventObject;

// This class is used to create an event. It extends the EventObject class.




public class FormEvent extends EventObject {
    private double firstNumber;
    private double secondNumber;
    private String calculation;
    private BigDecimal result;

    public FormEvent(Object source, double firstNumber, double secondNumber, String calculation, BigDecimal result ) { //constructor of the class that will be used to create the event
        super(source); //super is used to call the constructor of the parent class. In this case, the parent class is EventObject. Source is the object that is the source of the event.
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.calculation = calculation;
        this.result = result;
    }

    // Getters
    public double getFirstNumber() {
        return firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    public String getCalculation() {
        return calculation;
    }

    public BigDecimal getResult() {
        return result;
}

}
