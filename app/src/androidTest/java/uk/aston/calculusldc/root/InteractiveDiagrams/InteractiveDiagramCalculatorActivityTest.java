package uk.aston.calculusldc.root.InteractiveDiagrams;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

import uk.aston.calculusldc.R;


public class InteractiveDiagramCalculatorActivityTest {

    @Rule
    public ActivityScenarioRule<InteractiveDiagramCalculatorActivity> activityScenarioRule = new ActivityScenarioRule<InteractiveDiagramCalculatorActivity>(InteractiveDiagramCalculatorActivity.class);


    @Test
    public void syntaxErrorCheck()
    {
        onView(withId(R.id.equalsButton)).perform(click());
        onView(withId(R.id.formulaView)).check(matches(withText("Syntax Error: Enter an equation first")));
    }

    @Test
    public void openingParenthesisCheck()
    {
        onView(withId(R.id.openParenthesis)).perform(click());
        onView(withId(R.id.formulaView)).check(matches(withText("y=(")));
    }

    //closed parenthesis should not be shown even if there are no values entered before it
    @Test
    public void closedParenthesisCheck()
    {
        onView(withId(R.id.closedParenthesis)).perform(click());
        onView(withId(R.id.formulaView)).check(matches(withText("y=")));
    }

    @Test
    public void xCheck()
    {
        onView(withId(R.id.x)).perform(click());
        onView(withId(R.id.formulaView)).check(matches(withText("y=x")));
    }

    @Test
    public void cancelCheck()
    {
        onView(withId(R.id.x)).perform(click());
        onView(withId(R.id.canc)).perform(click());
        onView(withId(R.id.formulaView)).check(matches(withText("y=")));
    }

    @Test
    public void sevenCheck()
    {
        onView(withId(R.id.seven)).perform(click());
        onView(withId(R.id.formulaView)).check(matches(withText("y=7")));
    }

    @Test
    public void zeroCheck()
    {
        onView(withId(R.id.zero)).perform(click());
        onView(withId(R.id.formulaView)).check(matches(withText("y=0")));
    }

    @Test
    public void oneCheck()
    {
        onView(withId(R.id.one)).perform(click());
        onView(withId(R.id.formulaView)).check(matches(withText("y=1")));
    }

    @Test
    public void twoCheck()
    {
        onView(withId(R.id.two)).perform(click());
        onView(withId(R.id.formulaView)).check(matches(withText("y=2")));
    }

    @Test
    public void threeCheck()
    {
        onView(withId(R.id.three)).perform(click());
        onView(withId(R.id.formulaView)).check(matches(withText("y=3")));
    }

    @Test
    public void fourCheck()
    {
        onView(withId(R.id.four)).perform(click());
        onView(withId(R.id.formulaView)).check(matches(withText("y=4")));
    }

    @Test
    public void fiveCheck()
    {
        onView(withId(R.id.five)).perform(click());
        onView(withId(R.id.formulaView)).check(matches(withText("y=5")));
    }

    @Test
    public void sixCheck()
    {
        onView(withId(R.id.six)).perform(click());
        onView(withId(R.id.formulaView)).check(matches(withText("y=6")));
    }

    @Test
    public void eightCheck()
    {
        onView(withId(R.id.eight)).perform(click());
        onView(withId(R.id.formulaView)).check(matches(withText("y=8")));
    }

    @Test
    public void nineCheck()
    {
        onView(withId(R.id.nine)).perform(click());
        onView(withId(R.id.formulaView)).check(matches(withText("y=9")));
    }








}