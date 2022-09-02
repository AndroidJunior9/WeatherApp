package com.androidjunior9.weatherapp.data.repository

import com.androidjunior9.weatherapp.data.mappers.toWeatherInfo
import com.androidjunior9.weatherapp.data.remote.WeatherApi
import com.androidjunior9.weatherapp.domain.repository.WeatherRepository
import com.androidjunior9.weatherapp.domain.util.Resources
import com.androidjunior9.weatherapp.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api:WeatherApi
):WeatherRepository{
    override suspend fun getWeatherData(lat: Double, long: Double,tz:String): Resources<WeatherInfo> {
        return try{
            Resources.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long,
                    tz = tz
                ).toWeatherInfo()
            )
        }catch(e:Exception){
            e.printStackTrace()
            return Resources.Error(e.message?:"An Unknown Error occured")
        }
    }
}