package android.checkapp.domain.usecase

import android.checkapp.domain.repository.MainRepository
import javax.inject.Inject

class SetStaticticsUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {
    fun execute(plusValue: Int) = mainRepository.setStatistics(plusValue)
}