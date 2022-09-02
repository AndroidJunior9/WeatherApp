package com.androidjunior9.weatherapp.domain.location

import android.location.Location

interface LocationTracker {
    suspend fun getCurrentLocation():Location?
}