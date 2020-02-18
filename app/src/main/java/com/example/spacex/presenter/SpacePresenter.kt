package com.example.spacex.presenter

import SpaceBaseListModel
import android.util.Log
import com.example.spacex.ContractView
import com.example.spacex.network.SpaceRetrofitClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class SpacePresenter(var view: ContractView?) :
    ContractPresenter {
    private val compositeDisposable = CompositeDisposable()
    private val client = SpaceRetrofitClient.spaceClient
    private val call = client.getSomeSpace()
    private val LOG = "PresenterClassX"


    override fun getRepo() {
        compositeDisposable.add(
            call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleSuccess, this::handleError)

        )

    }

    override fun getRepoActive() {
        compositeDisposable.add(
            call.subscribeOn(Schedulers.io())
                .map { i ->
                    i.filter { i -> i.active }
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleSuccess, this::handleError)

        )

    }

    private fun handleSuccess(spaceModel: List<SpaceBaseListModel>) {
        view?.showRepo(spaceModel)
    }

    private fun handleError(t: Throwable) {
        Log.i(LOG, t.localizedMessage)
        view?.showError(t)
    }

    override fun onDestroyCalled() {
        view = null
    }
}