package android.checkapp.data.repository.remote

import android.checkapp.data.mapper.MainMapper
import android.checkapp.data.repository.remote.datasource.MainDataSource
import android.checkapp.domain.model.DomainLoveReponse
import android.checkapp.domain.model.DomainScore
import android.checkapp.domain.repository.MainRepository
import android.checkapp.domain.utils.RemoteErrorEmitter
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.firestore.QuerySnapshot
import javax.inject.Inject

//#9 Data모듈에 Domain모듈 repository구현체를 만들어 줌.
class MainRepositoryImpl @Inject constructor(
    //#4 MainDataSource 주입
    private val mainDataSource: MainDataSource
) : MainRepository {

    override suspend fun checkLoveCalculator(
        remoteErrorEmitter: RemoteErrorEmitter,
        host: String,
        key: String,
        mName: String,
        wName: String
    ): DomainLoveReponse? {
        return MainMapper.loveMapper(mainDataSource.checkLoveCalculator(remoteErrorEmitter, host, key, mName, wName))
    // 처음 에러나는 경우 반환형이 Domain계증의 response인데 return값으로 Data계증의 Response를 줘서 오류가 남
        // 이럴때 mapper를 사용함. 쉽게 말해서 data계층의 response를 domain계증의 response로 변환해 줌.
    }

    override fun getStatistics(): Task<DataSnapshot> {
        return mainDataSource.getStatistics()
    }

    override fun setStatistics(plusValue: Int): Task<Void> {
        return mainDataSource.setStatistics(plusValue)
    }

    override fun getScore(): Task<QuerySnapshot> {
        return mainDataSource.getScore()
    }

    override fun setScore(score: DomainScore): Task<Void> {
        return mainDataSource.setScore(MainMapper.scoreMapper(score))
    }
}