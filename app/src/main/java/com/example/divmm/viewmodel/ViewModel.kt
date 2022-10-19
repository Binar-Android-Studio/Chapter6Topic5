package com.example.divmm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.divmm.model.responseProductItem
import com.example.divmm.network.RestfullAPI
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(var api : RestfullAPI) : ViewModel(){

    lateinit var liveDataCar: MutableLiveData<List<responseProductItem>>


    init {
        liveDataCar = MutableLiveData()
    }

    fun getliveDataCar() : MutableLiveData<List<responseProductItem>> {
        return  liveDataCar
    }

    fun callApiCar(){
        api.getAllCar().enqueue(object : Callback<List<responseProductItem>> {
            override fun onResponse(
                call: Call<List<responseProductItem>>,
                response: Response<List<responseProductItem>>
            ) {
                if (response.isSuccessful){
                    liveDataCar.postValue(response.body())
                }else{
                    liveDataCar.postValue(null)
                }
            }

            override fun onFailure(call: Call<List<responseProductItem>>, t: Throwable) {
                liveDataCar.postValue(null)
            }

        })
    }

}