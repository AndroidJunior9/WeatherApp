package com.androidjunior9.weatherapp.di

import com.androidjunior9.weatherapp.data.repository.WeatherRepositoryImpl
import com.androidjunior9.weatherapp.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsWeatherRepository(weatherRepositoryImpl: WeatherRepositoryImpl):WeatherRepository
}