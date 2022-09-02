package com.androidjunior9.weatherapp.domain.repository

import com.androidjunior9.weatherapp.domain.util.Resources
import com.androidjunior9.weatherapp.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat:Double,long:Double,tz:String):Resources<WeatherInfo>
}