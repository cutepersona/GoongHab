package android.checkapp.domain.usecase

import android.checkapp.domain.repository.MainRepository
import javax.inject.Inject

class GetStatisticsUseCase @Inject constructor(
    private val mainRepository: MainRepository
){
    fun excute() = mainRepository.getStatistics()
}