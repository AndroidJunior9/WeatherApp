package com.androidjunior9.weatherapp.data.mappers

import com.androidjunior9.weatherapp.data.remote.DailyWeatherDataDto
import com.androidjunior9.weatherapp.data.remote.WeatherDataDto
import com.androidjunior9.weatherapp.data.remote.WeatherDto
import com.androidjunior9.weatherapp.domain.weather.DailyWeatherData
import com.androidjunior9.weatherapp.domain.weather.WeatherData
import com.androidjunior9.weatherapp.domain.weather.WeatherInfo
import com.androidjunior9.weatherapp.domain.weather.WeatherType
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private data class IndexedWeatherData(
    val index:Int,
    val data:WeatherData
)

fun WeatherDataDto.toweatherDataMap():Map<Int,List<WeatherData>>{
    return time.mapIndexed{index,time->
        val temperature = temperatures[index]
        val windSpeed = windSpeeds[index]
        val pressure = pressures[index]
        val weathercode = weatherCodes[index]
        val humidity = humidites[index]

        IndexedWeatherData(
            index = index,
            data = WeatherData(
                time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
                temperatureCelsius = temperature,
                pressure = pressure,
                windSpeed = windSpeed,
                humidity = humidity,
                weatherType = WeatherType.fromWMO(weathercode)
            )
        )

    }.groupBy {
        it.index/24
    }.mapValues {
        it.value.map{it.data}
    }
}
fun DailyWeatherDataDto.todailyWeatherdata():List<DailyWeatherData>{
    return time.mapIndexed {  index,time->
        val weatherCode = dailyWeathercodes[index]
        val maxTemperature = maxTemperatures[index]
        val minTemperature = minTemperatures[index]

        DailyWeatherData(
            time = LocalDate.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd")),
            maxTemperature = maxTemperature,
            minTemperature = minTemperature,
            weatherCode = WeatherType.fromWMO(weatherCode)
        )
    }
}

fun WeatherDto.toWeatherInfo():WeatherInfo{
    val weatherDataMap = weatherData.toweatherDataMap()
    val dailyWeatherData = dailyWeatherData.todailyWeatherdata()
    val now = LocalDateTime.now()
    val currentWeatherData = weatherDataMap[0]?.find {
        val hour = if(now.minute<30) now.hour else now.hour+1
        it.time.hour == hour
    }

    return WeatherInfo(
        weatherDataPerDay = weatherDataMap,
        currentWeatherData = currentWeatherData,
        dailyWeatherData = dailyWeatherData
    )
}


















