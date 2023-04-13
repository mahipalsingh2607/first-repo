package com.example.mygitrepos.viewmodel

import android.util.Log
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mygitrepos.Utility.Constants
import com.example.mygitrepos.model.GithubResponse
import com.example.mygitrepos.model.GithubResponseItem
import com.example.mygitrepos.network.ApiClient
import com.google.gson.Gson
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Response

class MainViewModel() : ViewModel() {
    val progress = ObservableBoolean(false)
    private val repoData = MutableLiveData<ArrayList<GithubResponseItem>>()
    fun getAllRepositories(username: String) {
        progress.set(true)
        val response = ApiClient.apiService.getUserRepositories(username)
        response.observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : Observer<Response<ResponseBody>> {

                override fun onSubscribe(d: Disposable) {

                }


                override fun onNext(t: Response<ResponseBody>) {
                    Log.i("onNext", t.toString())
                    val res =
                        Gson().fromJson(t.body()!!.string(), Array<GithubResponseItem>::class.java)
                    val list = ArrayList<GithubResponseItem>()
                    for (item in res) {
                        list.add(item)
                    }
                    repoData.postValue(list)
                }


                override fun onError(e: Throwable) {
                    Log.i("onError", e.toString())
                    progress.set(false)
                }


                override fun onComplete() {
                    progress.set(false)
                }

            })
    }

    fun onRepoData(): MutableLiveData<ArrayList<GithubResponseItem>> {
        return repoData
    }
}