package apptest;

import app.MySimpleCalculator;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;

public class MySimpleCalculatorTest {


    @DisplayName("Calculate the sum")
    @Description("This tests the bla bla bla bla bla bla bla of methods ")
    @Story("My first allure test ")

    @Test
    public void tc1() {


        MySimpleCalculator mySimpleCalculator = new MySimpleCalculator();

        double actual = mySimpleCalculator.add2Num(2.0, 2.0);

        Assert.assertThat(actual, equalTo(4.0));
    }

    @DisplayName("Calculate the sub ")
    @Test
    public void tc2() {


        MySimpleCalculator mySimpleCalculator = new MySimpleCalculator();

        double actual = mySimpleCalculator.sub2Num(2.0, 2.0);

        Assert.assertThat(actual, equalTo(4.0));
    }

    @Issue("https://jira.com/DMO-1300")
    @DisplayName("Calculate the multiplication")
    @Test
    public void tc3() {


        MySimpleCalculator mySimpleCalculator = new MySimpleCalculator();

        double actual = mySimpleCalculator.mul2Num(2.0, 2.0);

        Assert.assertThat(actual, equalTo(4.0));
    }

    @Link("https://www.google.com")
    @DisplayName("Calculate the divide")
    @Test
    public void tc4() {

        MySimpleCalculator mySimpleCalculator = new MySimpleCalculator();

        double actual = mySimpleCalculator.div2Num(2.0, 2.0);

        Assert.assertThat(actual, equalTo(4.0));
    }

    @DisplayName("blab bla")

    @Test
    public void tc5() {


        CalculatorSteps calculatorSteps = new CalculatorSteps();
        double actual = calculatorSteps.add2Numbers(3.0, 5.0);

        Assert.assertThat(actual, equalTo(8.0));

    }
}
