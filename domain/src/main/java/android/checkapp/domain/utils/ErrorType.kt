package android.checkapp.domain.utils

// Api 호출 시 Error가 났을때 어떤 Error인지 확인하려는 Enum
// #1
enum class ErrorType {
    // 네트워크 문제
    NETWORK,
    // 요청 시간 초과
    TIMEOUT,
    // 세션 만료
    SESSION_EXPIRED,
    // 알수 없는 다른 문제
    UNKNOWN
}