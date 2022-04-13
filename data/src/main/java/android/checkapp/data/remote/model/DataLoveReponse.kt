package android.checkapp.data.remote.model

// Api 반환값을 받기 위한 dataClass    반환 파라미터의 변수명과 똑같아야함!!!
data class DataLoveReponse (
    val fname: String,
    val sname : String,
    val percentage : Int,
    val result: String
)