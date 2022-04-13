package android.checkapp.data.remote.api

import android.checkapp.data.remote.model.DataLoveReponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

//Retrofit을 사용하기 위한 인터페이스 생성
// 네트워크 모듈파일에 이미 주입할 내용이 만들어져 있음.  MainDataSourceImpl구현체의 생성자에 주입
interface LoveCalculatorApi {
    // API에서 문서 요청 형태가 GET이므로 @GET 어노테이션 사용
    @GET("/getPercentage")   // BASE_URL 뒤의 end_url을 붙인다.
    suspend fun getPercentage(
        @Header("X-RapidAPI-Key") key : String, // 문서에 있는 Headers부분 추가
        @Header("X-RapidAPI-Host") host : String,
        @Query("fname") fName : String,         // 문서에 있는 parameter부분 추가
        @Query("sname") sName : String
    ) : Response<DataLoveReponse>
}