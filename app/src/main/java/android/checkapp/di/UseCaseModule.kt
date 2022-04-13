package android.checkapp.di

import android.checkapp.domain.repository.MainRepository
import android.checkapp.domain.repository.SplashRepository
import android.checkapp.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideCheckLoveCalculatorUseCase(repository : MainRepository) = CheckLoveCalculatorUseCase(repository)

    @Provides
    @Singleton
    fun provideCheckAppVersionUseCase(repository : SplashRepository) = CheckAppVersionUseCase(repository)

    @Provides
    @Singleton
    fun provideGetStatisticsUseCase(repository : MainRepository) = GetStatisticsUseCase(repository)

    @Provides
    @Singleton
    fun provideSetStatisticsUseCase(repository : MainRepository) = SetStaticticsUseCase(repository)

    @Provides
    @Singleton
    fun provideSetScoreUseCase(repository : MainRepository) = SetScoreUseCase(repository)

    @Provides
    @Singleton
    fun provideGetScoreUseCase(repository : MainRepository) = GetScoreUseCase(repository)



}