package solution_z_1_1.service.calculations;

import solution_z_1_1.service.CalculateStrategy;

public class PowerToCalculation implements CalculateStrategy {



    @Override
    public double calculate(double firstNumber, double secNumber) {

        return  Math.pow(firstNumber, secNumber);
    }
}