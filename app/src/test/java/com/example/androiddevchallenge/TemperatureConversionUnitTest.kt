package com.example.androiddevchallenge

import org.junit.Test

class TemperatureConversionUnitTest {
    @Test
    fun celciusToFahrenheit_formula_test(){
        assert(celciusToF(celcius = 100f)==212f)
    }
    @Test
    fun fahrenheitToCelcius_formula_test(){
        assert(fahrenHeitToC(212f) == 100f)
    }
}