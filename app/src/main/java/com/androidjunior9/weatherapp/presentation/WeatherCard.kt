package com.androidjunior9.weatherapp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.androidjunior9.weatherapp.R
import kotlin.math.roundToInt

@Composable
fun WeatherCard(
    state: WeatherState,
    backGroundColor:Color,
    modifier:Modifier = Modifier
){
    Card(
        backgroundColor = backGroundColor,
        shape = RoundedCornerShape(10.dp),
        modifier = modifier.padding(16.dp)
    ) {
        state.weatherInfo?.currentWeatherData?.let{data->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){

                Text(
                    text = "Now",
                    modifier = Modifier.align(Alignment.Start),
                    color = Color.White,
                    style = TextStyle(fontSize = 20.sp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Image(
                    painter = painterResource(id = data.weatherType.iconRes),
                    contentDescription = "Current Weather",
                    modifier = Modifier.width(200.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "${data.temperatureCelsius}°C",
                    color = Color.White,
                    fontSize = 50.sp
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = data.weatherType.weatherDesc,
                    fontSize = 20.sp,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(32.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ){
                    WeatherDataDisplay(
                        value = data.pressure.roundToInt(),
                        unit = "hpa",
                        icon = ImageVector.vectorResource(id = R.drawable.ic_pressure),
                        icontint =  Color.White,
                        textStyle = TextStyle(color = Color.White)
                    )

                    WeatherDataDisplay(
                        value = data.humidity.roundToInt(),
                        unit = "%",
                        icon = ImageVector.vectorResource(id = R.drawable.ic_drop),
                        icontint =  Color.White,
                        textStyle = TextStyle(color = Color.White)
                    )

                    WeatherDataDisplay(
                        value = data.windSpeed.roundToInt(),
                        unit = "km/h",
                        icon = ImageVector.vectorResource(id = R.drawable.ic_wind),
                        icontint =  Color.White,
                        textStyle = TextStyle(color = Color.White)
                    )
                }
            }
        }

    }
}













