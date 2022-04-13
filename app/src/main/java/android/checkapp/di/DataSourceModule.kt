package android.checkapp.di

import android.checkapp.data.remote.api.LoveCalculatorApi
import android.checkapp.data.repository.remote.datasource.MainDataSource
import android.checkapp.data.repository.remote.datasource.SplashDataSource
import android.checkapp.data.repository.remote.datasourceimpl.MainDataSourceImpl
import android.checkapp.data.repository.remote.datasourceimpl.SplashDataSourceImpl
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Provides
    @Singleton
    fun provideMainDataSource(
        loveCalculatorApi : LoveCalculatorApi,
        firebastRtdb : FirebaseDatabase,
        firestore: FirebaseFirestore
    ) : MainDataSource{
        return MainDataSourceImpl(
            loveCalculatorApi,
            firebastRtdb
            ,firestore
        )
    }


    @Provides
    @Singleton
    fun provideSplashDataSource(
        firebaseRtdb : FirebaseDatabase,
        firestore: FirebaseFirestore
    ) : SplashDataSource {
        return SplashDataSourceImpl(
            firebaseRtdb, firestore
        )
    }

}