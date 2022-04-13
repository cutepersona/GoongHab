package android.checkapp.presentation.view

import android.view.View
import android.checkapp.presentation.R
import android.checkapp.presentation.databinding.FragmentWomanNameBinding
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import android.checkapp.presentation.base.BaseFragment
import android.checkapp.presentation.viewmodel.MainViewModel

class WomanNameFragment : BaseFragment<FragmentWomanNameBinding>(R.layout.fragment_woman_name) {

    private val mainViewModel by activityViewModels<MainViewModel>()

    override fun init() {
        binding.fragment = this
    }

    fun nextBtnClick(view: View){
        mainViewModel.womanNameResult = binding.nameEditTxt.text.toString()
        this.findNavController().navigate(R.id.action_womanNameFragment_to_manNameFragment)
    }


}