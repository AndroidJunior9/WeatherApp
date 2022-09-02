package com.androidjunior9.weatherapp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.androidjunior9.weatherapp.domain.weather.DailyWeatherData

@Composable
fun DailyWeatherDisplay(modifier: Modifier = Modifier ,data:DailyWeatherData){
    Column(
        modifier = modifier.padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = data.time.dayOfWeek.toString(),
            color = Color.LightGray
        )
        Image(
            painter = painterResource(id = data.weatherCode.iconRes),
            contentDescription = "Weather Icons",
            modifier = Modifier.width(40.dp)
        )
        Text(
            text = "${data.maxTemperature}°C",
            color = Color.Red,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "${data.minTemperature}°C",
            color = Color.Cyan,
            fontWeight = FontWeight.Bold
        )
}}