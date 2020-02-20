package com.example.spacex.presenter

import SpaceBaseListModel
import com.example.spacex.network.SpaceRetrofitClient
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RocketRepositoryImpl : RocketsRepository {
    private val client = SpaceRetrofitClient.instTest
    private val call = client.getSomeSpace()

    override fun getRocketsData(): Observable<List<SpaceBaseListModel>> {
        return call.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}