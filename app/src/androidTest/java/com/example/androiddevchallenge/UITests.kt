package com.example.androiddevchallenge

import androidx.compose.animation.ExperimentalAnimationApi
import org.junit.Rule
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.example.androiddevchallenge.ui.theme.MyTheme
import org.junit.Test
import androidx.compose.ui.test.*

class UITests    {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @ExperimentalAnimationApi
    @Test
    fun openBottomSheetAndCloseBottomSheetTest(){
        composeTestRule.setContent {
            MyTheme() {
                MyApp()
            }
        }
        composeTestRule.onNodeWithContentDescription(label = "Open Bottom Sheet").assertExists();
        composeTestRule.onNodeWithContentDescription(label = "Close Bottom Sheet").assertDoesNotExist();
        composeTestRule.onNodeWithContentDescription(label = "Open Bottom Sheet").performClick();
        composeTestRule.onNodeWithContentDescription(label = "Open Bottom Sheet").assertDoesNotExist();
        composeTestRule.onNodeWithContentDescription(label = "Close Bottom Sheet").assertExists();
        composeTestRule.onNodeWithContentDescription(label = "Close Bottom Sheet").performClick();
        composeTestRule.onNodeWithContentDescription(label = "Open Bottom Sheet").assertExists();
        composeTestRule.onNodeWithContentDescription(label = "Close Bottom Sheet").assertDoesNotExist();

    }
    @ExperimentalAnimationApi
    @Test
    fun changeTemperatureTypeTest(){
        composeTestRule.setContent {
            MyTheme() {
                MyApp()
            }
        }
            composeTestRule.onNodeWithText("27").assertExists()
            composeTestRule.onNodeWithText("80").assertDoesNotExist()

            composeTestRule.onNodeWithContentDescription(label ="Fahrenheit" ).performClick()
            composeTestRule.onNodeWithText("27").assertDoesNotExist()
            composeTestRule.onNodeWithText("80").assertExists()
        composeTestRule.onNodeWithContentDescription(label ="Celcius" ).performClick()
        composeTestRule.onNodeWithText("27").assertExists()
        composeTestRule.onNodeWithText("80").assertDoesNotExist()

        }
    }
