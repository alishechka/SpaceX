package com.example.spacex.presenter

import SpaceBaseListModel
import io.reactivex.Observable

interface RocketsRepository {
    fun getRocketsData(): Observable<List<SpaceBaseListModel>>
}