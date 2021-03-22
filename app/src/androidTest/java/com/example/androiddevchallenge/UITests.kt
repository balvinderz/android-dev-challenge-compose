/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.androiddevchallenge.ui.theme.MyTheme
import org.junit.Rule
import org.junit.Test

class UITests {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @ExperimentalAnimationApi
    @Test
    fun openBottomSheetAndCloseBottomSheetTest() {
        composeTestRule.setContent {
            MyTheme() {
                MyApp()
            }
        }
        composeTestRule.onNodeWithTag(testTag= "OpenBottomSheetFloatingButton").assertExists()
        composeTestRule.onNodeWithTag(testTag = "CloseBottomSheetFloatingButton")
            .assertDoesNotExist()
        composeTestRule.onNodeWithTag(testTag= "OpenBottomSheetFloatingButton").performClick()
        composeTestRule.onNodeWithTag(testTag= "OpenBottomSheetFloatingButton")
            .assertDoesNotExist()
        composeTestRule.onNodeWithTag(testTag = "CloseBottomSheetFloatingButton").assertExists()
        composeTestRule.onNodeWithTag(testTag = "CloseBottomSheetFloatingButton").performClick()
        composeTestRule.onNodeWithTag(testTag= "OpenBottomSheetFloatingButton").assertExists()
        composeTestRule.onNodeWithTag(testTag= "CloseBottomSheetFloatingButton")
            .assertDoesNotExist()
    }

    @ExperimentalAnimationApi
    @Test
    fun changeTemperatureTypeTest() {
        composeTestRule.setContent {
            MyTheme() {
                MyApp()
            }
        }
        composeTestRule.onNodeWithText("27").assertExists()
        composeTestRule.onNodeWithText("80").assertDoesNotExist()

        composeTestRule.onNodeWithContentDescription(label = "Fahrenheit").performClick()
        composeTestRule.onNodeWithText("27").assertDoesNotExist()
        composeTestRule.onNodeWithText("80").assertExists()
        composeTestRule.onNodeWithContentDescription(label = "Celsius").performClick()
        composeTestRule.onNodeWithText("27").assertExists()
        composeTestRule.onNodeWithText("80").assertDoesNotExist()
    }
    @ExperimentalAnimationApi
    @Test
    fun clickingOnNext7DaysMakesThe7DaysTabAppearTest(){
        composeTestRule.setContent {
            MyTheme {
                MyApp()
            }
        }
        for(i in 0..6)
            composeTestRule.onNodeWithText(getTodaysDate(offset = i+1)).assertDoesNotExist() // initially these days should not be there
        composeTestRule.onNodeWithContentDescription(label = "Open Bottom Sheet").performClick()
        composeTestRule.onNodeWithTag("Next7DaysTextButton").performClick()
        for(i in 0..6)
            composeTestRule.onNodeWithText(getTodaysDate(offset = i+1)).assertExists() // after clicking the next7days button ,these dates should be there
    }
    }
