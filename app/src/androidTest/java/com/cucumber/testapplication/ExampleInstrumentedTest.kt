package com.cucumber.testapplication

import android.content.Intent
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createEmptyComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import java.util.*
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    private lateinit var scenario: ActivityScenario<MainActivity>
    private val composeTestRule = createEmptyComposeRule()
//
//    @Test
//    fun useAppContext() {
//        // Context of the app under test.
//        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
//        assertEquals("com.cucumber.testapplication", appContext.packageName)
//    }

    @Test
    fun validateComposeUI() {
        val intent = Intent(InstrumentationRegistry.getInstrumentation().targetContext, MainActivity::class.java)
        scenario = ActivityScenario.launch(intent)
        val time = Date().time
        val newTime = time + 20_000
        composeTestRule.waitUntil(3_000 + 20_000) {
            Date().time >= newTime
        }
        composeTestRule.onNodeWithTag("GreetingText").assertIsDisplayed()
        scenario.close()
    }
}