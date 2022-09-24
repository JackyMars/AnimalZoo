package com.example.taipeizoo.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.taipeizoo.databinding.RecyclerListRowBinding
import com.bumptech.glide.Glide
import com.example.taipeizoo.network.AnimalInfo


class AnimalListAdapter:RecyclerView.Adapter<AnimalListAdapter.ViewHolder>() {

    var animalListData = ArrayList<AnimalInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RecyclerListRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(animalListData[position])
    }

    override fun getItemCount(): Int {
        return  animalListData.size
    }

    inner class ViewHolder(binding: RecyclerListRowBinding):RecyclerView.ViewHolder(binding.root){

        val tvName:TextView = binding.tvName
        val tvLocation:TextView = binding.tvLocation
        val tvDistribution:TextView = binding.tvDistribution
        val ivPic01:ImageView = binding.ivPic01

        fun bind(data : AnimalInfo){
            tvName.text = data.a_name_ch
            tvLocation.text = data.a_location
            tvDistribution.text = data.a_distribution
            val url = data.a_pic01_url
            /** Glide基本語法
             * Glide.with(fragment)
                .load(url)
                .into(imageView);
             */
            Glide.with(ivPic01)
                .load(url)
                .circleCrop()
                .into(ivPic01)
        }
    }
}