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
import com.androidjunior9.weatherapp.domain.weather.DailyWeatherData

@Composable
fun DailyWeatherCard(
    weatherData: List<DailyWeatherData>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 1.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "7 Day Forcast",
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier.padding(start = 16.dp)
        )
        Spacer(Modifier.height(16.dp))

        LazyRow(horizontalArrangement = Arrangement.SpaceBetween,
            content = {
                items(weatherData) { data ->
                    DailyWeatherDisplay(
                        data = data,
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .height(120.dp)
                    )
                    }
                }
            )
    }
}
