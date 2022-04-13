package android.checkapp.data.repository.remote.datasource

import android.checkapp.data.remote.model.DataLoveReponse
import android.checkapp.data.remote.model.DataScore
import android.checkapp.domain.utils.RemoteErrorEmitter
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.firestore.QuerySnapshot

// #4
interface MainDataSource {
    // 생성자로 에러 타입등을 알려주는 인터페이스와 API 호출에 필요한 값들을 받는다.
    // 궁합 Api 호출
    suspend fun checkLoveCalculator(
        remoteErrorEmitter: RemoteErrorEmitter,
        host: String,
        key : String,
        // fName = 남자이름
        mName : String,
        // sName = 여자이름
        wName : String
    ) : DataLoveReponse?    // 반환형 DataLoveReponse 를 반환


    // 통계 가져오기
    fun getStatistics() : Task<DataSnapshot>

    // 통계 저장하기
    fun setStatistics(plusValue : Int) : Task<Void>

    // 전적 가져오기
    fun getScore() : Task<QuerySnapshot>

    // 전적 저장하기
    fun setScore(score : DataScore) : Task<Void>


}