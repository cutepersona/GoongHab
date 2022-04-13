package android.checkapp.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// 의존성 주입 클래스      Application 을 상속받는다.
@HiltAndroidApp            // Hilt를 사용하기위한 준비
class App: Application() {

    companion object {
        private lateinit var application : App
        fun getInstance() : App = application
    }

    override fun onCreate() {
        super.onCreate()
        application = this
    }
}