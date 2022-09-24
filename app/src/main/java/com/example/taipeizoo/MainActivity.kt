package com.example.taipeizoo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.taipeizoo.databinding.ActivityMainBinding
import com.example.taipeizoo.adapter.AnimalListAdapter
import com.example.taipeizoo.network.ResultModel
import com.example.taipeizoo.viewmodel.MainActivityViewModel
import androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL


class MainActivity : AppCompatActivity() {
    lateinit var viewModel:MainActivityViewModel
    lateinit var animalListAdapter: AnimalListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadAPIData()
        initRecycleView(binding)
    }



    fun initRecycleView(binding:ActivityMainBinding){
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            val decoration = DividerItemDecoration(applicationContext, VERTICAL)
            addItemDecoration(decoration)
            animalListAdapter = AnimalListAdapter()
            adapter = animalListAdapter
        }
    }
    fun loadAPIData(){
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getAnimalListObserver().observe(this,Observer<ResultModel>{
            if(it != null){
                //update adapter...
                animalListAdapter.animalListData = it.result.results
                animalListAdapter.notifyDataSetChanged()
            }else{
                Toast.makeText(this, "Error in fetching data", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.makeApiCall("resourceAquire")
    }


}