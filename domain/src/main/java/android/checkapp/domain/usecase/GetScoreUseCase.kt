package android.checkapp.domain.usecase

import android.checkapp.domain.model.DomainScore
import android.checkapp.domain.repository.MainRepository
import javax.inject.Inject

class GetScoreUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {
    fun execute() = mainRepository.getScore()
}