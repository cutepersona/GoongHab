package android.checkapp.domain.usecase

import android.checkapp.domain.model.DomainScore
import android.checkapp.domain.repository.MainRepository
import javax.inject.Inject

class SetScoreUseCase @Inject constructor(
    private val mainRepository : MainRepository
) {
    fun execute(score: DomainScore) = mainRepository.setScore(score)
}