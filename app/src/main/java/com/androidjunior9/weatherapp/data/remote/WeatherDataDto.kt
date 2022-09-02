package com.androidjunior9.weatherapp.data.remote

import com.squareup.moshi.Json

data class WeatherDataDto(
    val time :List<String>,
    @field:Json(name = "temperature_2m")
    val temperatures:List<Double>,
    @field:Json(name="weathercode")
    val weatherCodes:List<Int>,
    @field:Json(name = "surface_pressure")
    val pressures:List<Double>,
    @field:Json(name = "windspeed_10m")
    val windSpeeds:List<Double>,
    @field:Json(name = "relativehumidity_2m")
    val humidites:List<Double>
)