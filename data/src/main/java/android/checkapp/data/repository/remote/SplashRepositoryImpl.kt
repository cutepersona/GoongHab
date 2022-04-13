package android.checkapp.data.repository.remote

import android.checkapp.data.repository.remote.datasource.SplashDataSource
import android.checkapp.domain.repository.SplashRepository
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import javax.inject.Inject

class SplashRepositoryImpl @Inject constructor(
    private val splashDataSource: SplashDataSource
) : SplashRepository{
    override fun checkAppVersion(): Task<DataSnapshot> {
        return splashDataSource.checkAppVersion()
    }
}