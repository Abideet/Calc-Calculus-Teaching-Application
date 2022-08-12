package uk.aston.calculusldc.root.InteractiveDiagrams;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uk.aston.calculusldc.root.differentiation.ChainRule.ChainRuleQuizInventory;

public class FunctionTest {


    Function func;
    InteractiveDiagramCalculatorActivity diagramCalculatorActivity;


    @Before
    public void setUp()
    {

        func = new Function();
        diagramCalculatorActivity = new InteractiveDiagramCalculatorActivity();

    }

    @Test
    public void convertToRPNlv2() {
    }

    @Test
    public void resolveExpressionlv2() {
    }

    @Test
    public void replaceX() {
    }

    @Test
    public void replaceConstants() {
    }

    @Test
    public void createGraphicValues()
    {

        assertEquals(func.createGraphicValues(diagramCalculatorActivity.expression,1, -10, 10, 0 ));

    }
}