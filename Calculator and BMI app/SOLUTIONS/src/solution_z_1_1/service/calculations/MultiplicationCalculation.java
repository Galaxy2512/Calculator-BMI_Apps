package solution_z_1_1.service.calculations;

import solution_z_1_1.service.CalculateStrategy;

public class MultiplicationCalculation implements CalculateStrategy {


    @Override
    public double calculate(double firstNumber, double secNumber) {

        return firstNumber * secNumber;
    }
}
