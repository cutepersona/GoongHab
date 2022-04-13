package android.checkapp.domain.utils

//API 호출 Error시 에러 메시지와 타입을 가지는 인터페이스 생성    Domain.Utils에 넣어준다
// #3
interface RemoteErrorEmitter {
    fun onError(msg:String)
    fun onError(errorType: ErrorType)
}