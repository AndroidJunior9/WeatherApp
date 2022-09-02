package com.androidjunior9.weatherapp.domain.weather

data class WeatherInfo(
    val weatherDataPerDay:Map<Int,List<WeatherData>>,
    val currentWeatherData:WeatherData?,
    val dailyWeatherData: List<DailyWeatherData>
)
