package uk.aston.calculusldc.root.differentiation.ChainRule;

import junit.framework.TestCase;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import android.support.test.rule.ActivityTestRule;


import androidx.test.ext.junit.rules.ActivityScenarioRule;


import uk.aston.calculusldc.R;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class QuizActivityTest extends TestCase {

    QuizActivity quizActivity;


    @Rule
    public ActivityScenarioRule<QuizActivity> activityScenarioRule =
            new ActivityScenarioRule<QuizActivity>(QuizActivity.class);

    @Test
    public void testQuestionIncrement(){
        onView(withId(R.id.choice1)).perform(click());
        onView(quizActivity.mQuestionNumber).check(matches(withText("1")));
    }

}