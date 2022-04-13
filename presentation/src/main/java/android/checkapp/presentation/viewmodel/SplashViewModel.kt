package android.checkapp.presentation.viewmodel

import android.checkapp.domain.usecase.CheckAppVersionUseCase
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val checkAppVersionUseCase: CheckAppVersionUseCase
) :ViewModel() {

    fun checkAppVersion() = checkAppVersionUseCase.excute()

}