package android.checkapp.domain.utils

// Api 통신 후 결과를 표시하는 Enum 클래스    일반적으로 domain.utils 패키지에 넣는다.
// #2
enum class ScreenState {
    // api 호출 로딩이 정상적으로 완료 되었을때
    LOADING,

    // api 호출 도중 에러가 발생했을때
    ERROR
}