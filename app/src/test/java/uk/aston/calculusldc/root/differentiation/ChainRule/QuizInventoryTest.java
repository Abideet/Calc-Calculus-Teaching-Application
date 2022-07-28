package uk.aston.calculusldc.root.differentiation.ChainRule;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QuizInventoryTest {

    QuizInventory q;


    @Before
    public void setUp()
    {

        q = new QuizInventory();

    }

    @Test
    public void getLength() {
        int expectedOutput = 4;
        int falseOutput = 5;
        assertEquals(falseOutput, q.getLength());
    }

    @Test
    public void getChoice() {
        String expectedOutput = "5*(2*x^5 + 4)^(-0.5)*x^4";
        assertEquals(expectedOutput, q.getChoice(1, 1));
    }

    @Test
    public void getCorrectAnswer() {

        String expectedOutput = "(8x + 6)*cos(4*x^2 + 6x + 5)";

        assertEquals(expectedOutput, q.getCorrectAnswer(0));

    }
}