package ru.mike.videorecognition;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

import org.junit.Assert;
import org.junit.Test;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Shishov M.V. on 10/07/2015.
 */

public class SettingsFragmentTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public SettingsFragmentTest() {
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        getActivity();
        openActionBarOverflowOrOptionsMenu(getActivity().getApplicationContext());
        onView(withText(R.string.MainMenu_settings)).perform(click());
    }

    @Test
    public void testRootPatch(){
        onView(withId(R.id.rootPath)).check(matches(isDisplayed()));
        onView(withId(R.id.rootPath)).check(matches(withText(
                ((GlobalData)getActivity().getApplication().getApplicationContext())
                        .getRootPath())));
    }

    @Test
    public void testDBPatch(){
        onView(withId(R.id.dbPath)).check(matches(isDisplayed()));
        onView(withId(R.id.dbPath)).check(matches(withText(
                ((GlobalData)getActivity().getApplication().getApplicationContext())
                        .getDBPath())));
    }

    @Test
    public void testFilesPatch(){
        onView(withId(R.id.filesPath)).check(matches(isDisplayed()));
        onView(withId(R.id.filesPath)).check(matches(withText(
                ((GlobalData)getActivity().getApplication().getApplicationContext())
                        .getFilesPath())));
    }

    @Test
    public void testButtonReturn(){
        onView(withId(R.id.settingsReturn)).check(matches(isDisplayed()));
        onView(withId(R.id.settingsReturn)).perform(click());
        onView(withId(R.id.cameraFragment)).check(matches(isDisplayed()));
    }

    @Test
    public void testButtonSaveAndReturn() throws InterruptedException {
        onView(withId(R.id.settingsSaveAndReturn)).check(matches(isDisplayed()));
        String r="1234";
        onView(withId( R.id.rootPath  )).perform(typeText(r));
        String d="4567";
        closeSoftKeyboard();
        Thread.sleep(5000);
        onView(withId( R.id.dbPath)).perform(typeText(d));
        String f="7891";
        closeSoftKeyboard();
        Thread.sleep(5000);
        onView(withId( R.id.filesPath )).perform(typeText(f));
        closeSoftKeyboard();
        Thread.sleep(10000);
        onView(withId(R.id.settingsSaveAndReturn)).perform(click());
        onView(withId(R.id.cameraFragment)).check(matches(isDisplayed()));
        openActionBarOverflowOrOptionsMenu(getActivity().getApplicationContext());
        onView(withText(R.string.MainMenu_settings)).perform(click());
        testRootPatch();
        testDBPatch();
        testFilesPatch();
        testButtonReturn();
    }
}