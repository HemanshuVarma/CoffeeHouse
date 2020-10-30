package com.varma.hemanshu.coffeehouse;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class UserDetailsTest {

    @Rule
    public ActivityScenarioRule<UserDetails> activityScenarioRule = new ActivityScenarioRule<>(UserDetails.class);

    @Test
    public void launchTest_success() {

    }

}