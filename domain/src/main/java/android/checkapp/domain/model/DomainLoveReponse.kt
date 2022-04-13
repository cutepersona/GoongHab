package android.checkapp.domain.model

// Api 반환값을 받기 위한 dataClass
// #8
// domain은 data계증에 대한 의존성을 가지고 있지 않아 data 모듈에서 만든 data class를 사용할 수 없음.
// 똑같이 domain에도 data class를 만들어 줌.
class DomainLoveReponse (
    val fname: String,
    val sname : String,
    val percentage : Int,
    val result: String
)