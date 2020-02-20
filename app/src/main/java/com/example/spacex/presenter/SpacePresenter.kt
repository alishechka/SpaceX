package com.example.spacex.presenter

import SpaceBaseListModel
import android.util.Log
import com.example.spacex.ContractView
import io.reactivex.disposables.CompositeDisposable

class SpacePresenter(var view: ContractView?,
                     var repository:RocketsRepository) :
    ContractPresenter {
    private val compositeDisposable = CompositeDisposable()
    private val LOG = "PresenterClassX"


    override fun getRepo(isActive: Boolean) {
        view?.showLoading()
        compositeDisposable.add(
            repository.getRocketsData() //.getRockets does subscribeOn and observeOn
                .map { i ->
                    if (isActive) {
                        i.filter { i -> i.active }
                    } else {
                        i
                    }
                }
                .subscribe(this::handleSuccess, this::handleError)
        )
    }

    private fun handleSuccess(spaceModel: List<SpaceBaseListModel>) {
        view?.showRepo(spaceModel)
        view?.hideLoading()

    }

    private fun handleError(t: Throwable) {
//        Log.i(LOG, t.localizedMessage)
        view?.showLoading()
        view?.showError(t)

    }

    override fun onDestroyCalled() {
        view = null
    }
}