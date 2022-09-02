package com.androidjunior9.weatherapp.data.remote

import com.squareup.moshi.Json

data class DailyWeatherDataDto(
    val time :List<String>,
    @field:Json(name = "temperature_2m_max")
    val maxTemperatures:List<Double>,
    @field:Json(name = "temperature_2m_min")
    val minTemperatures:List<Double>,
    @field:Json(name = "weathercode")
    val dailyWeathercodes:List<Int>
)
