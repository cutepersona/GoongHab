package android.checkapp.data.remote.model

data class DataScore (
    // 남자이름
    val man : String,
    // 여자이름
    val woman : String,
    // 확율
    val percentage : Int,
    // 시간
    val date : String
){
    constructor(): this("오류","오류", 0, "오류")
}