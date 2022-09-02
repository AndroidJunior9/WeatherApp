package com.androidjunior9.weatherapp.presentation

import com.androidjunior9.weatherapp.domain.weather.WeatherInfo

data class WeatherState(
    val weatherInfo: WeatherInfo? = null,
    val isLoading:Boolean = false,
    val error:String? = null
)
