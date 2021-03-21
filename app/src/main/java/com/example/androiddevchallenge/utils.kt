package com.example.androiddevchallenge

import com.example.androiddevchallenge.ui.theme.*
import java.text.SimpleDateFormat
import java.util.*

fun celciusToF(celcius : Float) : Float {
    return celcius*1.8f + 32.00f;

}
fun fahrenheitToC(fahrenHeit : Float) : Float {
    return (fahrenHeit-32.00f)/1.8f;

}
enum class  TemperatureType{
    Celcius,
    Fahrenheit
}
fun generateRandomTime(start : Int,end: Int ) : String
{
    val  hour:  Int =     (start..end).random()
    val  minute : Int= (10..59).random()
    if(hour<10)
        return "0$hour:$minute";

    return "$hour:$minute"
}
fun getTodaysDate() : String {
    val months = listOf("January","February","March","May","June","July","August","September","October","November","December");
    val date  = Date();
    val calendar : Calendar = Calendar.getInstance();
    return "${calendar.get(Calendar.DAY_OF_MONTH)} ${months[calendar.get(Calendar.MONTH)]} ${calendar.get(Calendar.YEAR)}";
}
fun getCurrentTime(): String {

    val calendar : Calendar = Calendar.getInstance();
    val hour = calendar.get(Calendar.HOUR_OF_DAY);
    val stringHour = if(hour<10) "0$hour" else hour.toString();
    val minutes = calendar.get(Calendar.MINUTE);
    val stringMinutes = if(minutes<10) "0$minutes" else minutes.toString();
    return "$stringHour:$stringMinutes";

}
fun getTheme() : TimeBasedTheme {
    val calendar : Calendar = Calendar.getInstance();
    when (calendar.get(Calendar.HOUR_OF_DAY)) {
        in 4..7 -> return SunComingUpTheme()
        in 8..16 -> return SunriseTheme()
        in 17..19 -> return SunGoingDownTheme()
        in 20..22 -> return MoonComingUpTheme()
        in 2..23 -> return MoonUpTheme()
        in 0..3 -> return MoonGoingDownTheme()

    };
    return SunComingUpTheme();


}