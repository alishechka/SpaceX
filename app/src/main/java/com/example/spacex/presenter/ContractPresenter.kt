package com.example.spacex.presenter

interface ContractPresenter {
    fun getRepo(isActive: Boolean = false)
    fun onDestroyCalled()
}