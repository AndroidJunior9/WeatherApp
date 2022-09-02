package com.androidjunior9.weatherapp.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("v1/forecast?hourly=temperature_2m,relativehumidity_2m,weathercode,windspeed_10m,surface_pressure&daily=temperature_2m_max,temperature_2m_min,weathercode")
    suspend fun getWeatherData(
        @Query("latitude")lat:Double,
        @Query("longitude")long:Double,
        @Query("timezone")tz:String
    ):WeatherDto
}
//&daily=temperature_2m_max,temperature_2m_min,weathercode