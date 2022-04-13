package android.checkapp.data.repository.remote.datasourceimpl

import android.checkapp.data.remote.api.LoveCalculatorApi
import android.checkapp.data.remote.model.DataLoveReponse
import android.checkapp.data.remote.model.DataScore
import android.checkapp.data.repository.remote.datasource.MainDataSource
import android.checkapp.data.utils.base.BaseDataSource
import android.checkapp.domain.utils.RemoteErrorEmitter
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.QuerySnapshot
import javax.inject.Inject

// Interface의 MainDataSource의 구현체
// DI 사용 구현체 에서 API를 주입받고 BaseDataSource, MainDataSource를 상속 받는다.
// #5
class MainDataSourceImpl @Inject constructor(
    private val loveCalculatorApi: LoveCalculatorApi,
    private val firebastRtdb : FirebaseDatabase,
    private val firestore: FirebaseFirestore
) : BaseDataSource(), MainDataSource {

    override suspend fun checkLoveCalculator(
        remoteErrorEmitter: RemoteErrorEmitter,
        host: String,
        key: String,
        mName: String,
        wName: String
    ): DataLoveReponse? {
        return safeApiCall(remoteErrorEmitter){         // BaseDataSource()에서 safeApiCall 사용
            loveCalculatorApi.getPercentage(host = host, key = key, fName = mName, sName = wName)
            // api의 값을 받아 DataLoveResponse에 대입
            // 이후 Network모듈에서 api 주입하는 부분 확인
        }?.body()

    }

    // 통계 가져오기
    override fun getStatistics(): Task<DataSnapshot> {
        return firebastRtdb.reference.child("statistics").get()
    }

    override fun setStatistics(plusValue: Int): Task<Void> {
        return firebastRtdb.reference.child("statistics").setValue(plusValue)
    }

    override fun getScore(): Task<QuerySnapshot> {
        return firestore.collection("score").orderBy("date", Query.Direction.DESCENDING).get()
    }

    override fun setScore(score: DataScore): Task<Void> {
        return firestore.collection("score").document().set(score)
    }


}