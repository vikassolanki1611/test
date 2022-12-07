package com.testapplication.ui.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.post_api.ApiHttpCLient
import com.example.post_api.ApiInterface
import com.example.roomclass.data.Data
import com.example.roomclass.data.dataBase
import com.example.roomclass.data.userRepo
import com.testapplication.ui.main.dataClass.testData
import com.testapplication.ui.main.dataClass.testDataItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(application: Application) : AndroidViewModel(application) {
    val apiInterface: ApiInterface?= ApiHttpCLient().getClient()!!.create(ApiInterface::class.java)

    private val readalldata: LiveData<List<Data>>
    private val repository: userRepo

    init {
        val userDao = dataBase.getDataBase(application).userDao()
        repository = userRepo(userDao)
        readalldata = repository.readaAllData

    }

        fun insertallData(data: List<Data>) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertallData(data)
        }



    }
    fun getalldata(): LiveData<List<Data>> {
        return readalldata
    }







    fun getAPIdata() {
        var Gettradecall = apiInterface!!.getData()
        Gettradecall.enqueue(object : Callback<testData?> {
            override fun onFailure(call: Call<testData?>, t: Throwable) {
            }

            override fun onResponse(call: Call<testData?>, response: Response<testData?>) {
              //  Log.d("response",response.body()!!.toString())

                val resultsItemList = response.body()!! as List<Data>
                insertallData(resultsItemList)
            }
        }) }
}