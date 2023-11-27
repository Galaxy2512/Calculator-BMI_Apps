package solution_z_1_1.service.calculations;

//this class implements the CalculateStrategy interface and overrides the calculate method

import solution_z_1_1.service.CalculateStrategy;

public class DivisionCalculation implements CalculateStrategy {


    @Override
    public double calculate(double firstNumber, double secNumber) {

        return firstNumber / secNumber;
    }

}