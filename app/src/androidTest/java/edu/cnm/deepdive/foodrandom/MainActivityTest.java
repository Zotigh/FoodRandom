/*
 *  Copyright 2019 Lance Zotigh & Deep Dive Coding
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package edu.cnm.deepdive.foodrandom;

import android.arch.persistence.room.Delete;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.removeGlobalAssertion;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.anything;

/**
 * makes a simple test for the Main Activity
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule
            = new ActivityTestRule<>(MainActivity.class);

    //Order matters!!
    @Test
    public void navigateToRandomize(){
        //Deletes anything in the text editor.
        onView(withId(R.id.text_input_ingredient))
            .perform(clearText());

        //puts beef in the text editor
        onView(withId(R.id.text_input_ingredient))
            .perform(typeText("beef"));

        //Click on randomize button
        onView(withId(R.id.randomize_button))
            .perform(click());
        //Clicks on the save button
        onView(withId(R.id.save_button))
            .perform(click());

        //Click on Navigation
        onView(withId(R.id.navigation_recipes))
                .perform(click());

        //Make sure fragment is loaded
        onView(withId(R.id.saved_recipes_layout))
                .check(matches(isDisplayed()));


        //Will only work if there is something in the list
        //checks if the first item in the list is working
        onData(anything()).atPosition(0).perform(click());

        //Will only work if there is something in the list
        //checks that the recipe name is displayed
        onView(withId(R.id.recipe_name))
            .check(matches(isDisplayed()));


    }

}