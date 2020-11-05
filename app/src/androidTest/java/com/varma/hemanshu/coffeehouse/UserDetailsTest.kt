package com.varma.hemanshu.coffeehouse

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4ClassRunner::class)
class UserDetailsTest {

    @Rule
    @JvmField
    val activityScenarioRule = ActivityScenarioRule(UserDetails::class.java)

    @Test
    fun launchTest_success() {
        activityScenarioRule.scenario
    }
}