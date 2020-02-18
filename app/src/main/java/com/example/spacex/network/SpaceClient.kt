package com.example.spacex.network

import SpaceBaseListModel
import com.example.spacex.misc.ENDPOINT
import io.reactivex.Observable
import retrofit2.http.GET

interface SpaceClient {
    @GET(ENDPOINT)
    fun getSomeSpace(): Observable<List<SpaceBaseListModel>>
}