package uk.aston.calculusldc.root.differentiation.ChainRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

import uk.aston.calculusldc.R;

public class ChainRuleQuestionActivityTest {

    //uk.aston.calculusldc.root.differentiation.ChainRule.QuizActivity quizActivity = new QuizActivity();

    @Rule
    public ActivityScenarioRule<ChainRuleQuestionActivity> activityScenarioRule = new ActivityScenarioRule<ChainRuleQuestionActivity>(ChainRuleQuestionActivity.class);




//    @Rule
//    public ActivityScenarioRule<QuizActivity> activityScenarioRule =
//            new ActivityScenarioRule<QuizActivity>(QuizActivity.class);
//
//    @Test
//    public void testQuestionIncrement(){
//        onView(withId(R.id.choice1)).perform(click());
//        onView(quizActivity.mQuestionNumber).check(matches(withText("1")));
//    }

    @Test
    public void updateScore(){
        onView(withId(R.id.choice1)).perform(click());
        onView(withId(R.id.score)).check(matches(withText("1/4")));
    }


//    @Test
//    public void converterTest() {
//
//
//        Double testValue = 10.1;
//
//        //quizActivity.score.getClass().getSimpleName();
//
//        Assert.assertEquals(testValue.getClass().getSimpleName(), quizActivity.score.getClass().getSimpleName());
//
//
//    }

}