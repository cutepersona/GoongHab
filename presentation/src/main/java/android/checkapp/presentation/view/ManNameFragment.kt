package android.checkapp.presentation.view

import android.checkapp.domain.utils.ErrorType
import android.checkapp.domain.utils.ScreenState
import android.view.View
import android.checkapp.presentation.R
import android.checkapp.presentation.databinding.FragmentManNameBinding
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import android.checkapp.presentation.base.BaseFragment
import android.checkapp.presentation.viewmodel.MainViewModel

class ManNameFragment : BaseFragment<FragmentManNameBinding>(R.layout.fragment_man_name) {

    private val mainViewModel by activityViewModels<MainViewModel>()

    override fun init() {
        binding.fragment = this
        observeViewModel()
    }

    fun nextBtnClick(view: View) {
        binding.loadingBar.visibility = View.VISIBLE
        mainViewModel.checkLoveCalculator(
            "love-calculator.p.rapidapi.com",
            "d72e98dd8dmshe63076931bd657ep18bacbjsned136a88dc58",
            binding.nameEditTxt.text.toString(),
            mainViewModel.womanNameResult
        )
    }

    private fun observeViewModel(){
        // MainViewModel에 livedata를 observe로 관찰해 API가 정상적으로 호출되면 결과 화면으로 넘어가도록 함.
        mainViewModel.apiCalleEvent.observe(this){
            binding.loadingBar.visibility = View.INVISIBLE
            when(it){
                ScreenState.LOADING -> this.findNavController().navigate(R.id.action_manNameFragment_to_resultFragment)
                ScreenState.ERROR -> toastErrorMsg()
                else -> shortShowToast("알수없는 오류가 발생했습니다.")
            }
        }
    }

    private fun toastErrorMsg(){
        when(mainViewModel.apiErrorType){
            ErrorType.NETWORK -> longShowToast("네트워크 오류가 발생했습니다.")
            ErrorType.SESSION_EXPIRED ->  longShowToast("세션이 만료되었습니다.")
            ErrorType.TIMEOUT ->  longShowToast("호출 시간이 초과되었습니다.")
            ErrorType.UNKNOWN -> longShowToast("얘기치 못한 오류가 발생했습니다.")
        }
    }

}