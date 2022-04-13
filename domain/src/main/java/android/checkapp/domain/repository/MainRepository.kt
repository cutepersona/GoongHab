package android.checkapp.domain.repository

import android.checkapp.domain.model.DomainLoveReponse
import android.checkapp.domain.model.DomainScore
import android.checkapp.domain.utils.RemoteErrorEmitter
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.firestore.QuerySnapshot

// #7
interface MainRepository {
    suspend fun checkLoveCalculator(
        remoteErrorEmitter: RemoteErrorEmitter,
        host: String,
        key : String,
        // fName = 남자이름
        mName : String,
        // sName = 여자이름
        wName : String
    ) : DomainLoveReponse?
//    ) : DataLoveReponse?  // domain은 data계증에 대한 의존성을 가지고 있지 않아 data 모듈에서 만든 data class를 사용할 수 없음.
    // 똑같이 domain에도 data class를 만들어 줌.

    // 통계 가져오기
    fun getStatistics() : Task<DataSnapshot>

    // 통계 저장하기
    fun setStatistics(plusValue : Int) : Task<Void>

    // 전적 가져오기
    fun getScore() : Task<QuerySnapshot>

    // 전적 저장하기
    fun setScore(score : DomainScore) : Task<Void>

}