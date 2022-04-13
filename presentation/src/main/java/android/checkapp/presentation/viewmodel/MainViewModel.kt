package android.checkapp.presentation.viewmodel

import android.checkapp.domain.model.DomainLoveReponse
import android.checkapp.domain.model.DomainScore
import android.checkapp.domain.usecase.*
import android.checkapp.domain.utils.ErrorType
import android.checkapp.domain.utils.RemoteErrorEmitter
import android.checkapp.domain.utils.ScreenState
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import android.checkapp.presentation.widget.utils.SingleLiveEvent
import javax.inject.Inject

// 의존성 주입이 사용된 viewModel에서는 HiltViewModel 어노테이션을 붙인다.
// MainActivity에서 사용하게될 viewModel 클래스
// #12
@HiltViewModel
class MainViewModel @Inject constructor(
    // UseCase 주입
    private val checkLoveCalculatorUseCase: CheckLoveCalculatorUseCase,
    // 주입  @Inject
    // RemoteErrorEmitter 상속
    private val setStatisticsUseCase: SetStaticticsUseCase,
    private val getStatisticsUseCase: GetStatisticsUseCase,
    private val setScoreUseCase: SetScoreUseCase,
    private val getScoreUseCase: GetScoreUseCase

): ViewModel(), RemoteErrorEmitter {

    val apiCalleEvent: LiveData<ScreenState> get() = _apiCallEvent
    private val _apiCallEvent = SingleLiveEvent<ScreenState>()

    val getStatisticsEvent: LiveData<Int> get() = _getStatisticsEvent
    private val _getStatisticsEvent = SingleLiveEvent<Int>()

    val getScoreEvent: LiveData<Int> get() = _getScoreEvent
    private val _getScoreEvent = SingleLiveEvent<Int>()

    var apiCallResult = DomainLoveReponse("","", 0, "")
    var apiErrorType = ErrorType.UNKNOWN
    var apiErrorMessage = "none"

    // 남자 이름과 여자이름을 담을 변수 선언
    var manNameResult = "man"
    var womanNameResult = "woman"
    val scoreList = arrayListOf<DomainScore>()


    // CoroutineScope
    // UseCase호출 부
    fun checkLoveCalculator( host: String,key : String, mName : String, wName : String ) = viewModelScope.launch {
        checkLoveCalculatorUseCase.execute(this@MainViewModel, host, key, mName, wName).let { response ->
            // 반환값이 null이 아니고 잘 받아져 왔을때
            if (response != null){
                apiCallResult = response
                _apiCallEvent.postValue(ScreenState.LOADING)
            }
            // 반환값이 null일 때
            else { _apiCallEvent.postValue(ScreenState.ERROR)

            }
        }
    }

    fun setStatistics(plusValue : Int) = setStatisticsUseCase.execute(plusValue)

    fun getStatistics() = getStatisticsUseCase.excute()

    fun getStaticticsDisplay() = getStatisticsUseCase.excute()
        .addOnSuccessListener {
            _getStatisticsEvent.postValue(it.value.toString().toInt())
        }

    fun getScore() = getScoreUseCase.execute()
        .addOnSuccessListener { snapshot ->
            scoreList.clear()
            for (item in snapshot.documents){
                item.toObject(DomainScore::class.java).let{
                    scoreList.add(it!!)
                }
            }
            _getScoreEvent.call()
        }

    fun setScore(man : String, woman : String, percentage : Int, date : String){
        setScoreUseCase.execute(DomainScore(man,woman,percentage,date))
    }


    // 호출 오류 발생 시 아래 onError함수 호출
    override fun onError(msg: String) {
        apiErrorMessage = msg
    }

    override fun onError(errorType: ErrorType) {
        apiErrorType = errorType
    }


}