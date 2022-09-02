package com.androidjunior9.weatherapp

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.androidjunior9.weatherapp.presentation.WeatherCard
import com.androidjunior9.weatherapp.presentation.WeatherForcast
import com.androidjunior9.weatherapp.presentation.WeatherViewModel
import com.androidjunior9.weatherapp.ui.theme.DarkBlue
import com.androidjunior9.weatherapp.ui.theme.DeepBlue
import com.androidjunior9.weatherapp.ui.theme.WeatherAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel:WeatherViewModel by viewModels()
    private lateinit var permissionLauncher:ActivityResultLauncher<Array<String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ){
            viewModel.loadWeatherInfo()
        }
        permissionLauncher.launch(arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ))
        setContent {
            WeatherAppTheme {
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(DarkBlue)
                    ) {
                        item{
                            WeatherCard(
                                state = viewModel.state,
                                backGroundColor = DeepBlue
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                        }

                        item {
                            WeatherForcast(state = viewModel.state)
                            Spacer(modifier = Modifier.height(16.dp))
                        }
                    }
                    if(viewModel.state.isLoading){
                        CircularProgressIndicator(
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                    viewModel.state.error?.let{ error->
                        Text(
                            text = error,
                            color = Color.Red,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }
        }
    }
}

