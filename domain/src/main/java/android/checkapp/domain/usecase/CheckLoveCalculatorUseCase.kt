package android.checkapp.domain.usecase

import android.checkapp.domain.repository.MainRepository
import android.checkapp.domain.utils.RemoteErrorEmitter
import javax.inject.Inject

// #11  Activity에서 호출하는 UseCase Domain Response를 리턴함.
class CheckLoveCalculatorUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {
    suspend fun execute( remoteErrorEmitter: RemoteErrorEmitter, host: String, key : String, mName : String, wName : String ) = mainRepository.checkLoveCalculator(remoteErrorEmitter, host, key, mName, wName)
}