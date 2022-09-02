package com.androidjunior9.weatherapp.domain.weather

import java.time.LocalDate

data class DailyWeatherData(
    val time: LocalDate,
    val maxTemperature:Double,
    val minTemperature:Double,
    val weatherCode:WeatherType
)
