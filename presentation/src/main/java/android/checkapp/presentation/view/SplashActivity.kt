package android.checkapp.presentation.view

import android.checkapp.presentation.R
import android.checkapp.presentation.databinding.ActivitySplashBinding
import androidx.activity.viewModels
import android.checkapp.presentation.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import android.checkapp.presentation.viewmodel.SplashViewModel
import android.checkapp.presentation.widget.extension.startActivityAndFinish
import com.pss.barlibrary.CustomBar.Companion.setTransparentBar

@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashBinding>(R.layout.activity_splash) {

    private val splashViewModel by viewModels<SplashViewModel>()
    private val appVersion = "1.0.0"

    override fun init() {
        setTransparentBar(this)
        splashViewModel.checkAppVersion()
            .addOnSuccessListener {
                if (appVersion == it.value) {
                    this.startActivityAndFinish(this, MainActivity::class.java)
                } else {
                    longShowToast("앱 버전이 다릅니다!")
                }
            }.addOnFailureListener {
                shortShowToast("오류가 발생했습니다, 오류코드 - ${it.message}")
            }
    }

}