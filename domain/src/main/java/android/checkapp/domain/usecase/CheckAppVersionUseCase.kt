package android.checkapp.domain.usecase

import android.checkapp.domain.repository.SplashRepository
import javax.inject.Inject

class CheckAppVersionUseCase @Inject constructor(
    private val splashRepository: SplashRepository
)  {
    fun excute() = splashRepository.checkAppVersion()
}