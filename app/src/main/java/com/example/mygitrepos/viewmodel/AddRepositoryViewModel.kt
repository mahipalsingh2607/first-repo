package com.example.mygitrepos.viewmodel

import android.util.Log
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mygitrepos.model.GithubResponseItem
import com.example.mygitrepos.model.Repository
import com.example.mygitrepos.network.ApiClient
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import retrofit2.Response

class AddRepositoryViewModel :ViewModel(){
    val progress = ObservableBoolean(false)
    private val repoStatus = MutableLiveData<Boolean>()
    fun addRepository(token: String, repoName: String, ownerName: String) {
        progress.set(true)
        val response = ApiClient.apiService.createRepository(token, Repository(repoName), ownerName)
        response.observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : Observer<Response<ResponseBody>> {

                override fun onSubscribe(d: Disposable) {

                }


                override fun onNext(t: Response<ResponseBody>) {
                    Log.i("onNext", t.toString())
                    if(t.code() == 201){
                        repoStatus.postValue(true)
                    } else {
                        repoStatus.postValue(false)
                    }
                }


                override fun onError(e: Throwable) {
                    Log.i("onError", e.toString())
                    progress.set(false)
                    repoStatus.postValue(false)
                }


                override fun onComplete() {
                    progress.set(false)
                }

            })
    }
    fun onRepoData(): MutableLiveData<Boolean> {
        return repoStatus
    }
}