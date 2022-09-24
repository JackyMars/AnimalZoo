package com.example.taipeizoo.viewmodel

import androidx.lifecycle.MutableLiveData
import io.reactivex.Observer
import androidx.lifecycle.ViewModel
import com.example.taipeizoo.network.ResultModel
import com.example.taipeizoo.network.RetroInstance
import com.example.taipeizoo.network.RetroService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainActivityViewModel:ViewModel() {
    lateinit var animailList:MutableLiveData<ResultModel>
    init {
        animailList = MutableLiveData()
    }

    fun getAnimalListObserver():MutableLiveData<ResultModel>{
        return animailList
    }

    fun makeApiCall(scope:String){

        val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
        retroInstance.getAnimalListFromApi(scope)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(getAnimailListObserverRx())

    }

    private fun getAnimailListObserverRx():Observer<ResultModel>{
        return object :Observer<ResultModel>{
            override fun onSubscribe(d: Disposable) {
                //start showing progress indicator.
            }

            override fun onNext(t: ResultModel) {
                animailList.postValue(t)
            }

            override fun onError(e: Throwable) {
                animailList.postValue(null)
            }

            override fun onComplete() {
                //hide progress indicator .
            }

        }
    }
}