package com.example.androiddevchallenge


fun  Int.convertToFahrenheit(convert : Boolean): Int{
    if(!convert)
        return this;

    return celciusToF(this.toFloat()).toInt()

}