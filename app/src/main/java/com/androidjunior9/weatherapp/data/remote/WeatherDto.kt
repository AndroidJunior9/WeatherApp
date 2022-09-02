package com.androidjunior9.weatherapp.data.remote

import com.squareup.moshi.Json

data class WeatherDto(
    @field:Json(name = "hourly")
    val weatherData:WeatherDataDto,
    @field:Json(name = "daily")
    val dailyWeatherData:DailyWeatherDataDto
)
