package android.checkapp.presentation.view

import android.checkapp.presentation.R
import android.checkapp.presentation.databinding.ActivityMainBinding
import androidx.activity.viewModels
import android.checkapp.presentation.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import android.checkapp.presentation.viewmodel.MainViewModel
import com.pss.barlibrary.CustomBar.Companion.setTransparentBar

// Hilt 관련 어노테이션이 사용된 viewModel등을 사용하기 위해서는
// activity에 AndroidEntryPoint 어노테이션을 선언한다.
@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    // Main에서 사용할 ViewModel 선언
    private val mainViewModel by viewModels<MainViewModel>()

    // BaseActivity에서 onCreate를 init로 단축시켰으므로 초기생성 onCreate는 삭제함.
    // 또한, Databinding도 Base에 있으므로 생략가능함.
    override fun init() {
        setTransparentBar(this)
    }
}