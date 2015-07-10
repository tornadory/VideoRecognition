package ru.mike.videorecognition;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Shishov M.V. on 10/07/2015.
 */

@LargeTest
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testMainActivityExistsFragmentContainer() {
        onView(withId(R.id.fragmentContainer))
                .check(matches(isDisplayed()));
    }

    public void testMainActivityStartWithCameraContainer() {
        onView(withId(R.id.cameraFragment))
                .check(matches(isDisplayed()));
    }

    public void testMainActivityOnMenuItemSettingsClickShowSettingsFragment() {
        openActionBarOverflowOrOptionsMenu(getActivity().getApplicationContext());
        onView(withText(R.string.MainMenu_settings)).perform(click());
        onView(withId(R.id.settingsFragment))
                .check(matches(isDisplayed()));
        onView(withId(R.id.cameraFragment))
                .check(doesNotExist());
    }
}