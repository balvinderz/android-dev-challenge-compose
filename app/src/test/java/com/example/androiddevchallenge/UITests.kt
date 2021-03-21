package com.example.androiddevchallenge

import androidx.compose.ui.test.SemanticsMatcher
import org.junit.Rule
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.example.androiddevchallenge.ui.theme.MyTheme
import org.junit.Test

class UITests    {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun BottomSheetTest(){
        composeTestRule.setContent {
            MyTheme() {
                MainActivity()
            }
        }
        composeTestRule.onNode(matcher = SemanticsMatcher(description = ""))
    }
}