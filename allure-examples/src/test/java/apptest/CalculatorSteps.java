package apptest;

import app.MySimpleCalculator;
import io.qameta.allure.Step;

public class CalculatorSteps {


    @Step("Adding 2 numbers: {0} & {1}")
    public double add2Numbers(double n1, double n2) {

        MySimpleCalculator mySimpleCalculator = new MySimpleCalculator();

        return mySimpleCalculator.add2Num(n1, n2);
    }
}
