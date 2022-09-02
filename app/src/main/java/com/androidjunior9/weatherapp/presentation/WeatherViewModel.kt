package com.androidjunior9.weatherapp.presentation


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidjunior9.weatherapp.domain.location.LocationTracker
import com.androidjunior9.weatherapp.domain.repository.WeatherRepository
import com.androidjunior9.weatherapp.domain.util.Resources
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel@Inject constructor(
    private val repository:WeatherRepository,
    private val locationTracker: LocationTracker
):ViewModel() {
    private val tz: String = TimeZone.getDefault().id
    var state by mutableStateOf(WeatherState())
        private set

    fun loadWeatherInfo(){
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )
            locationTracker.getCurrentLocation()?.let { location->
                when(val result = repository.getWeatherData(location.latitude,location.longitude,tz)){
                    is Resources.Success -> {
                        state = state.copy(
                            weatherInfo = result.data,
                            isLoading = false,
                            error = null
                        )
                    }

                    is Resources.Error -> {
                        state = state.copy(
                            weatherInfo = null,
                            isLoading = false,
                            error = result.message
                        )
                    }
                }
            }?: kotlin.run {
                state = state.copy(
                    isLoading = false,
                    error = "Couldn't retrieve location, Make sure " +
                            "to grant permission and enable internet"
                )
            }
        }
    }
}













