package com.androidjunior9.weatherapp.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WeatherForcast(
    state: WeatherState,
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        state.weatherInfo?.weatherDataPerDay?.get(0)?.let {
            WeatherForcastContainer(data = it,isToday = true)
        }
        Spacer(modifier = Modifier.height(32.dp))
        state.weatherInfo?.weatherDataPerDay?.get(1)?.let{
            WeatherForcastContainer(data = it,isToday = false)
        }
        Spacer(modifier = Modifier.height(32.dp))
        state.weatherInfo?.dailyWeatherData?.let{
            DailyWeatherCard(weatherData = it)
        }

    }

}








