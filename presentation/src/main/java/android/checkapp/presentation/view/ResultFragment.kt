package android.checkapp.presentation.view

import android.view.View
import android.checkapp.presentation.R
import android.checkapp.presentation.databinding.FragmentResultBinding
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import android.checkapp.presentation.base.BaseFragment
import android.checkapp.presentation.viewmodel.MainViewModel
import java.text.SimpleDateFormat
import java.util.*

class ResultFragment : BaseFragment<FragmentResultBinding>(R.layout.fragment_result) {

    private val mainViewModel by activityViewModels<MainViewModel>()

    override fun init() {
        binding.fragment = this
        initResult()
        saveScore()
    }

    // api로 호출받은 결과값 바인딩
    private fun initResult(){
        binding.score.text = mainViewModel.apiCallResult.percentage.toString()
        when(mainViewModel.apiCallResult.percentage){
            in 0..20 -> setLoveMsgTxt("조금 힘들어 보여요")
            in 21..40 -> setLoveMsgTxt("노력해 보세요")
            in 41..70 -> setLoveMsgTxt("기대해도 좋겠는데요?")
            in 71..90 -> setLoveMsgTxt("일단 축하드려요")
            in 91..99 -> setLoveMsgTxt("와우.. 눈을 의심하고 있어요")
            100 -> {
                saveStatistics()
                setLoveMsgTxt("완벽하네요! 축하드려요")
            }
            else -> setLoveMsgTxt("알수 없는 힘?!")
        }
    }


    private fun saveStatistics(){
        mainViewModel.getStatistics()
            .addOnSuccessListener{
                if (it != null){
                    mainViewModel.setStatistics(it.value.toString().toInt() + 1)
                        .addOnFailureListener {

                        }
                }
            }
    }

    private fun saveScore() = with(mainViewModel.apiCallResult){
        mainViewModel.setScore(this.fname, this.sname, this.percentage, nowTime())
    }

    private fun nowTime() : String = SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분", Locale("ko", "KR")).format(
        Date(System.currentTimeMillis())
    )

    private fun error() = shortShowToast("통계를 저장하는데 오류가 발생했습니다.")

    private fun setLoveMsgTxt(msg : String) = binding.message.setText(msg)

    // navigate로 다시 메인으로 이동하도록 함.
    fun backMainBtnClick(view: View){
        this.findNavController().navigate(R.id.action_resultFragment_to_mainFragment)
    }

}