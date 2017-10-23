package com.mateuszzbylut.calcnet;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ConvertActivityInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.mateuszzbylut.calcnet", appContext.getPackageName());
    }

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class, false, false);

    @Test
    public void whenClickOnButtonConvertActivityThenMoveToNextActivity() {
        Context context = InstrumentationRegistry.getTargetContext();

        Intent intent = new Intent(context, ConvertActivity.class);
        activityTestRule.launchActivity(intent);

        Espresso.onView(withId(R.id.convert_activity_button)).perform(click());
    }

    @Rule
    public ActivityTestRule<ConvertActivity> convertTestRule =
            new ActivityTestRule<>(ConvertActivity.class);

    private  ConvertActivity convertActicity;

    @Test
    public void whenDecConvertThenConvertToBinOctHex() {
        convertActicity = convertTestRule.getActivity();
        onView(withId(R.id.numberToConvert)).perform(typeText("17"));
        onView(withId(R.id.buttonConvert)).perform(click());

        Espresso.onView(allOf(withId(R.id.outputText), withText("BIN: 10001")));
        Espresso.onView(allOf(withId(R.id.outputText2), withText("OCT: 21")));
        Espresso.onView(allOf(withId(R.id.outputText3), withText("HEX: 11")));
    }

    @Test
    public void whenFromBinThenSetBinConvert() {
        convertActicity = convertTestRule.getActivity();
        onView(withId(R.id.binButton)).perform(click());

        Espresso.onView(allOf(withId(R.id.decTitle), withText("BIN")));
    }

    @Test
    public void whenFromDecThenSetDecConvert() {
        convertActicity = convertTestRule.getActivity();
        onView(withId(R.id.decButton)).perform(click());

        Espresso.onView(allOf(withId(R.id.decTitle), withText("DEC")));
    }

    @Test
    public void whenFromOctThenSetOctConvert() {
        convertActicity = convertTestRule.getActivity();
        onView(withId(R.id.octButton)).perform(click());

        Espresso.onView(allOf(withId(R.id.decTitle), withText("OCT")));
    }

    @Test
    public void whenFromHexThenSetHexConvert() {
        convertActicity = convertTestRule.getActivity();
        onView(withId(R.id.hexButton)).perform(click());

        Espresso.onView(allOf(withId(R.id.decTitle), withText("HEX")));
    }


}
