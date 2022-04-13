package android.checkapp.di

import android.checkapp.data.repository.remote.MainRepositoryImpl
import android.checkapp.data.repository.remote.SplashRepositoryImpl
import android.checkapp.data.repository.remote.datasource.MainDataSource
import android.checkapp.data.repository.remote.datasource.SplashDataSource
import android.checkapp.data.repository.remote.datasourceimpl.SplashDataSourceImpl
import android.checkapp.domain.repository.MainRepository
import android.checkapp.domain.repository.SplashRepository
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMainRepository(
        mainDataSource: MainDataSource
    ) : MainRepository{
        return MainRepositoryImpl(
            mainDataSource
        )
    }

    @Provides
    @Singleton
    fun provideSplashRepository(
        SplashDataSource: SplashDataSource
    ) : SplashRepository {
        return SplashRepositoryImpl(
            SplashDataSource
        )
    }

}