package com.androidjunior9.weatherapp.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.androidjunior9.weatherapp.domain.weather.WeatherData

@Composable
fun WeatherForcastContainer(
    data: List<WeatherData>,
    isToday:Boolean
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 1.dp)
    ) {
        Text(
            text = if(isToday) "Today" else "Tomorrow",
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier.padding(start = 16.dp)
        )
        Spacer(Modifier.height(16.dp))

        LazyRow(
            content = {
                items(data){
                    HourlyWeatherDisplay(
                        weatherData = it,
                        modifier = Modifier
                            .height(100.dp)
                            .padding(horizontal = 16.dp)
                    )
                }
            }
        )
    }
}