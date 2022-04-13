package android.checkapp.presentation.adapter//package android.checkapp.presentation.adapter

import android.checkapp.domain.model.DomainScore
import android.checkapp.presentation.R
import android.checkapp.presentation.databinding.ScoreRecyclerItemBinding
import android.checkapp.presentation.viewmodel.MainViewModel
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView

class ScoreRecyclerViewAdapter(
    private val viewModel: MainViewModel
)  : RecyclerView.Adapter<ScoreRecyclerViewAdapter.ScoreRecyclerViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScoreRecyclerViewHolder {
        val layoutInfalter = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ScoreRecyclerItemBinding>(
            layoutInfalter
            ,R.layout.score_recycler_item
            ,parent
            ,false
        )
        return ScoreRecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ScoreRecyclerViewHolder, position: Int) {
        holder.bind(viewModel.scoreList[position])
    }

    override fun getItemCount(): Int {
        return viewModel.scoreList.size
    }

    inner class ScoreRecyclerViewHolder(val binding: ScoreRecyclerItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: DomainScore){
            binding.data = data
            binding.executePendingBindings()
        }
    }

}