package android.checkapp.presentation.view

import android.view.View
import android.checkapp.presentation.R
import android.checkapp.presentation.adapter.ScoreRecyclerViewAdapter
import android.checkapp.presentation.databinding.FragmentMainBinding
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import android.checkapp.presentation.base.BaseFragment
import android.checkapp.presentation.viewmodel.MainViewModel
import android.checkapp.presentation.widget.extension.showVertical
import com.pss.library.CountNumberEvent.Companion.countNumber

class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    private val mainViewModel by activityViewModels<MainViewModel>()

    //MainActivity와 마찬가지로 init에서 onCreateView와 DataBinding을 초기세팅하여 삭제처리함.
    override fun init() {
        // binding의 fragment가 잘 연결되었는지 확인
        binding.fragment = this
        observeViewModel()
        mainViewModel.getStaticticsDisplay()
        mainViewModel.getScore()
    }

    // private로 선언하면 안됨.
    fun startBtnClick(view: View){
        // 이제 버튼을 눌렀을때 startBtnClick 함수가 실행되고 다음화면으로 넘어가도록 함.
        this.findNavController().navigate(R.id.action_mainFragment_to_womanNameFragment)
    }

    private fun observeViewModel(){
        mainViewModel.getStatisticsEvent.observe(this){
            countNumber(0,it,binding.statistics, 2000)
//            binding.statistics.text = it.toString()
        }

        mainViewModel.getScoreEvent.observe(this){
            initRecyclerView()
        }
    }

    private fun initRecyclerView(){
        binding.scoreRecyclerView.adapter = ScoreRecyclerViewAdapter(mainViewModel)
        binding.scoreRecyclerView.showVertical(requireContext())
    }

}