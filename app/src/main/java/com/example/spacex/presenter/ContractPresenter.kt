package com.example.spacex.presenter

interface ContractPresenter {
    fun getRepo(isActive: Boolean = false)
    fun getRepoActive()
    fun onDestroyCalled()
}